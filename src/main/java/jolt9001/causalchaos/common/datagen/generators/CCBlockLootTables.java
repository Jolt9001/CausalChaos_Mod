package jolt9001.causalchaos.common.datagen.generators;

import jolt9001.causalchaos.library.block.custom.CCBlocks;
import jolt9001.causalchaos.library.item.CCItems;
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

public class CCBlockLootTables extends BlockLootSubProvider {
    public CCBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Ores and Terrain
        this.add(CCBlocks.ANTHRACITE_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.ANTHRACITE_ORE.get(), CCItems.ANTHRACITE.get()));
        this.add(CCBlocks.COBALT_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.COBALT_ORE.get(), CCItems.RAW_COBALT.get()));
        this.add(CCBlocks.IRIDIUM_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.IRIDIUM_ORE.get(), CCItems.RAW_IRIDIUM.get()));
        this.add(CCBlocks.NEODYMIUM_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.NEODYMIUM_ORE.get(), CCItems.RAW_NEODYMIUM.get()));
        this.add(CCBlocks.PALLADIUM_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.PALLADIUM_ORE.get(), CCItems.RAW_PALLADIUM.get()));
        this.add(CCBlocks.TITANIUM_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.TITANIUM_ORE.get(), CCItems.RAW_TITANIUM.get()));
        this.add(CCBlocks.TUNGSTEN_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.TUNGSTEN_ORE.get(), CCItems.RAW_TUNGSTEN.get()));

        this.add(CCBlocks.DEEPSLATE_COBALT_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.DEEPSLATE_COBALT_ORE.get(), CCItems.RAW_COBALT.get()));
        this.add(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get(), CCItems.RAW_IRIDIUM.get()));
        this.add(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get(), CCItems.RAW_NEODYMIUM.get()));
        this.add(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get(), CCItems.RAW_PALLADIUM.get()));
        this.add(CCBlocks.DEEPSLATE_TITANIUM_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.DEEPSLATE_TITANIUM_ORE.get(), CCItems.RAW_TITANIUM.get()));
        this.add(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), block -> createCopperLikeOreDrops(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), CCItems.RAW_TUNGSTEN.get()));

        this.add(CCBlocks.REALMWEAVE_BLOCK.get(), block -> createCopperLikeOreDrops(CCBlocks.REALMWEAVE_BLOCK.get(), CCItems.ABYSSAL_THREAD.get()));

        // Resource blocks
        this.dropSelf(CCBlocks.ANTHRACITE_BLOCK.get());
        this.dropSelf(CCBlocks.COBALT_BLOCK.get());
        this.dropSelf(CCBlocks.IRIDIUM_BLOCK.get());
        this.dropSelf(CCBlocks.NEODYMIUM_BLOCK.get());
        this.dropSelf(CCBlocks.PALLADIUM_BLOCK.get());
        this.dropSelf(CCBlocks.PERPLEXIUM_BLOCK.get());
        this.dropSelf(CCBlocks.THUNDERSTEEL_BLOCK.get());
        this.dropSelf(CCBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(CCBlocks.TUNGSTEN_BLOCK.get());

        // Machines
        this.dropSelf(CCBlocks.T0_STARFORGE.get());
        this.dropSelf(CCBlocks.T1_STARFORGE.get());
        this.dropSelf(CCBlocks.T2_STARFORGE.get());
        this.dropSelf(CCBlocks.T3_STARFORGE.get());

        // Gadgets
        this.dropSelf(CCBlocks.DIMENSIONAL_ANCHOR.get());
        this.dropSelf(CCBlocks.WORMHOLE_STABILIZER.get());
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block block, Item item) {
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

}
