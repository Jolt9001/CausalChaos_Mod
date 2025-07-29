package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CCCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CausalChaos.MODID);

    public static final RegistryObject<CreativeModeTab> BLOCKS = TABS.register("blocks", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(CCBlocks.COBALT_ORE.get()))
            .title(Component.translatable("item_group." + CausalChaos.MODID + ".blocks"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(CCBlocks.ANTHRACITE_ORE.get());
                pOutput.accept(CCBlocks.ANTHRACITE_BLOCK.get());
                pOutput.accept(CCBlocks.MAGNETITE_ORE.get());
                pOutput.accept(CCBlocks.MAGNETITE_BLOCK.get());
                pOutput.accept(CCBlocks.COBALT_ORE.get());
                pOutput.accept(CCBlocks.DEEPSLATE_COBALT_ORE.get());
                pOutput.accept(CCBlocks.RAW_COBALT_BLOCK.get());
                pOutput.accept(CCBlocks.COBALT_BLOCK.get());
                pOutput.accept(CCBlocks.IRIDIUM_ORE.get());
                pOutput.accept(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get());
                pOutput.accept(CCBlocks.RAW_IRIDIUM_BLOCK.get());
                pOutput.accept(CCBlocks.IRIDIUM_BLOCK.get());
                pOutput.accept(CCBlocks.NEODYMIUM_ORE.get());
                pOutput.accept(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get());
                pOutput.accept(CCBlocks.RAW_NEODYMIUM_BLOCK.get());
                pOutput.accept(CCBlocks.NEODYMIUM_BLOCK.get());
                pOutput.accept(CCBlocks.PALLADIUM_ORE.get());
                pOutput.accept(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get());
                pOutput.accept(CCBlocks.RAW_PALLADIUM_BLOCK.get());
                pOutput.accept(CCBlocks.PALLADIUM_BLOCK.get());
                pOutput.accept(CCBlocks.PERPLEXIUM_BLOCK.get());
                pOutput.accept(CCBlocks.THUNDERSTEEL_BLOCK.get());
                pOutput.accept(CCBlocks.TITANIUM_ORE.get());
                pOutput.accept(CCBlocks.DEEPSLATE_TITANIUM_ORE.get());
                pOutput.accept(CCBlocks.RAW_TITANIUM_BLOCK.get());
                pOutput.accept(CCBlocks.TITANIUM_BLOCK.get());
                pOutput.accept(CCBlocks.TUNGSTEN_ORE.get());
                pOutput.accept(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
                pOutput.accept(CCBlocks.RAW_TUNGSTEN_BLOCK.get());
                pOutput.accept(CCBlocks.TUNGSTEN_BLOCK.get());
                pOutput.accept(CCBlocks.REALMWEAVE_BLOCK.get());
                pOutput.accept(CCBlocks.QUANTUM_FABRIC.get());
                pOutput.accept(CCBlocks.DIMENSIONAL_ANCHOR.get());
                pOutput.accept(CCBlocks.WORMHOLE_STABILIZER.get());
                pOutput.accept(CCBlocks.FUSION_CORE.get());
                pOutput.accept(CCBlocks.T0_STARFORGE.get());
                pOutput.accept(CCBlocks.T1_STARFORGE.get());
                pOutput.accept(CCBlocks.T2_STARFORGE.get());
                pOutput.accept(CCBlocks.T3_STARFORGE.get());
                pOutput.accept(CCBlocks.T1_HEAT_SINK.get());
                pOutput.accept(CCBlocks.T2_HEAT_SINK.get());
                pOutput.accept(CCBlocks.T3_HEAT_SINK.get());
                pOutput.accept(CCBlocks.T1_ELECTROMAGNET.get());
                pOutput.accept(CCBlocks.T2_ELECTROMAGNET.get());
                pOutput.accept(CCBlocks.T3_ELECTROMAGNET.get());
                pOutput.accept(CCBlocks.T1_HOPPER.get());
                pOutput.accept(CCBlocks.T2_HOPPER.get());
                pOutput.accept(CCBlocks.T3_HOPPER.get());
                pOutput.accept(CCBlocks.T1_S_HOPPER.get());
                pOutput.accept(CCBlocks.T2_S_HOPPER.get());
                pOutput.accept(CCBlocks.T3_S_HOPPER.get());
                pOutput.accept(CCBlocks.T1_CORE_SHIELDING.get());
                pOutput.accept(CCBlocks.T2_CORE_SHIELDING.get());
                pOutput.accept(CCBlocks.T3_CORE_SHIELDING.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_SLAB.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_STAIRS.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_WALL.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_COBBLESTONE.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_COBBLESTONE_SLAB.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_COBBLESTONE_STAIRS.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_COBBLESTONE_WALL.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_SMOOTH_STONE.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_SMOOTH_STONE_SLAB.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_SMOOTH_STONE_STAIRS.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_SMOOTH_STONE_WALL.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_BRICKS.get());
                pOutput.accept(CCBlocks.CHISELED_TRANSCENDENT_STONE_BRICKS.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_BRICK_SLAB.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_BRICK_STAIRS.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_BRICK_WALL.get());
                pOutput.accept(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICKS.get());
                pOutput.accept(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_SLAB.get());
                pOutput.accept(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_STAIRS.get());
                pOutput.accept(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_WALL.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_TILES.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_TILE_SLAB.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_TILE_STAIRS.get());
                pOutput.accept(CCBlocks.TRANSCENDENT_STONE_TILE_WALL.get());
                pOutput.accept(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILES.get());
                pOutput.accept(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_SLAB.get());
                pOutput.accept(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_STAIRS.get());
                pOutput.accept(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_WALL.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> ITEMS = TABS.register("items", () -> CreativeModeTab.builder()
            // Set icon of creative tab
            .icon(() -> new ItemStack(CCItems.CAUSALITY_CRYSTAL.get()))
            // Set name of tab to display
            .title(Component.translatable("item_group." + CausalChaos.MODID + ".items"))
            // Add items to tab
            .displayItems((features, output) -> {
                output.accept(CCItems.JOURNAL.get());
                output.accept(CCItems.CAUSALITY_CRYSTAL.get());
                output.accept(CCItems.COBALT_INGOT.get());
                output.accept(CCItems.IRIDIUM_INGOT.get());
                output.accept(CCItems.NEODYMIUM_INGOT.get());
                output.accept(CCItems.PALLADIUM_INGOT.get());
                output.accept(CCItems.PERPLEXIUM_INGOT.get());
                output.accept(CCItems.THUNDERSTEEL_INGOT.get());
                output.accept(CCItems.TITANIUM_INGOT.get());
                output.accept(CCItems.TUNGSTEN_INGOT.get());
                output.accept(CCItems.COBALT_NUGGET.get());
                output.accept(CCItems.IRIDIUM_NUGGET.get());
                output.accept(CCItems.NEODYMIUM_NUGGET.get());
                output.accept(CCItems.PALLADIUM_NUGGET.get());
                output.accept(CCItems.PERPLEXIUM_NUGGET.get());
                output.accept(CCItems.THUNDERSTEEL_NUGGET.get());
                output.accept(CCItems.TITANIUM_NUGGET.get());
                output.accept(CCItems.TUNGSTEN_NUGGET.get());
                output.accept(CCItems.RAW_COBALT.get());
                output.accept(CCItems.RAW_IRIDIUM.get());
                output.accept(CCItems.RAW_NEODYMIUM.get());
                output.accept(CCItems.RAW_PALLADIUM.get());
                output.accept(CCItems.RAW_TITANIUM.get());
                output.accept(CCItems.RAW_TUNGSTEN.get());
                output.accept(CCItems.ANTHRACITE.get());
                output.accept(CCItems.MAGNETITE.get());
                output.accept(CCItems.QUANTUM_SIGIL.get());
                output.accept(CCItems.RIFT_TOKEN.get());
                output.accept(CCItems.STABLE_RIFT_TOKEN.get());
                output.accept(CCItems.ABYSS_STRING.get());
                output.accept(CCItems.TIME_CRYSTAL.get());
                output.accept(CCItems.VOID_FABRIC.get());
                output.accept(CCItems.WORLD_THREAD.get());
                output.accept(CCItems.REALM_SEED.get());
                output.accept(CCItems.THUNDERSTEEL_UPGRADE.get());
            }).build()
    );
    public static final RegistryObject<CreativeModeTab> EQUIPMENT = TABS.register("equipment", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(CCItems.COBALT_SWORD.get()))
            .title(Component.translatable("item_group." + CausalChaos.MODID + ".equipment"))
            .displayItems((features, output) -> {
                for (RegistryObject<Item> item : CCItems.EQUIPMENT.getEntries()) {
                    output.accept(item.get());
                }
                /*
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
                output.accept(CCItems.PELLUCID_KATANA.get());
                output.accept(CCItems.DIAPHANOUS_SHURIKEN.get());
                output.accept(CCItems.SANGUINE_SHORTSWORD.get());
                output.accept(CCItems.GUIDED_NANOSPEAR.get());
                output.accept(CCItems.INFALLIBLE_BAYONET.get());
                output.accept(CCItems.PINPOINT_REVOLVER.get());
                output.accept(CCItems.AIMBOT_45.get());
                output.accept(CCItems.GALLANT_SHASHKA.get());
                output.accept(CCItems.NIGHTMARE_BOW.get());
                output.accept(CCItems.TREPIDOUS_ARROW.get());
                output.accept(CCItems.BESPATTERED_WARHAMMER.get());
                output.accept(CCItems.PRISMATIC_GRENADE.get());
                output.accept(CCItems.OSCILLATING_TRIDENT.get());
                output.accept(CCItems.ENTROPIC_SHORTBOW.get());
                output.accept(CCItems.VIBRATING_ARROW.get());
                output.accept(CCItems.UMBRAL_GUISARME.get());
                output.accept(CCItems.TWILIGHT_JAVELIN.get());
                output.accept(CCItems.COLLAPSAR_CLAYMORE.get());
                output.accept(CCItems.RELATIVISTIC_RAYGUN.get());
                output.accept(CCItems.HALLUCINOGENIC_BRACERS.get());
                output.accept(CCItems.PSYCHOTIC_LONGBOW.get());
                output.accept(CCItems.DELIRIUM_ARROW.get());
                output.accept(CCItems.CADUCEUS_GLAIVE.get());
                output.accept(CCItems.VAMPIRIC_CHAKRAM.get());
                output.accept(CCItems.INSTINCTUAL_SCYTHE.get());
                output.accept(CCItems.ARDENT_TOMAHAWK.get());
                output.accept(CCItems.ILLUSORY_SPEAR.get());
                output.accept(CCItems.PHRENIC_DART.get());
                output.accept(CCItems.DIABLO_GAUNTLETS.get());
                output.accept(CCItems.BRIMSTONE_FLAMETHROWER.get());
                output.accept(CCItems.BRIMSTONE_CANISTER.get());
                output.accept(CCItems.WORLDLINE_RAPIER.get());
                output.accept(CCItems.SNAPSHOT_RIFLE.get());
                output.accept(CCItems.CHRONAL_BULLET.get());
                output.accept(CCItems.REPULSOR_SABER.get());
                output.accept(CCItems.SUPERRADIANT_DAGGER.get());
                output.accept(CCItems.ELECTRON_STAFF.get());
                output.accept(CCItems.SPARK_LAUNCHERS.get());
                output.accept(CCItems.TERAVOLT_CANNON.get());
                output.accept(CCItems.SUPERLUMINAL_SLUG.get());
                output.accept(CCItems.WHITE_THUNDER.get());
                output.accept(CCItems.OBLIVION_CROSSBOW.get());
                output.accept(CCItems.WORLD_THREAD_BOLT.get());
                */
            }).build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
/*
    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }
    }

 */
}
