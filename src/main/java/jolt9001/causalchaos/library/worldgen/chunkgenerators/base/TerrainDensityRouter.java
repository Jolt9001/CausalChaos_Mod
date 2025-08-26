package jolt9001.causalchaos.library.worldgen.chunkgenerators.base;

import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.DensityFunction;

public class TerrainDensityRouter implements DensityFunction.SimpleFunction {
    @Override
    public double compute(FunctionContext functionContext) {
        return 0;
    }

    @Override
    public double minValue() {
        return 0;
    }

    @Override
    public double maxValue() {
        return 0;
    }

    @Override
    public KeyDispatchDataCodec<? extends DensityFunction> codec() {
        return null;
    }
}
