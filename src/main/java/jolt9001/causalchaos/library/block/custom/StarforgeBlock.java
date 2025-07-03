package jolt9001.causalchaos.library.block.custom;

import jolt9001.causalchaos.init.CCBlockEntities;
import jolt9001.causalchaos.library.block.entity.starforgealone.*;
import jolt9001.causalchaos.library.block.entity.starforgemultiblock.*;
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
import org.jetbrains.annotations.Nullable;

public class StarforgeBlock extends AbstractFurnaceBlock {
    protected static boolean isMultiblock;
    protected static int tier;
    public static int getTier() {
        return tier;
    }
    public static void setTier(int t) {
        tier = t;
    }
    public static boolean getIsMultiblock() {
        return isMultiblock;
    }
    public static void setIsMultiblock(boolean check) {
        isMultiblock = check;
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
            if (!checkIfMultiblock(level, pos)) {
                if (blockEntity instanceof T0StarforgeBlockEntity) {
                    setTier(0);
                    ((T0StarforgeBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T1StarforgeBlockEntity) {
                    setTier(1);
                    ((T1StarforgeBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T2StarforgeBlockEntity) {
                    setTier(2);
                    ((T2StarforgeBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T3StarforgeBlockEntity) {
                    setTier(3);
                    ((T3StarforgeBlockEntity) blockEntity).drops();
                }
            } else {
                if (blockEntity instanceof T1StarforgeMultiBlockEntity) {
                    setTier(1);
                    ((T1StarforgeMultiBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T2StarforgeMultiBlockEntity) {
                    setTier(2);
                    ((T2StarforgeMultiBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T3StarforgeMultiBlockEntity) {
                    setTier(3);
                    ((T3StarforgeMultiBlockEntity) blockEntity).drops();
                }
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    @Deprecated
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (!getIsMultiblock()) {
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
                if (blockEntity instanceof T1StarforgeMultiBlockEntity) {
                    setTier(1);
                    return InteractionResult.SUCCESS;
                } else if (blockEntity instanceof T2StarforgeMultiBlockEntity) {
                    setTier(2);
                    return InteractionResult.SUCCESS;
                } else if (blockEntity instanceof T3StarforgeMultiBlockEntity) {
                    setTier(3);
                    return InteractionResult.SUCCESS;
                } else {
                    throw new IllegalStateException("Container provider is missing.");
                }
            }
        } else {
            this.openContainer(level, pos, player);
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        if (!isMultiblock) {
            return switch (tier) {
                case 0 -> new T0StarforgeBlockEntity(pos, state);
                case 1 -> new T1StarforgeBlockEntity(pos, state);
                case 2 -> new T2StarforgeBlockEntity(pos, state);
                case 3 -> new T3StarforgeBlockEntity(pos, state);
                default -> null;
            };
        } else {
            newMultiblockEntity(pos, state);
            return null;
        }
    }

    public BlockEntity newMultiblockEntity(BlockPos pos, BlockState state) {
        if (isMultiblock) {
            return switch (tier) {
                case 1 -> new T1StarforgeMultiBlockEntity(pos, state);
                case 2 -> new T2StarforgeMultiBlockEntity(pos, state);
                case 3 -> new T3StarforgeMultiBlockEntity(pos, state);
                default -> null;
            };
        } else {
            newBlockEntity(pos, state);
            return null;
        }
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return null;
        }
        switch (tier) {
            case 0 -> {
                return createTickerHelper(blockEntityType, CCBlockEntities.T0_STARFORGE_BE.get(),
                        (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1)/*T0StarforgeBlockEntity::serverTick*/);
            }
            case 1 -> {
                return createTickerHelper(blockEntityType, CCBlockEntities.T1_STARFORGE_BE.get(),
                        (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1)/*T1StarforgeBlockEntity::serverTick*/);
            }
            case 2 -> {
                return createTickerHelper(blockEntityType, CCBlockEntities.T2_STARFORGE_BE.get(),
                        (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1)/*T2StarforgeBlockEntity::serverTick*/);
            }
            case 3 -> {
                return createTickerHelper(blockEntityType, CCBlockEntities.T3_STARFORGE_BE.get(),
                        (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1)/*T3StarforgeBlockEntity::serverTick*/);
            }
            default -> throw new IllegalStateException("Container provider is missing.");
        }
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (!getIsMultiblock()) {
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

    /**
     * CS = Core Shielding, HS = heat sink, EM = electromagnet/acceptor, FC = fusion core, SF = starforge
     * Layer 1
     * [CS HS CS]
     * [HS EM HS]
     * [CS HS CS]
     * Layer 2
     * [HS EM HS]
     * [EM FC EM]
     * [HS SF HS]
     * Layer 3
     * [CS HS CS]
     * [HS EM HS]
     * [CS HS CS]
     *
     * @param level
     * @param pos
     * @return boolean instanceof
     */
    public static boolean checkIfMultiblock(Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);


        return switch (tier) {
            case 1 -> blockEntity instanceof T1StarforgeMultiBlockEntity;
            case 2 -> blockEntity instanceof T2StarforgeMultiBlockEntity;
            case 3 -> blockEntity instanceof T3StarforgeMultiBlockEntity;
            default -> throw new IllegalStateException("Illegal value: " + tier);
        };
    }
}
