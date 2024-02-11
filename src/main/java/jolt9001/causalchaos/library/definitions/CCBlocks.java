package jolt9001.causalchaos.library.definitions;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public final class CCBlocks {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CausalChaos.MODID);
    // Environmental (ores, terrain, etc)
    // Resource
    // Machine
    public static final RegistryObject<Block> T0_STARFORGE = BLOCKS.register("starforge_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
}
