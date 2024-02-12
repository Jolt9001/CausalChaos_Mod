package jolt9001.causalchaos.library.definitions;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.ids.CCItemIds;
import jolt9001.causalchaos.library.item.*;
import jolt9001.causalchaos.library.item.enums.CCArmorMaterial;
import jolt9001.causalchaos.library.item.armor.material.*;
import jolt9001.causalchaos.util.CausalChaosItemTier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public final class CCItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CausalChaos.MODID);

    // Causal Journal
    public static final RegistryObject<JournalItem> JOURNAL = ITEMS.register("causal_journal", () -> new JournalItem(new Item.Properties()));

    // Quest (I.E. the Causality Crystal)
    public static final RegistryObject<CausalityCrystalItem> CAUSALITY_CRYSTAL = ITEMS.register("causal_journal", () -> new CausalityCrystalItem(new Item.Properties()));

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
/*
    public static final ItemDefinition<Item> RAW_COBALT = item("Raw Cobalt", CCItemIds.RAW_COBALT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_IRIDIUM = item("Raw Iridium", CCItemIds.RAW_IRIDIUM, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_NEODYMIUM = item("Raw Neodymium", CCItemIds.RAW_NEODYMIUM, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_PALLADIUM = item("Raw Palladium", CCItemIds.RAW_PALLADIUM, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_TITANIUM = item("Raw Titanium", CCItemIds.RAW_TITANIUM, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_TUNGSTEN = item("Raw Tungsten", CCItemIds.RAW_TUNGSTEN, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> ANTHRACITE = item("Anthracite", CCItemIds.ANTHRACITE, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
 */
    public static final RegistryObject<Item> RAW_COBALT =  ITEMS.register("raw_cobalt", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_IRIDIUM = ITEMS.register("raw_iridium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NEODYMIUM = ITEMS.register("raw_neodymium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_PALLADIUM = ITEMS.register("raw_palladium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANTHRACITE = ITEMS.register("anthracite", () -> new Item(new Item.Properties()));

    // Tools
        // Axes
    public static final RegistryObject<Item> COBALT_AXE = ITEMS.register("cobalt_axe", () -> new AxeItem(CausalChaosItemTier.COBALT, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_AXE = ITEMS.register("infused_thundersteel_axe", () -> new AxeItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_AXE = ITEMS.register("iridium_axe", () -> new AxeItem(CausalChaosItemTier.IRIDIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_AXE = ITEMS.register("neodymium_axe", () -> new AxeItem(CausalChaosItemTier.NEODYMIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_AXE = ITEMS.register("palladium_axe", () -> new AxeItem(CausalChaosItemTier.PALLADIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_AXE = ITEMS.register("perplexium_axe", () -> new AxeItem(CausalChaosItemTier.PERPLEXIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_AXE = ITEMS.register("thundersteel_axe", () -> new AxeItem(CausalChaosItemTier.THUNDERSTEEL, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", () -> new AxeItem(CausalChaosItemTier.TITANIUM, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe", () -> new AxeItem(CausalChaosItemTier.TUNGSTEN, 6.0F, -3.0F, new Item.Properties()));

        // Hoes
    public static final RegistryObject<Item> COBALT_HOE = ITEMS.register("cobalt_hoe", () -> new HoeItem(CausalChaosItemTier.COBALT, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_HOE = ITEMS.register("infused_thundersteel_hoe", () -> new HoeItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_HOE = ITEMS.register("iridium_hoe", () -> new HoeItem(CausalChaosItemTier.IRIDIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_HOE = ITEMS.register("neodymium_hoe", () -> new HoeItem(CausalChaosItemTier.NEODYMIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_HOE = ITEMS.register("palladium_hoe", () -> new HoeItem(CausalChaosItemTier.PALLADIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_HOE = ITEMS.register("perplexium_hoe", () -> new HoeItem(CausalChaosItemTier.PERPLEXIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_HOE = ITEMS.register("thundersteel_hoe", () -> new HoeItem(CausalChaosItemTier.THUNDERSTEEL, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", () -> new HoeItem(CausalChaosItemTier.TITANIUM, 3, -0.5F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe", () -> new HoeItem(CausalChaosItemTier.TUNGSTEN, 3, -0.5F, new Item.Properties()));

    // Pickaxes
    public static final RegistryObject<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe", () -> new PickaxeItem(CausalChaosItemTier.COBALT, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_PICKAXE = ITEMS.register("infused_thundersteel_pickaxe", () -> new PickaxeItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_PICKAXE = ITEMS.register("iridium_pickaxe", () -> new PickaxeItem(CausalChaosItemTier.IRIDIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_PICKAXE = ITEMS.register("neodymium_pickaxe", () -> new PickaxeItem(CausalChaosItemTier.NEODYMIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_PICKAXE = ITEMS.register("palladium_pickaxe", () -> new PickaxeItem(CausalChaosItemTier.PALLADIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_PICKAXE = ITEMS.register("perplexium_pickaxe", () -> new PickaxeItem(CausalChaosItemTier.PERPLEXIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_PICKAXE = ITEMS.register("thundersteel_pickaxe", () -> new PickaxeItem(CausalChaosItemTier.THUNDERSTEEL, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", () -> new PickaxeItem(CausalChaosItemTier.TITANIUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe", () -> new PickaxeItem(CausalChaosItemTier.TUNGSTEN, 1, -2.8F, new Item.Properties()));

        // Shovels
    public static final RegistryObject<Item> COBALT_SHOVEL = ITEMS.register("cobalt_shovel", () -> new ShovelItem(CausalChaosItemTier.COBALT, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_SHOVEL = ITEMS.register("infused_thundersteel_shovel", () -> new ShovelItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_SHOVEL = ITEMS.register("iridium_shovel", () -> new ShovelItem(CausalChaosItemTier.IRIDIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_SHOVEL = ITEMS.register("neodymium_shovel", () -> new ShovelItem(CausalChaosItemTier.NEODYMIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_SHOVEL = ITEMS.register("palladium_shovel", () -> new ShovelItem(CausalChaosItemTier.PALLADIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_SHOVEL = ITEMS.register("perplexium_shovel", () -> new ShovelItem(CausalChaosItemTier.PERPLEXIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_SHOVEL = ITEMS.register("thundersteel_shovel", () -> new ShovelItem(CausalChaosItemTier.THUNDERSTEEL, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", () -> new ShovelItem(CausalChaosItemTier.TITANIUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_hoe", () -> new ShovelItem(CausalChaosItemTier.TUNGSTEN, 1.5F, -3.0F, new Item.Properties()));

    // Weapons
        // Material Melee
    public static final RegistryObject<Item> COBALT_SWORD = ITEMS.register("cobalt_sword", () -> new SwordItem(CausalChaosItemTier.COBALT, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> INFUSED_THUNDERSTEEL_SWORD = ITEMS.register("infused_thundersteel_sword", () -> new SwordItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> IRIDIUM_SWORD = ITEMS.register("iridium_sword", () -> new SwordItem(CausalChaosItemTier.IRIDIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> NEODYMIUM_SWORD = ITEMS.register("neodymium_sword", () -> new SwordItem(CausalChaosItemTier.NEODYMIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> PALLADIUM_SWORD = ITEMS.register("palladium_sword", () -> new SwordItem(CausalChaosItemTier.PALLADIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> PERPLEXIUM_SWORD = ITEMS.register("perplexium_sword", () -> new SwordItem(CausalChaosItemTier.PERPLEXIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> THUNDERSTEEL_SWORD = ITEMS.register("thundersteel_sword", () -> new SwordItem(CausalChaosItemTier.THUNDERSTEEL, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", () -> new SwordItem(CausalChaosItemTier.TITANIUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword", () -> new SwordItem(CausalChaosItemTier.TUNGSTEN, 3, -2.4F, new Item.Properties()));

        // Super Melee
    public static final RegistryObject<Item> WHITE_THUNDER = ITEMS.register("white_thunder", () -> new SwordItem(CausalChaosItemTier.SUPERWEAPON, 3, -2.4F, new Item.Properties()));

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

    // Gadgets
    public static final RegistryObject<Item> QUANTUM_SIGIL = ITEMS.register("quantum_sigil", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RIFT_TOKEN = ITEMS.register("rift_token", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STABLE_RIFT_TOKEN = ITEMS.register("stable_rift_token", () -> new Item(new Item.Properties()));

    // Crafting ingredients
    public static final RegistryObject<Item> ABYSSAL_THREAD = ITEMS.register("abyssal_thread", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIME_CRYSTAL = ITEMS.register("time_crystal", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VOID_FABRIC = ITEMS.register("void_fabric", () -> new Item(new Item.Properties()));



    /*
    public static List<ItemDefinition<?>> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    private static <T extends Item> ItemDefinition<T> item(String name, ResourceLocation id, Function<Item.Properties, T> factory, ResourceKey<CreativeModeTab> group) {
        Item.Properties p = new Item.Properties();
        T item = factory.apply(p);
        ItemDefinition<T> definition = new ItemDefinition<>(name, id, item);
        if (group.equals(CreativeTabs.ITEMS)) {

        }

        ITEMS.add(definition);

        return definition;
    }

     */

}