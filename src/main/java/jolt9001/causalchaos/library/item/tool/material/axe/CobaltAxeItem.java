package jolt9001.causalchaos.library.item.tool.material.axe;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public class CobaltAxeItem extends AxeItem {

    // Tier, Attack Damage, Speed, properties
    public CobaltAxeItem(Tier material, Properties prop) {
        super(material, 5.0F, -3.0F, prop);
    }
}
