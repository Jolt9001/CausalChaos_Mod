package jolt9001.causalchaos.library.ids;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.resources.ResourceLocation;

public final class CCItemIds {
    public static final ResourceLocation JOURNAL = id("journal");

    private static ResourceLocation id(String id) {
        return new ResourceLocation(CausalChaos.MODID);
    }
}
