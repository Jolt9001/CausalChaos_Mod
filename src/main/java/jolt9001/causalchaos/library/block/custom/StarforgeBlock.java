package jolt9001.causalchaos.library.block.custom;

import jolt9001.causalchaos.library.block.entity.CCBlockEntities;
import jolt9001.causalchaos.library.block.entity.starforge.T0StarforgeBlockEntity;
import jolt9001.causalchaos.library.block.entity.starforge.T1StarforgeBlockEntity;
import jolt9001.causalchaos.library.block.entity.starforge.T2StarforgeBlockEntity;
import jolt9001.causalchaos.library.block.entity.starforge.T3StarforgeBlockEntity;
import jolt9001.causalchaos.library.screen.StarforgeAloneScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkContext;
import net.minecraftforge.network.NetworkInstance;
import org.jetbrains.annotations.Nullable;

public class StarforgeBlock extends AbstractFurnaceBlock {
    protected static int tier;
    public static int getTier() {
        return tier;
    }
    public static void setTier(int t) {
        tier = t;
    }

    protected StarforgeBlock(Properties properties) {
        super(properties);
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof T0StarforgeBlockEntity) {
                ((T0StarforgeBlockEntity) blockEntity).drops();
            } else if (blockEntity instanceof T1StarforgeBlockEntity) {
                ((T1StarforgeBlockEntity) blockEntity).drops();
            } else if (blockEntity instanceof T2StarforgeBlockEntity) {
                ((T2StarforgeBlockEntity) blockEntity).drops();
            } else if (blockEntity instanceof T3StarforgeBlockEntity) {
                ((T3StarforgeBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    @Deprecated
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof T0StarforgeBlockEntity) {
                setTier(0);
                return InteractionResult.SUCCESS;
            } else if (blockEntity instanceof T1StarforgeBlockEntity) {
                setTier(1);
                return InteractionResult.SUCCESS;
            } else if (blockEntity instanceof T2StarforgeBlockEntity) {
                setTier(2);
                return InteractionResult.SUCCESS;
            } else if (blockEntity instanceof T3StarforgeBlockEntity) {
                setTier(3);
                return InteractionResult.SUCCESS;
            } else {
                throw new IllegalStateException("Container provider is missing.");
            }
        } else {
            this.openContainer(level, pos, player);
            return InteractionResult.CONSUME;
        }
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
        return createTickerHelper(blockEntityType, CCBlockEntities.T0_STARFORGE_BE.get(),
                (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1)/*T0StarforgeBlockEntity::serverTick*/);
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof T0StarforgeBlockEntity t0StarforgeBlockEntity) {
                setTier(0);
                player.openMenu(t0StarforgeBlockEntity);
            } else if (blockEntity instanceof T1StarforgeBlockEntity t1StarforgeBlockEntity) {
                setTier(1);
                player.openMenu(t1StarforgeBlockEntity);
            } else if (blockEntity instanceof T2StarforgeBlockEntity t2StarforgeBlockEntity) {
                setTier(2);
                player.openMenu(t2StarforgeBlockEntity);
            } else if (blockEntity instanceof T3StarforgeBlockEntity t3StarforgeBlockEntity) {
                setTier(3);
                player.openMenu(t3StarforgeBlockEntity);
            } else {
                throw new IllegalStateException("Container provider is missing.");
            }
        }
    }
}
