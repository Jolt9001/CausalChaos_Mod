package jolt9001.causalchaos.common.advancements;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Optional;

public class SurvivalDeathTrigger extends SimpleCriterionTrigger<SurvivalDeathTrigger.Instance> {
    public static final SurvivalDeathTrigger INSTANCE = new SurvivalDeathTrigger();
    @Override
    protected SurvivalDeathTrigger.Instance createInstance(JsonObject json, Optional<ContextAwarePredicate> predicate, DeserializationContext context) {
        return new SurvivalDeathTrigger.Instance(predicate);
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, (instance) -> true);
    }

    public static class Instance extends AbstractCriterionTriggerInstance {
        public Instance(Optional<ContextAwarePredicate> predicate) {
            super(predicate);
        }
        public static Criterion<SurvivalDeathTrigger.Instance> youDied(LivingDeathEvent event) {
            if (event.getEntity() instanceof ServerPlayer) {
                return INSTANCE.createCriterion(new SurvivalDeathTrigger.Instance(Optional.empty()));
            }
            return null;
        }
    }
}
