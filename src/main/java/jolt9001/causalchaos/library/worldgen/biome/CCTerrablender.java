package jolt9001.causalchaos.library.worldgen.biome;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class CCTerrablender {
    public static void registerBiomes() {
        Regions.register(new CCOverworldRegion(new ResourceLocation(CausalChaos.MODID, "overworld"), 5));
    }
}
