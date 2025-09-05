package jolt9001.causalchaos.common.datagen.tags;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.datagen.tags.compat.ModdedEntityTagGenerator;
import jolt9001.causalchaos.init.CCEntities;
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
    public static final TagKey<EntityType<?>> NPCS = create(CausalChaos.prefix("npcs"));
    public static final TagKey<EntityType<?>> ANCHORS = create(CausalChaos.prefix("anchors"));
    public static final TagKey<EntityType<?>> TWISTED_CHILDREN = create(CausalChaos.prefix("twisted_children"));

    public EntityTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper helper) {
        super(output, provider, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        super.addTags(provider);
        tag(BOSSES).add(
                CCEntities.DEMON_LORD.get(), CCEntities.LEVIATHAN_SKYWYRM.get(), CCEntities.WORLDEATER.get()
        );
        tag(SUPERBOSSES).add(
                CCEntities.TSUNA_BOSS.get(), CCEntities.KAI_BOSS.get(), CCEntities.TERRY_BOSS.get(),
                CCEntities.LYADOVA_BOSS.get(), CCEntities.AELLA_BOSS.get(), CCEntities.JACK_BOSS.get(),
                CCEntities.XANTHEA_BOSS.get(), CCEntities.WILL_BOSS.get(), CCEntities.MATTHUE_BOSS.get(),
                CCEntities.ALLINE_BOSS.get(), CCEntities.MADELINE_BOSS.get(), CCEntities.EMILY_BOSS.get(),
                CCEntities.ADRIAN_BOSS.get(), CCEntities.ANDREA_BOSS.get(), CCEntities.REX_BOSS.get(),
                CCEntities.JOLT_BOSS.get(), CCEntities.FPJOLT_BOSS.get()
        );
        tag(ENEMIES).add(
                CCEntities.RIFTWALKER_SCOUT.get(), CCEntities.RIFTWALKER_SOLDIER.get(), CCEntities.RIFTWALKER_ELITE.get(),
                CCEntities.RIFTWALKER_CORRUPTOR.get()
        );
        tag(NPCS).add(
                CCEntities.TSUNA_NPC.get(), CCEntities.KAI_NPC.get(), CCEntities.TERRY_NPC.get(),
                CCEntities.LYADOVA_NPC.get(), CCEntities.AELLA_NPC.get(), CCEntities.JACK_NPC.get(),
                CCEntities.XANTHEA_NPC.get(), CCEntities.WILL_NPC.get(), CCEntities.MATTHUE_NPC.get(),
                CCEntities.ALLINE_NPC.get(), CCEntities.MADELINE_NPC.get(), CCEntities.EMILY_NPC.get(),
                CCEntities.ADRIAN_NPC.get(), CCEntities.ANDREA_NPC.get(), CCEntities.REX_NPC.get(),
                CCEntities.JOLT_NPC.get()
        );
    }

    private static TagKey<EntityType<?>> create(ResourceLocation rl) {
        return TagKey.create(Registries.ENTITY_TYPE, rl);
    }
}
