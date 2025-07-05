package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.common.advancements.HardcoreCheckTrigger;
import jolt9001.causalchaos.common.advancements.HardcoreDeathTrigger;
import jolt9001.causalchaos.init.CCBlocks;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.LevelData;

import jolt9001.causalchaos.init.CCItems;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.function.Consumer;

public class CCAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {

    // protected Consumer<Advancement> advancementConsumer;
    // protected BiConsumer<ResourceLocation, ConditionalAdvancement.Builder> conditionalConsumer;

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper file) {
        // Advancement builder variable for efficiency
        Advancement.Builder builder = Advancement.Builder.advancement();

        // Level Data
        LevelData levelData = ObfuscationReflectionHelper.getPrivateValue(ServerLevel.class, null, "field_237386_d_");

        // Root
        var root = builder
                .display(
                        CCItems.JOURNAL.get(), //get ItemLike object
                        Component.translatable("achievement.causalchaos.root", "Causal Chaos"), //Advancement name
                        Component.translatable("achievement.causalchaos.root.desc", "It might be a good idea to hold on to this."), //Advancement Description
                        null, // background
                        FrameType.TASK, //the shape of the advancement icon
                        false, // showToast
                        false, // announceChat
                        false) // hidden
                .rewards(AdvancementRewards.Builder.loot(new ResourceLocation("causalchaos:gameplay/causal_journal"))) //grant reward in the form of a Causal Journal
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick()) //Triggered the moment the player joins the world
                .save(consumer, "causalchaos:root"); //Save the advancement


        // Tutorial
        var getCrystalDefault = builder
                .display(
                        CCItems.CAUSALITY_CRYSTAL.get(),
                        Component.translatable("achievement.causalchaos.crystal_get", "Ooh, Shiny!"),
                        Component.translatable("achievement.causalchaos.crystal_get.desc", "Obtain a Causality Crystal."),
                        null, FrameType.TASK, true, true, false)
                .parent(root)
                .addCriterion("get_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.CAUSALITY_CRYSTAL.get()))
                .save(consumer, "causalchaos:get_crystal");

        var dashStrike = builder; // "I Am Speed" Prereq: getCrystalDefault
        var dodge = builder; // "Can't Touch This" Prereq: getCrystalDefault
        var dangerSense = builder; // "Spidey Sense" Prereq: getCrystalDefault

        // Ability
        var standInHitbox = builder; // "Danger Zone" Prereq: dangerSense
        var QTEFail = builder; // "You Blinked" Prereq: standInHitbox
        var perfectDodge = builder; // "Saw It Coming" Prereq: standInHitbox
        var lightningDodge = builder; // "Lightning-Fast Reaction" Prereq: perfectDodge
        var killCreeperWhileExploding = builder; // "Assisted Suicide" Prereq: perfectDodge

        var mastery1 = builder; // "Sidekick" Prereq: getCrystalDefault
        var mastery2 = builder; // "Fledgling" Prereq: mastery1
        var mastery3 = builder; // "Hero" Prereq: mastery2, timeLoopActivate
        var mastery4 = builder; // "Superhero" Prereq: mastery3, loopEscape
        var mastery5 = builder; // "Limitless" Prereq: mastery4, EnterTPlain

        // Bosses (Demon Lord, Worldeater, Leviathan Skywyrm)
            // generic
        var heroDeath = builder; // "Selfless Sacrifice" Prereq: QTEFail

            // Demon Lord
        var fightDL1 = builder; // "Great Destroyer" Prereq: getCrystalDefault
        var fightDL2 = builder; // "Déjà vu" Prereq: fightDL1
        var tripleDLPerfectDodge = builder; // "Chronal Duelist" Prereq: fightDL2
        var DLFlurryCounter = builder; // "Temporal Mastermind" Prereq: fightDL2
        var bossDLDeathless = builder; // "Eternal Survivor" Prereq: fightDL1
        var soloDL = builder; // "Impossible Odds" Prereq: fightDL1
        var anchorDeathlessDL = builder; // "True Hero" Prereq: anchorEncounter

            // Worldeater
        var worldeaterEncounter = builder; // "Horrific Monstrosity" Prereq: enterLimbo
        var worldeaterDefeat = builder; // "Satiated Hunger" Prereq: worldeaterEncounter
        var worldeaterMax = builder; // "Not Afraid Anymore" Prereq: CFPJolt, worldeaterEncounter

            // Leviathan Skywyrm

        // Early Game (Time Loop)
        var timeLoopActivate = builder; // "Future Vision?" Prereq: fightDL1
        var anchorEncounter = builder; // "Timeless Bond" Prereq: getCrystalDefault
        var anchorDeath = builder; // "Apocalypse" Prereq: anchorEncounter
        var anchorProtect = builder; // "The Fifteen" Prereq: anchorEncounter
        var twistedEncounter = builder; // "Twisted Children" Prereq:getCrystalDefault
        var riftwalkerKill = builder; // "Released From Suffering" getCrystalDefault

        // MidGame (Advancements specific to the timeframe between the ending of the time loop and the crafting of the Starforge)
        var loopEscape = builder; // "Shattered Dimension" Prereq: fightDL2
        var quantumSigil = builder; // "Monstrous Resurrection" Prereq: fightDL2, riftwalkerKill

        // Endgame (post time loop)
        var obtainStarforge = builder
                .display(
                        CCBlocks.T0_STARFORGE.get(),
                        Component.translatable("achievement.causalchaos.starforge_get", "Crystal Catalyst"),
                        Component.translatable("achievement.causalchaos.starforge_get.desc", "Craft a Starforge."),
                        null, FrameType.TASK, true, true, false)
                //.parent(loopEscape)
                .addCriterion("get_starforge", InventoryChangeTrigger.TriggerInstance.hasItems(CCBlocks.T0_STARFORGE.get()))
                .save(consumer, "causalchaos:get_starforge");
        var obtainThundersteel = builder
                .display(
                        CCItems.THUNDERSTEEL_INGOT.get(),
                        Component.translatable("achievement.causalchaos.thundersteel_get", "Ultimate alloy"),
                        Component.translatable("achievement.causalchaos.thundersteel_get.desc", "Obtain Thundersteel."),
                        null, FrameType.TASK, true, true, false)
                .parent(obtainStarforge)
                .addCriterion("get_thundersteel", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.THUNDERSTEEL_INGOT.get()))
                .save(consumer, "causalchaos:get_thundersteel");
        var obtainPerplexium = builder
                .display(
                        CCItems.PERPLEXIUM_INGOT.get(),
                        Component.translatable("achievement.causalchaos.perplexium_get", "Cheap Imitation"),
                        Component.translatable("achievement.causalchaos.perplexium_get.desc", "Obtain Perplexium."),
                        null, FrameType.TASK, true, true, false)
                .parent(obtainThundersteel)
                .addCriterion("get_perplexium", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.PERPLEXIUM_INGOT.get()))
                .save(consumer, "causalchaos:get_perplexium");
        var infusedThundersteel = builder; // "Upgrades, People, Upgrades!" Prereq: obtainPerplexium
        var purePerplexium = builder; // "Unlimited Power!" Prereq: obtainPerplexium
        var villageHousing25 = builder; // "Superhuman City" Prereq: anchorEncounter
        var villagerGift = builder; // "Thank You!" Prereq: anchorEncounter
        var superbossVillage = builder; // "Supreme Sanctuary" Prereq: Tsuna
        var realityGlitch = builder; // "Butterfly Effect" Prereq: stableRiftToken

        // Dimensions
            // Sky Islands
        var enterSkylands = builder; // "Not The Aether" Prereq: mastery3

            // Limbo
        var enterLimbo = builder; // "Oh No..." Prereq: EnterRiftwalkerRealmTear
        var limboDeath = builder; // "Ỷ̷͈̟Õ̵̪U̶̺̥̐ ̴͉̬́̂C̵̱̉͆A̸̝̔͒Ǹ̸̦̤͝'̴̝͗T̴͉͗ ̵̘̣͌E̸͔̹̿̐S̴͇̠̽C̸̩̦̑A̵͍̗̅P̵̻̓Ė̴̲" Prereq: enterLimbo
        var limboEscape = builder; // "Freedom, For Now..." Prereq: enterLimbo
        var stableRiftToken = builder; // "Dimensional Mastery" Prereq: limboEscape
        var limboPortal = builder; // "Self-Imprisonment" Prereq: stableRiftToken

            //Transcendent's Plain
        var TPPortalActivate = builder; // "Gateway to the Infinite" Prereq: getPerplexium
        var EnterTPlain = builder; // "Preeminence" Prereq: Tsuna
        var chaosModeKill = builder; // "Chronicles of Chaos"

            // Realm Tears + Parallel Universes
        var enterRiftwalkerRealmTear = builder; // "Where Am I Now?"
        var enterPlayerRealmTear = builder; // "Not in Kansas Anymore" Prereq: enterRiftwalerRealmTear
        var permanentRealmTear = builder; // "Breezeblocks" Prereq: enterPlayerRealmTear
        var dimensionalAnchor = builder; // "No Place Like Home" Prereq: permanentRealmTear
        var parallelDemonLord = builder; // "Interdimensional Savior" Prereq: enterRiftwalkerRealmTear

        // Superbosses
            // Normal Mode
        var Tsuna = builder; // "Diamonds are Not Forever" Prereq: TPPortalActivate
        var Kai = builder; // "Caught Red Handed" Prereq: enterTPlain
        var Terry = builder; // "Cheaters Never Prosper" Prereq: enterTPlain
        var Lyadova = builder; // "Phobophobia" Prereq: enterTPlain
        var Aella = builder; // "Captivating Chromaticity" Prereq: enterTPlain
        var Jack = builder; // "Entropic Reversion" Prereq: enterTPlain
        var Xanthea = builder; // "Blackest Day" Prereq: enterTPlain
        var Will = builder; // "Faster Than Light" Prereq: enterTPlain
        var Matthue = builder; // "Are You Insane?" Prereq: enterTPlain
        var Alline = builder; // "Questionable Cleric" Prereq: enterTPlain
        var Madeline = builder; // "Someone Else's Shoes" Prereq: enterTPlain
        var Emily = builder; // "Cerebral Invader" Prereq: enterTPlain
        var Adrian = builder; // "Heart of Gold" Prereq: enterTPlain
        var Andrea = builder; // "Angel of Time" Prereq: enterTPlain
        var Christian = builder; // "Perpetual Energy" Prereq: enterTPlain
        var Jolt = builder; // "Thunderstruck" Prereq: enterTPlain
        var FPJolt = builder; // "The Origin" Prereq: Jolt

            // Chaos Mode
        var CTsuna = builder; // "Unbreakable" Prereq: bossRush
        var CKai = builder; // "Big Brother" Prereq: bossRush
        var CTerry = builder; // "High Noon" Prereq: bossRush
        var CLyadova = builder; // "Terrifying Conqueror" Prereq: bossRush
        var CAella = builder; // "Artist's Block" Prereq: bossRush
        var CJack = builder; // "Rogue Planet" Prereq: bossRush
        var CXanthea = builder; // "Umbral Curse" Prereq: bossRush
        var CWill = builder; // "Historical Protector" Prereq: bossRush
        var CMatthue = builder; // "Psychological Degradation" Prereq: bossRush
        var CAlline = builder; // "Discriminitory Hypocrites" Prereq:  bossRush
        var CMadeline = builder; // "Schadenfreude" Prereq: bossRush
        var CEmily = builder; // "Eye of Providence" Prereq: bossRush
        var CAdrian = builder; // "Patient Man's Rage" Prereq: bossRush
        var CAndrea = builder; // "Temporal Valkyrie" Prereq: bossRush
        var CChristian = builder; // "Megalomania" Prereq: bossRush
        var CJolt = builder; // "Singularity Point" Prereq: bossRush
        var CFPJolt = builder; // "Extradimensional Menace" Prereq: CJolt, bossRush

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
                .addCriterion("is_hardcore", HardcoreCheckTrigger.Instance.hardcoreCheck(levelData))
                .save(consumer, "causalchaos:get_crystal_hardcore");

        LivingEntity entity = null;
        LivingDeathEvent event = new LivingDeathEvent(entity, null);
        var hardcoreDeath = builder
                .display(
                        (ItemLike) IconGenerator.RESUSCITATION_ICON,
                        Component.translatable("achievement.causalchaos.hardcore_death", "Resuscitation"),
                        Component.translatable("achievement.causalchaos.hardcore_death.desc",
                                "Embrace mortality, yet defy the fall."), null, FrameType.GOAL, true, true, false)
                .parent(getCrystalHardcore)
                .addCriterion("hardcore_death", HardcoreDeathTrigger.Instance.youDied(event))
                .save(consumer, "causalchaos:hardcore_death");
        var hardcoreDLDefeat = builder; // "Last Stand" Prereq: getCrystalHardcore
        var perfectSuperboss = builder; // "Memento Mori" Prereq: getCrystalHardcore + TPPortalActivate
        var day100 = builder; /// "Indomitable Spirit" Prereq: getCrystalHardcore
        var halfHeartSuperboss = builder; // "Not Even Close" Prereq: getCrystalHardcore + TPPortalActivate

        // Journal Completion
        var journal25 = builder; // "Bare Minimum" Prereq: root
        var journal50 = builder; // "You Actually Studied?" Prereq: journal25
        var journal75 = builder; // "Salutatorian" Prereq: journal50
        var journal100 = builder; // "Valedictorian" journal75

        // Challenges and Funnies
            // Challenges
        var bossRush = builder; // "Manhunt" Prereq: Tsuna, Kai, Terry, Lyadova, Aella, Jack, Xanthea, Will, Matthue, Alline, Madeline, Emily, Adrian, Andrea, Christian, Jolt, FPJolt
        var chaosCompletion = builder; // "Masochistic Persistence" Prereq: CTsuna, CKai, CTerry, CLyadova, CAella, CJack, CXanthea, CWill, CMatthue, CAlline, CMadeline, CEmily, CAdrian, CAndrea, CChristian, CJolt, CFPJolt
        var bossRushHardcore = builder; // "Hardcore Hitman" Prereq: hardcoreDLdefeat, (same as bossRush)
        var chaosCompletionHardcore = builder; // "Perfected Flagellation"  Prereq: bossRushHardcore, (same as chaosCompletion)

            // Funnies
        var blackHoleTP = builder; // "Wormhole'd" Prereq: enterTPlain
        var FPJoltDeath = builder; // "Instant Karma" Prereq: Jolt
        var playerLostMind = builder; // "Straitjacket" Prereq: enterTPlain
        var superweaponOnVanillaMob = builder; // "Unnecessary" Prereq: Tsuna
        var badRNG = builder
                .display(
                        (ItemLike)IconGenerator.NAT1,
                        Component.translatable("achievement.causalchaos.badRNG", "Rolled a 1"),
                        Component.translatable("achievement.causalchaos.badRNG.desc", "RNG hates you."),
                        null, FrameType.TASK,true, true, false)
                // .parent(TPPortalActivate)
                /* Add criteria that allows for hit detecion from RNG-based attacks */
                .save(consumer, "causalchaos:badRNG"); // "Rolled a 1" Prereq: TPPortalActivate

            // Hidden Challenges
        var chaosBossRush = builder; // "Unlimited" Prereq: chaosCompletion
        var chaosBossRushHardcore = builder; // "Boundless" Prereq: chaosCompletionHardcore
    }
}
