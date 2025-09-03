package jolt9001.causalchaos.actions.base_impl.dash;


import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.network.CustomPayloadEvent;

import java.util.function.Supplier;

public class ServerboundDashPacket {
    // Minimal payload: desired dash vector & whether airborne
    private final float dx, dy, dz;
    private final boolean airborne;

    public ServerboundDashPacket(float dx, float dy, float dz, boolean airborne) {
        this.dx = dx; this.dy = dy; this.dz = dz; this.airborne = airborne;
    }

    public static void encode(ServerboundDashPacket msg, FriendlyByteBuf buf) {
        buf.writeFloat(msg.dx);
        buf.writeFloat(msg.dy);
        buf.writeFloat(msg.dz);
        buf.writeBoolean(msg.airborne);
    }

    public static ServerboundDashPacket decode(FriendlyByteBuf buf) {
        return new ServerboundDashPacket(buf.readFloat(), buf.readFloat(), buf.readFloat(), buf.readBoolean());
    }

    // Handler runs on the network thread – enqueue work to the main thread
    public static void handle(ServerboundDashPacket msg, Supplier<CustomPayloadEvent.Context> ctxSupplier) {
        CustomPayloadEvent.Context ctx = ctxSupplier.get();
        ctx.enqueueWork(() -> {
            ServerPlayer player = ctx.getSender();
            if (player == null) return;

            // Basic guardrails (server-authoritative sanity checks)
            if (player.isDeadOrDying() || player.isSpectator()) return;

            // Normalize incoming vector; clamp magnitude
            Vec3 v = new Vec3(msg.dx, msg.dy, msg.dz);
            if (v.lengthSqr() < 1e-6) return;
            v = v.normalize();

            // Scale dash speed (tweak to taste)
            double groundSpeed = 1.25;   // ~5 blocks in ~4 ticks
            double airSpeed    = 2.25;   // stronger while flying
            double speed = msg.airborne ? airSpeed : groundSpeed;

            // Apply velocity “impulse”; keep some vertical if requested
            Vec3 current = player.getDeltaMovement();
            Vec3 dash = new Vec3(v.x * speed, v.y * speed * 0.35, v.z * speed);
            // If you want it to “override” lateral velocity:
            Vec3 newVel = new Vec3(dash.x, current.y + dash.y, dash.z);

            player.setDeltaMovement(newVel);
            player.hurtMarked = true; // force client move update

            // Optional: cooldown or stamina (capabilities/attributes hook)
            // CCEnergy.get(player).consume(…); etc.
        });
        ctx.setPacketHandled(true);
    }
}