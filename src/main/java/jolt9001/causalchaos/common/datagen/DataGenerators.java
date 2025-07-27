package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.datagen.tags.BlockTagGenerator;
import jolt9001.causalchaos.common.datagen.tags.ItemTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = CausalChaos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void generate(GatherDataEvent event) {
        net.minecraft.data.DataGenerator gen = event.getGenerator();
        PackOutput out = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> prov = event.getLookupProvider();
        ExistingFileHelper help = event.getExistingFileHelper();

        // Server Side: Worldgen. Recipes, Advancements, Loot Tables, Tags
            // Worldgen
        // gen.addProvider(event.includeServer(), new WorldGenProvider(out, prov));
            // Recipes
        gen.addProvider(event.includeServer(), new CCCraftingProvider(out));
            // Advancements
        gen.addProvider(event.includeServer(), new CCAdvancementProvider(out, prov, help));
            // Loot Tables
        // gen.addProvider(event.includeServer(), new CCLootTableProvider(out));
            // Tags
        BlockTagGenerator blocktags = new BlockTagGenerator(out, prov, help);
        gen.addProvider(event.includeServer(), blocktags);
        gen.addProvider(event.includeServer(), new ItemTagGenerator(out, prov, blocktags.contentsGetter(), help));
        // Client side: Sounds, Block/Item Models, Particles
            // Sounds
        gen.addProvider(event.includeClient(), new BlockstateGenerator(out, help));
            // Models
        gen.addProvider(event.includeClient(), new CCItemModelProvider(out, help));
            // Particles
    }
}
