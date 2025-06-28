package jolt9001.causalchaos.util;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.item.CCItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class CausalChaosItemMaterial {
    // Mining level, durability, mining speed multiplier, damage bonus, enchantability
    // Base damage for swords is 4, reference personal docs for stats

    public static final Tier NEODYMIUM = TierSortingRegistry.registerTier(
            new ForgeTier(2, 732, 6.5F, 2, 14,
                    BlockTags.create(CausalChaos.prefix("needs_neodymium_tool")),
                    () -> Ingredient.of(CCItems.NEODYMIUM_INGOT.get())),
            CausalChaos.prefix("neodymium"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier PALLADIUM = TierSortingRegistry.registerTier(
            new ForgeTier(2, 1051,8, 3, 14,
                    BlockTags.create(CausalChaos.prefix("needs_palladium_tool")),
                    () -> Ingredient.of(CCItems.PALLADIUM_INGOT.get())),
            CausalChaos.prefix("palladium"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier TITANIUM = TierSortingRegistry.registerTier(
            new ForgeTier(3, 2052, 10, 4, 10,
                    BlockTags.create(CausalChaos.prefix("needs_titanium_tool")),
                    () -> Ingredient.of(CCItems.TITANIUM_INGOT.get())),
            CausalChaos.prefix("titanium"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));

    public static final Tier COBALT = TierSortingRegistry.registerTier(
            new ForgeTier(3, 2531, 9, 4,30,
                    BlockTags.create(CausalChaos.prefix("needs_cobalt_tool")),
                    () -> Ingredient.of(CCItems.COBALT_INGOT.get())),
            CausalChaos.prefix("cobalt"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));

    public static final Tier IRIDIUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 3207, 9, 5, 20,
                    BlockTags.create(CausalChaos.prefix("needs_iridium_tool")),
                    () -> Ingredient.of(CCItems.IRIDIUM_INGOT.get())),
            CausalChaos.prefix("iridium"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier TUNGSTEN = TierSortingRegistry.registerTier(
            new ForgeTier(4, 4096, 8, 5, 15,
                    BlockTags.create(CausalChaos.prefix("needs_tungsten_tool")),
                    () -> Ingredient.of(CCItems.TUNGSTEN_INGOT.get())),
            CausalChaos.prefix("tungsten"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier THUNDERSTEEL = TierSortingRegistry.registerTier(
            new ForgeTier(4, 5137, 13,6, 13,
                    BlockTags.create(CausalChaos.prefix("needs_thundersteel_tool")),
                    () -> Ingredient.of(CCItems.THUNDERSTEEL_INGOT.get())),
            CausalChaos.prefix("thundersteel"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier INFUSED_THUNDERSTEEL = TierSortingRegistry.registerTier(
            new ForgeTier(4, 10274,18,8.5F, 15,
                    BlockTags.create(CausalChaos.prefix("needs_infused_thundersteel_tool")),
                    () -> Ingredient.of(CCItems.PERPLEXIUM_NUGGET.get())),
            CausalChaos.prefix("infused_thundersteel"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier PERPLEXIUM = TierSortingRegistry.registerTier(
            new ForgeTier(4, 15411, 20, 11, 15,
                    BlockTags.create(CausalChaos.prefix("needs_perplexium_tool")),
                    () -> Ingredient.of(CCItems.PERPLEXIUM_INGOT.get())),
            CausalChaos.prefix("perplexium"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier SUPERWEAPON = TierSortingRegistry.registerTier(
            new ForgeTier(5, Integer.MAX_VALUE, 20, 15, 0,
                    BlockTags.create(CausalChaos.prefix("needs_superweapon")),
                    Ingredient::of),
            CausalChaos.prefix("superweapon"), List.of(), List.of());
}
