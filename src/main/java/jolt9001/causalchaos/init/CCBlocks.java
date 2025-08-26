package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.block.starforge.StarforgeBlock;
import jolt9001.causalchaos.library.portal.TranscendentPortalBlock;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public final class CCBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CausalChaos.MODID);
    // Environmental (ores, terrain, etc)
        // Stone Ores
    public static final RegistryObject<Block> ANTHRACITE_ORE = registerBlock("anthracite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> MAGNETITE_ORE = registerBlock("magnetite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> IRIDIUM_ORE = registerBlock("iridium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> NEODYMIUM_ORE = registerBlock("neodymium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> PALLADIUM_ORE = registerBlock("palladium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TUNGSTEN_ORE = registerBlock("tungsten_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), ConstantInt.of(0)));

        // Deepslate Ores
    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> DEEPSLATE_IRIDIUM_ORE = registerBlock("deepslate_iridium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> DEEPSLATE_NEODYMIUM_ORE = registerBlock("deepslate_neodymium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> DEEPSLATE_PALLADIUM_ORE = registerBlock("deepslate_palladium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = registerBlock("deepslate_tungsten_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));

    // Terrain Blocks
    public static final RegistryObject<Block> REALMWEAVE_BLOCK = registerBlock("realmweave_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> TRANSCENDENT_SOIL = registerBlock("transcendent_dirt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> TRANSCENDENT_TURF = registerBlock("transcendent_grass_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> TRANSCENDENT_STONE = registerBlock("transcendent_stone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE = registerBlock("transcendent_deepstone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

    // Environmental blocks (NYI)
        // Skourainei Biome
    /*
    public static final RegistryObject<Block> EVENOS_LOG = registerBlock("evenos_log",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LOG)));
    public static final RegistryObject<Block> EVENOS_PLANKS = registerBlock("evenos_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> EVENOS_LEAVES = registerBlock("evenos_leaves",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_LEAVES)));
    public static final RegistryObject<Block> EVENOS_SAPLING = registerBlock("evenos_sapling",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_SAPLING)));

     */

    // Transcendent Stone Ores (NYI)
    public static final RegistryObject<Block> TRANSCENDENT_COBALT_ORE = registerBlock("transcendent_cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_STONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_IRIDIUM_ORE = registerBlock("transcendent_iridium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_STONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_NEODYMIUM_ORE = registerBlock("transcendent_neodymium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_STONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_PALLADIUM_ORE = registerBlock("transcendent_palladium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_STONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_TITANIUM_ORE = registerBlock("transcendent_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_STONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_TUNGSTEN_ORE = registerBlock("transcendent_tungsten_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_STONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));

    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_COBALT_ORE = registerBlock("transcendent_deepstone_cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_DEEPSTONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_IRIDIUM_ORE = registerBlock("transcendent_deepstone_iridium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_DEEPSTONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_NEODYMIUM_ORE = registerBlock("transcendent_deepstone_neodymium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_DEEPSTONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_PALLADIUM_ORE = registerBlock("transcendent_deepstone_palladium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_DEEPSTONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_TITANIUM_ORE = registerBlock("transcendent_deepstone_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_DEEPSTONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_TUNGSTEN_ORE = registerBlock("transcendent_deepstone_tungsten_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(CCBlocks.TRANSCENDENT_DEEPSTONE.get()).strength(3f)
                    .requiresCorrectToolForDrops(), ConstantInt.of(0)));


    // Decoration Blocks
    public static final RegistryObject<Block> QUANTUM_FABRIC = registerBlock("quantum_fabric", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    public static final RegistryObject<Block> WARP_PAD = registerBlock("warp_pad", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CYAN_CARPET)));

    public static final RegistryObject<Block> TRANSCENDENT_STONE_SLAB = registerBlock("transcendent_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> TRANSCENDENT_STONE_STAIRS = registerBlock("transcendent_stone_stairs", () -> new StairBlock(() -> CCBlocks.TRANSCENDENT_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> TRANSCENDENT_STONE_WALL = registerBlock("transcendent_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_SLAB = registerBlock("transcendent_deepstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_STAIRS = registerBlock("transcendent_deepstone_stairs", () -> new StairBlock(() -> CCBlocks.TRANSCENDENT_DEEPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_WALL = registerBlock("transcendent_deepstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> TRANSCENDENT_SMOOTH_STONE = registerBlock("transcendent_smooth_stone_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> TRANSCENDENT_SMOOTH_STONE_SLAB = registerBlock("transcendent_smooth_stone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE_SLAB)));
    public static final RegistryObject<Block> TRANSCENDENT_SMOOTH_STONE_STAIRS = registerBlock("transcendent_smooth_stone_stairs", () -> new StairBlock( () -> CCBlocks.TRANSCENDENT_SMOOTH_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> TRANSCENDENT_SMOOTH_STONE_WALL = registerBlock("transcendent_smooth_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> POLISHED_TRANSCENDENT_DEEPSTONE = registerBlock("polished_transcendent_deepstone_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> POLISHED_TRANSCENDENT_DEEPSTONE_SLAB = registerBlock("polished_transcendent_deepstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> POLISHED_TRANSCENDENT_DEEPSTONE_STAIRS = registerBlock("polished_transcendent_deepstone_stairs", () -> new StairBlock(() -> CCBlocks.POLISHED_TRANSCENDENT_DEEPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> POLISHED_TRANSCENDENT_DEEPSTONE_WALL = registerBlock("polished_transcendent_deepstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> TRANSCENDENT_COBBLESTONE = registerBlock("transcendent_cobblestone_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<Block> TRANSCENDENT_COBBLESTONE_SLAB = registerBlock("transcendent_cobblestone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB)));
    public static final RegistryObject<Block> TRANSCENDENT_COBBLESTONE_STAIRS = registerBlock("transcendent_cobblestone_stairs", () -> new StairBlock(() -> CCBlocks.TRANSCENDENT_COBBLESTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS)));
    public static final RegistryObject<Block> TRANSCENDENT_COBBLESTONE_WALL = registerBlock("transcendent_cobblestone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> COBBLED_TRANSCENDENT_DEEPSTONE = registerBlock("cobbled_transcendent_deepstone_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> COBBLED_TRANSCENDENT_DEEPSTONE_SLAB = registerBlock("cobbled_transcendent_deepstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> COBBLED_TRANSCENDENT_DEEPSTONE_STAIRS = registerBlock("cobbled_transcendent_deepstone_stairs", () -> new StairBlock(() -> CCBlocks.COBBLED_TRANSCENDENT_DEEPSTONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> COBBLED_TRANSCENDENT_DEEPSTONE_WALL = registerBlock("cobbled_transcendent_deepstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> TRANSCENDENT_STONE_BRICKS = registerBlock("transcendent_stone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)));
    public static final RegistryObject<Block> TRANSCENDENT_STONE_BRICK_SLAB = registerBlock("transcendent_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> TRANSCENDENT_STONE_BRICK_STAIRS = registerBlock("transcendent_stone_brick_stairs", () -> new StairBlock(() -> CCBlocks.TRANSCENDENT_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> TRANSCENDENT_STONE_BRICK_WALL = registerBlock("transcendent_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));
    public static final RegistryObject<Block> CHISELED_TRANSCENDENT_STONE_BRICKS = registerBlock("chiseled_transcendent_stone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_STONE_BRICKS)));

    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_BRICKS = registerBlock("transcendent_deepstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_BRICK_SLAB = registerBlock("transcendent_deepstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_BRICK_STAIRS = registerBlock("transcendent_deepstone_brick_stairs", () -> new StairBlock(() -> CCBlocks.TRANSCENDENT_DEEPSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_BRICK_WALL = registerBlock("transcendent_deepstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));
    public static final RegistryObject<Block> CHISELED_TRANSCENDENT_DEEPSTONE_BRICKS = registerBlock("chiseled_transcendent_deepstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_STONE_BRICKS)));

    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_STONE_BRICKS = registerBlock("cracked_transcendent_stone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_STONE_BRICK_SLAB = registerBlock("cracked_transcendent_stone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_STONE_BRICK_STAIRS = registerBlock("cracked_transcendent_stone_brick_stairs", () -> new StairBlock(() -> CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_SLAB)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_STONE_BRICK_WALL = registerBlock("cracked_transcendent_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));

    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_DEEPSTONE_BRICKS = registerBlock("cracked_transcendent_deepstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_DEEPSTONE_BRICK_SLAB = registerBlock("cracked_transcendent_deepstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_DEEPSTONE_BRICK_STAIRS = registerBlock("cracked_transcendent_deepstone_brick_stairs", () -> new StairBlock(() -> CCBlocks.CRACKED_TRANSCENDENT_DEEPSTONE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_DEEPSTONE_BRICK_WALL = registerBlock("cracked_transcendent_deepstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> TRANSCENDENT_STONE_TILES = registerBlock("transcendent_stone_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> TRANSCENDENT_STONE_TILE_SLAB = registerBlock("transcendent_stone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILE_SLAB)));
    public static final RegistryObject<Block> TRANSCENDENT_STONE_TILE_STAIRS = registerBlock("transcendent_stone_tile_stairs", () -> new StairBlock(() -> CCBlocks.TRANSCENDENT_STONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILE_STAIRS)));
    public static final RegistryObject<Block> TRANSCENDENT_STONE_TILE_WALL = registerBlock("transcendent_stone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILE_WALL)));

    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_TILES = registerBlock("transcendent_deepstone_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_TILE_SLAB = registerBlock("transcendent_deepstone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_TILE_STAIRS = registerBlock("transcendent_deepstone_tile_stairs", () -> new StairBlock(() -> CCBlocks.TRANSCENDENT_DEEPSTONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> TRANSCENDENT_DEEPSTONE_TILE_WALL = registerBlock("transcendent_deepstone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_STONE_TILES = registerBlock("cracked_transcendent_stone_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_STONE_TILE_SLAB = registerBlock("cracked_transcendent_stone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILE_SLAB)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_STONE_TILE_STAIRS = registerBlock("cracked_transcendent_stone_tile_stairs", () -> new StairBlock(() -> CCBlocks.CRACKED_TRANSCENDENT_STONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILE_STAIRS)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_STONE_TILE_WALL = registerBlock("cracked_transcendent_stone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILE_WALL)));

    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_DEEPSTONE_TILES = registerBlock("cracked_transcendent_deepstone_tiles", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_DEEPSTONE_TILE_SLAB = registerBlock("cracked_transcendent_deepstone_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_DEEPSTONE_TILE_STAIRS = registerBlock("cracked_transcendent_deepstone_tile_stairs", () -> new StairBlock(() -> CCBlocks.CRACKED_TRANSCENDENT_DEEPSTONE_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> CRACKED_TRANSCENDENT_DEEPSTONE_TILE_WALL = registerBlock("cracked_transcendent_deepstone_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    // Portal Block
    public static final RegistryObject<Block> TRANSCENDENT_GATEWAY = registerBlock("transcendent_gateway",
            () -> new TranscendentPortalBlock(BlockBehaviour.Properties.of().noLootTable().noCollission().randomTicks().strength(-1.0f)
                    .sound(SoundType.GLASS).lightLevel(CCBlocks::lightLevel15).pushReaction(PushReaction.BLOCK).forceSolidOn()));

    // Resource
    public static final RegistryObject<Block> ANTHRACITE_BLOCK = registerBlock("anthracite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)));
    public static final RegistryObject<Block> MAGNETITE_BLOCK = registerBlock("magnetite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> IRIDIUM_BLOCK = registerBlock("iridium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> NEODYMIUM_BLOCK = registerBlock("neodymium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PALLADIUM_BLOCK = registerBlock("palladium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PERPLEXIUM_BLOCK = registerBlock("perplexium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> THUNDERSTEEL_BLOCK = registerBlock("thundersteel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_IRIDIUM_BLOCK = registerBlock("raw_iridium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_NEODYMIUM_BLOCK = registerBlock("raw_neodymium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_PALLADIUM_BLOCK = registerBlock("raw_palladium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK = registerBlock("raw_tungsten_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    // Machine
    public static final RegistryObject<Block> T0_STARFORGE = registerBlock("starforge0",
            () -> new StarforgeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), 0));
    public static final RegistryObject<Block> T1_STARFORGE = registerBlock("starforge1",
            () -> new StarforgeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), 1));
    public static final RegistryObject<Block> T2_STARFORGE = registerBlock("starforge2",
            () -> new StarforgeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), 2));
    public static final RegistryObject<Block> T3_STARFORGE = registerBlock("starforge3",
            () -> new StarforgeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), 3));

    public static final RegistryObject<Block> DIMENSIONAL_ANCHOR = registerBlock("dimensional_anchor",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> WORMHOLE_STABILIZER = registerBlock("wormhole_stabilizer",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    // Multiblock Components
    public static final RegistryObject<Block> FUSION_CORE = registerBlock("fusion_core",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> T1_HEAT_SINK = registerBlock("heat_sink1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T2_HEAT_SINK = registerBlock("heat_sink2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T3_HEAT_SINK = registerBlock("heat_sink3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> T1_ELECTROMAGNET = registerBlock("electromagnet1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T2_ELECTROMAGNET = registerBlock("electromagnet2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T3_ELECTROMAGNET = registerBlock("electromagnet3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> T1_HOPPER = registerBlock("hopper1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T2_HOPPER = registerBlock("hopper2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T3_HOPPER = registerBlock("hopper3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> T1_S_HOPPER = registerBlock("s_hopper1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T2_S_HOPPER = registerBlock("s_hopper2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T3_S_HOPPER = registerBlock("s_hopper3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> T1_CORE_SHIELDING = registerBlock("core_shield1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T2_CORE_SHIELDING = registerBlock("core_shield2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> T3_CORE_SHIELDING = registerBlock("core_shield3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return CCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static int lightLevel15(BlockState state) { return 15; }
    public static void register(IEventBus eventBus) { BLOCKS.register(eventBus); }
}
