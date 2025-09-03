package jolt9001.causalchaos.actions.base_impl.timeloop.adv_persist;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.ServerAdvancementManager;
import net.minecraft.server.level.ServerPlayer;

import java.util.*;

public final class AdvSnapshotUtil {
    private AdvSnapshotUtil() {}

    // Helpers to deal with Iterable<String>
    private static boolean any(Iterable<String> it) {
        return it.iterator().hasNext();
    }
    private static Set<String> toSet(Iterable<String> it) {
        Set<String> s = new HashSet<>();
        for (String x : it) s.add(x);
        return s;
    }

    // --- SNAPSHOT ---
    public static Map<ResourceLocation, Set<String>> snapshot(ServerPlayer sp) {
        Map<ResourceLocation, Set<String>> out = new HashMap<>();
        ServerAdvancementManager advIndex = sp.server.getAdvancements();                // registry of advancements
        PlayerAdvancements pa = sp.getAdvancements();                       // per-player progress

        for (AdvancementHolder holder : advIndex.getAllAdvancements()) {
            AdvancementProgress prog = pa.getOrStartProgress(holder);
            // works regardless of Iterable vs Set
            Iterable<String> completed = prog.getCompletedCriteria();
            if (prog.isDone() || any(completed)) {
                out.put(holder.id(), new HashSet<>((Collection) prog.getCompletedCriteria()));
            }
        }
        return out;
    }

    // === RESTORE (non-destructive) ===
    public static void restore(ServerPlayer sp, Map<ResourceLocation, Set<String>> saved) {
        if (saved == null || saved.isEmpty()) return;

        ServerAdvancementManager advIndex = sp.server.getAdvancements();
        PlayerAdvancements pa = sp.getAdvancements();

        for (Map.Entry<ResourceLocation, Set<String>> e : saved.entrySet()) {
            AdvancementHolder holder = advIndex.get(e.getKey());             // null if id disappeared
            if (holder == null) continue;

            AdvancementProgress cur = pa.getOrStartProgress(holder);
            Set<String> done = (Set<String>) cur.getCompletedCriteria();

            for (String crit : e.getValue()) {
                if (!done.contains(crit)) {
                    pa.award(holder, crit);                                  // syncs to client automatically
                }
            }
        }
    }

    // === (optional) STRICT restore that also revokes anything not in snapshot ===
    public static void restoreStrict(ServerPlayer sp, Map<ResourceLocation, Set<String>> saved) {
        restore(sp, saved); // first ensure all saved criteria are granted

        ServerAdvancementManager advIndex = sp.server.getAdvancements();
        PlayerAdvancements pa = sp.getAdvancements();

        for (AdvancementHolder holder : advIndex.getAllAdvancements()) {
            AdvancementProgress cur = pa.getOrStartProgress(holder);
            Set<String> keep = saved.getOrDefault(holder.id(), Collections.emptySet());
            // copy to avoid concurrent modification
            for (Object crit : new HashSet<>((Collection) cur.getCompletedCriteria())) {
                if (!keep.contains(crit)) {
                    pa.revoke(holder, crit.toString());
                }
            }
        }
    }
}