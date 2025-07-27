package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.advancements.HardcoreCheckTrigger;
import jolt9001.causalchaos.common.advancements.HardcoreDeathTrigger;
import jolt9001.causalchaos.common.datagen.tags.ItemTagGenerator;
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
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.Optional;
import java.util.function.Consumer;

public class CCAdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {

    // protected Consumer<Advancement> advancementConsumer;
    // protected BiConsumer<ResourceLocation, ConditionalAdvancement.Builder> conditionalConsumer;

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper file) {
        // Advancement builder variable for efficiency
        Advancement.Builder builder = Advancement.Builder.advancement();

        // Level Data
        // LevelData levelData = ObfuscationReflectionHelper.getPrivateValue(ServerLevel.class, null, "field_237386_d_");

        // Root
        var root = builder
                .display(
                        CCItems.JOURNAL.get(), //get ItemLike object
                        Component.translatable("achievement.causalchaos.root"), //Advancement name
                        Component.translatable("achievement.causalchaos.root.desc"), //Advancement Description
                        null, // background
                        FrameType.TASK, //the shape of the advancement icon
                        false, // showToast
                        false, // announceChat
                        false) // hidden
                .rewards(AdvancementRewards.Builder.loot(new ResourceLocation("jolt9001.causalchaos:gameplay/causal_journal"))) //grant reward in the form of a Causal Journal
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick()) //Triggered the moment the player joins the world
                .save(consumer, "jolt9001.causalchaos:root"); //Save the advancement


        // Tutorial
        var getCrystalDefault = builder
                .display(
                        CCItems.CAUSALITY_CRYSTAL.get(),
                        Component.translatable("achievement.causalchaos.crystal_get"),
                        Component.translatable("achievement.causalchaos.crystal_get.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_root_0", this.advancementTrigger(root))
                .addCriterion("get_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.CAUSALITY_CRYSTAL.get()))
                .save(consumer, "jolt9001.causalchaos:get_crystal");
        var dashStrike = builder; // "I Am Speed" Prereq: "adv_crystal_default_0", getCrystalDefault
        var dodge = builder; // "Can't Touch This" Prereq: "adv_crystal_default_1", getCrystalDefault
        var dangerSense = builder; // "Spidey Sense" Prereq: "adv_crystal_default_2", getCrystalDefault

        // Ability
        var standInHitbox = builder; // "Danger Zone" Prereq: "adv_danger_sense_0", dangerSense
        var QTEFail = builder; // "You Blinked" Prereq: "adv_in_hitbox_0", standInHitbox
        var perfectDodge = builder; // "Saw It Coming" Prereq: "adv_in_hitbox_1", standInHitbox, dodge
        var lightningDodge = builder; // "Lightning-Fast Reaction" Prereq: "adv_perfect_dodge_0", perfectDodge
        var killCreeperWhileExploding = builder; // "Allahu Akbar" Prereq: "adv_perfect_dodge_1", perfectDodge

        var mastery1 = builder; // "Sidekick" Prereq: "adv_crystal_default_3", getCrystalDefault
        var mastery2 = builder; // "Fledgling" Prereq: "adv_lvl1_0", mastery1
        var mastery3 = builder; // "Hero" Prereq: "adv_lvl2_0" - mastery2 . "adv_loop_active_0", timeLoopActivate
        var mastery4 = builder; // "Superhero" Prereq: "adv_lvl3_0", mastery3 . "adv_escape_loop_0", loopEscape
        var mastery5 = builder; // "Limitless" Prereq: "adv_lvl4_0", mastery4 . "adv_enter_tp_0" EnterTPlain

        // Bosses (Demon Lord, Worldeater, Leviathan Skywyrm)
            // generic
        var heroDeath = builder; // "Selfless Sacrifice" Prereq: "adv_fail_qte_1", QTEFail

            // Demon Lord
        var fightDL1 = builder; // "Great Destroyer" Prereq: "adv_crystal_default_4", getCrystalDefault
        var fightDL2 = builder; // "Déjà vu" Prereq: "adv_dl1_0", "adv_dl1_0", fightDL1
        var tripleDLPerfectDodge = builder; // "Chronal Duelist" Prereq: "adv_dl2_0", fightDL2
        var DLFlurryCounter = builder; // "Temporal Mastermind" Prereq: "adv_dl2_1", fightDL2
        var bossDLDeathless = builder; // "Eternal Survivor" Prereq: "adv_dl1_1", fightDL1
        var soloDL = builder; // "Impossible Odds" Prereq: "adv_dl1_2", fightDL1
        var anchorDeathlessDL = builder; // "True Hero" Prereq: anchorEncounter

            // Worldeater
        var worldeaterEncounter = builder; // "Horrific Monstrosity" Prereq: enterLimbo
        var worldeaterDefeat = builder; // "Satiated Hunger" Prereq: worldeaterEncounter
        var worldeaterLoss = builder; // "Unexisted" Prereq: worldeaterEncounter
        var worldeaterMax = builder; // "Not Afraid Anymore" Prereq: CFPJolt . worldeaterEncounter

            // Leviathan Skywyrm
        var skywyrmEncounter = builder;
        var skywyrmDefeat = builder;
        var skywyrmLoss = builder;

        // Early Game (Time Loop)
        var timeLoopActivate = builder; // "Future Vision?" Prereq: "adv_dl1_2", fightDL1
        var anchorEncounter = builder; // "Timeless Bond" Prereq: "adv_crystal_default_5", getCrystalDefault
        var anchorDeath = builder; // "Apocalypse" Prereq: anchorEncounter
        var anchorProtect = builder; // "The Fifteen" Prereq: anchorEncounter
        var twistedEncounter = builder; // "Twisted Children" Prereq: "adv_crystal_default_6", getCrystalDefault
        var riftwalkerKill = builder; // "Released From Suffering" "adv_crystal_default_7", getCrystalDefault

        // MidGame (Advancements specific to the timeframe between the ending of the time loop and the crafting of the Starforge)
        var loopEscape = builder; // "Shattered Dimension" Prereq: "adv_dl2_2", fightDL2
        var quantumSigil = builder; // "Monstrous Resurrection" Prereq: "adv_dl2_3", fightDL2 . riftwalkerKill

        // Endgame (post time loop)
        var obtainStarforge = builder
                .display(
                        CCBlocks.T0_STARFORGE.get(),
                        Component.translatable("achievement.causalchaos.starforge_get"),
                        Component.translatable("achievement.causalchaos.starforge_get.desc"),
                        null, FrameType.TASK, true, true, false)
                //.addCriterion("adv_escape_loop_1", this.advancementTrigger(loopEscape))
                .addCriterion("get_starforge", InventoryChangeTrigger.TriggerInstance.hasItems(CCBlocks.T0_STARFORGE.get()))
                .save(consumer, "jolt9001.causalchaos:get_starforge");
        var obtainThundersteel = builder
                .display(
                        CCItems.THUNDERSTEEL_INGOT.get(),
                        Component.translatable("achievement.causalchaos.thundersteel_get"),
                        Component.translatable("achievement.causalchaos.thundersteel_get.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_starforge_0", this.advancementTrigger(obtainStarforge))
                .addCriterion("get_thundersteel", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.THUNDERSTEEL_INGOT.get()))
                .save(consumer, "jolt9001.causalchaos:get_thundersteel");
        var obtainPerplexium = builder
                .display(
                        CCItems.PERPLEXIUM_INGOT.get(),
                        Component.translatable("achievement.causalchaos.perplexium_get"),
                        Component.translatable("achievement.causalchaos.perplexium_get.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_thundersteel", this.advancementTrigger(obtainThundersteel))
                .addCriterion("get_perplexium", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.PERPLEXIUM_INGOT.get()))
                .save(consumer, "jolt9001.causalchaos:get_perplexium");
        var infusedThundersteelArmor = builder
                .display(
                        CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE.get(),
                        Component.translatable("achievement.causalchaos.thundersteel_infuse_armor"),
                        Component.translatable("achievement.causalchaos.thundersteel_infuse_armor.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_perplexium_0", this.advancementTrigger(obtainPerplexium))
                .addCriterion("thundersteel_infuse_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTagGenerator.ARMORS_INFUSED_THUNDERSTEEL)))
                .save(consumer, "jolt9001.causalchaos:thundersteel_infuse_armor");
        var infusedThundersteelTool = builder
                .display(
                        CCItems.INFUSED_THUNDERSTEEL_SWORD.get(),
                        Component.translatable("achievement.causalchaos.thundersteel_infuse_tool"),
                        Component.translatable("achievement.causalchaos.thundersteel_infuse_tool.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_perplexium_1", this.advancementTrigger(obtainPerplexium))
                .addCriterion("thundersteel_infuse_tool", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTagGenerator.TOOLS_INFUSED_THUNDERSTEEL)))
                .save(consumer, "jolt9001.causalchaos:thundersteel_infuse_tool");
        var purePerplexiumArmor = builder
                .display(
                        CCItems.PERPLEXIUM_CHESTPLATE.get(),
                        Component.translatable("achievement.causalchaos.perplexium_armor"),
                        Component.translatable("achievement.causalchaos.perplexium_armor.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_perplexium_2", this.advancementTrigger(obtainPerplexium))
                .addCriterion("perplexium_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTagGenerator.ARMORS_PERPLEXIUM)))
                .save(consumer, "jolt9001.causalchaos:perplexium_armor");
        var purePerplexiumTool = builder
                .display(
                        CCItems.PERPLEXIUM_SWORD.get(),
                        Component.translatable("achievement.causalchaos.perplexium_tool"),
                        Component.translatable("achievement.causalchaos.perplexium_tool.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_perplexium_3", this.advancementTrigger(obtainPerplexium))
                .addCriterion("perplexium_tool", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTagGenerator.TOOLS_PERPLEXIUM)))
                .save(consumer, "jolt9001.causalchaos:perplexium_tool");
        var villageHousing25 = builder; // "Superhuman City" Prereq: anchorEncounter
        var villagerGift = builder; // "Thank You!" Prereq: anchorEncounter
        var superbossVillage = builder; // "Supreme Sanctuary" Prereq: Jolt
        var realityGlitch = builder; // "Butterfly Effect" Prereq: stableRiftToken

        // Dimensions
            // Sky Islands
        var enterSkylands = builder; // "Not The Aether" Prereq: mastery3
        var findStorm = builder;
        var perfectElytra = builder;

            // Limbo
        var enterLimbo = builder; // "Oh No..." Prereq: EnterRiftwalkerRealmTear
        var limboDeath = builder; // "Ỷ̷͈̟Õ̵̪U̶̺̥̐ ̴͉̬́̂C̵̱̉͆A̸̝̔͒Ǹ̸̦̤͝'̴̝͗T̴͉͗ ̵̘̣͌E̸͔̹̿̐S̴͇̠̽C̸̩̦̑A̵͍̗̅P̵̻̓Ė̴̲" Prereq: enterLimbo
        var limboEscape = builder; // "Freedom, For Now..." Prereq: enterLimbo
        var stableRiftToken = builder; // "Dimensional Mastery" Prereq: limboEscape
        var limboPortal = builder; // "Self-Imprisonment" Prereq: stableRiftToken

            //Transcendent's Plain
        var TPPortalEnter = builder; // "Gateway to the Infinite" Prereq: getPerplexium
        var EnterTPlain = builder; // "Preeminence" Prereq: Tsuna
        var chaosModeKill = builder; // "Chronicles of Chaos" Prereq:

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
        /*
        var getCrystalHardcore = builder
                .display(
                        CCItems.CAUSALITY_CRYSTAL.get(),
                        Component.translatable("achievement.causalchaos.hardcore_crystal_get"),
                        Component.translatable("achievement.causalchaos.hardcore_crystal_get.desc"),
                        null, FrameType.TASK, true, true, false
                )
                .parent(getCrystalDefault)
                // .addCriterion("get_crystal_hardcore", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.CAUSALITY_CRYSTAL.get()))
                .addCriterion("is_hardcore", HardcoreCheckTrigger.Instance.hardcoreCheck(levelData))
                .save(consumer, "jolt9001.causalchaos:get_crystal_hardcore");

        LivingEntity entity = null;
        LivingDeathEvent event = new LivingDeathEvent(entity, null);
        var hardcoreDeath = builder
                .display(
                        (ItemLike) IconGenerator.RESUSCITATION_ICON,
                        Component.translatable("achievement.causalchaos.hardcore_death", "Resuscitation"),
                        Component.translatable("achievement.causalchaos.hardcore_death.desc"),
                        null, FrameType.GOAL, true, true, false)
                .addCriterion("adv_crystal_hardcore0", this.advancementTrigger(getCrystalHardcore))
                .addCriterion("hardcore_death", HardcoreDeathTrigger.Instance.youDied(event))
                .save(consumer, "jolt9001.causalchaos:hardcore_death");
 */
        var hardcoreDLDefeat = builder; // "Last Stand" Prereq: getCrystalHardcore
        var perfectSuperboss = builder; // "Memento Mori" Prereq: getCrystalHardcore + TPPortalActivate
        var day100 = builder; /// "Indomitable Spirit" Prereq: getCrystalHardcore
        var halfHeartSuperboss = builder; // "Not Even Close" Prereq: getCrystalHardcore + TPPortalActivate

        // Journal Completion
        var journal25 = builder; // "Bare Minimum" Prereq: "adv_root_1", root
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
/*
        var badRNG = builder
                .display(
                        (ItemLike) IconGenerator.NAT1,
                        Component.translatable("achievement.causalchaos.superboss_bad_rng"),
                        Component.translatable("achievement.causalchaos.superboss_bad_rng.desc"),
                        null, FrameType.TASK,true, true, false)
                .addCriterion("tp_portal_activate", this.advancementTrigger(TPPortalActivate))
                // Add criteria that allows for hit detecion from RNG-based attacks
                .save(consumer, "jolt9001.causalchaos:badRNG"); // "Rolled a 1" Prereq: TPPortalActivate
 */
            // Hidden Challenges
        var chaosBossRush = builder; // "Unlimited" Prereq: chaosCompletion
        var chaosBossRushHardcore = builder; // "Boundless" Prereq: chaosCompletionHardcore
    }
    private Criterion<PlayerTrigger.TriggerInstance> advancementTrigger(AdvancementHolder advancement) {
        return this.advancementTrigger(advancement.id().getPath());
    }

    private Criterion<PlayerTrigger.TriggerInstance> advancementTrigger(String name) {
        return CriteriaTriggers.TICK.createCriterion(new PlayerTrigger.TriggerInstance(Optional.of(ContextAwarePredicate.create(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().subPredicate(PlayerPredicate.Builder.player().checkAdvancementDone(CausalChaos.prefix(name), true).build())).build()))));
    }
}
