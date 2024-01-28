package jolt9001.causalchaos.library.ids;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.resources.ResourceLocation;

public final class CCBlockIds {
    public static final ResourceLocation COBALT_BLOCK = id("cobaltblock");

    private static ResourceLocation id(String id) {
        return new ResourceLocation(CausalChaos.MODID);
    }
}
