package jolt9001.causalchaos.common.datagen.tags;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.datagen.tags.compat.ModdedBlockTagGenerator;
import jolt9001.causalchaos.init.CCBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends ModdedBlockTagGenerator {
    // Storage Blocks
    public static final TagKey<Block> STORAGE_BLOCKS_ANTHRACITE = BlockTags.create(CausalChaos.prefix("storage_blocks/anthracite"));
    public static final TagKey<Block> STORAGE_BLOCKS_MAGNETITE = BlockTags.create(CausalChaos.prefix("storage_blocks/magnetite"));
    public static final TagKey<Block> STORAGE_BLOCKS_COBALT = BlockTags.create(CausalChaos.prefix("storage_blocks/cobalt"));
    public static final TagKey<Block> STORAGE_BLOCKS_IRIDIUM = BlockTags.create(CausalChaos.prefix("storage_blocks/iridium"));
    public static final TagKey<Block> STORAGE_BLOCKS_NEODYMIUM = BlockTags.create(CausalChaos.prefix("storage_blocks/neodymium"));
    public static final TagKey<Block> STORAGE_BLOCKS_PALLADIUM = BlockTags.create(CausalChaos.prefix("storage_blocks/palladium"));
    public static final TagKey<Block> STORAGE_BLOCKS_PERPLEXIUM = BlockTags.create(CausalChaos.prefix("storage_blocks/perplexium"));
    public static final TagKey<Block> STORAGE_BLOCKS_THUNDERSTEEL = BlockTags.create(CausalChaos.prefix("storage_blocks/thundersteel"));
    public static final TagKey<Block> STORAGE_BLOCKS_TITANIUM = BlockTags.create(CausalChaos.prefix("storage_blocks/titanium"));
    public static final TagKey<Block> STORAGE_BLOCKS_TUNGSTEN = BlockTags.create(CausalChaos.prefix("storage_blocks/tungsten"));

    // Raw Storage Blocks
    public static final TagKey<Block> STORAGE_RAW_COBALT = BlockTags.create(CausalChaos.prefix("storage_blocks/raw_cobalt"));
    public static final TagKey<Block> STORAGE_RAW_IRIDIUM = BlockTags.create(CausalChaos.prefix("storage_blocks/raw_iridium"));
    public static final TagKey<Block> STORAGE_RAW_NEODYMIUM = BlockTags.create(CausalChaos.prefix("storage_blocks/raw_neodymium"));
    public static final TagKey<Block> STORAGE_RAW_PALLADIUM = BlockTags.create(CausalChaos.prefix("storage_blocks/raw_palladium"));
    public static final TagKey<Block> STORAGE_RAW_TITANIUM = BlockTags.create(CausalChaos.prefix("storage_blocks/raw_titanium"));
    public static final TagKey<Block> STORAGE_RAW_TUNGSTEN = BlockTags.create(CausalChaos.prefix("storage_blocks/raw_tungsten"));

    // Ores
    public static final TagKey<Block> ORES_COBALT = BlockTags.create(CausalChaos.prefix("ores/cobalt"));
    public static final TagKey<Block> ORES_IRIDIUM = BlockTags.create(CausalChaos.prefix("ores/iridium"));
    public static final TagKey<Block> ORES_NEODYMIUM = BlockTags.create(CausalChaos.prefix("ores/neodymium"));
    public static final TagKey<Block> ORES_PALLADIUM = BlockTags.create(CausalChaos.prefix("ores/palladium"));
    public static final TagKey<Block> ORES_TITANIUM = BlockTags.create(CausalChaos.prefix("ores/titanium"));
    public static final TagKey<Block> ORES_TUNGSTEN = BlockTags.create(CausalChaos.prefix("ores/tungsten"));

    // Special Ores
    public static final TagKey<Block> ORES_ANTHRACITE = BlockTags.create(CausalChaos.prefix("ores/anthracite")); // Only spawns in Sky Island dimension
    public static final TagKey<Block> ORES_MAGNETITE = BlockTags.create(CausalChaos.prefix("ores/magnetite")); // Only spawns in Sky Island dimension

    // Ore Replaceables
    public static final TagKey<Block> TRANS_STONE_ORES_REPLACEABLES = BlockTags.create(CausalChaos.prefix("blocks/trans_stone_ores_replaceables")); // Transcendent's Plain Stone ores
    public static final TagKey<Block> TRANS_DEEPSTONE_ORES_REPLACEABLES = BlockTags.create(CausalChaos.prefix("blocks/trans_deepstone_ores_replaceables"));
    public static final TagKey<Block> REALMWEAVE_ORES_REPLACEABLES = BlockTags.create(CausalChaos.prefix("blocks/realmweave_ores_replaceables")); // Limbo ores

    // Starforge Machine Blocks
    public static final TagKey<Block> FUSION_CORE = BlockTags.create(CausalChaos.prefix("machines/fusion_core"));
    public static final TagKey<Block> STARFORGES = BlockTags.create(CausalChaos.prefix("machines/starforges"));
    public static final TagKey<Block> HEAT_SINKS = BlockTags.create(CausalChaos.prefix("machines/heat_sinks"));
    public static final TagKey<Block> ELECTROMAGNETS = BlockTags.create(CausalChaos.prefix("machines/electromagnets"));
    public static final TagKey<Block> CORE_SHIELDS = BlockTags.create(CausalChaos.prefix("machines/core_shields"));
    public static final TagKey<Block> HOPPERS = BlockTags.create(CausalChaos.prefix("machines/hoppers"));
    public static final TagKey<Block> S_HOPPERS = BlockTags.create(CausalChaos.prefix("machines/s_hoppers"));


    // Utility Machine Blocks
    public static final TagKey<Block> DIMENSION_ANCHOR = BlockTags.create(CausalChaos.prefix("machines/dimensional_anchor"));
    public static final TagKey<Block> STABLE_WORMHOLE = BlockTags.create(CausalChaos.prefix("machines/wormhole_stabilizer"));

    // Other Blocks
    public static final TagKey<Block> QUANTUM_FABRIC = BlockTags.create(CausalChaos.prefix("quantum_fabric"));
    public static final TagKey<Block> REALMWEAVE = BlockTags.create(CausalChaos.prefix("realmweave_block"));
    public static final TagKey<Block> TRANSCENDENT_PORTAL = BlockTags.create(CausalChaos.prefix("transcendent_portal_block"));

    // Tool requirement tag
    public static final TagKey<Block> NEEDS_THUNDERSTEEL_TOOL = BlockTags.create(CausalChaos.prefix("needs_thundersteel_tool"));
    public static final TagKey<Block> NEEDS_INFUSED_THUNDERSTEEL_TOOL = BlockTags.create(CausalChaos.prefix("needs_infused_thundersteel_tool"));
    public static final TagKey<Block> NEEDS_PERPLEXIUM_TOOL = BlockTags.create(CausalChaos.prefix("needs_perplexium_tool"));


    public BlockTagGenerator(PackOutput out, CompletableFuture<HolderLookup.Provider> future, ExistingFileHelper help) {
        super(out, future, help);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider prov) {
        super.addTags(prov);

        // Material Storage
        tag(STORAGE_BLOCKS_ANTHRACITE).add(CCBlocks.ANTHRACITE_BLOCK.get());
        tag(STORAGE_BLOCKS_MAGNETITE).add(CCBlocks.MAGNETITE_BLOCK.get());
        tag(STORAGE_BLOCKS_COBALT).add(CCBlocks.COBALT_BLOCK.get());
        tag(STORAGE_BLOCKS_IRIDIUM).add(CCBlocks.IRIDIUM_BLOCK.get());
        tag(STORAGE_BLOCKS_NEODYMIUM).add(CCBlocks.NEODYMIUM_BLOCK.get());
        tag(STORAGE_BLOCKS_PALLADIUM).add(CCBlocks.PALLADIUM_BLOCK.get());
        tag(STORAGE_BLOCKS_PERPLEXIUM).add(CCBlocks.PERPLEXIUM_BLOCK.get());
        tag(STORAGE_BLOCKS_THUNDERSTEEL).add(CCBlocks.THUNDERSTEEL_BLOCK.get());
        tag(STORAGE_BLOCKS_TITANIUM).add(CCBlocks.TITANIUM_BLOCK.get());
        tag(STORAGE_BLOCKS_TUNGSTEN).add(CCBlocks.TUNGSTEN_BLOCK.get());
        tag(BlockTags.BEACON_BASE_BLOCKS).addTags(
                STORAGE_BLOCKS_COBALT, STORAGE_BLOCKS_IRIDIUM, STORAGE_BLOCKS_PALLADIUM, STORAGE_BLOCKS_TITANIUM,
                STORAGE_BLOCKS_TUNGSTEN, STORAGE_BLOCKS_THUNDERSTEEL, STORAGE_BLOCKS_PERPLEXIUM
        );

        tag(STORAGE_RAW_COBALT).add(CCBlocks.RAW_COBALT_BLOCK.get());
        tag(STORAGE_RAW_IRIDIUM).add(CCBlocks.RAW_IRIDIUM_BLOCK.get());
        tag(STORAGE_RAW_NEODYMIUM).add(CCBlocks.RAW_NEODYMIUM_BLOCK.get());
        tag(STORAGE_RAW_PALLADIUM).add(CCBlocks.RAW_PALLADIUM_BLOCK.get());
        tag(STORAGE_RAW_TITANIUM).add(CCBlocks.RAW_TITANIUM_BLOCK.get());
        tag(STORAGE_RAW_TUNGSTEN).add(CCBlocks.RAW_TUNGSTEN_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTags(
                STORAGE_BLOCKS_ANTHRACITE, STORAGE_BLOCKS_MAGNETITE, STORAGE_BLOCKS_COBALT, STORAGE_BLOCKS_IRIDIUM,
                STORAGE_BLOCKS_NEODYMIUM, STORAGE_BLOCKS_PALLADIUM, STORAGE_BLOCKS_TITANIUM, STORAGE_BLOCKS_TUNGSTEN, STORAGE_RAW_COBALT,
                STORAGE_RAW_IRIDIUM, STORAGE_RAW_NEODYMIUM, STORAGE_RAW_PALLADIUM, STORAGE_RAW_TITANIUM,
                STORAGE_RAW_TUNGSTEN, STORAGE_BLOCKS_THUNDERSTEEL, STORAGE_BLOCKS_PERPLEXIUM
        );

        // Ores
        tag(ORES_ANTHRACITE).add(CCBlocks.ANTHRACITE_ORE.get());
        tag(ORES_MAGNETITE).add(CCBlocks.MAGNETITE_ORE.get());
        tag(ORES_COBALT).add(CCBlocks.COBALT_ORE.get(), CCBlocks.DEEPSLATE_COBALT_ORE.get()/*, CCBlocks.TRANSCENDENT_COBALT_ORE.get()*/);
        tag(ORES_IRIDIUM).add(CCBlocks.IRIDIUM_ORE.get(), CCBlocks.DEEPSLATE_IRIDIUM_ORE.get()/*, CCBlocks.TRANSCENDENT_IRIDIUM_ORE.get()*/);
        tag(ORES_NEODYMIUM).add(CCBlocks.NEODYMIUM_ORE.get(), CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get()/*, CCBlocks.TRANSCENDENT_NEODYMIUM_ORE.get()*/);
        tag(ORES_PALLADIUM).add(CCBlocks.PALLADIUM_ORE.get(), CCBlocks.DEEPSLATE_PALLADIUM_ORE.get()/*, CCBlocks.TRANSCENDENT_PALLADIUM_ORE.get()*/);
        tag(ORES_TITANIUM).add(CCBlocks.TITANIUM_ORE.get(), CCBlocks.DEEPSLATE_TITANIUM_ORE.get()/*, CCBlocks.TRANSCENDENT_TITANIUM_ORE.get()*/);
        tag(ORES_TUNGSTEN).add(CCBlocks.TUNGSTEN_ORE.get(), CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get()/*, CCBlocks.TRANSCENDENT_TUNGSTEN_ORE.get()*/);

        // Starforge Blocks
        tag(FUSION_CORE).add(CCBlocks.FUSION_CORE.get());
        tag(STARFORGES).add(CCBlocks.T0_STARFORGE.get(), CCBlocks.T1_STARFORGE.get(), CCBlocks.T2_STARFORGE.get(), CCBlocks.T3_STARFORGE.get());
        tag(HEAT_SINKS).add(CCBlocks.T1_HEAT_SINK.get(), CCBlocks.T2_HEAT_SINK.get(), CCBlocks.T3_HEAT_SINK.get());
        tag(CORE_SHIELDS).add(CCBlocks.T1_CORE_SHIELDING.get(), CCBlocks.T2_CORE_SHIELDING.get(), CCBlocks.T3_CORE_SHIELDING.get());
        tag(ELECTROMAGNETS).add(
                CCBlocks.T1_ELECTROMAGNET.get(), CCBlocks.T1_HOPPER.get(), CCBlocks.T1_S_HOPPER.get(),
                CCBlocks.T2_ELECTROMAGNET.get(), CCBlocks.T2_HOPPER.get(), CCBlocks.T2_S_HOPPER.get(),
                CCBlocks.T3_ELECTROMAGNET.get(), CCBlocks.T3_HOPPER.get(), CCBlocks.T3_S_HOPPER.get());
        tag(HOPPERS).add(
                CCBlocks.T1_HOPPER.get(), CCBlocks.T1_S_HOPPER.get(),
                CCBlocks.T2_HOPPER.get(), CCBlocks.T2_S_HOPPER.get(),
                CCBlocks.T3_HOPPER.get(), CCBlocks.T3_S_HOPPER.get());
        tag(S_HOPPERS).add(CCBlocks.T1_S_HOPPER.get(), CCBlocks.T2_S_HOPPER.get(), CCBlocks.T3_S_HOPPER.get());

        // Utility
        tag(DIMENSION_ANCHOR).add(CCBlocks.DIMENSIONAL_ANCHOR.get());
        tag(STABLE_WORMHOLE).add(CCBlocks.WORMHOLE_STABILIZER.get());

        // Misc Blocks
        tag(QUANTUM_FABRIC).add(CCBlocks.QUANTUM_FABRIC.get());
        tag(REALMWEAVE).add(CCBlocks.REALMWEAVE_BLOCK.get());

        // Ores
        tag(Tags.Blocks.ORES).add(CCBlocks.ANTHRACITE_ORE.get(), CCBlocks.MAGNETITE_ORE.get());
        tag(Tags.Blocks.ORES).addTags(ORES_COBALT, ORES_IRIDIUM, ORES_NEODYMIUM, ORES_PALLADIUM, ORES_TITANIUM, ORES_TUNGSTEN);
        tag(Tags.Blocks.ORE_RATES_SINGULAR).addTags(ORES_COBALT, ORES_IRIDIUM, ORES_NEODYMIUM, ORES_PALLADIUM, ORES_TITANIUM, ORES_TUNGSTEN);
        tag(Tags.Blocks.ORE_RATES_SINGULAR).add(CCBlocks.ANTHRACITE_ORE.get(), CCBlocks.MAGNETITE_ORE.get());

        // Tool requirements
        tag(BlockTags.NEEDS_STONE_TOOL);
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                CCBlocks.NEODYMIUM_ORE.get(), CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get(),
                CCBlocks.NEODYMIUM_BLOCK.get(), CCBlocks.RAW_NEODYMIUM_BLOCK.get(),
                CCBlocks.PALLADIUM_ORE.get(), CCBlocks.DEEPSLATE_PALLADIUM_ORE.get(),
                CCBlocks.PALLADIUM_BLOCK.get(), CCBlocks.RAW_PALLADIUM_BLOCK.get()
        );
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(
                CCBlocks.COBALT_ORE.get(), CCBlocks.DEEPSLATE_COBALT_ORE.get(),
                CCBlocks.COBALT_BLOCK.get(), CCBlocks.RAW_COBALT_BLOCK.get(),
                CCBlocks.TITANIUM_ORE.get(), CCBlocks.DEEPSLATE_TITANIUM_ORE.get(),
                CCBlocks.TITANIUM_BLOCK.get(), CCBlocks.RAW_TITANIUM_BLOCK.get()
        );
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(
                CCBlocks.IRIDIUM_ORE.get(), CCBlocks.DEEPSLATE_IRIDIUM_ORE.get(),
                CCBlocks.IRIDIUM_BLOCK.get(), CCBlocks.RAW_IRIDIUM_BLOCK.get(),
                CCBlocks.TUNGSTEN_ORE.get(),  CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get(),
                CCBlocks.TUNGSTEN_BLOCK.get(), CCBlocks.RAW_TUNGSTEN_BLOCK.get(),
                CCBlocks.THUNDERSTEEL_BLOCK.get()
        );
        tag(NEEDS_THUNDERSTEEL_TOOL);
        tag(NEEDS_INFUSED_THUNDERSTEEL_TOOL).add(CCBlocks.PERPLEXIUM_BLOCK.get(), CCBlocks.QUANTUM_FABRIC.get());
        tag(NEEDS_PERPLEXIUM_TOOL);

        tag(BlockTags.MINEABLE_WITH_AXE);
        tag(BlockTags.MINEABLE_WITH_HOE);
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                CCBlocks.ANTHRACITE_ORE.get(), CCBlocks.ANTHRACITE_BLOCK.get(),
                CCBlocks.MAGNETITE_ORE.get(), CCBlocks.MAGNETITE_BLOCK.get(),
                CCBlocks.COBALT_ORE.get(), CCBlocks.DEEPSLATE_COBALT_ORE.get(), CCBlocks.RAW_COBALT_BLOCK.get(), CCBlocks.COBALT_BLOCK.get(),
                CCBlocks.IRIDIUM_ORE.get(), CCBlocks.DEEPSLATE_IRIDIUM_ORE.get(), CCBlocks.RAW_IRIDIUM_BLOCK.get(), CCBlocks.IRIDIUM_BLOCK.get(),
                CCBlocks.NEODYMIUM_ORE.get(), CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get(), CCBlocks.RAW_NEODYMIUM_BLOCK.get(), CCBlocks.NEODYMIUM_BLOCK.get(),
                CCBlocks.PALLADIUM_ORE.get(), CCBlocks.DEEPSLATE_PALLADIUM_ORE.get(), CCBlocks.RAW_PALLADIUM_BLOCK.get(), CCBlocks.PALLADIUM_BLOCK.get(),
                CCBlocks.PERPLEXIUM_BLOCK.get(), CCBlocks.THUNDERSTEEL_BLOCK.get(),
                CCBlocks.TITANIUM_ORE.get(), CCBlocks.DEEPSLATE_TITANIUM_ORE.get(), CCBlocks.RAW_TITANIUM_BLOCK.get(), CCBlocks.TITANIUM_BLOCK.get(),
                CCBlocks.TUNGSTEN_ORE.get(), CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), CCBlocks.RAW_TUNGSTEN_BLOCK.get(), CCBlocks.TUNGSTEN_BLOCK.get(),
                CCBlocks.T0_STARFORGE.get(), CCBlocks.T1_STARFORGE.get(), CCBlocks.T2_STARFORGE.get(), CCBlocks.T3_STARFORGE.get(),
                CCBlocks.FUSION_CORE.get(),
                CCBlocks.T1_HEAT_SINK.get(), CCBlocks.T2_HEAT_SINK.get(), CCBlocks.T3_HEAT_SINK.get(),
                CCBlocks.T1_ELECTROMAGNET.get(), CCBlocks.T2_ELECTROMAGNET.get(), CCBlocks.T3_ELECTROMAGNET.get(),
                CCBlocks.T1_HOPPER.get(), CCBlocks.T2_HOPPER.get(), CCBlocks.T3_HOPPER.get(),
                CCBlocks.T1_S_HOPPER.get(), CCBlocks.T2_S_HOPPER.get(), CCBlocks.T3_S_HOPPER.get(),
                CCBlocks.T1_CORE_SHIELDING.get(), CCBlocks.T2_CORE_SHIELDING.get(), CCBlocks.T3_CORE_SHIELDING.get(),
                CCBlocks.DIMENSIONAL_ANCHOR.get(), CCBlocks.WORMHOLE_STABILIZER.get(), CCBlocks.QUANTUM_FABRIC.get(), CCBlocks.REALMWEAVE_BLOCK.get(),
                CCBlocks.TRANSCENDENT_STONE.get(), CCBlocks.TRANSCENDENT_COBBLESTONE.get(), CCBlocks.TRANSCENDENT_SMOOTH_STONE.get(),
                CCBlocks.TRANSCENDENT_STONE_BRICKS.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICKS.get(), CCBlocks.CHISELED_TRANSCENDENT_STONE_BRICKS.get(),
                CCBlocks.TRANSCENDENT_STONE_TILES.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_TILES.get(),
                CCBlocks.TRANSCENDENT_STONE_SLAB.get(), CCBlocks.TRANSCENDENT_COBBLESTONE_SLAB.get(), CCBlocks.TRANSCENDENT_SMOOTH_STONE_SLAB.get(),
                CCBlocks.TRANSCENDENT_STONE_BRICK_SLAB.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_SLAB.get(),
                CCBlocks.TRANSCENDENT_STONE_TILE_SLAB.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_SLAB.get(),
                CCBlocks.TRANSCENDENT_STONE_STAIRS.get(), CCBlocks.TRANSCENDENT_COBBLESTONE_STAIRS.get(), CCBlocks.TRANSCENDENT_SMOOTH_STONE_STAIRS.get(),
                CCBlocks.TRANSCENDENT_STONE_BRICK_STAIRS.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_STAIRS.get(),
                CCBlocks.TRANSCENDENT_STONE_TILE_STAIRS.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_STAIRS.get(),
                CCBlocks.TRANSCENDENT_STONE_WALL.get(), CCBlocks.TRANSCENDENT_COBBLESTONE_WALL.get(), CCBlocks.TRANSCENDENT_SMOOTH_STONE_WALL.get(),
                CCBlocks.TRANSCENDENT_STONE_BRICK_WALL.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_WALL.get(),
                CCBlocks.TRANSCENDENT_STONE_TILE_WALL.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_WALL.get()
        );
        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                CCBlocks.TRANSCENDENT_SOIL.get(), CCBlocks.TRANSCENDENT_TURF.get()
        );

        // Portal
        tag(TRANSCENDENT_PORTAL).add(CCBlocks.TRANSCENDENT_GATEWAY.get());
        tag(BlockTags.PORTALS).addTag(TRANSCENDENT_PORTAL);

        // Terrain
        tag(TRANS_STONE_ORES_REPLACEABLES).add(CCBlocks.TRANSCENDENT_STONE.get());
        tag(TRANS_DEEPSTONE_ORES_REPLACEABLES).add(CCBlocks.TRANSCENDENT_DEEPSTONE.get());
        tag(REALMWEAVE_ORES_REPLACEABLES).add(CCBlocks.REALMWEAVE_BLOCK.get());

        // Decorative
        tag(BlockTags.SLABS).add(
                CCBlocks.TRANSCENDENT_STONE_SLAB.get(), CCBlocks.TRANSCENDENT_COBBLESTONE_SLAB.get(), CCBlocks.TRANSCENDENT_SMOOTH_STONE_SLAB.get(),
                CCBlocks.TRANSCENDENT_STONE_BRICK_SLAB.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_SLAB.get(),
                CCBlocks.TRANSCENDENT_STONE_TILE_SLAB.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_SLAB.get()
        );
        tag(BlockTags.STAIRS).add(
                CCBlocks.TRANSCENDENT_STONE_STAIRS.get(), CCBlocks.TRANSCENDENT_COBBLESTONE_STAIRS.get(), CCBlocks.TRANSCENDENT_SMOOTH_STONE_STAIRS.get(),
                CCBlocks.TRANSCENDENT_STONE_BRICK_STAIRS.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_STAIRS.get(),
                CCBlocks.TRANSCENDENT_STONE_TILE_STAIRS.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_STAIRS.get()
        );
        tag(BlockTags.WALLS).add(
                CCBlocks.TRANSCENDENT_STONE_WALL.get(), CCBlocks.TRANSCENDENT_COBBLESTONE_WALL.get(), CCBlocks.TRANSCENDENT_SMOOTH_STONE_WALL.get(),
                CCBlocks.TRANSCENDENT_STONE_BRICK_WALL.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_WALL.get(),
                CCBlocks.TRANSCENDENT_STONE_TILE_WALL.get(), CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_WALL.get()
        );
    }
}
