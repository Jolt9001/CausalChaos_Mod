package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.masks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.MaskContext;
import jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.VariantMask;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;

import java.util.Optional;

public record SpiralMask(
        double cx, double cz, double a, double b, double w, double g,
        double unityR, double jitter, double phase,
        Holder<Biome> yin, Holder<Biome> yang, Optional<Holder<Biome>> unity
) implements VariantMask {

    public static final MapCodec<SpiralMask> CODEC = RecordCodecBuilder.mapCodec(i -> i.group(
            Codec.DOUBLE.fieldOf("cx").forGetter(SpiralMask::cx),
            Codec.DOUBLE.fieldOf("cz").forGetter(SpiralMask::cz),
            Codec.DOUBLE.fieldOf("a").forGetter(SpiralMask::a),
            Codec.DOUBLE.fieldOf("b").forGetter(SpiralMask::b),
            Codec.DOUBLE.fieldOf("w").forGetter(SpiralMask::w),
            Codec.DOUBLE.fieldOf("g").forGetter(SpiralMask::g),
            Codec.DOUBLE.fieldOf("unity_radius").forGetter(SpiralMask::unityR),
            Codec.DOUBLE.fieldOf("jitter").forGetter(SpiralMask::jitter),
            Codec.DOUBLE.fieldOf("phase").forGetter(SpiralMask::phase),
            Biome.CODEC.fieldOf("yin").forGetter(SpiralMask::yin),
            Biome.CODEC.fieldOf("yang").forGetter(SpiralMask::yang),
            Biome.CODEC.optionalFieldOf("unity").forGetter(SpiralMask::unity)
    ).apply(i, SpiralMask::new));

    @Override public String type() {
        return "spiral";
    }

    @Override
    public Holder<Biome> pick(int bx, int by, int bz, long seed) {
        double dist = Math.hypot(bx - cx, bz - cz);
        if (unity.isPresent() && dist <= unityR) return unity.get();
        boolean yinSide = FerventFieldSpiralMask.isYin(
                bx, bz, seed,
                new FerventFieldSpiralMask.Params(cx, cz, a, b, w, g, unityR, jitter),
                phase
        );
        return yinSide ? yin : yang;
    }
}
