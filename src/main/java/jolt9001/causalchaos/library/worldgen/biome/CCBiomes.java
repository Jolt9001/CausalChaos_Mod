package jolt9001.causalchaos.library.worldgen.biome;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class CCBiomes {
    // Transcendent's Plain
        // Superboss Domains
    public static final ResourceKey<Biome> CRYSTAL_CLIFFS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_tsuna")); // Tsuna
    public static final ResourceKey<Biome> DISMAL_DESERT = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_kai")); // Kai
    public static final ResourceKey<Biome> SYSTEMATIC_SHRUBLANDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_terry")); // Terry
    public static final ResourceKey<Biome> PETRIFYING_PLATEAU = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_lyadova")); // Lyadova
    public static final ResourceKey<Biome> CHROMATIC_CRAGS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_aella")); // Aella, Similar to Stony Peaks
    public static final ResourceKey<Biome> GELID_GLACIER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_jack")); // Jack
    public static final ResourceKey<Biome> SKOURAINEI = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_xanthea")); // Xanthea, similar to Dark Forest
    public static final ResourceKey<Biome> HYPERBOLIC_HILLS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_will")); // Will
    public static final ResourceKey<Biome> FATUOUS_FOREST = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_matthue")); // Matthue
    public static final ResourceKey<Biome> HALCYON_HIGHLAND = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_alline")); // Alline
    public static final ResourceKey<Biome> FERVENT_FIELD = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_madeline")); // Madeline
    public static final ResourceKey<Biome> SUBCONSCIOUS_SWAMP = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_emily")); // Emily
    public static final ResourceKey<Biome> CALESCENT_CALDERA = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_adrian")); // Adrian
    public static final ResourceKey<Biome> TRANSIENT_TERRACE = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_andrea")); // Andrea
    public static final ResourceKey<Biome> QUIVERING_QUARRY = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_rex")); // Rex
    public static final ResourceKey<Biome> PERFECT_PLAINS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/biome_jolt")); // Jolt
        // Other Biomes
    public static final ResourceKey<Biome> RADIANT_RIVER = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "final/radiant_river")); // Separator biome for biome map continuity

    // Sky
    public static final ResourceKey<Biome> CUMULUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/cumulus"));
    public static final ResourceKey<Biome> STRATUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/stratus"));
    public static final ResourceKey<Biome> CIRRUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/cirrus"));
    public static final ResourceKey<Biome> NIMBUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/nimbus"));
    public static final ResourceKey<Biome> CUMULONIMBUS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "sky/cumulonimbus"));

    // Limbo
    public static final ResourceKey<Biome> REALMWEAVE_LANDS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "limbo/realmweave_lands"));
    public static final ResourceKey<Biome> WORLD_THREAD_FLATS = ResourceKey.create(Registries.BIOME, new ResourceLocation(CausalChaos.MODID, "limbo/world_thread_flats"));
}
