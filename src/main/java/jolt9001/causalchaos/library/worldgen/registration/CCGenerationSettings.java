package jolt9001.causalchaos.library.worldgen.registration;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.LevelStem;

public class CCGenerationSettings {
    //@Deprecated
    public static final int SEALEVEL = 0;

    // Sky Islands
    public static final ResourceLocation DIMENSION_SKY = CausalChaos.prefix("skylands");
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_SKY = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_SKY);
    public static final ResourceKey<Level> DIMENSION_KEY_SKY = ResourceKey.create(Registries.DIMENSION, DIMENSION_SKY);

    // Limbo
    public static final ResourceLocation DIMENSION_VOID = CausalChaos.prefix("limbo");
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_VOID = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_VOID);
    public static final ResourceKey<Level> DIMENSION_KEY_VOID = ResourceKey.create(Registries.DIMENSION, DIMENSION_VOID);

    // Transcendent's Plain
    public static final ResourceLocation DIMENSION_FINAL = CausalChaos.prefix("transcendents_plain");
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_FINAL = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_FINAL);
    public static final ResourceKey<Level> DIMENSION_KEY_FINAL = ResourceKey.create(Registries.DIMENSION, DIMENSION_FINAL);

    // Parallel Universes
    public static final ResourceLocation DIMENSION_PARALLEL = CausalChaos.prefix("parallel"); //
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_PARALLEL = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_PARALLEL);
    public static final ResourceKey<Level> DIMENSION_KEY_PARALLEL = ResourceKey.create(Registries.DIMENSION, DIMENSION_PARALLEL);

    public static boolean isSkyDestination(Level level) {
        return DIMENSION_SKY.equals(level.dimension().location());
    }
    public static boolean isVoidDestination(Level level) {
        return DIMENSION_VOID.equals(level.dimension().location());
    }
    public static boolean isFinalDestination(Level level) {
        return DIMENSION_FINAL.equals(level.dimension().location());
    }
    public static boolean isParallelDestination(Level level) {
        return DIMENSION_PARALLEL.equals(level.dimension().location());
    }
}
