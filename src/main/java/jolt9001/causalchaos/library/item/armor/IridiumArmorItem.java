package jolt9001.causalchaos.library.item.armor;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class IridiumArmorItem extends ArmorItem {
    public IridiumArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack s, Entity e, EquipmentSlot slot, String layer) {
        if (slot == EquipmentSlot.LEGS) {
            return CausalChaos.ARMOR_DIR + "iridium_layer_2.png";
        } else {
            return CausalChaos.ARMOR_DIR + "iridium_layer_1.png";
        }
    }
}
