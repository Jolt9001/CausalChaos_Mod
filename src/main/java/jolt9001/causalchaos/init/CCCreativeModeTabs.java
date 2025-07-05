package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CCCreativeModeTabs {
    public static final DeferredRegister CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CausalChaos.MODID);

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }


    static DeferredRegister<CreativeModeTab> TABS;

    public static final RegistryObject<CreativeModeTab> BLOCKS = TABS.register("blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + CausalChaos.MODID + ".blocks"))
            .icon(() -> new ItemStack(CCBlocks.COBALT_ORE.get()))
            .displayItems((params, output) -> {
                output.accept(CCBlocks.ANTHRACITE_ORE.get());
                output.accept(CCBlocks.ANTHRACITE_BLOCK.get());
                output.accept(CCBlocks.COBALT_ORE.get());
                output.accept(CCBlocks.DEEPSLATE_COBALT_ORE.get());
                output.accept(CCBlocks.RAW_COBALT_BLOCK.get());
                output.accept(CCBlocks.COBALT_BLOCK.get());
                output.accept(CCBlocks.IRIDIUM_ORE.get());
                output.accept(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get());
                output.accept(CCBlocks.RAW_IRIDIUM_BLOCK.get());
                output.accept(CCBlocks.IRIDIUM_BLOCK.get());
                output.accept(CCBlocks.NEODYMIUM_ORE.get());
                output.accept(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get());
                output.accept(CCBlocks.RAW_NEODYMIUM_BLOCK.get());
                output.accept(CCBlocks.NEODYMIUM_BLOCK.get());
                output.accept(CCBlocks.PALLADIUM_ORE.get());
                output.accept(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get());
                output.accept(CCBlocks.RAW_PALLADIUM_BLOCK.get());
                output.accept(CCBlocks.PALLADIUM_BLOCK.get());
                output.accept(CCBlocks.PERPLEXIUM_BLOCK.get());
                output.accept(CCBlocks.THUNDERSTEEL_BLOCK.get());
                output.accept(CCBlocks.TITANIUM_ORE.get());
                output.accept(CCBlocks.DEEPSLATE_TITANIUM_ORE.get());
                output.accept(CCBlocks.RAW_TITANIUM_BLOCK.get());
                output.accept(CCBlocks.TITANIUM_BLOCK.get());
                output.accept(CCBlocks.TUNGSTEN_ORE.get());
                output.accept(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
                output.accept(CCBlocks.RAW_TUNGSTEN_BLOCK.get());
                output.accept(CCBlocks.TUNGSTEN_BLOCK.get());
                output.accept(CCBlocks.REALMWEAVE_BLOCK.get());
                output.accept(CCBlocks.QUANTUM_FABRIC.get());
                output.accept(CCBlocks.DIMENSIONAL_ANCHOR.get());
                output.accept(CCBlocks.WORMHOLE_STABILIZER.get());
                output.accept(CCBlocks.FUSION_CORE.get());
                output.accept(CCBlocks.T0_STARFORGE.get());
                output.accept(CCBlocks.T1_STARFORGE.get());
                output.accept(CCBlocks.T2_STARFORGE.get());
                output.accept(CCBlocks.T3_STARFORGE.get());
                output.accept(CCBlocks.T1_HEAT_SINK.get());
                output.accept(CCBlocks.T2_HEAT_SINK.get());
                output.accept(CCBlocks.T3_HEAT_SINK.get());
                output.accept(CCBlocks.T1_ELECTROMAGNET.get());
                output.accept(CCBlocks.T2_ELECTROMAGNET.get());
                output.accept(CCBlocks.T3_ELECTROMAGNET.get());
                output.accept(CCBlocks.T1_ACCEPTOR.get());
                output.accept(CCBlocks.T2_ACCEPTOR.get());
                output.accept(CCBlocks.T3_ACCEPTOR.get());
                output.accept(CCBlocks.T1_CORE_SHIELDING.get());
                output.accept(CCBlocks.T2_CORE_SHIELDING.get());
                output.accept(CCBlocks.T3_CORE_SHIELDING.get());
            }).build());
    public static final RegistryObject<CreativeModeTab> ITEMS = TABS.register("items", () -> CreativeModeTab.builder()
            // Set name of tab to display
            .title(Component.translatable("item_group." + CausalChaos.MODID + ".items"))
            // Set icon of creative tab
            .icon(() -> new ItemStack(CCItems.CAUSALITY_CRYSTAL.get()))
            // Add default items to tab
            .displayItems((params, output) -> {
                output.accept(CCItems.JOURNAL.get());
                output.accept(CCItems.CAUSALITY_CRYSTAL.get());
                output.accept(CCItems.ANTHRACITE.get());
                output.accept(CCItems.RAW_COBALT.get());
                output.accept(CCItems.COBALT_NUGGET.get());
                output.accept(CCItems.COBALT_INGOT.get());
                output.accept(CCItems.RAW_IRIDIUM.get());
                output.accept(CCItems.IRIDIUM_NUGGET.get());
                output.accept(CCItems.IRIDIUM_INGOT.get());
                output.accept(CCItems.RAW_NEODYMIUM.get());
                output.accept(CCItems.NEODYMIUM_NUGGET.get());
                output.accept(CCItems.NEODYMIUM_INGOT.get());
                output.accept(CCItems.RAW_PALLADIUM.get());
                output.accept(CCItems.PALLADIUM_NUGGET.get());
                output.accept(CCItems.PALLADIUM_INGOT.get());
                output.accept(CCItems.PERPLEXIUM_NUGGET.get());
                output.accept(CCItems.PERPLEXIUM_INGOT.get());
                output.accept(CCItems.THUNDERSTEEL_NUGGET.get());
                output.accept(CCItems.THUNDERSTEEL_INGOT.get());
                output.accept(CCItems.RAW_TITANIUM.get());
                output.accept(CCItems.TITANIUM_NUGGET.get());
                output.accept(CCItems.TITANIUM_INGOT.get());
                output.accept(CCItems.RAW_TUNGSTEN.get());
                output.accept(CCItems.TUNGSTEN_NUGGET.get());
                output.accept(CCItems.TUNGSTEN_INGOT.get());
                output.accept(CCItems.QUANTUM_SIGIL.get());
                output.accept(CCItems.RIFT_TOKEN.get());
                output.accept(CCItems.STABLE_RIFT_TOKEN.get());
                output.accept(CCItems.ABYSSAL_THREAD.get());
                output.accept(CCItems.TIME_CRYSTAL.get());
                output.accept(CCItems.VOID_FABRIC.get());
            }).build()
    );
    public static final RegistryObject<CreativeModeTab> EQUIPMENT = TABS.register("equipment", () -> CreativeModeTab.builder()
            .title(Component.translatable("item_group." + CausalChaos.MODID + ".equipment"))
            .icon(() -> new ItemStack(CCItems.COBALT_SWORD.get()))
            .displayItems((params, output) -> {
                output.accept(CCItems.COBALT_AXE.get());
                output.accept(CCItems.COBALT_HOE.get());
                output.accept(CCItems.COBALT_PICKAXE.get());
                output.accept(CCItems.COBALT_SHOVEL.get());
                output.accept(CCItems.COBALT_SWORD.get());
                output.accept(CCItems.COBALT_HELMET.get());
                output.accept(CCItems.COBALT_CHESTPLATE.get());
                output.accept(CCItems.COBALT_LEGGINGS.get());
                output.accept(CCItems.COBALT_BOOTS.get());
                output.accept(CCItems.INFUSED_THUNDERSTEEL_AXE.get());
                output.accept(CCItems.INFUSED_THUNDERSTEEL_HOE.get());
                output.accept(CCItems.INFUSED_THUNDERSTEEL_PICKAXE.get());
                output.accept(CCItems.INFUSED_THUNDERSTEEL_SHOVEL.get());
                output.accept(CCItems.INFUSED_THUNDERSTEEL_SWORD.get());
                output.accept(CCItems.INFUSED_THUNDERSTEEL_HELMET.get());
                output.accept(CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE.get());
                output.accept(CCItems.INFUSED_THUNDERSTEEL_LEGGINGS.get());
                output.accept(CCItems.INFUSED_THUNDERSTEEL_BOOTS.get());
                output.accept(CCItems.IRIDIUM_AXE.get());
                output.accept(CCItems.IRIDIUM_HOE.get());
                output.accept(CCItems.IRIDIUM_PICKAXE.get());
                output.accept(CCItems.IRIDIUM_SHOVEL.get());
                output.accept(CCItems.IRIDIUM_SWORD.get());
                output.accept(CCItems.IRIDIUM_HELMET.get());
                output.accept(CCItems.IRIDIUM_CHESTPLATE.get());
                output.accept(CCItems.IRIDIUM_LEGGINGS.get());
                output.accept(CCItems.IRIDIUM_BOOTS.get());
                output.accept(CCItems.NEODYMIUM_AXE.get());
                output.accept(CCItems.NEODYMIUM_HOE.get());
                output.accept(CCItems.NEODYMIUM_PICKAXE.get());
                output.accept(CCItems.NEODYMIUM_SHOVEL.get());
                output.accept(CCItems.NEODYMIUM_SWORD.get());
                output.accept(CCItems.NEODYMIUM_HELMET.get());
                output.accept(CCItems.NEODYMIUM_CHESTPLATE.get());
                output.accept(CCItems.NEODYMIUM_LEGGINGS.get());
                output.accept(CCItems.NEODYMIUM_BOOTS.get());
                output.accept(CCItems.PALLADIUM_AXE.get());
                output.accept(CCItems.PALLADIUM_HOE.get());
                output.accept(CCItems.PALLADIUM_PICKAXE.get());
                output.accept(CCItems.PALLADIUM_SHOVEL.get());
                output.accept(CCItems.PALLADIUM_SWORD.get());
                output.accept(CCItems.PALLADIUM_HELMET.get());
                output.accept(CCItems.PALLADIUM_CHESTPLATE.get());
                output.accept(CCItems.PALLADIUM_LEGGINGS.get());
                output.accept(CCItems.PALLADIUM_BOOTS.get());
                output.accept(CCItems.PERPLEXIUM_AXE.get());
                output.accept(CCItems.PERPLEXIUM_HOE.get());
                output.accept(CCItems.PERPLEXIUM_PICKAXE.get());
                output.accept(CCItems.PERPLEXIUM_SHOVEL.get());
                output.accept(CCItems.PERPLEXIUM_SWORD.get());
                output.accept(CCItems.PERPLEXIUM_HELMET.get());
                output.accept(CCItems.PERPLEXIUM_CHESTPLATE.get());
                output.accept(CCItems.PERPLEXIUM_LEGGINGS.get());
                output.accept(CCItems.PERPLEXIUM_BOOTS.get());
                output.accept(CCItems.THUNDERSTEEL_AXE.get());
                output.accept(CCItems.THUNDERSTEEL_HOE.get());
                output.accept(CCItems.THUNDERSTEEL_PICKAXE.get());
                output.accept(CCItems.THUNDERSTEEL_SHOVEL.get());
                output.accept(CCItems.THUNDERSTEEL_SWORD.get());
                output.accept(CCItems.THUNDERSTEEL_HELMET.get());
                output.accept(CCItems.THUNDERSTEEL_CHESTPLATE.get());
                output.accept(CCItems.THUNDERSTEEL_LEGGINGS.get());
                output.accept(CCItems.THUNDERSTEEL_BOOTS.get());
                output.accept(CCItems.TITANIUM_AXE.get());
                output.accept(CCItems.TITANIUM_HOE.get());
                output.accept(CCItems.TITANIUM_PICKAXE.get());
                output.accept(CCItems.TITANIUM_SHOVEL.get());
                output.accept(CCItems.TITANIUM_SWORD.get());
                output.accept(CCItems.TITANIUM_HELMET.get());
                output.accept(CCItems.TITANIUM_CHESTPLATE.get());
                output.accept(CCItems.TITANIUM_LEGGINGS.get());
                output.accept(CCItems.TITANIUM_BOOTS.get());
                output.accept(CCItems.TUNGSTEN_AXE.get());
                output.accept(CCItems.TUNGSTEN_HOE.get());
                output.accept(CCItems.TUNGSTEN_PICKAXE.get());
                output.accept(CCItems.TUNGSTEN_SHOVEL.get());
                output.accept(CCItems.TUNGSTEN_SWORD.get());
                output.accept(CCItems.TUNGSTEN_HELMET.get());
                output.accept(CCItems.TUNGSTEN_CHESTPLATE.get());
                output.accept(CCItems.TUNGSTEN_LEGGINGS.get());
                output.accept(CCItems.TUNGSTEN_BOOTS.get());

                // Superboss gear
                output.accept(CCItems.WHITE_THUNDER.get());
            }).build());

/*
    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }
    }

 */
}
