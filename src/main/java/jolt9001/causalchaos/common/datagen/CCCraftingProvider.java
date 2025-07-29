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

public class CCCraftingProvider extends CraftingDataHelper {
    public CCCraftingProvider(PackOutput out) {
        super(out);
    }

    @Override
    protected void buildRecipes(RecipeOutput out) {
        compressionRecipes(out);
        equipmentRecipes(out);
        // smithingRecipes(out);
        // starforgeAlone(out);
        // starforgeMultiblock(out);

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
                .unlockedBy("has_item", has(CCItems.PERPLEXIUM_NUGGET.get()))
                .save(out, CausalChaos.prefix("blocks/quantum_fabric"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, CCItems.QUANTUM_SIGIL.get())
                .pattern("ntn")
                .pattern("tct")
                .pattern("ntn")
                .define('n', Items.NETHERITE_INGOT)
                .define('t', CCItems.TIME_CRYSTAL.get())
                .define('c', CCItems.CAUSALITY_CRYSTAL.get())
                .unlockedBy("has_item", has(CCItems.TIME_CRYSTAL.get()))
                .save(out, CausalChaos.prefix("gadgets/quantum_sigil"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.RIFT_TOKEN.get())
                .pattern("tct")
                .pattern("cqc")
                .pattern("tct")
                .define('t', CCItems.THUNDERSTEEL_INGOT.get())
                .define('c', CCItems.TIME_CRYSTAL.get())
                .define('q', CCItems.QUANTUM_SIGIL.get())
                .unlockedBy("has_item", has(CCItems.QUANTUM_SIGIL.get()))
                .save(out, CausalChaos.prefix("gadgets/rift_token"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.VOID_FABRIC.get())
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', CCItems.ABYSS_STRING.get())
                .unlockedBy("has_item", has(CCItems.ABYSS_STRING.get()))
                .save(out, CausalChaos.prefix("misc/void_fabric"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCItems.STABLE_RIFT_TOKEN.get())
                .pattern("vvv")
                .pattern("vrv")
                .pattern("vvv")
                .define('v', CCItems.VOID_FABRIC.get())
                .define('r', CCItems.RIFT_TOKEN.get())
                .unlockedBy("has_item", has(CCItems.RIFT_TOKEN.get()))
                .save(out, CausalChaos.prefix("gadgets/stable_rift_token"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CCBlocks.REALMWEAVE_BLOCK.get())
                .pattern("aa")
                .pattern("aa")
                .define('a', CCItems.ABYSS_STRING.get())
                .unlockedBy("has_item", has(CCItems.ABYSS_STRING.get()))
                .save(out, CausalChaos.prefix("blocks/realmweave_block"));
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, CCBlocks.DIMENSIONAL_ANCHOR.get())
                .pattern(" k ")
                .pattern("trt")
                .pattern("sss")
                .define('k', CCItems.RIFT_TOKEN.get())
                .define('t', CCItems.THUNDERSTEEL_INGOT.get())
                .define('r', CCItems.REALM_SEED.get())
                .define('s', Blocks.SMOOTH_STONE)
                .unlockedBy("has_item", has(CCItems.REALM_SEED.get()))
                .save(out, CausalChaos.prefix("blocks/dimensional_anchor"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, CCBlocks.WORMHOLE_STABILIZER.get())
                .pattern(" r ")
                .pattern("pcp")
                .pattern(" d ")
                .define('r', CCItems.STABLE_RIFT_TOKEN.get())
                .define('p', CCItems.PERPLEXIUM_INGOT.get())
                .define('c', CCItems.CAUSALITY_CRYSTAL.get())
                .define('d', CCBlocks.DIMENSIONAL_ANCHOR.get())
                .unlockedBy("has_item", has(CCBlocks.DIMENSIONAL_ANCHOR.get()))
                .save(out, CausalChaos.prefix("blocks/wormhole_stabilizer"));
/*
        StarforgeAloneShapedRecipeBuilder.shapedSingle(RecipeCategory.MISC, CCBlocks.T1_CORE_SHIELDING.get(), 10, 3)
                .pattern("wiw")
                .pattern("ini")
                .pattern("wiw")
                .define('w', CCItems.TUNGSTEN_INGOT.get())
                .define('i', CCItems.IRIDIUM_INGOT.get())
                .define('n', Items.NETHERITE_INGOT)
                .save(out, CausalChaos.prefix("machines/t1_core_shield"));
        StarforgeMultiblockShapedRecipeBuilder.shapedMulti(RecipeCategory.MISC, CCItems.THUNDERSTEEL_INGOT.get(), 10,3, 3)
                .pattern(" wfffw ")
                .pattern("witctiw")
                .pattern("ftppptf")
                .pattern("fcpnpcf")
                .pattern("ftntntf")
                .pattern("witctiw")
                .pattern(" wfffw ")
                .define('w', CCItems.TUNGSTEN_INGOT.get())
                .define('f', Items.IRON_INGOT)
                .define('i', CCItems.IRIDIUM_INGOT.get())
                .define('t', CCItems.TITANIUM_INGOT.get())
                .define('c', CCItems.COBALT_INGOT.get())
                .define('p', CCItems.PALLADIUM_INGOT.get())
                .define('n', CCItems.NEODYMIUM_INGOT.get())
                .save(out, CausalChaos.prefix("items/thundersteel_ingot"));
 */
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

    private void compressionRecipes(RecipeOutput out) {
        // Block to Ingot
        reverseCompressedBlock(out, "cobalt_block_to_item", CCItems.COBALT_INGOT, ItemTagGenerator.STORAGE_BLOCKS_COBALT);
        reverseCompressedBlock(out, "iridium_block_to_item", CCItems.IRIDIUM_INGOT, ItemTagGenerator.STORAGE_BLOCKS_IRIDIUM);
        reverseCompressedBlock(out, "neodymium_block_to_item", CCItems.NEODYMIUM_INGOT, ItemTagGenerator.STORAGE_BLOCKS_NEODYMIUM);
        reverseCompressedBlock(out, "palladium_block_to_item", CCItems.PALLADIUM_INGOT, ItemTagGenerator.STORAGE_BLOCKS_PALLADIUM);
        reverseCompressedBlock(out, "perplexium_block_to_item", CCItems.PERPLEXIUM_INGOT, ItemTagGenerator.STORAGE_BLOCKS_PERPLEXIUM);
        reverseCompressedBlock(out, "thundersteel_block_to_item", CCItems.THUNDERSTEEL_INGOT, ItemTagGenerator.STORAGE_BLOCKS_THUNDERSTEEL);
        reverseCompressedBlock(out, "titanium_block_to_item", CCItems.TITANIUM_INGOT, ItemTagGenerator.STORAGE_BLOCKS_TITANIUM);
        reverseCompressedBlock(out, "tungsten_block_to_item", CCItems.TUNGSTEN_INGOT, ItemTagGenerator.STORAGE_BLOCKS_TUNGSTEN);

        // Block to Raw material
        reverseCompressedBlock(out, "anthracite_block_to_item", CCItems.ANTHRACITE, ItemTagGenerator.STORAGE_BLOCKS_ANTHRACITE);
        reverseCompressedBlock(out, "magnetite_block_to_item", CCItems.MAGNETITE, ItemTagGenerator.STORAGE_BLOCKS_MAGNETITE);
        reverseCompressedBlock(out, "raw_cobalt_block_to_item", CCItems.RAW_COBALT, ItemTagGenerator.STORAGE_RAW_COBALT);
        reverseCompressedBlock(out, "raw_iridium_block_to_item", CCItems.RAW_IRIDIUM, ItemTagGenerator.STORAGE_RAW_IRIDIUM);
        reverseCompressedBlock(out, "raw_neodymium_block_to_item", CCItems.RAW_NEODYMIUM, ItemTagGenerator.STORAGE_RAW_NEODYMIUM);
        reverseCompressedBlock(out, "raw_palladium_block_to_item", CCItems.RAW_PALLADIUM, ItemTagGenerator.STORAGE_RAW_PALLADIUM);
        reverseCompressedBlock(out, "raw_titanium_block_to_item", CCItems.RAW_TITANIUM, ItemTagGenerator.STORAGE_RAW_TITANIUM);
        reverseCompressedBlock(out, "raw_tungsten_block_to_item", CCItems.RAW_TUNGSTEN, ItemTagGenerator.STORAGE_RAW_TUNGSTEN);

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

        // Nugget to Ingot
        ingotCraft(out, "cobalt_ingot", CCItems.COBALT_INGOT, ItemTagGenerator.COBALT_NUGGETS);
        ingotCraft(out, "iridium_ingot", CCItems.IRIDIUM_INGOT, ItemTagGenerator.IRIDIUM_NUGGETS);
        ingotCraft(out, "neodymium_ingot", CCItems.NEODYMIUM_INGOT, ItemTagGenerator.NEODYMIUM_NUGGETS);
        ingotCraft(out, "palladium_ingot", CCItems.PALLADIUM_INGOT, ItemTagGenerator.PALLADIUM_NUGGETS);
        ingotCraft(out, "perplexium_ingot", CCItems.PERPLEXIUM_INGOT, ItemTagGenerator.PERPLEXIUM_NUGGETS);
        ingotCraft(out, "thundersteel_ingot", CCItems.THUNDERSTEEL_INGOT, ItemTagGenerator.THUNDERSTEEL_NUGGETS);
        ingotCraft(out, "titanium_ingot", CCItems.TITANIUM_INGOT, ItemTagGenerator.TITANIUM_NUGGETS);
        ingotCraft(out, "tungsten_ingot", CCItems.TUNGSTEN_INGOT, ItemTagGenerator.TUNGSTEN_NUGGETS);

        // Ingot to Nugget
        reverseIngotCraft(out, "cobalt_ingot", CCItems.COBALT_NUGGET, ItemTagGenerator.COBALT_INGOTS);
        reverseIngotCraft(out, "iridium_ingot", CCItems.IRIDIUM_NUGGET, ItemTagGenerator.IRIDIUM_INGOTS);
        reverseIngotCraft(out, "neodymium_ingot", CCItems.NEODYMIUM_NUGGET, ItemTagGenerator.NEODYMIUM_INGOTS);
        reverseIngotCraft(out, "palladium_ingot", CCItems.PALLADIUM_NUGGET, ItemTagGenerator.PALLADIUM_INGOTS);
        reverseIngotCraft(out, "perplexium_ingot", CCItems.PERPLEXIUM_NUGGET, ItemTagGenerator.PERPLEXIUM_INGOTS);
        reverseIngotCraft(out, "thundersteel_ingot", CCItems.THUNDERSTEEL_NUGGET, ItemTagGenerator.THUNDERSTEEL_INGOTS);
        reverseIngotCraft(out, "titanium_ingot", CCItems.TITANIUM_NUGGET, ItemTagGenerator.TITANIUM_INGOTS);
        reverseIngotCraft(out, "tungsten_ingot", CCItems.TUNGSTEN_NUGGET, ItemTagGenerator.TUNGSTEN_INGOTS);

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