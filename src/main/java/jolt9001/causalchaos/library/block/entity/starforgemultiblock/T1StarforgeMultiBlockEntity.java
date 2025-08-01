package jolt9001.causalchaos.library.block.entity.starforgemultiblock;

import jolt9001.causalchaos.init.CCBlockEntities;
import jolt9001.causalchaos.init.CCMultiblockEntities;
import jolt9001.causalchaos.library.recipe.recipes.StarforgeMultiblockRecipe;
import jolt9001.causalchaos.library.screen.StarforgeMultiblockMenu;
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

public class T1StarforgeMultiBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(11) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private static final int[] INPUT_SLOTS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 18, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47};
    // private static final int FUEL_SLOT =  9;
    private static final int RESULT_SLOT = 48;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public T1StarforgeMultiBlockEntity(BlockPos pos, BlockState state){
        super(CCMultiblockEntities.T1_STARFORGE_MBE.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> T1StarforgeMultiBlockEntity.this.progress;
                    case 1 -> T1StarforgeMultiBlockEntity.this.maxProgress;
                    default ->  0;
                };
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> T1StarforgeMultiBlockEntity.this.progress = value;
                    case 1 -> T1StarforgeMultiBlockEntity.this.maxProgress = value;
                }
            }
            @Override
            public int getCount() {
                return 2;
            }
        };
    }

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
        return Component.translatable("block.causalchaos.starforge1");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putInt("t1_starforge.progress", progress);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        progress = tag.getInt("t1_starforge.progress");
    }


    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInv, Player player) {
        return new StarforgeMultiblockMenu(containerId, playerInv, this, this.data);
    }

    public void tick(Level level1, BlockPos pos, BlockState state1) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(level1, pos, state1);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            } else {
                resetProgress();
            }
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<RecipeHolder<StarforgeMultiblockRecipe>> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().value().getResultItem(null);
        for (int i = 0; i <= 47; i++) {
            this.itemHandler.extractItem(INPUT_SLOTS[i], 1, false);
        }
        this.itemHandler.setStackInSlot(RESULT_SLOT, new ItemStack(result.getItem(), this.itemHandler.getStackInSlot(RESULT_SLOT).getCount() + result.getCount()));
        // this.itemHandler.setStackInSlot(FUEL_SLOT, new ItemStack(result.getItem()));
    }

    private boolean hasRecipe() {
        Optional<RecipeHolder<StarforgeMultiblockRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()) {
            return false;
        }
        ItemStack result = recipe.get().value().getResultItem(getLevel().registryAccess());
        return canInsertAmountIntoOutputSlot(result.getCount()) && (canInsertItemIntoOutputSlot(result.getItem()));
    }

    private Optional<RecipeHolder<StarforgeMultiblockRecipe>> getCurrentRecipe() {
        SimpleContainer inv = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        return this.level.getRecipeManager().getRecipeFor(StarforgeMultiblockRecipe.Type.INSTANCE, inv, level);
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
