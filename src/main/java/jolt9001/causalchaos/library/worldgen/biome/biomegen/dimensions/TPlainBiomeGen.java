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
    protected static final int NORMAL_WATER_COLOR = 0x3f76e4;
    protected static final int NORMAL_WATER_FOG_COLOR = 0x329011;
    private static final int OVERWORLD_FOG_COLOR = 0xc0d8ff;

    protected static int calculateSkyColor(float pTemperature) {
        float color = pTemperature / 3.0F;
        color = Mth.clamp(color, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - color * 0.05F, 0.5F + color * 0.1F, 1.0F);
    }

    // ---- Superboss Domains ----

    /**
     *
     * @param context
     * @return
     */
    public static Biome crystalCliffs(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome petrifyingPlateau(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.3F, 2.0f, biomeBuilder, spawnBuilder, 0x3f76e4, 0xbf1b26,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome gelidGlacier(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.8f, 0.7f, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome hyperbolicHills(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.9F, 0.95F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }

    // Behold: the Holy Javadoc comment
    /**
     * The Fervent Field Biome will have three variants as follows -
     * <div style="color: black;"><b>Yin Variant:</b></div>
     * Scary but safe. Muted colors, vibrant flowers. Flowers occasionally give positive effects such as resistance
     * and regeneration when collected or walked on.
     * <div style="color: 7a8aa9;">Water -> muted steel blue</div>
     * <div style="color: 446a37;">Water Fog -> dark mossy green</div>
     * <div style="color: a1b9d7;">Sky -> pale, washed blue-gray</div>
     * <div style="color: 85a179;">Grass -> dusty sage green</div>
     * <div style="color: 668856;">Foliage -> muted olive green</div>
     * <div style="color: 5d90ab;">Fog -> desaturated teal-gray</div>
     * <div style="color: white;"><b>Yang Variant:</b></div>
     * Beautiful but dangerous. Oversaturated colors, muted flowers. The flowers in this variant are poisonous
     * and often toxic. Players should expect to be constantly poisoned.
     * <div style="color: 2f71f4;">Water -> saturated bright blue</div>
     * <div style="color: 2d9a07;">Water Fog -> neon grassy green</div>
     * <div style="color: 79b4ff;">Sky -> vivid light blue</div>
     * <div style="color: 6ae634;">Grass -> neon lime</div>
     * <div style="color: 4fcb13;">Foliage -> strong chartreuse</div>
     * <div style="color: 13a5f5;">Fog -> tropical aqua-blue</div>
     * <div style="color: gray;"><b>Unity Variant:</b></div>
     * A combination of the two variants. Colors are an average between the two variants. Arguably the most
     * dangerous variant due to the poisonous plants intermingling with the safe ones.
     * <div style="color: 3f76e4;">Water -> bright medium blue</div>
     * <div style="color: 329011;">Water Fog -> vivid grass green</div>
     * <div style="color: 8db6eb;">Sky -> medium soft blue</div>
     * <div style="color: 79c05a;">Grass -> healthy mid-green</div>
     * <div style="color: 59ae30;">Foliage -> strong leaf green</div>
     * <div style="color: 22a1e6;">Fog -> electric cyan</div>
     * @param context bootstrap context
     * @param variant variant string
     * @return buildBiome(boolean hasPrecipitation, float downfall, float temperature, BiomeGenerationSettings.Builder, MobSpawnSettings.Builder, int waterColor, int waterFogColor, int skyColor, int grassColor, int foliageColor, int fogColor, AmbientMoodSettings ambience, Music backgroundMusic)
     */
    public static Biome ferventField(BootstapContext<Biome> context, String variant) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        int waterColor = 0x3f76e4;
        int waterFogColor = 0x329011;
        int skyColor = 0x8db6eb;
        int grassColor = 0x79c05a;
        int foliageColor = 0x59ae30;
        int fogColor = 0x22a1e6;

        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        switch (variant) {
            case "yin" -> { // scary but safe
                // biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.TREES_BLOOMHEART_YIN); // Uncomment these when te FoliagePlacers are complete
                // biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.FLOWERS_YIN);
                waterColor = 0x7a8aa9;
                waterFogColor = 0x446a37;
                skyColor = 0xa1b9d7;
                grassColor = 0x85a179;
                foliageColor = 0x668856;
                fogColor = 0x5d90ab;
            }
            case "yang" -> { // beautiful but dangerous
                // biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.TREES_BLOOMHEART_YANG);
                // biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.FLOWERS_YANG);
                waterColor = 0x2f71f4;
                waterFogColor = 0x2d9a07;
                skyColor = 0x79b4ff;
                grassColor = 0x6ae634;
                foliageColor = 0x4fcb13;
                fogColor = 0x13a5f5;
            }
            case "unity" -> { // Both variants unified
                //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.TREES_BLOOMHEART_UNITY);
                //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.FLOWERS_YIN);
                //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.FLOWERS_YANG);
                //biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CCFoliagePlacers.FLOWERS_UNITY);
            }
            default -> {
                biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_FLOWER_FOREST);
                biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_FLOWER_FOREST);
                /*
                Default to vanilla flower forest
                 */
            }
        }
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, waterColor, waterFogColor,
                skyColor, grassColor, foliageColor, fogColor, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
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

        return buildBiome(true, 0.9F, 0.8F, biomeBuilder, spawnBuilder, 0x617b64, 0x232317,
                0x30c918, 0x4c763c, 6975545, 0x6a7039, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome calescentCaldera(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome transientTerrace(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
                0x30c918, 0x7f03fc, 0xd203fc, 0x22a1e6, AmbientMoodSettings.LEGACY_CAVE_SETTINGS, null);
    }
    public static Biome quiveringQuarry(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.5F, 0.5F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.5F, 0.0F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.5F, 0.5F, biomeBuilder, spawnBuilder, 0x3d57d6, 0x329011,
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

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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

        return buildBiome(true, 0.8F, 0.7F, biomeBuilder, spawnBuilder, 0x3f76e4, 0x329011,
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
