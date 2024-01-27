package jolt9001.causalchaos.library.ids;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class CCCreativeTabIds {
    private CCCreativeTabIds() {
    }

    public static final ResourceKey<CreativeModeTab> MAIN = create("main");

    private static ResourceKey<CreativeModeTab> create(String path) {
        return ResourceKey.create((Registries.CREATIVE_MODE_TAB, ))
    }
}
