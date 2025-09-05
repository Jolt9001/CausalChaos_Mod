package jolt9001.causalchaos.actions.base_impl.dash.dashstrike;

import jolt9001.causalchaos.common.CCCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

public class DashDataProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    private final DashData dashData = new DashData();
    private final LazyOptional<IDashData> optional = LazyOptional.of(() -> dashData);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return cap == CCCapabilities.DASH_DATA ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putBoolean("dashing", dashData.isDashing());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        dashData.setDashing(nbt.getBoolean("dashing"));
    }
}
