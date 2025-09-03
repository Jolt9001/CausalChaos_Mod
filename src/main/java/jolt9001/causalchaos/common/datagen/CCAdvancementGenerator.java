package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.advancements.HardcoreCheckTrigger;
import jolt9001.causalchaos.common.advancements.HardcoreDeathTrigger;
import jolt9001.causalchaos.common.datagen.tags.ItemTagGenerator;
import jolt9001.causalchaos.init.CCBlocks;
import jolt9001.causalchaos.init.CCEntities;
import jolt9001.causalchaos.init.CCStructures;
import jolt9001.causalchaos.library.worldgen.biome.CCBiomes;
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
    // Advancement nb() variable for efficiency
    private static Advancement.Builder nb() {
        return Advancement.Builder.advancement();
    }

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> consumer, ExistingFileHelper file) {
        Advancement.Builder builder = Advancement.Builder.advancement();

        // Level Data
        // LevelData levelData = ObfuscationReflectionHelper.getPrivateValue(ServerLevel.class, null, "field_237386_d_");

        // Root
        var root = nb()
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
        var getCrystalDefault = nb()
                .parent(root)
                .display(
                        CCItems.CAUSALITY_CRYSTAL.get(),
                        Component.translatable("achievement.causalchaos.crystal_get"),
                        Component.translatable("achievement.causalchaos.crystal_get.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_root_0", this.advancementTrigger(root))
                .addCriterion("get_crystal", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.CAUSALITY_CRYSTAL.get()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:get_crystal");
        var dashStrike = nb(); // "I Am Speed" Prereq: "adv_crystal_default_0", getCrystalDefault
        var dodge = nb(); // "Can't Touch This" Prereq: "adv_crystal_default_1", getCrystalDefault
        var dangerSense = nb(); // "Spidey Sense" Prereq: "adv_crystal_default_2", getCrystalDefault

        // Ability
        var standInHitbox = nb(); // "Danger Zone" Prereq: "adv_danger_sense_0", dangerSense
        var QTEFail = nb(); // "You Blinked" Prereq: "adv_in_hitbox_0", standInHitbox
        var perfectDodge = nb(); // "Saw It Coming" Prereq: "adv_in_hitbox_1", standInHitbox, dodge
        var parry = nb(); // "Denied"
        var perfectParry = nb(); // "Damage Reflection"

        // Ability Mastery - Based on experience factor of Causality Crystal
        /*
        Dash: 1 xp
        Dash Strike: 3 xp
        Dodge: 5 xp
        Danger Sense: 1 xp
        Hitbox detection: 3xp
        Perfect Dodge: 10 xp
        Parry: 10 xp
        Perfect Parry: 20 xp
        Flight: 1 xp per second
        Elytra flight: 3 xp per second
        Use weapon ability: 5-15 xp per use
        Total xp needed for max level: 3,975
        */
        var mastery1 = nb(); // "Sidekick" Prereq: "adv_crystal_default_3", getCrystalDefault                    50 xp
        var mastery2 = nb(); // "Fledgling" Prereq: "adv_lvl1_0", mastery1                                       125 xp
        var mastery3 = nb(); // "Hero" Prereq: "adv_lvl2_0" - mastery2 . "adv_loop_active_0", timeLoopActivate   350 xp
        var mastery4 = nb(); // "Superhero" Prereq: "adv_lvl3_0", mastery3 . "adv_escape_loop_0", loopEscape     950 xp
        var mastery5 = nb(); // "Limitless" Prereq: "adv_lvl4_0", mastery4 . "adv_enter_tp_0" EnterTPlain        2500 xp

        // Bosses (Demon Lord, Worldeater, Leviathan Skywyrm)
            // generic
        var heroDeath = nb(); // "Selfless Sacrifice" Prereq: "adv_fail_qte_1", QTEFail

            // Demon Lord
        var fightDL1 = nb(); // "Great Destroyer" Prereq: "adv_crystal_default_4", getCrystalDefault
        var fightDL2 = nb(); // "Déjà vu" Prereq: "adv_dl1_0", "adv_dl1_0", fightDL1
        var tripleDLPerfectDodge = nb(); // "Chronal Duelist" Prereq: "adv_dl2_0", fightDL2
        var DLFlurryCounter = nb(); // "Temporal Mastermind" Prereq: "adv_dl2_1", fightDL2
        var bossDLDeathless = nb(); // "Eternal Survivor" Prereq: "adv_dl1_1", fightDL1
        var soloDL = nb(); // "Impossible Odds" Prereq: "adv_dl1_2", fightDL1
        var anchorDeathlessDL = nb(); // "True Hero" Prereq: "adv_anchor_find_0", anchorEncounter

            // Worldeater
        var worldeaterEncounter = nb(); // "Horrific Monstrosity" Prereq: "adv_enter_limbo_0", enterLimbo
        var worldeaterDefeat = nb()/*
                .display(
                        CCBlocks.REALMWEAVE_BLOCK.get(),
                        Component.translatable("achievement.causalchaos.worldeater_win"),
                        Component.translatable("achievement.causalchaos.worldeater_win.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_worldeater_0", this.advancementTrigger(worldeaterEncounter))
                .addCriterion("worldeater_kill", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.nb().entity().of(CCEntities.WORLDEATER.get())))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:worldeater_win")*/; // "Satiated Hunger" Prereq: "adv_worldeater_0", worldeaterEncounter
        var worldeaterLoss = nb()/*
                .display(
                        CCBlocks.REALMWEAVE_BLOCK.get(),
                        Component.translatable("achievement.causalchaos.worldeater_loss"),
                        Component.translatable("achievement.causalchaos.worldeater_loss.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_worldeater_1", this.advancementTrigger(worldeaterEncounter))
                .addCriterion("die_to_worleater", KilledTrigger.TriggerInstance.entityKilledPlayer(EntityPredicate.nb().entity().of(CCEntities.WORLDEATER.get())))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:worldeater_loss")*/; // "Unexisted" Prereq: "adv_worldeater_1", worldeaterEncounter
        var worldeaterMax = nb(); // "Not Afraid Anymore" Prereq: "adv_cfpjolt_0", CFPJolt . "adv_worldeater_2" worldeaterEncounter

            // Leviathan Skywyrm
        var skywyrmEncounter = nb();
        var skywyrmDefeat = nb();
        var skywyrmLoss = nb();

        // Early Game (Time Loop)
        var timeLoopActivate = nb(); // "Future Vision?" Prereq: "adv_dl1_2", fightDL1
        var anchorEncounter = nb(); // "Timeless Bond" Prereq: "adv_crystal_default_5", getCrystalDefault
        var anchorDeath = nb(); // "Apocalypse" Prereq: "adv_anchor_find_1", anchorEncounter
        var anchorProtect = nb(); // "The Fifteen" Prereq: "adv_anchor_find_2", anchorEncounter
        var twistedEncounter = nb(); // "Twisted Children" Prereq: "adv_crystal_default_6", getCrystalDefault
        var riftwalkerKill = nb()/*.display(
                        CCItems.WORLD_THREAD.get(),
                        Component.translatable("achievement.causalchaos.riftwalker_kill"),
                        Component.translatable("achievement.causalchaos.riftwalker_kill.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("riftwalker_kill", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.nb().entity().of(CCEntities.RIFTWALKER_SCOUT.get())))
                .addCriterion("adv_crystal_default_7", this.advancementTrigger(getCrystalDefault))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:riftwalker_kill")*/; // "Released From Suffering" Prereq: "adv_crystal_default_7", getCrystalDefault

        // MidGame (Advancements specific to the timeframe between the ending of the time loop and entering Transcendent's Plain)
        var loopEscape = nb()/*
                .parent(fightDL2)
                .display(
                        CCItems.WORLD_THREAD.get(),
                        Component.translatable("achievement.causalchaos.dl_win"),
                        Component.translatable("achievement.causalchaos.dl_win.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("dl_kill", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.nb().entity().of(CCEntities.DEMON_LORD.get())))
                .addCriterion("adv_dl2_2", this.advancementTrigger(fightDL2))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:dl_win")*/; // "Shattered Dimension" Prereq: "adv_dl2_2", fightDL2
        var quantumSigil = nb()
                //.parent(fightDL2)
                .display(
                        CCItems.QUANTUM_SIGIL.get(),
                        Component.translatable("achievement.causalchaos.quantum_sigil"),
                        Component.translatable("achievement.causalchaos.quantum_sigil.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("has_quantum_sigil", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.QUANTUM_SIGIL.get()))
                //.addCriterion("adv_dl2_3", this.advancementTrigger(fightDL2))
                //.addCriterion("adv_riftwalker_kill_0", this.advancementTrigger(riftwalkerKill))
                //.requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:quantum_sigil");
        var obtainStarforge = nb()
                .display(
                        CCBlocks.T0_STARFORGE.get(),
                        Component.translatable("achievement.causalchaos.starforge_get"),
                        Component.translatable("achievement.causalchaos.starforge_get.desc"),
                        null, FrameType.TASK, true, true, false)
                //.addCriterion("adv_escape_loop_1", this.advancementTrigger(loopEscape))
                .addCriterion("get_starforge", InventoryChangeTrigger.TriggerInstance.hasItems(CCBlocks.T0_STARFORGE.get()))
                //.requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:get_starforge");
        var obtainThundersteel = nb()
                .parent(obtainStarforge)
                .display(
                        CCItems.THUNDERSTEEL_INGOT.get(),
                        Component.translatable("achievement.causalchaos.thundersteel_get"),
                        Component.translatable("achievement.causalchaos.thundersteel_get.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_starforge_0", this.advancementTrigger(obtainStarforge))
                .addCriterion("get_thundersteel", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.THUNDERSTEEL_INGOT.get()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:get_thundersteel");
        var obtainPerplexium = nb()
                .parent(obtainThundersteel)
                .display(
                        CCItems.PERPLEXIUM_INGOT.get(),
                        Component.translatable("achievement.causalchaos.perplexium_get"),
                        Component.translatable("achievement.causalchaos.perplexium_get.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_thundersteel", this.advancementTrigger(obtainThundersteel))
                .addCriterion("get_perplexium", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.PERPLEXIUM_INGOT.get()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:get_perplexium");
        var infusedThundersteelArmor = nb()
                .parent(obtainPerplexium)
                .display(
                        CCItems.INFUSED_THUNDERSTEEL_CHESTPLATE.get(),
                        Component.translatable("achievement.causalchaos.thundersteel_infuse_armor"),
                        Component.translatable("achievement.causalchaos.thundersteel_infuse_armor.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_perplexium_0", this.advancementTrigger(obtainPerplexium))
                .addCriterion("thundersteel_infuse_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTagGenerator.ARMORS_INFUSED_THUNDERSTEEL).build()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:thundersteel_infuse_armor");
        var infusedThundersteelTool = nb()
                .parent(obtainPerplexium)
                .display(
                        CCItems.INFUSED_THUNDERSTEEL_SWORD.get(),
                        Component.translatable("achievement.causalchaos.thundersteel_infuse_tool"),
                        Component.translatable("achievement.causalchaos.thundersteel_infuse_tool.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_perplexium_1", this.advancementTrigger(obtainPerplexium))
                .addCriterion("thundersteel_infuse_tool", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTagGenerator.TOOLS_INFUSED_THUNDERSTEEL).build()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:thundersteel_infuse_tool");
        var purePerplexiumArmor = nb()
                .parent(obtainPerplexium)
                .display(
                        CCItems.PERPLEXIUM_CHESTPLATE.get(),
                        Component.translatable("achievement.causalchaos.perplexium_armor"),
                        Component.translatable("achievement.causalchaos.perplexium_armor.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_perplexium_2", this.advancementTrigger(obtainPerplexium))
                .addCriterion("perplexium_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTagGenerator.ARMORS_PERPLEXIUM).build()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:perplexium_armor");
        var purePerplexiumTool = nb()
                .parent(obtainPerplexium)
                .display(
                        CCItems.PERPLEXIUM_SWORD.get(),
                        Component.translatable("achievement.causalchaos.perplexium_tool"),
                        Component.translatable("achievement.causalchaos.perplexium_tool.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_perplexium_3", this.advancementTrigger(obtainPerplexium))
                .addCriterion("perplexium_tool", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ItemTagGenerator.TOOLS_PERPLEXIUM).build()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:perplexium_tool");

        // Endgame (post Starforge)
        var villageHousing25 = nb(); // "Superhuman City" Prereq: "adv_anchor_find_3", anchorEncounter
        var villagerGift = nb(); // "Thank You!" Prereq: "adv_anchor_find_4", anchorEncounter
        var superbossVillage = nb(); // "Supreme Sanctuary" Prereq: "adv_jolt_0", Jolt
        var realityGlitch = nb(); // "Butterfly Effect" Prereq: "adv_stable_rt_0", stableRiftToken

        // Dimensions
            // Sky Islands
        var enterSkylands = nb(); // "Not The Aether" Prereq: "adv_lvl3_1", mastery3 . "adv_loop_escape_0", loopEscape
        var findStorm = nb(); //
        var perfectElytra = nb(); //

            // Limbo
        var enterLimbo = nb(); // "Oh No..." Prereq: "adv_realm_tear_rw_0", EnterRiftwalkerRealmTear
        var limboDeath = nb(); // "Ỷ̷͈̟Õ̵̪U̶̺̥̐ ̴͉̬́̂C̵̱̉͆A̸̝̔͒Ǹ̸̦̤͝'̴̝͗T̴͉͗ ̵̘̣͌E̸͔̹̿̐S̴͇̠̽C̸̩̦̑A̵͍̗̅P̵̻̓Ė̴̲" Prereq: "adv_enter_limbo_1", enterLimbo
        var limboEscape = nb(); // "Freedom, For Now..." Prereq: "adv_enter_limbo_2", enterLimbo
        var stableRiftToken = nb(); // "Dimensional Mastery" Prereq: "adv_limbo_escape_0", limboEscape
        var limboPortal = nb(); // "Self-Imprisonment" Prereq: adv_stable_rt_1", stableRiftToken

            //Transcendent's Plain
        var TPPortalEnter = nb()
                .display(
                        CCBlocks.QUANTUM_FABRIC.get(),
                        Component.translatable("achievement.causalchaos.tp_portal"),
                        Component.translatable("achievement.causalchaos.tp_portal.desc"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("adv_perplexium_4", this.advancementTrigger(obtainPerplexium))
                .addCriterion("portal_enter", ChangeDimensionTrigger.TriggerInstance.changedDimension())
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:tpportal_enter"); // "Gateway to the Infinite" Prereq: "adv_perplexium_4", getPerplexium
        var EnterTPlain = nb()
                .display(
                        CCItems.CRYSTAL_KEY.get(),
                        Component.translatable("achievement.causalchaos.tp_enter"),
                        Component.translatable("achievement.causalchaos.tp_enter.desc"),
                        null, FrameType.TASK, true, true, false)
                //.addCriterion("adv_tsuna_0", this.advancementTrigger(Tsuna))
                .addCriterion("leave_portal_cage", ItemUsedOnLocationTrigger.TriggerInstance.itemUsedOnBlock(
                        LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(CCBlocks.WARP_PAD.get())),
                        ItemPredicate.Builder.item().of(CCItems.CRYSTAL_KEY.get())))
                //.requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:enter_tplain"); // "Preeminence" Prereq: "adv_tsuna_0", Tsuna
        var chaosModeKill = nb(); // "Chronicles of Chaos" Prereq: "adv_fpjolt_0", FPJolt

            // Realm Tears + Parallel Universes
        var enterRiftwalkerRealmTear = nb(); // "Where Am I Now?"
        var enterPlayerRealmTear = nb(); // "Not in Kansas Anymore" Prereq: "adv_realm_tear_rw_1", enterRiftwalerRealmTear
        var permanentRealmTear = nb(); // "Breezeblocks" Prereq: "adv_realm_tear_pl_0", enterPlayerRealmTear
        var dimensionalAnchor = nb(); // "No Place Like Home" Prereq: "adv_realm_tear_perm_0", permanentRealmTear
        var parallelDemonLord = nb(); // "Interdimensional Savior" Prereq: "adv_realm_tear_rw_1", enterRiftwalkerRealmTear

        // Superbosses
            // Normal Mode
        var Tsuna = nb(); // "Diamonds are Not Forever" Prereq: "adv_tp_portal_0", TPPortalActivate
        var Kai = nb(); // "Caught Red Handed" Prereq: "adv_enter_tp_1", enterTPlain
        var Terry = nb(); // "Cheaters Never Prosper" Prereq: "adv_enter_tp_2", enterTPlain
        var Lyadova = nb(); // "Phobophobia" Prereq: "adv_enter_tp_3", enterTPlain
        var Aella = nb(); // "Captivating Chromaticity" Prereq: "adv_enter_tp_4", enterTPlain
        var Jack = nb(); // "Entropic Reversion" Prereq: "adv_enter_tp_5", enterTPlain
        var Xanthea = nb(); // "Blackest Day" Prereq: "adv_enter_tp_6", enterTPlain
        var Will = nb(); // "Faster Than Light" Prereq: "adv_enter_tp_7", enterTPlain
        var Matthue = nb(); // "Are You Insane?" Prereq: "adv_enter_tp_8", enterTPlain
        var Alline = nb(); // "Questionable Cleric" Prereq: "adv_enter_tp_9", enterTPlain
        var Madeline = nb(); // "Someone Else's Shoes" Prereq: "adv_enter_tp_10", enterTPlain
        var Emily = nb(); // "Cerebral Invader" Prereq: "adv_enter_tp_11", enterTPlain
        var Adrian = nb(); // "Heart of Gold" Prereq: "adv_enter_tp_12", enterTPlain
        var Andrea = nb(); // "Angel of Time" Prereq: "adv_enter_tp_13", enterTPlain
        var Christian = nb(); // "Perpetual Energy" Prereq: "adv_enter_tp_14", enterTPlain
        var Jolt = nb(); // "Thunderstruck" Prereq: "adv_enter_tp_15", enterTPlain
        var FPJolt = nb(); // "The Origin" Prereq: "adv_jolt_1", Jolt

            // Chaos Mode
        var CTsuna = nb(); // "Unbreakable" Prereq: "adv_boss_rush_0", bossRush
        var CKai = nb(); // "Big Brother" Prereq: "adv_boss_rush_1", bossRush
        var CTerry = nb(); // "High Noon" Prereq: "adv_boss_rush_2", bossRush
        var CLyadova = nb(); // "Terrifying Conqueror" Prereq: "adv_boss_rush_3", bossRush
        var CAella = nb(); // "Artist's Block" Prereq: "adv_boss_rush_4", bossRush
        var CJack = nb(); // "Rogue Planet" Prereq: "adv_boss_rush_5", bossRush
        var CXanthea = nb(); // "Umbral Curse" Prereq: "adv_boss_rush_6", bossRush
        var CWill = nb(); // "Historical Protector" Prereq: "adv_boss_rush_7", bossRush
        var CMatthue = nb(); // "Psychological Degradation" Prereq: "adv_boss_rush_8", bossRush
        var CAlline = nb(); // "Discriminitory Hypocrites" Prereq: "adv_boss_rush_9", bossRush
        var CMadeline = nb(); // "Schadenfreude" Prereq: "adv_boss_rush_10", bossRush
        var CEmily = nb(); // "Eye of Providence" Prereq: "adv_boss_rush_11", bossRush
        var CAdrian = nb(); // "Patient Man's Rage" Prereq: "adv_boss_rush_12", bossRush
        var CAndrea = nb(); // "Temporal Valkyrie" Prereq: "adv_boss_rush_13", bossRush
        var CChristian = nb(); // "Megalomania" Prereq: "adv_boss_rush_14", bossRush
        var CJolt = nb(); // "Singularity Point" Prereq: "adv_boss_rush_15", bossRush
        var CFPJolt = nb(); // "Extradimensional Menace" Prereq: "adv_cjolt_0", CJolt . bossRush

        // Hardcore
        /*
        var getCrystalHardcore = nb()
                .display(
                        CCItems.CAUSALITY_CRYSTAL.get(),
                        Component.translatable("achievement.causalchaos.hardcore_crystal_get"),
                        Component.translatable("achievement.causalchaos.hardcore_crystal_get.desc"),
                        null, FrameType.TASK, true, true, false
                )
                .addCriterion("adv_crystal_default_8", this.advancementTrigger(getCrystalDefault))
                .addCriterion("get_crystal_hardcore", InventoryChangeTrigger.TriggerInstance.hasItems(CCItems.CAUSALITY_CRYSTAL.get()))
                .addCriterion("is_hardcore", HardcoreCheckTrigger.Instance.hardcoreCheck(levelData))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:get_crystal_hardcore");

        LivingEntity entity = null;
        LivingDeathEvent event = new LivingDeathEvent(entity, null);
        var hardcoreDeath = nb()
                .display(
                        (ItemLike) IconGenerator.RESUSCITATION_ICON, // Particle Effect
                        Component.translatable("achievement.causalchaos.hardcore_death"),
                        Component.translatable("achievement.causalchaos.hardcore_death.desc"),
                        null, FrameType.GOAL, true, true, false)
                .addCriterion("adv_crystal_hardcore_0", this.advancementTrigger(getCrystalHardcore))
                .addCriterion("hardcore_death", HardcoreDeathTrigger.Instance.youDied(event))
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:hardcore_death");
 */
        var hardcoreDLDefeat = nb(); // "Last Stand" Prereq: "adv_crystal_hardcore_1", getCrystalHardcore
        var perfectSuperboss = nb(); // "Memento Mori" Prereq: "adv_crystal_hardcore_2", getCrystalHardcore . "adv_tp_portal_1", TPPortalActivate
        var day100 = nb(); /// "Indomitable Spirit" Prereq: "adv_crystal_hardcore_3", getCrystalHardcore
        var halfHeartSuperboss = nb(); // "Not Even Close" Prereq: "adv_crystal_hardcore_4", getCrystalHardcore . "adv_tp_portal_2", TPPortalActivate

        // Journal Completion
        var journal25 = nb(); // "Bare Minimum" Prereq: "adv_root_1", root
        var journal50 = nb(); // "You Actually Studied?" Prereq: "adv_journal25", journal25
        var journal75 = nb(); // "Salutatorian" Prereq: "adv_journal50", journal50
        var journal100 = nb(); // "Valedictorian" "adv_journal75", journal75

        // Challenges and Funnies
            // Challenges
        var bossRush = nb(); // "Manhunt" Prereq: Tsuna, Kai, Terry, Lyadova, Aella, Jack, Xanthea, Will, Matthue, Alline, Madeline, Emily, Adrian, Andrea, Christian, Jolt, FPJolt
        var chaosCompletion = nb(); // "Masochistic Persistence" Prereq: CTsuna, CKai, CTerry, CLyadova, CAella, CJack, CXanthea, CWill, CMatthue, CAlline, CMadeline, CEmily, CAdrian, CAndrea, CChristian, CJolt, CFPJolt
        var bossRushHardcore = nb(); // "Hardcore Hitman" Prereq: "adv_hard_DL_win_0", hardcoreDLdefeat, (same as bossRush)
        var chaosCompletionHardcore = nb(); // "Perfected Flagellation"  Prereq: bossRushHardcore, (same as chaosCompletion)

            // Funnies
        var lightningDodge = nb(); // "Lightning-Fast Reaction" Prereq: "adv_perfect_dodge_0", perfectDodge
        var killCreeperWhileExploding = nb(); // "Allahu Akbar" Prereq: "adv_perfect_dodge_1", perfectDodge
        var superweaponOnVanillaMob = nb(); // "Unnecessary" Prereq: "adv_tsuna_2", Tsuna
        var blackHoleTP = nb(); // "Wormhole'd" Prereq: "adv_enter_tp_16", enterTPlain
        var playerLostMind = nb(); // "Straitjacket" Prereq: "adv_enter_tp_17", enterTPlain
        var FPJoltDeath = nb(); // "Instant Karma" Prereq: "adv_jolt_2", Jolt
/*
        var badRNG = nb()
                .display(
                        (ItemLike) IconGenerator.NAT1,
                        Component.translatable("achievement.causalchaos.superboss_bad_rng"),
                        Component.translatable("achievement.causalchaos.superboss_bad_rng.desc"),
                        null, FrameType.TASK,true, true, false)
                .addCriterion("adv_tp_portal_3", this.advancementTrigger(TPPortalActivate))
                // Add criteria that allows for hit detecion from RNG-based attacks such as Aella's Prismatic Grenades
                .requirements(AdvancementRequirements.Strategy.AND)
                .save(consumer, "jolt9001.causalchaos:badRNG");
 */
            // Hidden Challenges
        var chaosBossRush = nb(); // "Unlimited" Prereq: chaosCompletion
        var chaosBossRushHardcore = nb(); // "Boundless" Prereq: chaosCompletionHardcore
    }
    private Criterion<PlayerTrigger.TriggerInstance> advancementTrigger(AdvancementHolder advancement) {
        return this.advancementTrigger(advancement.id().getPath());
    }

    private Criterion<PlayerTrigger.TriggerInstance> advancementTrigger(String name) {
        return CriteriaTriggers.TICK.createCriterion(new PlayerTrigger.TriggerInstance(Optional.of(ContextAwarePredicate.create(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().subPredicate(PlayerPredicate.Builder.player().checkAdvancementDone(CausalChaos.prefix(name), true).build())).build()))));
    }
}
