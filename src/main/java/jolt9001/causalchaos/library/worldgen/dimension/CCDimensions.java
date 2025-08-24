package jolt9001.causalchaos.library.worldgen.dimension;

import com.mojang.datafixers.util.Pair;
import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import net.minecraft.core.Holder;
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
import net.minecraft.world.level.dimension.DimensionDefaults;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.minecraft.world.level.levelgen.presets.WorldPresets;

import java.util.List;
import java.util.OptionalLong;

public class CCDimensions {
    //@Deprecated
    public static final int SEALEVEL = 0;

    // Sky Islands
    public static final ResourceKey<LevelStem> SKY_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(CausalChaos.MODID, "sky"));
    public static final ResourceKey<Level> SKY_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(CausalChaos.MODID, "sky"));
    public static final ResourceKey<DimensionType> SKY_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "sky_dim_type"));

    // Limbo
    public static final ResourceLocation DIMENSION_LIMBO = CausalChaos.prefix("limbo");
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_LIMBO = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_LIMBO);
    public static final ResourceKey<Level> DIMENSION_KEY_LIMBO = ResourceKey.create(Registries.DIMENSION, DIMENSION_LIMBO);
    public static final ResourceKey<DimensionType> LIMBO_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "limbo_dim_type"));

    // Transcendent's Plain
    public static final ResourceKey<LevelStem> TPLAIN_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(CausalChaos.MODID, "tplain"));
    public static final ResourceKey<Level> TPLAIN_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(CausalChaos.MODID, "tplain"));
    public static final ResourceKey<DimensionType> TPLAIN_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "tplain_dim_type"));

    // Parallel Universes
    public static final ResourceLocation DIMENSION_PARALLEL = CausalChaos.prefix("parallel"); //
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_PARALLEL = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_PARALLEL);
    public static final ResourceKey<Level> DIMENSION_KEY_PARALLEL = ResourceKey.create(Registries.DIMENSION, DIMENSION_PARALLEL);
    public static final ResourceKey<DimensionType> PARALLEL_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "parallel_dim_type"));

    public static void bootstrapTypeTPlain(BootstapContext<DimensionType> context) {
        context.register(TPLAIN_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), false, false, false, false,
                1.0, true, false, -64, 320, 320,
                BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 1.0f,
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }
    public static void bootstrapStemTPlain(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(CCBiomes.TEST_BIOME)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
                                Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(CCBiomes.TEST_BIOME)),
                                Pair.of(Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.BIRCH_FOREST)),
                                Pair.of(Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.OCEAN)),
                                Pair.of(Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeRegistry.getOrThrow(Biomes.DARK_FOREST))
                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));
        LevelStem stem = new LevelStem(dimTypes.getOrThrow(CCDimensions.TPLAIN_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(TPLAIN_KEY, stem);
    }

    public static void bootstrapTypeSky(BootstapContext<DimensionType> context) {
        context.register(SKY_DIM_TYPE, new DimensionType(
                OptionalLong.empty(), false, false, false, false, 1.0,
                true, false, -64, 320, 320, BlockTags.INFINIBURN_OVERWORLD,
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, 1.0f,
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)
        ));
    }
    public static void bootstrapStemSky(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);
        HolderGetter<MultiNoiseBiomeSourceParameterList> parameterList = context.lookup(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST);

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromPreset(parameterList.getOrThrow(MultiNoiseBiomeSourceParameterLists.OVERWORLD)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.FLOATING_ISLANDS));
        LevelStem stem = new LevelStem(dimTypes.getOrThrow(CCDimensions.SKY_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(SKY_KEY, stem);
    }
}
