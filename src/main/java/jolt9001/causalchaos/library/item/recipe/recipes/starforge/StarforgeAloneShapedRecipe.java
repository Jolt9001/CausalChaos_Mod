package jolt9001.causalchaos.library.item.recipe.recipes.starforge;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import jolt9001.causalchaos.library.item.recipe.CCRecipeTypes;

import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.Nullable;

public class StarforgeAloneShapedRecipe implements Recipe<Container> {

    // Recipe type and identification
    protected final RecipeType<?> type;
    protected final String group;
    protected final CompoundTag tag;

    // Size of grid
    protected final int width;
    protected final int height;

    // array of Ingredient inputs, ItemStack for outputs, and the cook time.
    protected final Ingredient[][] ingredients;
    protected final ItemStack output;
    protected final int cookTime;

    public StarforgeAloneShapedRecipe(int width, int height, String group, Ingredient[][] ingredients, CompoundTag tag, int cookTime, ItemStack output) {
        this.type = CCRecipeTypes.STARFORGE_ALONE.get();
        this.width = width;
        this.height=height;
        this.group = group;
        this.ingredients = ingredients;
        this.tag = tag;
        this.cookTime = cookTime;
        this.output = output;
    }

    public ItemStack getRecipeOutput() {
        return this.output;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess access) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) {
        return true;
    }

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
        return this.type;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public static class Serializer implements RecipeSerializer<StarforgeAloneShapedRecipe> {
        /*
        @Override
        public StarforgeAloneShapedRecipe fromJson(ResourceLocation recipeLocation, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");
            int size = 2;
            Ingredient[][] ingredients = new Ingredient[size][size];
            for (int i = 0; i <= size; i++) { // loops through the rows
                for (int j = 0; j <= size; j++) { // loops through the columns
                    ingredients[i][j] = Ingredient.fromJson(recipeLocation, GsonHelper.getAsJsonObject(json, "ingredient" + i + "," + j));
                }
            }
            CompoundTag tag = null;
            if (json.has("tag")) {
                tag = CraftingHelper.getNBT(json.get("tag"));
            }
            int cookTime = GsonHelper.getAsInt(json, "cooktime");
            ItemStack output = GsonHelper.getAsObject(json, "output", "", "");
            return new StarforgeAloneShapedRecipe(recipeLocation, size, size, group, ingredients, tag, cookTime, output);
        }
         */

        /*
        [0,0] [0,1] [0,2]
        [1,0] [1,1] [1,2]
        [2.0] [2,1] [2,2]
        */

        private static final Codec<StarforgeAloneShapedRecipe> CODEC = RecordCodecBuilder.create((instance) ->
                instance.group(ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(func -> func.group),
                        Ingredient.CODEC_NONEMPTY.optionalFieldOf("ingredients").forGetter(func -> func.ingredients[2][2]),
                        CompoundTag.CODEC.optionalFieldOf("tag").forGetter(func -> func.tag),
                        Codec.INT.optionalFieldOf("cooktime").forGetter(func -> func.cookTime),
                        ItemStack.CODEC.optionalFieldOf("output").forGetter(func -> func.output))
                        .apply(instance, StarforgeAloneShapedRecipe::new));

        @Nullable
        @Override
        public StarforgeAloneShapedRecipe fromNetwork(FriendlyByteBuf buffer) {
            String group = buffer.readUtf();
            int size = 2;
            Ingredient[][] ingredients = new Ingredient[size][size];
            for (int i = 0; i <= size; i++) { // loops through the rows
                for (int j = 0; j <= size; j++) { // loops through the columns
                    ingredients[i][j] = Ingredient.fromNetwork(buffer);
                }
            }
            CompoundTag tag = null;
            if (buffer.readBoolean()) {
                tag = buffer.readNbt();
            }
            int cookTime = buffer.readVarInt();
            ItemStack output = buffer.readItem();
            return new StarforgeAloneShapedRecipe(size, size, group, ingredients, tag, cookTime, output);
        }

        @Override
        public Codec<StarforgeAloneShapedRecipe> codec() {
            return CODEC;
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, StarforgeAloneShapedRecipe recipe) {
            buffer.writeUtf(recipe.group);
            int size = 2;
            Ingredient[][] ingredients = new Ingredient[size][size];
            for (int i = 0; i <= size; i++) { // loops through the rows
                for (int j = 0; j <= size; j++) { // loops through the columns
                    ingredients[i][j].toNetwork(buffer);
                }
            }
            if (recipe.tag != null) {
                buffer.writeBoolean(true);
                buffer.writeNbt(recipe.tag);
            } else {
                buffer.writeBoolean(false);
            }
            buffer.writeVarInt(recipe.getCookTime());
        }
    }
}
