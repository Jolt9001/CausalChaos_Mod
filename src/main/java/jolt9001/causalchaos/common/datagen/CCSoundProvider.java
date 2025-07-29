package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class CCSoundProvider extends SoundDefinitionsProvider {
    protected CCSoundProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, CausalChaos.MODID, helper);
    }

    @Override
    public void registerSounds() {

    }
}
