package jolt9001.causalchaos.library.block.entity;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.block.entity.starforgealone.T0StarforgeBlockEntity;
import jolt9001.causalchaos.library.block.custom.CCBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CCBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CausalChaos.MODID);

    public static final RegistryObject<BlockEntityType<T0StarforgeBlockEntity>> T0_STARFORGE_BE = BLOCK_ENTITY_TYPES.register("t0_starforge", () -> BlockEntityType.Builder.of(T0StarforgeBlockEntity::new, CCBlocks.T0_STARFORGE.get()).build(null));
    public static final RegistryObject<BlockEntityType<T0StarforgeBlockEntity>> T1_STARFORGE_BE = BLOCK_ENTITY_TYPES.register("t1_starforge", () -> BlockEntityType.Builder.of(T0StarforgeBlockEntity::new, CCBlocks.T1_STARFORGE.get()).build(null));
    public static final RegistryObject<BlockEntityType<T0StarforgeBlockEntity>> T2_STARFORGE_BE = BLOCK_ENTITY_TYPES.register("t2_starforge", () -> BlockEntityType.Builder.of(T0StarforgeBlockEntity::new, CCBlocks.T2_STARFORGE.get()).build(null));
    public static final RegistryObject<BlockEntityType<T0StarforgeBlockEntity>> T3_STARFORGE_BE = BLOCK_ENTITY_TYPES.register("t3_starforge", () -> BlockEntityType.Builder.of(T0StarforgeBlockEntity::new, CCBlocks.T3_STARFORGE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}