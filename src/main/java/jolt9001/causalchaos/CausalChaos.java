package jolt9001.causalchaos;

import com.mojang.logging.LogUtils;

import jolt9001.causalchaos.init.*;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.Locale;

/**
* @author Jolt9001
* Minecraft 1.20.2
*/

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CausalChaos.MODID)
public class CausalChaos {
    public static final String MODID = "causalchaos";
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final String MODEL_DIR = "textures/entity/";
    private static final String GUI_DIR = "textures.gui/";
    private static final String ENVIRO_DIR = "textures/environment/";
    public static final String ARMOR_DIR = "textures/armor/";
    public static final String REGISTRY_NAMESPACE = "causalchaos";
    private static final Rarity rarity = Rarity.create("CAUSALCHAOS", ChatFormatting.AQUA);

    static CausalChaos INSTANCE;

    public CausalChaos() {
        LOGGER.info("Loading Causal Chaos...");


        if (INSTANCE != null) {
            throw new IllegalStateException();
        }
        INSTANCE = this;
        LOGGER.info("Me when the mod startup");

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CCCreativeModeTabs.register(modEventBus);

        CCBlocks.register(modEventBus);
        CCItems.register(modEventBus);


        //CCBlockEntities.BLOCK_ENTITY_TYPES.register(modEventBus);
        //CCMultiblockEntities.MULTIBLOCK_ENTITY_TYPES.register(modEventBus);

        //CCMenuTypes.register(modEventBus);

        CCRecipes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        //odEventBus.addListener(this::addCreative);

        // Config a = new Config();

        // Register the mod's ForgeConfigSpec so that Forge can create and load the config file for me
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CCConfig.SPEC);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent evt) {
        // Some common setup code
        LOGGER.info("Me when the common setup");

        if (CCConfig.logDirtBlock)
        {
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        }

        LOGGER.info(CCConfig.magicNumberIntroduction + CCConfig.magicNumber);

        CCConfig.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    /*
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == CCCreativeModeTabs.BLOCKS.get()) {
            for (RegistryObject<Block> block : CCBlocks.BLOCKS.getEntries()) {
                event.accept(block.get());
            }
        } else if (event.getTab() == CCCreativeModeTabs.EQUIPMENT.get()) {
            for (RegistryObject<Item> item : ) {

            }
        }
    }
    */


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("Starting server...");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("Me when the client setup");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            //MenuScreens.register(CCMenuTypes.STARFORGE_ALONE_MENU.get(), StarforgeAloneScreen::new);
            //MenuScreens.register(CCMenuTypes.STARFORGE_MULTIBLOCK_MENU.get(), StarforgeMultiblockScreen::new);
        }
    }
    /*
    public void registerCommands(RegisterCommandsEvent event) {
        CCCommand.register(event.getDispatcher());
    }
     */

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
    }
    public static ResourceLocation namedRegistry(String name) {
        return new ResourceLocation(REGISTRY_NAMESPACE, name.toLowerCase(Locale.ROOT));
    }

    public static ResourceLocation getModelTexture(String name) {
        return new ResourceLocation(MODID, MODEL_DIR + name);
    }

    public static ResourceLocation getGuiTexture(String name) {
        return new ResourceLocation(MODID, GUI_DIR + name);
    }

    public static ResourceLocation getEnvTexture(String name) {
        return new ResourceLocation(MODID, ENVIRO_DIR + name);
    }

    public static Rarity getRarity() {
        return rarity;
    }
}
