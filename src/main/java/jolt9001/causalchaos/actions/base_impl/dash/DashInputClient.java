package jolt9001.causalchaos.actions.base_impl.dash;

import jolt9001.causalchaos.library.input.CCKeyRecorder;
import jolt9001.causalchaos.library.input.CCKeybinds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class DashInputClient {
    private static int dashCooldownTicks = 0; // UI-side only so we don't spam the command

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent e) {
        if (e.phase != TickEvent.Phase.END) return;
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) return;

        if (dashCooldownTicks > 0) dashCooldownTicks--;

        // when your key state says "pressed" this tick
        if (CCKeyRecorder.keyDash.isPressed() && dashCooldownTicks == 0) {
            // Encode a little context with the command using flags:
            // j=jump held, s=sneak held
            boolean j = CCKeybinds.getKeyJump().isDown();
            boolean s = CCKeybinds.getKeySneak().isDown();

            String flags = (j ? "j" : "") + (s ? "s" : "");
            if (flags.isEmpty()) flags = "-";

            // Send vanilla command packet to server
            if (mc.player.connection != null) {
                mc.player.connection.sendCommand("cc_dash " + flags);
            }

            // small client-side throttle so we don't spam packets
            dashCooldownTicks = 6;
        }
    }
}