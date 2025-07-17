package jolt9001.causalchaos.common.datagen.custom;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.datagen.helpers.CraftingDataHelper;
import jolt9001.causalchaos.init.CCBlocks;
import jolt9001.causalchaos.init.CCItems;
import jolt9001.causalchaos.library.recipe.builders.StarforgeAloneRecipeBuilder.*;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;

public class StarforgeAloneGenerator extends CraftingDataHelper {
    public StarforgeAloneGenerator(PackOutput out) { super(out); }

    @Override
    public void buildRecipes(RecipeOutput out) {
        StarforgeAloneShapedRecipeBuilder.shapedSingle(RecipeCategory.MISC, CCBlocks.T1_CORE_SHIELDING.get(), 10, 3)
                .pattern("wiw")
                .pattern("ini")
                .pattern("wiw")
                .define('w', CCItems.TUNGSTEN_INGOT.get())
                .define('i', CCItems.IRIDIUM_INGOT.get())
                .define('n', Items.NETHERITE_INGOT)
                .save(out, CausalChaos.prefix("machines/t1_core_shield"));
    }
}
