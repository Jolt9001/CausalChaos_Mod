package jolt9001.causalchaos.event;

import jolt9001.causalchaos.CausalChaos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CausalChaos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CCEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions evt) {

    }
    @SubscribeEvent
    public static void RegisterBER(EntityRenderersEvent.RegisterRenderers evt){

    }
}
