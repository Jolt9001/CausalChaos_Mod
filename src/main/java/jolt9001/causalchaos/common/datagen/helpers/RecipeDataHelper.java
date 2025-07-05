package jolt9001.causalchaos.common.datagen.helpers;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class RecipeDataHelper extends RecipeProvider {
    public RecipeDataHelper(PackOutput out) {
        super(out);
    }

    protected final void compressedBlock(RecipeOutput out, String name, Supplier<? extends Block> result, TagKey<Item> ingredient) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ingredient)
                .unlockedBy("has_item", has(ingredient))
                .save(out, CausalChaos.prefix("compressed_blocks/" + name));
    }

    protected final void helmetItem(RecipeOutput out, String name, Supplier<? extends Item> result, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .pattern("###")
                .pattern("# #")
                .define('#', material)
                .unlockedBy("has_item", has(material))
                .save(out, locEquip(name));
    }

    protected final void chestplateItem(RecipeOutput out, String name, Supplier<? extends Item> result, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', material)
                .unlockedBy("has_item", has(material))
                .save(out, locEquip(name));
    }

    protected final void leggingsItem(RecipeOutput out, String name, Supplier<? extends Item> result, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', material)
                .unlockedBy("has_item", has(material))
                .save(out, locEquip(name));
    }

    protected final void bootsItem(RecipeOutput out, String name, Supplier<? extends Item> result, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .pattern("# #")
                .pattern("# #")
                .define('#', material)
                .unlockedBy("has_item", has(material))
                .save(out, locEquip(name));
    }

    protected final void axeItem(RecipeOutput out, String name, Supplier<? extends Item> result, TagKey<Item> material, TagKey<Item> handle) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get())
                .pattern("##")
                .pattern("#X")
                .pattern(" X")
                .define('#', material)
                .define('X', handle)
                .unlockedBy("has_item", has(material))
                .save(out, locEquip(name));
    }

    protected final void hoeItem(RecipeOutput out, String name, Supplier<? extends Item> result, TagKey<Item> material, TagKey<Item> handle) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get())
                .pattern("##")
                .pattern(" X")
                .pattern(" X")
                .define('#', material)
                .define('X', handle)
                .unlockedBy("has_item", has(material))
                .save(out, locEquip(name));
    }

    protected final void pickaxeItem(RecipeOutput out, String name, Supplier<? extends Item> result, TagKey<Item> material, TagKey<Item> handle) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get())
                .pattern("###")
                .pattern(" X ")
                .pattern(" X ")
                .define('#', material)
                .define('X', handle)
                .unlockedBy("has_item", has(material))
                .save(out, locEquip(name));
    }

    protected final void shovelItem(RecipeOutput out, String name, Supplier<? extends Item> result, TagKey<Item> material, TagKey<Item> handle) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .pattern("#")
                .pattern("X")
                .pattern("X")
                .define('#', material)
                .define('X', handle)
                .unlockedBy("has_item", has(material))
                .save(out, locEquip(name));
    }

    protected final void swordItem(RecipeOutput out, String name, Supplier<? extends Item> result, TagKey<Item> material, TagKey<Item> handle) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get())
                .pattern("#")
                .pattern("#")
                .pattern("X")
                .define('#', material)
                .define('X', handle)
                .unlockedBy("has_item", has(material))
                .save(out, locEquip(name));
    }

    protected final ResourceLocation locEquip(String name) {
        return CausalChaos.prefix("equipment/" + name);
    }
}
