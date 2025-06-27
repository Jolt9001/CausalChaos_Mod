package jolt9001.causalchaos.common.datagen.generators;

import jolt9001.causalchaos.common.triggers.HardcoreCheckTrigger;
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

import net.minecraft.world.level.storage.WorldData;
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
                        Component.translatable("achievement.causalchaos.root", "Causal Chaos"), //Advancement name
                        Component.translatable("achievement.causalchaos.root.desc",
                                "It might be a good idea to hold on to this."), //Advancement Description
                        null, // background
                        FrameType.TASK, //the shape of the advancement icon
                        false, // showToast
                        false, // announceChat
                        false) // hidden
                .rewards(AdvancementRewards.Builder.loot(new ResourceLocation("causalchaos:gameplay/causal_journal"))) //grant reward in the form of a Causal Journal
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

        var dashStrike = builder; // "I Am Speed"
        var dodge = builder; // "Can't Touch This"
        var dangerSense = builder; // "Spidey Sense"

        // Ability
        var standInHitbox = builder; // "Danger Zone"
        var QTEFail = builder; // "You Blinked"
        var perfectDodge = builder; // "Saw It Coming"
        var lightningDodge = builder; // "Lightning-Fast Reaction"
        var killCreeperWhileExploding = builder; // "Assisted Suicide"

        var mastery1 = builder; // "Sidekick"
        var mastery2 = builder; // "Fledgling"
        var mastery3 = builder; // "Hero"
        var mastery4 = builder; // "Superhero
        var mastery5 = builder; // "Limitless"

        // Bosses (Demon Lord, Worldeater, Leviathan Skywyrm)
            // generic
        var heroDeath = builder; // "Selfless Sacrifice"

            // Demon Lord
        var fightDL1 = builder; // "Great Destroyer"
        var fightDL2 = builder; // "Déjà vu"
        var tripleDLPerfectDodge = builder; // "Chronal Duelist"
        var DLFlurryCounter = builder; // "Temporal Mastermind"
        var bossDLDeathless = builder; // Eternal Survivor"
        var soloDL = builder; // "Impossible Odds"
        var anchorDeathlessDL = builder; // "True Hero"

            // Worldeater
        var worldeaterEncounter = builder; // "Horrific Monstrosity"
        var worldeaterDefeat = builder; // "Satiated Hunger"
        var worldeaterMax = builder; // "Not Afraid Anymore"

            // Leviathan Skywyrm

        // Early Game (Time Loop)
        var timeLoopActivate = builder; // "Future Vision?"
        var anchorEncounter = builder; // "Timeless Bond"
        var anchorDeath = builder; // "Apocalypse"
        var anchorProtect = builder; // "The Fifteen"
        var twistedEncounter = builder; //Twisted Children"
        var riftwalkerKill = builder; // "Released From Suffering"

        // MidGame (Advancements specific to the ending of the time loop)
        var loopEscape = builder; // "Shattered Dimension"

        // Endgame (post time loop)
        var obtainStarforge = builder; // "Crystal Catalyst"
        var obtainThundersteel = builder; // "Ultimate Alloy"
        var obtainPerplexium = builder; // "Cheap Imitation"
        var infusedThundersteel = builder; // "Upgrades, People, Upgrades!"
        var purePerplexium = builder; // "Unlimited Power!"
        var villageHousing25 = builder; // "Superhuman City"
        var villagerGift = builder; // "Thank You!"
        var superbossVillage = builder; // "Supreme Sanctuary"
        var realityGlitch = builder; // "Butterfly Effect"

        // Dimensions
            // Sky Islands
        var enterSkylands = builder; // "Not The Aether"

            // Limbo
        var enterLimbo = builder; // "Oh No..."
        var limboDeath = builder; // "Ỷ̷͈̟Õ̵̪U̶̺̥̐ ̴͉̬́̂C̵̱̉͆A̸̝̔͒Ǹ̸̦̤͝'̴̝͗T̴͉͗ ̵̘̣͌E̸͔̹̿̐S̴͇̠̽C̸̩̦̑A̵͍̗̅P̵̻̓Ė̴̲"
        var limboEscape = builder; // "Freedom, For Now..."
        var stableRiftToken = builder; // "Dimensional Mastery"
        var limboPortal = builder; // "Self-Imprisonment"

            //Transcendent's Plain
        var TPPortalActivate = builder; // "Gateway to the Infinite"
        var EnterTPlain = builder; // "Preeminence"
        var chaosModeKill = builder; // "Chronicles of Chaos"

            // Realm Tears + Parallel Universes
        var enterRiftwalkerRealmTear = builder; // "Where Am I Now?"
        var enterPlayerRealmTear = builder; // "Not in Kansas Anymore"
        var permanentRealmTear = builder; // "Breezeblocks"
        var dimensionalAnchor = builder; // "No Place Like Home"
        var parallelDemonLord = builder; // "Interdimensional Savior"

        // Superbosses
            // Normal Mode
        var Tsuna = builder; // "Diamonds are Not Forever"
        var Kai = builder; // "Caught Red Handed"
        var Terry = builder; // "Cheaters Never Prosper"
        var Lyadova = builder; // "Phobophobia"
        var Aella = builder; // "Captivating Chromaticity"
        var Jack = builder; // "Entropic Reversion"
        var Xanthea = builder; // "Blackest Day"
        var Will = builder; // "Faster Than Light"
        var Matthue = builder; // "Are You Insane?"
        var Alline = builder; // "Questionable Cleric"
        var Madeline = builder; // "Someone Else's Shoes"
        var Emily = builder; // "Cerebral Invader"
        var Adrian = builder; // Heart of Gold"
        var Andrea = builder; // "Angel of Time"
        var Christian = builder; // "Perpetual Energy"
        var Jolt = builder; // "Thunderstruck"
        var FPJolt = builder; // "The Origin"

            // Chaos Mode
        var CTsuna = builder; // "Unbreakable"
        var CKai = builder; // "Big Brother"
        var CTerry = builder; // "High Noon"
        var CLyadova = builder; // "Terrifying Conqueror"
        var CAella = builder; // "Artist's Block"
        var CJack = builder; // "Rogue Planet"
        var CXanthea = builder; // "Umbral Curse"
        var CWill = builder; // "Historical Protector"
        var CMatthue = builder; // "Psychological Degradation"
        var CAlline = builder; // "Discriminitory Hypocrites"
        var CMadeline = builder; // "Schadenfreude"
        var CEmily = builder; // "Eye of Providence"
        var CAdrian = builder; // "Patient Man's Rage"
        var CAndrea = builder; // "Temporal Valkyrie"
        var CChristian = builder; // "Megalomania"
        var CJolt = builder; // "Singularity Point"
        var CFPJolt = builder; // "Extradimensional Menace"

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
                .addCriterion("is_hardcore", HardcoreCheckTrigger.Instance.hardcoreCheck())
                .save(consumer, "causalchaos.main/get_crystal_hardcore");

        LivingEntity entity = null;
        LivingDeathEvent event = new LivingDeathEvent(entity, null);
        var hardcoreDeath = builder
                .display(
                        (ItemLike) IconGenerator.RESUSCITATION_ICON,
                        Component.translatable("achievement.causalchaos.hardcore_death", "Resuscitation"),
                        Component.translatable("achievement.causalchaos.hardcore_death.desc",
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
        var hardcoreDLDefeat = builder; // "Last Stand"
        var perfectSuperboss = builder; // "Memento Mori"
        var day100 = builder; /// "Indomitable Spirit"
        var halfHeartSuperboss = builder; // "Not Even Close"

        // Journal Completion
        var journal25 = builder; // "Bare Minimum"
        var journal50 = builder; // "You Actually Studied?"
        var journal75 = builder; // "Salutatorian"
        var journal100 = builder; // "Valedictorian"

        // Challenges and Funnies
            // Challenges

            // Funnies
        var blackHoleTP = builder; // "Wormhole'd"
        var FPJoltDeath = builder; // "Instant Karma"
        var playerLostMind = builder; // "Straitjacket"
        var superweaponOnVanillaMob = builder; // "Unnecessary"
        var badRNG = builder; // "Rolled a 1"

        // Hidden Challenges
        var bossRush = builder; // "Manhunt"
        var chaosCompletion = builder; // "Masochistic Persistence"
        var chaosCompletionHardcore = builder; // "Boundless"
    }
}
