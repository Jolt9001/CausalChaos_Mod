package jolt9001.causalchaos.library.portal;

import jolt9001.causalchaos.CCConfig;
import jolt9001.causalchaos.init.CCSounds;
import jolt9001.causalchaos.library.world.registration.CCGenerationSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.mutable.MutableInt;

import java.util.Map;

public class TranscendentPortalBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0, 0.0, 6.0, 16.0, 16.0, 10.0);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);

    private static ResourceKey<Level> cachedOriginDimension;

    public TranscendentPortalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AXIS, Direction.Axis.X));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

/**
 * [CODE COPY] - {@link Entity handleInsidePortal(BlockPos)}<br>
 * [CODE COPY] - {@link Entity handleNetherPortal()}.<br><br>
 */
    @SuppressWarnings("deprecation")
    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) { // Portal checks for when an entity is inside the portal
        if (!entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions() && !entity.level().isClientSide && level != null && level.dimension() != null){
            if (entity.isOnPortalCooldown()){
                entity.setPortalCooldown();
            } else {
                if (entity instanceof LivingEntity){
                    entity.level().getProfiler().push(level.dimension().location().getPath());
                    attemptSendEntity(entity);
                }
            }
        }
    }
    private static ResourceKey<Level> getDestination(Entity entity) { // Destination getter
        if (cachedOriginDimension == null){
            cachedOriginDimension = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(CCConfig.COMMON_CONFIG.originDimension.get()));
        }
        return !entity.getCommandSenderWorld().dimension().location().equals(CCGenerationSettings.DIMENSION_FINAL)
                ? cachedOriginDimension // Return dimension
                : CCGenerationSettings.DIMENSION_KEY_FINAL; // Destination dimension
    }

    public static void attemptSendEntity(Entity entity) { // Teleportation Handler
        if (!entity.isAlive() || entity.level().isClientSide()) return;
        if (entity.isPassenger() || entity.isVehicle() || !entity.canChangeDimensions()) return;

        ResourceKey<Level> destinationKey = getDestination(entity);
        ServerLevel destinationLevel = entity.getCommandSenderWorld().getServer().getLevel(destinationKey);
        if (destinationLevel == null) return;

        entity.changeDimension(destinationLevel, new TranscendentPortalForcer(destinationLevel));

        if (destinationKey == CCGenerationSettings.DIMENSION_KEY_FINAL && entity instanceof ServerPlayer playerMP) {
            playerMP.setRespawnPosition(destinationKey, playerMP.blockPosition(), playerMP.getYRot(), true, false);
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource rand) { // Animation
        int random = rand.nextInt(100);
        // if (state.getValue(DISALLOW_RETURN) && random < 80) return;

        if (random == 0) {
            level.playLocalSound(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, CCSounds.PORTAL_WHOOSH.get(), SoundSource.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double xPos = pos.getX() + rand.nextFloat();
            double yPos = pos.getY() + 1D;
            double zPos = pos.getZ() + rand.nextFloat();
            double xSpeed = (rand.nextFloat() - 0.5D) * 0.5D;
            double ySpeed = rand.nextFloat();
            double zSpeed = (rand.nextFloat() - 0.5D) * 0.5D;

            level.addParticle(ParticleTypes.PORTAL, xPos, yPos, zPos, xSpeed, ySpeed, zSpeed);
        }
    }
    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) { // Portal rotation handler
        return switch (rotation) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch (state.getValue(AXIS)) {
                case Z -> state.setValue(AXIS, Direction.Axis.X);
                case X -> state.setValue(AXIS, Direction.Axis.Z);
                default -> state;
            };
            default -> state;
        };
    }
    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(AXIS)) {
            case Z -> Z_AXIS_AABB;
            default -> X_AXIS_AABB;
        };
    }
    @SuppressWarnings("deprecation")
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        Direction.Axis directionAxis = direction.getAxis();
        Direction.Axis blockAxis = state.getValue(AXIS);
        boolean flag = blockAxis != directionAxis && directionAxis.isHorizontal();
        return !flag && !facingState.is(this) && !(new TranscendentPortalShape(level, currentPos, blockAxis).isComplete()) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, facingState, level, currentPos, facingPos);
    }
    @SuppressWarnings("deprecation")
    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }
}
