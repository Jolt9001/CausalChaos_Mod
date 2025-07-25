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

    // Tools
    public static final TagKey<Item> TOOLS_PERPLEXIUM = makeForgeTag("tools/perplexium");
    public static final TagKey<Item> TOOLS_INFUSED_THUNDERSTEEL = makeForgeTag("tools/infused_thundersteel");

    // Armors
    public static final TagKey<Item> ARMORS_PERPLEXIUM = makeForgeTag("armors/perplexium");
    public static final TagKey<Item> ARMORS_INFUSED_THUNDERSTEEL = makeForgeTag("armors/infused_thundersteel");

    // Bulk Tags
    public static final TagKey<Item> ALL_EQUIPMENT = makeForgeTag("all_equip");
    public static final TagKey<Item> NON_EQUIPMENT = makeForgeTag("non-equip");

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
        tag(RAW_MATERIALS_ANTHRACITE).add(CCItems.ANTHRACITE.get());
        tag(RAW_MATERIALS_MAGNETITE).add(CCItems.MAGNETITE.get());
        tag(RAW_MATERIALS_COBALT).add(CCItems.RAW_COBALT.get());
        tag(RAW_MATERIALS_IRIDIUM).add(CCItems.RAW_IRIDIUM.get());
        tag(RAW_MATERIALS_NEODYMIUM).add(CCItems.RAW_NEODYMIUM.get());
        tag(RAW_MATERIALS_PALLADIUM).add(CCItems.RAW_PALLADIUM.get());
        tag(RAW_MATERIALS_TITANIUM).add(CCItems.RAW_TITANIUM.get());
        tag(RAW_MATERIALS_TUNGSTEN).add(CCItems.RAW_TUNGSTEN.get());
        tag(Tags.Items.RAW_MATERIALS)
                .addTag(RAW_MATERIALS_ANTHRACITE).addTag(RAW_MATERIALS_COBALT).addTag(RAW_MATERIALS_IRIDIUM)
                .addTag(RAW_MATERIALS_NEODYMIUM).addTag(RAW_MATERIALS_PALLADIUM).addTag(RAW_MATERIALS_TITANIUM)
                .addTag(RAW_MATERIALS_TUNGSTEN).addTag(RAW_MATERIALS_MAGNETITE);

        tag(COBALT_NUGGETS).add(CCItems.COBALT_NUGGET.get());
        tag(IRIDIUM_NUGGETS).add(CCItems.IRIDIUM_NUGGET.get());
        tag(NEODYMIUM_NUGGETS).add(CCItems.NEODYMIUM_NUGGET.get());
        tag(PALLADIUM_NUGGETS).add(CCItems.PALLADIUM_NUGGET.get());
        tag(PERPLEXIUM_NUGGETS).add(CCItems.PERPLEXIUM_NUGGET.get());
        tag(THUNDERSTEEL_NUGGETS).add(CCItems.THUNDERSTEEL_NUGGET.get());
        tag(TITANIUM_NUGGETS).add(CCItems.TITANIUM_NUGGET.get());
        tag(TUNGSTEN_NUGGETS).add(CCItems.TUNGSTEN_NUGGET.get());
        tag(Tags.Items.NUGGETS)
                .addTag(COBALT_NUGGETS).addTag(IRIDIUM_NUGGETS).addTag(NEODYMIUM_NUGGETS).addTag(PALLADIUM_NUGGETS)
                .addTag(PERPLEXIUM_NUGGETS).addTag(THUNDERSTEEL_NUGGETS).addTag(TITANIUM_NUGGETS)
                .addTag(TUNGSTEN_NUGGETS);

        tag(COBALT_INGOTS).add(CCItems.COBALT_INGOT.get());
        tag(IRIDIUM_INGOTS).add(CCItems.IRIDIUM_INGOT.get());
        tag(NEODYMIUM_INGOTS).add(CCItems.NEODYMIUM_INGOT.get());
        tag(PALLADIUM_INGOTS).add(CCItems.PALLADIUM_INGOT.get());
        tag(PERPLEXIUM_INGOTS).add(CCItems.PERPLEXIUM_INGOT.get());
        tag(THUNDERSTEEL_INGOTS).add(CCItems.THUNDERSTEEL_INGOT.get());
        tag(TITANIUM_INGOTS).add(CCItems.TITANIUM_INGOT.get());
        tag(TUNGSTEN_INGOTS).add(CCItems.TUNGSTEN_INGOT.get());
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

        tag(ALL_EQUIPMENT).add(
                CCItems.COBALT_AXE.get(), CCItems.INFUSED_THUNDERSTEEL_AXE.get(), CCItems.IRIDIUM_AXE.get(),
                CCItems.NEODYMIUM_AXE.get(), CCItems.PALLADIUM_AXE.get(), CCItems.PERPLEXIUM_AXE.get(),
                CCItems.THUNDERSTEEL_AXE.get(), CCItems.TITANIUM_AXE.get(), CCItems.TUNGSTEN_AXE.get(),
                CCItems.COBALT_BOOTS.get(), CCItems.INFUSED_THUNDERSTEEL_BOOTS.get(), CCItems.IRIDIUM_BOOTS.get(),
                CCItems.NEODYMIUM_BOOTS.get(), CCItems.PALLADIUM_BOOTS.get(), CCItems.PERPLEXIUM_BOOTS.get(),
                CCItems.THUNDERSTEEL_BOOTS.get(), CCItems.TITANIUM_BOOTS.get(), CCItems.TUNGSTEN_BOOTS.get(),
                CCItems.COBALT_CHESTPLATE.get(), CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE.get(),
                CCItems.IRIDIUM_CHESTPLATE.get(), CCItems.NEODYMIUM_CHESTPLATE.get(),
                CCItems.PALLADIUM_CHESTPLATE.get(), CCItems.PERPLEXIUM_CHESTPLATE.get(),
                CCItems.THUNDERSTEEL_CHESTPLATE.get(), CCItems.TITANIUM_CHESTPLATE.get(),
                CCItems.TUNGSTEN_CHESTPLATE.get(), CCItems.COBALT_HELMET.get(), CCItems.INFUSED_THUNDERSTEEL_HELMET.get(),
                CCItems.IRIDIUM_HELMET.get(), CCItems.NEODYMIUM_HELMET.get(), CCItems.PALLADIUM_HELMET.get(),
                CCItems.PERPLEXIUM_HELMET.get(), CCItems.THUNDERSTEEL_HELMET.get(), CCItems.TITANIUM_HELMET.get(),
                CCItems.TUNGSTEN_HELMET.get(), CCItems.COBALT_HOE.get(), CCItems.INFUSED_THUNDERSTEEL_HOE.get(),
                CCItems.IRIDIUM_HOE.get(), CCItems.NEODYMIUM_HOE.get(), CCItems.PALLADIUM_HOE.get(), CCItems.PERPLEXIUM_HOE.get(),
                CCItems.THUNDERSTEEL_HOE.get(), CCItems.TITANIUM_HOE.get(), CCItems.TUNGSTEN_HOE.get(),
                CCItems.COBALT_HELMET.get(), CCItems.INFUSED_THUNDERSTEEL_HELMET.get(), CCItems.IRIDIUM_HELMET.get(),
                CCItems.NEODYMIUM_HELMET.get(), CCItems.PALLADIUM_HELMET.get(), CCItems.PERPLEXIUM_HELMET.get(),
                CCItems.THUNDERSTEEL_HELMET.get(), CCItems.TITANIUM_HELMET.get(), CCItems.TUNGSTEN_HELMET.get(),
                CCItems.COBALT_LEGGINGS.get(), CCItems.INFUSED_THUNDERSTEEL_LEGGINGS.get(),
                CCItems.IRIDIUM_LEGGINGS.get(), CCItems.NEODYMIUM_LEGGINGS.get(), CCItems.PALLADIUM_LEGGINGS.get(),
                CCItems.PERPLEXIUM_LEGGINGS.get(), CCItems.THUNDERSTEEL_LEGGINGS.get(), CCItems.TITANIUM_LEGGINGS.get(),
                CCItems.TUNGSTEN_LEGGINGS.get(), CCItems.COBALT_PICKAXE.get(), CCItems.INFUSED_THUNDERSTEEL_PICKAXE.get(),
                CCItems.IRIDIUM_PICKAXE.get(), CCItems.NEODYMIUM_PICKAXE.get(), CCItems.PALLADIUM_PICKAXE.get(),
                CCItems.PERPLEXIUM_PICKAXE.get(), CCItems.THUNDERSTEEL_PICKAXE.get(), CCItems.TITANIUM_PICKAXE.get(),
                CCItems.TUNGSTEN_PICKAXE.get(), CCItems.COBALT_SHOVEL.get(), CCItems.INFUSED_THUNDERSTEEL_SHOVEL.get(),
                CCItems.IRIDIUM_SHOVEL.get(), CCItems.NEODYMIUM_SHOVEL.get(), CCItems.PALLADIUM_SHOVEL.get(),
                CCItems.PERPLEXIUM_SHOVEL.get(), CCItems.THUNDERSTEEL_SHOVEL.get(), CCItems.TITANIUM_SHOVEL.get(),
                CCItems.TUNGSTEN_SHOVEL.get(), CCItems.COBALT_SWORD.get(), CCItems.INFUSED_THUNDERSTEEL_SWORD.get(),
                CCItems.IRIDIUM_SWORD.get(), CCItems.NEODYMIUM_SWORD.get(), CCItems.PALLADIUM_SWORD.get(),
                CCItems.PERPLEXIUM_SWORD.get(), CCItems.THUNDERSTEEL_SWORD.get(), CCItems.TITANIUM_SWORD.get(),
                CCItems.TUNGSTEN_SWORD.get(), CCItems.PELLUCID_KATANA.get(), CCItems.DIAPHANOUS_SHURIKEN.get(),
                CCItems.SANGUINE_SHORTSWORD.get(), CCItems.GUIDED_NANOSPEAR.get(), CCItems.INFALLIBLE_BAYONET.get(),
                CCItems.PINPOINT_REVOLVER.get(), CCItems.AIMBOT_45.get(), CCItems.GALLANT_SHASHKA.get(),
                CCItems.NIGHTMARE_BOW.get(), CCItems.TREPIDOUS_ARROW.get(), CCItems.BESPATTERED_WARHAMMER.get(),
                CCItems.PRISMATIC_GRENADE.get(), CCItems.OSCILLATING_TRIDENT.get(), CCItems.ENTROPIC_SHORTBOW.get(),
                CCItems.VIBRATING_ARROW.get(), CCItems.UMBRAL_GUISARME.get(), CCItems.TWILIGHT_JAVELIN.get(),
                CCItems.COLLAPSAR_CLAYMORE.get(), CCItems.RELATIVISTIC_RAYGUN.get(), CCItems.HALLUCINOGENIC_BRACERS.get(),
                CCItems.PSYCHOTIC_LONGBOW.get(), CCItems.DELIRIUM_ARROW.get(), CCItems.CADUCEUS_GLAIVE.get(),
                CCItems.VAMPIRIC_CHAKRAM.get(), CCItems.INSTINCTUAL_SCYTHE.get(), CCItems.ARDENT_TOMAHAWK.get(),
                CCItems.ILLUSORY_SPEAR.get(), CCItems.PHRENIC_DART.get(), CCItems.DIABLO_GAUNTLETS.get(),
                CCItems.BRIMSTONE_FLAMETHROWER.get(), CCItems.BRIMSTONE_CANISTER.get(), CCItems.WORLDLINE_RAPIER.get(),
                CCItems.SNAPSHOT_RIFLE.get(), CCItems.CHRONAL_BULLET.get(), CCItems.REPULSOR_SABER.get(),
                CCItems.SUPERRADIANT_DAGGER.get(), CCItems.ELECTRON_STAFF.get(), CCItems.SPARK_LAUNCHERS.get(),
                CCItems.TERAVOLT_CANNON.get(), CCItems.SUPERLUMINAL_SLUG.get(), CCItems.WHITE_THUNDER.get(),
                CCItems.OBLIVION_CROSSBOW.get(), CCItems.WORLD_THREAD_BOLT.get()
        );
        tag(NON_EQUIPMENT).add(
                CCItems.JOURNAL.get(), CCItems.CAUSALITY_CRYSTAL.get(), CCItems.ANTHRACITE.get(),
                CCItems.MAGNETITE.get(), CCItems.RAW_COBALT.get(), CCItems.COBALT_NUGGET.get(),
                CCItems.COBALT_INGOT.get(), CCItems.RAW_IRIDIUM.get(), CCItems.IRIDIUM_NUGGET.get(),
                CCItems.IRIDIUM_INGOT.get(), CCItems.RAW_NEODYMIUM.get(), CCItems.NEODYMIUM_NUGGET.get(),
                CCItems.NEODYMIUM_INGOT.get(), CCItems.RAW_PALLADIUM.get(), CCItems.PALLADIUM_NUGGET.get(),
                CCItems.PALLADIUM_INGOT.get(), CCItems.PERPLEXIUM_NUGGET.get(), CCItems.PERPLEXIUM_INGOT.get(),
                CCItems.THUNDERSTEEL_UPGRADE.get(), CCItems.THUNDERSTEEL_NUGGET.get(), CCItems.THUNDERSTEEL_INGOT.get(),
                CCItems.RAW_TITANIUM.get(), CCItems.TITANIUM_NUGGET.get(), CCItems.TITANIUM_INGOT.get(),
                CCItems.RAW_TUNGSTEN.get(), CCItems.TUNGSTEN_NUGGET.get(), CCItems.TUNGSTEN_INGOT.get(),
                CCItems.QUANTUM_SIGIL.get(), CCItems.RIFT_TOKEN.get(), CCItems.STABLE_RIFT_TOKEN.get(),
                CCItems.ABYSS_STRING.get(), CCItems.TIME_CRYSTAL.get(), CCItems.VOID_FABRIC.get(),
                CCItems.WORLD_THREAD.get(), CCItems.REALM_SEED.get()
        );

        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
                CCItems.COBALT_BOOTS.get(), CCItems.INFUSED_THUNDERSTEEL_BOOTS.get(), CCItems.IRIDIUM_BOOTS.get(),
                CCItems.NEODYMIUM_BOOTS.get(), CCItems.PALLADIUM_BOOTS.get(), CCItems.PERPLEXIUM_BOOTS.get(),
                CCItems.THUNDERSTEEL_BOOTS.get(), CCItems.TITANIUM_BOOTS.get(), CCItems.TUNGSTEN_BOOTS.get(),
                CCItems.COBALT_CHESTPLATE.get(), CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE.get(),
                CCItems.IRIDIUM_CHESTPLATE.get(), CCItems.NEODYMIUM_CHESTPLATE.get(),
                CCItems.PALLADIUM_CHESTPLATE.get(), CCItems.PERPLEXIUM_CHESTPLATE.get(),
                CCItems.THUNDERSTEEL_CHESTPLATE.get(), CCItems.TITANIUM_CHESTPLATE.get(),
                CCItems.TUNGSTEN_CHESTPLATE.get(), CCItems.COBALT_HELMET.get(), CCItems.INFUSED_THUNDERSTEEL_HELMET.get(),
                CCItems.IRIDIUM_HELMET.get(), CCItems.NEODYMIUM_HELMET.get(), CCItems.PALLADIUM_HELMET.get(),
                CCItems.PERPLEXIUM_HELMET.get(), CCItems.THUNDERSTEEL_HELMET.get(), CCItems.TITANIUM_HELMET.get(),
                CCItems.TUNGSTEN_HELMET.get(), CCItems.COBALT_LEGGINGS.get(), CCItems.INFUSED_THUNDERSTEEL_LEGGINGS.get(),
                CCItems.IRIDIUM_LEGGINGS.get(), CCItems.NEODYMIUM_LEGGINGS.get(), CCItems.PALLADIUM_LEGGINGS.get(),
                CCItems.PERPLEXIUM_LEGGINGS.get(), CCItems.THUNDERSTEEL_LEGGINGS.get(), CCItems.TITANIUM_LEGGINGS.get(),
                CCItems.TUNGSTEN_LEGGINGS.get()
        );

        tag(PORTAL_ACTIVATOR).add(CCItems.STABLE_RIFT_TOKEN.get());
    }

    public static TagKey<Item> create(String tagName) {
        return ItemTags.create(CausalChaos.prefix(tagName));
    }

    public static TagKey<Item> makeForgeTag(String tagName) {
        return ItemTags.create(new ResourceLocation("forge", tagName));
    }
}
