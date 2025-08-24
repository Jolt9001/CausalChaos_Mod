package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ChunkGenTPlain extends ChunkGenerator {
    /*
     * Endless rolling plain of green grass and white sky
     * few trees, wide caves, no hostile mobs
     * structures generate across the dimension in a grid pattern centered at the portal location
     * Rare ores generate far more often here than in the Overworld
     */

    public static final Codec<ChunkGenTPlain> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            ChunkGenerator.CODEC.fieldOf("tplain_wrapped_generator").forGetter(o -> o.delegate),
            NoiseGeneratorSettings.CODEC.fieldOf("tplain_noise_generation_settings").forGetter(o -> o.noiseGeneratorSettings))
            //Codec.unboundedMap(ResourceKey.codec(Registries.BIOME), CCLandmark.CODEC.listOf().xmap(ImmutableSet::copyOf, ImmutableList::copyOf)).fieldOf("landmark_placement_allowed_biomes").forGetter(o -> o.biomeLandmarkOverrides)
            .apply(instance, ChunkGenTPlain::new));

    private final Holder<NoiseGeneratorSettings> noiseGeneratorSettings;
    //private final Map<ResourceKey<Biome>, ImmutableSet<CCLandmark>> biomeLandmarkOverrides;
    //private final Optional<Climate.Sampler> surfaceNoiseGetter;
    public final ChunkGenerator delegate;

    public ChunkGenTPlain(ChunkGenerator delegate, Holder<NoiseGeneratorSettings> noiseGeneratorSettings/*, ImmutableSet<CCLandmark>> biomeLandmarkOverrides*/) {
        super(delegate.getBiomeSource());
        this.delegate = delegate;
        this.noiseGeneratorSettings = noiseGeneratorSettings;
        //this.biomeLandmarkOverrides = biomeLandmarkOverrides;
    }

    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void applyCarvers(WorldGenRegion worldGenRegion, long l, RandomState randomState, BiomeManager biomeManager, StructureManager structureManager, ChunkAccess chunkAccess, GenerationStep.Carving carving) {

    }

    @Override
    public void buildSurface(WorldGenRegion worldGenRegion, StructureManager structureManager, RandomState randomState, ChunkAccess chunkAccess) {

    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion worldGenRegion) {

    }

    @Override
    public int getGenDepth() {
        return 0;
    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, Blender blender, RandomState randomState, StructureManager structureManager, ChunkAccess chunkAccess) {
        return null;
    }

    @Override
    public int getSeaLevel() {
        return 0;
    }

    @Override
    public int getMinY() {
        return -64;
    }

    @Override
    public int getBaseHeight(int i, int i1, Heightmap.Types types, LevelHeightAccessor levelHeightAccessor, RandomState randomState) {
        return 0;
    }

    @Override
    public NoiseColumn getBaseColumn(int i, int i1, LevelHeightAccessor levelHeightAccessor, RandomState randomState) {
        return null;
    }

    @Override
    public void addDebugScreenInfo(List<String> list, RandomState randomState, BlockPos blockPos) {

    }
}