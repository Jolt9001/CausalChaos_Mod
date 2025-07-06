package jolt9001.causalchaos.common.datagen.tags;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.datagen.tags.compat.ModdedEntityTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EntityTagGenerator extends ModdedEntityTagGenerator {
    public static final TagKey<EntityType<?>> BOSSES = create(CausalChaos.prefix("bosses"));
    public static final TagKey<EntityType<?>> SUPERBOSSES = create(CausalChaos.prefix("superbosses"));
    public static final TagKey<EntityType<?>> ENEMIES = create(CausalChaos.prefix("enemies"));
    public static final TagKey<EntityType<?>> NPCS = create(CausalChaos.prefix("enemies"));


    public EntityTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper helper) {
        super(output, provider, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        super.addTags(provider);
        tag(BOSSES);
        tag(SUPERBOSSES);
        tag(ENEMIES);
        tag(NPCS);
    }

    private static TagKey<EntityType<?>> create(ResourceLocation rl) {
        return TagKey.create(Registries.ENTITY_TYPE, rl);
    }
}
