package jolt9001.causalchaos.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;

public final class PortalSoundUtil {
    /**
     * Based on {@link net.minecraft.client.renderer.LevelRenderer levelEvent(int, BlockPos, int)}, event 1032.
     */
    public static void playPortalSound(LocalPlayer localPlayer) {
        //Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forLocalAmbience(CCSoundEvents.BLOCK_TRANSCENDENT_PORTAL_TRAVEL.get(), localPlayer.level().getRandom().nextFloat() * 0.4F + 0.8F, 0.25F));
    }
}
