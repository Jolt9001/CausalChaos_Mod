package jolt9001.causalchaos.library.screen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.block.custom.StarforgeBlock;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class StarforgeMultiblockScreen extends AbstractContainerScreen<StarforgeMultiblockMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CausalChaos.MODID, "textures/gui/starforge_alone.png");
    private static int tier;

    public StarforgeMultiblockScreen(StarforgeMultiblockMenu menu, Inventory inv, Component comp) {
        super(menu, inv, comp);
        tier = StarforgeBlock.getTier();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics p_283065_, float p_97788_, int p_97789_, int p_97790_) {

    }
}
