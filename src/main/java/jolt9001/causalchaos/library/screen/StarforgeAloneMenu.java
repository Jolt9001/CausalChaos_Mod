package jolt9001.causalchaos.library.screen;

import jolt9001.causalchaos.init.CCMenuTypes;
import jolt9001.causalchaos.library.block.entity.starforgealone.T0StarforgeBlockEntity;
import jolt9001.causalchaos.library.block.entity.starforgealone.T1StarforgeBlockEntity;
import jolt9001.causalchaos.library.block.entity.starforgealone.T2StarforgeBlockEntity;
import jolt9001.causalchaos.library.block.entity.starforgealone.T3StarforgeBlockEntity;
import jolt9001.causalchaos.init.CCBlocks;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;

public class StarforgeAloneMenu extends AbstractContainerMenu {
    public T0StarforgeBlockEntity blockEntity0;
    public T1StarforgeBlockEntity blockEntity1;
    public T2StarforgeBlockEntity blockEntity2;
    public T3StarforgeBlockEntity blockEntity3;
    protected final Level level;
    protected final ContainerData data;

    protected int tier;

    public StarforgeAloneMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(11));
    }

    public int BlockTier(BlockEntity entity) {
        if (entity instanceof T0StarforgeBlockEntity) return 0;
        else if (entity instanceof T1StarforgeBlockEntity) return 1;
        else if (entity instanceof T2StarforgeBlockEntity) return 2;
        else if (entity instanceof T3StarforgeBlockEntity) return 3;
        else throw new IllegalArgumentException("Invalid tier value");
    }

    public StarforgeAloneMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(CCMenuTypes.STARFORGE_ALONE_MENU.get(), containerId);
        checkContainerSize(inv, 11);
        tier = BlockTier(entity);
        this.level = inv.player.level();
        this.data = data;

        switch (tier) {
            case 0 -> {
                blockEntity0 = ((T0StarforgeBlockEntity) entity);
                this.blockEntity0.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
                    int k = 0; // Index variable
                    for (int i = 0; i < 3; ++i) { // y: vertical positioning; three slots tall
                        for (int j = 0; j < 3; ++j) { // x: horizontal positioning; three slots wide
                            this.addSlot(new SlotItemHandler(iItemHandler, k, 44 + j * 18, 21 + i * 18)); // x = 44, y = 53
                            k++; // k should equal 2 when j loop completes for the first time
                        }
                    }
                    this.addSlot(new SlotItemHandler(iItemHandler, k, 139, 93)); // Fuel Slot, k = 9
                    this.addSlot(new SlotItemHandler(iItemHandler, k+1, 176, 39)); // Result Slot, k = 10
                });
            }
            case 1 -> {
                blockEntity1 = ((T1StarforgeBlockEntity) entity);
                this.blockEntity1.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
                    int k = 0; // Index variable
                    for (int i = 0; i < 3; ++i) { // y: vertical positioning; three slots tall
                        for (int j = 0; j < 3; ++j) { // x: horizontal positioning; three slots wide
                            this.addSlot(new SlotItemHandler(iItemHandler, k, 44 + j * 18, 21 + i * 18)); // x = 44, y = 53
                            k++; // k should equal 2 when j loop completes for the first time
                        }
                    }
                    this.addSlot(new SlotItemHandler(iItemHandler, k, 139, 93)); // Fuel Slot
                    this.addSlot(new SlotItemHandler(iItemHandler, k+1, 176, 39)); // Result Slot
                });
            }
            case 2 -> {
                blockEntity2 = ((T2StarforgeBlockEntity) entity);
                this.blockEntity2.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
                    int k = 0; // Index variable
                    for (int i = 0; i < 3; ++i) { // y: vertical positioning; three slots tall
                        for (int j = 0; j < 3; ++j) { // x: horizontal positioning; three slots wide
                            this.addSlot(new SlotItemHandler(iItemHandler, k, 44 + j * 18, 21 + i * 18)); // x = 44, y = 53
                            k++; // k should equal 2 when j loop completes for the first time
                        }
                    }
                    this.addSlot(new SlotItemHandler(iItemHandler, k, 139, 93)); // Fuel Slot
                    this.addSlot(new SlotItemHandler(iItemHandler, k+1, 176,39)); // Result Slot
                });
            }
            case 3 -> {
                blockEntity3 = ((T3StarforgeBlockEntity) entity);
                this.blockEntity3.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
                    int k = 0; // Index variable
                    for (int i = 0; i < 3; ++i) { // y: vertical positioning; three slots tall
                        for (int j = 0; j < 3; ++j) { // x: horizontal positioning; three slots wide
                            this.addSlot(new SlotItemHandler(iItemHandler, k, 44 + j * 18, 21 + i * 18)); // x = 44, y = 53
                            k++; // k should equal 2 when j loop completes for the first time
                        }
                    }
                    this.addSlot(new SlotItemHandler(iItemHandler, k, 139, 93)); // Fuel Slot
                    this.addSlot(new SlotItemHandler(iItemHandler, k+1, 176, 39)); // Result Slot
                });
            }
            default -> throw new IllegalStateException("Invalid tier value: " + tier);
        }
        addPlayerInventory(inv);
        addPlayerHotbar(inv);
        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getBurnRemainder() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    /**
     * CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
     * must assign a slot number to each of the slots used by the GUI.
     * For this container, we can see both the tile inventory's slots, the player inventory slots, and the hotbar.
     * Each time we add a Slot to the container, it automatically increases the slotIndex, which means
     *  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
     * 9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
     *  36 - 47 = TileInventory slots, which map to our TileEntity slot numbers 0 - 10)
     */
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = 11; // Hardcoded: number of slots in the Starforge when not in its multiblock.

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player player) {
        switch (tier) {
            case 0 -> {
                return stillValid(ContainerLevelAccess.create(level, blockEntity0.getBlockPos()),
                        player, CCBlocks.T0_STARFORGE.get());
            }
            case 1 -> {
                return stillValid(ContainerLevelAccess.create(level, blockEntity1.getBlockPos()),
                        player, CCBlocks.T1_STARFORGE.get());
            }
            case 2 -> {
                return stillValid(ContainerLevelAccess.create(level, blockEntity2.getBlockPos()),
                        player, CCBlocks.T2_STARFORGE.get());
            }
            case 3 -> {
                return stillValid(ContainerLevelAccess.create(level, blockEntity3.getBlockPos()),
                        player, CCBlocks.T3_STARFORGE.get());
            }
            default -> throw new IllegalStateException("Invalid tier: " + tier);
        }
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 22 + j * 18, 125 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 22 + i * 18, 183));
        }
    }
}
