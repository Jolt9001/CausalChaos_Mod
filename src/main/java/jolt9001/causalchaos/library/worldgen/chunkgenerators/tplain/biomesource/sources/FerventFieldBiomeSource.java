package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.sources;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jolt9001.causalchaos.init.CCWorldSeeds;
import jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.masks.FerventFieldSpiralMask;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

import java.util.stream.Stream;

public class FerventFieldBiomeSource extends BiomeSource {
    // Encode holders directly. Biome.CODEC resolves keys via registry ops.
    public static final MapCodec<FerventFieldBiomeSource> CODEC =
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    BiomeSource.CODEC.fieldOf("base").forGetter(s -> s.base),
                    Biome.CODEC.fieldOf("fervent_field").forGetter(s -> s.ferventField),
                    Biome.CODEC.fieldOf("yin").forGetter(s -> s.yinVariant),
                    Biome.CODEC.fieldOf("yang").forGetter(s -> s.yangVariant),
                    Biome.CODEC.fieldOf("unity").forGetter(s -> s.unityVariant),
                    ResourceKey.codec(Registries.DIMENSION).optionalFieldOf("dimension").forGetter(s -> s.dimensionKey == null ? java.util.Optional.empty() : java.util.Optional.of(s.dimensionKey))
            ).apply(instance, (base, ff, yin, yang, unity, dimOpt) -> new FerventFieldBiomeSource(base, ff, yin, yang, unity, dimOpt.orElse(null)))
            );

    private final BiomeSource base;
    private final Holder<Biome> ferventField;
    private final Holder<Biome> yinVariant;
    private final Holder<Biome> yangVariant;
    private final Holder<Biome> unityVariant;
    private final ResourceKey<Level> dimensionKey;
    private final ResourceKey<Biome> ffKey;

    // --- Constructor used by the CODEC ---
    public FerventFieldBiomeSource(BiomeSource base, Holder<Biome> ferventField, Holder<Biome> yinVariant, Holder<Biome> yangVariant, Holder<Biome> unityVariant, ResourceKey<Level> dim) {
        super();
        this.base = base;
        this.ferventField = ferventField;
        this.yinVariant = yinVariant;
        this.yangVariant = yangVariant;
        this.unityVariant = unityVariant;
        this.dimensionKey = dim;
        ffKey = ferventField.unwrapKey().orElseThrow();
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC.codec();
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return Stream.concat(base.possibleBiomes().stream(),
                Stream.of(ferventField, yinVariant, yangVariant, unityVariant)).distinct();
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler pSampler) {
        // Delegate to your base/vanilla source first
        Holder<Biome> baseHold = base.getNoiseBiome(x, y, z, pSampler);

        if (!baseHold.is(ffKey)) return baseHold;

        // World coords are at 4-block scale (biome noise res). Convert to block coords if you want:
        int bx = x << 2;
        int bz = z << 2;

        long seed = CCWorldSeeds.get(dimensionKey);

        // Spiral params (tune to your Large Biomes + structure size)
        double cx = 0/* center X (e.g., structure center or 0) */;
        double cz = 0/* center Z */;
        double a  = 480.0;    // initial radius scale
        double b  = 0.3;      // growth rate (>0) - tightness
        double w  = 10.0;     // arm width
        double g = 1.0;       // arm gap
        double u = 48.0;      // UNITY radius (blocks) to avoid overlap near origin
        double j = 1.0;       // jitter
        double phase = 0.0;   // rotate spirals if needed. May introduce randomness later

        // Close to the center? Force Unity
        double dist = Math.hypot(bx - cx, bz - cz);


        FerventFieldSpiralMask.Params p = new FerventFieldSpiralMask.Params(cx, cx, a, b, w, g, u, j);
        boolean yin = FerventFieldSpiralMask.isYin(bx, bz, seed, p, phase);
        if (!yin && dist <= u) return unityVariant;
        return yin ? yinVariant : yangVariant;

    }
}
