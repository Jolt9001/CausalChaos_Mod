package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.item.CausalityCrystalItem;
import jolt9001.causalchaos.library.item.JournalItem;
import jolt9001.causalchaos.library.item.enums.CCArmorMaterial;
import jolt9001.causalchaos.library.item.armor.material.*;
import jolt9001.causalchaos.library.item.tool.material.axe.*;
import jolt9001.causalchaos.library.item.tool.material.hoe.*;
import jolt9001.causalchaos.library.item.tool.material.pickaxe.*;
import jolt9001.causalchaos.library.item.tool.material.shovel.*;
import jolt9001.causalchaos.library.item.tool.material.weapon.melee.*;
import jolt9001.causalchaos.util.CCTiers;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class CCItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CausalChaos.MODID);

    // Causal Journal
    public static final RegistryObject<JournalItem> JOURNAL = ITEMS.register("causal_journal", () -> new JournalItem(new Item.Properties()));

    // Quest (I.E. the Causality Crystal)
    public static final RegistryObject<CausalityCrystalItem> CAUSALITY_CRYSTAL = ITEMS.register("causality_crystal", () -> new CausalityCrystalItem(new Item.Properties()));

    // Crafting Ingredients and Materials (ingots, nuggets, raw ores, etc.)
    public static final RegistryObject<Item> COBALT_INGOT =  ITEMS.register("cobalt_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_INGOT = ITEMS.register("perplexium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_INGOT = ITEMS.register("thundersteel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COBALT_NUGGET =  ITEMS.register("cobalt_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_NUGGET = ITEMS.register("iridium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_NUGGET = ITEMS.register("neodymium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_NUGGET = ITEMS.register("palladium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_NUGGET = ITEMS.register("perplexium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_NUGGET = ITEMS.register("thundersteel_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_NUGGET = ITEMS.register("tungsten_nugget", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_COBALT =  ITEMS.register("raw_cobalt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_IRIDIUM = ITEMS.register("raw_iridium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NEODYMIUM = ITEMS.register("raw_neodymium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PALLADIUM = ITEMS.register("raw_palladium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANTHRACITE = ITEMS.register("anthracite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAGNETITE = ITEMS.register("magnetite", () -> new Item(new Item.Properties()));

    // Tools
        // Axes
    public static final RegistryObject<Item> COBALT_AXE = ITEMS.register("cobalt_axe", () -> new CobaltAxeItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_AXE = ITEMS.register("infused_thundersteel_axe", () -> new InfusedThundersteelAxeItem(CCTiers.INFUSED_THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_AXE = ITEMS.register("iridium_axe", () -> new IridiumAxeItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_AXE = ITEMS.register("neodymium_axe", () -> new NeodymiumAxeItem(CCTiers.NEODYMIUM,  new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_AXE = ITEMS.register("palladium_axe", () -> new PalladiumAxeItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_AXE = ITEMS.register("perplexium_axe", () -> new PerplexiumAxeItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_AXE = ITEMS.register("thundersteel_axe", () -> new ThundersteelAxeItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new TitaniumAxeItem(CCTiers.TITANIUM,  new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe", () -> new TungstenAxeItem(CCTiers.TUNGSTEN, new Item.Properties()));

        // Hoes
    public static final RegistryObject<Item> COBALT_HOE = ITEMS.register("cobalt_hoe", () -> new CobaltHoeItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_HOE = ITEMS.register("infused_thundersteel_hoe", () -> new InfusedThundersteelHoeItem(CCTiers.INFUSED_THUNDERSTEEL,  new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_HOE = ITEMS.register("iridium_hoe", () -> new IridiumHoeItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_HOE = ITEMS.register("neodymium_hoe", () -> new NeodymiumHoeItem(CCTiers.NEODYMIUM, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_HOE = ITEMS.register("palladium_hoe", () -> new PalladiumHoeItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_HOE = ITEMS.register("perplexium_hoe", () -> new PerplexiumHoeItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_HOE = ITEMS.register("thundersteel_hoe", () -> new ThundersteelHoeItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new TitaniumHoeItem(CCTiers.TITANIUM, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe", () -> new TungstenHoeItem(CCTiers.TUNGSTEN, new Item.Properties()));

    // Pickaxes
    public static final RegistryObject<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe", () -> new CobaltPickaxeItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_PICKAXE = ITEMS.register("infused_thundersteel_pickaxe", () -> new InfusedThundersteelPickaxeItem(CCTiers.INFUSED_THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_PICKAXE = ITEMS.register("iridium_pickaxe", () -> new IridiumPickaxeItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_PICKAXE = ITEMS.register("neodymium_pickaxe", () -> new NeodymiumPickaxeItem(CCTiers.NEODYMIUM, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_PICKAXE = ITEMS.register("palladium_pickaxe", () -> new PalladiumPickaxeItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_PICKAXE = ITEMS.register("perplexium_pickaxe", () -> new PerplexiumPickaxeItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_PICKAXE = ITEMS.register("thundersteel_pickaxe", () -> new ThundersteelPickaxeItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new TitaniumPickaxeItem(CCTiers.TITANIUM, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe", () -> new TungstenPickaxeItem(CCTiers.TUNGSTEN, new Item.Properties()));

        // Shovels
    public static final RegistryObject<Item> COBALT_SHOVEL = ITEMS.register("cobalt_shovel", () -> new CobaltShovelItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_SHOVEL = ITEMS.register("infused_thundersteel_shovel", () -> new InfusedThundersteelShovelItem(CCTiers.INFUSED_THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_SHOVEL = ITEMS.register("iridium_shovel", () -> new IridiumShovelItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_SHOVEL = ITEMS.register("neodymium_shovel", () -> new NeodymiumShovelItem(CCTiers.NEODYMIUM, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_SHOVEL = ITEMS.register("palladium_shovel", () -> new PalladiumShovelItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_SHOVEL = ITEMS.register("perplexium_shovel", () -> new PerplexiumShovelItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_SHOVEL = ITEMS.register("thundersteel_shovel", () -> new ThundersteelShovelItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new TitaniumShovelItem(CCTiers.TITANIUM, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_hoe", () -> new TungstenShovelItem(CCTiers.TUNGSTEN, new Item.Properties()));

    // Weapons
        // Material Melee
    public static final RegistryObject<Item> COBALT_SWORD = ITEMS.register("cobalt_sword", () -> new CobaltSwordItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_SWORD = ITEMS.register("infused_thundersteel_sword", () -> new InfusedThundersteelSwordItem(CCTiers.INFUSED_THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_SWORD = ITEMS.register("iridium_sword", () -> new IridiumSwordItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_SWORD = ITEMS.register("neodymium_sword", () -> new NeodymiumSwordItem(CCTiers.NEODYMIUM, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_SWORD = ITEMS.register("palladium_sword", () -> new PalladiumSwordItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_SWORD = ITEMS.register("perplexium_sword", () -> new PerplexiumSwordItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_SWORD = ITEMS.register("thundersteel_sword", () -> new ThundersteelSwordItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () -> new TitaniumSwordItem(CCTiers.TITANIUM, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword", () -> new TungstenSwordItem(CCTiers.TUNGSTEN, new Item.Properties()));

        // Super Melee (Uses SwordItem() as a temporary reference)
    public static final RegistryObject<Item> PELLUCID_KATANA = ITEMS.register("pellucid_katana", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Tsuna
    public static final RegistryObject<Item> SANGUINE_SHORTSWORD = ITEMS.register("sanguine_shortsword", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Kai
    public static final RegistryObject<Item> INFALLIBLE_BAYONET = ITEMS.register("infallible_bayonet", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Terry
    public static final RegistryObject<Item> GALLANT_SHASHKA = ITEMS.register("gallant_shashka", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Lyadova
    public static final RegistryObject<Item> BESPATTERED_WARHAMMER = ITEMS.register("bespattered_warhammer", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Aella
    public static final RegistryObject<Item> OSCILLATING_TRIDENT = ITEMS.register("oscillating_trident", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jack
    public static final RegistryObject<Item> UMBRAL_GUISARME = ITEMS.register("umbral_guisarme", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Xanthea
    public static final RegistryObject<Item> COLLAPSAR_CLAYMORE = ITEMS.register("collapsar_claymore", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Will
    public static final RegistryObject<Item> HALLUCINOGENIC_BRACERS = ITEMS.register("hallucinogenic_bracers", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Matthue
    public static final RegistryObject<Item> CADUCEUS_GLAIVE = ITEMS.register("caduceus_glaive", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Alline
    public static final RegistryObject<Item> INSTINCTUAL_SCYTHE = ITEMS.register("instinctual_scythe", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Madeline
    public static final RegistryObject<Item> ILLUSORY_SPEAR = ITEMS.register("illusory_spear", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Emily
    public static final RegistryObject<Item> DIABLO_GAUNTLETS = ITEMS.register("diablo_gauntlets", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Adrian
    public static final RegistryObject<Item> WORLDLINE_RAPIER = ITEMS.register("worldline_rapier", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Andrea
    public static final RegistryObject<Item> REPULSOR_SABER = ITEMS.register("repulsor_saber", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Rex
    public static final RegistryObject<Item> ELECTRON_STAFF = ITEMS.register("electron_staff", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jolt
    public static final RegistryObject<Item> WHITE_THUNDER = ITEMS.register("white_thunder", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from FPJolt

        // Material Ranged

        // Super Ranged (Uses SwordItem() as a temporary reference)
    public static final RegistryObject<Item> DIAPHANOUS_SHURIKEN = ITEMS.register("diaphanous_shuriken", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Tsuna
    public static final RegistryObject<Item> GUIDED_NANOSPEAR = ITEMS.register("guided_nanospears", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Kai
    public static final RegistryObject<Item> PINPOINT_REVOLVER = ITEMS.register("pinpoint_revolver", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Terry
    public static final RegistryObject<Item> NIGHTMARE_BOW = ITEMS.register("nightmare_bow", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Lyadova
    public static final RegistryObject<Item> PRISMATIC_GRENADE = ITEMS.register("prismatic_grenade", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Aella
    public static final RegistryObject<Item> ENTROPIC_SHORTBOW = ITEMS.register("entropic_shortbow", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jack
    public static final RegistryObject<Item> TWILIGHT_JAVELIN = ITEMS.register("twilight_javelin", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Xanthea
    public static final RegistryObject<Item> RELATIVISTIC_RAYGUN = ITEMS.register("relativistic_raygun", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Will
    public static final RegistryObject<Item> PSYCHOTIC_LONGBOW = ITEMS.register("psychotic_longbow", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Matthue
    public static final RegistryObject<Item> VAMPIRIC_CHAKRAM = ITEMS.register("vampiric_chakram", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Alline
    public static final RegistryObject<Item> ARDENT_TOMAHAWK = ITEMS.register("ardent_tomahawk", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Madeline
    public static final RegistryObject<Item> PHRENIC_DART = ITEMS.register("phrenic_dart", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Emily
    public static final RegistryObject<Item> BRIMSTONE_FLAMETHROWER = ITEMS.register("brimstone_flamethrower", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Adrian
    public static final RegistryObject<Item> SNAPSHOT_RIFLE = ITEMS.register("snapshot_rifle", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Andrea
    public static final RegistryObject<Item> SUPERRADIANT_DAGGER = ITEMS.register("superradiant_dagger", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Rex
    public static final RegistryObject<Item> SPARK_LAUNCHERS = ITEMS.register("spark_launchers", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jolt
    public static final RegistryObject<Item> TERAVOLT_CANNON = ITEMS.register("teravolt_cannon", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jolt
    public static final RegistryObject<Item> OBLIVION_CROSSBOW = ITEMS.register("oblivion_crossbow", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from FPJolt

    // Ammunition
        // Material
        // Superweapon
    public static final RegistryObject<Item> AIMBOT_45 = ITEMS.register("aimbot_45", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> TREPIDOUS_ARROW = ITEMS.register("trepidous_arrow", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> VIBRATING_ARROW = ITEMS.register("vibrating_arrow", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> DELIRIUM_ARROW = ITEMS.register("delirium_arrow", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> BRIMSTONE_CANISTER = ITEMS.register("brimstone_canister", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> CHRONAL_BULLET = ITEMS.register("chronal_bullet", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> SUPERLUMINAL_SLUG = ITEMS.register("superluminal_slug", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> WORLD_THREAD_BOLT = ITEMS.register("world_thread_bolt", () -> new ArrowItem(new Item.Properties()));

    // Material Armor
        // Boots
    public static final RegistryObject<Item> COBALT_BOOTS = ITEMS.register("cobalt_boots", () -> new CobaltArmorItem(CCArmorMaterial.ARMOR_COBALT, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_BOOTS = ITEMS.register("infused_thundersteel_boots", () -> new InfusedThundersteelArmorItem(CCArmorMaterial.ARMOR_INFUSED_THUNDERSTEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_BOOTS = ITEMS.register("iridium_boots", () -> new IridiumArmorItem(CCArmorMaterial.ARMOR_IRIDIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_BOOTS = ITEMS.register("neodymium_boots", () -> new NeodymiumArmorItem(CCArmorMaterial.ARMOR_NEODYMIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_BOOTS = ITEMS.register("palladium_boots", () -> new PalladiumArmorItem(CCArmorMaterial.ARMOR_PALLADIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_BOOTS = ITEMS.register("perplexium_boots", () -> new PerplexiumArmorItem(CCArmorMaterial.ARMOR_PERPLEXIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_BOOTS = ITEMS.register("thundersteel_boots", () -> new ThundersteelArmorItem(CCArmorMaterial.ARMOR_THUNDERSTEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots", () -> new TitaniumArmorItem(CCArmorMaterial.ARMOR_TITANIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_BOOTS = ITEMS.register("tungsten_boots", () -> new TungstenArmorItem(CCArmorMaterial.ARMOR_TUNGSTEN, ArmorItem.Type.BOOTS, new Item.Properties()));

        // Chestplates
    public static final RegistryObject<Item> COBALT_CHESTPLATE = ITEMS.register("cobalt_chestplate", () -> new CobaltArmorItem(CCArmorMaterial.ARMOR_COBALT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_CHESTPLATE = ITEMS.register("infused_thundersteel_chestplate", () -> new InfusedThundersteelArmorItem(CCArmorMaterial.ARMOR_INFUSED_THUNDERSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_CHESTPLATE = ITEMS.register("iridium_chestplate", () -> new IridiumArmorItem(CCArmorMaterial.ARMOR_IRIDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_CHESTPLATE = ITEMS.register("neodymium_chestplate", () -> new NeodymiumArmorItem(CCArmorMaterial.ARMOR_NEODYMIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_CHESTPLATE = ITEMS.register("palladium_chestplate", () -> new PalladiumArmorItem(CCArmorMaterial.ARMOR_PALLADIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_CHESTPLATE = ITEMS.register("perplexium_chestplate", () -> new PerplexiumArmorItem(CCArmorMaterial.ARMOR_PERPLEXIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_CHESTPLATE = ITEMS.register("thundersteel_chestplate", () -> new ThundersteelArmorItem(CCArmorMaterial.ARMOR_THUNDERSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", () -> new TitaniumArmorItem(CCArmorMaterial.ARMOR_TITANIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_CHESTPLATE = ITEMS.register("tungsten_chestplate", () -> new TungstenArmorItem(CCArmorMaterial.ARMOR_TUNGSTEN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

        // Helmets
    public static final RegistryObject<Item> COBALT_HELMET = ITEMS.register("cobalt_helmet", () -> new CobaltArmorItem(CCArmorMaterial.ARMOR_COBALT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_HELMET = ITEMS.register("infused_thundersteel_helmet", () -> new InfusedThundersteelArmorItem(CCArmorMaterial.ARMOR_INFUSED_THUNDERSTEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_HELMET = ITEMS.register("iridium_helmet", () -> new IridiumArmorItem(CCArmorMaterial.ARMOR_IRIDIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_HELMET = ITEMS.register("neodymium_helmet", () -> new NeodymiumArmorItem(CCArmorMaterial.ARMOR_NEODYMIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_HELMET = ITEMS.register("palladium_helmet", () -> new PalladiumArmorItem(CCArmorMaterial.ARMOR_PALLADIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_HELMET = ITEMS.register("perplexium_helmet", () -> new PerplexiumArmorItem(CCArmorMaterial.ARMOR_PERPLEXIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_HELMET = ITEMS.register("thundersteel_helmet", () -> new ThundersteelArmorItem(CCArmorMaterial.ARMOR_THUNDERSTEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet", () -> new TitaniumArmorItem(CCArmorMaterial.ARMOR_TITANIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_HELMET = ITEMS.register("tungsten_helmet", () -> new TungstenArmorItem(CCArmorMaterial.ARMOR_TUNGSTEN, ArmorItem.Type.HELMET, new Item.Properties()));

        // Leggings
    public static final RegistryObject<Item> COBALT_LEGGINGS = ITEMS.register("cobalt_leggings", () -> new CobaltArmorItem(CCArmorMaterial.ARMOR_COBALT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_LEGGINGS = ITEMS.register("infused_thundersteel_leggings", () -> new InfusedThundersteelArmorItem(CCArmorMaterial.ARMOR_INFUSED_THUNDERSTEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_LEGGINGS = ITEMS.register("iridium_leggings", () -> new IridiumArmorItem(CCArmorMaterial.ARMOR_IRIDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_LEGGINGS = ITEMS.register("neodymium_leggings", () -> new NeodymiumArmorItem(CCArmorMaterial.ARMOR_NEODYMIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_LEGGINGS = ITEMS.register("palladium_leggings", () -> new PalladiumArmorItem(CCArmorMaterial.ARMOR_PALLADIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_LEGGINGS = ITEMS.register("perplexium_leggings", () -> new PerplexiumArmorItem(CCArmorMaterial.ARMOR_PERPLEXIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_LEGGINGS = ITEMS.register("thundersteel_leggings", () -> new ThundersteelArmorItem(CCArmorMaterial.ARMOR_THUNDERSTEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", () -> new TitaniumArmorItem(CCArmorMaterial.ARMOR_TITANIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_LEGGINGS = ITEMS.register("tungsten_leggings", () -> new TungstenArmorItem(CCArmorMaterial.ARMOR_TUNGSTEN, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    // Super armor
        // Boots
        // Chestplates
        // Helmets
        // Leggings
    // Gadgets
    public static final RegistryObject<Item> QUANTUM_SIGIL = ITEMS.register("quantum_sigil", () -> new Item(new Item.Properties())); // Used to summon the Demon Lord boss
    public static final RegistryObject<Item> RIFT_TOKEN = ITEMS.register("rift_token", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STABLE_RIFT_TOKEN = ITEMS.register("stable_rift_token", () -> new Item(new Item.Properties()));

    // Crafting ingredients
    public static final RegistryObject<Item> ABYSS_STRING = ITEMS.register("abyss_string", () -> new Item(new Item.Properties())); // Dropped from Riftwalkers (all types)
    public static final RegistryObject<Item> TIME_CRYSTAL = ITEMS.register("time_crystal", () -> new Item(new Item.Properties())); // Drops from Demon Lord, Superbosses, and Riftwalkers
    public static final RegistryObject<Item> VOID_FABRIC = ITEMS.register("void_fabric", () -> new Item(new Item.Properties())); // Crafted from nine Abyss String
    public static final RegistryObject<Item> WORLD_THREAD = ITEMS.register("world_thread", () -> new Item(new Item.Properties())); // Drops from powerful Riftwalkers and the Worldeater
    public static final RegistryObject<Item> REALM_SEED = ITEMS.register("realm_seed", () -> new Item(new Item.Properties())); // Crafted with Void Fabric, Time Crystals, and a World Thread

    // Smithing Templates
    public static final RegistryObject<Item> THUNDERSTEEL_UPGRADE = ITEMS.register("thundersteel_upgrade_smithing_template", () -> new Item(new Item.Properties()));
    // Add more smithing templates as treasures

    // Registration
    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}

    /*
    public static List<ItemDefinition<?>> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    private static <T extends Item> ItemDefinition<T> item(String name, ResourceLocation id, Function<Item.Properties, T> factory, ResourceKey<CreativeModeTab> group) {
        Item.Properties p = new Item.Properties();
        T item = factory.apply(p);
        ItemDefinition<T> definition = new ItemDefinition<>(name, id, item);
        if (group.equals(CCCreativeModeTabs.ITEMS)) {

        }
        ITEMS.add(definition);
        return definition;
    }
    */
}