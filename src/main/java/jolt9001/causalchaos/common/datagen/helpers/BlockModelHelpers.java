package jolt9001.causalchaos.common.datagen.helpers;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static jolt9001.causalchaos.CausalChaos.prefix;

public abstract class BlockModelHelpers extends BlockStateProvider {
    protected static final ResourceLocation SOLID = new ResourceLocation("solid");
    protected static final ResourceLocation CUTOUT = new ResourceLocation("cutout");
    protected static final ResourceLocation CUTOUT_MIPPED = new ResourceLocation("cutout_mipped");
    protected static final ResourceLocation TRANSLUCENT = new ResourceLocation("translucent");

    public BlockModelHelpers(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CausalChaos.MODID, exFileHelper);
    }

    protected void builtinEntity(Block b, String particle) {
        simpleBlock(b, models().getBuilder(name(b))
                .parent(new ModelFile.UncheckedModelFile("builtin/entity"))
                .texture("particle", particle));
    }
    protected void simpleBlockExisting(Block b) {
        simpleBlock(b, new ConfiguredModel(models().getExistingFile(prefix(name(b)))));
    }

    protected ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    protected String name(Block block) {
        return key(block).getPath();
    }
}
