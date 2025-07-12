package jolt9001.causalchaos.common.loot;

import com.google.common.collect.Sets;
import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.Set;

public class CCLootTables {
    private static final Set<ResourceLocation> CC_LOOT_TABLES = Sets.newHashSet();

    // Block Loot
    // Chest Loot
    // Entity Loot
    // Special Loot
    public static Set<ResourceLocation> allBuiltin() {
        return Collections.unmodifiableSet(CC_LOOT_TABLES);
    }
}
