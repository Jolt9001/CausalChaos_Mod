package jolt9001.causalchaos.common.datagen.generators;

import jolt9001.causalchaos.common.triggers.HardcoreDeathTrigger;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.LevelData;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import jolt9001.causalchaos.library.item.CCItems;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
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
                        CCItems.JOURNAL.get(), //get ItemLike object
                        Component.translatable("achievement.causalchaos.root", "Causal Chaos"),
                        Component.translatable("achievement.causalchaos.root.desc",
                                "It might be a good idea to hold on to this."), //Advancement Description
                        null, // background
                        FrameType.TASK,
                        false, // showToast
                        false, // announceChat
                        false) // hidden
                .rewards(AdvancementRewards.Builder.loot(new ResourceLocation(
                        "causalchaos:gameplay/causal_journal"))) //grant reward in the form of a Causal Journal
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick()) //Triggered the moment the player joins the world
                .save(consumer, "causalchaos:main/root"); //Save the advancement


        // Tutorial
        var getCrystalDefault = builder
                .display(
                        CCItems.CAUSALITY_CRYSTAL.get(),
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
                .addCriterion("get_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.CAUSALITY_CRYSTAL.get()))
                .save(consumer, "causalchaos.main/get_crystal");

        var dashStrike = builder;
        var dodge = builder;
        var dangerSense = builder;

        // Ability
        var standInHitbox = builder;
        var QTEFail = builder;
        var perfectDodge = builder;
        var lightningDodge = builder;
        var killCreeperWhileExploding = builder;

        var mastery1 = builder;
        var mastery2 = builder;
        var mastery3 = builder;
        var mastery4 = builder;
        var mastery5 = builder;

        // Bosses (Demon Lord, Worldeater, Leviathan Skywyrm)
            // generic
        var heroDeath = builder;

            // Demon Lord
        var fightDL1 = builder;
        var fightDL2 = builder;
        var tripleDLPerfectDodge = builder;
        var DLFlurryCounter = builder;
        var bossDLDeathless = builder;
        var soloDL = builder;
        var anchorDeathlessDL = builder;
        var parallelDLDefeat = builder;

            // Worldeater
        var worldeaterEncounter = builder;
        var worldeaterDefeat = builder;
        var worldeaterMax = builder;

            // Leviathan Skywyrm

        // Early Game (Time Loop)
        var timeLoopActivate = builder;
        var anchorEncounter = builder;
        var anchorDeath = builder;
        var anchorProtect = builder;
        var twistedEncounter = builder;
        var riftwalkerKill = builder;

        // MidGame (Advancements specific to the ending of the time loop)
        var loopEscape = builder;

        // Endgame (post time loop)
        var obtainStarforge = builder;
        var obtainThundersteel = builder;
        var obtainPerplexium = builder;
        var infusedThundersteel = builder;
        var purePerplexium = builder;
        var villageHousing25 = builder;
        var villagerGift = builder;
        var superbossVillage = builder;
        var realityGlitch = builder;

        // Dimensions
            // Sky Islands
        var enterSkylands = builder;

            // Limbo
        var enterLimbo = builder;
        var limboDeath = builder;
        var limboEscape = builder;
        var stableRiftToken = builder;
        var limboPortal = builder;

            // Realm Tears + Parallel Universes
        var enterRealmTear = builder;
        var permanentRealmTear = builder;
        var dimensionalAnchor = builder;

            //Transcendent's Plain
        var TPPortalActivate = builder;
        var preeminence = builder;
        var chaosModeKill = builder;

        // Superbosses
            // Normal Mode
        var Tsuna = builder;
        var Kai = builder;
        var Terry = builder;
        var Lyadova = builder;
        var Aella = builder;
        var Jack = builder;
        var Xanthea = builder;
        var Will = builder;
        var Matthue = builder;
        var Alline = builder;
        var Madeline = builder;
        var Emily = builder;
        var Adrian = builder;
        var Andrea = builder;
        var Christian = builder;
        var Jolt = builder;
        var FPJolt = builder;

            // Chaos Mode
        var CTsuna = builder;
        var CKai = builder;
        var CTerry = builder;
        var CLyadova = builder;
        var CAella = builder;
        var CJack = builder;
        var CXanthea = builder;
        var CWill = builder;
        var CMatthue = builder;
        var CAlline = builder;
        var CMadeline = builder;
        var CEmily = builder;
        var CAdrian = builder;
        var CAndrea = builder;
        var CChristian = builder;
        var CJolt = builder;
        var CFPJolt = builder;

        // Hardcore
        var getCrystalHardcore = builder
                .display(
                        CCItems.CAUSALITY_CRYSTAL.get(),
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
                .addCriterion("get_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.CAUSALITY_CRYSTAL.get()))
                // .addCriterion("is_hardcore", [hardcore mode trigger])
                .save(consumer, "causalchaos.main/get_crystal_hardcore");

        LivingEntity entity = null;
        LivingDeathEvent event = new LivingDeathEvent(entity, null);
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
                .addCriterion("hardcore_death", HardcoreDeathTrigger.Instance.youDied(event))
                .save(consumer, "causalchaos.main/hardcore_death");
        var hardcoreDLDefeat = builder;
        var perfectSuperboss = builder;
        var day100 = builder;
        var halfHeartSuperboss = builder;

        // Journal Completion
        var journal25 = builder;
        var journal50 = builder;
        var journal75 = builder;
        var journal100 = builder;

        // Challenges and Funnies
            // Challenges

            // Funnies
        var blackHoleTP = builder;
        var FPJoltDeath = builder;
        var playerLostMind = builder;
        var superweaponOnVanillaMob = builder;
        var badRNG = builder;

        // Hidden Challenges
        var bossRush = builder;
        var chaosCompletion = builder;
        var chaosCompletionHardcore = builder;
    }
}
