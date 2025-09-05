package jolt9001.causalchaos.common;

import jolt9001.causalchaos.actions.base_impl.dash.dashstrike.DashDataProvider;
import jolt9001.causalchaos.actions.base_impl.dash.dashstrike.IDashData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CCCapabilities {
    public static final ResourceLocation DASH_DATA_ID = new ResourceLocation("causalchaos", "dash_data");

    // Capability instance
    public static final Capability<IDashData> DASH_DATA =
            CapabilityManager.get(new CapabilityToken<>(){});

    // Called during mod setup
    public static void register(RegisterCapabilitiesEvent event) {
        event.register(IDashData.class);
    }

    // Attach capability to players
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(DASH_DATA_ID, new DashDataProvider());
        }
    }

    // Helper to get capability
    public static LazyOptional<IDashData> getDashData(Player player) {
        return player.getCapability(DASH_DATA);
    }
}
