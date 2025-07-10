package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class CCSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, CausalChaos.MODID);

    public static final RegistryObject<SoundEvent> PORTAL_WHOOSH = createEvent("block.causalchaos.portal.whoosh");

    private static RegistryObject<SoundEvent> createEvent(String sound) {
        return SOUNDS.register(sound, () -> SoundEvent.createVariableRangeEvent(CausalChaos.prefix(sound)));
    }
}
