package jolt9001.causalchaos.common.triggers;

import jolt9001.causalchaos.common.handlers.PlayerDeathHandler;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import java.util.Optional;

public class PlayerDeathTriggers {

    /**
     * Triggers
     */
    public static final PlayerTrigger SURVIVAL_DEATH = new PlayerTrigger();
    public static final PlayerTrigger HARDCORE_DEATH = new PlayerTrigger();

    /**
     * Criteria
     */
    public static Criterion<?> playerDeathCriterion() {
        return SURVIVAL_DEATH.createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty()));
    }

    public static Criterion<?> hardcoreDeathCriterion() {
        return HARDCORE_DEATH.createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty()));
    }

    /**
     * Initialization
     */
    public static void init() {
        CriteriaTriggers.register("causalchaos:survival_death", SURVIVAL_DEATH);
        CriteriaTriggers.register("causalchaos:hardcore_death", HARDCORE_DEATH);
    }
}
