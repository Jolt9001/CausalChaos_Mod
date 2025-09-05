package jolt9001.causalchaos.common.advancements;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.*;

public class CCAdvancements {

    /**
     * Tutorial Triggers
     */
    public static final PlayerHurtEntityTrigger DASH_STRIKE = new PlayerHurtEntityTrigger();
    public static final HardcoreCheckTrigger HARDCORE_CHECK = CriteriaTriggers.register("hardcore_check", new HardcoreCheckTrigger());

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
    public static final PlayerDeathTrigger PLAYER_DEATH = CriteriaTriggers.register("jolt9001.causalchaos:hardcore_death", new PlayerDeathTrigger());

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

    public static void init() {}
}
