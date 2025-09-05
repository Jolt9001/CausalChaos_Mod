package jolt9001.causalchaos.actions.base_impl.dash.dashstrike;

import jolt9001.causalchaos.common.CCCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public interface IDashData {
    int getDashTicks();
    void setDashTicks(int v);

    int getStrikeWindow();
    void setStrikeWindow(int v);

    boolean isDashing();
    void setDashing(boolean value);

    /** Returns true once, then closes the window. */
    default boolean consumeStrikeWindow() {
        if (getStrikeWindow() > 0) { setStrikeWindow(0); return true; }
        return false;
    }
}