package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jolt9001.causalchaos.init.CCWorldSeeds;
import jolt9001.causalchaos.library.worldgen.biome.biomegen.dimensions.TPlainBiomeGen;
import jolt9001.causalchaos.library.worldgen.biome.selector.CCTPlainBiomeBuilder;
import jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.masks.FerventFieldSpiralMask;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

import java.util.stream.Stream;

public class FerventFieldBiomeSource extends BiomeSource {
    // Encode holders directly. Biome.CODEC resolves keys via registry ops.
    public static final MapCodec<FerventFieldBiomeSource> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    Biome.CODEC.fieldOf("fervent_field").forGetter(s -> s.ferventField),
                    Biome.CODEC.fieldOf("yin").forGetter(s -> s.yinVariant),
                    Biome.CODEC.fieldOf("yang").forGetter(s -> s.yangVariant),
                    Biome.CODEC.fieldOf("unity").forGetter(s -> s.unityVariant),
                    // If you truly need to keep which dimension this source is for:
                    ResourceKey.codec(Registries.DIMENSION).optionalFieldOf("dimension")
                            .forGetter(s -> s.dimensionKey == null ? java.util.Optional.empty() : java.util.Optional.of(s.dimensionKey))
            ).apply(instance, (ff, yin, yang, unity, dimOpt) ->
                    new FerventFieldBiomeSource(ff, yin, yang, unity, dimOpt.orElse(null)))
            );

    private final Holder<Biome> ferventField;
    private final Holder<Biome> yinVariant;
    private final Holder<Biome> yangVariant;
    private final Holder<Biome> unityVariant;
    private final ResourceKey<Level> dimensionKey;

    // --- Constructor used by the CODEC ---
    public FerventFieldBiomeSource(Holder<Biome> ferventField, Holder<Biome> yinVariant, Holder<Biome> yangVariant, Holder<Biome> unityVariant, ResourceKey<Level> dim) {
        this.dimensionKey = dim;
        this.ferventField = ferventField;
        this.yinVariant = yinVariant;
        this.yangVariant = yangVariant;
        this.unityVariant = unityVariant;
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC.codec();
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return null;
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler pSampler) {
        // Delegate to your base/vanilla source first
        Holder<Biome> base = /* call wrapped source here */ null;

        if (base == this.ferventField) {
            // World coords are at 4-block scale (biome noise res). Convert to block coords if you want:
            int bx = x << 2;
            int bz = z << 2;

            long seed = CCWorldSeeds.get(dimensionKey);

            // Spiral params (tune to your Large Biomes + structure size)
            double cx = 0/* center X (e.g., structure center or 0) */;
            double cz = 0/* center Z */;
            double a  = 24.0;     // initial radius scale
            double b  = 0.075;    // tightness
            double w  = 10.0;     // arm thickness
            double phase = 0.0;   // rotate spirals if needed

            // Close to the center? Force Unity
            double dist = Math.hypot(bx - cx, bz - cz);
            if (dist <= 48.0) return unityVariant;

            boolean yin = FerventFieldSpiralMask.isYin(bx, bz, seed, cx, cz, a, b, w, phase);
            return yin ? yinVariant : yangVariant;
        }

        return base;
    }
}
