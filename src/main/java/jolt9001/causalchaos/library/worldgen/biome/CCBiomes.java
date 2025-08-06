package jolt9001.causalchaos.library.worldgen.biome;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class CCBiomes {
    // Test Biome
    public static final ResourceKey<Biome> TEST_BIOME = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "test_biome"));

    // Transcendent's Plain
        // Superboss Domains
    public static final ResourceKey<Biome> CRYSTAL_CLIFFS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_tsuna")); // Tsuna
    public static final ResourceKey<Biome> DISMAL_DESERT = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_kai")); // Kai
    public static final ResourceKey<Biome> SYSTEMATIC_SHRUBLANDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_terry")); // Terry
    public static final ResourceKey<Biome> PETRIFYING_PLATEAU = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_lyadova")); // Lyadova
    public static final ResourceKey<Biome> CHROMATIC_CRAGS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_aella")); // Aella, Similar to Stony Peaks
    public static final ResourceKey<Biome> GELID_GLACIER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_jack")); // Jack
    public static final ResourceKey<Biome> SKOURAINEI = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_xanthea")); // Xanthea, similar to Dark Forest
    public static final ResourceKey<Biome> HYPERBOLIC_HILLS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_will")); // Will
    public static final ResourceKey<Biome> FATUOUS_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_matthue")); // Matthue
    public static final ResourceKey<Biome> HALCYON_HIGHLAND = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_alline")); // Alline
    public static final ResourceKey<Biome> FERVENT_FIELD = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_madeline")); // Madeline
    public static final ResourceKey<Biome> SUBCONSCIOUS_SWAMP = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_emily")); // Emily
    public static final ResourceKey<Biome> CALESCENT_CALDERA = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_adrian")); // Adrian
    public static final ResourceKey<Biome> TRANSIENT_TERRACE = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_andrea")); // Andrea
    public static final ResourceKey<Biome> QUIVERING_QUARRY = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_rex")); // Rex
    public static final ResourceKey<Biome> PERFECT_PLAINS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_jolt")); // Jolt
        // Other Biomes
    public static final ResourceKey<Biome> RADIANT_RIVER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/radiant_river")); // Separator biome for biome map continuity

    // Sky
    public static final ResourceKey<Biome> CUMULUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/cumulus"));
    public static final ResourceKey<Biome> STRATUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/stratus"));
    public static final ResourceKey<Biome> CIRRUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/cirrus"));
    public static final ResourceKey<Biome> NIMBUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/nimbus"));
    public static final ResourceKey<Biome> CUMULONIMBUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/cumulonimbus"));

    // Limbo
    public static final ResourceKey<Biome> REALMWEAVE_LANDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "limbo/realmweave_lands"));
    public static final ResourceKey<Biome> WORLD_THREAD_FLATS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "limbo/world_thread_flats"));

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(TEST_BIOME, testBiome(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome testBiome(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        // spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

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
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                        //.backgroundMusic(Musics.createGameMusic(ModSounds.BAR_BRAWL.getHolder().get())).build())
                .build();
    }
}
