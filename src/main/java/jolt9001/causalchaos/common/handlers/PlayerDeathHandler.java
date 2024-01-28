package jolt9001.causalchaos.common.handlers;

import com.google.gson.JsonObject;
import jolt9001.causalchaos.common.triggers.PlayerDeathTriggers;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerPlayer;

import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import jolt9001.causalchaos.CausalChaos;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = CausalChaos.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerDeathHandler {

    private static final ResourceLocation DEATH = new ResourceLocation(CausalChaos.MODID);
    public static final CriterionTriggerInstance INSTANCE = CriteriaTriggers.register("player_death", new CriterionTrigger());

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof ServerPlayer) {
            ServerPlayer player = (ServerPlayer) event.getEntity();
            if (player.level().getLevelData().isHardcore()) {
                PlayerDeathTriggers.HARDCORE_DEATH.trigger(player);
            } else {
                PlayerDeathTriggers.SURVIVAL_DEATH.trigger(player);
            }
        }
    }

    public static void instanceTrigger(PlayerAdvancements adv) {
        DEATH.trigger(adv);
    }

    static class CriterionTriggerInstance extends AbstractCriterionTriggerInstance {
        public CriterionTriggerInstance() {
            super(Optional.empty());
        }

        @Override
        public void trigger(PlayerAdvancements advancements) {
            for (AdvancementProgress progress : advancements.getOrStartProgress("")) {
                Advancement adv = progress.getAdvancement();
                progress.getCriterion("").grant();
            }
        }
    }

    /*
    static class CriterionTrigger implements net.minecraft.advancements.CriterionTrigger<CriterionTriggerInstance> {
        public void addPlayerListener(PlayerAdvancements advs, Listener<CriterionTriggerInstance> listener) {
            // Implementation
        }

        @Override
        public void removePlayerListener(PlayerAdvancements advs, Listener<CriterionTriggerInstance> listener) {
            // Implementation
        }

        @Override
        public void removePlayerListeners(PlayerAdvancements advs) {
            //Implementation
        }

        CriterionTrigger() {
            super();
        }

        public CriterionTriggerInstance createInstance(JsonObject json, DeserializationContext cond) {
            // Implementation
            return null;
        }

        public void trigger(PlayerAdvancements advancements) {
            for (AdvancementProgress progress : advancements.getOrStartProgress(addPlayerListener())) {
                progress.getCriterion(this.toString());
            }
        }

        public static class Instance {
            public Instance() {
            }

            public ResourceLocation getCriterion() {
                return DEATH;
            }

            // Implement any additional logic for the criterion instance
        }
    } */
}