package jolt9001.causalchaos.library.worldgen.features.vegetation;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class CCFoliagePlacers {
    // Crystal Cliffs
    public static final ResourceKey<PlacedFeature> TREES_ENAMEL = PlacementUtils.createKey("trees_enamel");

    // Petrifying Plateau
    public static final ResourceKey<PlacedFeature> TREES_GRIM = PlacementUtils.createKey("trees_grim");

    // Skourainei
    public static final ResourceKey<PlacedFeature> TREES_EVENOS = PlacementUtils.createKey("trees_evenos");

    // Fervent Field
    public static final ResourceKey<PlacedFeature> TREES_BLOOMHEART_YIN = PlacementUtils.createKey("trees_bloomheart_yin");
    public static final ResourceKey<PlacedFeature> TREES_BLOOMHEART_YANG = PlacementUtils.createKey("trees_bloomheart_yang");
    public static final ResourceKey<PlacedFeature> FLOWERS_YIN = PlacementUtils.createKey("flowers_yin"); // Flowers for Yin variant
    public static final ResourceKey<PlacedFeature> FLOWERS_YANG = PlacementUtils.createKey("flowers_yang"); // Flowers for Yang variant

    // Quivering Quarry
    public static final ResourceKey<PlacedFeature> TREES_FULGUR = PlacementUtils.createKey("trees_fulgur");
}