package jolt9001.causalchaos.library.worldgen.chunkgenerators.tplain.biomesource;

import com.mojang.serialization.*;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public final class VariantMaskCodecs {
    private static final Map<String, MapCodec<? extends VariantMask>> BY_NAME = new LinkedHashMap<>();

    /** Call this once for every mask type (e.g. in your mod init) */
    public static <M extends VariantMask> void register(String name, MapCodec<M> codec) {
        if (BY_NAME.putIfAbsent(name, codec) != null) {
            throw new IllegalStateException("Duplicate mask type: " + name);
        }
    }

    /** A MapCodec that writes { "type": "...", ...maskFields } and reads it back. */
    public static final MapCodec<VariantMask> DISPATCH = new MapCodec<>() {
        @Override
        public <T> RecordBuilder<T> encode(VariantMask value, DynamicOps<T> ops, RecordBuilder<T> builder) {
            final String name = value.type();
            @SuppressWarnings("unchecked")
            MapCodec<VariantMask> codec = (MapCodec<VariantMask>) BY_NAME.get(name);
            if (codec == null) return builder.withErrorsFrom(DataResult.error(() -> "Unknown mask type: " + name));
            builder.add("type", name, Codec.STRING);
            return codec.encode(value, ops, builder);
        }

        @Override
        public <T> DataResult<VariantMask> decode(DynamicOps<T> ops, MapLike<T> input) {
            T tVal = input.get("type");
            if (tVal == null) return DataResult.error(() -> "Missing 'type' for VariantMask");
            return Codec.STRING.parse(ops, tVal).flatMap(name -> {
                final MapCodec<? extends VariantMask> raw = BY_NAME.get(name);
                if (raw == null) return DataResult.error(() -> "Unknown mask type: " + name);

                @SuppressWarnings("unchecked")
                MapCodec<VariantMask> cast = (MapCodec<VariantMask>) raw;
                return cast.decode(ops, input);
            });
        }

        @Override
        public <T> Stream<T> keys(DynamicOps<T> ops) {
            return Stream.of(ops.createString("type"));
        }
    };

    /** If you prefer a Codec<VariantMask>, just call .codec() */
    public static final Codec<VariantMask> CODEC = DISPATCH.codec();
}