package jolt9001.causalchaos.library.block.entity;

import jolt9001.causalchaos.library.recipe.recipes.StarforgeAloneRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public abstract class StarforgeBEBase extends BlockEntity implements MenuProvider {
    // ---- Inventory ----
    protected final ItemStackHandler itemHandler = new ItemStackHandler(11) {
        @Override protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_ALL);
            }
        }
    };
    protected LazyOptional<IItemHandler> lazyInv = LazyOptional.empty();

    // ---- Slots ----
    protected static final int[] INPUT_SLOTS = {0,1,2,3,4,5,6,7,8};
    protected static final int FUEL_SLOT = 9;
    protected static final int RESULT_SLOT = 10;

    // ---- Data slots (DO NOT report 11 here; you only expose 4 ints) ----
    protected final ContainerData data = new ContainerData() {
        @Override public int get(int i) {
            return switch (i) {
                case 0 -> progress;
                case 1 -> maxProgress;
                case 2 -> litTime;
                case 3 -> litDuration;
                default -> 0;
            };
        }
        @Override public void set(int i, int v) {
            switch (i) {
                case 0 -> progress = v;
                case 1 -> maxProgress = v;
                case 2 -> litTime = v;
                case 3 -> litDuration = v;
            }
        }
        @Override public int getCount() { return 4; } // ← fix
    };

    // ---- Processing state ----
    protected int progress = 0;
    protected int maxProgress = 78;
    protected int litTime = 0;
    protected int litDuration = 0;

    protected StarforgeBEBase(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    // ---- Tier & mode hooks (child classes implement) ----
    public abstract int getTier();                // 0..3
    public abstract boolean isMultiblockMode();   // false for “alone”, true for multiblock
    protected abstract AbstractContainerMenu makeMenu(int id, Inventory inv);

    // Optional: display name per tier or from block’s description id
    @Override public Component getDisplayName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    // ---- Capability plumbing ----
    @Override public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) return lazyInv.cast();
        return super.getCapability(cap, side);
    }
    @Override public void onLoad() {
        super.onLoad();
        lazyInv = LazyOptional.of(() -> itemHandler);
    }
    @Override public void invalidateCaps() {
        super.invalidateCaps();
        lazyInv.invalidate();
    }

    // ---- Menu ----
    @Nullable
    @Override public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        return makeMenu(containerId, playerInv);
    }

    // ---- Drops ----
    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) inv.setItem(i, itemHandler.getStackInSlot(i));
        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    // ---- Save/Load (fix: save and load both LitDuration) ----
    private static final String TAG_INV = "Inventory";
    private static final String TAG_PROGRESS = "Progress";
    private static final String TAG_LIT = "LitTime";
    private static final String TAG_LIT_DUR = "LitDuration";

    @Override protected void saveAdditional(CompoundTag tag) {
        tag.put(TAG_INV, itemHandler.serializeNBT());
        tag.putInt(TAG_PROGRESS, progress);
        tag.putInt(TAG_LIT, litTime);
        tag.putInt(TAG_LIT_DUR, litDuration); // ← you were loading this but not saving it
        super.saveAdditional(tag);
    }
    @Override public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound(TAG_INV));
        progress = tag.getInt(TAG_PROGRESS);
        litTime = tag.getInt(TAG_LIT);
        litDuration = tag.getInt(TAG_LIT_DUR);
    }

    // ---- Net sync ----
    @Nullable @Override public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    @Override public CompoundTag getUpdateTag() { return saveWithoutMetadata(); }

    // ---- Processing API ----
    public boolean isLit() { return this.litTime > 0; }

    protected void resetProgress() { progress = 0; }
    protected boolean hasProgressFinished() { return progress >= maxProgress; }
    protected void increaseProgress() { progress++; }

    // ---- Recipe hooks (alone vs multiblock can override) ----
    protected Optional<RecipeHolder<StarforgeAloneRecipe>> getCurrentAloneRecipe() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) inv.setItem(i, itemHandler.getStackInSlot(i));
        return this.level.getRecipeManager().getRecipeFor(StarforgeAloneRecipe.Type.INSTANCE, inv, level);
    }
    protected boolean canInsertItemIntoOutputSlot(Item item) {
        ItemStack out = itemHandler.getStackInSlot(RESULT_SLOT);
        return out.isEmpty() || out.is(item);
    }
    protected boolean canInsertAmountIntoOutputSlot(int count) {
        ItemStack out = itemHandler.getStackInSlot(RESULT_SLOT);
        return out.getCount() + count <= out.getMaxStackSize();
    }

    // ---- Standalone tick (multiblock variant can override) ----
    public void serverTickStandalone() {
        if (level == null || level.isClientSide()) return;

        Optional<RecipeHolder<StarforgeAloneRecipe>> recipe = getCurrentAloneRecipe();
        if (recipe.isEmpty()) { resetProgress(); return; }

        ItemStack result = recipe.get().value().getResultItem(level.registryAccess());
        if (!(canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem()))) {
            resetProgress(); return;
        }

        // TODO: handle fuel consumption properly (see Bug #2 notes)
        increaseProgress();
        setChanged(level, worldPosition, getBlockState());

        if (hasProgressFinished()) {
            // consume inputs
            for (int slot : INPUT_SLOTS) itemHandler.extractItem(slot, 1, false);
            // output
            ItemStack out = itemHandler.getStackInSlot(RESULT_SLOT);
            itemHandler.setStackInSlot(RESULT_SLOT, new ItemStack(result.getItem(), out.getCount() + result.getCount()));
            // (do NOT overwrite fuel slot with result—see Bug #2)
            resetProgress();
        }
    }
}
