package jolt9001.causalchaos.library.worldgen;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class CCBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_COBALT_ORE = registerKey("add_cobalt_ore");
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_IRIDIUM_ORE = registerKey("add_iridium_ore");
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_NEODYMIUM_ORE = registerKey("add_neodymium_ore");
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_PALLADIUM_ORE = registerKey("add_palladium_ore");
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_TITANIUM_ORE = registerKey("add_titanium_ore");
    public static final ResourceKey<BiomeModifier> ADD_OVERWORLD_TUNGSTEN_ORE = registerKey("add_tungsten_ore");

    public static final ResourceKey<BiomeModifier> ADD_TRANSCENDENT_COBALT_ORE = registerKey("add_transcendent_cobalt_ore");
    public static final ResourceKey<BiomeModifier> ADD_TRANSCENDENT_IRIDIUM_ORE = registerKey("add_transcendent_iridium_ore");
    public static final ResourceKey<BiomeModifier> ADD_TRANSCENDENT_NEODYMIUM_ORE = registerKey("add_transcendent_neodymium_ore");
    public static final ResourceKey<BiomeModifier> ADD_TRANSCENDENT_PALLADIUM_ORE = registerKey("add_transcendent_palladium_ore");
    public static final ResourceKey<BiomeModifier> ADD_TRANSCENDENT_TITANIUM_ORE = registerKey("add_transcendent_titanium_ore");
    public static final ResourceKey<BiomeModifier> ADD_TRANSCENDENT_TUNGSTEN_ORE = registerKey("add_transcendent_tungsten_ore");

    public static final ResourceKey<BiomeModifier> ADD_SKY_ANTHRACITE_ORE = registerKey("add_anthracite_ore");
    public static final ResourceKey<BiomeModifier> ADD_SKY_MAGNETITE_ORE = registerKey("add_magnetite_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_OVERWORLD_NEODYMIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.OVERWORLD_NEODYMIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_OVERWORLD_COBALT_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.OVERWORLD_COBALT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_OVERWORLD_TITANIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.OVERWORLD_TITANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_OVERWORLD_TUNGSTEN_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.OVERWORLD_TUNGSTEN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_OVERWORLD_PALLADIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.OVERWORLD_PALLADIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_OVERWORLD_IRIDIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.OVERWORLD_IRIDIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        /*
        context.register(ADD_SKY_ANTHRACITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(CCBiomeTags.IS_SKY),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.SKY_ANTHRACITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_SKY_MAGNETITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(CCBiomeTags.IS_SKY),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.SKY_MAGNETITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_TRANSCENDENT_NEODYMIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(CCBiomeTags.IS_FINAL),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.TRANSCENDENT_NEODYMIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_TRANSCENDENT_COBALT_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(CCBiomeTags.IS_FINAL),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.OVERWORLD_COBALT_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_TRANSCENDENT_TITANIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(CCBiomeTags.IS_FINAL),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.TRANSCENDENT_TITANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_TRANSCENDENT_TUNGSTEN_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(CCBiomeTags.IS_FINAL),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.TRANSCENDENT_TUNGSTEN_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_TRANSCENDENT_PALLADIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(CCBiomeTags.IS_FINAL),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.TRANSCENDENT_PALLADIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_TRANSCENDENT_IRIDIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(CCBiomeTags.IS_FINAL),
                HolderSet.direct(placedFeatures.getOrThrow(CCPlacedFeatures.TRANSCENDENT_IRIDIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

         */
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CausalChaos.MODID, name));
    }
}
