package jolt9001.causalchaos.common.datagen.tags.compat;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModdedEntityTagGenerator extends EntityTypeTagsProvider {
    public ModdedEntityTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper helper) {
        super(output, provider, CausalChaos.MODID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }

    private static TagKey<EntityType<?>> createTagFor(String modid, String tagName) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(modid, tagName));
    }
}
