package jolt9001.causalchaos.common.datagen;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = CausalChaos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {

    @SubscribeEvent
    public static void generate(GatherDataEvent event) {
        net.minecraft.data.DataGenerator gen = event.getGenerator();
        PackOutput out = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> prov = event.getLookupProvider();
        ExistingFileHelper help = event.getExistingFileHelper();

        // Server Side: Worldgen. Recipes, Advancements, Loot Tables, Tags
        gen.addProvider(event.includeServer(), new RecipeGenerator(out));
        gen.addProvider(event.includeServer(), new CCAdvancementProvider(out, prov, help));
        // Client side: Sounds, Block/Item Models, Particles, Language
    }
}
