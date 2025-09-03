package jolt9001.causalchaos.actions.base_impl.timeloop.adv_persist;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jolt9001.causalchaos.CausalChaos;
import net.minecraft.ResourceLocationException;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public final class AdvSnapshotStorage {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private AdvSnapshotStorage() {}

    private static Path baseDir(MinecraftServer srv) {
        // Use a stable world id; level name is simple, but you can store a GUID once in SavedData if you prefer.
        String worldId = srv.getWorldData().getLevelName();
        Path dir = FMLPaths.CONFIGDIR.get().resolve("causalchaos/loops").resolve(worldId);
        try { Files.createDirectories(dir); } catch (IOException ignored) {}
        return dir;
    }

    private static Path file(MinecraftServer srv, UUID uuid) {
        return baseDir(srv).resolve(uuid + ".adv.json");
    }

    public static void write(MinecraftServer srv, ServerPlayer sp, Map<ResourceLocation, Set<String>> snap) {
        // Flatten keys to strings for json
        Map<String, Set<String>> payload = new HashMap<>();
        for (var e : snap.entrySet()) payload.put(e.getKey().toString(), e.getValue());

        try (Writer w = Files.newBufferedWriter(file(srv, sp.getUUID()), StandardCharsets.UTF_8)) {
            GSON.toJson(payload, w);
        } catch (IOException e) {
            CausalChaos.LOGGER.error("Failed writing advancement snapshot", e);
        }
    }

    public static Map<ResourceLocation, Set<String>> read(MinecraftServer srv, UUID uuid) {
        Path p = file(srv, uuid);
        if (!Files.exists(p)) return Collections.emptyMap();

        try (Reader r = Files.newBufferedReader(p, StandardCharsets.UTF_8)) {
            Type t = new TypeToken<Map<String, Set<String>>>(){}.getType();
            Map<String, Set<String>> raw = GSON.fromJson(r, t);
            if (raw == null) return Collections.emptyMap();

            Map<ResourceLocation, Set<String>> out = new HashMap<>();
            for (var e : raw.entrySet()) {
                try {
                    out.put(new ResourceLocation(e.getKey()), e.getValue());
                } catch (ResourceLocationException ex) {
                    // Skip stale/bad id
                }
            }
            return out;
        } catch (IOException e) {
            CausalChaos.LOGGER.error("Failed reading advancement snapshot", e);
            return Collections.emptyMap();
        }
    }
}