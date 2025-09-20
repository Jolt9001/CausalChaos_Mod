package jolt9001.causalchaos.library.worldgen.dimension;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import jolt9001.causalchaos.library.worldgen.biome.selector.CCTPlainBiomeBuilder;
import jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.sources.FerventFieldBiomeSource;
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
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;

import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;

import static jolt9001.causalchaos.CausalChaos.LOGGER;

public class CCDimensions {
    //@Deprecated
    public static final int SEALEVEL = 0;

    // Sky Islands
    public static final ResourceKey<LevelStem> SKY_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(CausalChaos.MODID, "sky"));
    public static final ResourceKey<Level> SKY_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(CausalChaos.MODID, "sky"));
    public static final ResourceKey<DimensionType> SKY_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "sky_dim_type"));

    // Limbo
    public static final ResourceKey<LevelStem> LIMBO_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(CausalChaos.MODID, "limbo"));
    public static final ResourceKey<Level> LIMBO_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(CausalChaos.MODID, "limbo"));
    public static final ResourceKey<DimensionType> LIMBO_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "limbo_dim_type"));

    // Transcendent's Plain
    public static final ResourceKey<LevelStem> TPLAIN_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(CausalChaos.MODID, "tplain"));
    public static final ResourceKey<Level> TPLAIN_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(CausalChaos.MODID, "tplain"));
    public static final ResourceKey<DimensionType> TPLAIN_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "tplain_dim_type"));

    // Parallel Universes
    public static final ResourceKey<LevelStem> PARALLEL_KEY = ResourceKey.create(Registries.LEVEL_STEM, new ResourceLocation(CausalChaos.MODID, "parallel"));
    public static final ResourceKey<Level> PARALLEL_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation(CausalChaos.MODID, "parallel"));
    public static final ResourceKey<DimensionType> PARALLEL_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(CausalChaos.MODID, "parallel_dim_type"));

    public static void bootstrapTypeTPlain(BootstapContext<DimensionType> context) {
        context.register(TPLAIN_DIM_TYPE, new DimensionType(
                OptionalLong.of(12000), true, false, false, false,
                1.0, true, false, -64, 320, 320,
                BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 1.0f,
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(0), 0)));
    }
    public static void bootstrapStemTPlain(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeGetter = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        ImmutableList.Builder<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder = new ImmutableList.Builder<>();
        new CCTPlainBiomeBuilder().addBiomes(builder::add);
        List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> list = builder.build();
        List<Pair<Climate.ParameterPoint, Holder<Biome>>> holder = convert(list, biomeGetter);

        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(/*holder*/ // Uncomment when all biomes are complete
                        List.of(
                                Pair.of(Climate.parameters(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F), biomeGetter.getOrThrow(CCBiomes.FERVENT_FIELD)),
                                Pair.of(Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeGetter.getOrThrow(Biomes.BIRCH_FOREST)),
                                Pair.of(Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeGetter.getOrThrow(Biomes.OCEAN)),
                                Pair.of(Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeGetter.getOrThrow(Biomes.DARK_FOREST))
                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.LARGE_BIOMES));

        Climate.Parameter FULL = Climate.Parameter.span(-1.0F, 1.0F);

        BiomeSource base = MultiNoiseBiomeSource.createFromList(
                new Climate.ParameterList<>(
                List.of(
                    Pair.of(Climate.parameters(FULL, FULL, FULL, FULL, FULL, FULL, 0.0F), biomeGetter.getOrThrow(CCBiomes.FERVENT_FIELD)),
                    Pair.of(Climate.parameters(0.1F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F), biomeGetter.getOrThrow(Biomes.BIRCH_FOREST)),
                    Pair.of(Climate.parameters(0.3F, 0.6F, 0.1F, 0.1F, 0.0F, 0.0F, 0.0F), biomeGetter.getOrThrow(Biomes.OCEAN)),
                    Pair.of(Climate.parameters(0.4F, 0.3F, 0.2F, 0.1F, 0.0F, 0.0F, 0.0F), biomeGetter.getOrThrow(Biomes.DARK_FOREST))
        )));

        // --- Wrap the base with your spiral/variant picker ---
        BiomeSource masked = new FerventFieldBiomeSource(
                base,
                biomeGetter.getOrThrow(CCBiomes.FERVENT_FIELD),                   // placeholder to intercept
                biomeGetter.getOrThrow(CCBiomes.FERVENT_FIELD_YIN),               // Yin biome
                biomeGetter.getOrThrow(CCBiomes.FERVENT_FIELD_YANG),              // Yang biome
                biomeGetter.getOrThrow(CCBiomes.FERVENT_FIELD_UNITY),             // Unity biome
                TPLAIN_LEVEL_KEY                                                  // dimension key for seeding
        );

        // NOTE: your FerventFieldBiomeSource#getNoiseBiome should:
        // - check if baseHold.is(CCBiomes.FERVENT_FIELD)
        // - convert (x,z) -> block coords (x<<2, z<<2)
        // - classify to Yin/Yang/Unity using the spiral
        // - otherwise return baseHold

        NoiseBasedChunkGenerator gen = new NoiseBasedChunkGenerator(
                masked, noiseGenSettings.getOrThrow(NoiseGeneratorSettings.LARGE_BIOMES) // or your custom settings
        );

        LOGGER.info("TPlain biome source = {}", gen.getBiomeSource().getClass().getName());

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(CCDimensions.TPLAIN_DIM_TYPE), gen);
        //LevelStem stem = new LevelStem(dimTypes.getOrThrow(CCDimensions.TPLAIN_DIM_TYPE), noiseBasedChunkGenerator);

        context.register(TPLAIN_KEY, stem);
    }
    public static List<Pair<Climate.ParameterPoint, Holder<Biome>>> convert(List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> inputList, HolderGetter<Biome> biomeGetter) {
        return inputList.stream()
                .map(pair -> {
                    Climate.ParameterPoint parameterPoint = pair.getFirst();
                    ResourceKey<Biome> biomeKey = pair.getSecond();
                    Holder<Biome> biomeHolder = biomeGetter.getOrThrow(biomeKey);
                    return Pair.of(parameterPoint, biomeHolder);
                })
                .collect(Collectors.toList());
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
