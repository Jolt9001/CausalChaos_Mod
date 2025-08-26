package jolt9001.causalchaos.library.worldgen.components;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

import java.util.function.Function;

public class CCCavesCarver extends WorldCarver<CaveCarverConfiguration> {
    public CCCavesCarver(Codec<CaveCarverConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean carve(CarvingContext carvingContext, CaveCarverConfiguration caveCarverConfiguration, ChunkAccess chunkAccess, Function<BlockPos, Holder<Biome>> function, RandomSource randomSource, Aquifer aquifer, ChunkPos chunkPos, CarvingMask carvingMask) {
        return false;
    }

    @Override
    public boolean isStartChunk(CaveCarverConfiguration caveCarverConfiguration, RandomSource randomSource) {
        return false;
    }
}
