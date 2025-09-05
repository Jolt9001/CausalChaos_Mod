package jolt9001.causalchaos.actions.base_impl.dash;


import jolt9001.causalchaos.common.CCCapabilities;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.network.CustomPayloadEvent;

import java.util.function.Supplier;

public class ServerboundDashPacket {
    // Minimal payload: desired dash vector & whether airborne
    private final float dx, dy, dz;
    private final boolean airborne, jumpHeld, sneakHeld;

    public ServerboundDashPacket(float dx, float dy, float dz, boolean airborne, boolean jumpHeld, boolean sneakHeld) {
        this.dx = dx; this.dy = dy; this.dz = dz; this.airborne = airborne; this.jumpHeld = jumpHeld; this.sneakHeld = sneakHeld;
    }

    public static void encode(ServerboundDashPacket msg, FriendlyByteBuf buf) {
        buf.writeFloat(msg.dx);
        buf.writeFloat(msg.dy);
        buf.writeFloat(msg.dz);
        buf.writeBoolean(msg.airborne);
        buf.writeBoolean(msg.jumpHeld);
        buf.writeBoolean(msg.sneakHeld);
    }

    public static ServerboundDashPacket decode(FriendlyByteBuf buf) {
        return new ServerboundDashPacket(buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readBoolean(), buf.readBoolean(), buf.readBoolean());
    }

    // Handler runs on the network thread – enqueue work to the main thread
    public static void handle(ServerboundDashPacket msg, CustomPayloadEvent.Context ctx) {;
        ctx.enqueueWork(() -> {
            ServerPlayer player = ctx.getSender();
            if (player == null) return;
            DashHandler.tryDash(player, new Vec3(msg.dx, msg.dy, msg.dz), msg.airborne, msg.jumpHeld, msg.sneakHeld);
        });
        ctx.setPacketHandled(true);
    }
}