package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.common.datagen.helpers.BlockModelBuilders;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockstateGenerator extends BlockModelBuilders {
    protected static final ResourceLocation SOLID = new ResourceLocation("solid");
    protected static final ResourceLocation CUTOUT = new ResourceLocation("cutout");
    protected static final ResourceLocation CUTOUT_MIPPED = new ResourceLocation("cutout_mipped");
    protected static final ResourceLocation TRANSLUCENT = new ResourceLocation("translucent");

    public BlockstateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        /*
        // Ores
        simpleBlock(CCBlocks.ANTHRACITE_ORE.get());
        simpleBlock(CCBlocks.MAGNETITE_ORE.get());
        simpleBlock(CCBlocks.COBALT_ORE.get());
        simpleBlock(CCBlocks.IRIDIUM_ORE.get());
        simpleBlock(CCBlocks.NEODYMIUM_ORE.get());
        simpleBlock(CCBlocks.PALLADIUM_ORE.get());
        simpleBlock(CCBlocks.TITANIUM_ORE.get());
        simpleBlock(CCBlocks.TUNGSTEN_ORE.get());

        simpleBlock(CCBlocks.DEEPSLATE_COBALT_ORE.get());
        simpleBlock(CCBlocks.DEEPSLATE_IRIDIUM_ORE.get());
        simpleBlock(CCBlocks.DEEPSLATE_NEODYMIUM_ORE.get());
        simpleBlock(CCBlocks.DEEPSLATE_PALLADIUM_ORE.get());
        simpleBlock(CCBlocks.DEEPSLATE_TITANIUM_ORE.get());
        simpleBlock(CCBlocks.DEEPSLATE_TUNGSTEN_ORE.get());

        // Terrain
        simpleBlock(CCBlocks.REALMWEAVE_BLOCK.get());

        // Resource Storage

        simpleBlock(CCBlocks.RAW_COBALT_BLOCK.get());
        simpleBlock(CCBlocks.RAW_IRIDIUM_BLOCK.get());
        simpleBlock(CCBlocks.RAW_NEODYMIUM_BLOCK.get());
        simpleBlock(CCBlocks.RAW_PALLADIUM_BLOCK.get());
        simpleBlock(CCBlocks.RAW_TITANIUM_BLOCK.get());
        simpleBlock(CCBlocks.RAW_TUNGSTEN_BLOCK.get());

        simpleBlock(CCBlocks.ANTHRACITE_BLOCK.get());
        simpleBlock(CCBlocks.MAGNETITE_BLOCK.get());
        simpleBlock(CCBlocks.COBALT_BLOCK.get());
        simpleBlock(CCBlocks.IRIDIUM_BLOCK.get());
        simpleBlock(CCBlocks.NEODYMIUM_BLOCK.get());
        simpleBlock(CCBlocks.PALLADIUM_BLOCK.get());
        simpleBlock(CCBlocks.PERPLEXIUM_BLOCK.get());
        simpleBlock(CCBlocks.THUNDERSTEEL_BLOCK.get());
        simpleBlock(CCBlocks.TITANIUM_BLOCK.get());
        simpleBlock(CCBlocks.TUNGSTEN_BLOCK.get());

        // Machines and Gadgets
        simpleBlock(CCBlocks.T0_STARFORGE.get());
        simpleBlock(CCBlocks.T1_STARFORGE.get());
        simpleBlock(CCBlocks.T2_STARFORGE.get());
        simpleBlock(CCBlocks.T3_STARFORGE.get());
        simpleBlock(CCBlocks.DIMENSIONAL_ANCHOR.get());
        simpleBlock(CCBlocks.WORMHOLE_STABILIZER.get());
        */
    }
}
