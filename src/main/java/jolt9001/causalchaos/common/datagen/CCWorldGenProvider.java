package jolt9001.causalchaos.common.datagen;

import com.google.gson.JsonElement;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.JsonOps;
import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class CCWorldGenProvider implements DataProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(CCWorldGenProvider.class);

    private final PackOutput out;
    private final CompletableFuture<HolderLookup.Provider> reg;

    public CCWorldGenProvider(PackOutput o, CompletableFuture<HolderLookup.Provider> reg) {
        this.out = o;
        this.reg = reg;
    }

    public CompletableFuture<?> run(CachedOutput writer) {
        return reg.thenComposeAsync(provider -> {
            var dynamicOps = RegistryOps.create(JsonOps.INSTANCE, provider);
            var futures = RegistryDataLoader.WORLDGEN_REGISTRIES
                    .stream()
                    .map((info) -> this.writeRegistryEntries(writer, provider, dynamicOps, info))
                    .toArray(CompletableFuture[]::new);
            return CompletableFuture.allOf(futures);
        });
    }

    private <T> CompletableFuture<Void> writeRegistryEntries(CachedOutput w, HolderLookup.Provider p, DynamicOps<JsonElement> ops, RegistryDataLoader.RegistryData<T> data) {
        var regKey = data.key();
        var registry = p.lookup(regKey).orElse(null);
        if (registry == null) {
            return CompletableFuture.completedFuture(null);
        }
        var pathResolver = this.out.createPathProvider(PackOutput.Target.DATA_PACK,
                regKey.location().getPath());

        var futures = registry.listElements().flatMap(regEntry -> {
            var key = regEntry.key();

            if (!key.location().getNamespace().equals(CausalChaos.MODID)) {
                return Stream.empty();
            }

            var path = pathResolver.json(key.location());
            return writeToPath(path, w, ops, data.elementCodec(), regEntry.value())
                    .stream();
        }).toArray(CompletableFuture[]::new);
        return CompletableFuture.allOf(futures);
    }

    private static <E> Optional<CompletableFuture<?>> writeToPath(Path path, CachedOutput cache,
                                                                  DynamicOps<JsonElement> json, Encoder<E> encoder,
                                                                  E value) {
        var optional = encoder.encodeStart(json, value).resultOrPartial((error) -> {
            LOGGER.error("Couldn't serialize element {}: {}", path, error);
        });

        return optional.map(data -> DataProvider.saveStable(cache, data, path));
    }

    public String getName() {
        return "Causal Chaos Worldgen";
    }
}
