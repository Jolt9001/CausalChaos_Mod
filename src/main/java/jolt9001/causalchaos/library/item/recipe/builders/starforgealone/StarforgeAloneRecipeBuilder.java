package jolt9001.causalchaos.library.item.recipe.builders.starforgealone;

import com.google.gson.JsonObject;
import jolt9001.causalchaos.library.item.recipe.recipes.AbstractStarforgeRecipe;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This recipe builder has properties of both a furnace and a crafting table.
 */
public class StarforgeAloneRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Ingredient[][] ingredients;
    private final ItemStack output;
    private final float exp;
    private final int cookTime;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
    @Nullable
    private String group;
    private final RecipeSerializer<? extends AbstractStarforgeRecipe> serializer;

    public StarforgeAloneRecipeBuilder(RecipeCategory category, ItemStack output, Ingredient[][] ingredients, float exp, int cookTime, RecipeSerializer<? extends AbstractStarforgeRecipe> serializer) {
        this.category = category;
        this.output = output;
        this.ingredients = ingredients;
        this.exp = exp;
        this.cookTime = cookTime;
        this.serializer = serializer;
    }

    public static StarforgeAloneRecipeBuilder generic(RecipeCategory category, ItemStack output, Ingredient[][] ingredients, float exp, int cookTime, RecipeSerializer<? extends AbstractStarforgeRecipe> serializer) {
        return new StarforgeAloneRecipeBuilder(category, output, ingredients, exp, cookTime, serializer);
    }

    @Override
    public StarforgeAloneRecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
        this.criteria.put(criterionName, criterionTrigger);
        return this;
    }

    @Override
    public Item getResult() {
        return this.getResult();
    }

    @Override
    public StarforgeAloneRecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public void save(RecipeOutput finishedRecipeConsumer, ResourceLocation id) {

    }

    static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final Ingredient[][] ingredients; // [rows][columns]
        private final ItemStack output;
        private final float exp;
        private final int cookTime;
        private final AdvancementHolder advancement;
        private final RecipeSerializer<? extends AbstractStarforgeRecipe> serializer;

        public Result(ResourceLocation id, String group, Ingredient[][] ingredients, ItemStack output, float exp, int cookTime, AdvancementHolder advancement, RecipeSerializer<? extends AbstractStarforgeRecipe> serializer) {
            this.id = id;
            this.group = group;
            this.output = output;
            this.ingredients = ingredients;
            this.exp = exp;
            this.cookTime = cookTime;
            this.advancement = advancement;
            this.serializer = serializer;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }
            int size = 2;
            for (int i = 0; i <= size; i++) { // loops through the rows
                for (int j = 0; j <= size; j++) { // loops through the columns
                    json.add("ingredient", this.ingredients[i][j].toJson(true));
                    /*
                    [0,0] [0,1] [0,2]
                    [1,0] [1,1] [1,2]
                    [2.0] [2,1] [2,2]
                     */
                }
            }
            ResourceLocation itemLocation = ForgeRegistries.ITEMS.getKey(this.output.getItem());
            if (itemLocation != null) {
                json.addProperty("output", itemLocation.toString());
            } else {
                throw new IllegalStateException("Item: " + this.output + "does not exist");
            }
            json.addProperty("experience", this.exp);
            json.addProperty("cookingtime", this.cookTime);
        }

        @Override
        public RecipeSerializer<?> type() {
            return this.serializer;
        }

        @Override
        public ResourceLocation id() {
            return this.id;
        }

        @Nullable
        @Override
        public AdvancementHolder advancement() {
            return this.advancement;
        }
    }
}
