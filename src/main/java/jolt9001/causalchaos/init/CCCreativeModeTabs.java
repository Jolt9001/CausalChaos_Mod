package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CCCreativeModeTabs {
    public static final DeferredRegister CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CausalChaos.MODID);

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }

    /*
    static DeferredRegister<CreativeModeTab> TABS;

    public static final RegistryObject<CreativeModeTab> ITEMS = TABS.register("core", () -> CreativeModeTab.builder()
            // Set name of tab to display
            .title(Component.translatable("item_group." + CausalChaos.MODID + ".core"))
            // Set icon of creative tab
            .icon(() -> new ItemStack(CCItems.CAUSALITY_CRYSTAL))
            // Add default items to tab
            .displayItems((params, output) -> {
                CCItems.getItems();
            })
            .build()
    );



    @SubscribeEvent
    public void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

        }
    }

 */
}
