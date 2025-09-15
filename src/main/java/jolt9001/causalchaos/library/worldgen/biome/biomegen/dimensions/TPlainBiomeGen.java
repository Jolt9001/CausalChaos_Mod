package jolt9001.causalchaos.library.worldgen.biome.biomegen.dimensions;

import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import jolt9001.causalchaos.library.worldgen.features.vegetation.CCFoliagePlacers;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import javax.annotation.Nullable;
import java.util.Objects;

public class TPlainBiomeGen {
    protected static int calculateSkyColor(float pTemperature) {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    // ---- Superboss Domains ----
    public static Biome crystalCliffs(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome dismalDesert(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);

        return buildBiome(false, 0.0f, 2.0f, biomeBuilder, spawnBuilder, 0xe82e3b, 0xbf1b26,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome systematicShrublands(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome petrifyingPlateau(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome chromaticCrags(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        BiomeDefaultFeatures.addFrozenSprings(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);

        return buildBiome(true, 0.3F, 2.0f, biomeBuilder, spawnBuilder, 0xe82e3b, 0xbf1b26,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome gelidGlacier(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome skourainei(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return buildBiome(true, 0.8f, 0.7f, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome hyperbolicHills(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome fatuousForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome regenerativeRainforest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addJungleTrees(biomeBuilder);
        BiomeDefaultFeatures.addWarmFlowers(biomeBuilder);
        BiomeDefaultFeatures.addJungleGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addJungleGrass(biomeBuilder);
        BiomeDefaultFeatures.addJungleVines(biomeBuilder);
        BiomeDefaultFeatures.addJungleMelons(biomeBuilder);

        return buildBiome(true, 0.9F, 0.95F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }

    /**
     * This biome will have two variants.
     * @param context
     * @param variant
     * @return biome build
     */
    public static Biome ferventField(BootstapContext<Biome> context, @Nullable String variant) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        /*
        if (variant.equals("yin")) {
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.TREES_BLOOMHEART_YIN);
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.FLOWERS_YIN);
        } else if (variant.equals("yang")) {
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.TREES_BLOOMHEART_YANG);
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.FLOWERS_YANG);


        } else {*/
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_FLOWER_FOREST);
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_FLOWER_FOREST);
        //}
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome subconsciousSwamp(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);
        BiomeDefaultFeatures.addSwampVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addSwampExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);

        return buildBiome(true, 0.9F, 0.8F, biomeBuilder, spawnBuilder, 6388580, 2302743,
                0x30c918, 5011004, 6975545, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome calescentCaldera(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome transientTerrace(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome quiveringQuarry(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    /**
     * Perfect Plains Biome: spawns the structure with the strongest boss in the mod. Equivalent to the plains biome from base Minecraft.
     * @param context Biome Bootstrap Context
     */
    public static Biome perfectPlains(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // Need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        // biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PINE_PLACED_KEY);

        return buildBiome(true, 0.8f, 0.7f, biomeBuilder, spawnBuilder, 0xe82e3b, 0xbf1b26,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    // ---- Superboss Domain Variants ----

    // ---- River Biomes ----
    public static Biome radiantRiver(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addWaterTrees(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return buildBiome(true, 0.5F, 0.5F, biomeBuilder, spawnBuilder, 0x4e9204, 0x329011,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome frozenRadiantRiver(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addWaterTrees(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return buildBiome(true, 0.5F, 0.0F, biomeBuilder, spawnBuilder, 0x4e9204, 0x329011,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }

    // ---- Ocean Biomes ----
    public static BiomeGenerationSettings.Builder baseOcean(BiomeGenerationSettings.Builder biomeBuilder) {
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addWaterTrees(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return biomeBuilder;
    }

    public static Biome frozenOriginativeOcean(BootstapContext<Biome> context, boolean pIsDeep) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        float f = pIsDeep ? 0.5F : 0.0F;
        BiomeDefaultFeatures.addIcebergs(biomeBuilder);
        CCBiomes.globalGeneration(biomeBuilder);
        baseOcean(biomeBuilder);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(f)
                .temperatureAdjustment(Biome.TemperatureModifier.FROZEN)
                .downfall(0.5F)
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(3750089)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(f))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build()).mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();

    }
    public static Biome coldOriginativeOcean(BootstapContext<Biome> context, boolean pIsDeep) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));


        CCBiomes.globalGeneration(biomeBuilder);
        baseOcean(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, pIsDeep ? AquaticPlacements.SEAGRASS_DEEP_COLD : AquaticPlacements.SEAGRASS_COLD);
        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder);
        BiomeDefaultFeatures.addColdOceanExtraVegetation(biomeBuilder);

        return buildBiome(true, 0.5F, 0.5F, biomeBuilder, spawnBuilder, 4020182, 0x329011,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome originativeOcean(BootstapContext<Biome> context, boolean pIsDeep) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        baseOcean(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, pIsDeep ? AquaticPlacements.SEAGRASS_DEEP : AquaticPlacements.SEAGRASS_NORMAL);
        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder);
        BiomeDefaultFeatures.addColdOceanExtraVegetation(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome lukewarmOriginativeOcean(BootstapContext<Biome> context, boolean pIsDeep) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        baseOcean(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, pIsDeep ? AquaticPlacements.SEAGRASS_DEEP_WARM : AquaticPlacements.SEAGRASS_WARM);
        if (pIsDeep) {
            BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder);
        }
        BiomeDefaultFeatures.addLukeWarmKelp(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome warmOriginativeOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        baseOcean(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        BiomeDefaultFeatures.addDefaultSeagrass(biomeBuilder);
        BiomeDefaultFeatures.addColdOceanExtraVegetation(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4e9204, 0x4e9204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    /*
    public static Biome deepFrozenOriginativeOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        baseOcean(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4159204, 0x4159204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome deepColdOriginativeOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        baseOcean(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4159204, 0x4159204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome deepOriginativeOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        baseOcean(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4159204, 0x4159204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome deepLukewarmOriginativeOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        baseOcean(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x4159204, 0x4159204,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    */

    private static Biome buildBiome(boolean pHasPercipitation, float pDownfall, float pTemperature, BiomeGenerationSettings.Builder pGenerationSettings,
                                    MobSpawnSettings.Builder pMobSpawnSettings, int pWaterColor, int pWaterFogColor, int pSkyColor,
                                    int pFogColor, AmbientMoodSettings pAmbientMood, @Nullable Music pBackgroundMusic) {
        return buildBiome(pHasPercipitation, pTemperature, pDownfall, pGenerationSettings, pMobSpawnSettings, pWaterColor,
                pWaterFogColor, pSkyColor, null, null, pFogColor, pAmbientMood, pBackgroundMusic);
    }

    private static Biome buildBiome(boolean pHasPrecipitation, float pDownfall, float pTemperature, BiomeGenerationSettings.Builder pGenerationSettings,
                                    MobSpawnSettings.Builder pMobSpawnSettings, int pWaterColor, int pWaterFogColor, int pSkyColor,
                                    @Nullable Integer pGrassColorOverride, @Nullable Integer pFoliageColorOverride, int pFogColor,
                                    AmbientMoodSettings pAmbientMood, @Nullable Music pBackgroundMusic) {
        BiomeSpecialEffects.Builder specialEffects = (new BiomeSpecialEffects.Builder())
                .waterColor(pWaterColor)
                .waterFogColor(pWaterFogColor)
                .skyColor(pSkyColor)
                .fogColor(pFogColor)
                .ambientMoodSound(pAmbientMood)
                .backgroundMusic(pBackgroundMusic);
        if (pGrassColorOverride != null) specialEffects.grassColorOverride(pGrassColorOverride);
        if (pFoliageColorOverride != null) specialEffects.foliageColorOverride(pFoliageColorOverride);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(pHasPrecipitation)
                .downfall(pDownfall)
                .temperature(pTemperature)
                .generationSettings(pGenerationSettings.build())
                .mobSpawnSettings(pMobSpawnSettings.build())
                .specialEffects(specialEffects.build())
                .build();
    }
}
