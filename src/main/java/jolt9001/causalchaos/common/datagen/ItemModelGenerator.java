package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.init.CCBlocks;
import jolt9001.causalchaos.init.CCItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ItemModelGenerator extends ItemModelProvider {
    private final ModelFile.UncheckedModelFile GENERATED = new ModelFile.UncheckedModelFile("item/generated");
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CausalChaos.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /*
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
        //toBlock(CCBlocks.DIMENSIONAL_ANCHOR.get());
        //toBlock(CCBlocks.FUSION_CORE.get());
        toBlock(CCBlocks.IRIDIUM_BLOCK.get());
        toBlock(CCBlocks.IRIDIUM_ORE.get());
        toBlock(CCBlocks.MAGNETITE_BLOCK.get());
        toBlock(CCBlocks.MAGNETITE_ORE.get());
        toBlock(CCBlocks.NEODYMIUM_BLOCK.get());
        toBlock(CCBlocks.NEODYMIUM_ORE.get());
        toBlock(CCBlocks.PALLADIUM_BLOCK.get());
        toBlock(CCBlocks.PALLADIUM_ORE.get());
        toBlock(CCBlocks.PERPLEXIUM_BLOCK.get());
        //toBlock(CCBlocks.QUANTUM_FABRIC.get());
        toBlock(CCBlocks.RAW_COBALT_BLOCK.get());
        toBlock(CCBlocks.RAW_IRIDIUM_BLOCK.get());
        toBlock(CCBlocks.RAW_NEODYMIUM_BLOCK.get());
        toBlock(CCBlocks.RAW_PALLADIUM_BLOCK.get());
        toBlock(CCBlocks.RAW_TITANIUM_BLOCK.get());
        toBlock(CCBlocks.RAW_TUNGSTEN_BLOCK.get());
        /*
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
         */
        /*
        toBlock(CCBlocks.THUNDERSTEEL_BLOCK.get());
        toBlock(CCBlocks.TITANIUM_BLOCK.get());
        toBlock(CCBlocks.TITANIUM_ORE.get());
        toBlock(CCBlocks.TRANSCENDENT_GATEWAY.get());
        toBlock(CCBlocks.TUNGSTEN_BLOCK.get());
        toBlock(CCBlocks.TUNGSTEN_ORE.get());
        //toBlock(CCBlocks.WORMHOLE_STABILIZER.get());

        toBasicItem(CCItems.ABYSS_STRING.get());
        //toBasicItem(CCItems.AIMBOT_45.get());
        toBasicItem(CCItems.ANTHRACITE.get());
        /*
        toBasicItem(CCItems.ARDENT_TOMAHAWK.get());
        toBasicItem(CCItems.BESPATTERED_WARHAMMER.get());
        toBasicItem(CCItems.BRIMSTONE_CANISTER.get());
        toBasicItem(CCItems.BRIMSTONE_FLAMETHROWER.get()); // TEMP
        toBasicItem(CCItems.CADUCEUS_GLAIVE.get());

        toBasicItem(CCItems.CAUSALITY_CRYSTAL.get());
        //toBasicItem(CCItems.CHRONAL_BULLET.get());
        toBasicItem(CCItems.COBALT_AXE.get());
        toBasicItem(CCItems.COBALT_HOE.get());
        toBasicItem(CCItems.COBALT_INGOT.get());
        toBasicItem(CCItems.COBALT_NUGGET.get());
        toBasicItem(CCItems.COBALT_PICKAXE.get());
        toBasicItem(CCItems.COBALT_SHOVEL.get());
        toBasicItem(CCItems.COBALT_SWORD.get());
        /*
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

         */
        /*
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_AXE.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_HOE.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_PICKAXE.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_SHOVEL.get());
        toBasicItem(CCItems.INFUSED_THUNDERSTEEL_SWORD.get());
        //toBasicItem(CCItems.INSTINCTUAL_SCYTHE.get());
        toBasicItem(CCItems.IRIDIUM_AXE.get());
        toBasicItem(CCItems.IRIDIUM_HOE.get());
        toBasicItem(CCItems.IRIDIUM_INGOT.get());
        toBasicItem(CCItems.IRIDIUM_NUGGET.get());
        toBasicItem(CCItems.IRIDIUM_PICKAXE.get());
        toBasicItem(CCItems.IRIDIUM_SHOVEL.get());
        toBasicItem(CCItems.IRIDIUM_SWORD.get());
        toBasicItem(CCItems.JOURNAL.get());
        toBasicItem(CCItems.MAGNETITE.get());
        toBasicItem(CCItems.NEODYMIUM_AXE.get());
        toBasicItem(CCItems.NEODYMIUM_HOE.get());
        toBasicItem(CCItems.NEODYMIUM_INGOT.get());
        toBasicItem(CCItems.NEODYMIUM_NUGGET.get());
        toBasicItem(CCItems.NEODYMIUM_PICKAXE.get());
        toBasicItem(CCItems.NEODYMIUM_SHOVEL.get());
        toBasicItem(CCItems.NEODYMIUM_SWORD.get());
        /*
        toBasicItem(CCItems.NIGHTMARE_BOW.get()); // TEMP
        toBasicItem(CCItems.OBLIVION_CROSSBOW.get()); // TEMP
        toBasicItem(CCItems.OSCILLATING_TRIDENT.get());

         */
        /*
        toBasicItem(CCItems.PALLADIUM_AXE.get());
        toBasicItem(CCItems.PALLADIUM_HOE.get());
        toBasicItem(CCItems.PALLADIUM_INGOT.get());
        toBasicItem(CCItems.PALLADIUM_NUGGET.get());
        toBasicItem(CCItems.PALLADIUM_PICKAXE.get());
        toBasicItem(CCItems.PALLADIUM_SHOVEL.get());
        toBasicItem(CCItems.PALLADIUM_SWORD.get());
        //toBasicItem(CCItems.PELLUCID_KATANA.get());
        toBasicItem(CCItems.PERPLEXIUM_AXE.get());
        toBasicItem(CCItems.PERPLEXIUM_HOE.get());
        toBasicItem(CCItems.PERPLEXIUM_INGOT.get());
        toBasicItem(CCItems.PERPLEXIUM_NUGGET.get());
        toBasicItem(CCItems.PERPLEXIUM_PICKAXE.get());
        toBasicItem(CCItems.PERPLEXIUM_SHOVEL.get());
        toBasicItem(CCItems.PERPLEXIUM_SWORD.get());
        /*
        toBasicItem(CCItems.PINPOINT_REVOLVER.get());
        toBasicItem(CCItems.PHRENIC_DART.get());
        toBasicItem(CCItems.PRISMATIC_GRENADE.get());
        toBasicItem(CCItems.PSYCHOTIC_LONGBOW.get()); // TEMP
        toBasicItem(CCItems.QUANTUM_SIGIL.get());

         */
        /*
        toBasicItem(CCItems.RAW_COBALT.get());
        toBasicItem(CCItems.RAW_IRIDIUM.get());
        toBasicItem(CCItems.RAW_NEODYMIUM.get());
        toBasicItem(CCItems.RAW_PALLADIUM.get());
        toBasicItem(CCItems.RAW_TITANIUM.get());
        toBasicItem(CCItems.RAW_TUNGSTEN.get());
        /*
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

         */
        /*
        toBasicItem(CCItems.THUNDERSTEEL_AXE.get());
        toBasicItem(CCItems.THUNDERSTEEL_HOE.get());
        toBasicItem(CCItems.THUNDERSTEEL_INGOT.get());
        toBasicItem(CCItems.THUNDERSTEEL_NUGGET.get());
        toBasicItem(CCItems.THUNDERSTEEL_PICKAXE.get());
        toBasicItem(CCItems.THUNDERSTEEL_SHOVEL.get());
        toBasicItem(CCItems.THUNDERSTEEL_SWORD.get());
        //toBasicItem(CCItems.TIME_CRYSTAL.get());
        toBasicItem(CCItems.TITANIUM_AXE.get());
        toBasicItem(CCItems.TITANIUM_HOE.get());
        toBasicItem(CCItems.TITANIUM_INGOT.get());
        toBasicItem(CCItems.TITANIUM_NUGGET.get());
        toBasicItem(CCItems.TITANIUM_PICKAXE.get());
        toBasicItem(CCItems.TITANIUM_SHOVEL.get());
        toBasicItem(CCItems.TITANIUM_SWORD.get());
        toBasicItem(CCItems.TREPIDOUS_ARROW.get());
        toBasicItem(CCItems.TUNGSTEN_AXE.get());
        toBasicItem(CCItems.TUNGSTEN_HOE.get());
        toBasicItem(CCItems.TUNGSTEN_INGOT.get());
        toBasicItem(CCItems.TUNGSTEN_NUGGET.get());
        toBasicItem(CCItems.TUNGSTEN_PICKAXE.get());
        toBasicItem(CCItems.TUNGSTEN_SHOVEL.get());
        toBasicItem(CCItems.TUNGSTEN_SWORD.get());
        /*
        toBasicItem(CCItems.TWILIGHT_JAVELIN.get());
        toBasicItem(CCItems.UMBRAL_GUISARME.get());
        toBasicItem(CCItems.VAMPIRIC_CHAKRAM.get());
        toBasicItem(CCItems.VIBRATING_ARROW.get());
        toBasicItem(CCItems.VOID_FABRIC.get());

         */
        //toBasicItem(CCItems.WHITE_THUNDER.get());
        /*
        toBasicItem(CCItems.WORLD_THREAD.get());
        toBasicItem(CCItems.WORLD_THREAD_BOLT.get());
        toBasicItem(CCItems.WORLDLINE_RAPIER.get());
         */

        trimmedArmorItem(CCItems.COBALT_HELMET);
        trimmedArmorItem(CCItems.COBALT_CHESTPLATE);
        trimmedArmorItem(CCItems.COBALT_LEGGINGS);
        trimmedArmorItem(CCItems.COBALT_BOOTS);

        trimmedArmorItem(CCItems.INFUSED_THUNDERSTEEL_HELMET);
        trimmedArmorItem(CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE);
        trimmedArmorItem(CCItems.INFUSED_THUNDERSTEEL_LEGGINGS);
        trimmedArmorItem(CCItems.INFUSED_THUNDERSTEEL_BOOTS);

        trimmedArmorItem(CCItems.IRIDIUM_HELMET);
        trimmedArmorItem(CCItems.IRIDIUM_CHESTPLATE);
        trimmedArmorItem(CCItems.IRIDIUM_LEGGINGS);
        trimmedArmorItem(CCItems.IRIDIUM_BOOTS);

        trimmedArmorItem(CCItems.NEODYMIUM_HELMET);
        trimmedArmorItem(CCItems.NEODYMIUM_CHESTPLATE);
        trimmedArmorItem(CCItems.NEODYMIUM_LEGGINGS);
        trimmedArmorItem(CCItems.NEODYMIUM_BOOTS);

        trimmedArmorItem(CCItems.PALLADIUM_HELMET);
        trimmedArmorItem(CCItems.PALLADIUM_CHESTPLATE);
        trimmedArmorItem(CCItems.PALLADIUM_LEGGINGS);
        trimmedArmorItem(CCItems.PALLADIUM_BOOTS);

        trimmedArmorItem(CCItems.PERPLEXIUM_HELMET);
        trimmedArmorItem(CCItems.PERPLEXIUM_CHESTPLATE);
        trimmedArmorItem(CCItems.PERPLEXIUM_LEGGINGS);
        trimmedArmorItem(CCItems.PERPLEXIUM_BOOTS);

        trimmedArmorItem(CCItems.THUNDERSTEEL_HELMET);
        trimmedArmorItem(CCItems.THUNDERSTEEL_CHESTPLATE);
        trimmedArmorItem(CCItems.THUNDERSTEEL_LEGGINGS);
        trimmedArmorItem(CCItems.THUNDERSTEEL_BOOTS);

        trimmedArmorItem(CCItems.TITANIUM_HELMET);
        trimmedArmorItem(CCItems.TITANIUM_CHESTPLATE);
        trimmedArmorItem(CCItems.TITANIUM_LEGGINGS);
        trimmedArmorItem(CCItems.TITANIUM_BOOTS);

        trimmedArmorItem(CCItems.TUNGSTEN_HELMET);
        trimmedArmorItem(CCItems.TUNGSTEN_CHESTPLATE);
        trimmedArmorItem(CCItems.TUNGSTEN_LEGGINGS);
        trimmedArmorItem(CCItems.TUNGSTEN_BOOTS);
    }
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MODID = CausalChaos.MODID;
        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {
                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem; // e.g. item/cobalt_boots
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath(); // e.g. trims/items/boots_trim_iron
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim"; // e.g. item/cobalt_boots_iron_trim
                ResourceLocation armorItemResLoc = new ResourceLocation(MODID, armorItemPath); // e.g. causalchaos/item/cobalt_boots
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MODID, currentTrimName); // e.g. causalchaos/item/cobalt_boots_iron_trim

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(), mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0", new ResourceLocation(MODID, "item/" + itemRegistryObject.getId().getPath()));
            });
        }
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
