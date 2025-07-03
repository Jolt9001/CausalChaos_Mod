package jolt9001.causalchaos.common.datagen.providers;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;

import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider {
    private RecipeOutput out;

    public RecipeProvider(PackOutput o, CompletableFuture<HolderLookup.Provider> reg) {
        super(o);
    }

    @Override
    protected void buildRecipes(RecipeOutput o) {

    }
}
