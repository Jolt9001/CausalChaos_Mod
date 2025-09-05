package jolt9001.causalchaos.actions.base_impl.dash;

import jolt9001.causalchaos.common.CCCapabilities;
import jolt9001.causalchaos.init.CCItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DashHandler {
    // Dodge timing window: 15 ticks
    public static final int DODGE_WINDOW = 15;

    // Perfect Dodge timing window: 5 ticks
    public static final int P_DODGE_WINDOW = 5;

    // --- tuning knobs ---
    private static final int COOLDOWN_TICKS = 15;           // ~0.75s at 20 TPS = 15 ticks? (adjust as you like)
    private static final double GROUND_RANGE = 5.0;         // blocks
    private static final double AIR_MULTIPLIER = 2.0;       // air dash ~10 blocks
    private static final double WATER_MULTIPLIER = 0.35;    // heavily reduced underwater
    private static final float HUNGER_COST = 2.0F;          // half shank = 1.0F; so 2.0F = 1 full shank
    private static final double VERTICAL_UP = 0.9;          // vertical component when jumpHeld
    private static final double VERTICAL_DOWN = -0.9;       // (if you later want down-dash on sneak)

    // A super-lightweight per-player cooldown using persistent data
    private static final String NBT_LAST_DASH = "cc_last_dash";

    public static void tryDash(ServerPlayer p, Vec3 clientDir, boolean airborne, boolean jumpHeld, boolean sneakHeld) {
        // 1) Gate: must be alive and not mounted
        if (p.isDeadOrDying() || p.isSpectator() || p.isPassenger() || p.isRemoved()) return;

        // 2) Gate: holding Causality Crystal in offhand
        Item causality = CCItems.CAUSALITY_CRYSTAL.get();
        boolean hasCrystal = p.getOffhandItem().is(causality);
        if (!hasCrystal) return;

        // 3) Gate: cooldown
        long now = p.level().getGameTime();
        CompoundTag tag = p.getPersistentData();
        long last = tag.getLong(NBT_LAST_DASH);
        if (now - last < COOLDOWN_TICKS) return;

        // 4) Build server-validated dash direction
        Vec3 dir = sanitizeDirection(p, clientDir, jumpHeld, sneakHeld);
        if (dir == Vec3.ZERO) return;

        // 5) Compute effective range
        boolean onGround = p.onGround();
        boolean inWater = p.isInWaterOrBubble();
        double range = GROUND_RANGE * (onGround ? 1.0 : AIR_MULTIPLIER);
        if (inWater) range *= WATER_MULTIPLIER;

        // Convert “range in blocks” to velocity impulse.
        double groundSpeed = 1.25;   // ~5 blocks in ~4 ticks
        double airSpeed    = 2.25;   // stronger while flying
        double speed = airborne ? airSpeed : groundSpeed;
        double impulse = range * speed; //
        Vec3 current = p.getDeltaMovement();

        // If you want it to “override” lateral velocity:
        Vec3 dash = dir.scale(impulse);
        boolean forceVertical = Math.abs(dir.y) > 0.75;
        Vec3 newVel = forceVertical ? dash : new Vec3(dash.x, current.y + dash.y, dash.z);

        // 6) Apply motion & short friction immunity
        p.hurtMarked = true;
        p.setDeltaMovement(newVel);
        p.hasImpulse = true;

        // Optional: brief fall-damage forgiveness on perfect upward dash
        if (dir.y > 0.6) p.resetFallDistance();

        // 7) Hunger cost (don’t starve them to death)
        if (!p.isCreative() && !p.isSpectator()) {
            FoodData food = p.getFoodData();
            food.setFoodLevel(Math.max(0, food.getFoodLevel() - (int) HUNGER_COST));
            food.setSaturation(Math.max(0, food.getSaturationLevel() - HUNGER_COST));
        }

        // 8) Start cooldown
        tag.putLong(NBT_LAST_DASH, now);

        // 9) SFX/particles (server sends to nearby)
        p.level().playSound(null, p.blockPosition(), SoundEvents.ELYTRA_FLYING, SoundSource.PLAYERS, 0.6F, 1.6F);
        ((ServerLevel) p.level()).sendParticles(ParticleTypes.CLOUD, p.getX(), p.getY() + 0.1, p.getZ(),
                15, 0.15, 0.1, 0.15, 0.05);

        // 10) Dash Strike handling
        p.getCapability(CCCapabilities.DASH_DATA).ifPresent(cap -> {
            cap.setDashTicks(4); // 4 ticks of movement burst
            cap.isDashing();     // one boosted hit each dash
        });

        // Optional: cooldown or stamina (capabilities/attributes hook)
        // CCEnergy.get(player).consume(…); etc.
    }

    private static Vec3 sanitizeDirection(ServerPlayer p, Vec3 clientDir, boolean jumpHeld, boolean sneakHeld) {
        Vec3 dir = clientDir;
        // If client sent zero or garbage, use look vector
        if (dir.lengthSqr() < 1.0E-4) dir = p.getLookAngle();

        // If jump is held: bias to vertical up dash (works mid-air for “bounce”)
        if (jumpHeld) dir = new Vec3(0, VERTICAL_UP, 0);

        // Optional: allow down-dash with sneak
        // else if (sneakHeld) dir = new Vec3(0, VERTICAL_DOWN, 0);

        // Normalize and clamp
        double len = dir.length();
        if (len < 1.0E-4) return Vec3.ZERO;
        dir = dir.scale(1.0 / len);

        // Prevent excessive upward velocity when colliding under ceilings
        if (hitHeadSoon(p) && dir.y > 0) dir = new Vec3(dir.x, 0.1, dir.z);

        return dir;
    }

    private static boolean hitHeadSoon(ServerPlayer p) {
        AABB box = p.getBoundingBox().inflate(0.0, 0.1, 0.0).move(0, 0.2, 0);
        return !p.level().noCollision(p, box);
    }

    private static void checkDodge() {
        // TODO: Handle dodges and perfect dodges using hitboxes displayed by DangerSense ability
    }
}
