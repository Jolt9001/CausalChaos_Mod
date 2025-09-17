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
    public static final ResourceKey<Biome> SYSTEMATIC_SHRUBLANDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "systematic_shrublands")); // Terry, Savanna
    public static final ResourceKey<Biome> PETRIFYING_PLATEAU = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "petrifying_plateay")); // Lyadova, Cherry Grove
    public static final ResourceKey<Biome> CHROMATIC_CRAGS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "chromatic_crags")); // Aella, Stony Peaks
    public static final ResourceKey<Biome> GELID_GLACIER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "gelid_glacier")); // Jack, Ice Spikes ond snowy slopes
    public static final ResourceKey<Biome> SKOURAINEI = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "skourainei")); // Xanthea, Dark Forest
    public static final ResourceKey<Biome> HYPERBOLIC_HILLS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "hyperbolic_hills")); // Will, Windswept Hills
    public static final ResourceKey<Biome> FATUOUS_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "fatuous_forest")); // Matthue, Forest
    public static final ResourceKey<Biome> REGENERATIVE_RAINFOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "regenerative_rainforest")); // Alline, Jungle
    public static final ResourceKey<Biome> FERVENT_FIELD = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "fervent_field")); // Madeline, Flower Forest
    public static final ResourceKey<Biome> SUBCONSCIOUS_SWAMP = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "subconscious_swamp")); // Emily, Swamp
    public static final ResourceKey<Biome> CALESCENT_CALDERA = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "calescent_caldera")); // Adrian, Badlands
    public static final ResourceKey<Biome> TRANSIENT_TAIGA = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "transient_taiga")); // Andrea, Taiga
    public static final ResourceKey<Biome> QUIVERING_QUARRY = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "quivering_quarry")); // Rex, Windswept Gravel Hills
    public static final ResourceKey<Biome> PERFECT_PLAINS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "perfect_plains")); // Jolt, Plains
        // Other Biomes
    public static final ResourceKey<Biome> RADIANT_RIVER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "radiant_river")); // Separator biome for biome map continuity
    public static final ResourceKey<Biome> FROZEN_RADIANT_RIVER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "frozen_radiant_river")); // Separator biome for biome map continuity

        // Variants
            // ---- FERVENT FILED VARIANTS ----
    public static final ResourceKey<Biome> FERVENT_FIELD_YIN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "fervent_field_yin"));
    public static final ResourceKey<Biome> FERVENT_FIELD_YANG = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "fervent_field_yang"));
    public static final ResourceKey<Biome> FERVENT_FIELD_UNITY = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "fervent_field_unity"));



        // Oceans
    public static final ResourceKey<Biome> FROZEN_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "frozen_originative_ocean"));
    public static final ResourceKey<Biome> COLD_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "cold_originative_ocean"));
    public static final ResourceKey<Biome> ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "originative_ocean"));
    public static final ResourceKey<Biome> LUKEWARM_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "lukewarm_originative_ocean"));
    public static final ResourceKey<Biome> WARM_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "warm_originative_ocean"));
    public static final ResourceKey<Biome> DEEP_FROZEN_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "deep_frozen_originative_ocean"));
    public static final ResourceKey<Biome> DEEP_COLD_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "deep_cold_originative_ocean"));
    public static final ResourceKey<Biome> DEEP_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "deep_originative_ocean"));
    public static final ResourceKey<Biome> DEEP_LUKEWARM_ORIGINATIVE_OCEAN = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "deep_lukewarm_originative_ocean"));

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
        context.register(CRYSTAL_CLIFFS, TPlainBiomeGen.crystalCliffs(context)); // Stony Shore
        // Beach
        // Snowy Beach
        context.register(DISMAL_DESERT, TPlainBiomeGen.dismalDesert(context)); // Desert
        context.register(SYSTEMATIC_SHRUBLANDS, TPlainBiomeGen.systematicShrublands(context)); // Savanna
        // Savanna Plateau
        // Windswept Savanna
        context.register(PETRIFYING_PLATEAU, TPlainBiomeGen.petrifyingPlateau(context)); // Cherry Grove
        // Meadow
        context.register(CHROMATIC_CRAGS, TPlainBiomeGen.chromaticCrags(context)); // Jagged Peaks
        // Frozen Peaks
        // Stony Peaks
        context.register(GELID_GLACIER, TPlainBiomeGen.gelidGlacier(context)); // Snowy Slopes + Ice Spikes
        context.register(SKOURAINEI, TPlainBiomeGen.skourainei(context)); // Dark Forest
        context.register(HYPERBOLIC_HILLS, TPlainBiomeGen.hyperbolicHills(context)); // Windswept Hills
        context.register(FATUOUS_FOREST, TPlainBiomeGen.fatuousForest(context)); // Forest
        // Windswept Forest
        // Birch Forest
        // Old Growth Birch Forest
        context.register(REGENERATIVE_RAINFOREST, TPlainBiomeGen.regenerativeRainforest(context)); // Jungle
        // Sparse Jungle
        // Bamboo Jungle
        context.register(FERVENT_FIELD, TPlainBiomeGen.ferventField(context, "null")); // Flower Forest
        context.register(SUBCONSCIOUS_SWAMP, TPlainBiomeGen.subconsciousSwamp(context)); // Swamp
        // Mangrove Swamp
        context.register(CALESCENT_CALDERA, TPlainBiomeGen.calescentCaldera(context)); // Badlands
        // Wooded Badlands
        // Eroded Badlands
        context.register(TRANSIENT_TAIGA, TPlainBiomeGen.transientTerrace(context)); // Snowy Taiga
        // Taiga
        // Old growth Spruce
        // Old Growth Pine
        context.register(QUIVERING_QUARRY, TPlainBiomeGen.quiveringQuarry(context)); // Windswept Gravelly Hills
        context.register(PERFECT_PLAINS, TPlainBiomeGen.perfectPlains(context)); // Plains
        // Snowy Plains
        // Sunflower Plains

        context.register(FERVENT_FIELD_YIN, TPlainBiomeGen.ferventField(context, "yin"));
        context.register(FERVENT_FIELD_YANG, TPlainBiomeGen.ferventField(context, "yang"));
        context.register(FERVENT_FIELD_UNITY, TPlainBiomeGen.ferventField(context, "unity"));

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
