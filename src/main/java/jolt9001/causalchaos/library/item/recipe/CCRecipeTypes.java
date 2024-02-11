package jolt9001.causalchaos.library.item.recipe;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.item.recipe.recipes.starforge.StarforgeAloneShapedRecipe;
import jolt9001.causalchaos.library.item.recipe.recipes.starforgemultiblock.StarforgeMultiblockShapedRecipe;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CCRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, CausalChaos.MODID);

    public static final Supplier<RecipeType<StarforgeAloneShapedRecipe>> STARFORGE_ALONE = RECIPE_TYPES.register("starforge_alone", () -> RecipeType.simple(new ResourceLocation(CausalChaos.MODID, "starforge_alone")));
    public static final Supplier<RecipeType<StarforgeMultiblockShapedRecipe>> STARFORGE_MULTIBLOCK = RECIPE_TYPES.register("starforge_multiblock", () -> RecipeType.simple(new ResourceLocation(CausalChaos.MODID, "starforge_multiblock")));
    // public static final Supplier<RecipeType<IridiumEnhancerRecipe>> IRIDIUM_ENHANCEMENT;
}
