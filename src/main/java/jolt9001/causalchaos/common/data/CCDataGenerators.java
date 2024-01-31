package jolt9001.causalchaos.common.data;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.common.data.providers.advancements.CCAdvancementProvider;
import jolt9001.causalchaos.common.data.providers.recipes.CraftingRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = CausalChaos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CCDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput out = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> prov = event.getLookupProvider();
        ExistingFileHelper help = event.getExistingFileHelper();

        // Server Side
        // Worldgen

        // Loot

        // Tags

        // Recipes
        gen.addProvider(event.includeServer(), new CraftingRecipes(out));
        // Misc
        gen.addProvider(event.includeServer(), new CCAdvancementProvider(out, prov, help));

        // Client side: Sounds, Block/Item Models, Particles, Language

        // Models

        // Particles

        // Language

        // Sound

    }
}
