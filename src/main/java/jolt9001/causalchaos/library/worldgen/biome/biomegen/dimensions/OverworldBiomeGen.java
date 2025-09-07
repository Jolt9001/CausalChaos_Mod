package jolt9001.causalchaos.library.worldgen.biome.biomegen.dimensions;

import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class OverworldBiomeGen {
    public static Biome testBiome(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        // we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures as such:
        /*
        * addDefaultCarversAndLakes
        * addDefaultMonsterRoom
        * addDefaultUndergroundVariety
        * addDripstone
        * addSculk
        * addDefaultOres
        * addExtraGold
        * addExtraEmeralds
        * addInfestedStone
        * addDefaultSoftDisks
        * addSwampClayDisk
        * addMangroveSwampDisks
        * addMossyStoneBlock
        * addFerns
        * addRareBerryBushes
        * addCommonBerryBushes
        * addLightBambooVegetation
        * addBambooVegetation
        * addTaigaTrees
        * addGroveTrees
        * addWaterTrees
        * addBirchTrees
        * addOtherBirchTrees
        * addTallBirchTrees
        * addSavannaTrees
        * addShatteredSavannaTrees
        * addLushCavesVegetationFeatures
        * addLushCavesSpecialOres
        * addMountainTrees
        * addMountainForestTrees
        * addJungleTrees
        * addSparseJungleTrees
        * addBadlandsTrees
        * addSnowyTrees
        * addJungleGrass
        * addSavannaGrass
        * addShatteredSavannaGrass
        * addSavannaExtraGrass
        * addBadlandGrass
        * addForestFlowers
        * addForestGrass
        * addSwampVegetation
        * addMangroveSwampVegetation
        * addMushroomFieldVegetation
        * addPlainVegetation
        * addDesertVegetation
        * addGiantTaigaVegetation
        * addDefaultFlowers
        * addCherryGroveVegetation
        * addMeadowVegetation
        * addWarmFlowers
        * addDefaultGrass
        * addTaigaGrass
        * addPlainGrass
        * addDefaultMushrooms
        * addDefaultExtraVegetation
        * addBadlandExtraVegetation
        * addJungleMelons
        * addSparseJungleMelons
        * addJungleVines
        * addDesertExtraVegetation
        * addSwampExtraVegetation
        * addDesertExtraDecoration
        * addFossilDecoration
        * addColdOceanExtraVegetation
        * addDefaultSeagrass
        * addLukeWarmKelp
        * addDefaultSprings
        * addFrozenSprings
        * addIcebergs
        * addBlueIce
        * addSurfaceFreezing
        * addNetherDefaultOres
        * addAncientDebris
        * addDefaultCrystalFormations
        * farmAnimals
        * caveSpawns
        * commonSpawns
        * oceanSpawns
        * warmOceanSpawns
        * plainsSpawns
        * snowySpawns
        * desertSpawns
        * dripstoneCavesSpawns
        * monsters
        * mooshroomSpawns
        * baseJungleSpawns
        * endSpawns
        */
        CCBiomes.globalGeneration(biomeBuilder);
        //BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        // biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PINE_PLACED_KEY);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x24423a)
                        .grassColorOverride(0x8ab689)
                        .foliageColorOverride(0x6da36b)
                        .fogColor(0x8cd093)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                //.backgroundMusic(Musics.createGameMusic(ModSounds.BAR_BRAWL.getHolder().get())).build())
                .build();
    }

    // USE SEED 5869176929701707854 WHEN TESTING STORM WALL BIOME
    public static Biome stormWall(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE),
                        context.lookup(Registries.CONFIGURED_CARVER));

        CCBiomes.globalGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x24423a)
                        .grassColorOverride(0x8ab689)
                        .foliageColorOverride(0x6da36b)
                        .fogColor(0x8cd093)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                //.backgroundMusic(Musics.createGameMusic(ModSounds.BAR_BRAWL.getHolder().get())).build())
                .build();
    }
}