package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.masks.FerventFieldSpiralMask;
import jolt9001.causalchaos.library.worldgen.dimension.CCDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
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
            NoiseGeneratorSettings.CODEC.fieldOf("tplain_noise_generation_settings").forGetter(o -> o.noiseGeneratorSettings)//,
            //Codec.unboundedMap(ResourceKey.codec(Registries.BIOME), CCLandmark.CODEC.listOf().xmap(ImmutableSet::copyOf, ImmutableList::copyOf)).fieldOf("landmark_placement_allowed_biomes").forGetter(o -> o.biomeLandmarkOverrides)
    ).apply(instance, ChunkGenTPlain::new));

    public final ChunkGenerator delegate;
    private final Holder<NoiseGeneratorSettings> noiseGeneratorSettings;
    //private final Map<ResourceKey<Biome>, ImmutableSet<CCLandmark>> biomeLandmarkOverrides;
    //private final Optional<Climate.Sampler> surfaceNoiseGetter;
    private final BiomeSource ffsource;

    public ChunkGenTPlain(ChunkGenerator delegate, Holder<NoiseGeneratorSettings> noiseGeneratorSettings/*, ImmutableSet<CCLandmark>> biomeLandmarkOverrides*/) {
        super(delegate.getBiomeSource());
        this.delegate = delegate;
        this.noiseGeneratorSettings = noiseGeneratorSettings;
        this.ffsource = this.getBiomeSource();
        //this.biomeLandmarkOverrides = biomeLandmarkOverrides;
    }
/*
    private static BiomeSource wrap(BiomeSource base) {
        // look up your biomes/level key from your bootstrap/context as needed

        Holder<Biome> ff;    //= registry.getOrThrow(CCBiomes.FERVENT_FIELD)
        Holder<Biome> yin;   //= registry.getOrThrow(CCBiomes.FERVENT_FIELD_YIN)
        Holder<Biome> yang;  //= registry.getOrThrow(CCBiomes.FERVENT_FIELD_YANG)
        Holder<Biome> unity; //= registry.getOrThrow(CCBiomes.FERVENT_FIELD_UNITY)
        ResourceKey<Level> dim = CCDimensions.TPLAIN_LEVEL_KEY;

        return new FerventFieldBiomeSource(base, ff, yin, yang, unity, dim);
    }
*/
    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void applyCarvers(WorldGenRegion worldGenRegion, long l, RandomState randomState, BiomeManager biomeManager, StructureManager structureManager, ChunkAccess chunkAccess, GenerationStep.Carving carving) {

    }

    @Override
    public void buildSurface(WorldGenRegion region, StructureManager structure, RandomState random, ChunkAccess chunk) {
        delegate.buildSurface(region, structure, random, chunk);

        // Chunk world coordinates
        final ChunkPos cp = chunk.getPos();
        final int midX = cp.getMiddleBlockX();
        final int midZ = cp.getMiddleBlockZ();

        // Sample which variant the biome source chose (authoritative):
        Holder<Biome> atMid = region.getBiomeManager().getNoiseBiomeAtPosition(new BlockPos(midX, 64, midZ));

        // If wanted, *also* compute your spiral mask for shaping detail fields:
        long seed = region.getLevel().getSeed(); // or derive from RandomState

        // For Fervent Field
        final double cx = 0, cz = 0;
        FerventFieldSpiralMask.Params p = new FerventFieldSpiralMask.Params(cx, cz, 480.0, 0.3, 10.0, 1.0, 48.0, 1.0);
        boolean yin = FerventFieldSpiralMask.isYin(midX, midZ, seed, p, 0.0);

        // Prefer the biome source decision to avoid disagreement:
        boolean isYin    = atMid.is(CCBiomes.FERVENT_FIELD_YIN);
        boolean isYang   = atMid.is(CCBiomes.FERVENT_FIELD_YANG);
        boolean isUnity  = atMid.is(CCBiomes.FERVENT_FIELD_UNITY);

        // Use the variant to control surface touch-ups (examples):
        if (isYang) {
            // sprinkle poison sand, adjust top blocks, place toxic patches, etc.
        } else if (isYin) {
            // softer topsoil, safe flowers, etc.
        } else if (isUnity) {
            // mixed palette, randomized patches
        }
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