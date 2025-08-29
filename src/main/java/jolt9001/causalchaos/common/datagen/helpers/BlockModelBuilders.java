package jolt9001.causalchaos.common.datagen.helpers;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;

public abstract class BlockModelBuilders extends BlockModelHelpers {
    public BlockModelBuilders(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, exFileHelper);
    }

}
