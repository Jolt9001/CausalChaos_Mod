package jolt9001.causalchaos.library.recipe.recipes.starforgemultiblock;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.recipe.recipes.starforge.StarforgeAloneRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StarforgeMultiblockRecipe implements Recipe<Container> {
    // Recipe type and identification
    protected final String group;
    protected final CompoundTag tag;

    // Size of grid
    // protected final int gridSize;

    // Tier
    protected final int tier;

    // array of Ingredient inputs, ItemStack for outputs, and the cook time.
    protected final List<Ingredient> ingredients;
    protected final ItemStack output;
    protected final int cookTime;

    public StarforgeMultiblockRecipe(String group, List<Ingredient> ingredients, CompoundTag tag, int cookTime, ItemStack output, int tier) {
        // this.gridSize = gridSize
        this.group = group;
        this.ingredients = ingredients;
        this.tag = tag;
        this.cookTime = cookTime;
        this.output = output;
        this.tier = tier;
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
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

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
        return null;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }

    public static class Type implements RecipeType<StarforgeMultiblockRecipe> {
        public static final StarforgeMultiblockRecipe.Type INSTANCE = new StarforgeMultiblockRecipe.Type();
        public static final String ID ="starforge_multiblock";
    }

    public static class Serializer implements RecipeSerializer<StarforgeMultiblockRecipe> {
        public static final StarforgeMultiblockRecipe.Serializer INSTANCE = new StarforgeMultiblockRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(CausalChaos.MODID, "starforge_alone");


        private static final Codec<StarforgeMultiblockRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                // ExtraCodecs.strictOptionalField(Codec.INT, "grid_size", 2).forGetter(func -> func.gridSize),
                ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(func -> func.group),
                Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").forGetter(func -> func.ingredients),
                CompoundTag.CODEC.fieldOf("tag").forGetter(func -> func.tag),
                Codec.INT.fieldOf("cook_time").forGetter(func -> func.cookTime),
                ItemStack.CODEC.fieldOf("output").forGetter(func -> func.output),
                Codec.INT.fieldOf("tier").forGetter(func -> func.tier)
        ).apply(instance, StarforgeMultiblockRecipe::new));
/*
        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return ExtraCodecs.validate(ExtraCodecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }
 */

        @Override
        public Codec<StarforgeMultiblockRecipe> codec() {
            return CODEC;
        }

        @Nullable
        @Override
        public StarforgeMultiblockRecipe fromNetwork(FriendlyByteBuf buffer) { // READ
            String group = buffer.readUtf();
            // int gridSize = 2;
            NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }

            CompoundTag tag = null;
            if (buffer.readBoolean()) {
                tag = buffer.readNbt();
            }
            int cookTime = buffer.readVarInt();
            ItemStack output = buffer.readItem();
            int tier = buffer.readInt();
            return new StarforgeMultiblockRecipe(group, inputs, tag, cookTime, output, tier);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, StarforgeMultiblockRecipe recipe) {
            buffer.writeUtf(recipe.group);
            // int size = 2;
            buffer.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buffer);
            }

            if (recipe.tag != null) {
                buffer.writeBoolean(true);
                buffer.writeNbt(recipe.tag);
            } else {
                buffer.writeBoolean(false);
            }
            buffer.writeVarInt(recipe.getCookTime());
            buffer.writeItemStack(recipe.getResultItem(null), true);
            buffer.writeVarInt(recipe.tier);
        }
    }
}
