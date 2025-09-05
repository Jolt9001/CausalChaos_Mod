package jolt9001.causalchaos.event;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.advancements.HardcoreDeathTrigger;
import jolt9001.causalchaos.common.advancements.SurvivalDeathTrigger;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CausalChaos.MODID)
public class CCEvents {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer sp)) return;

        // Only count hardcore deaths
        if (sp.serverLevel().getLevelData().isHardcore()) {
            HardcoreDeathTrigger.INSTANCE.trigger(sp);
        }

        // Count survival death by default
        SurvivalDeathTrigger.INSTANCE.trigger(sp);
    }
}
