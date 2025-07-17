package jolt9001.causalchaos.library.item;

import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CausalityCrystalItem extends Item {
    private final RandomSource random = RandomSource.create();
    public CausalityCrystalItem(Properties p){
        super(p);
    }
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack p1) {
        return false;
    }

    public boolean hasCraftingRemainingItem() {
        return true;
    }
    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        ItemStack dmg = stack.copy();
        if (dmg.hurt(1, random, null)) {
            return ItemStack.EMPTY;
        } else {
            return dmg;
        }
    }
    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
