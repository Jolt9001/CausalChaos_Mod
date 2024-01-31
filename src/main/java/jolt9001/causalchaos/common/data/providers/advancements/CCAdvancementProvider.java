package jolt9001.causalchaos.common.data.providers.advancements;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CCAdvancementProvider extends ForgeAdvancementProvider {

    public CCAdvancementProvider(PackOutput o, CompletableFuture<HolderLookup.Provider> reg, ExistingFileHelper fileHelper) {
        super(o, reg, fileHelper, List.of(new CCAdvancementGenerator()));
    }
}
