package jolt9001.causalchaos.common.advancements;

import com.google.gson.JsonObject;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.storage.LevelData;

import java.util.Optional;

/**
 * Criterion to check if the player is in hardcore mode
 */
public class HardcoreCheckTrigger extends SimpleCriterionTrigger<HardcoreCheckTrigger.Instance> {
    public static final HardcoreCheckTrigger INSTANCE = new HardcoreCheckTrigger();

    @Override
    protected HardcoreCheckTrigger.Instance createInstance(JsonObject json, Optional<ContextAwarePredicate> predicate, DeserializationContext context) {
        return new HardcoreCheckTrigger.Instance(predicate);
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

        public static Criterion<HardcoreCheckTrigger.Instance> hardcoreCheck(LevelData data) {
            if (data.isHardcore()) {
                return INSTANCE.createCriterion(new HardcoreCheckTrigger.Instance(Optional.empty()));
            }
            return null;
        }
    }
}
