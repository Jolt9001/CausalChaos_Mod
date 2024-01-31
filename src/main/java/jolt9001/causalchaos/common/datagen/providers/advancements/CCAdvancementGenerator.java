package jolt9001.causalchaos.common.datagen.providers.advancements;

import jolt9001.causalchaos.common.datagen.IconGenerator;

import jolt9001.causalchaos.common.triggers.AdvancementTriggers;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.LevelData;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import jolt9001.causalchaos.library.definitions.CCItems;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.function.Consumer;

public class CCAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {

    // protected Consumer<Advancement> advancementConsumer;
    // protected BiConsumer<ResourceLocation, ConditionalAdvancement.Builder> conditionalConsumer;

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper fileHelper) {
        // Advancement builder variable for efficiency
        Advancement.Builder builder = Advancement.Builder.advancement();

        // Level Data
        LevelData levelData = ObfuscationReflectionHelper.getPrivateValue(ServerLevel.class, null, "field_237386_d_");

        // Root
        var root = builder
                .display(
                        CCItems.JOURNAL,
                        Component.translatable("achievement.causalchaos.root", "Causal Chaos"),
                        Component.translatable("achievement.causalchaos.root.desc",
                                "It might be a good idea to hold on to this."),
                        null, /* background */
                        FrameType.TASK,
                        false, /* showToast */
                        false, /* announceChat */
                        false) /* hidden */
                .rewards(AdvancementRewards.Builder.loot(new ResourceLocation("causalchaos:gameplay/causal_journal")))
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, "causalchaos:main/root");

        // Tutorial
        var getCrystalDefault = builder
                .display(
                        CCItems.CAUSALITY_CRYSTAL,
                        Component.translatable("achievement.causalchaos.crystal_get",
                                "Ooh, Shiny!"),
                        Component.translatable("achievement.causalchaos.crystal_get.desc",
                                "Obtain a Causality Crystal."),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false
                )
                .parent(root)
                .addCriterion("get_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.CAUSALITY_CRYSTAL))
                .save(consumer, "causalchaos.main/get_crystal");
        // Ability

        // Bosses (Demon Lord, Worldeater, Leviathan Skywyrm)

        // Early Game (Time Loop)

        // MidGame (Advancements specific to the ending of the time loop)

        // Endgame (post time loop)

        // Dimensions
            // Limbo

            // Realm Tears + Parallel Universes

            //Transcendent's Plain

        // Superbosses
            // Normal Mode

            // Chaos Mode

        // Hardcore
        if (levelData.isHardcore()) {
            var getCrystalHardcore = builder
                    .display(
                            CCItems.CAUSALITY_CRYSTAL,
                            Component.translatable("achievement.causalchaos.crystal_get",
                                    "YOLO"),
                            Component.translatable("achievement.causalchaos.crystal_get.desc",
                                    "Obtain a Causality Crystal in Hardcore Mode."),
                            null,
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .parent(root)
                    .addCriterion("get_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.CAUSALITY_CRYSTAL))
                    .save(consumer, "causalchaos.main/get_crystal_hardcore");

            var hardcoreDeath = builder
                    .display(
                            (ItemLike) IconGenerator.RESUSCITATION_ICON,
                            Component.translatable("achievement.causalchaos.hardcore_death", "Resuscitation"),
                            Component.translatable("achievement.causalchaos.hardcore_death",
                                    "Embrace mortality, yet defy the fall."),
                            null,
                            FrameType.GOAL,
                            true,
                            true,
                            false
                    )
                    .parent(getCrystalHardcore)
                    .addCriterion("hardcore_death", AdvancementTriggers.hardcoreDeathCriterion())
                    .save(consumer, "causalchaos.main/hardcore_death");
        }
        // Journal Completion

        // Challenges and Funnies

        // Hidden Challenges
    }
}
