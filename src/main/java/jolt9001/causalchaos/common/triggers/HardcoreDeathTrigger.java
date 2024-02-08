package jolt9001.causalchaos.common.triggers;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Optional;

/**
 * Criterion trigger used to check for when a player gets unalived in hardcore mode
 */
public class HardcoreDeathTrigger extends SimpleCriterionTrigger<HardcoreDeathTrigger.Instance> {
    public static final HardcoreDeathTrigger INSTANCE = new HardcoreDeathTrigger();

    @Override
    protected HardcoreDeathTrigger.Instance createInstance(JsonObject json, Optional<ContextAwarePredicate> predicate, DeserializationContext context) {
        return new HardcoreDeathTrigger.Instance(predicate);
    }

    public void trigger(ServerPlayer player) {
        if (player.level().getLevelData().isHardcore()) {
            this.trigger(player, (instance) -> true);
        }
    }

    public static class Instance extends AbstractCriterionTriggerInstance {
        public Instance(Optional<ContextAwarePredicate> predicate) {
            super(predicate);
        }

        public static Criterion<Instance> youDied(LivingDeathEvent event) {
            if (event.getEntity() instanceof ServerPlayer) {
                return INSTANCE.createCriterion(new HardcoreDeathTrigger.Instance(Optional.empty()));
            }
            return null;
        }
    }
}
