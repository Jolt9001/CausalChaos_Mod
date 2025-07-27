package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.common.datagen.loot.*;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class CCLootTableProvider {
    public static LootTableProvider create(PackOutput out) {
        return new LootTableProvider(out, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)//,
                //new LootTableProvider.SubProviderEntry(ChestLootTables::new, LootContextParamSets.CHEST),
                //new LootTableProvider.SubProviderEntry(EntityLootTables::new, LootContextParamSets.ENTITY),
                //new LootTableProvider.SubProviderEntry(SpecialLootTables::new, LootContextParamSets.EMPTY)
        ));
    }
}
