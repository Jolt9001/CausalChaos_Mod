package jolt9001.causalchaos.actions.base_impl.dash.dashstrike;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.CCCapabilities;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CausalChaos.MODID)
public class DashCombatHooks {
    private static final float DASH_STRIKE_MULT = 1.5f;

    @SubscribeEvent
    public static void onHurt(LivingHurtEvent e) {
        var src = e.getSource();
        if (!(src.getEntity() instanceof Player player)) return;
        // Only boost “player attacks” (skip fall, magic, explosions, etc.)
        // If you want to be stricter, also check DamageTypes.PLAYER_ATTACK:

        // Option A: require they are currently dashing
        // if (!cap.isDashing()) return;

        if (!src.is(DamageTypeTags.IS_PROJECTILE) && src.getDirectEntity() == player) {
            player.getCapability(CCCapabilities.DASH_DATA).ifPresent(cap -> {
                // Option A: require they are currently dashing
                // if (!cap.isDashing()) return;

                // Option B (recommended): grant a short strike window when dash starts
                if (cap.consumeStrikeWindow()) {
                    e.setAmount(e.getAmount() * DASH_STRIKE_MULT);

                    // (Optional) feedback
                    player.level().broadcastEntityEvent(player, (byte) 46); // crit particles
                    // Or play a custom sound/packet here
                }
            });
        }
    }
}
