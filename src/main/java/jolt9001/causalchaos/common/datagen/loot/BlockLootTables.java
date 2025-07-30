package jolt9001.causalchaos.common.datagen.loot;

import jolt9001.causalchaos.init.CCBlocks;
import jolt9001.causalchaos.init.CCItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider {
    public BlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Ores and Terrain
        this.add(CCBlocks.ANTHRACITE_ORE.get(), block -> createOreDrops(CCBlocks.ANTHRACITE_ORE.get(), CCItems.ANTHRACITE.get()));
        this.add(CCBlocks.MAGNETITE_ORE.get(), block -> createOreDrops(CCBlocks.MAGNETITE_ORE.get(), CCItems.MAGNETITE.get()));
        this.add(CCBlocks.COBALT_ORE.get(), block -> createOreDrops(CCBlocks.COBALT_ORE.get(), CCItems.RAW_COBALT.get()));
        this.add(CCBlocks.IRIDIUM_ORE.get(), block -> createOreDrops(CCBlocks.IRIDIUM_ORE.get(), CCItems.RAW_IRIDIUM.get()));
        this.add(CCBlocks.NEODYMIUM_ORE.get(), block -> createOreDrops(CCBlocks.NEODYMIUM_ORE.get(), CCItems.RAW_NEODYMIUM.get()));
        this.add(CCBlocks.PALLADIUM_ORE.get(), block -> createOreDrops(CCBlocks.PALLADIUM_ORE.get(), CCItems.RAW_PALLADIUM.get()));
        this.add(CCBlocks.TITANIUM_ORE.get(), block -> createOreDrops(CCBlocks.TITANIUM_ORE.get(), CCItems.RAW_TITANIUM.get()));
        this.add(CCBlocks.TUNGSTEN_ORE.get(), block -> createOreDrops(CCBlocks.TUNGSTEN_ORE.get(), CCItems.RAW_TUNGSTEN.get()));

        this.add(CCBlocks.DEEPSLATE_COBALT_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_COBALT_ORE.get(), CCItems.RAW_COBALT.get()));
        this.add(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get(), CCItems.RAW_IRIDIUM.get()));
        this.add(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get(), CCItems.RAW_NEODYMIUM.get()));
        this.add(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get(), CCItems.RAW_PALLADIUM.get()));
        this.add(CCBlocks.DEEPSLATE_TITANIUM_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_TITANIUM_ORE.get(), CCItems.RAW_TITANIUM.get()));
        this.add(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), CCItems.RAW_TUNGSTEN.get()));

        // Terrain Blocks
        this.add(CCBlocks.REALMWEAVE_BLOCK.get(), block -> createOreDrops(CCBlocks.REALMWEAVE_BLOCK.get(), CCItems.ABYSS_STRING.get()));
        this.add(CCBlocks.TRANSCENDENT_TURF.get(), block -> createGrassDrops(CCBlocks.TRANSCENDENT_TURF.get()));
        this.dropSelf(CCBlocks.TRANSCENDENT_SOIL.get());
        this.add(CCBlocks.TRANSCENDENT_STONE.get(), block -> createSingleItemTableWithSilkTouch(CCBlocks.TRANSCENDENT_STONE.get(), CCBlocks.TRANSCENDENT_COBBLESTONE.get()));

        // Decoration Blocks
        this.dropSelf(CCBlocks.QUANTUM_FABRIC.get());

        this.dropSelf(CCBlocks.TRANSCENDENT_SMOOTH_STONE.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_COBBLESTONE.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_STONE_BRICKS.get());
        this.dropSelf(CCBlocks.CHISELED_TRANSCENDENT_STONE_BRICKS.get());
        this.dropSelf(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICKS.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_STONE_TILES.get());
        this.dropSelf(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILES.get());

        this.add(CCBlocks.TRANSCENDENT_STONE_SLAB.get(), block -> createSlabItemTable(CCBlocks.TRANSCENDENT_STONE_SLAB.get()));
        this.add(CCBlocks.TRANSCENDENT_SMOOTH_STONE_SLAB.get(), block -> createSlabItemTable(CCBlocks.TRANSCENDENT_SMOOTH_STONE_SLAB.get()));
        this.add(CCBlocks.TRANSCENDENT_COBBLESTONE_SLAB.get(), block -> createSlabItemTable(CCBlocks.TRANSCENDENT_COBBLESTONE_SLAB.get()));
        this.add(CCBlocks.TRANSCENDENT_STONE_BRICK_SLAB.get(), block -> createSlabItemTable(CCBlocks.TRANSCENDENT_STONE_BRICK_SLAB.get()));
        this.add(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_SLAB.get(), block -> createSlabItemTable(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_SLAB.get()));
        this.add(CCBlocks.TRANSCENDENT_STONE_TILE_SLAB.get(), block -> createSlabItemTable(CCBlocks.TRANSCENDENT_STONE_TILE_SLAB.get()));
        this.add(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_SLAB.get(), block -> createSlabItemTable(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_SLAB.get()));

        this.dropSelf(CCBlocks.TRANSCENDENT_STONE_STAIRS.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_SMOOTH_STONE_STAIRS.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_COBBLESTONE_STAIRS.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_STONE_BRICK_STAIRS.get());
        this.dropSelf(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_STAIRS.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_STONE_TILE_STAIRS.get());
        this.dropSelf(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_STAIRS.get());

        this.dropSelf(CCBlocks.TRANSCENDENT_STONE_WALL.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_SMOOTH_STONE_WALL.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_COBBLESTONE_WALL.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_STONE_BRICK_WALL.get());
        this.dropSelf(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_WALL.get());
        this.dropSelf(CCBlocks.TRANSCENDENT_STONE_TILE_WALL.get());
        this.dropSelf(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_WALL.get());

        // Resource blocks
        this.dropSelf(CCBlocks.ANTHRACITE_BLOCK.get());
        this.dropSelf(CCBlocks.MAGNETITE_BLOCK.get());
        this.dropSelf(CCBlocks.COBALT_BLOCK.get());
        this.dropSelf(CCBlocks.IRIDIUM_BLOCK.get());
        this.dropSelf(CCBlocks.NEODYMIUM_BLOCK.get());
        this.dropSelf(CCBlocks.PALLADIUM_BLOCK.get());
        this.dropSelf(CCBlocks.PERPLEXIUM_BLOCK.get());
        this.dropSelf(CCBlocks.THUNDERSTEEL_BLOCK.get());
        this.dropSelf(CCBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(CCBlocks.TUNGSTEN_BLOCK.get());

        this.dropSelf(CCBlocks.RAW_COBALT_BLOCK.get());
        this.dropSelf(CCBlocks.RAW_IRIDIUM_BLOCK.get());
        this.dropSelf(CCBlocks.RAW_NEODYMIUM_BLOCK.get());
        this.dropSelf(CCBlocks.RAW_PALLADIUM_BLOCK.get());
        this.dropSelf(CCBlocks.RAW_TITANIUM_BLOCK.get());
        this.dropSelf(CCBlocks.RAW_TUNGSTEN_BLOCK.get());

        // Machines
        this.dropSelf(CCBlocks.FUSION_CORE.get());
        this.dropSelf(CCBlocks.T0_STARFORGE.get());
        this.dropSelf(CCBlocks.T1_CORE_SHIELDING.get());
        this.dropSelf(CCBlocks.T1_ELECTROMAGNET.get());
        this.dropSelf(CCBlocks.T1_HEAT_SINK.get());
        this.dropSelf(CCBlocks.T1_HOPPER.get());
        this.dropSelf(CCBlocks.T1_STARFORGE.get());
        this.dropSelf(CCBlocks.T1_S_HOPPER.get());
        this.dropSelf(CCBlocks.T2_CORE_SHIELDING.get());
        this.dropSelf(CCBlocks.T2_ELECTROMAGNET.get());
        this.dropSelf(CCBlocks.T2_HEAT_SINK.get());
        this.dropSelf(CCBlocks.T2_HOPPER.get());
        this.dropSelf(CCBlocks.T2_STARFORGE.get());
        this.dropSelf(CCBlocks.T2_S_HOPPER.get());
        this.dropSelf(CCBlocks.T3_CORE_SHIELDING.get());
        this.dropSelf(CCBlocks.T3_ELECTROMAGNET.get());
        this.dropSelf(CCBlocks.T3_HEAT_SINK.get());
        this.dropSelf(CCBlocks.T3_HOPPER.get());
        this.dropSelf(CCBlocks.T3_STARFORGE.get());
        this.dropSelf(CCBlocks.T3_S_HOPPER.get());

        // Gadgets
        this.dropSelf(CCBlocks.DIMENSIONAL_ANCHOR.get());
        this.dropSelf(CCBlocks.WORMHOLE_STABILIZER.get());
    }

    protected LootTable.Builder createOreDrops(Block block, Item item) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CCBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
