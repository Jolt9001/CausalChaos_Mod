package jolt9001.causalchaos.library.worldgen;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CCGenerationSettings {
    public static final int SEALEVEL = 0;

    public static final ResourceLocation DIMENSION_FINAL = CausalChaos.prefix("Transcendents_plain");
    public static final ResourceKey<LevelStem> WORLDGEN_KEY_FINAL = ResourceKey.create(Registries.LEVEL_STEM, DIMENSION_FINAL);
    public static final ResourceKey<Level> DIMENSION_KEY_FINAL = ResourceKey.create(Registries.DIMENSION, DIMENSION_FINAL);

    public static boolean isTranscendentPortalDestination(Level level) {
        return DIMENSION_FINAL.equals(level.dimension().location());
    }
    @OnlyIn(Dist.CLIENT)
    public static boolean isTranscendentWorldOnClient(Level level) {
        return CausalChaos.MODID.equals(Minecraft.getInstance().level.dimension().location().getNamespace()) || isTranscendentPortalDestination(level);
    }
/*
    public static boolean usesTranscendentChunkGenerator(ServerLevel level) {
        return level.getChunkSource().getGenerator() instanceof CCChunkGenerator;
    }

 */
}
