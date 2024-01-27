package jolt9001.causalchaos.library.definitions;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.Objects;

public class ItemDefinition<T extends Item> implements ItemLike {
    private final ResourceLocation id;
    private final String name;
    private final T item;

    public ItemDefinition(String name, ResourceLocation id, T item) {
        Objects.requireNonNull(id, "id");
        this.id = id;
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public ResourceLocation id() {
        return this.id;
    }

    public ItemStack stack() {
        return stack(1);
    }

    public ItemStack stack(int stackSize) {
        return new ItemStack(item, stackSize);
    }

    @Override
    public T asItem() {
        return item;
    }
}
