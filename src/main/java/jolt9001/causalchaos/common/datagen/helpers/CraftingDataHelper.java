package jolt9001.causalchaos.common.datagen.helpers;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.init.CCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public abstract class CraftingDataHelper extends RecipeProvider {
    public CraftingDataHelper(PackOutput out) {
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
    protected final void reverseCompressedBlock(RecipeOutput out, String name, Supplier<? extends Block> result, TagKey<Item> ingredient) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get(), 9)
                .requires(ingredient)
                .unlockedBy("has_item", has(ingredient))
                .save(out, CausalChaos.prefix("compressed_blocks/reversed/" + name));
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

    protected final void infusedThundersteel(RecipeOutput out, String name, Item base, Item result) {
        SmithingTransformRecipeBuilder
                .smithing(Ingredient.of(CCItems.THUNDERSTEEL_UPGRADE.get()),
                        Ingredient.of(base), Ingredient.of(CCItems.PERPLEXIUM_INGOT.get()), RecipeCategory.MISC, result)
                .save(out, locEquip(name));
    }

    protected final void smithingTrims(RecipeOutput out, String name, Item template, Item base, Item addition) {
        SmithingTrimRecipeBuilder.smithingTrim(Ingredient.of(template), Ingredient.of(base), Ingredient.of(addition), RecipeCategory.MISC)
                .save(out, locEquip(name));
    }

    protected final ResourceLocation locEquip(String name) {
        return CausalChaos.prefix("equipment/" + name);
    }
}
