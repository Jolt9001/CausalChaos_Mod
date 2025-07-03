package jolt9001.causalchaos.common.datagen.providers;

import jolt9001.causalchaos.common.datagen.generators.AdvancementGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AdvancementProvider extends net.minecraft.data.advancements.AdvancementProvider {
    public AdvancementProvider(PackOutput out, CompletableFuture<HolderLookup.Provider> reg){
        super(out, reg, List.of(new AdvancementGenerator()));
    }
}
