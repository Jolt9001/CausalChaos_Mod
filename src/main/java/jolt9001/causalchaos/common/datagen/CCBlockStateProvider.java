package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.init.CCBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CCBlockStateProvider extends BlockStateProvider {
    public CCBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CausalChaos.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        /*
        // Ores
        fullBlock(CCBlocks.ANTHRACITE_ORE);
        fullBlock(CCBlocks.MAGNETITE_ORE);
        fullBlock(CCBlocks.COBALT_ORE);
        fullBlock(CCBlocks.IRIDIUM_ORE);
        fullBlock(CCBlocks.NEODYMIUM_ORE);
        fullBlock(CCBlocks.PALLADIUM_ORE);
        fullBlock(CCBlocks.TITANIUM_ORE);
        fullBlock(CCBlocks.TUNGSTEN_ORE);

        // Deepslate Ores
        fullBlock(CCBlocks.DEEPSLATE_COBALT_ORE);
        fullBlock(CCBlocks.DEEPSLATE_IRIDIUM_ORE);
        fullBlock(CCBlocks.DEEPSLATE_NEODYMIUM_ORE);
        fullBlock(CCBlocks.DEEPSLATE_PALLADIUM_ORE);
        fullBlock(CCBlocks.DEEPSLATE_TITANIUM_ORE);
        fullBlock(CCBlocks.DEEPSLATE_TUNGSTEN_ORE);

        // Terrain Blocks
        fullBlock(CCBlocks.REALMWEAVE_BLOCK);
        bottomTop(CCBlocks.TRANSCENDENT_TURF);
        fullBlock(CCBlocks.TRANSCENDENT_SOIL);
        fullBlock(CCBlocks.TRANSCENDENT_STONE);

        // Decorative
        fullBlock(CCBlocks.QUANTUM_FABRIC);

        fullBlock(CCBlocks.TRANSCENDENT_SMOOTH_STONE);
        fullBlock(CCBlocks.TRANSCENDENT_COBBLESTONE);
        fullBlock(CCBlocks.TRANSCENDENT_STONE_BRICKS);
        fullBlock(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICKS);
        fullBlock(CCBlocks.TRANSCENDENT_STONE_TILES);
        fullBlock(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILES);
        fullBlock(CCBlocks.CHISELED_TRANSCENDENT_STONE_BRICKS);

        slab(CCBlocks.TRANSCENDENT_STONE_SLAB, CCBlocks.TRANSCENDENT_STONE);
        slab(CCBlocks.TRANSCENDENT_SMOOTH_STONE_SLAB, CCBlocks.TRANSCENDENT_SMOOTH_STONE);
        slab(CCBlocks.TRANSCENDENT_COBBLESTONE_SLAB, CCBlocks.TRANSCENDENT_COBBLESTONE);
        slab(CCBlocks.TRANSCENDENT_STONE_BRICK_SLAB, CCBlocks.TRANSCENDENT_STONE_BRICKS);
        slab(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_SLAB, CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICKS);
        slab(CCBlocks.TRANSCENDENT_STONE_TILE_SLAB, CCBlocks.TRANSCENDENT_STONE_TILES);
        slab(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_SLAB, CCBlocks.CRACKED_TRANSCENDENT_STONE_TILES);

        stair(CCBlocks.TRANSCENDENT_STONE_STAIRS, CCBlocks.TRANSCENDENT_STONE);
        stair(CCBlocks.TRANSCENDENT_SMOOTH_STONE_STAIRS, CCBlocks.TRANSCENDENT_SMOOTH_STONE);
        stair(CCBlocks.TRANSCENDENT_COBBLESTONE_STAIRS, CCBlocks.TRANSCENDENT_COBBLESTONE);
        stair(CCBlocks.TRANSCENDENT_STONE_BRICK_STAIRS, CCBlocks.TRANSCENDENT_STONE_BRICKS);
        stair(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_STAIRS, CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICKS);
        stair(CCBlocks.TRANSCENDENT_STONE_TILE_STAIRS, CCBlocks.TRANSCENDENT_STONE_TILES);
        stair(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_STAIRS, CCBlocks.CRACKED_TRANSCENDENT_STONE_TILES);

        wall(CCBlocks.TRANSCENDENT_STONE_WALL, CCBlocks.TRANSCENDENT_STONE);
        wall(CCBlocks.TRANSCENDENT_SMOOTH_STONE_WALL, CCBlocks.TRANSCENDENT_SMOOTH_STONE);
        wall(CCBlocks.TRANSCENDENT_COBBLESTONE_WALL, CCBlocks.TRANSCENDENT_COBBLESTONE);
        wall(CCBlocks.TRANSCENDENT_STONE_BRICK_WALL, CCBlocks.TRANSCENDENT_STONE_BRICKS);
        wall(CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICK_WALL, CCBlocks.CRACKED_TRANSCENDENT_STONE_BRICKS);
        wall(CCBlocks.TRANSCENDENT_STONE_TILE_WALL, CCBlocks.TRANSCENDENT_STONE_TILES);
        wall(CCBlocks.CRACKED_TRANSCENDENT_STONE_TILE_WALL, CCBlocks.CRACKED_TRANSCENDENT_STONE_TILES);

        // Resource Storage
        fullBlock(CCBlocks.RAW_COBALT_BLOCK);
        fullBlock(CCBlocks.RAW_IRIDIUM_BLOCK);
        fullBlock(CCBlocks.RAW_NEODYMIUM_BLOCK);
        fullBlock(CCBlocks.RAW_PALLADIUM_BLOCK);
        fullBlock(CCBlocks.RAW_TITANIUM_BLOCK);
        fullBlock(CCBlocks.RAW_TUNGSTEN_BLOCK);

        fullBlock(CCBlocks.ANTHRACITE_BLOCK);
        fullBlock(CCBlocks.MAGNETITE_BLOCK);
        fullBlock(CCBlocks.COBALT_BLOCK);
        fullBlock(CCBlocks.IRIDIUM_BLOCK);
        fullBlock(CCBlocks.NEODYMIUM_BLOCK);
        fullBlock(CCBlocks.PALLADIUM_BLOCK);
        fullBlock(CCBlocks.PERPLEXIUM_BLOCK);
        fullBlock(CCBlocks.THUNDERSTEEL_BLOCK);
        fullBlock(CCBlocks.TITANIUM_BLOCK);
        fullBlock(CCBlocks.TUNGSTEN_BLOCK);

        // Machines
        starforgeBlock(CCBlocks.T0_STARFORGE);
        starforgeBlock(CCBlocks.T1_STARFORGE);
        starforgeBlock(CCBlocks.T2_STARFORGE);
        starforgeBlock(CCBlocks.T3_STARFORGE);
        columnBlocks(CCBlocks.T1_ELECTROMAGNET);
        columnBlocks(CCBlocks.T2_ELECTROMAGNET);
        columnBlocks(CCBlocks.T3_ELECTROMAGNET);
        columnBlocks(CCBlocks.T1_HEAT_SINK);
        columnBlocks(CCBlocks.T2_HEAT_SINK);
        columnBlocks(CCBlocks.T3_HEAT_SINK);
        bottomTop(CCBlocks.T1_HOPPER);
        bottomTop(CCBlocks.T2_HOPPER);
        bottomTop(CCBlocks.T3_HOPPER);
        bottomTop(CCBlocks.T1_S_HOPPER);
        bottomTop(CCBlocks.T2_S_HOPPER);
        bottomTop(CCBlocks.T3_S_HOPPER);
        fullBlock(CCBlocks.T1_CORE_SHIELDING);
        fullBlock(CCBlocks.T2_CORE_SHIELDING);
        fullBlock(CCBlocks.T3_CORE_SHIELDING);

        // Gadgets
        //blockWithItem(CCBlocks.DIMENSIONAL_ANCHOR);
        //blockWithItem(CCBlocks.WORMHOLE_STABILIZER);
        //blockWithItem(CCBlocks.WARP_PAD);
         */
    }

    private void slab(RegistryObject<Block> blockRegistryObject, RegistryObject<Block> texture) {
        slabBlock((SlabBlock) blockRegistryObject.get(), blockTexture(texture.get()), blockTexture(texture.get()));
    }
    private void stair(RegistryObject<Block> blockRegistryObject, RegistryObject<Block> texture) {
        stairsBlock((StairBlock) blockRegistryObject.get(), blockTexture(texture.get()));
    }
    private void wall(RegistryObject<Block> blockRegistryObject, RegistryObject<Block> texture) {
        wallBlock((WallBlock) blockRegistryObject.get(), blockTexture(texture.get()));
    }
    private void fullBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void starforgeBlock(RegistryObject<Block> blockRegistryObject) {
        // Needs Top, Bottom, Side, and Front.
        var offModel = models().cube(
                modelPath(blockRegistryObject),
                blockRegistryObject.getId().withSuffix("_bottom"),
                blockRegistryObject.getId().withSuffix("_top"),
                blockRegistryObject.getId().withSuffix("_front"),
                blockRegistryObject.getId().withSuffix("_side"),
                blockRegistryObject.getId().withSuffix("_side"),
                blockRegistryObject.getId().withSuffix("_side"))
                .texture("particle", blockRegistryObject.getId().withSuffix("_front"));
        var onModel = models().cube(
                modelPath(blockRegistryObject) + "_on",
                blockRegistryObject.getId().withSuffix("_bottom"),
                blockRegistryObject.getId().withSuffix("_top"),
                blockRegistryObject.getId().withSuffix("_front_on"),
                blockRegistryObject.getId().withSuffix("_side"),
                blockRegistryObject.getId().withSuffix("_side"),
                blockRegistryObject.getId().withSuffix("_side"))
                .texture("particle", blockRegistryObject.getId().withSuffix("_front_on"));
    }
    private void columnBlocks(RegistryObject<Block> blockRegistryObject) {
        var model = models().cubeColumn(
                modelPath(blockRegistryObject),
                blockRegistryObject.getId().withSuffix("_side"),
                blockRegistryObject.getId().withSuffix("_end")
        );
    }
    private void bottomTop(RegistryObject<Block> blockRegistryObject){
        var model = models().cubeBottomTop(
                modelPath(blockRegistryObject),
                blockRegistryObject.getId().withSuffix("_side"),
                blockRegistryObject.getId().withSuffix("_bottom"),
                blockRegistryObject.getId().withSuffix("_top")
        );
    }
    private String modelPath(RegistryObject<Block> block) {
        return block.getId().getPath();
    }
}
