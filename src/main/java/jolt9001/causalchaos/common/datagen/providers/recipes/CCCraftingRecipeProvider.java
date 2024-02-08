package jolt9001.causalchaos.common.datagen.providers.recipes;

import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class CCCraftingRecipeProvider extends RecipeProvider {
    private RecipeOutput out;

    public CCCraftingRecipeProvider(PackOutput o) {
        super(o);
    }

    @Override
    protected void buildRecipes(RecipeOutput o) {

    }
}
