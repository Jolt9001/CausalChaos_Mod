package jolt9001.causalchaos.library.block.custom;

import jolt9001.causalchaos.library.block.CCBlockEntities;
import jolt9001.causalchaos.library.block.entity.T0StarforgeBlockEntity;
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
    public static final int TIER = 0;

    protected StarforgeBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new T0StarforgeBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return null;
        }
        return createTickerHelper(blockEntityType, CCBlockEntities.T0_STARFORGE_BE.get(), T0StarforgeBlockEntity::serverTick);
        // return level.isClientSide() ? null : createTickerHelper(blockEntityType, CCBlockEntityTypes.STARFORGE.get(), AbstractFurnaceBlock::tick);
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {

    }
}
