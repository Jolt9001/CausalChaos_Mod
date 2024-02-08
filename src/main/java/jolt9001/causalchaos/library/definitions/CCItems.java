package jolt9001.causalchaos.library.definitions;

import jolt9001.causalchaos.library.gui.CreativeTabs;
import jolt9001.causalchaos.library.ids.CCItemIds;
import jolt9001.causalchaos.library.item.*;
import jolt9001.causalchaos.library.item.material.*;
import jolt9001.causalchaos.library.item.armor.*;
import jolt9001.causalchaos.library.item.tool.*;
import jolt9001.causalchaos.util.CausalChaosItemTier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public final class CCItems {

    private static final List<ItemDefinition<?>> ITEMS = new ArrayList<>();

    // Causal Journal
    public static final ItemDefinition<JournalItem> JOURNAL = item("Causal Journal", CCItemIds.JOURNAL, p -> new JournalItem(p.stacksTo(1)), CreativeModeTabs.TOOLS_AND_UTILITIES);

    // Quest (I.E. the Causality Crystal)
    public static final ItemDefinition<CausalityCrystalItem> CAUSALITY_CRYSTAL = item("Causality Crystal", CCItemIds.CAUSALITY_CRYSTAL, p -> new CausalityCrystalItem(p.stacksTo(1)), CreativeModeTabs.TOOLS_AND_UTILITIES);

    // Crafting Ingredients and Materials (ingots, nuggets, raw ores, etc.)
    public static final ItemDefinition<Item> COBALT_INGOT = item("Cobalt Ingot", CCItemIds.COBALT_INGOT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> IRIDIUM_INGOT = item("Iridium Ingot", CCItemIds.IRIDIUM_INGOT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> NEODYMIUM_INGOT = item("Neodymium Ingot", CCItemIds.NEODYMIUM_INGOT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> PALLADIUM_INGOT = item("Palladium Ingot", CCItemIds.PALLADIUM_INGOT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> PERPLEXIUM_INGOT = item("Perplexium Ingot", CCItemIds.PERPLEXIUM_INGOT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> THUNDERSTEEL_INGOT = item("Thundersteel Ingot", CCItemIds.THUNDERSTEEL_INGOT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> TITANIUM_INGOT = item("Titanium Ingot", CCItemIds.TITANIUM_INGOT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> TUNGSTEN_INGOT = item("Tungsten Ingot", CCItemIds.TUNGSTEN_INGOT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);

    public static final ItemDefinition<Item> COBALT_NUGGET = item("Cobalt Nugget", CCItemIds.COBALT_NUGGET, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> IRIDIUM_NUGGET = item("Iridium Nugget", CCItemIds.IRIDIUM_NUGGET, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> NEODYMIUM_NUGGET = item("Neodymium Nugget", CCItemIds.NEODYMIUM_NUGGET, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> PALLADIUM_NUGGET = item("Palladium Nugget", CCItemIds.PALLADIUM_NUGGET, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> PERPLEXIUM_NUGGET = item("Perplexium Nugget", CCItemIds.PERPLEXIUM_NUGGET, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> THUNDERSTEEL_NUGGET = item("Thundersteel Nugget", CCItemIds.THUNDERSTEEL_NUGGET, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> TITANIUM_NUGGET = item("Titanium Nugget", CCItemIds.TITANIUM_NUGGET, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> TUNGSTEN_NUGGET = item("Tungsten Nugget", CCItemIds.TUNGSTEN_NUGGET, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);

    public static final ItemDefinition<Item> RAW_COBALT = item("Raw Cobalt", CCItemIds.RAW_COBALT, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_IRIDIUM = item("Raw Iridium", CCItemIds.RAW_IRIDIUM, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_NEODYMIUM = item("Raw Neodymium", CCItemIds.RAW_NEODYMIUM, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_PALLADIUM = item("Raw Palladium", CCItemIds.RAW_PALLADIUM, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_TITANIUM = item("Raw Titanium", CCItemIds.RAW_TITANIUM, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);
    public static final ItemDefinition<Item> RAW_TUNGSTEN = item("Raw Tungsten", CCItemIds.RAW_TUNGSTEN, p -> new Item(new Item.Properties()), CreativeModeTabs.INGREDIENTS);

    // Tools
        // Axes
    public static final ItemDefinition<Item> COBALT_AXE = item("Cobalt Axe", CCItemIds.COBALT_AXE, p -> new AxeItem(CausalChaosItemTier.COBALT, 6.0F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> INFUSED_THUNDERSTEEL_AXE = item("Infused Thundersteel Axe", CCItemIds.INFUSED_THUNDERSTEEL_AXE, p -> new AxeItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 6.0F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> IRIDIUM_AXE = item("Iridium Axe", CCItemIds.IRIDIUM_AXE, p -> new AxeItem(CausalChaosItemTier.IRIDIUM, 6.0F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> NEODYMIUM_AXE = item("Neodymium Axe", CCItemIds.NEODYMIUM_AXE, p -> new AxeItem(CausalChaosItemTier.NEODYMIUM, 6.0F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> PALLADIUM_AXE = item("Palladium Axe", CCItemIds.PALLADIUM_AXE, p -> new AxeItem(CausalChaosItemTier.PALLADIUM, 6.0F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> PERPLEXIUM_AXE = item("Perplexium Axe", CCItemIds.PERPLEXIUM_AXE, p -> new AxeItem(CausalChaosItemTier.PERPLEXIUM, 6.0F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> THUNDERSTEEL_AXE = item("Thundersteel Axe", CCItemIds.THUNDERSTEEL_AXE, p -> new AxeItem(CausalChaosItemTier.THUNDERSTEEL, 6.0F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> TITANIUM_AXE = item("Titanium Axe", CCItemIds.TITANIUM_AXE, p -> new AxeItem(CausalChaosItemTier.TITANIUM, 6.0F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> TUNGSTEN_AXE = item("Tungsten Axe", CCItemIds.TUNGSTEN_AXE, p -> new AxeItem(CausalChaosItemTier.TUNGSTEN, 6.0F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);

        // Hoes
    public static final ItemDefinition<Item> COBALT_HOE = item("Cobalt Axe", CCItemIds.COBALT_HOE, p -> new AxeItem(CausalChaosItemTier.COBALT, 3, -0.5F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> INFUSED_THUNDERSTEEL_HOE = item("Infused Thundersteel Axe", CCItemIds.INFUSED_THUNDERSTEEL_HOE, p -> new AxeItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 3, -0.5F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> IRIDIUM_HOE = item("Iridium Axe", CCItemIds.IRIDIUM_HOE, p -> new AxeItem(CausalChaosItemTier.IRIDIUM, 3, -0.5F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> NEODYMIUM_HOE = item("Neodymium Axe", CCItemIds.NEODYMIUM_HOE, p -> new AxeItem(CausalChaosItemTier.NEODYMIUM, 3, -0.5F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> PALLADIUM_HOE = item("Palladium Axe", CCItemIds.PALLADIUM_HOE, p -> new AxeItem(CausalChaosItemTier.PALLADIUM, 3, -0.5F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> PERPLEXIUM_HOE = item("Perplexium Axe", CCItemIds.PERPLEXIUM_HOE, p -> new AxeItem(CausalChaosItemTier.PERPLEXIUM, 3, -0.5F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> THUNDERSTEEL_HOE = item("Thundersteel Axe", CCItemIds.THUNDERSTEEL_HOE, p -> new AxeItem(CausalChaosItemTier.THUNDERSTEEL, 3F, -0.5F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> TITANIUM_HOE = item("Titanium Axe", CCItemIds.TITANIUM_HOE, p -> new AxeItem(CausalChaosItemTier.TITANIUM, 3, -0.5F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> TUNGSTEN_HOE = item("Tungsten Axe", CCItemIds.TUNGSTEN_HOE, p -> new AxeItem(CausalChaosItemTier.TUNGSTEN, 3, -0.5F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
        // Pickaxes
    public static final ItemDefinition<Item> COBALT_PICKAXE = item("Cobalt Pickaxe", CCItemIds.COBALT_PICKAXE, p -> new PickaxeItem(CausalChaosItemTier.COBALT, 1, -2.8F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> INFUSED_THUNDERSTEEL_PICKAXE = item("Infused Thundersteel Pickaxe", CCItemIds.INFUSED_THUNDERSTEEL_PICKAXE, p -> new PickaxeItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 1, -2.8F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> IRIDIUM_PICKAXE = item("Iridium Pickaxe", CCItemIds.IRIDIUM_PICKAXE, p -> new PickaxeItem(CausalChaosItemTier.IRIDIUM, 1, -2.8F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> NEODYMIUM_PICKAXE = item("Neodymium Pickaxe", CCItemIds.NEODYMIUM_PICKAXE, p -> new PickaxeItem(CausalChaosItemTier.NEODYMIUM, 1, -2.8F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> PALLADIUM_PICKAXE = item("Palladium Pickaxe", CCItemIds.PALLADIUM_PICKAXE, p -> new PickaxeItem(CausalChaosItemTier.PALLADIUM, 1, -2.8F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> PERPLEXIUM_PICKAXE = item("Perplexium Pickaxe", CCItemIds.PERPLEXIUM_PICKAXE, p -> new PickaxeItem(CausalChaosItemTier.PERPLEXIUM, 1, -2.8F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> THUNDERSTEEL_PICKAXE = item("Thundersteel Pickaxe", CCItemIds.THUNDERSTEEL_PICKAXE, p -> new PickaxeItem(CausalChaosItemTier.THUNDERSTEEL, 1, -2.8F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> TITANIUM_PICKAXE = item("Titanium Pickaxe", CCItemIds.TITANIUM_PICKAXE, p -> new PickaxeItem(CausalChaosItemTier.TITANIUM, 1, -2.8F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> TUNGSTEN_PICKAXE = item("Tungsten Pickaxe", CCItemIds.TUNGSTEN_PICKAXE, p -> new PickaxeItem(CausalChaosItemTier.TUNGSTEN, 1, -2.8F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);

        // Shovels
    public static final ItemDefinition<Item> COBALT_SHOVEL = item("Cobalt Shovel", CCItemIds.COBALT_SHOVEL, p -> new ShovelItem(CausalChaosItemTier.COBALT, 1.5F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> INFUSED_THUNDERSTEEL_SHOVEL = item("Infused Thundersteel Shovel", CCItemIds.INFUSED_THUNDERSTEEL_SHOVEL, p -> new ShovelItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 1.5F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> IRIDIUM_SHOVEL = item("Iridium Shovel", CCItemIds.IRIDIUM_SHOVEL, p -> new ShovelItem(CausalChaosItemTier.IRIDIUM, 1.5F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> NEODYMIUM_SHOVEL = item("Neodymium Shovel", CCItemIds.NEODYMIUM_SHOVEL, p -> new ShovelItem(CausalChaosItemTier.NEODYMIUM, 1.5F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> PALLADIUM_SHOVEL = item("Palladium Shovel", CCItemIds.PALLADIUM_SHOVEL, p -> new ShovelItem(CausalChaosItemTier.PALLADIUM, 1.5F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> PERPLEXIUM_SHOVEL = item("Perplexium Shovel", CCItemIds.PERPLEXIUM_SHOVEL, p -> new ShovelItem(CausalChaosItemTier.PERPLEXIUM, 1.5F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> THUNDERSTEEL_SHOVEL = item("Thundersteel Shovel", CCItemIds.THUNDERSTEEL_SHOVEL, p -> new ShovelItem(CausalChaosItemTier.THUNDERSTEEL, 1.5F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> TITANIUM_SHOVEL = item("Titanium Shovel", CCItemIds.TITANIUM_SHOVEL, p -> new ShovelItem(CausalChaosItemTier.TITANIUM, 1.5F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);
    public static final ItemDefinition<Item> TUNGSTEN_SHOVEL = item("Tungsten Shovel", CCItemIds.TUNGSTEN_SHOVEL, p -> new ShovelItem(CausalChaosItemTier.TUNGSTEN, 1.5F, -3.0F, new Item.Properties()), CreativeModeTabs.TOOLS_AND_UTILITIES);

    // Weapons
        // Material Melee
    public static final ItemDefinition<Item> COBALT_SWORD = item("Cobalt Sword", CCItemIds.COBALT_SWORD, p -> new SwordItem(CausalChaosItemTier.COBALT, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final ItemDefinition<Item> INFUSED_THUNDERSTEEL_SWORD = item("Infused Thundersteel Sword", CCItemIds.INFUSED_THUNDERSTEEL_SWORD, p -> new SwordItem(CausalChaosItemTier.INFUSED_THUNDERSTEEL, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final ItemDefinition<Item> IRIDIUM_SWORD = item("Iridium Sword", CCItemIds.IRIDIUM_SWORD, p -> new SwordItem(CausalChaosItemTier.IRIDIUM, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final ItemDefinition<Item> NEODYMIUM_SWORD = item("Neodymium Sword", CCItemIds.NEODYMIUM_SWORD, p -> new SwordItem(CausalChaosItemTier.NEODYMIUM, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final ItemDefinition<Item> PALLADIUM_SWORD = item("Palladium Sword", CCItemIds.PALLADIUM_SWORD, p -> new SwordItem(CausalChaosItemTier.PALLADIUM, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final ItemDefinition<Item> PERPLEXIUM_SWORD = item("Perplexium Sword", CCItemIds.PERPLEXIUM_SWORD, p -> new SwordItem(CausalChaosItemTier.PERPLEXIUM, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final ItemDefinition<Item> THUNDERSTEEL_SWORD = item("Thundersteel Sword", CCItemIds.THUNDERSTEEL_SWORD, p -> new SwordItem(CausalChaosItemTier.THUNDERSTEEL, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final ItemDefinition<Item> TITANIUM_SWORD = item("Titanium Sword", CCItemIds.TITANIUM_SWORD, p -> new SwordItem(CausalChaosItemTier.TITANIUM, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);
    public static final ItemDefinition<Item> TUNGSTEN_SWORD = item("Tungsten Sword", CCItemIds.TUNGSTEN_SWORD, p -> new SwordItem(CausalChaosItemTier.TUNGSTEN, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);

        // Super Melee
    public static final ItemDefinition<Item> WHITE_THUNDER = item("White Thunder", CCItemIds.WHITE_THUNDER, p -> new SwordItem(CausalChaosItemTier.SUPERWEAPON, 3, -2.4F, new Item.Properties()), CreativeModeTabs.COMBAT);

    // Armor

    // Items done, now to put them in a list.
    public static List<ItemDefinition<?>> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    private static <T extends Item> ItemDefinition<T> item(String name, ResourceLocation id, Function<Item.Properties, T> factory, ResourceKey<CreativeModeTab> group) {
        Item.Properties p = new Item.Properties();
        T item = factory.apply(p);
        ItemDefinition<T> definition = new ItemDefinition<>(name, id, item);
/*
        if (group.equals(CreativeTabs.ITEMS)) {

        }
*/
        ITEMS.add(definition);

        return definition;
    }
}