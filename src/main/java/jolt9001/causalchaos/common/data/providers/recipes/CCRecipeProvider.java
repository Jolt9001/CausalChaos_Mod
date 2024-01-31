package jolt9001.causalchaos.common.data.providers.recipes;

import com.google.gson.JsonObject;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.concurrent.CompletableFuture;

public abstract class CCRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public CCRecipeProvider(PackOutput o) {
        super(o);
    }

    public static JsonObject toJson(ItemStack s) {
        var stackObj = new JsonObject();
        stackObj.addProperty("item", BuiltInRegistries.ITEM.getKey(s.getItem()).toString());
        if (s.getCount() > 1) {
            stackObj.addProperty("count", s.getCount());
        }
        return stackObj;
    }
}
