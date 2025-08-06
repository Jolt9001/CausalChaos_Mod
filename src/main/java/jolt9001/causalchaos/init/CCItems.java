package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.item.CausalityCrystalItem;
import jolt9001.causalchaos.library.item.FuelItem;
import jolt9001.causalchaos.library.item.armor.supermaterial.*;
import jolt9001.causalchaos.library.enums.CCArmorMaterial;
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
    public static final DeferredRegister<Item> EQUIPMENT = DeferredRegister.create(ForgeRegistries.ITEMS, CausalChaos.MODID);
    // Causal Journal
    public static final RegistryObject<Item> JOURNAL = ITEMS.register("causal_journal", () -> new Item(new Item.Properties()));

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
    public static final RegistryObject<Item> ANTHRACITE = ITEMS.register("anthracite", () -> new FuelItem(new Item.Properties(), 400));
    public static final RegistryObject<Item> MAGNETITE = ITEMS.register("magnetite", () -> new Item(new Item.Properties()));

    // Tools
        // Axes
    public static final RegistryObject<Item> COBALT_AXE = EQUIPMENT.register("cobalt_axe", () -> new CobaltAxeItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_AXE = EQUIPMENT.register("infused_thundersteel_axe", () -> new InfusedThundersteelAxeItem(CCTiers.INFUSED_THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_AXE = EQUIPMENT.register("iridium_axe", () -> new IridiumAxeItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_AXE = EQUIPMENT.register("neodymium_axe", () -> new NeodymiumAxeItem(CCTiers.NEODYMIUM,  new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_AXE = EQUIPMENT.register("palladium_axe", () -> new PalladiumAxeItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_AXE = EQUIPMENT.register("perplexium_axe", () -> new PerplexiumAxeItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_AXE = EQUIPMENT.register("thundersteel_axe", () -> new ThundersteelAxeItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_AXE = EQUIPMENT.register("titanium_axe", () -> new TitaniumAxeItem(CCTiers.TITANIUM,  new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_AXE = EQUIPMENT.register("tungsten_axe", () -> new TungstenAxeItem(CCTiers.TUNGSTEN, new Item.Properties()));

        // Hoes
    public static final RegistryObject<Item> COBALT_HOE = EQUIPMENT.register("cobalt_hoe", () -> new CobaltHoeItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_HOE = EQUIPMENT.register("infused_thundersteel_hoe", () -> new InfusedThundersteelHoeItem(CCTiers.INFUSED_THUNDERSTEEL,  new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_HOE = EQUIPMENT.register("iridium_hoe", () -> new IridiumHoeItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_HOE = EQUIPMENT.register("neodymium_hoe", () -> new NeodymiumHoeItem(CCTiers.NEODYMIUM, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_HOE = EQUIPMENT.register("palladium_hoe", () -> new PalladiumHoeItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_HOE = EQUIPMENT.register("perplexium_hoe", () -> new PerplexiumHoeItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_HOE = EQUIPMENT.register("thundersteel_hoe", () -> new ThundersteelHoeItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_HOE = EQUIPMENT.register("titanium_hoe", () -> new TitaniumHoeItem(CCTiers.TITANIUM, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_HOE = EQUIPMENT.register("tungsten_hoe", () -> new TungstenHoeItem(CCTiers.TUNGSTEN, new Item.Properties()));

    // Pickaxes
    public static final RegistryObject<Item> COBALT_PICKAXE = EQUIPMENT.register("cobalt_pickaxe", () -> new CobaltPickaxeItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_PICKAXE = EQUIPMENT.register("infused_thundersteel_pickaxe", () -> new InfusedThundersteelPickaxeItem(CCTiers.INFUSED_THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_PICKAXE = EQUIPMENT.register("iridium_pickaxe", () -> new IridiumPickaxeItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_PICKAXE = EQUIPMENT.register("neodymium_pickaxe", () -> new NeodymiumPickaxeItem(CCTiers.NEODYMIUM, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_PICKAXE = EQUIPMENT.register("palladium_pickaxe", () -> new PalladiumPickaxeItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_PICKAXE = EQUIPMENT.register("perplexium_pickaxe", () -> new PerplexiumPickaxeItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_PICKAXE = EQUIPMENT.register("thundersteel_pickaxe", () -> new ThundersteelPickaxeItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = EQUIPMENT.register("titanium_pickaxe", () -> new TitaniumPickaxeItem(CCTiers.TITANIUM, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = EQUIPMENT.register("tungsten_pickaxe", () -> new TungstenPickaxeItem(CCTiers.TUNGSTEN, new Item.Properties()));

        // Shovels
    public static final RegistryObject<Item> COBALT_SHOVEL = EQUIPMENT.register("cobalt_shovel", () -> new CobaltShovelItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_SHOVEL = EQUIPMENT.register("infused_thundersteel_shovel", () -> new InfusedThundersteelShovelItem(CCTiers.INFUSED_THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_SHOVEL = EQUIPMENT.register("iridium_shovel", () -> new IridiumShovelItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_SHOVEL = EQUIPMENT.register("neodymium_shovel", () -> new NeodymiumShovelItem(CCTiers.NEODYMIUM, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_SHOVEL = EQUIPMENT.register("palladium_shovel", () -> new PalladiumShovelItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_SHOVEL = EQUIPMENT.register("perplexium_shovel", () -> new PerplexiumShovelItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_SHOVEL = EQUIPMENT.register("thundersteel_shovel", () -> new ThundersteelShovelItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = EQUIPMENT.register("titanium_shovel", () -> new TitaniumShovelItem(CCTiers.TITANIUM, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = EQUIPMENT.register("tungsten_shovel", () -> new TungstenShovelItem(CCTiers.TUNGSTEN, new Item.Properties()));

    // Weapons
        // Material Melee
    public static final RegistryObject<Item> COBALT_SWORD = EQUIPMENT.register("cobalt_sword", () -> new CobaltSwordItem(CCTiers.COBALT, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_SWORD = EQUIPMENT.register("infused_thundersteel_sword", () -> new InfusedThundersteelSwordItem(CCTiers.INFUSED_THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_SWORD = EQUIPMENT.register("iridium_sword", () -> new IridiumSwordItem(CCTiers.IRIDIUM, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_SWORD = EQUIPMENT.register("neodymium_sword", () -> new NeodymiumSwordItem(CCTiers.NEODYMIUM, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_SWORD = EQUIPMENT.register("palladium_sword", () -> new PalladiumSwordItem(CCTiers.PALLADIUM, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_SWORD = EQUIPMENT.register("perplexium_sword", () -> new PerplexiumSwordItem(CCTiers.PERPLEXIUM, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_SWORD = EQUIPMENT.register("thundersteel_sword", () -> new ThundersteelSwordItem(CCTiers.THUNDERSTEEL, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SWORD = EQUIPMENT.register("titanium_sword", () -> new TitaniumSwordItem(CCTiers.TITANIUM, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SWORD = EQUIPMENT.register("tungsten_sword", () -> new TungstenSwordItem(CCTiers.TUNGSTEN, new Item.Properties()));

        // Super Melee (Uses SwordItem() as a temporary reference)
    public static final RegistryObject<Item> PELLUCID_KATANA = EQUIPMENT.register("pellucid_katana", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Tsuna
    public static final RegistryObject<Item> SANGUINE_SHORTSWORD = EQUIPMENT.register("sanguine_shortsword", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Kai
    public static final RegistryObject<Item> INFALLIBLE_BAYONET = EQUIPMENT.register("infallible_bayonet", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Terry
    public static final RegistryObject<Item> GALLANT_SHASHKA = EQUIPMENT.register("gallant_shashka", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Lyadova
    public static final RegistryObject<Item> BESPATTERED_WARHAMMER = EQUIPMENT.register("bespattered_warhammer", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Aella
    public static final RegistryObject<Item> OSCILLATING_TRIDENT = EQUIPMENT.register("oscillating_trident", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jack
    public static final RegistryObject<Item> UMBRAL_GUISARME = EQUIPMENT.register("umbral_guisarme", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Xanthea
    public static final RegistryObject<Item> COLLAPSAR_CLAYMORE = EQUIPMENT.register("collapsar_claymore", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Will
    public static final RegistryObject<Item> HALLUCINOGENIC_BRACERS = EQUIPMENT.register("hallucinogenic_bracers", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Matthue
    public static final RegistryObject<Item> CADUCEUS_GLAIVE = EQUIPMENT.register("caduceus_glaive", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Alline
    public static final RegistryObject<Item> INSTINCTUAL_SCYTHE = EQUIPMENT.register("instinctual_scythe", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Madeline
    public static final RegistryObject<Item> ILLUSORY_SPEAR = EQUIPMENT.register("illusory_spear", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Emily
    public static final RegistryObject<Item> DIABLO_GAUNTLETS = EQUIPMENT.register("diablo_gauntlets", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Adrian
    public static final RegistryObject<Item> WORLDLINE_RAPIER = EQUIPMENT.register("worldline_rapier", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Andrea
    public static final RegistryObject<Item> REPULSOR_SABER = EQUIPMENT.register("repulsor_saber", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Rex
    public static final RegistryObject<Item> ELECTRON_STAFF = EQUIPMENT.register("electron_staff", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jolt
    public static final RegistryObject<Item> WHITE_THUNDER = EQUIPMENT.register("white_thunder", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from FPJolt

        // Material Ranged

        // Super Ranged (Uses SwordItem() as a temporary reference)
    public static final RegistryObject<Item> DIAPHANOUS_SHURIKEN = EQUIPMENT.register("diaphanous_shuriken", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Tsuna
    public static final RegistryObject<Item> GUIDED_NANOSPEAR = EQUIPMENT.register("guided_nanospears", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Kai
    public static final RegistryObject<Item> PINPOINT_REVOLVER = EQUIPMENT.register("pinpoint_revolver", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Terry
    public static final RegistryObject<Item> NIGHTMARE_BOW = EQUIPMENT.register("nightmare_bow", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Lyadova
    public static final RegistryObject<Item> PRISMATIC_GRENADE = EQUIPMENT.register("prismatic_grenade", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Aella
    public static final RegistryObject<Item> ENTROPIC_SHORTBOW = EQUIPMENT.register("entropic_shortbow", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jack
    public static final RegistryObject<Item> TWILIGHT_JAVELIN = EQUIPMENT.register("twilight_javelin", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Xanthea
    public static final RegistryObject<Item> RELATIVISTIC_RAYGUN = EQUIPMENT.register("relativistic_raygun", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Will
    public static final RegistryObject<Item> PSYCHOTIC_LONGBOW = EQUIPMENT.register("psychotic_longbow", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Matthue
    public static final RegistryObject<Item> VAMPIRIC_CHAKRAM = EQUIPMENT.register("vampiric_chakram", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Alline
    public static final RegistryObject<Item> ARDENT_TOMAHAWK = EQUIPMENT.register("ardent_tomahawk", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Madeline
    public static final RegistryObject<Item> PHRENIC_DART = EQUIPMENT.register("phrenic_dart", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Emily
    public static final RegistryObject<Item> BRIMSTONE_FLAMETHROWER = EQUIPMENT.register("brimstone_flamethrower", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Adrian
    public static final RegistryObject<Item> SNAPSHOT_RIFLE = EQUIPMENT.register("snapshot_rifle", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Andrea
    public static final RegistryObject<Item> SUPERRADIANT_DAGGER = EQUIPMENT.register("superradiant_dagger", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Rex
    public static final RegistryObject<Item> SPARK_LAUNCHERS = EQUIPMENT.register("spark_launchers", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jolt
    public static final RegistryObject<Item> TERAVOLT_CANNON = EQUIPMENT.register("teravolt_cannon", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from Jolt
    public static final RegistryObject<Item> OBLIVION_CROSSBOW = EQUIPMENT.register("oblivion_crossbow", () -> new SwordItem(CCTiers.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from FPJolt

    // Ammunition
        // Material
        // Superweapon
    public static final RegistryObject<Item> AIMBOT_45 = EQUIPMENT.register("aimbot_45", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> TREPIDOUS_ARROW = EQUIPMENT.register("trepidous_arrow", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> VIBRATING_ARROW = EQUIPMENT.register("vibrating_arrow", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> DELIRIUM_ARROW = EQUIPMENT.register("delirium_arrow", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> BRIMSTONE_CANISTER = EQUIPMENT.register("brimstone_canister", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> CHRONAL_BULLET = EQUIPMENT.register("chronal_bullet", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> SUPERLUMINAL_SLUG = EQUIPMENT.register("superluminal_slug", () -> new ArrowItem(new Item.Properties()));
    public static final RegistryObject<Item> WORLD_THREAD_BOLT = EQUIPMENT.register("world_thread_bolt", () -> new ArrowItem(new Item.Properties()));

    // Material Armor
        // Helmets
    public static final RegistryObject<Item> COBALT_HELMET = EQUIPMENT.register("cobalt_helmet", () -> new /*Cobalt*/ArmorItem(CCArmorMaterial.ARMOR_COBALT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_HELMET = EQUIPMENT.register("infused_thundersteel_helmet", () -> new /*InfusedThundersteel*/ArmorItem(CCArmorMaterial.ARMOR_INFUSED_THUNDERSTEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_HELMET = EQUIPMENT.register("iridium_helmet", () -> new /*Iridium*/ArmorItem(CCArmorMaterial.ARMOR_IRIDIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_HELMET = EQUIPMENT.register("neodymium_helmet", () -> new /*Neodymium*/ArmorItem(CCArmorMaterial.ARMOR_NEODYMIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_HELMET = EQUIPMENT.register("palladium_helmet", () -> new /*Palladium*/ArmorItem(CCArmorMaterial.ARMOR_PALLADIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_HELMET = EQUIPMENT.register("perplexium_helmet", () -> new /*Perplexium*/ArmorItem(CCArmorMaterial.ARMOR_PERPLEXIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_HELMET = EQUIPMENT.register("thundersteel_helmet", () -> new /*Thundersteel*/ArmorItem(CCArmorMaterial.ARMOR_THUNDERSTEEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_HELMET = EQUIPMENT.register("titanium_helmet", () -> new /*Titanium*/ArmorItem(CCArmorMaterial.ARMOR_TITANIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_HELMET = EQUIPMENT.register("tungsten_helmet", () -> new /*Tungsten*/ArmorItem(CCArmorMaterial.ARMOR_TUNGSTEN, ArmorItem.Type.HELMET, new Item.Properties()));

        // Chestplates
    public static final RegistryObject<Item> COBALT_CHESTPLATE = EQUIPMENT.register("cobalt_chestplate", () -> new /*Cobalt*/ArmorItem(CCArmorMaterial.ARMOR_COBALT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_CHESTPLATE = EQUIPMENT.register("infused_thundersteel_chestplate", () -> new /*InfusedThundersteel*/ArmorItem(CCArmorMaterial.ARMOR_INFUSED_THUNDERSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_CHESTPLATE = EQUIPMENT.register("iridium_chestplate", () -> new /*Iridium*/ArmorItem(CCArmorMaterial.ARMOR_IRIDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_CHESTPLATE = EQUIPMENT.register("neodymium_chestplate", () -> new /*Neodymium*/ArmorItem(CCArmorMaterial.ARMOR_NEODYMIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_CHESTPLATE = EQUIPMENT.register("palladium_chestplate", () -> new /*Palladium*/ArmorItem(CCArmorMaterial.ARMOR_PALLADIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_CHESTPLATE = EQUIPMENT.register("perplexium_chestplate", () -> new /*Perplexium*/ArmorItem(CCArmorMaterial.ARMOR_PERPLEXIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_CHESTPLATE = EQUIPMENT.register("thundersteel_chestplate", () -> new /*Thundersteel*/ArmorItem(CCArmorMaterial.ARMOR_THUNDERSTEEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = EQUIPMENT.register("titanium_chestplate", () -> new /*Titanium*/ArmorItem(CCArmorMaterial.ARMOR_TITANIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_CHESTPLATE = EQUIPMENT.register("tungsten_chestplate", () -> new /*Tungsten*/ArmorItem(CCArmorMaterial.ARMOR_TUNGSTEN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        // Leggings
    public static final RegistryObject<Item> COBALT_LEGGINGS = EQUIPMENT.register("cobalt_leggings", () -> new /*Cobalt*/ArmorItem(CCArmorMaterial.ARMOR_COBALT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_LEGGINGS = EQUIPMENT.register("infused_thundersteel_leggings", () -> new /*InfusedThundersteel*/ArmorItem(CCArmorMaterial.ARMOR_INFUSED_THUNDERSTEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_LEGGINGS = EQUIPMENT.register("iridium_leggings", () -> new /*Iridium*/ArmorItem(CCArmorMaterial.ARMOR_IRIDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_LEGGINGS = EQUIPMENT.register("neodymium_leggings", () -> new /*Neodymium*/ArmorItem(CCArmorMaterial.ARMOR_NEODYMIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_LEGGINGS = EQUIPMENT.register("palladium_leggings", () -> new /*Palladium*/ArmorItem(CCArmorMaterial.ARMOR_PALLADIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_LEGGINGS = EQUIPMENT.register("perplexium_leggings", () -> new /*Perplexium*/ArmorItem(CCArmorMaterial.ARMOR_PERPLEXIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_LEGGINGS = EQUIPMENT.register("thundersteel_leggings", () -> new /*Thundersteel*/ArmorItem(CCArmorMaterial.ARMOR_THUNDERSTEEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = EQUIPMENT.register("titanium_leggings", () -> new /*Titanium*/ArmorItem(CCArmorMaterial.ARMOR_TITANIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_LEGGINGS = EQUIPMENT.register("tungsten_leggings", () -> new /*Tungsten*/ArmorItem(CCArmorMaterial.ARMOR_TUNGSTEN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        // Boots
    public static final RegistryObject<Item> COBALT_BOOTS = EQUIPMENT.register("cobalt_boots", () -> new /*Cobalt*/ArmorItem(CCArmorMaterial.ARMOR_COBALT, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_BOOTS = EQUIPMENT.register("infused_thundersteel_boots", () -> new /*InfusedThundersteel*/ArmorItem(CCArmorMaterial.ARMOR_INFUSED_THUNDERSTEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_BOOTS = EQUIPMENT.register("iridium_boots", () -> new /*Iridium*/ArmorItem(CCArmorMaterial.ARMOR_IRIDIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_BOOTS = EQUIPMENT.register("neodymium_boots", () -> new /*Neodymium*/ArmorItem(CCArmorMaterial.ARMOR_NEODYMIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_BOOTS = EQUIPMENT.register("palladium_boots", () -> new /*Palladium*/ArmorItem(CCArmorMaterial.ARMOR_PALLADIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_BOOTS = EQUIPMENT.register("perplexium_boots", () -> new /*Perplexium*/ArmorItem(CCArmorMaterial.ARMOR_PERPLEXIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_BOOTS = EQUIPMENT.register("thundersteel_boots", () -> new /*Thundersteel*/ArmorItem(CCArmorMaterial.ARMOR_THUNDERSTEEL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_BOOTS = EQUIPMENT.register("titanium_boots", () -> new /*Titanium*/ArmorItem(CCArmorMaterial.ARMOR_TITANIUM, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_BOOTS = EQUIPMENT.register("tungsten_boots", () -> new /*Tungsten*/ArmorItem(CCArmorMaterial.ARMOR_TUNGSTEN, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Special Equipment
    public static final RegistryObject<Item> PERFECTED_ELYTRA = EQUIPMENT.register("perfected_elytra", () -> new ElytraItem(new Item.Properties()));

    // Super armor
        // Helmets
    public static final RegistryObject<Item> HYPERDIAMOND_CRYSTAL_HELMET = EQUIPMENT.register("hyperdiamond_crystal_crystal_helmet", () -> new HyperdiamondCrystalArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_COAGULANT_HELMET = EQUIPMENT.register("crimson_coagulant_helmet", () -> new CrimsonCoagulantArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DEADLY_PRECISION_HELMET = EQUIPMENT.register("deadly_precision_helmet", () -> new DeadlyPrecisionArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SUBJUGATED_HORROR_HELMET = EQUIPMENT.register("subjugated_horror_helmet", () -> new SubjugatedHorrorArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DRACONIC_RAINBOW_HELMET = EQUIPMENT.register("draconic_rainbow_helmet", () -> new DraconicRainbowArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ZERO_POINT_HELMET = EQUIPMENT.register("zero_point_helmet", () -> new ZeroPointArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SHADOW_WARD_HELMET = EQUIPMENT.register("shadow_ward_helmet", () -> new ShadowWardArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STELLAR_SINGULARITY_HELMET = EQUIPMENT.register("stellar_singularity_helmet", () -> new StellarSingularityArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> LUNATIC_ASYLUM_HELMET = EQUIPMENT.register("lunatic_asylum_helmet", () -> new LunaticAsylumArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> POSTMODERN_CLERIC_HELMET = EQUIPMENT.register("postmodern_cleric_helmet", () -> new PostmodernClericArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CONDENSED_EMOTION_HELMET = EQUIPMENT.register("condensed_emotion_helmet", () -> new CondensedEmotionArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COGNITIVE_BARRIER_HELMET = EQUIPMENT.register("cognitive_barrier_helmet", () -> new CognitiveBarrierArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_GUARDIAN_HELMET = EQUIPMENT.register("demonic_guardian_helmet", () -> new DemonicGuardianArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TEMPORAL_VALKYRIE_HELMET = EQUIPMENT.register("temporal_valkyrie_helmet", () -> new TemporalValkyrieArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DARK_ENERGY_HELMET = EQUIPMENT.register("dark_energy_helmet", () -> new DarkEnergyArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> LIVING_THUNDER_HELMET = EQUIPMENT.register("living_thunder_helmet", () -> new LivingThunderArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> QUANTUM_FOAM_HELMET = EQUIPMENT.register("quantum_foam_helmet", () -> new QuantumFoamArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.HELMET, new Item.Properties()));
        // Chestplates
    public static final RegistryObject<Item> HYPERDIAMOND_CRYSTAL_CHESTPLATE = EQUIPMENT.register("hyperdiamond_crystal_crystal_chestplate", () -> new HyperdiamondCrystalArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_COAGULANT_CHESTPLATE = EQUIPMENT.register("crimson_coagulant_chestplate", () -> new CrimsonCoagulantArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DEADLY_PRECISION_HCHESTPLATE = EQUIPMENT.register("deadly_precision_chestplate", () -> new DeadlyPrecisionArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SUBJUGATED_HORROR_CHESTPLATE= EQUIPMENT.register("subjugated_horror_chestplate", () -> new SubjugatedHorrorArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DRACONIC_RAINBOW_CHESTPLATE = EQUIPMENT.register("draconic_rainbow_chestplate", () -> new DraconicRainbowArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ZERO_POINT_CHESTPLATE = EQUIPMENT.register("zero_point_chestplate", () -> new ZeroPointArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SHADOW_WARD_CHESTPLATE = EQUIPMENT.register("shadow_ward_chestplate", () -> new ShadowWardArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> STELLAR_SINGULARITY_CHESTPLATE = EQUIPMENT.register("stellar_singularity_chestplate", () -> new StellarSingularityArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> LUNATIC_ASYLUM_CHESTPLATE = EQUIPMENT.register("lunatic_asylum_chestplate", () -> new LunaticAsylumArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> POSTMODERN_CLERIC_CHESTPLATE = EQUIPMENT.register("postmodern_cleric_chestplate", () -> new PostmodernClericArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CONDENSED_EMOTION_CHESTPLATE = EQUIPMENT.register("condensed_emotion_chestplate", () -> new CondensedEmotionArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COGNITIVE_BARRIER_CHESTPLATE = EQUIPMENT.register("cognitive_barrier_chestplate", () -> new CognitiveBarrierArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_GUARDIAN_CHESTPLATE = EQUIPMENT.register("demonic_guardian_chestplate", () -> new DemonicGuardianArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TEMPORAL_VALKYRIE_CHESTPLATE = EQUIPMENT.register("temporal_valkyrie_chestplate", () -> new TemporalValkyrieArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DARK_ENERGY_CHESTPLATE = EQUIPMENT.register("dark_energy_chestplate", () -> new DarkEnergyArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> LIVING_THUNDER_CHESTPLATE = EQUIPMENT.register("living_thunder_chestplate", () -> new LivingThunderArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> QUANTUM_FOAM_CHESTPLATE = EQUIPMENT.register("quantum_foam_chestplate", () -> new QuantumFoamArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
        // Leggings
    public static final RegistryObject<Item> HYPERDIAMOND_CRYSTAL_LEGGINGS = EQUIPMENT.register("hyperdiamond_crystal_crystal_leggings", () -> new HyperdiamondCrystalArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_COAGULANT_LEGGINGS = EQUIPMENT.register("crimson_coagulant_leggings", () -> new CrimsonCoagulantArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DEADLY_PRECISION_LEGGINGS = EQUIPMENT.register("deadly_precision_leggings", () -> new DeadlyPrecisionArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SUBJUGATED_HORROR_LEGGINGS = EQUIPMENT.register("subjugated_horror_leggings", () -> new SubjugatedHorrorArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DRACONIC_RAINBOW_LEGGINGS = EQUIPMENT.register("draconic_rainbow_leggings", () -> new DraconicRainbowArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ZERO_POINT_LEGGINGS = EQUIPMENT.register("zero_point_leggings", () -> new ZeroPointArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SHADOW_WARD_LEGGINGS = EQUIPMENT.register("shadow_ward_leggings", () -> new ShadowWardArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> STELLAR_SINGULARITY_LEGGINGS = EQUIPMENT.register("stellar_singularity_leggings", () -> new StellarSingularityArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> LUNATIC_ASYLUM_LEGGINGS = EQUIPMENT.register("lunatic_asylum_leggings", () -> new LunaticAsylumArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> POSTMODERN_CLERIC_LEGGINGS = EQUIPMENT.register("postmodern_cleric_leggings", () -> new PostmodernClericArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CONDENSED_EMOTION_LEGGINGS = EQUIPMENT.register("condensed_emotion_leggings", () -> new CondensedEmotionArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COGNITIVE_BARRIER_LEGGINGS = EQUIPMENT.register("cognitive_barrier_leggings", () -> new CognitiveBarrierArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_GUARDIAN_LEGGINGS = EQUIPMENT.register("demonic_guardian_leggings", () -> new DemonicGuardianArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TEMPORAL_VALKYRIE_LEGGINGS = EQUIPMENT.register("temporal_valkyrie_leggings", () -> new TemporalValkyrieArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DARK_ENERGY_LEGGINGS = EQUIPMENT.register("dark_energy_leggings", () -> new DarkEnergyArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> LIVING_THUNDER_LEGGINGS = EQUIPMENT.register("living_thunder_leggings", () -> new LivingThunderArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> QUANTUM_FOAM_LEGGINGS = EQUIPMENT.register("quantum_foam_leggings", () -> new QuantumFoamArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
        // Boots
    public static final RegistryObject<Item> HYPERDIAMOND_CRYSTAL_BOOTS = EQUIPMENT.register("hyperdiamond_crystal_crystal_boots", () -> new HyperdiamondCrystalArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_COAGULANT_BOOTS = EQUIPMENT.register("crimson_coagulant_boots", () -> new CrimsonCoagulantArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DEADLY_PRECISION_BOOTS = EQUIPMENT.register("deadly_precision_boots", () -> new DeadlyPrecisionArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> SUBJUGATED_HORROR_BOOTS = EQUIPMENT.register("subjugated_horror_boots", () -> new SubjugatedHorrorArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DRACONIC_RAINBOW_BOOTS = EQUIPMENT.register("draconic_rainbow_boots", () -> new DraconicRainbowArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> ZERO_POINT_BOOTS = EQUIPMENT.register("zero_point_boots", () -> new ZeroPointArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> SHADOW_WARD_BOOTS = EQUIPMENT.register("shadow_ward_boots", () -> new ShadowWardArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> STELLAR_SINGULARITY_BOOTS = EQUIPMENT.register("stellar_singularity_boots", () -> new StellarSingularityArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> LUNATIC_ASYLUM_BOOTS = EQUIPMENT.register("lunatic_asylum_boots", () -> new LunaticAsylumArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> POSTMODERN_CLERIC_BOOTS = EQUIPMENT.register("postmodern_cleric_boots", () -> new PostmodernClericArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> CONDENSED_EMOTION_BOOTS = EQUIPMENT.register("condensed_emotion_boots", () -> new CondensedEmotionArmorItem( CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> COGNITIVE_BARRIER_BOOTS = EQUIPMENT.register("cognitive_barrier_boots", () -> new CognitiveBarrierArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_GUARDIAN_BOOTS = EQUIPMENT.register("demonic_guardian_boots", () -> new DemonicGuardianArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> TEMPORAL_VALKYRIE_BOOTS = EQUIPMENT.register("temporal_valkyrie_boots", () -> new TemporalValkyrieArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> DARK_ENERGY_BOOTS = EQUIPMENT.register("dark_energy_boots", () -> new DarkEnergyArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> LIVING_THUNDER_BOOTS = EQUIPMENT.register("living_thunder_boots", () -> new LivingThunderArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> QUANTUM_FOAM_BOOTS = EQUIPMENT.register("quantum_foam_boots", () -> new QuantumFoamArmorItem(CCArmorMaterial.ARMOR_SUPERMATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Gadgets
    public static final RegistryObject<Item> QUANTUM_SIGIL = ITEMS.register("quantum_sigil", () -> new Item(new Item.Properties())); // Used to summon the Demon Lord boss
    public static final RegistryObject<Item> RIFT_TOKEN = ITEMS.register("rift_token", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STABLE_RIFT_TOKEN = ITEMS.register("stable_rift_token", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_KEY = ITEMS.register("crystal_key", () -> new Item(new Item.Properties()));

    // Crafting ingredients
    public static final RegistryObject<Item> VOID_FABRIC = ITEMS.register("void_fabric", () -> new Item(new Item.Properties())); // Crafted from nine Abyss String

    // Mob drops
    public static final RegistryObject<Item> ABYSS_STRING = ITEMS.register("abyss_string", () -> new Item(new Item.Properties())); // Dropped from Riftwalkers (all types)
    public static final RegistryObject<Item> TIME_CRYSTAL = ITEMS.register("time_crystal", () -> new Item(new Item.Properties())); // Drops from Demon Lord, Superbosses, and Riftwalkers
    public static final RegistryObject<Item> WORLD_THREAD = ITEMS.register("world_thread", () -> new Item(new Item.Properties())); // Drops from powerful Riftwalkers and the Worldeater
    public static final RegistryObject<Item> REALM_SEED = ITEMS.register("realm_seed", () -> new Item(new Item.Properties())); // Crafted with Void Fabric, Time Crystals, and a World Thread

    // Boss Drops
        // Tsuna
    public static final RegistryObject<Item> HYPERDIAMOND = ITEMS.register("hyperdiamond", () -> new Item(new Item.Properties()));
        // Kai
    public static final RegistryObject<Item> VAMPIRE_BLOOD = ITEMS.register("vampire_blood", () -> new Item(new Item.Properties()));
        // Terry drop
    public static final RegistryObject<Item> WYVERN_CLAW = ITEMS.register("wyvern_claw", () -> new Item(new Item.Properties()));
        // Lyadova drop

        // Aella drop
    public static final RegistryObject<Item> LUMINOUS_DRAGON_SCALE = ITEMS.register("luminous_dragon_scale", () -> new Item(new Item.Properties()));
        // Jack Drop

        // Xanthea drop
    public static final RegistryObject<Item> GIALISKIAS = ITEMS.register("gialiskias", () -> new Item(new Item.Properties()));
        // Will drop

        // Matthue drop

        // Alline drop

        // Madeline drop

        // Emily drop

        // Adrian drop

        // Andrea drop

        // Rex drop

        // Jolt drop

        // FP Jolt drop


    // Smithing Templates
    public static final RegistryObject<Item> THUNDERSTEEL_UPGRADE = ITEMS.register("thundersteel_upgrade_smithing_template", () -> new Item(new Item.Properties()));
    // Add more smithing templates as treasures

    // Registration
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        EQUIPMENT.register(eventBus);
    }

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