package jolt9001.causalchaos.library.recipe.recipes.starforge;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jolt9001.causalchaos.init.CCRecipes;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;


import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StarforgeAloneRecipe implements Recipe<Container> {

    // Recipe type and identification
    protected final String group;
    protected final CompoundTag tag;

    // Size of grid
    // protected final int gridSize;

    // array of Ingredient inputs, ItemStack for outputs, and the cook time.
    protected final List<Ingredient> ingredients;
    protected final ItemStack output;
    protected final int cookTime;

    public StarforgeAloneRecipe(String group, List<Ingredient> ingredients, CompoundTag tag, int cookTime, ItemStack output) {
        // this.gridSize = gridSize
        this.group = group;
        this.ingredients = ingredients;
        this.tag = tag;
        this.cookTime = cookTime;
        this.output = output;
    }


    @Override
    public boolean matches(Container container, Level level) {
        if (level.isClientSide()) {
            return false;
        }
        return ingredients.get(0).test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess access) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) { return true; }

    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return output;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(ingredients);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CCRecipes.STARFORGE_ALONE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return CCRecipes.STARFORGE_ALONE.get();
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public static class Type implements RecipeType<StarforgeAloneRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID ="starforge_alone";
    }

    public static class Serializer implements RecipeSerializer<StarforgeAloneRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        // public static final ResourceLocation ID = new ResourceLocation(CausalChaos.MODID, "starforge_alone");

        private static final Codec<StarforgeAloneRecipe> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
                // ExtraCodecs.strictOptionalField(Codec.INT, "grid_size", 2).forGetter(func -> func.gridSize),
                ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(func -> func.group), // Group
                Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").forGetter(func -> func.ingredients), // Ingredients
                CompoundTag.CODEC.fieldOf("tag").forGetter(func -> func.tag), // Tag
                Codec.INT.fieldOf("cook_time").forGetter(func -> func.cookTime), // int Cook Time
                ItemStack.CODEC.fieldOf("output").forGetter(func -> func.output) // ItemStack Output
        ).apply(instance, StarforgeAloneRecipe::new));
/*
        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return ExtraCodecs.validate(ExtraCodecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }
 */

        @Override
        public Codec<StarforgeAloneRecipe> codec() {
            return CODEC;
        }

        @Nullable
        @Override
        public StarforgeAloneRecipe fromNetwork(FriendlyByteBuf buf) { // READ
            String group = buf.readUtf();
            // int gridSize = 2;
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            CompoundTag tag = null;
            if (buf.readBoolean()) {
                tag = buf.readNbt();
            }
            int cookTime = buf.readVarInt();
            ItemStack output = buf.readItem();
            return new StarforgeAloneRecipe(group, inputs, tag, cookTime, output);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, StarforgeAloneRecipe recipe) {
            buf.writeUtf(recipe.group);
            // int size = 2;
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buf);
            }

            if (recipe.tag != null) {
                buf.writeBoolean(true);
                buf.writeNbt(recipe.tag);
            } else {
                buf.writeBoolean(false);
            }
            buf.writeVarInt(recipe.getCookTime());
            buf.writeItemStack(recipe.getResultItem(null), true);
        }
    }
}
