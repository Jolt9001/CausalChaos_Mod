package jolt9001.causalchaos.library.block.entity;

import jolt9001.causalchaos.init.CCBlockEntities;
import jolt9001.causalchaos.init.CCRecipes;
import jolt9001.causalchaos.library.block.starforge.StarforgeBlock;
import jolt9001.causalchaos.library.recipe.recipes.StarforgeAloneRecipe;
import jolt9001.causalchaos.library.screen.StarforgeAloneMenu;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public final class StarforgeBEBase extends BlockEntity implements MenuProvider {
    private final StarforgeTier tier;
    private boolean inStructure;

    // ---- Inventory ----
    private final ItemStackHandler items = new ItemStackHandler( /* 51 if you keep fuel, else 50 */ ) {
        @Override protected void onContentsChanged(int slot){ setChanged(); }
    };
    private LazyOptional<IItemHandler> lazyInv = LazyOptional.empty();

    // ---- Slots ----
    private static final int MAX_INPUTS = 49;
    private static final int RESULT_SLOT = 49; // after inputs
    private static final int FUEL_SLOT = 50; // Fuel slot for when alone

    // ---- Data slots ----
    private final ContainerData data = new ContainerData() {
        @Override
        public int get(int idx){
            return switch(idx){
                case 0 -> progress;
                case 1 -> maxProgress;
                case 2 -> litTime;
                case 3 -> litDuration;
                default -> 0;
            };
        }
        @Override
        public void set(int idx, int val) {
            switch(idx) {
                case 0 -> progress = val;
                case 1 -> maxProgress = val;
                case 2 -> litTime = val;
                case 3 -> litDuration = val;
            }
        }
        @Override
        public int getCount() {
            return 4;
        }
    };

    // ---- Processing state ----
    private int progress = 0;
    private int maxProgress = 78;
    private int litTime = 0;
    private int litDuration = 0;

    private StarforgeBEBase(BlockPos pos, BlockState state, StarforgeTier tier){
        super(CCBlockEntities.STARFORGE_BE.get(), pos, state); // This will remain an error for now
        this.tier = tier;
        this.inStructure = state.getValue(StarforgeBlock.IN_STRUCTURE);
    }

    // ---- Multiblock checks ----
    public boolean getInStructure() {
        return inStructure;
    }
    public void setInStructure(boolean v) {
        if(this.inStructure != v){
            this.inStructure = v;
            // keep BlockState in sync with BE
            level.setBlock(worldPosition, getBlockState().setValue(StarforgeBlock.IN_STRUCTURE, v), 3);
            setChanged();
        }
    }

    // ---- Layout helpers ----
    private int inputCount(){ return inStructure ? 49 : 9; }
    private IntStream inputSlots(){ return IntStream.range(0, inputCount()); }
    private int resultSlot(){ return inStructure ? 49 : 10; }   // if 3x3 uses fuel=9, result=10
    private OptionalInt fuelSlot(){
        return (!inStructure) ? OptionalInt.of(9) : OptionalInt.empty();
    }

    // Optional: display name per tier or from block’s description id
    @Override public Component getDisplayName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    // ---- Capability plumbing ----
    @Override public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) return lazyInv.cast();
        return super.getCapability(cap, side);
    }
    @Override
    public void onLoad() {
        super.onLoad();
        lazyInv = LazyOptional.of(() -> items);
    }
    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyInv.invalidate();
    }

    // ---- Drops ----
    public void drops() {
        SimpleContainer inv = new SimpleContainer(items.getSlots());
        for (int i = 0; i < items.getSlots(); i++) inv.setItem(i, items.getStackInSlot(i));
        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    // ---- Save/Load (fix: save and load both LitDuration) ----
    private static final String TAG_INV = "Inventory";
    private static final String TAG_PROGRESS = "Progress";
    private static final String TAG_LIT = "LitTime";
    private static final String TAG_LIT_DUR = "LitDuration";

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put(TAG_INV, items.serializeNBT());
        tag.putInt(TAG_PROGRESS, progress);
        tag.putInt(TAG_LIT, litTime);
        tag.putInt(TAG_LIT_DUR, litDuration); // ← you were loading this but not saving it
        super.saveAdditional(tag);
    }
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        items.deserializeNBT(tag.getCompound(TAG_INV));
        progress = tag.getInt(TAG_PROGRESS);
        litTime = tag.getInt(TAG_LIT);
        litDuration = tag.getInt(TAG_LIT_DUR);
    }

    // ---- Net sync ----
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    @Override public CompoundTag getUpdateTag() { return saveWithoutMetadata(); }

    // ---- Processing API ----
    public boolean isLit() { return this.litTime > 0; }

    private void resetProgress() { progress = 0; }
    private boolean hasProgressFinished() { return progress >= maxProgress; }
    private void increaseProgress() { progress++; }

    // ---- Recipe hooks (alone vs multiblock can override) ----
    private Optional<RecipeHolder<StarforgeAloneRecipe>> getCurrentAloneRecipe() {
        SimpleContainer inv = new SimpleContainer(items.getSlots());
        for (int i = 0; i < items.getSlots(); i++) inv.setItem(i, items.getStackInSlot(i));
        return this.level.getRecipeManager().getRecipeFor(StarforgeAloneRecipe.Type.INSTANCE, inv, level);
    }
    private boolean canInsertItemIntoOutputSlot(Item item) {
        ItemStack out = items.getStackInSlot(RESULT_SLOT);
        return out.isEmpty() || out.is(item);
    }
    private boolean canInsertAmountIntoOutputSlot(int count) {
        ItemStack out = items.getStackInSlot(RESULT_SLOT);
        return out.getCount() + count <= out.getMaxStackSize();
    }

    // ---- Standalone tick (multiblock variant can override) ----
    public static void serverTick(Level lvl, BlockPos pos, BlockState st, StarforgeBEBase be){
        if(lvl.getGameTime() % 20 == 0) { // throttle to 1/s or trigger via neighbor updates
            boolean valid = SFMultiblock.check(lvl, pos, be.tier, st.getValue(StarforgeBlock.FACING));
            be.setInStructure(valid);
        }

        if(be.hasRecipe()){
            be.progress++;
            if(be.progress >= be.maxProgress){
                be.craft();
                be.progress = 0;
            }
        } else be.progress = 0;
    }

    private boolean hasRecipe(){
        var inv = snapshotForRecipe(); // fill SimpleContainer only with effective input slots + (fuel if needed)
        var type = inStructure ? CCRecipes.STARFORGE_MULTIBLOCK.get() : CCRecipes.STARFORGE_ALONE.get();
        var found = level.getRecipeManager().getRecipeFor(type, inv, level);
        if(found.isEmpty()) return false;
        ItemStack out = found.get().value().getResultItem(level.registryAccess());

        return canOutput(out);
    }
    private void craft(){
        var inv = snapshotForRecipe();
        var type = inStructure ? CCRecipes.STARFORGE_MULTIBLOCK.get() : CCRecipes.STARFORGE_ALONE.get();
        var rh = level.getRecipeManager().getRecipeFor(type, inv, level).orElseThrow();
        ItemStack out = rh.value().getResultItem(level.registryAccess());

        inputSlots().forEach(i -> items.extractItem(i, 1, false));

        int r = resultSlot();
        ItemStack cur = items.getStackInSlot(r);
        items.setStackInSlot(r, ItemHandlerHelper.copyStackWithSize(out, cur.getCount() + out.getCount()));

        // handle fuel consumption here (don’t set fuel to the result item by accident!)
        // fuelSlot().ifPresent(fs -> consumeFuel(fs));
    }

    private SimpleContainer snapshotForRecipe(){
        int size = inStructure ? 49 : (fuelSlot().isPresent() ? 10 : 9);
        SimpleContainer sc = new SimpleContainer(size);
        inputSlots().forEach(i -> sc.setItem(i, items.getStackInSlot(i)));
        // No need to include result slot in the recipe inventory
        return sc;
    }

    private boolean canOutput(ItemStack out){
        int r = resultSlot();
        ItemStack cur = items.getStackInSlot(r);
        return (cur.isEmpty() || ItemStack.isSameItemSameTags(cur, out)) &&
                cur.getCount() + out.getCount() <= cur.getMaxStackSize();
    }

    // ---- Menu ----
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory pinv, Player p){
        return inStructure
                ? new StarforgeMultiblockMenu(id, pinv, this, data)
                : new StarforgeAloneMenu(id, pinv, this, data);
    }
}
