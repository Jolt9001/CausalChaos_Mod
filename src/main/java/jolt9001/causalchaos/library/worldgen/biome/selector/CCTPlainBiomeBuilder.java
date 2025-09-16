package jolt9001.causalchaos.library.worldgen.biome.selector;

import com.mojang.datafixers.util.Pair;
import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.NoiseRouterData;

import java.util.function.Consumer;

public final class CCTPlainBiomeBuilder {
    private static final float VALLEY_SIZE = 0.05F;
    private static final float LOW_START = 0.26666668F;
    public static final float HIGH_START = 0.4F;
    private static final float HIGH_END = 0.93333334F;
    private static final float PEAK_SIZE = 0.1F;
    public static final float PEAK_START = 0.56666666F;
    private static final float PEAK_END = 0.7666667F;
    public static final float NEAR_INLAND_START = -0.11F;
    public static final float MID_INLAND_START = 0.03F;
    public static final float FAR_INLAND_START = 0.3F;
    public static final float EROSION_INDEX_1_START = -0.78F;
    public static final float EROSION_INDEX_2_START = -0.375F;
    private static final float EROSION_DEEP_DARK_DRYNESS_THRESHOLD = -0.225F;
    private static final float DEPTH_DEEP_DARK_DRYNESS_THRESHOLD = 0.9F;
    private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
    private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter FROZEN_RANGE;
    private final Climate.Parameter UNFROZEN_RANGE;
    private final Climate.Parameter mushroomFieldsContinentalness;
    private final Climate.Parameter deepOceanContinentalness;
    private final Climate.Parameter oceanContinentalness;
    private final Climate.Parameter coastContinentalness;
    private final Climate.Parameter inlandContinentalness;
    private final Climate.Parameter nearInlandContinentalness;
    private final Climate.Parameter midInlandContinentalness;
    private final Climate.Parameter farInlandContinentalness;

    public CCTPlainBiomeBuilder() {
        this.FROZEN_RANGE = this.temperatures[0];
        this.UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
        this.mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
        this.deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
        this.oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
        this.coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
        this.inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
        this.nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
        this.midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
        this.farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
    }

    public void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pKey) {
        this.addOffCoasts(pKey);
        this.addInlands(pKey);
        this.addUndergrounds(pKey);
    }

    private void addOffCoasts(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer) {
        this.addSurface(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.MUSHROOM_FIELDS);

        for(int $$1 = 0; $$1 < this.temperatures.length; ++$$1) {
            Climate.Parameter $$2 = this.temperatures[$$1];
            this.addSurface(pConsumer, $$2, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, CCTPlainBiomeSelectors.TPLAIN_OCEANS[0][$$1]);
            this.addSurface(pConsumer, $$2, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, CCTPlainBiomeSelectors.TPLAIN_OCEANS[1][$$1]);
        }

    }

    private void addInlands(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer) {
        this.addMidSlice(pConsumer, Climate.Parameter.span(-1.0F, -0.93333334F));
        this.addHighSlice(pConsumer, Climate.Parameter.span(-0.93333334F, -0.7666667F));
        this.addPeaks(pConsumer, Climate.Parameter.span(-0.7666667F, -0.56666666F));
        this.addHighSlice(pConsumer, Climate.Parameter.span(-0.56666666F, -0.4F));
        this.addMidSlice(pConsumer, Climate.Parameter.span(-0.4F, -0.26666668F));
        this.addLowSlice(pConsumer, Climate.Parameter.span(-0.26666668F, -0.05F));
        this.addValleys(pConsumer, Climate.Parameter.span(-0.05F, 0.05F));
        this.addLowSlice(pConsumer, Climate.Parameter.span(0.05F, 0.26666668F));
        this.addMidSlice(pConsumer, Climate.Parameter.span(0.26666668F, 0.4F));
        this.addHighSlice(pConsumer, Climate.Parameter.span(0.4F, 0.56666666F));
        this.addPeaks(pConsumer, Climate.Parameter.span(0.56666666F, 0.7666667F));
        this.addHighSlice(pConsumer, Climate.Parameter.span(0.7666667F, 0.93333334F));
        this.addMidSlice(pConsumer, Climate.Parameter.span(0.93333334F, 1.0F));
    }

    private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pWeirdness) {
        for(int t = 0; t < this.temperatures.length; ++t) {
            Climate.Parameter temp = this.temperatures[t];
            for (int h = 0; h < this.humidities.length; ++h) {
                Climate.Parameter humid = this.humidities[h];
                ResourceKey<Biome> mid = this.pickMid(t, h, pWeirdness);
                ResourceKey<Biome> midOrBadHot = this.pickMidOrBadIfHot(t, h, pWeirdness);
                ResourceKey<Biome> midOrBadHotOrSlopeCold = this.pickMiddleOrBadIfHotOrSlopeIfCold(t, h, pWeirdness);
                ResourceKey<Biome> plat = this.pickPlat(t, h, pWeirdness);
                ResourceKey<Biome> shatt = this.pickShatt(t, h, pWeirdness);
                ResourceKey<Biome> maybeWindSav = this.maybePickWindSav(t, h, pWeirdness, shatt);
                ResourceKey<Biome> peak = this.pickPeak(t, h, pWeirdness);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], pWeirdness, 0.0F, peak);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], pWeirdness, 0.0F, midOrBadHotOrSlopeCold);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[1], pWeirdness, 0.0F, peak);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], pWeirdness, 0.0F, plat);
                this.addSurface(pConsumer, temp, humid, this.midInlandContinentalness, this.erosions[3], pWeirdness, 0.0F, midOrBadHot);
                this.addSurface(pConsumer, temp, humid, this.midInlandContinentalness, this.erosions[3], pWeirdness, 0.0F, plat);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], pWeirdness, 0.0F, maybeWindSav);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], pWeirdness, 0.0F, shatt);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], pWeirdness, 0.0F, mid);
            }
        }
    }
    private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pWeirdness) {
        for(int t = 0; t < this.temperatures.length; ++t) {
            Climate.Parameter temp = this.temperatures[t];
            for (int h = 0; h < this.humidities.length; ++h) {
                Climate.Parameter humid = this.humidities[h];
                ResourceKey<Biome> mid = this.pickMid(t, h, pWeirdness);
                ResourceKey<Biome> midOrBadHot = this.pickMidOrBadIfHot(t, h, pWeirdness);
                ResourceKey<Biome> midOrBadHotOrSlopeCold = this.pickMiddleOrBadIfHotOrSlopeIfCold(t, h, pWeirdness);
                ResourceKey<Biome> plat = this.pickPlat(t, h, pWeirdness);
                ResourceKey<Biome> shatt = this.pickShatt(t, h, pWeirdness);
                ResourceKey<Biome> maybeWindSav = this.maybePickWindSav(t, h, pWeirdness, shatt);
                ResourceKey<Biome> slope = this.pickSlope(t, h, pWeirdness);
                ResourceKey<Biome> peak = this.pickPeak(t, h, pWeirdness);
                this.addSurface(pConsumer, temp, humid, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, this.nearInlandContinentalness, this.erosions[0], pWeirdness, 0.0F, slope);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], pWeirdness, 0.0F, peak);
                this.addSurface(pConsumer, temp, humid, this.nearInlandContinentalness, this.erosions[1], pWeirdness, 0.0F, midOrBadHotOrSlopeCold);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], pWeirdness, 0.0F, slope);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], pWeirdness, 0.0F, plat);
                this.addSurface(pConsumer, temp, humid, this.midInlandContinentalness, this.erosions[3], pWeirdness, 0.0F, midOrBadHot);
                this.addSurface(pConsumer, temp, humid, this.midInlandContinentalness, this.erosions[3], pWeirdness, 0.0F, plat);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], pWeirdness, 0.0F, maybeWindSav);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], pWeirdness, 0.0F, shatt);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], pWeirdness, 0.0F, mid);
            }
        }
    }
    private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pWeirdness) {
        this.addSurface(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), pWeirdness, 0.0F, Biomes.STONY_SHORE);
        this.addSurface(pConsumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], pWeirdness, 0.0F, CCBiomes.SUBCONSCIOUS_SWAMP);
        this.addSurface(pConsumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], pWeirdness, 0.0F, Biomes.MANGROVE_SWAMP);

        for(int t = 0; t < this.temperatures.length; ++t) {
            Climate.Parameter temp = this.temperatures[t];
            for (int h = 0; h < this.humidities.length; ++h) {
                Climate.Parameter humid = this.humidities[h];
                ResourceKey<Biome> mid = this.pickMid(t, h, pWeirdness);
                ResourceKey<Biome> midOrBadHot = this.pickMidOrBadIfHot(t, h, pWeirdness);
                ResourceKey<Biome> midOrBadHotOrSlopeCold = this.pickMiddleOrBadIfHotOrSlopeIfCold(t, h, pWeirdness);
                ResourceKey<Biome> shatt = this.pickShatt(t, h, pWeirdness);
                ResourceKey<Biome> plat = this.pickPlat(t, h, pWeirdness);
                ResourceKey<Biome> beach = this.pickBeach(t, h);
                ResourceKey<Biome> maybeWindSav = this.maybePickWindSav(t, h, pWeirdness, shatt);
                ResourceKey<Biome> shattCoast = this.pickShattCoast(t, h, pWeirdness);
                ResourceKey<Biome> slope = this.pickSlope(t, h, pWeirdness);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], pWeirdness, 0.0F, slope);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], pWeirdness, 0.0F, midOrBadHotOrSlopeCold);
                this.addSurface(pConsumer, temp, humid, this.farInlandContinentalness, this.erosions[1], pWeirdness, 0.0F, t == 0 ? slope : plat);
                this.addSurface(pConsumer, temp, humid, this.nearInlandContinentalness, this.erosions[2], pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, this.midInlandContinentalness, this.erosions[2], pWeirdness, 0.0F, midOrBadHot);
                this.addSurface(pConsumer, temp, humid, this.farInlandContinentalness, this.erosions[2], pWeirdness, 0.0F, plat);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], pWeirdness, 0.0F, midOrBadHot);
                if (pWeirdness.max() < 0L) {
                    this.addSurface(pConsumer, temp, humid, this.coastContinentalness, this.erosions[4], pWeirdness, 0.0F, beach);
                    this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], pWeirdness, 0.0F, mid);
                } else {
                    this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], pWeirdness, 0.0F, mid);
                }
                this.addSurface(pConsumer, temp, humid, this.coastContinentalness, this.erosions[5], pWeirdness, 0.0F, shattCoast);
                this.addSurface(pConsumer, temp, humid, this.nearInlandContinentalness, this.erosions[5], pWeirdness, 0.0F, maybeWindSav);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], pWeirdness, 0.0F, beach);
                if (pWeirdness.max() < 0L) {
                    this.addSurface(pConsumer, temp, humid, this.coastContinentalness, this.erosions[6], pWeirdness, 0.0F, beach);
                } else {
                    this.addSurface(pConsumer, temp, humid, this.coastContinentalness, this.erosions[6], pWeirdness, 0.0F, mid);
                }
                if (t == 0) {
                    this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], pWeirdness, 0.0F, mid);
                }
            }
        }
    }
    private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pWeirdness) {
        this.addSurface(pConsumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), pWeirdness, 0.0F, Biomes.STONY_SHORE);
        this.addSurface(pConsumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], pWeirdness, 0.0F, CCBiomes.SUBCONSCIOUS_SWAMP);
        this.addSurface(pConsumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], pWeirdness, 0.0F, Biomes.MANGROVE_SWAMP);

        for(int t = 0; t < this.temperatures.length; ++t) {
            Climate.Parameter temp = this.temperatures[t];
            for (int h = 0; h < this.humidities.length; ++h) {
                Climate.Parameter humid = this.humidities[h];
                ResourceKey<Biome> mid = this.pickMid(t, h, pWeirdness);
                ResourceKey<Biome> midOrBadHot = this.pickMidOrBadIfHot(t, h, pWeirdness);
                ResourceKey<Biome> midOrBadHotOrSlopeCold = this.pickMiddleOrBadIfHotOrSlopeIfCold(t, h, pWeirdness);
                ResourceKey<Biome> beach = this.pickBeach(t, h);
                ResourceKey<Biome> maybeWindSav = this.maybePickWindSav(t, h, pWeirdness, mid);
                ResourceKey<Biome> shattCoast = this.pickShattCoast(t, h, pWeirdness);
                this.addSurface(pConsumer, temp, humid, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pWeirdness, 0.0F, midOrBadHot);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), pWeirdness, 0.0F, midOrBadHotOrSlopeCold);
                this.addSurface(pConsumer, temp, humid, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[3]), pWeirdness, 0.0F, midOrBadHot);
                this.addSurface(pConsumer, temp, humid, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), pWeirdness, 0.0F, beach);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, this.coastContinentalness, this.erosions[5], pWeirdness, 0.0F, shattCoast);
                this.addSurface(pConsumer, temp, humid, this.nearInlandContinentalness, this.erosions[5], pWeirdness, 0.0F, maybeWindSav);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], pWeirdness, 0.0F, mid);
                this.addSurface(pConsumer, temp, humid, this.coastContinentalness, this.erosions[6], pWeirdness, 0.0F, beach);
                if (t == 0) {
                    this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], pWeirdness, 0.0F, mid);
                }
            }
        }
    }
    private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pWierdness) {
        this.addSurface(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pWierdness, 0.0F, pWierdness.max() < 0L ? Biomes.STONY_SHORE : CCBiomes.FROZEN_RADIANT_RIVER);
        this.addSurface(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pWierdness, 0.0F, pWierdness.max() < 0L ? Biomes.STONY_SHORE : CCBiomes.RADIANT_RIVER);
        this.addSurface(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pWierdness, 0.0F, CCBiomes.FROZEN_RADIANT_RIVER);
        this.addSurface(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), pWierdness, 0.0F, CCBiomes.RADIANT_RIVER);
        this.addSurface(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), pWierdness, 0.0F, CCBiomes.FROZEN_RADIANT_RIVER);
        this.addSurface(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), pWierdness, 0.0F, CCBiomes.RADIANT_RIVER);
        this.addSurface(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], pWierdness, 0.0F, CCBiomes.FROZEN_RADIANT_RIVER);
        this.addSurface(pConsumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], pWierdness, 0.0F, CCBiomes.RADIANT_RIVER);
        this.addSurface(pConsumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], pWierdness, 0.0F, Biomes.SWAMP);
        this.addSurface(pConsumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], pWierdness, 0.0F, Biomes.MANGROVE_SWAMP);
        this.addSurface(pConsumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], pWierdness, 0.0F, CCBiomes.FROZEN_RADIANT_RIVER);

        for(int t = 0; t < this.temperatures.length; ++t) {
            Climate.Parameter temp = this.temperatures[t];

            for (int h = 0; h < this.humidities.length; ++h) {
                Climate.Parameter humid = this.humidities[h];
                ResourceKey<Biome> midOrBadHot = this.pickMidOrBadIfHot(t, h, pWierdness);
                this.addSurface(pConsumer, temp, humid, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), pWierdness, 0.0F, midOrBadHot);
            }
        }
    }

    private void addSurface(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pTemperature, Climate.Parameter pHumidity, Climate.Parameter pContinentalness, Climate.Parameter pErosion, Climate.Parameter pWierdness, float pOffset, ResourceKey<Biome> pKey) {
        pConsumer.accept(Pair.of(Climate.parameters(pTemperature, pHumidity, pContinentalness, pErosion, Climate.Parameter.point(0.0F), pWierdness, pOffset), pKey));
        pConsumer.accept(Pair.of(Climate.parameters(pTemperature, pHumidity, pContinentalness, pErosion, Climate.Parameter.point(1.0F), pWierdness, pOffset), pKey));
    }

    private void addUndergrounds(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsume) {
        this.addUnderground(pConsume, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.DRIPSTONE_CAVES);
        this.addUnderground(pConsume, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.LUSH_CAVES);
        this.addBottom(pConsume, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, Biomes.DEEP_DARK);
    }

    private ResourceKey<Biome> pickMid(int pTemperature, int pHumidity, Climate.Parameter pWeirdness) {
        if (pWeirdness.max() < 0L) {
            return CCTPlainBiomeSelectors.TPLAIN_MIDDLE_BIOMES[pTemperature][pHumidity]; // if it's FERVENT_FIELD, great — the BiomeSource will specialize it
        } else {
            ResourceKey<Biome> biome = CCTPlainBiomeSelectors.TPLAIN_MIDDLE_BIOMES_VARIANT[pTemperature][pHumidity];
            return biome == null ? CCTPlainBiomeSelectors.TPLAIN_MIDDLE_BIOMES[pTemperature][pHumidity] : biome;
        }
    }
    private ResourceKey<Biome> pickMidOrBadIfHot(int pTemperature, int pHumidity, Climate.Parameter pWeirdness) {
        return pTemperature == 4 ? this.pickBad(pHumidity, pWeirdness) : this.pickMid(pTemperature, pHumidity, pWeirdness);
    }
    private ResourceKey<Biome> pickMiddleOrBadIfHotOrSlopeIfCold(int pTemperature, int pHumidity, Climate.Parameter pWeirdness) {
        return pTemperature == 0 ? this.pickSlope(pTemperature, pHumidity, pWeirdness) : this.pickMidOrBadIfHot(pTemperature, pHumidity, pWeirdness);
    }
    private ResourceKey<Biome> maybePickWindSav(int pTemperature, int pHumidity, Climate.Parameter pWeirdness, ResourceKey<Biome> pKey) {
        return pTemperature > 1 && pHumidity < 4 && pWeirdness.max() >= 0L ? Biomes.WINDSWEPT_SAVANNA : pKey;
    }
    private ResourceKey<Biome> pickShattCoast(int pTemperature, int pHumidity, Climate.Parameter pWeirdness) {
        ResourceKey<Biome> biome = pWeirdness.max() >= 0L ? this.pickMid(pTemperature, pHumidity, pWeirdness) : this.pickBeach(pTemperature, pHumidity);
        return this.maybePickWindSav(pTemperature, pHumidity, pWeirdness, biome);
    }
    private ResourceKey<Biome> pickBeach(int pTemperature, int pHumidity) {
        if (pTemperature == 0) {
            return Biomes.SNOWY_BEACH;
        } else {
            return pTemperature == 4 ? CCBiomes.DISMAL_DESERT : Biomes.BEACH; // Dismal Desert replaces Desert
        }
    }
    private ResourceKey<Biome> pickBad(int pHumidity, Climate.Parameter pWeirdness) {
        if (pHumidity < 2) {
            return pWeirdness.max() < 0L ? Biomes.BADLANDS : Biomes.ERODED_BADLANDS;
        } else {
            return pHumidity < 3 ? Biomes.BADLANDS : Biomes.WOODED_BADLANDS;
        }
    }
    private ResourceKey<Biome> pickPlat(int pTemperature, int pHumidity, Climate.Parameter pWierdness) {
        if (pWierdness.max() >= 0L) {
            ResourceKey<Biome> biome = CCTPlainBiomeSelectors.TPLAIN_PLATEAU_BIOMES_VARIANT[pTemperature][pHumidity];
            if (biome != null) {
                return biome;
            }
        }
        return CCTPlainBiomeSelectors.TPLAIN_PLATEAU_BIOMES[pTemperature][pHumidity];
    }
    private ResourceKey<Biome> pickPeak(int pTemperature, int pHumidity, Climate.Parameter pWierdness) {
        if (pTemperature <= 2) {
            return pWierdness.max() < 0L ? CCBiomes.CHROMATIC_CRAGS : Biomes.FROZEN_PEAKS;
        } else {
            return pTemperature == 3 ? Biomes.STONY_PEAKS : this.pickBad(pHumidity, pWierdness); // Chromatic Crags replaces Stony Peaks
        }
    }
    private ResourceKey<Biome> pickSlope(int pTemperature, int pHumidity, Climate.Parameter pWierdness) {
        if (pTemperature >= 3) {
            return this.pickPlat(pTemperature, pHumidity, pWierdness);
        } else {
            return pHumidity <= 1 ? Biomes.SNOWY_SLOPES : Biomes.GROVE;
        }
    }
    private ResourceKey<Biome> pickShatt(int pTemperature, int pHumidity, Climate.Parameter pWierdness) {
        ResourceKey<Biome> biome = CCTPlainBiomeSelectors.TPLAIN_SHATTERED_BIOMES[pTemperature][pHumidity];
        return biome == null ? this.pickMid(pTemperature, pHumidity, pWierdness) : biome;
    }

    private void addUnderground(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pTemperature, Climate.Parameter pHumidity, Climate.Parameter pContinentalness, Climate.Parameter pErosion, Climate.Parameter pWierdness, float pOffset, ResourceKey<Biome> pKey) {
        pConsumer.accept(Pair.of(Climate.parameters(pTemperature, pHumidity, pContinentalness, pErosion, Climate.Parameter.span(0.2F, 0.9F), pWierdness, pOffset), pKey));
    }
    private void addBottom(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> pConsumer, Climate.Parameter pTemerature, Climate.Parameter pHumidity, Climate.Parameter pContinentalness, Climate.Parameter pErosion, Climate.Parameter pWierdness, float pOffset, ResourceKey<Biome> pKey) {
        pConsumer.accept(Pair.of(Climate.parameters(pTemerature, pHumidity, pContinentalness, pErosion, Climate.Parameter.point(1.1F), pWierdness, pOffset), pKey));
    }

    public static boolean isDeepDark(DensityFunction pErosionFunction, DensityFunction pDepthFunction, DensityFunction.FunctionContext pFunctionContext) {
        return pErosionFunction.compute(pFunctionContext) < -0.22499999403953552 && pDepthFunction.compute(pFunctionContext) > 0.8999999761581421;
    }

    public static String getDebugStringForPeaksAndValleys(double PVData) {
        if (PVData < (double) NoiseRouterData.peaksAndValleys(VALLEY_SIZE)) {
            return "Valley";
        } else if (PVData < (double)NoiseRouterData.peaksAndValleys(LOW_START)) {
            return "Low";
        } else if (PVData < (double)NoiseRouterData.peaksAndValleys(HIGH_START)) {
            return "Mid";
        } else {
            return PVData < (double)NoiseRouterData.peaksAndValleys(PEAK_START) ? "High" : "Peak";
        }
    }

    public String getDebugStringForContinentalness(double pContinentalness) {
        double cont = (double)Climate.quantizeCoord((float)pContinentalness);
        if (cont < (double)this.mushroomFieldsContinentalness.max()) {
            return "Mushroom fields";
        } else if (cont < (double)this.deepOceanContinentalness.max()) {
            return "Deep ocean";
        } else if (cont < (double)this.oceanContinentalness.max()) {
            return "Ocean";
        } else if (cont < (double)this.coastContinentalness.max()) {
            return "Coast";
        } else if (cont < (double)this.nearInlandContinentalness.max()) {
            return "Near inland";
        } else {
            return cont < (double)this.midInlandContinentalness.max() ? "Mid inland" : "Far inland";
        }
    }

    public String getDebugStringForErosion(double pErosion) {
        return getDebugStringForNoiseValue(pErosion, this.erosions);
    }

    public String getDebugStringForTemperature(double pTemperature) {
        return getDebugStringForNoiseValue(pTemperature, this.temperatures);
    }

    public String getDebugStringForHumidity(double pHumidity) {
        return getDebugStringForNoiseValue(pHumidity, this.humidities);
    }

    private static String getDebugStringForNoiseValue(double pValue, Climate.Parameter[] pValues) {
        double value = (double)Climate.quantizeCoord((float)pValue);

        for(int v = 0; v < pValues.length; ++v) {
            if (value < (double)pValues[v].max()) {
                return "" + v;
            }
        }

        return "?";
    }

    @VisibleForDebug
    public Climate.Parameter[] getTemperatureThresholds() {
        return this.temperatures;
    }

    @VisibleForDebug
    public Climate.Parameter[] getHumidityThresholds() {
        return this.humidities;
    }

    @VisibleForDebug
    public Climate.Parameter[] getErosionThresholds() {
        return this.erosions;
    }

    @VisibleForDebug
    public Climate.Parameter[] getContinentalnessThresholds() {
        return new Climate.Parameter[]{this.mushroomFieldsContinentalness, this.deepOceanContinentalness,
                this.oceanContinentalness, this.coastContinentalness, this.nearInlandContinentalness,
                this.midInlandContinentalness, this.farInlandContinentalness};
    }

    @VisibleForDebug
    public Climate.Parameter[] getPeaksAndValleysThresholds() {
        return new Climate.Parameter[]{Climate.Parameter.span(-2.0F, NoiseRouterData.peaksAndValleys(VALLEY_SIZE)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(VALLEY_SIZE), NoiseRouterData.peaksAndValleys(LOW_START)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(LOW_START), NoiseRouterData.peaksAndValleys(HIGH_START)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(HIGH_START), NoiseRouterData.peaksAndValleys(PEAK_START)), Climate.Parameter.span(NoiseRouterData.peaksAndValleys(PEAK_START), 2.0F)};
    }

    @VisibleForDebug
    public Climate.Parameter[] getWeirdnessThresholds() {
        return new Climate.Parameter[]{Climate.Parameter.span(-2.0F, 0.0F), Climate.Parameter.span(0.0F, 2.0F)};
    }
}
