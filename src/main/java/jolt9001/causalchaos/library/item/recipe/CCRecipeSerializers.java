package jolt9001.causalchaos.library.item.recipe;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.item.recipe.recipes.starforge.StarforgeAloneShapedRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CCRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CausalChaos.MODID);

    public static final Supplier<RecipeSerializer<StarforgeAloneShapedRecipe>> STARFORGE_ALONE_SHAPED = RECIPE_SERIALIZERS.register("starforge_alone_shaped", StarforgeAloneShapedRecipe.Serializer::new);
}
