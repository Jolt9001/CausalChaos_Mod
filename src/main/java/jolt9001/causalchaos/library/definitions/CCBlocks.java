package jolt9001.causalchaos.library.definitions;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class CCBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CausalChaos.MODID);
    // Environmental (ores, terrain, etc)
        // Stone Ores
    public static final RegistryObject<Block> COBALT_ORE = BLOCKS.register("cobalt_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> IRIDIUM_ORE = BLOCKS.register("iridium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> NEODYMIUM_ORE = BLOCKS.register("neodymium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> PALLADIUM_ORE = BLOCKS.register("palladium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> TITANIUM_ORE = BLOCKS.register("titanium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> TUNGSTEN_ORE = BLOCKS.register("tungsten_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> ANTHRACITE_ORE = BLOCKS.register("anthracite_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).noOcclusion()));

        // Deepslate Ores
    public static final RegistryObject<Block> DEEPSLATE_COBALT_ORE = BLOCKS.register("deepslate_cobalt_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_IRIDIUM_ORE = BLOCKS.register("deepslate_iridium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_NEODYMIUM_ORE = BLOCKS.register("deepslate_neodymium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_PALLADIUM_ORE = BLOCKS.register("deepslate_palladium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = BLOCKS.register("deepslate_titanium_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).noOcclusion()));
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = BLOCKS.register("deepslate_tungsten_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE).noOcclusion()));

        // Terrain Blocks
    public static final RegistryObject<Block> REALMWEAVE_BLOCK = BLOCKS.register("realmweave_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    // Resource
    public static final RegistryObject<Block> COBALT_BLOCK = BLOCKS.register("cobalt_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> IRIDIUM_BLOCK = BLOCKS.register("iridium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> NEODYMIUM_BLOCK = BLOCKS.register("neodymium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> PALLADIUM_BLOCK = BLOCKS.register("palladium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> PERPLEXIUM_BLOCK = BLOCKS.register("perplexium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> THUNDERSTEEL_BLOCK = BLOCKS.register("thundersteel_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = BLOCKS.register("tungsten_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    // Machine
    public static final RegistryObject<Block> T0_STARFORGE = BLOCKS.register("starforge_tier_0", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
    public static final RegistryObject<Block> T1_STARFORGE = BLOCKS.register("starforge_tier_1", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
    public static final RegistryObject<Block> T2_STARFORGE = BLOCKS.register("starforge_tier_2", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
    public static final RegistryObject<Block> T3_STARFORGE = BLOCKS.register("starforge_tier_3", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
}
