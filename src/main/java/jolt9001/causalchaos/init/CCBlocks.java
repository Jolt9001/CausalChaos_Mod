package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class CCBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CausalChaos.MODID);
    // Environmental (ores, terrain, etc)
        // Stone Ores
    public static final RegistryObject<Block> ANTHRACITE_ORE = BLOCKS.register("anthracite_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> IRIDIUM_ORE = BLOCKS.register("iridium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> NEODYMIUM_ORE = BLOCKS.register("neodymium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> PALLADIUM_ORE = BLOCKS.register("palladium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> TITANIUM_ORE = BLOCKS.register("titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> TUNGSTEN_ORE = BLOCKS.register("tungsten_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).
                    requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

        // Deepslate Ores
    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = BLOCKS.register("deepslate_cobalt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_IRIDIUM_ORE = BLOCKS.register("deepslate_iridium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_NEODYMIUM_ORE = BLOCKS.register("deepslate_neodymium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_PALLADIUM_ORE = BLOCKS.register("deepslate_palladium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = BLOCKS.register("deepslate_titanium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = BLOCKS.register("deepslate_tungsten_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).strength(3f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    // Raw ore blocks
    public static final RegistryObject<Block> RAW_COBALT_BLOCK = BLOCKS.register("raw_cobalt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> RAW_IRIDIUM_BLOCK = BLOCKS.register("raw_iridium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> RAW_NEODYMIUM_BLOCK = BLOCKS.register("raw_neodymium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> RAW_PALLADIUM_BLOCK = BLOCKS.register("raw_palladium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> RAW_ITANIUM_BLOCK = BLOCKS.register("raw_titanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK = BLOCKS.register("raw_tungsten_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).noOcclusion()));


    // Terrain Blocks
    public static final RegistryObject<Block> REALMWEAVE_BLOCK = BLOCKS.register("realmweave_block",
                () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> QUANTUM_FABRIC = BLOCKS.register("quantum_fabric",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    // Resource
    public static final RegistryObject<Block> ANTHRACITE_BLOCK = BLOCKS.register("anthracite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> COBALT_BLOCK = BLOCKS.register("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> IRIDIUM_BLOCK = BLOCKS.register("iridium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> NEODYMIUM_BLOCK = BLOCKS.register("neodymium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> PALLADIUM_BLOCK = BLOCKS.register("palladium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> PERPLEXIUM_BLOCK = BLOCKS.register("perplexium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> THUNDERSTEEL_BLOCK = BLOCKS.register("thundersteel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = BLOCKS.register("tungsten_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    // Machine
    public static final RegistryObject<Block> T0_STARFORGE = BLOCKS.register("starforge_tier_0",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
    public static final RegistryObject<Block> T1_STARFORGE = BLOCKS.register("starforge_tier_1",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
    public static final RegistryObject<Block> T2_STARFORGE = BLOCKS.register("starforge_tier_2",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
    public static final RegistryObject<Block> T3_STARFORGE = BLOCKS.register("starforge_tier_3",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
    public static final RegistryObject<Block> DIMENSIONAL_ANCHOR = BLOCKS.register("dimensional_anchor",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> WORMHOLE_STABILIZER = BLOCKS.register("wormhole_stabilizer",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    // Multiblock Components
    public static final RegistryObject<Block> FUSION_CORE = BLOCKS.register("fusion_core",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T1_HEAT_SINK = BLOCKS.register("t1_heat_sink",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T2_HEAT_SINK = BLOCKS.register("t2_heat_sink",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T3_HEAT_SINK = BLOCKS.register("t3_heat_sink",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T1_ELECTROMAGNET = BLOCKS.register("t1_electromagnet",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T2_ELECTROMAGNET = BLOCKS.register("t2_electromagnet",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T3_ELECTROMAGNET = BLOCKS.register("t3_electromagnet",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T1_ACCEPTOR = BLOCKS.register("t1_acceptor",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T2_ACCEPTOR = BLOCKS.register("t2_acceptor",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T3_ACCEPTOR = BLOCKS.register("t3_acceptor",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T1_CORE_SHIELDING = BLOCKS.register("t1_core_shielding",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T2_CORE_SHIELDING = BLOCKS.register("t2_core_shielding",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> T3_CORE_SHIELDING = BLOCKS.register("t3_core_shielding",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
