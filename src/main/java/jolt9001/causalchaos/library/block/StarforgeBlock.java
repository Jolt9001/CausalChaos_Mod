package jolt9001.causalchaos.library.block;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.init.CCBlockEntities;
import jolt9001.causalchaos.init.CCMultiblockEntities;
import jolt9001.causalchaos.library.block.entity.starforgealone.*;
import jolt9001.causalchaos.library.block.entity.starforgemultiblock.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.extensions.IForgeServerPlayer;
import org.jetbrains.annotations.Nullable;

public class StarforgeBlock extends BaseEntityBlock {
    protected boolean isMultiblock = false;
    protected int tier = 0;


    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);
    public static final IntegerProperty TIER = IntegerProperty.create("tier", 0, 3);
    public static final BooleanProperty IN_STRUCTURE = BooleanProperty.create("in_structure");

    public int getTier() {
        return tier;
    }
    public void setTier(int t) {
        tier = t;
    }
    public boolean getIsMultiblock() {
        return isMultiblock;
    }
    public void setIsMultiblock(boolean check) {
        isMultiblock = check;
    }

    public StarforgeBlock(Properties properties, int tier) {
        super(properties);
        setTier(tier);
        this.registerDefaultState(this.defaultBlockState().setValue(ACTIVE, false).setValue(FACING, Direction.NORTH)
                .setValue(TIER, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext collision) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder){
        super.createBlockStateDefinition(builder);
        builder.add(FACING, ACTIVE, TIER);
    }


    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            //if (!checkMultiblock(level, pos)) {
                if (blockEntity instanceof T0StarforgeBlockEntity) {
                    ((T0StarforgeBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T1StarforgeBlockEntity) {
                    ((T1StarforgeBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T2StarforgeBlockEntity) {
                    ((T2StarforgeBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T3StarforgeBlockEntity) {
                    ((T3StarforgeBlockEntity) blockEntity).drops();
                }
                /*
            } else {
                if (blockEntity instanceof T1StarforgeMultiBlockEntity) {
                    ((T1StarforgeMultiBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T2StarforgeMultiBlockEntity) {
                    ((T2StarforgeMultiBlockEntity) blockEntity).drops();
                } else if (blockEntity instanceof T3StarforgeMultiBlockEntity) {
                    ((T3StarforgeMultiBlockEntity) blockEntity).drops();
                }
            }

                 */
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    @Deprecated
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (!isMultiblock) {
                if (blockEntity instanceof T0StarforgeBlockEntity) {
                    IForgeServerPlayer serverPlayer = (IForgeServerPlayer) player;
                    serverPlayer.openMenu(state.getMenuProvider(level, pos), pos);
                } else if (blockEntity instanceof T1StarforgeBlockEntity) {
                    IForgeServerPlayer serverPlayer = (IForgeServerPlayer) player;
                    serverPlayer.openMenu(state.getMenuProvider(level, pos), pos);
                } else if (blockEntity instanceof T2StarforgeBlockEntity) {
                    IForgeServerPlayer serverPlayer = (IForgeServerPlayer) player;
                    serverPlayer.openMenu(state.getMenuProvider(level, pos), pos);
                } else if (blockEntity instanceof T3StarforgeBlockEntity) {
                    IForgeServerPlayer serverPlayer = (IForgeServerPlayer) player;
                    serverPlayer.openMenu(state.getMenuProvider(level, pos), pos);
                } else {
                    throw new IllegalStateException("Container provider is missing.");
                }
            } else {
                if (blockEntity instanceof T1StarforgeMultiBlockEntity) {
                    IForgeServerPlayer serverPlayer = (IForgeServerPlayer) player;
                    serverPlayer.openMenu(state.getMenuProvider(level, pos), pos);
                } else if (blockEntity instanceof T2StarforgeMultiBlockEntity) {
                    IForgeServerPlayer serverPlayer = (IForgeServerPlayer) player;
                    serverPlayer.openMenu(state.getMenuProvider(level, pos), pos);
                } else if (blockEntity instanceof T3StarforgeMultiBlockEntity) {
                    IForgeServerPlayer serverPlayer = (IForgeServerPlayer) player;
                    serverPlayer.openMenu(state.getMenuProvider(level, pos), pos);
                } else {
                    throw new IllegalStateException("Container provider is missing.");
                }
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        CausalChaos.LOGGER.info("Tier " + getTier() + " Alone Starforge located at: " + pos);
        if (!isMultiblock) {
            return switch (getTier()) {
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

    @Nullable
    public BlockEntity newMultiblockEntity(BlockPos pos, BlockState state) {
        return switch (getTier()) {
            case 1 -> new T1StarforgeMultiBlockEntity(pos, state);
            case 2 -> new T2StarforgeMultiBlockEntity(pos, state);
            case 3 -> new T3StarforgeMultiBlockEntity(pos, state);
            default -> null;
        };
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) return null;
        if (!isMultiblock) {
            switch (getTier()) {
                case 0 -> {
                    return createTickerHelper(blockEntityType, CCBlockEntities.T0_STARFORGE_BE.get(),
                            (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1));
                }
                case 1 -> {
                    return createTickerHelper(blockEntityType, CCBlockEntities.T1_STARFORGE_BE.get(),
                            (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1));
                }
                case 2 -> {
                    return createTickerHelper(blockEntityType, CCBlockEntities.T2_STARFORGE_BE.get(),
                            (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1));
                }
                case 3 -> {
                    return createTickerHelper(blockEntityType, CCBlockEntities.T3_STARFORGE_BE.get(),
                            (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1));
                }
                default -> throw new IllegalStateException("Container provider is missing.");
            }
        } else {
            switch (getTier()) {
                case 1 -> {
                    return createTickerHelper(blockEntityType, CCMultiblockEntities.T1_STARFORGE_MBE.get(),
                            (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1));
                }
                case 2 -> {
                    return createTickerHelper(blockEntityType, CCMultiblockEntities.T2_STARFORGE_MBE.get(),
                            (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1));
                }
                case 3 -> {
                    return createTickerHelper(blockEntityType, CCMultiblockEntities.T3_STARFORGE_MBE.get(),
                            (level1, pos, state1, blockEntity) -> blockEntity.tick(level1, pos, state1));
                }
                default -> throw new IllegalStateException("Container provider is missing.");
            }
        }
    }

    protected void openContainer(Level level, BlockPos pos, Player player) {
        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (getIsMultiblock()) {
                if (blockEntity instanceof T1StarforgeMultiBlockEntity t1StarforgeMultiBlockEntity) {
                    player.openMenu(t1StarforgeMultiBlockEntity);
                } else if (blockEntity instanceof T2StarforgeMultiBlockEntity t2StarforgeMultiblockEntity) {
                    player.openMenu(t2StarforgeMultiblockEntity);
                } else if (blockEntity instanceof T3StarforgeMultiBlockEntity t3StarforgeMultiBlockEntity) {
                    player.openMenu(t3StarforgeMultiBlockEntity);
                } else {
                    throw new IllegalStateException("Container provider is missing.");
                }
            } else {
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
    public boolean checkMultiblock(Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);


        return switch (getTier()) {
            case 1 -> blockEntity instanceof T1StarforgeMultiBlockEntity;
            case 2 -> blockEntity instanceof T2StarforgeMultiBlockEntity;
            case 3 -> blockEntity instanceof T3StarforgeMultiBlockEntity;
            default -> throw new IllegalStateException("Illegal value: " + tier);
        };
    }

    public static void buildMultiblock() {

    }
}