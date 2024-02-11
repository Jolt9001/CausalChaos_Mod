package jolt9001.causalchaos.library.item.recipe.recipes.starforgemultiblock;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class StarforgeMultiblockShapedRecipe implements Recipe<Container> {
    // hardcoded input grid size
    private static final int MAX_GRID_WIDTH = 7;
    private static final int MAX_GRID_HEIGHT = 7;

    @Override
    public boolean matches(Container container, Level level) {
        return false;
    }

    /**
     * @return An empty {@link ItemStack}, as there is no item output.
     */
    @Override
    public ItemStack assemble(Container container, RegistryAccess access) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) {
        return true;
    }

    /**
     * @return The original {@link ItemStack} ingredient for Recipe Book display.
     */
    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return null;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }
}
