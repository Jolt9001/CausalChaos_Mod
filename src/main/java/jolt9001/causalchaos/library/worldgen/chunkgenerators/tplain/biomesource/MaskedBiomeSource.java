package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jolt9001.causalchaos.init.CCWorldSeeds;
import jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.masks.SpiralMask;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.stream.Stream;

public class MaskedBiomeSource extends BiomeSource {
    public static final MapCodec<MaskedBiomeSource> CODEC =
            RecordCodecBuilder.mapCodec(i -> i.group(
                    BiomeSource.CODEC.fieldOf("base").forGetter(m -> m.base),
                    ResourceKey.codec(Registries.BIOME).fieldOf("placeholder").forGetter(m -> m.placeholderKey),
                    VariantMaskCodecs.DISPATCH.fieldOf("mask").forGetter(m -> m.mask),
                    ResourceKey.codec(Registries.DIMENSION).optionalFieldOf("dimension").forGetter(m -> Optional.ofNullable(m.dimensionKey))
            ).apply(i, (base, placeholder, mask, dimOpt) -> new MaskedBiomeSource(base, placeholder, mask, dimOpt.orElse(null))));

    private final BiomeSource base;
    private final ResourceKey<Biome> placeholderKey;
    private final VariantMask mask;
    private final ResourceKey<Level> dimensionKey;

    public MaskedBiomeSource(BiomeSource base, ResourceKey<Biome> placeholderKey, VariantMask mask, @Nullable ResourceKey<Level> dim) {
        this.base = base; this.placeholderKey = placeholderKey; this.mask = mask; this.dimensionKey = dim;
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC.codec();
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return base.possibleBiomes().stream();
    }

    @Override
    public Holder<Biome> getNoiseBiome(int pX, int pY, int pZ, Climate.Sampler pSampler) {
        Holder<Biome> baseHold = base.getNoiseBiome(pX, pY, pZ, pSampler);
        if (!baseHold.is(placeholderKey)) return baseHold;

        int bx = pX << 2, bz = pZ << 2;
        long seed = CCWorldSeeds.get(dimensionKey);

        if (mask instanceof SpiralMask spiral) {
            return spiral.pick(bx, pY << 2, bz, seed);
        }
        // Future masks: add instanceof branches or give VariantMask a common pick() method.
        return baseHold;
    }
}
