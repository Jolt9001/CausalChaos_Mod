package jolt9001.causalchaos.library.definitions;

import com.google.common.base.Preconditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.Objects;

public class BlockDefinition<T extends Block> extends ItemDefinition<BlockItem> {
    private final T block;

    public BlockDefinition(String name, ResourceLocation id, T block, BlockItem i) {
        super(name, id, i);
        this.block = Objects.requireNonNull(block, "block");
    }

    public final T block() {
        return this.block;
    }

    @Override
    public final ItemStack stack(int size) {
        Preconditions.checkArgument(size > 0);

        return new ItemStack(block, size);
    }
}
