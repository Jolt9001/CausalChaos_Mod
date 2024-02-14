package jolt9001.causalchaos.library.screen;

import jolt9001.causalchaos.CausalChaos;
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
    public static final RegistryObject<MenuType<StarforgeAloneMenu>> STARFORGE_ALONE_MENU = registerMenuTypes("starforge_alone_menu", StarforgeAloneMenu::new);
    public static final RegistryObject<MenuType<StarforgeMultiblockMenu>> STARFORGE_MULTIBLOCK_MENU = registerMenuTypes("starforge_multiblock_menu", StarforgeMultiblockMenu::new);
    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuTypes(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
