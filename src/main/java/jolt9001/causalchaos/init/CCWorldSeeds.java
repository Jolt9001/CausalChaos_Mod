package jolt9001.causalchaos.init;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class CCWorldSeeds {
    private static final Map<ResourceKey<Level>, Long> SEEDS = new ConcurrentHashMap<>();

    public static long get(ResourceKey<Level> dim) {
        return SEEDS.getOrDefault(dim, 0L);
    }

    @SubscribeEvent
    public static void onLevelLoad(LevelEvent.Load e) {
        if (e.getLevel() instanceof ServerLevel sl) {
            SEEDS.put(sl.dimension(), sl.getSeed()); // ← one authoritative place
        }
    }

    @SubscribeEvent
    public static void onLevelUnload(LevelEvent.Unload e) {
        if (e.getLevel() instanceof ServerLevel sl) {
            SEEDS.remove(sl.dimension());
        }
    }
}