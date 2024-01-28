package jolt9001.causalchaos.library.definitions;

import jolt9001.causalchaos.library.definitions.gui.CreativeTabs;
import jolt9001.causalchaos.library.ids.CCItemIds;
import jolt9001.causalchaos.library.item.CausalityCrystalItem;
import jolt9001.causalchaos.library.item.JournalItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

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

    // Crafting Ingredients

    // Tools

    // Weapons

    // Armor

    // Items done, now to put them in a list.
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
}