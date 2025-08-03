package jolt9001.causalchaos.library.enums;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.init.CCItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum CCArmorMaterial implements ArmorMaterial {
    ARMOR_NEODYMIUM("neodymium", 22, new int[] { 2, 5, 7, 2 }, 14,
            SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, () -> Ingredient.of(CCItems.NEODYMIUM_INGOT.get())),
    ARMOR_PALLADIUM("palladium", 30, new int[] { 3, 6, 7, 3 }, 14,
            SoundEvents.ARMOR_EQUIP_IRON, 0F, 0.0F, () -> Ingredient.of(CCItems.PALLADIUM_INGOT.get())),
    ARMOR_COBALT("cobalt", 36, new int[] { 3, 6, 8, 3 }, 30, SoundEvents.ARMOR_EQUIP_GOLD,
            2F, 0.0F, () -> Ingredient.of(CCItems.COBALT_INGOT.get())),
    ARMOR_TITANIUM("titanium", 43, new int[] { 3, 6, 8, 3 }, 10,
            SoundEvents.ARMOR_EQUIP_IRON, 1F, 0.0F, () -> Ingredient.of(CCItems.TITANIUM_INGOT.get())),

    /**
     * This is when stuff gets out of control... All the following armor sets are better than Netherite.
     */
    ARMOR_IRIDIUM("iridium", 52, new int[] { 3, 6, 8, 3 }, 20, SoundEvents.ARMOR_EQUIP_GOLD,
            4F, 0.1F, () -> Ingredient.of(CCItems.IRIDIUM_INGOT.get())),
    ARMOR_TUNGSTEN("tungsten", 64, new int[] { 3, 6, 8, 3 }, 15,
            SoundEvents.ARMOR_EQUIP_IRON, 5F, 0.5F, () -> Ingredient.of(CCItems.TUNGSTEN_INGOT.get())),
    ARMOR_THUNDERSTEEL("thundersteel", 100, new int[] { 3, 6, 8, 3 }, 13,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 6F, 1.0F, () -> Ingredient.of(CCItems.THUNDERSTEEL_INGOT.get())),
    ARMOR_INFUSED_THUNDERSTEEL("infused_thundersteel", 150, new int[] { 3, 6, 8, 3 }, 15,
            SoundEvents.ARMOR_EQUIP_NETHERITE, 12F, 2.0F, null),
    ARMOR_PERPLEXIUM("perplexium", 200, new int[] { 3, 6, 8, 3 }, 15,
            SoundEvents.ARMOR_EQUIP_DIAMOND, 18F, 3.0F, () -> Ingredient.of(CCItems.PERPLEXIUM_INGOT.get())),
    // And now we're breaking minecraft... This is the best material in the mod. Temp because each supermaterial set is unique.
    ARMOR_SUPERMATERIAL("supermaterial", Integer.MAX_VALUE, new int[] {3, 6, 8, 3}, 0,
            SoundEvents.ARMOR_EQUIP_GENERIC, 25F, 5.0F, null);

    /* BRINELL HARDNESS
    Iron: 490 MPa (Comparison)
    Neodymium: 265 MPa
    Palladium: 37.2 MPa
    Cobalt: 700 MPa
    Titanium: 715 MPa
    Iridium: 1670 MPa
    Tungsten: 2570 MPa
     */

    private final String name;
    private final int durabilityMult;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    CCArmorMaterial(String name, int durabilityMult, int[] protectionAmounts,
                    int enchantability, SoundEvent sound, float toughness,
                    float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.durabilityMult = durabilityMult;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public String getName() {
        return CausalChaos.MODID + ":" + this.name;
    }

    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * durabilityMult;
    }

    public int getDefenseForType(ArmorItem.Type type) { return this.protectionAmounts[type.ordinal()]; }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() { return this.equipSound; }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance; //Discuss use in other sets
    }
}
