package jolt9001.causalchaos.common.datagen.tags.compat;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModdedItemTagGenerator extends ItemTagsProvider {

    public ModdedItemTagGenerator(PackOutput out, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagLookup<Block>> prov, ExistingFileHelper help) {
        super(out, future, prov, CausalChaos.MODID, help);
    }
    @Override
    protected void addTags(HolderLookup.Provider prov) {

    }

    private static TagKey<Item> createTagFor(String modid, String tagName) {
        return ItemTags.create(new ResourceLocation(modid, tagName));
    }
}
