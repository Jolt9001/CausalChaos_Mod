package jolt9001.causalchaos.common.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CCAdvancementProvider extends ForgeAdvancementProvider {
    public CCAdvancementProvider(PackOutput out, CompletableFuture<HolderLookup.Provider> reg, ExistingFileHelper help){
        super(out, reg, help, List.of(new CCAdvancementGenerator()));
    }
}
