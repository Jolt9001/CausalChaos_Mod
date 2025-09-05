package jolt9001.causalchaos.library.block.entity.starforgealone;

import jolt9001.causalchaos.common.datagen.tags.ItemTagGenerator;
import jolt9001.causalchaos.init.CCBlockEntities;
import jolt9001.causalchaos.init.CCBlocks;
import jolt9001.causalchaos.init.CCItems;
import jolt9001.causalchaos.library.recipe.recipes.StarforgeAloneRecipe;
import jolt9001.causalchaos.library.screen.StarforgeAloneMenu;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class T0StarforgeBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(11) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private static final int[] INPUT_SLOTS = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    // TODO: require Anthracite (item or block) via tag causalchaos:starforge_fuel; burn timer litTime/litDuration; progress only while lit.
    // TODO: Never overwrite fuel with the result. Append to result stack if same item/tags and within max size.
    private static final int FUEL_SLOT =  9;
    private static final int RESULT_SLOT = 10;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;
    private int litTime;
    private int litDuration;

    public T0StarforgeBlockEntity(BlockPos pos, BlockState state){
        super(CCBlockEntities.T0_STARFORGE_BE.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> T0StarforgeBlockEntity.this.progress;
                    case 1 -> T0StarforgeBlockEntity.this.maxProgress;
                    case 2 -> T0StarforgeBlockEntity.this.litTime;
                    case 3 -> T0StarforgeBlockEntity.this.litDuration;
                    default ->  0;
                };
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> T0StarforgeBlockEntity.this.progress = value;
                    case 1 -> T0StarforgeBlockEntity.this.maxProgress = value;
                    case 2 -> T0StarforgeBlockEntity.this.litTime = value;
                    case 3 -> T0StarforgeBlockEntity.this.litDuration = value;
                }
            }
            @Override
            public int getCount() {
                return 4;
            } // getCount() should be 4 (progress, maxProgress, litTime, litDuration).
        };
    }

    // TODO: Guard slots: reject non-fuel into FUEL_SLOT, reject inserts into RESULT_SLOT.
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.causalchaos.starforge0");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        return new StarforgeAloneMenu(containerId, playerInv, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("t0_starforge.progress", progress);
        tag.putInt("LitTime", litTime);
        tag.putInt("LitDuration", litDuration);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.itemHandler.deserializeNBT(tag.getCompound("inventory"));
        this.progress = tag.getInt("t0_starforge.progress");
        this.litTime = tag.getInt("LitTime");
        this.litDuration = tag.getInt("LitDuration");
    }

    // TODO: Persist everything it will tick on: progress, maxProgress (if dynamic), litTime, litDuration, inventory.
    public void tick(Level level1, BlockPos pos, BlockState state1) {
        if (level1.isClientSide()) return;
        if (hasRecipe()) {
            if (!isLit()) {
                // Attempt to light with anthracite
                if (!tryConsumeFuel()) {
                    resetProgress();
                    return; // no fuel, no craft
                }
            }
            this.litTime = Math.max(0, this.litTime - 1);

            increaseCraftingProgress();
            setChanged(level1, pos, state1);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private boolean isFuel(ItemStack stack) {
        return stack.is(ItemTagGenerator.STARFORGE_FUEL);
    }
    private int getFuelBurnTime(ItemStack stack) {
        // Tweak to taste (coal = 1600). Make anthracite spicy.
        if (stack.is(CCItems.ANTHRACITE.get())) return 3200;                  // 160 seconds @20tps
        if (stack.is(CCBlocks.ANTHRACITE_BLOCK.get().asItem())) return 32000; // 1600 seconds
        return 0;
    }

    private boolean tryConsumeFuel() {
        ItemStack fuel = itemHandler.getStackInSlot(FUEL_SLOT);
        if (fuel.isEmpty() || !isFuel(fuel)) return false;

        int burn = getFuelBurnTime(fuel);
        if (burn <= 0) return false;

        // consume ONE fuel
        fuel.shrink(1);
        itemHandler.setStackInSlot(FUEL_SLOT, fuel); // writes back after shrink
        this.litTime = burn;
        this.litDuration = burn; // remember full duration for UI
        setChanged();
        return true;
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<RecipeHolder<StarforgeAloneRecipe>> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().value().getResultItem(null);
        for (int i = 0; i <= 8; i++) {
            this.itemHandler.extractItem(INPUT_SLOTS[i], 1, false);
        }
        this.itemHandler.setStackInSlot(RESULT_SLOT, new ItemStack(result.getItem(), this.itemHandler.getStackInSlot(RESULT_SLOT).getCount() + result.getCount()));
        this.itemHandler.setStackInSlot(FUEL_SLOT, new ItemStack(result.getItem()));
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<StarforgeAloneRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }
        ItemStack result = recipe.get().value().getResultItem(getLevel().registryAccess());
        return canInsertAmountIntoOutputSlot(result.getCount()) && (canInsertItemIntoOutputSlot(result.getItem()));
    }

    private Optional<RecipeHolder<StarforgeAloneRecipe>> getCurrentRecipe() {
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        return this.level.getRecipeManager().getRecipeFor(StarforgeAloneRecipe.Type.INSTANCE, inv, level);
    }
    public boolean isLit() {
        return this.litTime > 0;
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(RESULT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(RESULT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(RESULT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(RESULT_SLOT).getMaxStackSize();
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}
