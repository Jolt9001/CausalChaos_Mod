package jolt9001.causalchaos.common.datagen.tags.compat;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModdedBlockTagGenerator extends IntrinsicHolderTagsProvider<Block> {
    public ModdedBlockTagGenerator(PackOutput out, CompletableFuture<HolderLookup.Provider> future, ExistingFileHelper help) {
        super(out, Registries.BLOCK, future, block -> block.builtInRegistryHolder().key(), CausalChaos.MODID, help);
    }

    @Override
    protected void addTags(HolderLookup.Provider prov) {

    }
    private static TagKey<Block> createTagFor(String modid, String tagName) {
        return BlockTags.create(new ResourceLocation(modid, tagName));
    }
}
