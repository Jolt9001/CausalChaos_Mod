package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource.masks;

public final class FerventFieldSpiralMask {
    public static final class Params {
        public final double cx, cz;       // biome center in world coords
        public final double a;            // Starting point (≥ rCore)
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
     * <font color=#9932CC>if</font> <font color="yellow">baseBiome</font> == <font color="green">ferventField</font>:<br>
     * <font color=#9932CC>if</font> r <= <font color=#CD5C5C>rCore</font> → <font color=#9932CC>return</font> <font color="gray">unityVariant.</font><br>
     * <font color=#9932CC>else</font> determine boolean <font color=#6495ED>isYin</font>(<font color=#DAA520>x</font>, <font color=#DAA520>z</font>, <font color=#DAA520>seed</font>, <font color=#DAA520>params</font>, <font color=#DAA520>phase</font>). <br>
     * <font color=#9932CC>if true</font> → <font color="black">yinVariant</font>, else <font color="white">yangVariant</font>.
     * @param x reference x coordinate
     * @param z reference z corrdinate
     * @param worldSeed world seed
     * @param p Params
     * @param phase Log spiral phase
     * @return boolean isYin
     */
    public static boolean isYin(int x, int z, long worldSeed, Params p, double phase) {

        double dx = x - p.cx;
        double dz = z - p.cz;
        final double r  = Math.hypot(dx, dz);
        if (r <= p.rCore) return false; // let caller pick UNITY biome inside the core radius

        // angle in [0, ∞), we count windings by theta
        double th = Math.atan2(dz, dx);  // [-π, π]
        th = toPositiveAngle(th);

        /*
         Limited Logarithmic spiral.
         We want distance to nearest “arm” modulo 2π with optional phase.
         Euler spiral is defined as x(t) = ∫0-1 cos(πu^2)du, y(t) = ∫0-1 sin(πu^2)du
         I'm using a parametric substitute: r1(θ) = rCore+(r0-rCore)e^(-b), r2(θ) = rCore+(r0-rCore)e^(-bθ)*e^(-bπ)
         a = starting radius scale; b = tightening rate
        */
        final double R0   = Math.max(1e-6, p.a - p.rCore);                            // how far the first arm sits above rCore
        final double ref0 = p.rCore + R0 * Math.exp(-p.b * (th + phase));             // “Yin” arm
        final double ref1 = p.rCore + R0 * Math.exp(-p.b * (th + (phase + Math.PI))); // "Yang" arm

        // distance to each arm (radial distance works well because arms are nearly orthogonal to radial)
        double d0 = Math.abs(r - ref0);
        double d1 = Math.abs(r - ref1);

        // Add a tiny seed-based jitter so seams don’t look too perfect
        double j = jitter(worldSeed, x, z, 0xC0FFEE) * p.jitter;

        double dMin  = Math.min(d0, d1) + j;
        boolean onArm = dMin <= p.armWidth;

        if (onArm) {
            // If we’re within the physical arm band, arm identity = nearest arm.
            return d0 <= d1;
        }

        // In the gaps between windings, alternate rings as we wind inward.
        // Every π of theta we cross an arm (because the other arm is θ-shifted by π).
        int winding = (int) Math.floor((th + phase) / Math.PI);
        boolean even = (winding & 1) == 0;

        // Side of nearest arm: outside (r > ref) vs inside (r < ref)
        double refNearest = (d0 <= d1) ? ref0 : ref1;
        boolean outside   = r > refNearest;

        // Rule: alternate by winding; outside nearest arm on even windings = Yin, flip on odd.
        return even == outside;
    }

    // --- helpers ---
    /**
     * Map angle from [-π,π] to [0, ∞) by adding whole 2π turns
     * @param a number of full turns
     * @return a
     */
    private static double toPositiveAngle(double a) {
        if (a < 0) {
            double turns = Math.ceil(-a / (2.0 * Math.PI));
            a += turns * 2.0 * Math.PI;
        }
        return a;
    }

    /**
     * Tiny deterministic jitter (value in [-1,1]) to break straight edges:<br>
     * First, create a long value <font color=#7FFF00>s</font> and multiply inputs by constants.<br>
     * Next, pass <font color=#7FFF00>s</font> into the SplitMix64 bit-mixer to scramble nearby values of (x, z) don't correlate.<br>
     * Then, take the upper 23 bits of <font color=#7FFF00>s</font> and downcast to <font color=#9932CC>int</font><br>
     * Finally, normalize <font color=#7FFF00>s</font> to <font color=#FFD700>[0, ~8191]</font> and remap to <font color=#FFD700>~[-1, 1]</font>
     * @param seed Global world Seed
     * @param x x coordinate
     * @param z z coordinate
     * @param salt extra tweak parameter (used to differentiate multiple jitter passes with the same seed)
     * @return int jitter value
     */
    private static double jitter(long seed, int x, int z, int salt) {
        // Multiply inputs by constants. XOR into long s
        long s = seed ^ (x * 0x9E3779B97F4A7C15L) ^ (z * 0xC2B2AE3D27D4EB4FL) ^ (salt * 0x632BE59BD9B4E019L);

        // SplitMix64 Finalizer: Bit-Mixer - Hashing blender
        s ^= (s >>> 30); s *= 0xBF58476D1CE4E5B9L;
        s ^= (s >>> 27); s *= 0x94D049BB133111EBL;
        s ^= (s >>> 31);

        // take the upper 23 bits of s, downcast to int, normalize to [0, ~8191], remap to ~[-1,1]
        return ((int)(s >>> 41) / 1023.0 ) * 2.0 - 1.0;
    }
}