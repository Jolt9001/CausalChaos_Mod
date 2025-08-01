package jolt9001.causalchaos.library.recipe.builders;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jolt9001.causalchaos.init.CCRecipes;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StarforgeMultiblockRecipeBuilder  {
    public static class StarforgeMultiblockShapedRecipeBuilder implements RecipeBuilder {
        private final RecipeCategory category;
        private final List<String> rows = Lists.newArrayList();
        private final Item result;
        private final int count;
        private final float exp;
        private final int cookTime;
        private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
        private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
        @Nullable
        private String group;
        private boolean showNotification = true;
        private int tier;

        public StarforgeMultiblockShapedRecipeBuilder(RecipeCategory category, Item result, int cookTime, float exp,  int count, int tier) {
            this.category = category;
            this.result = result.asItem();
            this.cookTime = cookTime;
            this.exp = exp;
            this.count = count;
            this.tier = tier;
        }

        public static StarforgeMultiblockShapedRecipeBuilder shapedSingle(RecipeCategory category, Item result, int cookTime, float exp, int tier) {
            return shapedMulti(category, result, cookTime, exp, 1, tier);
        }
        public static StarforgeMultiblockShapedRecipeBuilder shapedMulti(RecipeCategory category, Item result, int cookTime, float exp, int count, int tier) {
            return new StarforgeMultiblockShapedRecipeBuilder(category, result, cookTime, exp, count, tier);
        }

        public StarforgeMultiblockShapedRecipeBuilder define(Character key, TagKey<Item> id) {
            return this.define(key, Ingredient.of(id));
        }

        public StarforgeMultiblockShapedRecipeBuilder define(Character key, ItemLike id) {
            return this.define(key, Ingredient.of(id));
        }

        public StarforgeMultiblockShapedRecipeBuilder define(Character key, Ingredient id) {
            if (this.key.containsKey(key)) {
                throw new IllegalArgumentException("Symbol '" + key + "' is already defined!");
            } else if (key == ' ') {
                throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
            } else {
                this.key.put(key, id);
                return this;
            }
        }

        public StarforgeMultiblockShapedRecipeBuilder pattern(String rows) {
            if (!this.rows.isEmpty() && rows.length() != this.rows.get(0).length()) {
                throw new IllegalArgumentException("Pattern must be the same width on every line.");
            } else {
                this.rows.add(rows);
                return this;
            }
        }
        @Override
        public StarforgeMultiblockShapedRecipeBuilder unlockedBy(String name, Criterion<?> trigger) {
            this.criteria.put(name, trigger);
            return this;
        }
        @Override
        public StarforgeMultiblockShapedRecipeBuilder group(@Nullable String group) {
            this.group = group;
            return this;
        }
        @Override
        public Item getResult() { return this.result; }

        @Override
        public void save(RecipeOutput finCons, ResourceLocation id) {
            this.ensureValid(id);
            Advancement.Builder advancement$builder = finCons.advancement()
                    .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                    .rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
            this.criteria.forEach(advancement$builder::addCriterion);
            finCons.accept(new ResultShaped(id, this.group, this.rows, this.count, this.result, this.exp, this.cookTime,
                    this.key, advancement$builder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")),
                    this.showNotification, this.tier));
        }

        private void ensureValid(ResourceLocation id) {
            if (this.rows.isEmpty()) {
                throw new IllegalStateException("No pattern defined for recipe " + id);
            } else {
                Set<Character> set = Sets.newHashSet(this.key.keySet());
                set.remove(' ');

                for (String s : this.rows) {
                    for (int i = 0; i < s.length(); ++i) {
                        char c0 = s.charAt(i);
                        if (!this.key.containsKey(c0) && c0 != ' ') {
                            throw new IllegalStateException("Pattern in recipe " + id + " uses undefined symbol '" + c0 + "'");
                        }
                        set.remove(c0);
                    }
                }

                if (!set.isEmpty()) {
                    throw new IllegalStateException("Ingredients are defined but not used in pattern for recipe " + id);
                } else if (this.rows.size() == 1 && this.rows.get(0).length() == 1) {
                    throw new IllegalStateException("Shaped recipe " + id + " only takes in a single item - should it be a shapeless recipe instead?");
                } else if (this.criteria.isEmpty()) {
                    throw new IllegalStateException("No way of obtaining recipe " + id);
                }
            }
        }
    }

    static class ResultShaped implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final List<String> pattern; // List of ingredients
        private final Item result;
        private final float exp;
        private final int cookTime;
        private final int count;
        private final Map<Character, Ingredient> key;
        private final AdvancementHolder advancement;
        private final boolean showNotification;
        private final int tier;

        public ResultShaped(ResourceLocation id, String group, List<String> pattern, int count, Item result, float exp,
                            int cookTime, Map<Character, Ingredient> key, AdvancementHolder advancement, boolean showNotification, int tier) {
            this.id = id;
            this.group = group;
            this.result = result;
            this.count = count;
            this.pattern = pattern;
            this.exp = exp;
            this.cookTime = cookTime;
            this.key = key;
            this.advancement = advancement;
            this.showNotification = showNotification;
            this.tier = tier;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            JsonArray jsonArray = new JsonArray();
            for (String s : this.pattern) {
                jsonArray.add(s);
            }
            json.add("pattern", jsonArray);

            ResourceLocation itemLocation = ForgeRegistries.ITEMS.getKey(this.result.asItem());
            JsonObject jsonObject1 = new JsonObject();
            jsonObject1.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            if (itemLocation != null) {
                json.addProperty("output", itemLocation.toString());
                if (this.count > 1) {
                    jsonObject1.addProperty("count", this.count);
                }
            } else {
                throw new IllegalStateException("Item: " + this.result + "does not exist");
            }
            json.addProperty("experience", this.exp);
            json.addProperty("cookingtime", this.cookTime);
            json.addProperty("show_notification", this.showNotification);
            json.addProperty("tier", this.tier);
        }

        @Override
        public RecipeSerializer<?> type() {
            return CCRecipes.STARFORGE_MULTIBLOCK_SERIALIZER.get();
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

    public static class StarforgeMultiblockShapelessRecipeBuilder implements RecipeBuilder {
        private final RecipeCategory category;
        private final Item result;
        private final int count;
        private final List<Ingredient> ingredients = Lists.newArrayList();
        private final float exp;
        private final int cookTime;
        private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
        @Nullable
        private String group;
        private int tier;

        public StarforgeMultiblockShapelessRecipeBuilder(RecipeCategory category, Item result, int cookTime, float exp, int count, int tier) {
            this.category = category;
            this.result = result.asItem();
            this.cookTime = cookTime;
            this.exp = exp;
            this.count = count;
            this.tier = tier;
        }

        public static StarforgeMultiblockShapelessRecipeBuilder shapelessSingle(RecipeCategory category, int cookTime, float exp, Item output, int tier) {
            return shapelessMulti(category, output, cookTime, exp, 1, tier);
        }

        public static StarforgeMultiblockShapelessRecipeBuilder shapelessMulti(RecipeCategory category, Item output, int cookTime, float exp, int count, int tier) {
            return new StarforgeMultiblockShapelessRecipeBuilder(category, output, cookTime, exp, count, tier);
        }

        public StarforgeMultiblockShapelessRecipeBuilder requires(TagKey<Item> tag) {
            return this.requires(Ingredient.of(tag));
        }
        public StarforgeMultiblockShapelessRecipeBuilder requires(ItemLike item) { return this.requires(item, 1); }
        public StarforgeMultiblockShapelessRecipeBuilder requires(ItemLike item, int size) {
            for(int i = 0; i < size; ++i) {
                this.requires(Ingredient.of(item));
            }
            return this;
        }
        public StarforgeMultiblockShapelessRecipeBuilder requires(Ingredient ingredient) { return this.requires(ingredient, 1); }
        public StarforgeMultiblockShapelessRecipeBuilder requires(Ingredient ingredient, int size) {
            for(int i = 0; i < size; ++i) {
                this.ingredients.add(ingredient);
            }
            return this;
        }

        @Override
        public StarforgeMultiblockShapelessRecipeBuilder unlockedBy(String name, Criterion<?> trigger) {
            this.criteria.put(name, trigger);
            return this;
        }

        @Override
        public StarforgeMultiblockShapelessRecipeBuilder group(@Nullable String group) {
            this.group = group;
            return this;
        }

        @Override
        public Item getResult() { return this.result; }

        @Override
        public void save(RecipeOutput finRec, ResourceLocation id) {
            this.ensureValid(id);
            Advancement.Builder advancement$builder = finRec.advancement()
                    .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                    .rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
            this.criteria.forEach(advancement$builder::addCriterion);
            finRec.accept(new ResultShapeless(id, this.group, this.ingredients, this.result,
                    this.count, this.exp, this.cookTime,
                    advancement$builder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/")), this.tier));
        }

        private void ensureValid(ResourceLocation id) {
            if (this.criteria.isEmpty()) {
                throw new IllegalStateException("No way of obtaining recipe " + id);
            }
        }
    }

    static class ResultShapeless implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final List<Ingredient> ingredients; // List of ingredients
        private final Item result;
        private final int count;
        private final float exp;
        private final int cookTime;
        private final AdvancementHolder advancement;
        private final int tier;

        public ResultShapeless(ResourceLocation id, String group, List<Ingredient> ingredients, Item result, int count, float exp, int cookTime, AdvancementHolder advancement, int tier) {
            this.id = id;
            this.group = group;
            this.result = result;
            this.count = count;
            this.ingredients = ingredients;
            this.exp = exp;
            this.cookTime = cookTime;
            this.advancement = advancement;
            this.tier = tier;
        }
        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            JsonArray jsonArray = new JsonArray();
            for (Ingredient ingredient : this.ingredients) {
                jsonArray.add(ingredient.toJson(false));
            }
            json.add("ingredients", jsonArray);

            ResourceLocation itemLocation = ForgeRegistries.ITEMS.getKey(this.result.asItem());
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            if (itemLocation != null) {
                json.addProperty("output", itemLocation.toString());
                if (this.count > 1) {
                    jsonObject.addProperty("count", this.count);
                }
            } else {
                throw new IllegalStateException("Item: " + this.result + "does not exist");
            }
            json.addProperty("experience", this.exp);
            json.addProperty("cookingtime", this.cookTime);
            json.addProperty("tier", this.tier);
        }

        @Override
        public @NotNull RecipeSerializer<?> type() { return CCRecipes.STARFORGE_MULTIBLOCK_SERIALIZER.get(); }

        @Override
        public @NotNull ResourceLocation id() {
            return this.id;
        }

        @Nullable
        @Override
        public AdvancementHolder advancement() {
            return this.advancement;
        }
    }
}