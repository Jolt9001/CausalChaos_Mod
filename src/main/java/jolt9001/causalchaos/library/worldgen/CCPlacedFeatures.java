package jolt9001.causalchaos.library.worldgen;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class CCPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OVERWORLD_COBALT_ORE_PLACED_KEY = registerKey("cobalt_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_IRIDIUM_ORE_PLACED_KEY = registerKey("iridium_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_NEODYMIUM_ORE_PLACED_KEY = registerKey("neodymium_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_PALLADIUM_ORE_PLACED_KEY = registerKey("palladium_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_TITANIUM_ORE_PLACED_KEY = registerKey("titanium_ore_placed");
    public static final ResourceKey<PlacedFeature> OVERWORLD_TUNGSTEN_ORE_PLACED_KEY = registerKey("tungsten_ore_placed");

    public static final ResourceKey<PlacedFeature> TRANSCENDENT_COBALT_ORE_PLACED_KEY = registerKey("transcendent_cobalt_ore_placed");
    public static final ResourceKey<PlacedFeature> TRANSCENDENT_IRIDIUM_ORE_PLACED_KEY = registerKey("transcendent_iridium_ore_placed");
    public static final ResourceKey<PlacedFeature> TRANSCENDENT_NEODYMIUM_ORE_PLACED_KEY = registerKey("transcendent_neodymium_ore_placed");
    public static final ResourceKey<PlacedFeature> TRANSCENDENT_PALLADIUM_ORE_PLACED_KEY = registerKey("transcendent_palladium_ore_placed");
    public static final ResourceKey<PlacedFeature> TRANSCENDENT_TITANIUM_ORE_PLACED_KEY = registerKey("transcendent_titanium_ore_placed");
    public static final ResourceKey<PlacedFeature> TRANSCENDENT_TUNGSTEN_ORE_PLACED_KEY = registerKey("transcendent_tungsten_ore_placed");

    public static final ResourceKey<PlacedFeature> SKY_ANTHRACITE_ORE_PLACED_KEY = registerKey("anthracite_ore_placed");
    public static final ResourceKey<PlacedFeature> SKY_MAGNETITE_ORE_PLACED_KEY = registerKey("magnetite_ore_placed");

    /* ORES IN ORDER OF RARITY
        Anthracite: 30 blobs per chunk in Sky Islands, blob size 17
        Magnetite: 10 blobs per chunk in Sky Islands, blob size 9
        Neodymium: 9 blobs per chunk, blob size 9 (Overworld); 18 blobs per chunk, blob size 13 (Transcendent's Plain)
        Cobalt: 8 blobs per chunk, blob size 7 (Overworld); 17 blobs per chunk, blob size 11 (Transcendent's Plain)
        Titanium: 7 blobs per chunk, blob size 6 (Overworld); 16 blobs per chunk, blob size 10 (Transcendent's Plain)
        Tungsten: 5 blobs per chunk, blob size 6 (Overworld); 14 blobs per chunk, blob size 10 (Transcendent's Plain)
        Palladium: 3 blobs per chunk in Overworld, blob size 5 (Overworld); 12 blobs per chunk, blob size 9 (Transcendent's Plain)
        Iridium: 2 blobs per chunk in Overworld, blob size 4 (Overworld); 10 blobs per chunk, blob size 8 (Transcendent's Plain)
    */

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, OVERWORLD_NEODYMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.OVERWORLD_NEODYMIUM_ORE_KEY),
                CCOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(66))));
        register(context, OVERWORLD_COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.OVERWORLD_COBALT_ORE_KEY),
                CCOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-34), VerticalAnchor.absolute(40))));
        register(context, OVERWORLD_TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.OVERWORLD_TITANIUM_ORE_KEY),
                CCOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(32))));
        register(context, OVERWORLD_TUNGSTEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.OVERWORLD_TUNGSTEN_ORE_KEY),
                CCOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16))));
        register(context, OVERWORLD_PALLADIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.OVERWORLD_PALLADIUM_ORE_KEY),
                CCOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));
        register(context, OVERWORLD_IRIDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.OVERWORLD_IRIDIUM_ORE_KEY),
                CCOrePlacement.commonOrePlacement(2,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-16))));
        // #(Uncomment when dimensions are created)
/*
        register(context, SKY_ANTHRACITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.SKY_ANTHRACITE_ORE_KEY),
                CCOrePlacement.commonOrePlacement(30,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, SKY_MAGNETITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.SKY_MAGNETITE_ORE_KEY),
                CCOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, TRANSCENDENT_NEODYMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.TRANSCENDENT_NEODYMIUM_ORE_KEY),
                CCOrePlacement.commonOrePlacement(18,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, TRANSCENDENT_COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.TRANSCENDENT_COBALT_ORE_KEY),
                CCOrePlacement.commonOrePlacement(17,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, TRANSCENDENT_TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.TRANSCENDENT_TITANIUM_ORE_KEY),
                CCOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, TRANSCENDENT_TUNGSTEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.TRANSCENDENT_TUNGSTEN_ORE_KEY),
                CCOrePlacement.commonOrePlacement(14,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, TRANSCENDENT_PALLADIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.TRANSCENDENT_PALLADIUM_ORE_KEY),
                CCOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, TRANSCENDENT_IRIDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(CCConfiguedFeatures.TRANSCENDENT_IRIDIUM_ORE_KEY),
                CCOrePlacement.commonOrePlacement(11,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

 */
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CausalChaos.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
