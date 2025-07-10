package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.init.CCBlocks;
import jolt9001.causalchaos.init.CCItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider {
    public BlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Ores and Terrain
        add(CCBlocks.ANTHRACITE_ORE.get(), block -> createOreDrops(CCBlocks.ANTHRACITE_ORE.get(), CCItems.ANTHRACITE.get()));
        add(CCBlocks.MAGNETITE_ORE.get(), block -> createOreDrops(CCBlocks.MAGNETITE_ORE.get(), CCItems.MAGNETITE.get()));
        add(CCBlocks.COBALT_ORE.get(), block -> createOreDrops(CCBlocks.COBALT_ORE.get(), CCItems.RAW_COBALT.get()));
        add(CCBlocks.IRIDIUM_ORE.get(), block -> createOreDrops(CCBlocks.IRIDIUM_ORE.get(), CCItems.RAW_IRIDIUM.get()));
        add(CCBlocks.NEODYMIUM_ORE.get(), block -> createOreDrops(CCBlocks.NEODYMIUM_ORE.get(), CCItems.RAW_NEODYMIUM.get()));
        add(CCBlocks.PALLADIUM_ORE.get(), block -> createOreDrops(CCBlocks.PALLADIUM_ORE.get(), CCItems.RAW_PALLADIUM.get()));
        add(CCBlocks.TITANIUM_ORE.get(), block -> createOreDrops(CCBlocks.TITANIUM_ORE.get(), CCItems.RAW_TITANIUM.get()));
        add(CCBlocks.TUNGSTEN_ORE.get(), block -> createOreDrops(CCBlocks.TUNGSTEN_ORE.get(), CCItems.RAW_TUNGSTEN.get()));

        add(CCBlocks.DEEPSLATE_COBALT_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_COBALT_ORE.get(), CCItems.RAW_COBALT.get()));
        add(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get(), CCItems.RAW_IRIDIUM.get()));
        add(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get(), CCItems.RAW_NEODYMIUM.get()));
        add(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get(), CCItems.RAW_PALLADIUM.get()));
        add(CCBlocks.DEEPSLATE_TITANIUM_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_TITANIUM_ORE.get(), CCItems.RAW_TITANIUM.get()));
        add(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), block -> createOreDrops(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), CCItems.RAW_TUNGSTEN.get()));

        add(CCBlocks.REALMWEAVE_BLOCK.get(), block -> createOreDrops(CCBlocks.REALMWEAVE_BLOCK.get(), CCItems.ABYSSAL_THREAD.get()));

        // Resource blocks
        dropSelf(CCBlocks.ANTHRACITE_BLOCK.get());
        dropSelf(CCBlocks.COBALT_BLOCK.get());
        dropSelf(CCBlocks.IRIDIUM_BLOCK.get());
        dropSelf(CCBlocks.NEODYMIUM_BLOCK.get());
        dropSelf(CCBlocks.PALLADIUM_BLOCK.get());
        dropSelf(CCBlocks.PERPLEXIUM_BLOCK.get());
        dropSelf(CCBlocks.THUNDERSTEEL_BLOCK.get());
        dropSelf(CCBlocks.TITANIUM_BLOCK.get());
        dropSelf(CCBlocks.TUNGSTEN_BLOCK.get());

        // Machines
        dropSelf(CCBlocks.T0_STARFORGE.get());
        dropSelf(CCBlocks.T1_STARFORGE.get());
        dropSelf(CCBlocks.T2_STARFORGE.get());
        dropSelf(CCBlocks.T3_STARFORGE.get());

        // Gadgets
        dropSelf(CCBlocks.DIMENSIONAL_ANCHOR.get());
        dropSelf(CCBlocks.WORMHOLE_STABILIZER.get());
    }

    protected LootTable.Builder createOreDrops(Block block, Item item) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

}
