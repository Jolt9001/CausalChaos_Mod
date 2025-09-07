package jolt9001.causalchaos.library.worldgen.biome.biomegen.dimensions;

import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

import javax.annotation.Nullable;

public class TPlainBiomeGen {
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
        /*
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(ModSounds.BAR_BRAWL.getHolder().get())).build())
                .build();
        */
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

    private static Biome buildBiome(boolean pHasPercipitation, float pDownfall, float pTemperature, BiomeGenerationSettings.Builder pGenerationSettings, MobSpawnSettings.Builder pMobSpawnSettings, int pWaterColor, int pWaterFogColor, int fogColor, int skyColor, AmbientMoodSettings pAmbientMood, @Nullable Music pBackgroundMusic) {
        return buildBiome(pHasPercipitation, pTemperature, pDownfall, pGenerationSettings, pMobSpawnSettings, pWaterColor, pWaterFogColor, skyColor, null, null, fogColor, pAmbientMood, pBackgroundMusic);
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
