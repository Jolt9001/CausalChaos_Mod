package jolt9001.causalchaos.library.ids;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.resources.ResourceLocation;

public final class CCBlockIds {
    // Storage Blocks
    public static final ResourceLocation COBALT_BLOCK = id("cobalt_block");
    public static final ResourceLocation IRIDIUM_BLOCK = id("iridium_block");
    public static final ResourceLocation NEODYMIUM_BLOCK = id("neodymium_block");
    public static final ResourceLocation PALLADIUM_BLOCK = id("palladium_block");
    public static final ResourceLocation PERPLEXIUM_BLOCK = id("perplexium_block");
    public static final ResourceLocation THUNDERSTEEL_BLOCK = id("thundersteel_block");
    public static final ResourceLocation TITANIUM_BLOCK = id("titanium_block");
    public static final ResourceLocation TUNGSTEN_BLOCK = id("tungsten_block");

    // Stone Ore
    public static final ResourceLocation COBALT_ORE = id("cobalt_ore");
    public static final ResourceLocation IRIDIUM_ORE = id("iridium_ore");
    public static final ResourceLocation NEODYMIUM_ORE = id("neodymium_ore");
    public static final ResourceLocation PALLADIUM_ORE = id("palladium_ore");
    public static final ResourceLocation TITANIUM_ORE = id("titanium_ore");
    public static final ResourceLocation TUNGSTEN_ORE = id("tungsten_ore");

    //Deepslate Ore
    public static final ResourceLocation DEEPSLATE_COBALT_ORE = id("deepslate_cobalt_ore");
    public static final ResourceLocation DEEPSLATE_IRIDIUM_ORE = id("deepslate_iridium_ore");
    public static final ResourceLocation DEEPSLATE_NEODYMIUM_ORE = id("deepslate_neodymium_ore");
    public static final ResourceLocation DEEPSLATE_PALLADIUM_ORE = id("deepslate_palladium_ore");
    public static final ResourceLocation DEEPSLATE_TITANIUM_ORE = id("deepslate_titanium_ore");
    public static final ResourceLocation DEEPSLATE_TUNGSTEN_ORE = id("deepslate_tungsten_ore");

    private static ResourceLocation id(String id) {
        return new ResourceLocation(CausalChaos.MODID);
    }
}
