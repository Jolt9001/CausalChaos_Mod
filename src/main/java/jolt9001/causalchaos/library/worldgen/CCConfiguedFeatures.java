package jolt9001.causalchaos.library.worldgen;

import jolt9001.causalchaos.CausalChaos;
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
    public static final ResourceKey<ConfiguredFeature<?, ?>> SKY_AMAGNETITE_ORE_KEY = registerKey("magnetite_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

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

        register(context, OVERWORLD_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCobaltOres, 9));
        register(context, OVERWORLD_IRIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldIridiumOres, 9));
        register(context, OVERWORLD_NEODYMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNeodymiumOres, 9));
        register(context, OVERWORLD_PALLADIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPalladiumOres, 9));
        register(context, OVERWORLD_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 9));
        register(context, OVERWORLD_TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTungstenOres, 9));

        register(context, SKY_AMAGNETITE_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceable, CCBlocks.ANTHRACITE_ORE.get().defaultBlockState(), 9));
        register(context, SKY_AMAGNETITE_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceable, CCBlocks.MAGNETITE_ORE.get().defaultBlockState(), 9));

/*
        register(context, TRANSCENDENT_COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCobaltOres, 9));
        register(context, TRANSCENDENT_IRIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldIridiumOres, 9));
        register(context, TRANSCENDENT_NEODYMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldNeodymiumOres, 9));
        register(context, TRANSCENDENT_PALLADIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPalladiumOres, 9));
        register(context, TRANSCENDENT_TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTitaniumOres, 9));
        register(context, TRANSCENDENT_TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTungstenOres, 9));

 */
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CausalChaos.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
