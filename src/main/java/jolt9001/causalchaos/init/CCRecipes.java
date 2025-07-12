package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.recipe.recipes.starforge.StarforgeAloneRecipe;
import jolt9001.causalchaos.library.recipe.recipes.starforgemultiblock.StarforgeMultiblockRecipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CCRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, CausalChaos.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, CausalChaos.MODID);

    public static final Supplier<RecipeType<StarforgeAloneRecipe>> STARFORGE_ALONE = RECIPE_TYPES.register("starforge_alone", () -> RecipeType.simple(new ResourceLocation(CausalChaos.MODID, "starforge_alone")));
    public static final Supplier<RecipeType<StarforgeMultiblockRecipe>> STARFORGE_MULTIBLOCK = RECIPE_TYPES.register("starforge_multiblock", () -> RecipeType.simple(new ResourceLocation(CausalChaos.MODID, "starforge_multiblock")));
    // public static final Supplier<RecipeType<IridiumEnhancerRecipe>> IRIDIUM_ENHANCEMENT = RECIPE_TYPES.register("iridium_enhancement", () -> RecipeType.simple(new ResourceLocation(CausalChaos.MODID, "iridium_enhancement")));
    public static final RegistryObject<RecipeSerializer<StarforgeAloneRecipe>> STARFORGE_ALONE_SERIALIZER = SERIALIZERS.register("starforge_alone", () -> StarforgeAloneRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<StarforgeMultiblockRecipe>> STARFORGE_MULTIBLOCK_SERIALIZER = SERIALIZERS.register("starforge_multiblock", () -> StarforgeMultiblockRecipe.Serializer.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
