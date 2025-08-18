package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.screen.StarforgeAloneMenu;
import jolt9001.causalchaos.library.screen.StarforgeMultiblockMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CCMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, CausalChaos.MODID);

    public static final RegistryObject<MenuType<StarforgeAloneMenu>> STARFORGE_ALONE_MENU = registerMenuType("starforge_alone_menu", StarforgeAloneMenu::new);
    public static final RegistryObject<MenuType<StarforgeMultiblockMenu>> STARFORGE_MULTIBLOCK_MENU = registerMenuType("starforge_multiblock_menu", StarforgeMultiblockMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) { MENUS.register(eventBus); }
}
