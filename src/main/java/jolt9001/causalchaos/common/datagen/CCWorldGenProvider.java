package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.worldgen.CCBiomeModifiers;
import jolt9001.causalchaos.library.worldgen.CCConfiguedFeatures;
import jolt9001.causalchaos.library.worldgen.CCPlacedFeatures;
import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
import jolt9001.causalchaos.library.worldgen.dimension.CCDimensions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CCWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, CCDimensions::bootstrapTypeTPlain)
            .add(Registries.CONFIGURED_FEATURE, CCConfiguedFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, CCPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, CCBiomeModifiers::bootstrap)
            .add(Registries.BIOME, CCBiomes::boostrap)
            .add(Registries.LEVEL_STEM, CCDimensions::bootstrapStemTPlain);

    public CCWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CausalChaos.MODID));
    }
}
