package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.Map;

public record MaskContext(ResourceKey<Level> dimensionKey, Map<String, Double> params) {}
