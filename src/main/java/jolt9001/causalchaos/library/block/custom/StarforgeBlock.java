package jolt9001.causalchaos.library.block.custom;

import jolt9001.causalchaos.library.block.CCBlockEntities;
import jolt9001.causalchaos.library.block.entity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class StarforgeBlock extends AbstractFurnaceBlock {


    protected int tier;

    public int getTier() {
        return tier;
    }
    public void setTier(int t) {
        tier = t;
    }

    protected StarforgeBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return switch (tier) {
            case 0 -> new T0StarforgeBlockEntity(pos, state);
            case 1 -> new T1StarforgeBlockEntity(pos, state);
            case 2 -> new T2StarforgeBlockEntity(pos, state);
            case 3 -> new T3StarforgeBlockEntity(pos, state);
            default -> null;
        };
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return null;
        }
        return createTickerHelper(blockEntityType, CCBlockEntities.T0_STARFORGE_BE.get(), T0StarforgeBlockEntity::serverTick);
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof T0StarforgeBlockEntity t0StarforgeBlockEntity) {
                player.openMenu(t0StarforgeBlockEntity);
            } else if (blockEntity instanceof T1StarforgeBlockEntity t1StarforgeBlockEntity) {
                player.openMenu(t1StarforgeBlockEntity);
            } else if (blockEntity instanceof T2StarforgeBlockEntity t2StarforgeBlockEntity) {
                player.openMenu(t2StarforgeBlockEntity);
            } else if (blockEntity instanceof T3StarforgeBlockEntity t3StarforgeBlockEntity) {
                player.openMenu(t3StarforgeBlockEntity);
            } else {
                throw new IllegalStateException("Container provider is missing.");
            }
        }
    }
}
