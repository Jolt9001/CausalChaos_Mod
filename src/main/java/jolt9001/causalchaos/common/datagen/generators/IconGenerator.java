package jolt9001.causalchaos.common.datagen.generators;

import net.minecraft.resources.ResourceLocation;

public class IconGenerator {
    public static final ResourceLocation RESUSCITATION_ICON = new ResourceLocation("causalchaos", "textures/icon.Resuscitation.png");
    public static final ResourceLocation NAT1 = new ResourceLocation("causalchaos", "textures/icon.nat1.png");

    // Private constructor to prevent instantiation
    private IconGenerator() {
        throw new IllegalStateException("Utility class");
    }
}
