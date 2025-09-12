package jolt9001.causalchaos.library.worldgen.biome;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.worldgen.biome.biomegen.dimensions.OverworldBiomeGen;
import jolt9001.causalchaos.library.worldgen.biome.biomegen.dimensions.SkyBiomeGen;
import jolt9001.causalchaos.library.worldgen.biome.biomegen.dimensions.TPlainBiomeGen;
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
    public static final ResourceKey<Biome> CRYSTAL_CLIFFS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "crystal_cliffs")); // Tsuna
    public static final ResourceKey<Biome> DISMAL_DESERT = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "dismal_desert")); // Kai, Desert
    public static final ResourceKey<Biome> SYSTEMATIC_SHRUBLANDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_terry")); // Terry, Savanna or Badlands
    public static final ResourceKey<Biome> PETRIFYING_PLATEAU = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_lyadova")); // Lyadova, Meadow or Cherry Grove
    public static final ResourceKey<Biome> CHROMATIC_CRAGS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "chromatic_crags")); // Aella, Stony Peaks
    public static final ResourceKey<Biome> GELID_GLACIER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_jack")); // Jack, Ice Spikes or Snowy Plains, maybe Taiga
    public static final ResourceKey<Biome> SKOURAINEI = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "skourainei")); // Xanthea, Dark Forest
    public static final ResourceKey<Biome> HYPERBOLIC_HILLS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_will")); // Will, Windswept Hills or Windswept Gravel Hills
    public static final ResourceKey<Biome> FATUOUS_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "fatuous_forest")); // Matthue, Forest
    public static final ResourceKey<Biome> REGENERATIVE_RAINFOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "regenerative_rainforest")); // Alline, Jungle
    public static final ResourceKey<Biome> FERVENT_FIELD = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "fervent_field_unity")); // Madeline, Flower Forest
    public static final ResourceKey<Biome> SUBCONSCIOUS_SWAMP = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "subconscious_swamp")); // Emily, Swamp
    public static final ResourceKey<Biome> CALESCENT_CALDERA = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_adrian")); // Adrian, Unknown
    public static final ResourceKey<Biome> TRANSIENT_TERRACE = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_andrea")); // Andrea, Unknown Slope biome
    public static final ResourceKey<Biome> QUIVERING_QUARRY = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "biome_rex")); // Rex, Unknown
    public static final ResourceKey<Biome> PERFECT_PLAINS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "perfect_plains")); // Jolt, Plains
        // Other Biomes
    public static final ResourceKey<Biome> RADIANT_RIVER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "radiant_river")); // Separator biome for biome map continuity
    public static final ResourceKey<Biome> FROZEN_RADIANT_RIVER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "frozen_radiant_river")); // Separator biome for biome map continuity

        // Variants
            // ---- FERVENT FILED VARIANTS ----
    public static final ResourceKey<Biome> FERVENT_FIELD_YIN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "fervent_field_yin"));
    public static final ResourceKey<Biome> FERVENT_FIELD_YANG = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "fervent_field_yang"));



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
    public static final ResourceKey<Biome> REALMWEAVE_LANDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "realmweave_lands"));
    public static final ResourceKey<Biome> WORLD_THREAD_FLATS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "world_thread_flats"));

    public static void boostrap(BootstapContext<Biome> context) {
        // Test Biome
        context.register(TEST_BIOME, OverworldBiomeGen.testBiome(context));

        // Overworld
        context.register(STORM_WALL, OverworldBiomeGen.stormWall(context));

        // Transcendent's Plain

        //context.register(CRYSTAL_CLIFFS, TPlainBiomeGen.crystalCliffs(context));
        context.register(DISMAL_DESERT, TPlainBiomeGen.dismalDesert(context));
        //context.register(SYSTEMATIC_SHRUBLANDS, TPlainBiomeGen.systematicShrublands(context));
        //context.register(PETRIFYING_PLATEAU, TPlainBiomeGen.petrifyingPlateau(context));
        context.register(CHROMATIC_CRAGS, TPlainBiomeGen.chromaticCrags(context));
        //context.register(GELID_GLACIER, TPlainBiomeGen.gelidGlacier(context));
        context.register(SKOURAINEI, TPlainBiomeGen.skourainei(context));
        //context.register(HYPERBOLIC_HILLS, TPlainBiomeGen.hyperbolicHills(context));
        context.register(FATUOUS_FOREST, TPlainBiomeGen.fatuousForest(context));
        context.register(REGENERATIVE_RAINFOREST, TPlainBiomeGen.regenerativeRainforest(context));
        context.register(FERVENT_FIELD, TPlainBiomeGen.ferventField(context, null));
        context.register(SUBCONSCIOUS_SWAMP, TPlainBiomeGen.subconsciousSwamp(context));
        //context.register(CALESCENT_CALDERA, TPlainBiomeGen.calescentCaldera(context));
        //context.register(TRANSIENT_TERRACE, TPlainBiomeGen.transientTerrace(context));
        //context.register(QUIVERING_QUARRY, TPlainBiomeGen.quiveringQuarry(context));
        context.register(PERFECT_PLAINS, TPlainBiomeGen.perfectPlains(context));

        context.register(FERVENT_FIELD_YIN, TPlainBiomeGen.ferventField(context, "yin"));
        context.register(FERVENT_FIELD_YANG, TPlainBiomeGen.ferventField(context, "yang"));

        context.register(RADIANT_RIVER, TPlainBiomeGen.radiantRiver(context));
        context.register(FROZEN_RADIANT_RIVER, TPlainBiomeGen.frozenRadiantRiver(context));

        context.register(FROZEN_ORIGINATIVE_OCEAN, TPlainBiomeGen.frozenOriginativeOcean(context, false));
        context.register(COLD_ORIGINATIVE_OCEAN, TPlainBiomeGen.coldOriginativeOcean(context, false));
        context.register(ORIGINATIVE_OCEAN, TPlainBiomeGen.originativeOcean(context, false));
        context.register(LUKEWARM_ORIGINATIVE_OCEAN, TPlainBiomeGen.lukewarmOriginativeOcean(context, false));
        context.register(WARM_ORIGINATIVE_OCEAN, TPlainBiomeGen.warmOriginativeOcean(context));
        context.register(DEEP_FROZEN_ORIGINATIVE_OCEAN, TPlainBiomeGen.frozenOriginativeOcean(context, true));
        context.register(DEEP_COLD_ORIGINATIVE_OCEAN, TPlainBiomeGen.coldOriginativeOcean(context, true));
        context.register(DEEP_ORIGINATIVE_OCEAN, TPlainBiomeGen.originativeOcean(context, true));
        context.register(DEEP_LUKEWARM_ORIGINATIVE_OCEAN, TPlainBiomeGen.lukewarmOriginativeOcean(context, true));
        // Sky
        context.register(CUMULONIMBUS, SkyBiomeGen.cumulonimbus(context));
/*
        // Limbo
        context.register(REALMWEAVE_LANDS, LimboBiomeGen.realmweaveLands(context));
        context.register(WORLD_THREAD_FLATS, LimboBiomeGen.worldThreadFlats(context));
        */
    }

    public static void globalGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
}
