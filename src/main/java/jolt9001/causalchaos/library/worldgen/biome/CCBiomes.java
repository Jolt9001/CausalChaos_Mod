package jolt9001.causalchaos.library.worldgen.biome;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.worldgen.biome.biomegen.dimensions.OverworldBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;


public class CCBiomes {
    // Test Biome
    public static final ResourceKey<Biome> TEST_BIOME = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "test_biome"));

    // Overworld biomes
    public static final ResourceKey<Biome> STORM_WALL = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "storm_wall")); // Similar to Windswept Gravel Hills

    // Transcendent's Plain
        // Superboss Domains
    public static final ResourceKey<Biome> CRYSTAL_CLIFFS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_tsuna")); // Tsuna
    public static final ResourceKey<Biome> DISMAL_DESERT = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_kai")); // Kai, similar to Desert
    public static final ResourceKey<Biome> SYSTEMATIC_SHRUBLANDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_terry")); // Terry
    public static final ResourceKey<Biome> PETRIFYING_PLATEAU = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_lyadova")); // Lyadova
    public static final ResourceKey<Biome> CHROMATIC_CRAGS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_aella")); // Aella, Similar to Stony Peaks
    public static final ResourceKey<Biome> GELID_GLACIER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_jack")); // Jack
    public static final ResourceKey<Biome> SKOURAINEI = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_skourainei")); // Xanthea, similar to Dark Forest
    public static final ResourceKey<Biome> HYPERBOLIC_HILLS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_will")); // Will
    public static final ResourceKey<Biome> FATUOUS_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_matthue")); // Matthue
    public static final ResourceKey<Biome> HALCYON_HIGHLAND = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_alline")); // Alline
    public static final ResourceKey<Biome> FERVENT_FIELD = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_madeline")); // Madeline, Similar to Flower Forest
    public static final ResourceKey<Biome> SUBCONSCIOUS_SWAMP = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_emily")); // Emily
    public static final ResourceKey<Biome> CALESCENT_CALDERA = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_adrian")); // Adrian
    public static final ResourceKey<Biome> TRANSIENT_TERRACE = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_andrea")); // Andrea
    public static final ResourceKey<Biome> QUIVERING_QUARRY = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_rex")); // Rex
    public static final ResourceKey<Biome> PERFECT_PLAINS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_jolt")); // Jolt, similar to Plains
        // Other Biomes
    public static final ResourceKey<Biome> RADIANT_RIVER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "radiant_river")); // Separator biome for biome map continuity
    public static final ResourceKey<Biome> FROZEN_RADIANT_RIVER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "frozen_radiant_river")); // Separator biome for biome map continuity


        // Variants

        // Oceans
    public static final ResourceKey<Biome> FROZEN_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "frozen_originative_ocean"));
    public static final ResourceKey<Biome> COLD_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "cold_originative_ocean"));
    public static final ResourceKey<Biome> ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "originative_ocean"));
    public static final ResourceKey<Biome> LUKEWARM_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "lukewarm_originative_ocean"));
    public static final ResourceKey<Biome> WARM_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "warm_originative_ocean"));
    public static final ResourceKey<Biome> DEEP_FROZEN_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "frozen_originative_ocean"));
    public static final ResourceKey<Biome> DEEP_COLD_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "cold_originative_ocean"));
    public static final ResourceKey<Biome> DEEP_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "originative_ocean"));
    public static final ResourceKey<Biome> DEEP_LUKEWARM_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "lukewarm_originative_ocean"));

    // Sky
    public static final ResourceKey<Biome> CUMULONIMBUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "cumulonimbus")); //

    // Limbo
    public static final ResourceKey<Biome> REALMWEAVE_LANDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "limbo/realmweave_lands"));
    public static final ResourceKey<Biome> WORLD_THREAD_FLATS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "limbo/world_thread_flats"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(TEST_BIOME, OverworldBiomes.testBiome(context));

        context.register(STORM_WALL, OverworldBiomes.stormWallBiome(context));
        /*
        context.register(CRYSTAL_CLIFFS, TPlainBiomes.crystalCliffsBiome(context));
        context.register(PERFECT_PLAINS, TPlainBiomes.perfectPlainsBiome(context));

         */
    }


    private static void addDefaultOverworldGeneration(BiomeGenerationSettings.Builder generationSettings) {
        CCBiomes.globalOverworldGeneration(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
}
