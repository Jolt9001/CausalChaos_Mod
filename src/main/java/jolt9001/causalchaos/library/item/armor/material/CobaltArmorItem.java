package jolt9001.causalchaos.library.item.armor.material;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class CobaltArmorItem extends ArmorItem {
    public CobaltArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack s, Entity e, EquipmentSlot slot, String layer) {
        if (slot == EquipmentSlot.LEGS) {
            return CausalChaos.ARMOR_DIR + "cobalt_layer_2.png";
        } else {
            return CausalChaos.ARMOR_DIR + "cobalt_layer_1.png";
        }
    }
    /*
    @Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(ArmorRender.INSTANCE);
	}

    private static final class ArmorRender implements IClientItemExtensions {
        private static final ArmorRender INSTANCE = new ArmorRender();

        @Override
        public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> model) {
            EntityModelSet models = Minecraft.getInstance().getEntityModels();
            ModelPart root = models.bakeLayer(slot == EquipmentSlot.LEGS ? CCModelLayers.COBALT_ARMOR_INNER : CCModelLayers.COBALT_ARMOR_OUTER);
            return new FieryArmorModel(root);
        }
    }

     */
}
