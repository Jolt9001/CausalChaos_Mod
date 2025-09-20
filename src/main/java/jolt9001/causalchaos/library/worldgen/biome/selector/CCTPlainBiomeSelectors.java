package jolt9001.causalchaos.library.worldgen.biome.selector;

import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import terrablender.api.Region;

public class CCTPlainBiomeSelectors {
    public static final ResourceKey<Biome>[][] TPLAIN_OCEANS = new ResourceKey[][]{
            {CCBiomes.DEEP_FROZEN_ORIGINATIVE_OCEAN, CCBiomes.DEEP_COLD_ORIGINATIVE_OCEAN, CCBiomes.DEEP_ORIGINATIVE_OCEAN, CCBiomes.DEEP_LUKEWARM_ORIGINATIVE_OCEAN, CCBiomes.WARM_ORIGINATIVE_OCEAN},
            {CCBiomes.FROZEN_ORIGINATIVE_OCEAN,      CCBiomes.COLD_ORIGINATIVE_OCEAN,      CCBiomes.ORIGINATIVE_OCEAN,      CCBiomes.LUKEWARM_ORIGINATIVE_OCEAN,      CCBiomes.WARM_ORIGINATIVE_OCEAN}};
    public static final ResourceKey<Biome>[][] TPLAIN_MIDDLE_BIOMES = new ResourceKey[][]{ // pV near-inland/Mid Slice
            {Biomes.SNOWY_PLAINS,            Biomes.SNOWY_PLAINS,            Biomes.SNOWY_PLAINS,         CCBiomes.TRANSIENT_TAIGA,         Biomes.TAIGA},      // Temperature 0
            {CCBiomes.PERFECT_PLAINS,        CCBiomes.PERFECT_PLAINS,        CCBiomes.FATUOUS_FOREST,     Biomes.TAIGA,                     Biomes.OLD_GROWTH_SPRUCE_TAIGA},      // Temperature 1
            {CCBiomes.FERVENT_FIELD,         CCBiomes.PERFECT_PLAINS,        CCBiomes.FATUOUS_FOREST,     Biomes.BIRCH_FOREST,      CCBiomes.SKOURAINEI},              // Temperature 2
            {CCBiomes.SYSTEMATIC_SHRUBLANDS, CCBiomes.SYSTEMATIC_SHRUBLANDS, CCBiomes.FATUOUS_FOREST,     CCBiomes.REGENERATIVE_RAINFOREST, CCBiomes.REGENERATIVE_RAINFOREST}, // Temperature 3
            {CCBiomes.DISMAL_DESERT,         CCBiomes.DISMAL_DESERT,         CCBiomes.DISMAL_DESERT,      CCBiomes.DISMAL_DESERT,           CCBiomes.DISMAL_DESERT}};          // Temperature 4
    public static final ResourceKey<Biome>[][] TPLAIN_MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{ // pV near-inland/Mid Slice
            {CCBiomes.GELID_GLACIER,      null, CCBiomes.TRANSIENT_TAIGA,    CCBiomes.TRANSIENT_TAIGA,    null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, CCBiomes.PERFECT_PLAINS, null, null},
            {null, null, null, null, null}}; // These will remain placeholders
    public static final ResourceKey<Biome>[][] TPLAIN_PLATEAU_BIOMES = new ResourceKey[][]{ // pV near-inland/Mid Slice
            {Biomes.SNOWY_PLAINS,         Biomes.SNOWY_PLAINS,         Biomes.SNOWY_PLAINS,         CCBiomes.TRANSIENT_TAIGA,    CCBiomes.TRANSIENT_TAIGA},
            {Biomes.MEADOW, 	          Biomes.MEADOW,               CCBiomes.FATUOUS_FOREST,     Biomes.TAIGA,                Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW, 	          Biomes.MEADOW,               Biomes.MEADOW, 	            Biomes.MEADOW,               CCBiomes.SKOURAINEI},
            {Biomes.SAVANNA_PLATEAU,      Biomes.SAVANNA_PLATEAU,      CCBiomes.FATUOUS_FOREST,     CCBiomes.FATUOUS_FOREST,     CCBiomes.REGENERATIVE_RAINFOREST},
            {CCBiomes.CALESCENT_CALDERA,  CCBiomes.CALESCENT_CALDERA,  CCBiomes.CALESCENT_CALDERA,  Biomes.WOODED_BADLANDS,      Biomes.WOODED_BADLANDS}};
    public static final ResourceKey<Biome>[][] TPLAIN_PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {CCBiomes.GELID_GLACIER,      null, null, null, null},
            {CCBiomes.PETRIFYING_PLATEAU, null, null, null, null},
            {CCBiomes.PETRIFYING_PLATEAU, CCBiomes.PETRIFYING_PLATEAU, CCBiomes.FATUOUS_FOREST,     null, null},
            {null, null, null, null, null},  // These will remain placeholders
            {null, null, null, null, null}};
    public static final ResourceKey<Biome>[][] TPLAIN_SHATTERED_BIOMES = new ResourceKey[][]{
            {CCBiomes.QUIVERING_QUARRY,   CCBiomes.QUIVERING_QUARRY,    CCBiomes.HYPERBOLIC_HILLS,  null, null},
            {CCBiomes.QUIVERING_QUARRY,   CCBiomes.QUIVERING_QUARRY,    CCBiomes.HYPERBOLIC_HILLS,  null, null},
            {CCBiomes.HYPERBOLIC_HILLS,   CCBiomes.HYPERBOLIC_HILLS,    CCBiomes.HYPERBOLIC_HILLS,  null, null},
            {null, null, null, null, null},  // These will remain placeholders
            {null, null, null, null, null}}; // These will remain placeholders

}
