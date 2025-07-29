package jolt9001.causalchaos.library.worldgen;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class CCBiomeModifiers {
    public static void bootstrap(BootstapContext<BiomeModifier> context) {

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CausalChaos.MODID, name));
    }
}
