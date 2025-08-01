package jolt9001.causalchaos.library.screen;

import jolt9001.causalchaos.init.CCMenuTypes;
import jolt9001.causalchaos.library.block.starforge.StarforgeBlock;
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

    public BlockEntity blockEntity = null;
    private final Level level;
    private final ContainerData data;

    public static int tier;

    public StarforgeAloneMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(11));
    }

    public StarforgeAloneMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(CCMenuTypes.STARFORGE_ALONE_MENU.get(), containerId);
        checkContainerSize(inv, 10);
        tier = StarforgeBlock.getTier();
        switch (tier) {
            case 0 -> blockEntity = ((T0StarforgeBlockEntity) entity);
            case 1 -> blockEntity = ((T1StarforgeBlockEntity) entity);
            case 2 -> blockEntity = ((T2StarforgeBlockEntity) entity);
            case 3 -> blockEntity = ((T3StarforgeBlockEntity) entity);
        }

        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 9; ++j){ // x = 44, y = 53
                    this.addSlot(new SlotItemHandler(iItemHandler, i + j, 44 + i * 18, 53 + j * 18));
                }
            }
        });

        addDataSlots(data);
    }

    public boolean isLit() {
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
     * For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
     * Each time we add a Slot to the container, it automatically increases the slotIndex, which means
     *  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
     * 9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
     *  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
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
                return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, CCBlocks.T0_STARFORGE.get());
            }
            case 1 -> {
                return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, CCBlocks.T1_STARFORGE.get());
            }
            case 2 -> {
                return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, CCBlocks.T2_STARFORGE.get());
            }
            case 3 -> {
                return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                        player, CCBlocks.T3_STARFORGE.get());
            }
            default -> throw new IllegalStateException("Invalid tier:  " + tier);
        }
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 22 + j * 18, 157 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 22 + i * 18, 215));
        }
    }
}
