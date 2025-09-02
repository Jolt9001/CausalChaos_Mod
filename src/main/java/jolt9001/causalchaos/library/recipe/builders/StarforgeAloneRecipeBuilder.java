package jolt9001.causalchaos.library.recipe.builders;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jolt9001.causalchaos.init.CCRecipes;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.compress.utils.Lists;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This recipe builder has properties of both a furnace and a crafting table.
 */
public class StarforgeAloneRecipeBuilder {
    public static class StarforgeAloneShapedRecipeBuilder implements RecipeBuilder {
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

        public StarforgeAloneShapedRecipeBuilder(RecipeCategory category, ItemLike result, int cookTime, float exp, int count) {
            this.category = category;
            this.result = result.asItem();
            this.cookTime = cookTime;
            this.exp = exp;
            this.count = count;
        }

        public static StarforgeAloneShapedRecipeBuilder shapedSingle(RecipeCategory category, ItemLike output, int cookTime, float exp) {
            return shapedMulti(category, output, cookTime, exp, 1);
        }

        public static StarforgeAloneShapedRecipeBuilder shapedMulti(RecipeCategory category, ItemLike output, int cookTime, float exp, int count) {
            return new StarforgeAloneShapedRecipeBuilder(category, output, cookTime, exp, count);
        }

        public StarforgeAloneShapedRecipeBuilder define(Character key, TagKey<Item> id) {
            return this.define(key, Ingredient.of(id));
        }

        public StarforgeAloneShapedRecipeBuilder define(Character key, ItemLike id) {
            return this.define(key, Ingredient.of(id));
        }

        public StarforgeAloneShapedRecipeBuilder define(Character key, Ingredient id) {
            if (this.key.containsKey(key)) {
                throw new IllegalArgumentException("Symbol '" + key + "' is already defined!");
            } else if (key == ' ') {
                throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
            } else {
                this.key.put(key, id);
                return this;
            }
        }

        public StarforgeAloneShapedRecipeBuilder pattern(String rows) {
            // enforce 3×3 rows; emit pattern, key, and result (object with item + count), cook_time, experience.
            if (rows.length() != 3) {
                throw new IllegalArgumentException("Starforge (alone) shaped recipes must be width 3 (got " + rows.length() + ")");
            }
            if (!this.rows.isEmpty() && rows.length() != this.rows.get(0).length()) {
                throw new IllegalArgumentException("Pattern must be the same width on every line.");
            }
            if (this.rows.size() >= 3) {
                throw new IllegalStateException("Starforge (alone) shaped recipes may only have 3 rows");
            }
            this.rows.add(rows);
            return this;
        }

        @Override
        public StarforgeAloneShapedRecipeBuilder unlockedBy(String name, Criterion<?> trigger) {
            this.criteria.put(name, trigger);
            return this;
        }

        @Override
        public StarforgeAloneShapedRecipeBuilder group(@Nullable String group) {
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
                    this.showNotification));
        }

        private void ensureValid(ResourceLocation id) {
            if (this.rows.size() != 3) {
                throw new IllegalStateException("Recipe " + id + " must have exactly 3 rows");
            }
            Set<Character> unused = Sets.newHashSet(this.key.keySet());
            unused.remove(' ');

            for (String r : this.rows) {
                if (r.length() != 3) throw new IllegalStateException("Recipe " + id + " rows must be length 3");
                for (int i = 0; i < r.length(); i++) {
                    char c = r.charAt(i);
                    if (c != ' ' && !this.key.containsKey(c)) {
                        throw new IllegalStateException("Recipe " + id + " uses undefined symbol '" + c + "'");
                    }
                    unused.remove(c);
                }
            }
            if (!unused.isEmpty()) {
                throw new IllegalStateException("Ingredients defined but not used in pattern for " + id + ": " + unused);
            }
            if (this.criteria.isEmpty()) {
                throw new IllegalStateException("No unlock criteria for recipe " + id);
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

        public ResultShaped(ResourceLocation id, String group, List<String> pattern, int count, Item result, float exp,
                            int cookTime, Map<Character, Ingredient> key, AdvancementHolder advancement, boolean showNotification) {
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
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            // (optional) group
            if (this.group != null && !this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            // pattern (preserve spaces)
            JsonArray arr = new JsonArray();
            for (String s : this.pattern) arr.add(s);
            json.add("pattern", arr);

            // key → map of symbol -> ingredient
            JsonObject keyObj = new JsonObject();
            for (Map.Entry<Character, Ingredient> e : this.key.entrySet()) {
                keyObj.add(String.valueOf(e.getKey()), e.getValue().toJson(false));
            }
            json.add("key", keyObj);

            // result (OBJECT, not "output" string)
            JsonObject resultObj = new JsonObject();
            ResourceLocation rl = ForgeRegistries.ITEMS.getKey(this.result);
            if (rl == null) throw new IllegalStateException("Unknown item: " + this.result);
            resultObj.addProperty("item", rl.toString());
            if (this.count > 1) resultObj.addProperty("count", this.count);
            json.add("result", resultObj);

            // extra fields your serializer expects
            json.addProperty("experience", this.exp);
            json.addProperty("cook_time", this.cookTime);

            // (optional) notifications flag if your serializer uses it
            json.addProperty("show_notification", this.showNotification);
        }
        @Override
        public RecipeSerializer<?> type() { return CCRecipes.STARFORGE_ALONE_SERIALIZER.get(); }
        @Override
        public ResourceLocation id() { return this.id; }
        @Nullable
        @Override
        public AdvancementHolder advancement() { return this.advancement; }
    }

    public static class StarforgeAloneShapelessRecipeBuilder implements RecipeBuilder {
        private final RecipeCategory category;
        private final Item result;
        private final int count;
        private final List<Ingredient> ingredients = Lists.newArrayList();
        private final float exp;
        private final int cookTime;
        private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
        @Nullable
        private String group;

        public StarforgeAloneShapelessRecipeBuilder(RecipeCategory category, Item result, int cookTime, float exp, int count) {
            this.category = category;
            this.result = result.asItem();
            this.cookTime = cookTime;
            this.exp = exp;
            this.count = count;
        }

        public static StarforgeAloneShapelessRecipeBuilder shapelessSingle(RecipeCategory category, int cookTime, float exp, Item output) {
            return shapelessMulti(category, output, cookTime, exp, 1);
        }

        public static StarforgeAloneShapelessRecipeBuilder shapelessMulti(RecipeCategory category, Item output, int cookTime, float exp, int count) {
            return new StarforgeAloneShapelessRecipeBuilder(category, output, cookTime, exp, count);
        }

        public StarforgeAloneShapelessRecipeBuilder requires(TagKey<Item> tag) {
            return this.requires(Ingredient.of(tag));
        }
        public StarforgeAloneShapelessRecipeBuilder requires(ItemLike item) {
            return this.requires(item, 1);
        }
        public StarforgeAloneShapelessRecipeBuilder requires(ItemLike item, int size) {
            for(int i = 0; i < size; ++i) {
                this.requires(Ingredient.of(item));
            }
            return this;
        }
        public StarforgeAloneShapelessRecipeBuilder requires(Ingredient ingredient) { return this.requires(ingredient, 1); }
        public StarforgeAloneShapelessRecipeBuilder requires(Ingredient ingredient, int size) {
            for(int i = 0; i < size; ++i) {
                this.ingredients.add(ingredient);
            }

            return this;
        }

        @Override
        public StarforgeAloneShapelessRecipeBuilder unlockedBy(String name, Criterion<?> trigger) {
            this.criteria.put(name, trigger);
            return this;
        }

        @Override
        public StarforgeAloneShapelessRecipeBuilder group(@Nullable String group) {
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
            finRec.accept(new StarforgeAloneRecipeBuilder.ResultShapeless(id, this.group, this.ingredients, this.result,
                    this.count, this.exp, this.cookTime,
                    advancement$builder.build(id.withPrefix("recipes/" + this.category.getFolderName() + "/"))));
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

        public ResultShapeless(ResourceLocation id, String group, List<Ingredient> ingredients, Item result, int count, float exp, int cookTime, AdvancementHolder advancement) {
            this.id = id;
            this.group = group;
            this.result = result;
            this.count = count;
            this.ingredients = ingredients;
            this.exp = exp;
            this.cookTime = cookTime;
            this.advancement = advancement;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            if (this.group != null && !this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            JsonArray ing = new JsonArray();
            for (Ingredient i : this.ingredients) ing.add(i.toJson(false));
            json.add("ingredients", ing);

            // result (OBJECT)
            JsonObject resultObj = new JsonObject();
            ResourceLocation rl = ForgeRegistries.ITEMS.getKey(this.result);
            if (rl == null) throw new IllegalStateException("Unknown item: " + this.result);
            resultObj.addProperty("item", rl.toString());
            if (this.count > 1) resultObj.addProperty("count", this.count);
            json.add("result", resultObj);

            // keep field names consistent with shaped
            json.addProperty("experience", this.exp);
            json.addProperty("cook_time", this.cookTime);
        }

        @Override
        public RecipeSerializer<?> type() { return CCRecipes.STARFORGE_ALONE_SERIALIZER.get(); }

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
