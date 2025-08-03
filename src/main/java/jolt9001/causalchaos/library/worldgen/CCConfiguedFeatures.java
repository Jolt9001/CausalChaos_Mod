package jolt9001.causalchaos.library.worldgen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.datagen.tags.BlockTagGenerator;
import jolt9001.causalchaos.init.CCBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class CCConfiguedFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_COBALT_ORE_KEY = registerKey("cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_IRIDIUM_ORE_KEY = registerKey("iridium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_NEODYMIUM_ORE_KEY = registerKey("neodymium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PALLADIUM_ORE_KEY = registerKey("palladium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TITANIUM_ORE_KEY = registerKey("titanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TUNGSTEN_ORE_KEY = registerKey("tungsten_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TRANSCENDENT_COBALT_ORE_KEY = registerKey("transcendent_cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TRANSCENDENT_IRIDIUM_ORE_KEY = registerKey("transcendent_iridium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TRANSCENDENT_NEODYMIUM_ORE_KEY = registerKey("transcendent_neodymium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TRANSCENDENT_PALLADIUM_ORE_KEY = registerKey("transcendent_palladium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TRANSCENDENT_TITANIUM_ORE_KEY = registerKey("transcendent_titanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TRANSCENDENT_TUNGSTEN_ORE_KEY = registerKey("transcendent_tungsten_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_ANTHRACITE_ORE_KEY = registerKey("anthracite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_MAGNETITE_ORE_KEY = registerKey("magnetite_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest finalReplaceables = new TagMatchTest(BlockTagGenerator.FINAL_ORES_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldCobaltOres = List.of(
                OreConfiguration.target(stoneReplaceable, CCBlocks.COBALT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CCBlocks.DEEPSLATE_COBALT_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldIridiumOres = List.of(
                OreConfiguration.target(stoneReplaceable, CCBlocks.IRIDIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CCBlocks.DEEPSLATE_IRIDIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldNeodymiumOres = List.of(
                OreConfiguration.target(stoneReplaceable, CCBlocks.NEODYMIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldPalladiumOres = List.of(
                OreConfiguration.target(stoneReplaceable, CCBlocks.PALLADIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CCBlocks.DEEPSLATE_PALLADIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldTitaniumOres = List.of(
                OreConfiguration.target(stoneReplaceable, CCBlocks.TITANIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CCBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldTungstenOres = List.of(
                OreConfiguration.target(stoneReplaceable, CCBlocks.TUNGSTEN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState()));

        /* ORES IN ORDER OF RARITY
        Anthracite: 30 blobs per chunk in Sky Islands, blob size 17
        Magnetite: 10 blobs per chunk in Sky Islands, blob size 9
        Neodymium: 9 blobs per chunk, blob size 9 (Overworld); 18 blobs per chunk, blob size 13 (Transcendent's Plain)
        Cobalt: 8 blobs per chunk, blob size 7 (Overworld); 17 blobs per chunk, blob size 11 (Transcendent's Plain)
        Titanium: 7 blobs per chunk, blob size 6 (Overworld); 16 blobs per chunk, blob size 10 (Transcendent's Plain)
        Tungsten: 5 blobs per chunk, blob size 6 (Overworld); 14 blobs per chunk, blob size 10 (Transcendent's Plain)
        Palladium: 3 blobs per chunk in Overworld, blob size 5 (Overworld); 12 blobs per chunk, blob size 9 (Transcendent's Plain)
        Iridium: 1 blob per chunk in Overworld, blob size 4 (Overworld); 10 blobs per chunk, blob size 8 (Transcendent's Plain)
        */

        register(context, OVERWORLD_NEODYMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNeodymiumOres, 9));
        register(context, OVERWORLD_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCobaltOres, 7));
        register(context, OVERWORLD_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 9));
        register(context, OVERWORLD_TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTungstenOres, 6));
        register(context, OVERWORLD_PALLADIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPalladiumOres, 5));
        register(context, OVERWORLD_IRIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldIridiumOres, 4));
/*
        register(context, SKY_ANTHRACITE_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceable, CCBlocks.ANTHRACITE_ORE.get().defaultBlockState(), 17));
        register(context, SKY_MAGNETITE_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceable, CCBlocks.MAGNETITE_ORE.get().defaultBlockState(), 9));

        register(context, TRANSCENDENT_NEODYMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(finalReplaceables, CCBlocks.TRANSCENDENT_NEODYMIUM_ORE.get().defaultBlockState(), 13));
        register(context, TRANSCENDENT_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(finalReplaceables, CCBlocks.TRANSCENDENT_COBALT_ORE.get().defaultBlockState(), 11));
        register(context, TRANSCENDENT_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(finalReplaceables, CCBlocks.TRANSCENDENT_TITANIUM_ORE.get().defaultBlockState(), 10));
        register(context, TRANSCENDENT_TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(finalReplaceables, CCBlocks.TRANSCENDENT_TUNGSTEN_ORE.get().defaultBlockState(), 10));
        register(context, TRANSCENDENT_PALLADIUM_ORE_KEY, Feature.ORE, new OreConfiguration(finalReplaceables, CCBlocks.TRANSCENDENT_PALLADIUM_ORE.get().defaultBlockState(), 9));
        register(context, TRANSCENDENT_IRIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(finalReplaceables, CCBlocks.TRANSCENDENT_IRIDIUM_ORE.get().defaultBlockState(), 8));

 */
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CausalChaos.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
