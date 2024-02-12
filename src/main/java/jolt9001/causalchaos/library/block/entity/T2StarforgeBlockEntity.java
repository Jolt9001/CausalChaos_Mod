package jolt9001.causalchaos.library.block.entity;

import jolt9001.causalchaos.library.block.CCBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class T2StarforgeBlockEntity extends BlockEntity implements MenuProvider {
    public T2StarforgeBlockEntity(BlockPos pos, BlockState state){
        super(CCBlockEntities.T0_STARFORGE_BE.get(), pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.causalchaos.tier_2_starforge");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int p_39954_, Inventory inv, Player p_39956_) {
        return null;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, T2StarforgeBlockEntity blockEntity) {

    }
}
