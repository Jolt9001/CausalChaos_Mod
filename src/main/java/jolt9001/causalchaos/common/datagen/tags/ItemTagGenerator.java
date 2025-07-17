package jolt9001.causalchaos.common.datagen.tags;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.datagen.tags.compat.ModdedItemTagGenerator;
import jolt9001.causalchaos.init.CCItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ModdedItemTagGenerator {
    // Raw Materials
    public static final TagKey<Item> RAW_MATERIALS_ANTHRACITE = makeForgeTag("raw_materials/anthracite");
    public static final TagKey<Item> RAW_MATERIALS_MAGNETITE = makeForgeTag("raw_materials/magnetite");
    public static final TagKey<Item> RAW_MATERIALS_COBALT = makeForgeTag("raw_materials/cobalt");
    public static final TagKey<Item> RAW_MATERIALS_IRIDIUM = makeForgeTag("raw_materials/iridium");
    public static final TagKey<Item> RAW_MATERIALS_NEODYMIUM = makeForgeTag("raw_materials/neodymium");
    public static final TagKey<Item> RAW_MATERIALS_PALLADIUM = makeForgeTag("raw_materials/palladium");
    public static final TagKey<Item> RAW_MATERIALS_TITANIUM = makeForgeTag("raw_materials/titanium");
    public static final TagKey<Item> RAW_MATERIALS_TUNGSTEN = makeForgeTag("raw_materials/tungsten");

    // Nuggets
    public static final TagKey<Item> COBALT_NUGGETS = makeForgeTag("nuggets/cobalt");
    public static final TagKey<Item> IRIDIUM_NUGGETS = makeForgeTag("nuggets/iridium");
    public static final TagKey<Item> NEODYMIUM_NUGGETS = makeForgeTag("nuggets/neodymium");
    public static final TagKey<Item> PALLADIUM_NUGGETS = makeForgeTag("nuggets/palladium");
    public static final TagKey<Item> PERPLEXIUM_NUGGETS = makeForgeTag("nuggets/perplexium");
    public static final TagKey<Item> THUNDERSTEEL_NUGGETS = makeForgeTag("nuggets/thundersteel");
    public static final TagKey<Item> TITANIUM_NUGGETS = makeForgeTag("nuggets/titanium");
    public static final TagKey<Item> TUNGSTEN_NUGGETS = makeForgeTag("nuggets/tungsten");

    // Ingots
    public static final TagKey<Item> COBALT_INGOTS = makeForgeTag("ingots/cobalt");
    public static final TagKey<Item> IRIDIUM_INGOTS = makeForgeTag("ingots/iridium");
    public static final TagKey<Item> NEODYMIUM_INGOTS = makeForgeTag("ingots/neodymium");
    public static final TagKey<Item> PALLADIUM_INGOTS = makeForgeTag("ingots/palladium");
    public static final TagKey<Item> PERPLEXIUM_INGOTS = makeForgeTag("ingots/perplexium");
    public static final TagKey<Item> THUNDERSTEEL_INGOTS = makeForgeTag("ingots/thundersteel");
    public static final TagKey<Item> TITANIUM_INGOTS = makeForgeTag("ingots/titanium");
    public static final TagKey<Item> TUNGSTEN_INGOTS = makeForgeTag("ingots/tungsten");

    // Storage Blocks
    public static final TagKey<Item> STORAGE_BLOCKS_ANTHRACITE = makeForgeTag("storage_blocks/anthracite");
    public static final TagKey<Item> STORAGE_BLOCKS_MAGNETITE = makeForgeTag("storage_blocks/magnetite");
    public static final TagKey<Item> STORAGE_BLOCKS_COBALT = makeForgeTag("storage_blocks/cobalt");
    public static final TagKey<Item> STORAGE_BLOCKS_IRIDIUM = makeForgeTag("storage_blocks/iridium");
    public static final TagKey<Item> STORAGE_BLOCKS_NEODYMIUM = makeForgeTag("storage_blocks/neodymium");
    public static final TagKey<Item> STORAGE_BLOCKS_PALLADIUM = makeForgeTag("storage_blocks/palladium");
    public static final TagKey<Item> STORAGE_BLOCKS_PERPLEXIUM = makeForgeTag("storage_blocks/perplexium");
    public static final TagKey<Item> STORAGE_BLOCKS_THUNDERSTEEL = makeForgeTag("storage_blocks/thundersteel");
    public static final TagKey<Item> STORAGE_BLOCKS_TITANIUM = makeForgeTag("storage_blocks/titanium");
    public static final TagKey<Item> STORAGE_BLOCKS_TUNGSTEN = makeForgeTag("storage_blocks/tungsten");

    // Tools
    public static final TagKey<Item> TOOLS_PERPLEXIUM = makeForgeTag("tools/perplexium");
    public static final TagKey<Item> TOOLS_INFUSED_THUNDERSTEEL = makeForgeTag("tools/infused_thundersteel");

    // Armors
    public static final TagKey<Item> ARMORS_PERPLEXIUM = makeForgeTag("armors/perplexium");
    public static final TagKey<Item> ARMORS_INFUSED_THUNDERSTEEL = makeForgeTag("armors/infused_thundersteel");

    // Portal activator
    public static final TagKey<Item> PORTAL_ACTIVATOR = create("portal/activator");

    public static final TagKey<Item> WIP = create("wip");
    public static final TagKey<Item> NYI = create("nyi");
    public ItemTagGenerator(PackOutput out, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> prov, ExistingFileHelper help) {
        super(out, future, prov, help);
    }

    @Override
    protected void addTags(HolderLookup.Provider prov) {
        super.addTags(prov);
        // Materials
        tag(Tags.Items.RAW_MATERIALS)
                .addTag(RAW_MATERIALS_ANTHRACITE).addTag(RAW_MATERIALS_COBALT).addTag(RAW_MATERIALS_IRIDIUM)
                .addTag(RAW_MATERIALS_NEODYMIUM).addTag(RAW_MATERIALS_PALLADIUM).addTag(RAW_MATERIALS_TITANIUM)
                .addTag(RAW_MATERIALS_TUNGSTEN);
        tag(Tags.Items.STORAGE_BLOCKS)
                .addTag(STORAGE_BLOCKS_ANTHRACITE).addTag(STORAGE_BLOCKS_MAGNETITE).addTag(STORAGE_BLOCKS_COBALT).addTag(STORAGE_BLOCKS_IRIDIUM)
                .addTag(STORAGE_BLOCKS_NEODYMIUM).addTag(STORAGE_BLOCKS_PALLADIUM).addTag(STORAGE_BLOCKS_PERPLEXIUM)
                .addTag(STORAGE_BLOCKS_THUNDERSTEEL).addTag(STORAGE_BLOCKS_TITANIUM).addTag(STORAGE_BLOCKS_TUNGSTEN);
        tag(Tags.Items.NUGGETS)
                .addTag(COBALT_NUGGETS).addTag(IRIDIUM_NUGGETS).addTag(NEODYMIUM_NUGGETS).addTag(PALLADIUM_NUGGETS)
                .addTag(PERPLEXIUM_NUGGETS).addTag(THUNDERSTEEL_NUGGETS).addTag(TITANIUM_NUGGETS)
                .addTag(TUNGSTEN_NUGGETS);
        tag(Tags.Items.INGOTS)
                .addTag(COBALT_INGOTS).addTag(IRIDIUM_INGOTS).addTag(NEODYMIUM_INGOTS).addTag(PALLADIUM_INGOTS)
                .addTag(PERPLEXIUM_INGOTS).addTag(THUNDERSTEEL_INGOTS).addTag(TITANIUM_INGOTS).addTag(TUNGSTEN_INGOTS);

        // Armor
        tag(Tags.Items.ARMORS_BOOTS).add(
                CCItems.COBALT_BOOTS.get(), CCItems.INFUSED_THUNDERSTEEL_BOOTS.get(), CCItems.IRIDIUM_BOOTS.get(),
                CCItems.NEODYMIUM_BOOTS.get(), CCItems.PALLADIUM_BOOTS.get(), CCItems.PERPLEXIUM_BOOTS.get(),
                CCItems.THUNDERSTEEL_BOOTS.get(), CCItems.TITANIUM_BOOTS.get(), CCItems.TUNGSTEN_BOOTS.get()
        );
        tag(Tags.Items.ARMORS_CHESTPLATES).add(
                CCItems.COBALT_CHESTPLATE.get(), CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE.get(),
                CCItems.IRIDIUM_CHESTPLATE.get(), CCItems.NEODYMIUM_CHESTPLATE.get(),
                CCItems.PALLADIUM_CHESTPLATE.get(), CCItems.PERPLEXIUM_CHESTPLATE.get(),
                CCItems.THUNDERSTEEL_CHESTPLATE.get(), CCItems.TITANIUM_CHESTPLATE.get(),
                CCItems.TUNGSTEN_CHESTPLATE.get()
        );
        tag(Tags.Items.ARMORS_HELMETS).add(
                CCItems.COBALT_HELMET.get(), CCItems.INFUSED_THUNDERSTEEL_HELMET.get(), CCItems.IRIDIUM_HELMET.get(),
                CCItems.NEODYMIUM_HELMET.get(), CCItems.PALLADIUM_HELMET.get(), CCItems.PERPLEXIUM_HELMET.get(),
                CCItems.THUNDERSTEEL_HELMET.get(), CCItems.TITANIUM_HELMET.get(), CCItems.TUNGSTEN_HELMET.get()
        );
        tag(Tags.Items.ARMORS_LEGGINGS).add(
                CCItems.COBALT_LEGGINGS.get(), CCItems.INFUSED_THUNDERSTEEL_LEGGINGS.get(),
                CCItems.IRIDIUM_LEGGINGS.get(), CCItems.NEODYMIUM_LEGGINGS.get(), CCItems.PALLADIUM_LEGGINGS.get(),
                CCItems.PERPLEXIUM_LEGGINGS.get(), CCItems.THUNDERSTEEL_LEGGINGS.get(), CCItems.TITANIUM_LEGGINGS.get(),
                CCItems.TUNGSTEN_LEGGINGS.get()
        );
        tag(ARMORS_PERPLEXIUM).add(
                CCItems.PERPLEXIUM_BOOTS.get(), CCItems.PERPLEXIUM_CHESTPLATE.get(), CCItems.PERPLEXIUM_HELMET.get(),
                CCItems.PERPLEXIUM_LEGGINGS.get());
        tag(ARMORS_INFUSED_THUNDERSTEEL).add(
                CCItems.INFUSED_THUNDERSTEEL_BOOTS.get(), CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE.get(),
                CCItems.INFUSED_THUNDERSTEEL_HELMET.get(), CCItems.INFUSED_THUNDERSTEEL_LEGGINGS.get());

        // Tools
        tag(ItemTags.AXES).add(
                CCItems.COBALT_AXE.get(), CCItems.INFUSED_THUNDERSTEEL_AXE.get(), CCItems.IRIDIUM_AXE.get(),
                CCItems.NEODYMIUM_AXE.get(), CCItems.PALLADIUM_AXE.get(), CCItems.PERPLEXIUM_AXE.get(),
                CCItems.THUNDERSTEEL_AXE.get(), CCItems.TITANIUM_AXE.get(), CCItems.TUNGSTEN_AXE.get()
        );
        tag(ItemTags.HOES).add(
                CCItems.COBALT_HOE.get(), CCItems.INFUSED_THUNDERSTEEL_HOE.get(), CCItems.IRIDIUM_HOE.get(),
                CCItems.NEODYMIUM_HOE.get(), CCItems.PALLADIUM_HOE.get(), CCItems.PERPLEXIUM_HOE.get(),
                CCItems.THUNDERSTEEL_HOE.get(), CCItems.TITANIUM_HOE.get(), CCItems.TUNGSTEN_HOE.get()
        );
        tag(ItemTags.PICKAXES).add(
                CCItems.COBALT_PICKAXE.get(), CCItems.INFUSED_THUNDERSTEEL_PICKAXE.get(), CCItems.IRIDIUM_PICKAXE.get(),
                CCItems.NEODYMIUM_PICKAXE.get(), CCItems.PALLADIUM_PICKAXE.get(), CCItems.PERPLEXIUM_PICKAXE.get(),
                CCItems.THUNDERSTEEL_PICKAXE.get(), CCItems.TITANIUM_PICKAXE.get(), CCItems.TUNGSTEN_PICKAXE.get()
        );
        tag(ItemTags.SHOVELS).add(
                CCItems.COBALT_SHOVEL.get(), CCItems.INFUSED_THUNDERSTEEL_SHOVEL.get(), CCItems.IRIDIUM_SHOVEL.get(),
                CCItems.NEODYMIUM_SHOVEL.get(), CCItems.PALLADIUM_SHOVEL.get(), CCItems.PERPLEXIUM_SHOVEL.get(),
                CCItems.THUNDERSTEEL_SHOVEL.get(), CCItems.TITANIUM_SHOVEL.get(), CCItems.TUNGSTEN_SHOVEL.get()
        );
        tag(ItemTags.SWORDS).add(
                CCItems.COBALT_SWORD.get(), CCItems.INFUSED_THUNDERSTEEL_SWORD.get(), CCItems.IRIDIUM_SWORD.get(),
                CCItems.NEODYMIUM_SWORD.get(), CCItems.PALLADIUM_SWORD.get(), CCItems.PERPLEXIUM_SWORD.get(),
                CCItems.THUNDERSTEEL_SWORD.get(), CCItems.TITANIUM_SWORD.get(), CCItems.TUNGSTEN_SWORD.get()
        );
        tag(TOOLS_PERPLEXIUM).add(
                CCItems.PERPLEXIUM_AXE.get(), CCItems.PERPLEXIUM_HOE.get(), CCItems.PERPLEXIUM_PICKAXE.get(),
                CCItems.PERPLEXIUM_SHOVEL.get(), CCItems.PERPLEXIUM_SWORD.get());
        tag(TOOLS_INFUSED_THUNDERSTEEL).add(
                CCItems.INFUSED_THUNDERSTEEL_AXE.get(), CCItems.INFUSED_THUNDERSTEEL_HOE.get(),
                CCItems.INFUSED_THUNDERSTEEL_PICKAXE.get(), CCItems.INFUSED_THUNDERSTEEL_SHOVEL.get(),
                CCItems.INFUSED_THUNDERSTEEL_SWORD.get());


        tag(PORTAL_ACTIVATOR).add(CCItems.RIFT_TOKEN.get());
    }

    public static TagKey<Item> create(String tagName) {
        return ItemTags.create(CausalChaos.prefix(tagName));
    }

    public static TagKey<Item> makeForgeTag(String tagName) {
        return ItemTags.create(new ResourceLocation("forge", tagName));
    }
}
