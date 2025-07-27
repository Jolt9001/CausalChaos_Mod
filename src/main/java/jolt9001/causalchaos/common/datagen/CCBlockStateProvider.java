package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.init.CCBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CCBlockStateProvider extends BlockStateProvider {
    public CCBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CausalChaos.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Ores
        blockWithItem(CCBlocks.ANTHRACITE_ORE);
        blockWithItem(CCBlocks.MAGNETITE_ORE);
        blockWithItem(CCBlocks.COBALT_ORE);
        blockWithItem(CCBlocks.IRIDIUM_ORE);
        blockWithItem(CCBlocks.NEODYMIUM_ORE);
        blockWithItem(CCBlocks.PALLADIUM_ORE);
        blockWithItem(CCBlocks.TITANIUM_ORE);
        blockWithItem(CCBlocks.TUNGSTEN_ORE);

        // Deepslate Ores
        blockWithItem(CCBlocks.DEEPSLATE_COBALT_ORE);
        blockWithItem(CCBlocks.DEEPSLATE_IRIDIUM_ORE);
        blockWithItem(CCBlocks.DEEPSLATE_NEODYMIUM_ORE);
        blockWithItem(CCBlocks.DEEPSLATE_PALLADIUM_ORE);
        blockWithItem(CCBlocks.DEEPSLATE_TITANIUM_ORE);
        blockWithItem(CCBlocks.DEEPSLATE_TUNGSTEN_ORE);

        // Terrain Blocks
        blockWithItem(CCBlocks.REALMWEAVE_BLOCK);

        // Resource Storage
        blockWithItem(CCBlocks.RAW_COBALT_BLOCK);
        blockWithItem(CCBlocks.RAW_IRIDIUM_BLOCK);
        blockWithItem(CCBlocks.RAW_NEODYMIUM_BLOCK);
        blockWithItem(CCBlocks.RAW_PALLADIUM_BLOCK);
        blockWithItem(CCBlocks.RAW_TITANIUM_BLOCK);
        blockWithItem(CCBlocks.RAW_TUNGSTEN_BLOCK);

        blockWithItem(CCBlocks.ANTHRACITE_BLOCK);
        blockWithItem(CCBlocks.MAGNETITE_BLOCK);
        blockWithItem(CCBlocks.COBALT_BLOCK);
        blockWithItem(CCBlocks.IRIDIUM_BLOCK);
        blockWithItem(CCBlocks.NEODYMIUM_BLOCK);
        blockWithItem(CCBlocks.PALLADIUM_BLOCK);
        blockWithItem(CCBlocks.PERPLEXIUM_BLOCK);
        blockWithItem(CCBlocks.THUNDERSTEEL_BLOCK);
        blockWithItem(CCBlocks.TITANIUM_BLOCK);
        blockWithItem(CCBlocks.TUNGSTEN_BLOCK);

        // Gadgets and Machines
        //blockWithItem(CCBlocks.T0_STARFORGE);
        //blockWithItem(CCBlocks.T1_STARFORGE);
        //blockWithItem(CCBlocks.T2_STARFORGE);
        //blockWithItem(CCBlocks.T3_STARFORGE);
        //blockWithItem(CCBlocks.DIMENSIONAL_ANCHOR);
        //blockWithItem(CCBlocks.WORMHOLE_STABILIZER);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
