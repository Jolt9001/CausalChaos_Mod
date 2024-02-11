package jolt9001.causalchaos.library.item.enums;

import jolt9001.causalchaos.library.definitions.CCItems;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum CCArmorMaterial implements ArmorMaterial {
    ARMOR_NEODYMIUM("neodymium_ingot", 22, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 2);
        map.put(ArmorItem.Type.LEGGINGS, 5);
        map.put(ArmorItem.Type.CHESTPLATE, 7);
        map.put(ArmorItem.Type.HELMET, 2);
    }), 14, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, () -> Ingredient.of(CCItems.NEODYMIUM_INGOT.get()), 0.0F),
    ARMOR_PALLADIUM("palladium_ingot", 30, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 7);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 14, SoundEvents.ARMOR_EQUIP_IRON, 0F, () -> Ingredient.of(CCItems.PALLADIUM_INGOT.get()), 0.0F),
    ARMOR_TITANIUM("titanium_ingot", 36, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 10, SoundEvents.ARMOR_EQUIP_IRON, 1F, () -> Ingredient.of(CCItems.TITANIUM_INGOT.get()), 0.0F),
    ARMOR_COBALT("cobalt_ingot", 43, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 30, SoundEvents.ARMOR_EQUIP_GOLD, 2F, () -> Ingredient.of(CCItems.COBALT_INGOT.get()), 0.0F),

    /**
     * This is when stuff gets out of control... All the following armor sets are better than Netherite.
     */
    ARMOR_IRIDIUM("iridium_ingot", 52, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 20, SoundEvents.ARMOR_EQUIP_GOLD, 4F, () -> Ingredient.of(CCItems.IRIDIUM_INGOT.get()), 0.1F),
    ARMOR_TUNGSTEN("tungsten_ingot", 64, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_IRON, 5F, () -> Ingredient.of(CCItems.TUNGSTEN_INGOT.get()), 0.5F),
    ARMOR_THUNDERSTEEL("thundersteel_ingot", 100, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 13, SoundEvents.ARMOR_EQUIP_DIAMOND, 6F, () -> Ingredient.of(CCItems.THUNDERSTEEL_INGOT.get()), 1.0F),
    ARMOR_INFUSED_THUNDERSTEEL("perplexium_nugget", 150, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 12F, () -> Ingredient.of(CCItems.PERPLEXIUM_NUGGET.get()), 2.0F),
    ARMOR_PERPLEXIUM("perplexium_ingot", 200, Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 8);
        map.put(ArmorItem.Type.HELMET, 3);
    }), 15, SoundEvents.ARMOR_EQUIP_DIAMOND, 18F, () -> Ingredient.of(CCItems.PERPLEXIUM_INGOT.get()), 3.0F);

    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 13);
        map.put(ArmorItem.Type.LEGGINGS, 15);
        map.put(ArmorItem.Type.CHESTPLATE, 16);
        map.put(ArmorItem.Type.HELMET, 11);
    });
    private final String name;
    private final int durability;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    CCArmorMaterial(String name, int durability, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantability, SoundEvent sound, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
        this.name = name;
        this.durability = durability;
        this.protectionFunctionForType = protectionFunctionForType;
        this.enchantability = enchantability;
        this.equipSound = sound;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getDurabilityForType(ArmorItem.Type type) {
        return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durability;
    }

    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionFunctionForType.get(type);
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance; //Discuss use in other sets
    }
}
