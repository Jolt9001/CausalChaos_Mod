package jolt9001.causalchaos.library.input;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CCKeyRecorder {
    public static final KeyState keyForward = new KeyState();
    public static final KeyState keyBackward = new KeyState();
    public static final KeyState keyLeft = new KeyState();
    public static final KeyState keyRight = new KeyState();
    public static final KeyState keySneak = new KeyState();
    public static final KeyState keyJump = new KeyState();

    public static final KeyState keyDash = new KeyState();
    public static final KeyState keyParry = new KeyState();

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START) return;

        record(CCKeybinds.getKeyForward(), keyForward);
        record(CCKeybinds.getKeyBack(), keyBackward);
        record(CCKeybinds.getKeyRight(), keyRight);
        record(CCKeybinds.getKeyLeft(), keyLeft);
        record(CCKeybinds.getKeySneak(), keySneak);
        record(CCKeybinds.getKeyJump(), keyJump);

        record(CCKeybinds.getKeyDash(), keyDash);
        record(CCKeybinds.getKeyParry(), keyParry);
    }

    private static void record(KeyMapping keyBinding, KeyState state) {
        state.pressed = (keyBinding.isDown() && state.tickKeyDown == 0);
        state.released = (!keyBinding.isDown() && state.tickNotKeyDown == 0);
        state.doubleTapped = (keyBinding.isDown() && 0 < state.tickNotKeyDown && state.tickNotKeyDown <= 2);
        if (keyBinding.isDown()) {
            state.tickKeyDown++;
            state.tickNotKeyDown = 0;
        } else {
            state.tickKeyDown = 0;
            state.tickNotKeyDown++;
        }
    }

    public static class KeyState {
        private boolean pressed = false;
        private boolean released = false;
        private boolean doubleTapped = false;
        private int tickKeyDown = 0;
        private int tickNotKeyDown = 0;

        public boolean isPressed() {
            return pressed;
        }

        public boolean isReleased() {
            return released;
        }

        public boolean isDoubleTapped() {
            return doubleTapped;
        }

        public int getTickKeyDown() {
            return tickKeyDown;
        }

        public int getTickNotKeyDown() {
            return tickNotKeyDown;
        }
    }
}
