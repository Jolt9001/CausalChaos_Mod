package jolt9001.causalchaos;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.EnumValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs

@Mod.EventBusSubscriber(modid = CausalChaos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CCConfig {

    public static Common COMMON_CONFIG;
    public static Client CLIENT_CONFIG;

    /**
     * Common specific config
     */
    public static class Common {

        //gameplay
        public final BooleanValue spawnWithBook;
        public final BooleanValue immediateMeteor;

        // Dimensions
        public final ForgeConfigSpec.ConfigValue<String> originDimension;

        // recipes

        // loot

        // worldgen
        public final BooleanValue generateCobalt;
        public final ConfigValue<Integer> veinCountCobalt;

        // combat

        // debug
        public final EnumValue<LogInvalidToolStack> logInvalidToolStack;
        public enum LogInvalidToolStack { STACKTRACE, WARNING, IGNORED }

        public Common(ForgeConfigSpec.Builder builder) {
            builder
                    .comment("Settings that affect gameplay.")
                    .push("Gameplay Settings");
            {
                this.spawnWithBook = builder
                        .comment("Set this to false to disable spawning with Causal Journal. Default: true")
                        .translation("jolt9001.causalchaos.configgui.spawnWithBook")
                        .worldRestart()
                        .define("spawnWithBook", true);
                this.immediateMeteor = builder
                        .comment("Set this to true to make the Causality Crystal spawn immediately. Default: false")
                        .translation("jolt9001.causalchaos.configgui.immediateMeteor")
                        .worldRestart()
                        .define("immediateMeteor", false);
            }
            builder.pop();
            originDimension = builder.
                    translation("jolt9001.causalchaos.configgui.originDimension").
                    comment("The dimension you can always travel to the mod's dimensions from, as well as the dimension you will return to. Default: overworld. (domain:regname)").
                    define("originDimension", "minecraft:overworld");

            builder.comment("Recipe config").push("recipes");

            builder.pop();

            builder.comment("Loot Table config").push("loot");

            builder.pop();

            builder.comment("World generation config").push("worldgen");
            {
                this.generateCobalt = builder
                        .comment("Allow Cobalt Ore Generation")
                        .translation("jolt9001.causalchaos.configgui.generateCobalt")
                        .worldRestart()
                        .define("generateCobalt", true);
                this.veinCountCobalt = builder
                        .comment("approximate ores per chunk")
                        .translation("jolt9001.causalchaos.configgui.veinCountCobalt")
                        .worldRestart()
                        .define("veinCountCobalt", 8);

                builder.pop();
            }
            builder.pop();

            builder.comment("Combat config").push("combat");

            builder.pop();

            builder.comment("Features for use in debugging gameplay and mechanics.").push("debug");

            this.logInvalidToolStack = builder
                    .comment("If STACKTRACE, logs the stacktrace whenever a tool stack is created from a non-modifiable item. If WARNING (default), logs a shorter but more efficient error. If IGNORE, disables logging (useful for modpacks/players *after* they reported the issue). The stacktrace helps debug which mod is causing it, but is rather expensive on the chance they are doing it a lot.")
                    .defineEnum("logInvalidToolStack", LogInvalidToolStack.WARNING);
            builder.pop();
        }
    }

    /**
     * Client-specific configuration - only loaded clientside
     */
    public static class Client {

        public Client(ForgeConfigSpec.Builder builder) {

        }
    }

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
            .comment("Whether to log the dirt block on common setup")
            .define("logDirtBlock", true);

    public static final ForgeConfigSpec.IntValue MAGIC_NUMBER = BUILDER
            .comment("A magic number")
            .defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
            .comment("What you want the introduction message to be for the magic number")
            .define("magicNumberIntroduction", "The magic number is... ");

    // a list of strings that are treated as resource locations for items
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
            .comment("A list of items to log on common setup.")
            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), CCConfig::validateItemName);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean logDirtBlock;
    public static int magicNumber;
    public static String magicNumberIntroduction;
    public static Set<Item> items;

    private static boolean validateItemName(final Object obj) {
        if (obj instanceof String) {
            String itemName = (String) obj;
            return ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
        }
        return false;
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        logDirtBlock = LOG_DIRT_BLOCK.get();
        magicNumber = MAGIC_NUMBER.get();
        magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // convert the list of strings into a set of items
        items = ITEM_STRINGS.get().stream()
                .map(itemName -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName)))
                .collect(Collectors.toSet());
    }
}
