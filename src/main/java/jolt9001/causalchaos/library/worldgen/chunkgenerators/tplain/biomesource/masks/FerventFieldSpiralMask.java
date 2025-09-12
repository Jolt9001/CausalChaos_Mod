package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.masks;

import net.minecraft.client.gui.screens.worldselection.WorldCreationUiState;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.world.level.levelgen.WorldOptions;
import net.minecraft.world.level.storage.WorldData;

public final class FerventFieldSpiralMask {
    public enum Variant { YIN, YANG, UNITY, OUT }

    public static final class Params {
        public final double cx, cz;       // biome center in world coords
        public final double a;            // base radius (≥ 1)
        public final double b;            // growth rate (>0); larger = faster tightening
        public final double armWidth;     // physical half-width of each arm (blocks)
        public final double gap;          // min gap between arms (blocks)
        public final double rCore;        // UNITY radius (blocks) to avoid overlap near origin
        public final double jitter;       // small noise (blocks) to break perfect symmetry

        public Params(double cx, double cz, double a, double b, double armWidth, double gap, double rCore, double jitter) {
            this.cx = cx;
            this.cz = cz;
            this.a = a;
            this.b = b;
            this.armWidth = armWidth;
            this.gap = gap;
            this.rCore = rCore;
            this.jitter = jitter;
        }
    }

    /**
     * Sample the mask at world (x,z).
     */
    public static Variant sample(int x, int z, Params p, long seed) {
        // Position relative to center
        double dx = (x + jitter(seed, x, z, 0) * p.jitter) - p.cx;
        double dz = (z + jitter(seed, x, z, 1) * p.jitter) - p.cz;
        double r  = Math.hypot(dx, dz);
        if (r <= p.rCore) return Variant.UNITY;

        // Angle in [-π, π]
        double theta = Math.atan2(dz, dx);

        /*
         For a logarithmic spiral r = a * e^(b * θ).
         Given r, the "ideal" angle of the spiral passing through r is θ* = ln(r/a)/b.
        */
        double thetaStar = Math.log(Math.max(r, 1e-6) / p.a) / p.b;

        /*
         Distance-to-curve metric: angular deviation (wrapped to [-π, π]) * radius ≈ normal distance.
         Arm A (YIN): phase = 0; Arm B (YANG): phase = π. Both wind with same b.
        */
        double dA = radialAngularDistance(theta, thetaStar, 0.0, r);
        double dB = radialAngularDistance(theta, thetaStar, Math.PI, r);

        // Pick nearest arm and apply width + gap. If both are close, prefer UNITY or keep nearest.
        double halfWidth = p.armWidth * 0.5;
        if (dA < dB) {
            if (dA <= halfWidth) return Variant.YIN;
            if (dA <= halfWidth + p.gap) return Variant.OUT;
            return Variant.OUT;
        } else {
            if (dB <= halfWidth) return Variant.YANG;
            if (dB <= halfWidth + p.gap) return Variant.OUT;
            return Variant.OUT;
        }
    }
    public static boolean isYin(int x, int z, long worldSeed,
                                double cx, double cz,
                                double a, double b,          // spiral params
                                double armWidth,             // thickness in blocks
                                double phaseOffset) {
        double dx = x - cx;
        double dz = z - cz;
        double r  = Math.hypot(dx, dz);
        double th = Math.atan2(dz, dx);  // [-π, π]

        // Log spiral reference radius at this theta: r* ~ a * e^(b*theta)
        // We want distance to nearest “arm” modulo 2π with optional phase.
        double ref = a * Math.exp(b * (th + phaseOffset));
        double dist = Math.abs(r - ref);

        // Add a tiny seed-based jitter so seams don’t look too perfect
        double j = jitter(worldSeed, x, z,  0xC0FFEE);
        dist += j;

        // Inside one arm?
        boolean inArm = dist <= armWidth;

        // Yin/Yang split by alternating arms: e.g., even/odd “windings”
        // Use theta / (2π / b) as a crude alternating ring index:
        double ringIdx = (Math.log(Math.max(1e-6, r / Math.max(1e-6, a))) / b) / (2 * Math.PI);
        boolean evenRing = (((long)Math.floor(ringIdx)) & 1L) == 0L;

        // Example rule: yin = in arm on even rings, or out of arm on odd rings
        return (evenRing && inArm) || (!evenRing && !inArm);
    }

    // --- helpers ---
    private static double radialAngularDistance(double theta, double thetaStar, double phase, double r) {
        // Choose the 2π-wrapped angle difference that minimizes |Δθ|
        double dTheta = wrapToPi((theta - phase) - thetaStar);
        // Convert angular error to an approximate physical distance along the normal
        return Math.abs(dTheta) * r;
    }

    private static double wrapToPi(double a) {
        a = (a + Math.PI) % (2.0 * Math.PI);
        if (a < 0) a += 2.0 * Math.PI;
        return a - Math.PI;
    }

    // Tiny deterministic jitter (value in [-1,1]) to break straight edges if you want it
    private static double jitter(long seed, int x, int z, int salt) {
        long s = seed ^ (x * 0x9E3779B97F4A7C15L) ^ (z * 0xC2B2AE3D27D4EB4FL) ^ (salt * 0x632BE59BD9B4E019L);
        s ^= (s >>> 30); s *= 0xBF58476D1CE4E5B9L;
        s ^= (s >>> 27); s *= 0x94D049BB133111EBL;
        s ^= (s >>> 31);
        return ( (int)(s >>> 41) / 1023.0 ) * 2.0 - 1.0; // ~[-1,1]
    }
}