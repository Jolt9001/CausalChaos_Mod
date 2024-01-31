package jolt9001.causalchaos.common.triggers;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.world.entity.player.Player;

import java.util.Optional;

public class AdvancementTriggers {

    /**
     * Tutorial Triggers
     */
    public static final PlayerHurtEntityTrigger DASH_STRIKE = new PlayerHurtEntityTrigger();

    /**
     * Ability Triggers
     */
    public static final EntityHurtPlayerTrigger QTE_FAIL = new EntityHurtPlayerTrigger();

    /**
     * Boss Encounter Triggers
     */
    public static final PlayerTrigger SELFLESS = new PlayerTrigger(); // Die to save a passive or friendly mob

    /**
     * Time Loop Triggers
     */
    public static final PlayerTrigger LOOP_RESET = new PlayerTrigger();
    public static final KilledTrigger APOCALYPSE = new KilledTrigger();

    /**
     * Loop Escape Triggers
     */
    public static final KilledTrigger LOOP_ESCAPE = new KilledTrigger(); // Kill the Demon Lord

    /**
     * Endgame Triggers
     */
    public static final PlayerTrigger REALITY_GLITCH = new PlayerTrigger();

    /**
     * Dimension Triggers
     * Sky Islands
     */

    /**
     * Dimension Triggers
     * Limbo
     */
    public static final PlayerTrigger LIMBO_DEATH = new PlayerTrigger(); // You can't escape...
    public static final ChangeDimensionTrigger LIMBO_ESCAPE = new ChangeDimensionTrigger();

    /**
     * Dimension Triggers
     * Parallel Universes
     */
    public static final ChangeDimensionTrigger PARALLEL_UNIVERSE = new ChangeDimensionTrigger();
    public static final ItemUsedOnLocationTrigger STABILIZER = new ItemUsedOnLocationTrigger();

    /**
     * Dimension Triggers
     * Transcendent's Plain
     */

    /**
     * Normal Mode Superbosses
     */

    /**
     * Chaos Mode Superbosses
     */

    /**
     * Hardcore Triggers
     */
    public static final PlayerTrigger HARDCORE_DEATH = new PlayerTrigger(); //Embrace mortality, yet defy the fall.

    /**
     * Causal Journal
     */
    public static final PlayerTrigger JOURNAL_COMPLETION_25 = new PlayerTrigger();
    public static final PlayerTrigger JOURNAL_COMPLETION_50 = new PlayerTrigger();
    public static final PlayerTrigger JOURNAL_COMPLETION_75 = new PlayerTrigger();
    public static final PlayerTrigger JOURNAL_COMPLETION_100 = new PlayerTrigger();
    /**
     * Challenges and Funnies
     */
    public static final PlayerTrigger KARMA = new PlayerTrigger();

    /**
     * Hidden Advancements
     */
    public static final PlayerTrigger BOSS_RUSH = new PlayerTrigger();

    /**
     * Criteria Creation
     * @return Criteria
     */
    public static Criterion<?> hardcoreDeathCriterion() {
        return HARDCORE_DEATH.createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty()));
    }
}
