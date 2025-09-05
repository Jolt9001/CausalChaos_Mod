package jolt9001.causalchaos.actions;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.actions.base_impl.dash.ServerboundDashPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.*;

@Mod.EventBusSubscriber(modid = CausalChaos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class CCNetwork {
    private static final String PROTOCOL = "1";
    public static final SimpleChannel CHANNEL = ChannelBuilder
            .named(new ResourceLocation("causalchaos", "main"))
            .networkProtocolVersion(Integer.parseInt(PROTOCOL))
            .clientAcceptedVersions((status, v) -> true)   // accept any for dev; tighten later
            .serverAcceptedVersions((status, v) -> true)
            .simpleChannel();

    private static int id = 0;
    private static int nextId() { return id++; }

    public static void register() {
        // Serverbound: client → server when player dashes
        CHANNEL.messageBuilder(ServerboundDashPacket.class, nextId(), NetworkDirection.PLAY_TO_SERVER)
                .encoder(ServerboundDashPacket::encode)
                .decoder(ServerboundDashPacket::decode)
                .consumerMainThread(ServerboundDashPacket::handle)
                .add();
    }
}