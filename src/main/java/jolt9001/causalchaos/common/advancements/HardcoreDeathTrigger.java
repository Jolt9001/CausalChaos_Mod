package jolt9001.causalchaos.common.advancements;

import com.google.gson.JsonObject;
import jolt9001.causalchaos.CausalChaos;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

/**
 * Criterion trigger used to check for when a player gets unalived
 */
public class HardcoreDeathTrigger extends SimpleCriterionTrigger<HardcoreDeathTrigger.Instance> {
    public static final ResourceLocation ID = new ResourceLocation(CausalChaos.MODID, "hardcore_death");
    public static final HardcoreDeathTrigger INSTANCE = new HardcoreDeathTrigger();

    public ResourceLocation getId() {
        return ID; // <-- critical: JSON "trigger": "modid:hardcore_death"
    }

    // 1.20.1-style parsing path (if you're < 1.20.3)
    @Override
    protected Instance createInstance(JsonObject json,
                                      Optional<ContextAwarePredicate> playerPredicate,
                                      DeserializationContext ctx) {
        return new Instance(playerPredicate);
    }

    public void trigger(ServerPlayer player) {
        // let the predicate (if any) decide; we just check hardcore outside
        this.trigger(player, inst -> true);
    }

    // This Instance is minimal because you don't have extra conditions
    public static class Instance extends AbstractCriterionTriggerInstance {
        public Instance(Optional<ContextAwarePredicate> playerPredicate) {
            super(playerPredicate);
        }

        // ---- Datagen helper: use this in your Advancement builder ----
        public static Criterion<Instance> youDied() {
            return HardcoreDeathTrigger.INSTANCE.createCriterion(new Instance(Optional.empty()));
        }
    }
}
