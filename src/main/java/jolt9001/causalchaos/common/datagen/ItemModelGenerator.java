package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.init.CCBlocks;
import jolt9001.causalchaos.init.CCItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    private final ModelFile.UncheckedModelFile GENERATED = new ModelFile.UncheckedModelFile("item/generated");
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CausalChaos.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        toBlock(CCBlocks.ANTHRACITE_BLOCK.get());
        toBlock(CCBlocks.ANTHRACITE_ORE.get());
        toBlock(CCBlocks.COBALT_BLOCK.get());
        toBlock(CCBlocks.COBALT_ORE.get());
        toBlock(CCBlocks.DEEPSLATE_COBALT_ORE.get());
        toBlock(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get());
        toBlock(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get());
        toBlock(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get());
        toBlock(CCBlocks.DEEPSLATE_TITANIUM_ORE.get());
        toBlock(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get());
        toBlock(CCBlocks.DIMENSIONAL_ANCHOR.get());
        toBlock(CCBlocks.FUSION_CORE.get());
        toBlock(CCBlocks.IRIDIUM_BLOCK.get());
        toBlock(CCBlocks.IRIDIUM_ORE.get());
        toBlock(CCBlocks.MAGNETITE_BLOCK.get());
        toBlock(CCBlocks.MAGNETITE_ORE.get());
        toBlock(CCBlocks.NEODYMIUM_BLOCK.get());
        toBlock(CCBlocks.NEODYMIUM_ORE.get());
        toBlock(CCBlocks.PALLADIUM_BLOCK.get());
        toBlock(CCBlocks.PALLADIUM_ORE.get());
        toBlock(CCBlocks.PERPLEXIUM_BLOCK.get());
        toBlock(CCBlocks.QUANTUM_FABRIC.get());
        toBlock(CCBlocks.RAW_COBALT_BLOCK.get());
        toBlock(CCBlocks.RAW_IRIDIUM_BLOCK.get());
        toBlock(CCBlocks.RAW_NEODYMIUM_BLOCK.get());
        toBlock(CCBlocks.RAW_PALLADIUM_BLOCK.get());
        toBlock(CCBlocks.RAW_TITANIUM_BLOCK.get());
        toBlock(CCBlocks.RAW_TUNGSTEN_BLOCK.get());
        toBlock(CCBlocks.REALMWEAVE_BLOCK.get());
        toBlock(CCBlocks.T0_STARFORGE.get());
        toBlock(CCBlocks.T1_CORE_SHIELDING.get());
        toBlock(CCBlocks.T1_ELECTROMAGNET.get());
        toBlock(CCBlocks.T1_HEAT_SINK.get());
        toBlock(CCBlocks.T1_HOPPER.get());
        toBlock(CCBlocks.T1_S_HOPPER.get());
        toBlock(CCBlocks.T1_STARFORGE.get());
        toBlock(CCBlocks.T2_CORE_SHIELDING.get());
        toBlock(CCBlocks.T2_ELECTROMAGNET.get());
        toBlock(CCBlocks.T2_HEAT_SINK.get());
        toBlock(CCBlocks.T2_HOPPER.get());
        toBlock(CCBlocks.T2_S_HOPPER.get());
        toBlock(CCBlocks.T2_STARFORGE.get());
        toBlock(CCBlocks.T3_CORE_SHIELDING.get());
        toBlock(CCBlocks.T3_ELECTROMAGNET.get());
        toBlock(CCBlocks.T3_HEAT_SINK.get());
        toBlock(CCBlocks.T3_HOPPER.get());
        toBlock(CCBlocks.T3_S_HOPPER.get());
        toBlock(CCBlocks.T3_STARFORGE.get());
        toBlock(CCBlocks.THUNDERSTEEL_BLOCK.get());
        toBlock(CCBlocks.TITANIUM_BLOCK.get());
        toBlock(CCBlocks.TITANIUM_ORE.get());
        toBlock(CCBlocks.TRANSCENDENT_GATEWAY.get());
        toBlock(CCBlocks.TUNGSTEN_BLOCK.get());
        toBlock(CCBlocks.TUNGSTEN_ORE.get());
        toBlock(CCBlocks.WORMHOLE_STABILIZER.get());

        toBasicItem(CCItems.ABYSS_STRING.get());
        toBasicItem(CCItems.AIMBOT_45.get());
        toBasicItem(CCItems.ANTHRACITE.get());
        toBasicItem(CCItems.ARDENT_TOMAHAWK.get());
        toBasicItem(CCItems.BESPATTERED_WARHAMMER.get());
        toBasicItem(CCItems.BRIMSTONE_CANISTER.get());
        toBasicItem(CCItems.BRIMSTONE_FLAMETHROWER.get()); // TEMP
        toBasicItem(CCItems.CADUCEUS_GLAIVE.get());
        toBasicItem(CCItems.CAUSALITY_CRYSTAL.get());
        toBasicItem(CCItems.CHRONAL_BULLET.get());
        toBasicItem(CCItems.COBALT_AXE.get());
        toBasicItem(CCItems.COBALT_BOOTS.get());
        toBasicItem(CCItems.COBALT_CHESTPLATE.get());
        toBasicItem(CCItems.COBALT_HELMET.get());
        toBasicItem(CCItems.COBALT_HOE.get());
        toBasicItem(CCItems.COBALT_INGOT.get());
        toBasicItem(CCItems.COBALT_LEGGINGS.get());
        toBasicItem(CCItems.COBALT_NUGGET.get());
        toBasicItem(CCItems.COBALT_PICKAXE.get());
        toBasicItem(CCItems.COBALT_SHOVEL.get());
        toBasicItem(CCItems.COBALT_SWORD.get());
        toBasicItem(CCItems.COLLAPSAR_CLAYMORE.get());
        toBasicItem(CCItems.DELIRIUM_ARROW.get());
        toBasicItem(CCItems.DIABLO_GAUNTLETS.get());
        toBasicItem(CCItems.DIAPHANOUS_SHURIKEN.get());
        toBasicItem(CCItems.ELECTRON_STAFF.get());
        toBasicItem(CCItems.ENTROPIC_SHORTBOW.get()); // TEMP
        toBasicItem(CCItems.GALLANT_SHASHKA.get());
        toBasicItem(CCItems.GUIDED_NANOSPEAR.get());
        toBasicItem(CCItems.HALLUCINOGENIC_BRACERS.get());
        toBasicItem(CCItems.ILLUSORY_SPEAR.get());
        toBasicItem(CCItems.INFALLIBLE_BAYONET.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_AXE.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_BOOTS.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_HELMET.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_HOE.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_LEGGINGS.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_PICKAXE.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_SHOVEL.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_SWORD.get());
        toBasicItem(CCItems.INSTINCTUAL_SCYTHE.get());
        toBasicItem(CCItems.IRIDIUM_AXE.get());
        toBasicItem(CCItems.IRIDIUM_BOOTS.get());
        toBasicItem(CCItems.IRIDIUM_CHESTPLATE.get());
        toBasicItem(CCItems.IRIDIUM_HELMET.get());
        toBasicItem(CCItems.IRIDIUM_HOE.get());
        toBasicItem(CCItems.IRIDIUM_INGOT.get());
        toBasicItem(CCItems.IRIDIUM_LEGGINGS.get());
        toBasicItem(CCItems.IRIDIUM_NUGGET.get());
        toBasicItem(CCItems.IRIDIUM_PICKAXE.get());
        toBasicItem(CCItems.IRIDIUM_SHOVEL.get());
        toBasicItem(CCItems.IRIDIUM_SWORD.get());
        toBasicItem(CCItems.JOURNAL.get());
        toBasicItem(CCItems.MAGNETITE.get());
        toBasicItem(CCItems.NEODYMIUM_AXE.get());
        toBasicItem(CCItems.NEODYMIUM_BOOTS.get());
        toBasicItem(CCItems.NEODYMIUM_CHESTPLATE.get());
        toBasicItem(CCItems.NEODYMIUM_HELMET.get());
        toBasicItem(CCItems.NEODYMIUM_HOE.get());
        toBasicItem(CCItems.NEODYMIUM_INGOT.get());
        toBasicItem(CCItems.NEODYMIUM_LEGGINGS.get());
        toBasicItem(CCItems.NEODYMIUM_NUGGET.get());
        toBasicItem(CCItems.NEODYMIUM_PICKAXE.get());
        toBasicItem(CCItems.NEODYMIUM_SHOVEL.get());
        toBasicItem(CCItems.NEODYMIUM_SWORD.get());
        toBasicItem(CCItems.NIGHTMARE_BOW.get()); // TEMP
        toBasicItem(CCItems.OBLIVION_CROSSBOW.get()); // TEMP
        toBasicItem(CCItems.OSCILLATING_TRIDENT.get());
        toBasicItem(CCItems.PALLADIUM_AXE.get());
        toBasicItem(CCItems.PALLADIUM_BOOTS.get());
        toBasicItem(CCItems.PALLADIUM_CHESTPLATE.get());
        toBasicItem(CCItems.PALLADIUM_HELMET.get());
        toBasicItem(CCItems.PALLADIUM_HOE.get());
        toBasicItem(CCItems.PALLADIUM_INGOT.get());
        toBasicItem(CCItems.PALLADIUM_LEGGINGS.get());
        toBasicItem(CCItems.PALLADIUM_NUGGET.get());
        toBasicItem(CCItems.PALLADIUM_PICKAXE.get());
        toBasicItem(CCItems.PALLADIUM_SHOVEL.get());
        toBasicItem(CCItems.PALLADIUM_SWORD.get());
        toBasicItem(CCItems.PELLUCID_KATANA.get());
        toBasicItem(CCItems.PERPLEXIUM_AXE.get());
        toBasicItem(CCItems.PERPLEXIUM_BOOTS.get());
        toBasicItem(CCItems.PERPLEXIUM_CHESTPLATE.get());
        toBasicItem(CCItems.PERPLEXIUM_HELMET.get());
        toBasicItem(CCItems.PERPLEXIUM_HOE.get());
        toBasicItem(CCItems.PERPLEXIUM_INGOT.get());
        toBasicItem(CCItems.PERPLEXIUM_LEGGINGS.get());
        toBasicItem(CCItems.PERPLEXIUM_NUGGET.get());
        toBasicItem(CCItems.PERPLEXIUM_PICKAXE.get());
        toBasicItem(CCItems.PERPLEXIUM_SHOVEL.get());
        toBasicItem(CCItems.PERPLEXIUM_SWORD.get());
        toBasicItem(CCItems.PINPOINT_REVOLVER.get());
        toBasicItem(CCItems.PHRENIC_DART.get());
        toBasicItem(CCItems.PRISMATIC_GRENADE.get());
        toBasicItem(CCItems.PSYCHOTIC_LONGBOW.get()); // TEMP
        toBasicItem(CCItems.QUANTUM_SIGIL.get());
        toBasicItem(CCItems.RAW_COBALT.get());
        toBasicItem(CCItems.RAW_IRIDIUM.get());
        toBasicItem(CCItems.RAW_NEODYMIUM.get());
        toBasicItem(CCItems.RAW_PALLADIUM.get());
        toBasicItem(CCItems.RAW_TITANIUM.get());
        toBasicItem(CCItems.RAW_TUNGSTEN.get());
        toBasicItem(CCItems.REALM_SEED.get());
        toBasicItem(CCItems.RELATIVISTIC_RAYGUN.get());
        toBasicItem(CCItems.REPULSOR_SABER.get());
        toBasicItem(CCItems.RIFT_TOKEN.get());
        toBasicItem(CCItems.SANGUINE_SHORTSWORD.get()); // TEMP
        toBasicItem(CCItems.SNAPSHOT_RIFLE.get());
        toBasicItem(CCItems.SPARK_LAUNCHERS.get());
        toBasicItem(CCItems.STABLE_RIFT_TOKEN.get());
        toBasicItem(CCItems.SUPERLUMINAL_SLUG.get());
        toBasicItem(CCItems.SUPERRADIANT_DAGGER.get());
        toBasicItem(CCItems.TERAVOLT_CANNON.get());
        toBasicItem(CCItems.THUNDERSTEEL_AXE.get());
        toBasicItem(CCItems.THUNDERSTEEL_BOOTS.get());
        toBasicItem(CCItems.THUNDERSTEEL_CHESTPLATE.get());
        toBasicItem(CCItems.THUNDERSTEEL_HELMET.get());
        toBasicItem(CCItems.THUNDERSTEEL_HOE.get());
        toBasicItem(CCItems.THUNDERSTEEL_INGOT.get());
        toBasicItem(CCItems.THUNDERSTEEL_LEGGINGS.get());
        toBasicItem(CCItems.THUNDERSTEEL_NUGGET.get());
        toBasicItem(CCItems.THUNDERSTEEL_PICKAXE.get());
        toBasicItem(CCItems.THUNDERSTEEL_SHOVEL.get());
        toBasicItem(CCItems.THUNDERSTEEL_SWORD.get());
        toBasicItem(CCItems.TIME_CRYSTAL.get());
        toBasicItem(CCItems.TITANIUM_AXE.get());
        toBasicItem(CCItems.TITANIUM_BOOTS.get());
        toBasicItem(CCItems.TITANIUM_CHESTPLATE.get());
        toBasicItem(CCItems.TITANIUM_HELMET.get());
        toBasicItem(CCItems.TITANIUM_HOE.get());
        toBasicItem(CCItems.TITANIUM_INGOT.get());
        toBasicItem(CCItems.TITANIUM_LEGGINGS.get());
        toBasicItem(CCItems.TITANIUM_NUGGET.get());
        toBasicItem(CCItems.TITANIUM_PICKAXE.get());
        toBasicItem(CCItems.TITANIUM_SHOVEL.get());
        toBasicItem(CCItems.TITANIUM_SWORD.get());
        toBasicItem(CCItems.TREPIDOUS_ARROW.get());
        toBasicItem(CCItems.TUNGSTEN_AXE.get());
        toBasicItem(CCItems.TUNGSTEN_BOOTS.get());
        toBasicItem(CCItems.TUNGSTEN_CHESTPLATE.get());
        toBasicItem(CCItems.TUNGSTEN_HELMET.get());
        toBasicItem(CCItems.TUNGSTEN_HOE.get());
        toBasicItem(CCItems.TUNGSTEN_INGOT.get());
        toBasicItem(CCItems.TUNGSTEN_LEGGINGS.get());
        toBasicItem(CCItems.TUNGSTEN_NUGGET.get());
        toBasicItem(CCItems.TUNGSTEN_PICKAXE.get());
        toBasicItem(CCItems.TUNGSTEN_SHOVEL.get());
        toBasicItem(CCItems.TUNGSTEN_SWORD.get());
        toBasicItem(CCItems.TWILIGHT_JAVELIN.get());
        toBasicItem(CCItems.UMBRAL_GUISARME.get());
        toBasicItem(CCItems.VAMPIRIC_CHAKRAM.get());
        toBasicItem(CCItems.VIBRATING_ARROW.get());
        toBasicItem(CCItems.VOID_FABRIC.get());
        toBasicItem(CCItems.WHITE_THUNDER.get());
        toBasicItem(CCItems.WORLD_THREAD.get());
        toBasicItem(CCItems.WORLD_THREAD_BOLT.get());
        toBasicItem(CCItems.WORLDLINE_RAPIER.get());
    }
    @SuppressWarnings("deprecation") // fym "ITEM" is depreciated!?
    private ResourceLocation id(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem());
    }

    /** Generated item with a texture */
    private ItemModelBuilder generated(ResourceLocation item, ResourceLocation texture) {
        return getBuilder(item.toString()).parent(GENERATED).texture("layer0", texture);
    }

    /** Generated item with a texture */
    private ItemModelBuilder generated(ResourceLocation item, String texture) {
        return generated(item, new ResourceLocation(item.getNamespace(), texture));
    }

    /** Generated item with a texture */
    private ItemModelBuilder generate(ItemLike item) {
        return generated(id(item), id(item).getPath());
    }

    /**
     * Generated item with a texture
     */
    private void basicItem(ResourceLocation item, String texture) {
        generated(item, "item/" + texture);
    }

    /** Generated item with a texture */
    private void toBasicItem(ItemLike item) {
        basicItem(id(item), id(item).getPath());
    }

    /* Bow item texture */
    private ItemModelBuilder bowItem(String name, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, "item/bow");
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        return builder;
    }

    /* Block textures */
    private void toBlock(Block b) {
        toBlockModel(b, BuiltInRegistries.BLOCK.getKey(b).getPath());
    }
    private void toBlockModel(Block b, String model) {
        toBlockModel(b, CausalChaos.prefix("block/" + model));
    }
    private void toBlockModel(Block b, ResourceLocation model) {
        withExistingParent(BuiltInRegistries.BLOCK.getKey(b).getPath(), model);
    }
}
