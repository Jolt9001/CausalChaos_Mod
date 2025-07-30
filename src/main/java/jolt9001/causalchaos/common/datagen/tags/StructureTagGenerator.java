package jolt9001.causalchaos.common.datagen.tags;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.init.CCStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class StructureTagGenerator extends StructureTagsProvider {
    public static final TagKey<Structure> FINAL_LANDMARK = TagKey.create(Registries.STRUCTURE, CausalChaos.prefix("landmark"));

    public StructureTagGenerator(PackOutput out, CompletableFuture<HolderLookup.Provider> prov, @Nullable ExistingFileHelper help) {
        super(out, prov, CausalChaos.MODID, help);
    }

    @Override
    protected void addTags(HolderLookup.Provider prov) {
        this.tag(FINAL_LANDMARK).add(
                CCStructures.TRANSCENDENT_MANSION, CCStructures.PERPETUAL_REACTOR, CCStructures.DOOMSDAY_CLOCK,
                CCStructures.INFERNAL_MAW, CCStructures.PROVIDENCE_TOWER, CCStructures.PERFECT_SANCTUARY,
                CCStructures.HOSPITAL, CCStructures.ASYLUM, CCStructures.BLACK_HOLE_ARENA, CCStructures.SHADOW_CASTLE,
                CCStructures.FROZEN_MOUNTAIN, CCStructures.DRAGON_CAVE, CCStructures.GIANT_MONSTER,
                CCStructures.OLD_WEST_TAVERN, CCStructures.BIG_BROTHER_SERVER, CCStructures.PORTAL_CAGE
        );
    }
}
