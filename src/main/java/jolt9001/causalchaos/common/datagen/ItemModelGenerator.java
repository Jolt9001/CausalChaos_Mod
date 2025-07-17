package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CausalChaos.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
