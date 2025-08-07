package jolt9001.causalchaos.library.worldgen.dimension;

import com.mojang.datafixers.util.Pair;
import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;
import java.util.OptionalLong;

public class CCDimensions {
    //@Deprecated
    public static final int SEALEVEL = 0;

    // Sky Islands
    public static final ResourceLocation DIMENSION_SKY = CausalChaos.prefix("sky");
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_SKY = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_SKY);
    public static final ResourceKey<Level> DIMENSION_KEY_SKY = ResourceKey.create(Registries.DIMENSION, DIMENSION_SKY);
    public static final ResourceKey<DimensionType> SKY_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "sky_dim_type"));

    // Limbo
    public static final ResourceLocation DIMENSION_LIMBO = CausalChaos.prefix("limbo");
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_LIMBO = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_LIMBO);
    public static final ResourceKey<Level> DIMENSION_KEY_LIMBO = ResourceKey.create(Registries.DIMENSION, DIMENSION_LIMBO);
    public static final ResourceKey<DimensionType> LIMBO_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "limbo_dim_type"));

    // Transcendent's Plain
    public static final ResourceLocation DIMENSION_FINAL = CausalChaos.prefix("final");
    public static final ResourceKey<LevelStem> FINAL_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(CausalChaos.MODID, "final"));
    public static final ResourceKey<Level> FINAL_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(CausalChaos.MODID, "final"));
    public static final ResourceKey<DimensionType> FINAL_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "final_dim_type"));

    // Parallel Universes
    public static final ResourceLocation DIMENSION_PARALLEL = CausalChaos.prefix("parallel"); //
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_PARALLEL = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_PARALLEL);
    public static final ResourceKey<Level> DIMENSION_KEY_PARALLEL = ResourceKey.create(Registries.DIMENSION, DIMENSION_PARALLEL);
    public static final ResourceKey<DimensionType> PARALLEL_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "parallel_dim_type"));

    public static void bootstrapTypeFinal(BootstapContext<DimensionType> context) {
        context.register(FINAL_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), // fixedTime
                false, // hasSkylight
                false, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.0, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, // effectsLocation
                1.0f, // ambientLight
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }

    public static void bootstrapStemFinal(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(CCBiomes.TEST_BIOME)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(Pair.of(
                                        Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(CCBiomes.TEST_BIOME)),
                                Pair.of(
                                        Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.BIRCH_FOREST)),
                                Pair.of(
                                        Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.OCEAN)),
                                Pair.of(
                                        Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.DARK_FOREST))

                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));
        LevelStem stem = new LevelStem(dimTypes.getOrThrow(CCDimensions.FINAL_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(FINAL_KEY, stem);
    }
}
