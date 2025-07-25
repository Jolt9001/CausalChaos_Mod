package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.datagen.helpers.CraftingDataHelper;
import jolt9001.causalchaos.common.datagen.tags.ItemTagGenerator;
import jolt9001.causalchaos.init.CCBlocks;
import jolt9001.causalchaos.init.CCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;

public class CraftingGenerator extends CraftingDataHelper {
    public CraftingGenerator(PackOutput out) {
        super(out);
    }

    @Override
    protected void buildRecipes(RecipeOutput out) {
        blockCompressionRecipes(out);
        equipmentRecipes(out);
        // smithingRecipes(out);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CCBlocks.T0_STARFORGE.get())
                .pattern("nnn")
                .pattern("nbn")
                .pattern("fff")
                .define('n', Items.NETHERITE_INGOT)
                .define('b', Blocks.BLAST_FURNACE)
                .define('f', Items.IRON_INGOT)
                .unlockedBy("has_item", has(Blocks.BLAST_FURNACE))
                .save(out, CausalChaos.prefix("machines/t0_starforge"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CCBlocks.T1_STARFORGE.get())
                .pattern("www")
                .pattern("wsw")
                .pattern("nnn")
                .define('w', CCItems.TUNGSTEN_INGOT.get())
                .define('s', CCBlocks.T0_STARFORGE.get())
                .define('n', Items.NETHERITE_INGOT)
                .unlockedBy("has_item", has(CCBlocks.T0_STARFORGE.get()))
                .save(out, CausalChaos.prefix("machines/t1_starforge"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CCBlocks.T2_STARFORGE.get())
                .pattern("ttt")
                .pattern("tst")
                .pattern("www")
                .define('t', CCItems.THUNDERSTEEL_INGOT.get())
                .define('s', CCBlocks.T1_STARFORGE.get())
                .define('w', CCItems.TUNGSTEN_INGOT.get())
                .unlockedBy("has_item", has(CCBlocks.T1_STARFORGE.get()))
                .save(out, CausalChaos.prefix("machines/t2_starforge"));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CCBlocks.T3_STARFORGE.get())
                .pattern("ppp")
                .pattern("psp")
                .pattern("ttt")
                .define('p', CCItems.PERPLEXIUM_INGOT.get())
                .define('s', CCBlocks.T2_STARFORGE.get())
                .define('t', CCItems.THUNDERSTEEL_INGOT.get())
                .unlockedBy("has_item", has(CCBlocks.T2_STARFORGE.get()))
                .save(out, CausalChaos.prefix("machines/t3_starforge"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CCBlocks.QUANTUM_FABRIC.get())
                .pattern("ptp")
                .pattern("tct")
                .pattern("ptp")
                .define('p', CCItems.PERPLEXIUM_NUGGET.get())
                .define('t', CCItems.THUNDERSTEEL_INGOT.get())
                .define('c', CCItems.CAUSALITY_CRYSTAL.get())
                ;
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CCItems.QUANTUM_SIGIL.get());
    }

    private void equipmentRecipes(RecipeOutput out) {
        // Cobalt
        bootsItem(out, "cobalt_boots", CCItems.COBALT_BOOTS, ItemTagGenerator.COBALT_INGOTS);
        helmetItem(out, "cobalt_helmet", CCItems.COBALT_HELMET, ItemTagGenerator.COBALT_INGOTS);
        leggingsItem(out, "cobalt_leggings", CCItems.COBALT_LEGGINGS, ItemTagGenerator.COBALT_INGOTS);
        chestplateItem(out, "cobalt_chestplate", CCItems.COBALT_CHESTPLATE, ItemTagGenerator.COBALT_INGOTS);
        hoeItem(out, "cobalt_hoe", CCItems.COBALT_HOE, ItemTagGenerator.COBALT_INGOTS, Tags.Items.RODS_WOODEN);
        axeItem(out, "cobalt_axe", CCItems.COBALT_AXE, ItemTagGenerator.COBALT_INGOTS, Tags.Items.RODS_WOODEN);
        swordItem(out, "cobalt_sword", CCItems.COBALT_SWORD, ItemTagGenerator.COBALT_INGOTS, Tags.Items.RODS_WOODEN);
        shovelItem(out, "cobalt_shovel", CCItems.COBALT_SHOVEL, ItemTagGenerator.COBALT_INGOTS, Tags.Items.RODS_WOODEN);
        pickaxeItem(out, "cobalt_pickaxe", CCItems.COBALT_PICKAXE, ItemTagGenerator.COBALT_INGOTS, Tags.Items.RODS_WOODEN);

        // Iridium
        bootsItem(out, "iridium_boots", CCItems.IRIDIUM_BOOTS, ItemTagGenerator.IRIDIUM_INGOTS);
        helmetItem(out, "iridium_helmet", CCItems.IRIDIUM_HELMET, ItemTagGenerator.IRIDIUM_INGOTS);
        leggingsItem(out, "iridium_leggings", CCItems.IRIDIUM_LEGGINGS, ItemTagGenerator.IRIDIUM_INGOTS);
        chestplateItem(out, "iridium_chestplate", CCItems.IRIDIUM_CHESTPLATE, ItemTagGenerator.IRIDIUM_INGOTS);
        hoeItem(out, "iridium_hoe", CCItems.IRIDIUM_HOE, ItemTagGenerator.IRIDIUM_INGOTS, Tags.Items.RODS_WOODEN);
        axeItem(out, "iridium_axe", CCItems.IRIDIUM_AXE, ItemTagGenerator.IRIDIUM_INGOTS, Tags.Items.RODS_WOODEN);
        swordItem(out, "iridium_sword", CCItems.IRIDIUM_SWORD, ItemTagGenerator.IRIDIUM_INGOTS, Tags.Items.RODS_WOODEN);
        shovelItem(out, "iridium_shovel", CCItems.IRIDIUM_SHOVEL, ItemTagGenerator.IRIDIUM_INGOTS, Tags.Items.RODS_WOODEN);
        pickaxeItem(out, "iridium_pickaxe", CCItems.IRIDIUM_PICKAXE, ItemTagGenerator.IRIDIUM_INGOTS, Tags.Items.RODS_WOODEN);

        // Neodymium
        bootsItem(out, "neodymium_boots", CCItems.NEODYMIUM_BOOTS, ItemTagGenerator.NEODYMIUM_INGOTS);
        helmetItem(out, "neodymium_helmet", CCItems.NEODYMIUM_HELMET, ItemTagGenerator.NEODYMIUM_INGOTS);
        leggingsItem(out, "neodymium_leggings", CCItems.NEODYMIUM_LEGGINGS, ItemTagGenerator.NEODYMIUM_INGOTS);
        chestplateItem(out, "neodymium_chestplate", CCItems.NEODYMIUM_CHESTPLATE, ItemTagGenerator.NEODYMIUM_INGOTS);
        hoeItem(out, "neodymium_hoe", CCItems.NEODYMIUM_HOE, ItemTagGenerator.NEODYMIUM_INGOTS, Tags.Items.RODS_WOODEN);
        axeItem(out, "neodymium_axe", CCItems.NEODYMIUM_AXE, ItemTagGenerator.NEODYMIUM_INGOTS, Tags.Items.RODS_WOODEN);
        swordItem(out, "neodymium_sword", CCItems.NEODYMIUM_SWORD, ItemTagGenerator.NEODYMIUM_INGOTS, Tags.Items.RODS_WOODEN);
        shovelItem(out, "neodymium_shovel", CCItems.NEODYMIUM_SHOVEL, ItemTagGenerator.NEODYMIUM_INGOTS, Tags.Items.RODS_WOODEN);
        pickaxeItem(out, "neodymium_pickaxe", CCItems.NEODYMIUM_PICKAXE, ItemTagGenerator.NEODYMIUM_INGOTS, Tags.Items.RODS_WOODEN);

        // Palladium
        bootsItem(out, "palladium_boots", CCItems.PALLADIUM_BOOTS, ItemTagGenerator.PALLADIUM_INGOTS);
        helmetItem(out, "palladium_helmet", CCItems.PALLADIUM_HELMET, ItemTagGenerator.PALLADIUM_INGOTS);
        leggingsItem(out, "palladium_leggings", CCItems.PALLADIUM_LEGGINGS, ItemTagGenerator.PALLADIUM_INGOTS);
        chestplateItem(out, "palladium_chestplate", CCItems.PALLADIUM_CHESTPLATE, ItemTagGenerator.PALLADIUM_INGOTS);
        hoeItem(out, "palladium_hoe", CCItems.PALLADIUM_HOE, ItemTagGenerator.PALLADIUM_INGOTS, Tags.Items.RODS_WOODEN);
        axeItem(out, "palladium_axe", CCItems.PALLADIUM_AXE, ItemTagGenerator.PALLADIUM_INGOTS, Tags.Items.RODS_WOODEN);
        swordItem(out, "palladium_sword", CCItems.PALLADIUM_SWORD, ItemTagGenerator.PALLADIUM_INGOTS, Tags.Items.RODS_WOODEN);
        shovelItem(out, "palladium_shovel", CCItems.PALLADIUM_SHOVEL, ItemTagGenerator.PALLADIUM_INGOTS, Tags.Items.RODS_WOODEN);
        pickaxeItem(out, "palladium_pickaxe", CCItems.PALLADIUM_PICKAXE, ItemTagGenerator.PALLADIUM_INGOTS, Tags.Items.RODS_WOODEN);

        // Pure Perplexium
        bootsItem(out, "perplexium_boots", CCItems.PERPLEXIUM_BOOTS, ItemTagGenerator.PERPLEXIUM_INGOTS);
        helmetItem(out, "perplexium_helmet", CCItems.PERPLEXIUM_HELMET, ItemTagGenerator.PERPLEXIUM_INGOTS);
        leggingsItem(out, "perplexium_leggings", CCItems.PERPLEXIUM_LEGGINGS, ItemTagGenerator.PERPLEXIUM_INGOTS);
        chestplateItem(out, "perplexium_chestplate", CCItems.PERPLEXIUM_CHESTPLATE, ItemTagGenerator.PERPLEXIUM_INGOTS);
        hoeItem(out, "perplexium_hoe", CCItems.PERPLEXIUM_HOE, ItemTagGenerator.PERPLEXIUM_INGOTS, Tags.Items.RODS_WOODEN);
        axeItem(out, "perplexium_axe", CCItems.PERPLEXIUM_AXE, ItemTagGenerator.PERPLEXIUM_INGOTS, Tags.Items.RODS_WOODEN);
        swordItem(out, "perplexium_sword", CCItems.PERPLEXIUM_SWORD, ItemTagGenerator.PERPLEXIUM_INGOTS, Tags.Items.RODS_WOODEN);
        shovelItem(out, "perplexium_shovel", CCItems.PERPLEXIUM_SHOVEL, ItemTagGenerator.PERPLEXIUM_INGOTS, Tags.Items.RODS_WOODEN);
        pickaxeItem(out, "perplexium_pickaxe", CCItems.PERPLEXIUM_PICKAXE, ItemTagGenerator.PERPLEXIUM_INGOTS, Tags.Items.RODS_WOODEN);

        // Thundersteel
        bootsItem(out, "thundersteel_boots", CCItems.THUNDERSTEEL_BOOTS, ItemTagGenerator.THUNDERSTEEL_INGOTS);
        helmetItem(out, "thundersteel_helmet", CCItems.THUNDERSTEEL_HELMET, ItemTagGenerator.THUNDERSTEEL_INGOTS);
        leggingsItem(out, "thundersteel_leggings", CCItems.THUNDERSTEEL_LEGGINGS, ItemTagGenerator.THUNDERSTEEL_INGOTS);
        chestplateItem(out, "thundersteel_chestplate", CCItems.THUNDERSTEEL_CHESTPLATE, ItemTagGenerator.THUNDERSTEEL_INGOTS);
        hoeItem(out, "thundersteel_hoe", CCItems.THUNDERSTEEL_HOE, ItemTagGenerator.THUNDERSTEEL_INGOTS, Tags.Items.RODS_WOODEN);
        axeItem(out, "thundersteel_axe", CCItems.THUNDERSTEEL_AXE, ItemTagGenerator.THUNDERSTEEL_INGOTS, Tags.Items.RODS_WOODEN);
        swordItem(out, "thundersteel_sword", CCItems.THUNDERSTEEL_SWORD, ItemTagGenerator.THUNDERSTEEL_INGOTS, Tags.Items.RODS_WOODEN);
        shovelItem(out, "thundersteel_shovel", CCItems.THUNDERSTEEL_SHOVEL, ItemTagGenerator.THUNDERSTEEL_INGOTS, Tags.Items.RODS_WOODEN);
        pickaxeItem(out, "thundersteel_pickaxe", CCItems.THUNDERSTEEL_PICKAXE, ItemTagGenerator.THUNDERSTEEL_INGOTS, Tags.Items.RODS_WOODEN);

        // Titanium
        bootsItem(out, "titanium_boots", CCItems.TITANIUM_BOOTS, ItemTagGenerator.TITANIUM_INGOTS);
        helmetItem(out, "titanium_helmet", CCItems.TITANIUM_HELMET, ItemTagGenerator.TITANIUM_INGOTS);
        leggingsItem(out, "titanium_leggings", CCItems.TITANIUM_LEGGINGS, ItemTagGenerator.TITANIUM_INGOTS);
        chestplateItem(out, "titanium_chestplate", CCItems.TITANIUM_CHESTPLATE, ItemTagGenerator.TITANIUM_INGOTS);
        hoeItem(out, "titanium_hoe", CCItems.TITANIUM_HOE, ItemTagGenerator.TITANIUM_INGOTS, Tags.Items.RODS_WOODEN);
        axeItem(out, "titanium_axe", CCItems.TITANIUM_AXE, ItemTagGenerator.TITANIUM_INGOTS, Tags.Items.RODS_WOODEN);
        swordItem(out, "titanium_sword", CCItems.TITANIUM_SWORD, ItemTagGenerator.TITANIUM_INGOTS, Tags.Items.RODS_WOODEN);
        shovelItem(out, "titanium_shovel", CCItems.TITANIUM_SHOVEL, ItemTagGenerator.TITANIUM_INGOTS, Tags.Items.RODS_WOODEN);
        pickaxeItem(out, "titanium_pickaxe", CCItems.TITANIUM_PICKAXE, ItemTagGenerator.TITANIUM_INGOTS, Tags.Items.RODS_WOODEN);

        // Tungsten
        bootsItem(out, "tungsten_boots", CCItems.TUNGSTEN_BOOTS, ItemTagGenerator.TUNGSTEN_INGOTS);
        helmetItem(out, "tungsten_helmet", CCItems.TUNGSTEN_HELMET, ItemTagGenerator.TUNGSTEN_INGOTS);
        leggingsItem(out, "tungsten_leggings", CCItems.TUNGSTEN_LEGGINGS, ItemTagGenerator.TUNGSTEN_INGOTS);
        chestplateItem(out, "tungsten_chestplate", CCItems.TUNGSTEN_CHESTPLATE, ItemTagGenerator.TUNGSTEN_INGOTS);
        hoeItem(out, "tungsten_hoe", CCItems.TUNGSTEN_HOE, ItemTagGenerator.TUNGSTEN_INGOTS, Tags.Items.RODS_WOODEN);
        axeItem(out, "tungsten_axe", CCItems.TUNGSTEN_AXE, ItemTagGenerator.TUNGSTEN_INGOTS, Tags.Items.RODS_WOODEN);
        swordItem(out, "tungsten_sword", CCItems.TUNGSTEN_SWORD, ItemTagGenerator.TUNGSTEN_INGOTS, Tags.Items.RODS_WOODEN);
        shovelItem(out, "tungsten_shovel", CCItems.TUNGSTEN_SHOVEL, ItemTagGenerator.TUNGSTEN_INGOTS, Tags.Items.RODS_WOODEN);
        pickaxeItem(out, "tungsten_pickaxe", CCItems.TUNGSTEN_PICKAXE, ItemTagGenerator.TUNGSTEN_INGOTS, Tags.Items.RODS_WOODEN);

        // Special equipment
        // Perfected Elytra
    }

    private void blockCompressionRecipes(RecipeOutput out) {
        // Block to Ingot
        reverseCompressedBlock(out, "cobalt_block_to_item", CCBlocks.COBALT_BLOCK, ItemTagGenerator.COBALT_INGOTS);
        reverseCompressedBlock(out, "iridium_block_to_item", CCBlocks.IRIDIUM_BLOCK, ItemTagGenerator.IRIDIUM_INGOTS);
        reverseCompressedBlock(out, "neodymium_block_to_item", CCBlocks.NEODYMIUM_BLOCK, ItemTagGenerator.NEODYMIUM_INGOTS);
        reverseCompressedBlock(out, "palladium_block_to_item", CCBlocks.PALLADIUM_BLOCK, ItemTagGenerator.PALLADIUM_INGOTS);
        reverseCompressedBlock(out, "perplexium_block_to_item", CCBlocks.PERPLEXIUM_BLOCK, ItemTagGenerator.PERPLEXIUM_INGOTS);
        reverseCompressedBlock(out, "thundersteel_block_to_item", CCBlocks.THUNDERSTEEL_BLOCK, ItemTagGenerator.THUNDERSTEEL_INGOTS);
        reverseCompressedBlock(out, "titanium_block_to_item", CCBlocks.TITANIUM_BLOCK, ItemTagGenerator.TITANIUM_INGOTS);
        reverseCompressedBlock(out, "tungsten_block_to_item", CCBlocks.TUNGSTEN_BLOCK, ItemTagGenerator.TUNGSTEN_INGOTS);

        // Block to Raw material
        reverseCompressedBlock(out, "anthracite_block_to_item", CCBlocks.ANTHRACITE_BLOCK, ItemTagGenerator.RAW_MATERIALS_ANTHRACITE);
        reverseCompressedBlock(out, "magnetite_block_to_item", CCBlocks.MAGNETITE_BLOCK, ItemTagGenerator.RAW_MATERIALS_MAGNETITE);
        reverseCompressedBlock(out, "raw_cobalt_block_to_item", CCBlocks.RAW_COBALT_BLOCK, ItemTagGenerator.RAW_MATERIALS_COBALT);
        reverseCompressedBlock(out, "raw_iridium_block_to_item", CCBlocks.RAW_IRIDIUM_BLOCK, ItemTagGenerator.RAW_MATERIALS_IRIDIUM);
        reverseCompressedBlock(out, "raw_neodymium_block_to_item", CCBlocks.RAW_NEODYMIUM_BLOCK, ItemTagGenerator.RAW_MATERIALS_NEODYMIUM);
        reverseCompressedBlock(out, "raw_palladium_block_to_item", CCBlocks.RAW_PALLADIUM_BLOCK, ItemTagGenerator.RAW_MATERIALS_PALLADIUM);
        reverseCompressedBlock(out, "raw_titanium_block_to_item", CCBlocks.RAW_TITANIUM_BLOCK, ItemTagGenerator.RAW_MATERIALS_TITANIUM);
        reverseCompressedBlock(out, "raw_tungsten_block_to_item", CCBlocks.RAW_TUNGSTEN_BLOCK, ItemTagGenerator.RAW_MATERIALS_TUNGSTEN);

        // Ingot to Block
        compressedBlock(out, "cobalt_block", CCBlocks.COBALT_BLOCK, ItemTagGenerator.COBALT_INGOTS);
        compressedBlock(out, "iridium_block", CCBlocks.IRIDIUM_BLOCK, ItemTagGenerator.IRIDIUM_INGOTS);
        compressedBlock(out, "neodymium_block", CCBlocks.NEODYMIUM_BLOCK, ItemTagGenerator.NEODYMIUM_INGOTS);
        compressedBlock(out, "palladium_block", CCBlocks.PALLADIUM_BLOCK, ItemTagGenerator.PALLADIUM_INGOTS);
        compressedBlock(out, "perplexium_block", CCBlocks.PERPLEXIUM_BLOCK, ItemTagGenerator.PERPLEXIUM_INGOTS);
        compressedBlock(out, "thundersteel_block", CCBlocks.THUNDERSTEEL_BLOCK, ItemTagGenerator.THUNDERSTEEL_INGOTS);
        compressedBlock(out, "titanium_block", CCBlocks.TITANIUM_BLOCK, ItemTagGenerator.TITANIUM_INGOTS);
        compressedBlock(out, "tungsten_block", CCBlocks.TUNGSTEN_BLOCK, ItemTagGenerator.TUNGSTEN_INGOTS);

        // Raw material to Block
        compressedBlock(out, "anthracite_block", CCBlocks.ANTHRACITE_BLOCK, ItemTagGenerator.RAW_MATERIALS_ANTHRACITE);
        compressedBlock(out, "magnetite_block", CCBlocks.MAGNETITE_BLOCK, ItemTagGenerator.RAW_MATERIALS_MAGNETITE);
        compressedBlock(out, "raw_cobalt_block", CCBlocks.RAW_COBALT_BLOCK, ItemTagGenerator.RAW_MATERIALS_COBALT);
        compressedBlock(out, "raw_iridium_block", CCBlocks.RAW_IRIDIUM_BLOCK, ItemTagGenerator.RAW_MATERIALS_IRIDIUM);
        compressedBlock(out, "raw_neodymium_block", CCBlocks.RAW_NEODYMIUM_BLOCK, ItemTagGenerator.RAW_MATERIALS_NEODYMIUM);
        compressedBlock(out, "raw_palladium_block", CCBlocks.RAW_PALLADIUM_BLOCK, ItemTagGenerator.RAW_MATERIALS_PALLADIUM);
        compressedBlock(out, "raw_titanium_block", CCBlocks.RAW_TITANIUM_BLOCK, ItemTagGenerator.RAW_MATERIALS_TITANIUM);
        compressedBlock(out, "raw_tungsten_block", CCBlocks.RAW_TUNGSTEN_BLOCK, ItemTagGenerator.RAW_MATERIALS_TUNGSTEN);
    }
/*
    private void smithingRecipes(RecipeOutput out) {
        infusedThundersteel(out, "infused_thundersteel_axe", CCItems.THUNDERSTEEL_AXE.get(), CCItems.INFUSED_THUNDERSTEEL_AXE.get());
        infusedThundersteel(out, "infused_thundersteel_hoe", CCItems.THUNDERSTEEL_HOE.get(), CCItems.INFUSED_THUNDERSTEEL_HOE.get());
        infusedThundersteel(out, "infused_thundersteel_sword", CCItems.THUNDERSTEEL_SWORD.get(), CCItems.INFUSED_THUNDERSTEEL_SWORD.get());
        infusedThundersteel(out, "infused_thundersteel_boots", CCItems.THUNDERSTEEL_BOOTS.get(), CCItems.INFUSED_THUNDERSTEEL_BOOTS.get());
        infusedThundersteel(out, "infused_thundersteel_helmet", CCItems.THUNDERSTEEL_HELMET.get(), CCItems.INFUSED_THUNDERSTEEL_HELMET.get());
        infusedThundersteel(out, "infused_thundersteel_shovel", CCItems.THUNDERSTEEL_SHOVEL.get(), CCItems.INFUSED_THUNDERSTEEL_SHOVEL.get());
        infusedThundersteel(out, "infused_thundersteel_pickaxe", CCItems.THUNDERSTEEL_PICKAXE.get(), CCItems.INFUSED_THUNDERSTEEL_PICKAXE.get());
        infusedThundersteel(out, "infused_thundersteel_leggings", CCItems.THUNDERSTEEL_LEGGINGS.get(), CCItems.INFUSED_THUNDERSTEEL_LEGGINGS.get());
        infusedThundersteel(out, "infused_thundersteel_chestplate", CCItems.THUNDERSTEEL_CHESTPLATE.get(), CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE.get());
    }

 */

    private void cookingRecipe(RecipeOutput out) {

    }
}
