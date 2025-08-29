package jolt9001.causalchaos.library.input;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.glfw.GLFW;

public class CCKeybinds {
    private static final Options settings = Minecraft.getInstance().options;

    public static final KeyMapping DASH_KEY = new KeyMapping("keybind.causalchaos.dash", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, "key.categories.misc");
    public static final KeyMapping PARRY_KEY = new KeyMapping("keybind.causalchaos.parry", KeyConflictContext.IN_GAME, InputConstants.Type.MOUSE, GLFW.GLFW_MOUSE_BUTTON_RIGHT, "key.categories.misc");


    public static KeyMapping getKeyJump() {
        return settings.keyJump;
    }

    public static KeyMapping getKeySneak() {
        return settings.keyShift;
    }

    public static KeyMapping getKeyLeft() {
        return settings.keyLeft;
    }

    public static KeyMapping getKeyRight() {
        return settings.keyRight;
    }

    public static KeyMapping getKeyForward() {
        return settings.keyUp;
    }

    public static KeyMapping getKeyBack() {
        return settings.keyDown;
    }
    public static KeyMapping getKeyDash() {
        return DASH_KEY;
    }
    public static KeyMapping getKeyParry() {
        return PARRY_KEY;
    }

    @SubscribeEvent
    public static void register(RegisterKeyMappingsEvent event) {
        event.register(DASH_KEY);
        event.register(PARRY_KEY);
    }
}
