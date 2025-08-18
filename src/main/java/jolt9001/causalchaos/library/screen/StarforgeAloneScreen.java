package jolt9001.causalchaos.library.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import jolt9001.causalchaos.CausalChaos;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class StarforgeAloneScreen extends AbstractContainerScreen<StarforgeAloneMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CausalChaos.MODID, "textures/gui/machines/starforge_alone.png");

    protected int tier;

    public StarforgeAloneScreen(StarforgeAloneMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
        this.tier = menu.tier;
    }

    @Override
    public void init() {
        super.init();
        this.inventoryLabelY = 146 - 33;
        this.titleLabelY = 6-33;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2 - 33;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, 203, 239); // width: 203px, height: 239px

        renderTierIndicator(guiGraphics, x, y, tier);
        renderProgressArrow(guiGraphics, x, y);
        renderBurnRemainderGraphic(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) { // 139, 72
        if(menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 139, y + 72, 204, 14, menu.getScaledProgress(), 17);
        }
    }

    private void renderBurnRemainderGraphic(GuiGraphics guiGraphics, int x, int y) { // 140, 110
        if (menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 140, y + 110, 204, 0, 8, menu.getBurnRemainder());
        }
    }

    private void renderTierIndicator(GuiGraphics guiGraphics, int x, int y, int tier) {
        switch (tier) {
            case 0 -> guiGraphics.blit(TEXTURE, x + 186, y + 19, 204, 31, 9, 11);
            case 1 -> guiGraphics.blit(TEXTURE, x + 186, y + 19, 204, 42, 9, 11);
            case 2 -> guiGraphics.blit(TEXTURE, x + 186, y + 19, 204, 53, 9, 11);
            case 3 -> guiGraphics.blit(TEXTURE, x + 186, y + 19, 204, 64, 9, 11);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        /*
        if (this.recipeBookComponent.isVisible() && this.widthTooNarrow) {
            this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
            this.recipeBookComponent.render(guiGraphics, mouseX, mouseY, partialTicks);
        } else {
            super.render(guiGraphics, mouseX, mouseY, partialTicks);
            this.recipeBookComponent.render(guiGraphics, mouseX, mouseY, partialTicks);
            this.recipeBookComponent.renderGhostRecipe(guiGraphics, this.leftPos, this.topPos, true, partialTicks);
        }
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        this.recipeBookComponent.renderTooltip(guiGraphics, this.leftPos, this.topPos, mouseX, mouseY);
         */
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
        super.render(guiGraphics, mouseX, mouseY, partialTicks);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
