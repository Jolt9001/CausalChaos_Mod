package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;

public interface VariantMask {
    /** Return a variant Holder[Biome] for world/block coords. Must be deterministic. */
    Holder<Biome> pick(int bx, int by, int bz, long seed);

    /** A short name used in JSON, e.g. "spiral" */
    String type();
}