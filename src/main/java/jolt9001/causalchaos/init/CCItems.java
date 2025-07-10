package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.definitions.ItemDefinition;
import jolt9001.causalchaos.library.item.CausalityCrystalItem;
import jolt9001.causalchaos.library.item.JournalItem;
import jolt9001.causalchaos.library.item.enums.CCArmorMaterial;
import jolt9001.causalchaos.library.item.armor.material.*;
import jolt9001.causalchaos.util.CausalChaosItemMaterial;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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
    public static final RegistryObject<Item> COBALT_AXE = ITEMS.register("cobalt_axe", () -> new AxeItem(CausalChaosItemMaterial.COBALT, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_AXE = ITEMS.register("infused_thundersteel_axe", () -> new AxeItem(CausalChaosItemMaterial.INFUSED_THUNDERSTEEL, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_AXE = ITEMS.register("iridium_axe", () -> new AxeItem(CausalChaosItemMaterial.IRIDIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_AXE = ITEMS.register("neodymium_axe", () -> new AxeItem(CausalChaosItemMaterial.NEODYMIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_AXE = ITEMS.register("palladium_axe", () -> new AxeItem(CausalChaosItemMaterial.PALLADIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_AXE = ITEMS.register("perplexium_axe", () -> new AxeItem(CausalChaosItemMaterial.PERPLEXIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_AXE = ITEMS.register("thundersteel_axe", () -> new AxeItem(CausalChaosItemMaterial.THUNDERSTEEL, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new AxeItem(CausalChaosItemMaterial.TITANIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe", () -> new AxeItem(CausalChaosItemMaterial.TUNGSTEN, 6.0F, -3.0F, new Item.Properties()));

        // Hoes
    public static final RegistryObject<Item> COBALT_HOE = ITEMS.register("cobalt_hoe", () -> new HoeItem(CausalChaosItemMaterial.COBALT, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_HOE = ITEMS.register("infused_thundersteel_hoe", () -> new HoeItem(CausalChaosItemMaterial.INFUSED_THUNDERSTEEL, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_HOE = ITEMS.register("iridium_hoe", () -> new HoeItem(CausalChaosItemMaterial.IRIDIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_HOE = ITEMS.register("neodymium_hoe", () -> new HoeItem(CausalChaosItemMaterial.NEODYMIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_HOE = ITEMS.register("palladium_hoe", () -> new HoeItem(CausalChaosItemMaterial.PALLADIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_HOE = ITEMS.register("perplexium_hoe", () -> new HoeItem(CausalChaosItemMaterial.PERPLEXIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_HOE = ITEMS.register("thundersteel_hoe", () -> new HoeItem(CausalChaosItemMaterial.THUNDERSTEEL, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new HoeItem(CausalChaosItemMaterial.TITANIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe", () -> new HoeItem(CausalChaosItemMaterial.TUNGSTEN, 3, -0.5F, new Item.Properties()));

    // Pickaxes
    public static final RegistryObject<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe", () -> new PickaxeItem(CausalChaosItemMaterial.COBALT, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_PICKAXE = ITEMS.register("infused_thundersteel_pickaxe", () -> new PickaxeItem(CausalChaosItemMaterial.INFUSED_THUNDERSTEEL, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_PICKAXE = ITEMS.register("iridium_pickaxe", () -> new PickaxeItem(CausalChaosItemMaterial.IRIDIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_PICKAXE = ITEMS.register("neodymium_pickaxe", () -> new PickaxeItem(CausalChaosItemMaterial.NEODYMIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_PICKAXE = ITEMS.register("palladium_pickaxe", () -> new PickaxeItem(CausalChaosItemMaterial.PALLADIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_PICKAXE = ITEMS.register("perplexium_pickaxe", () -> new PickaxeItem(CausalChaosItemMaterial.PERPLEXIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_PICKAXE = ITEMS.register("thundersteel_pickaxe", () -> new PickaxeItem(CausalChaosItemMaterial.THUNDERSTEEL, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new PickaxeItem(CausalChaosItemMaterial.TITANIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe", () -> new PickaxeItem(CausalChaosItemMaterial.TUNGSTEN, 1, -2.8F, new Item.Properties()));

        // Shovels
    public static final RegistryObject<Item> COBALT_SHOVEL = ITEMS.register("cobalt_shovel", () -> new ShovelItem(CausalChaosItemMaterial.COBALT, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_SHOVEL = ITEMS.register("infused_thundersteel_shovel", () -> new ShovelItem(CausalChaosItemMaterial.INFUSED_THUNDERSTEEL, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_SHOVEL = ITEMS.register("iridium_shovel", () -> new ShovelItem(CausalChaosItemMaterial.IRIDIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_SHOVEL = ITEMS.register("neodymium_shovel", () -> new ShovelItem(CausalChaosItemMaterial.NEODYMIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_SHOVEL = ITEMS.register("palladium_shovel", () -> new ShovelItem(CausalChaosItemMaterial.PALLADIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_SHOVEL = ITEMS.register("perplexium_shovel", () -> new ShovelItem(CausalChaosItemMaterial.PERPLEXIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_SHOVEL = ITEMS.register("thundersteel_shovel", () -> new ShovelItem(CausalChaosItemMaterial.THUNDERSTEEL, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new ShovelItem(CausalChaosItemMaterial.TITANIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_hoe", () -> new ShovelItem(CausalChaosItemMaterial.TUNGSTEN, 1.5F, -3.0F, new Item.Properties()));

    // Weapons
        // Material Melee
    public static final RegistryObject<Item> COBALT_SWORD = ITEMS.register("cobalt_sword", () -> new SwordItem(CausalChaosItemMaterial.COBALT, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_SWORD = ITEMS.register("infused_thundersteel_sword", () -> new SwordItem(CausalChaosItemMaterial.INFUSED_THUNDERSTEEL, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_SWORD = ITEMS.register("iridium_sword", () -> new SwordItem(CausalChaosItemMaterial.IRIDIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_SWORD = ITEMS.register("neodymium_sword", () -> new SwordItem(CausalChaosItemMaterial.NEODYMIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_SWORD = ITEMS.register("palladium_sword", () -> new SwordItem(CausalChaosItemMaterial.PALLADIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_SWORD = ITEMS.register("perplexium_sword", () -> new SwordItem(CausalChaosItemMaterial.PERPLEXIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_SWORD = ITEMS.register("thundersteel_sword", () -> new SwordItem(CausalChaosItemMaterial.THUNDERSTEEL, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () -> new SwordItem(CausalChaosItemMaterial.TITANIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword", () -> new SwordItem(CausalChaosItemMaterial.TUNGSTEN, 3, -2.4F, new Item.Properties()));

        // Super Melee
    /*
    Pellucid Katana, drops from Tsuna
    Sanguine Shortsword, drops from Kai
    Infallible Bayonet, drops from Terry
    Gallant Shashka, drops from Lyadova
    Bespattered Warhammer, drops from Aella
    Oscillating Trident, drops from Jack
    Umbral Guisarme, drops from Xanthea
    Collapsar Claymore, drops from Will
    Hallucinogenic Bracers, drops from Matthue
    Caduceus Glaive, drops from Alline
    Instinctual Scythe, drops from Madeline
    Illusory Spear, drops from Emily
    Diablo Gauntlets, drops from Adrian
    Worldline Rapier, drops from Andrea
    Repulsor Saber, drops from Rex
    Electron Staff, drops from Jolt
    */
    public static final RegistryObject<Item> WHITE_THUNDER = ITEMS.register("white_thunder", () -> new SwordItem(CausalChaosItemMaterial.SUPERWEAPON, 3, -2.4F, new Item.Properties())); // Drops from FPJolt

        // Material Ranged

        // Super Ranged
    /*
    Diaphanous Shuriken, drops from Tsuna
    Guided Nanospears, drops from Kai
    Pinpoint Revolver, drops from Terry
    Nightmare Bow, drops from Lyadova
    Prismatic Grenades, drops from Aella
    Entropic Shortbow, drops from Jack
    Twilight Javelins, drops from Xanthea
    Relativistic Raygun, drops from Will
    Psychotic Longbow, drops from Matthue
    Vampiric Chakram, drops from Alline
    Ardent Tomahawks, drops from Madeline
    Phrenic Darts, drops from Emily
    Brimstone Flamethrower, drops from Adrian
    Snapshot Rifle, drops from Andrea
    Superradiant Daggers, drops from Rex
    Spark Launchers/Teravolt Cannon, drops from Jolt
    Oblivion Crossbow, drops from FPJolt
     */

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
    public static final RegistryObject<Item> ABYSSAL_THREAD = ITEMS.register("abyssal_thread", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIME_CRYSTAL = ITEMS.register("time_crystal", () -> new Item(new Item.Properties())); // Drops from Demon Lord and Riftwalkers
    public static final RegistryObject<Item> VOID_FABRIC = ITEMS.register("void_fabric", () -> new Item(new Item.Properties()));

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