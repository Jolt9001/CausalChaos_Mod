package jolt9001.causalchaos.library.portal;

import com.google.common.collect.Maps;
import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.init.CCBlocks;
import jolt9001.causalchaos.library.worldgen.registration.CCGenerationSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ColumnPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.util.ITeleporter;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;

public class TranscendentPortalForcer implements ITeleporter {
    private final ServerLevel level;
    private static final Map<ResourceLocation, Map<ColumnPos, PortalPosition>> destinationCoordinateCache = new HashMap<>();

    public TranscendentPortalForcer(ServerLevel level) {
        this.level = level;
    }

    // Get Portal info
    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerLevel dest, Function<ServerLevel, PortalInfo> info) {
        PortalInfo pos;
        // Scale coordinates based on the dimension type coordinate_scale
        ServerLevel dim = dest.getServer().getLevel(CCGenerationSettings.DIMENSION_KEY_FINAL);
        double scale = dim == null ? 0.125D : dim.dimensionType().coordinateScale();
        scale = dest.dimension().equals(CCGenerationSettings.DIMENSION_KEY_FINAL) ? 1F / scale : scale;
        BlockPos destPos = dest.getWorldBorder().clampToBounds(entity.blockPosition().getX() * scale, entity.blockPosition().getY(), entity.blockPosition().getZ() * scale);

        if ((pos = findExisting(dest, entity, destPos)) == null) {
            CausalChaos.LOGGER.debug("Could not find existing portal. Generating a new one...");

            pos = findExisting(dest, entity, BlockPos.containing(pos.pos));
        }
        return pos == null ? ITeleporter.super.getPortalInfo(entity, dest, info) : pos;
    }

    @Nullable
    private static PortalInfo findExisting(ServerLevel destDim, Entity entity, BlockPos pos) {
        boolean flag = true;
        BlockPos blockpos;
        ColumnPos columnPos = new ColumnPos(entity.blockPosition().getX(), entity.blockPosition().getZ());


        PortalPosition portalPosition = destinationCoordinateCache.containsKey(destDim.dimension().location()) ? destinationCoordinateCache.get(destDim.dimension().location()).get(columnPos) : null;

        if (portalPosition != null) {
            blockpos = portalPosition.pos;
            portalPosition.lastUpdateTime = destDim.getGameTime();
            flag = false;
            // Validate that portal still exists
            CausalChaos.LOGGER.debug("Using cache, validating. {}", blockpos);
            if (blockpos == null || !destDim.getBlockState(blockpos).is(CCBlocks.TRANSCENDENT_GATEWAY.get())) {
                // Portal broke, recreate
                CausalChaos.LOGGER.debug("Invalid portal, regenerating.");
                blockpos = null;
                destinationCoordinateCache.get(destDim.dimension().location()).remove(columnPos);
            }
        } else {
            blockpos = getPortalPosition(destDim, pos);
        }

        if (blockpos == null) {
            return null;
        } else {
            if (flag) {
                CausalChaos.LOGGER.debug("Caching Src Portal Blocks to {}", blockpos);
                destinationCoordinateCache.putIfAbsent(destDim.dimension().location(), Maps.newHashMapWithExpectedSize(4096));
                Map<BlockPos, Boolean> portalBlocks = new HashMap<>();
                portalBlocks.put(entity.blockPosition(), true);
                // TranscendentPortalBlock.validate(entity.level(), entity.blockPosition(), portalBlocks, new MutableInt(0), entity.level().getBlockState(entity.blockPosition()));
                BlockPos finalBlockpos = blockpos;
                portalBlocks.forEach((blockPos, b) -> {
                    if (b) {
                        CausalChaos.LOGGER.debug("Caching {}", blockPos);
                        destinationCoordinateCache.get(destDim.dimension().location()).put(new ColumnPos(blockPos.getX(), blockPos.getZ()), new PortalPosition(finalBlockpos, destDim.getGameTime()));
                    }
                });
                destDim.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockpos), 3, new BlockPos(columnPos.x(), blockpos.getY(), columnPos.z()));
            }
            BlockPos[] portalBorder = getBoundaryPositions(destDim, blockpos).toArray(new BlockPos[0]);
            BlockPos borderPos = portalBorder[0];

            double portalX = borderPos.getX() + 0.5;
            double portalY = borderPos.getY() + 1.0;
            double portalZ = borderPos.getZ() + 0.5;

            return makePortalInfo(entity, portalX, portalY, portalZ);
        }
    }

    @Nullable
    private static BlockPos getPortalPosition(ServerLevel destDim, BlockPos pos) {
        int i = 200; // Scan radius up to 200
        double d0 = Double.MAX_VALUE;
        BlockPos result = null;

        for (int i1 = -i; i1 <= i; ++i1) {
            BlockPos blockPos2;

            for (int j1 = -i; j1 <= i; ++j1) {

            }
        }
        return null;
    }

    private static Set<BlockPos> getBoundaryPositions(ServerLevel world, BlockPos start) {
        Set<BlockPos> result = new HashSet<>(), checked = new HashSet<>();
        checked.add(start);
        checkAdjacent(world, start, checked, result);
        return result;
    }
    private static void checkAdjacent(ServerLevel level, BlockPos pos, Set<BlockPos> checked, Set<BlockPos> result) {
        for (Direction facing : Direction.Plane.HORIZONTAL) {
            BlockPos offset = pos.relative(facing);
            if (!checked.add(offset))
                continue;
            if (isPortalAt(level, offset)) {
                checkAdjacent(level, offset, checked, result);
            } else {
                result.add(offset);
            }
        }
    }
    private static boolean isPortal(BlockState state) {
        return state.getBlock() == CCBlocks.TRANSCENDENT_GATEWAY.get();
    }
    private static boolean isPortalAt(ServerLevel level, BlockPos pos) {
        return isPortal(level.getBlockState(pos));
    }

    public void makePortal(Entity entity, ServerLevel level, Vec3 pos) {
        // TranscendentPortalShape portal = this.isPortal()
    }

    static class PortalPosition {
        public final BlockPos pos;
        long lastUpdateTime;

        PortalPosition(BlockPos pos, long time) {
            this.pos = pos;
            this.lastUpdateTime = time;
        }
    }

    private static PortalInfo makePortalInfo(Entity entity, double x, double y, double z) {
        return makePortalInfo(entity, new Vec3(x, y, z));
    }

    private static PortalInfo makePortalInfo(Entity entity, Vec3 pos) {
        return new PortalInfo(pos, Vec3.ZERO, entity.getYRot(), entity.getXRot());
    }
}
