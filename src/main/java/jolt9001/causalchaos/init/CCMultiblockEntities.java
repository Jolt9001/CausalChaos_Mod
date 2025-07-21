package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.block.entity.starforgealone.T1StarforgeBlockEntity;
import jolt9001.causalchaos.library.block.entity.starforgealone.T2StarforgeBlockEntity;
import jolt9001.causalchaos.library.block.entity.starforgealone.T3StarforgeBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CCMultiblockEntities {
    public static final DeferredRegister<BlockEntityType<?>> MULTIBLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CausalChaos.MODID);

    public static final RegistryObject<BlockEntityType<T1StarforgeBlockEntity>> T1_STARFORGE_MBE = MULTIBLOCK_ENTITY_TYPES.register("t1_starforge", () -> BlockEntityType.Builder.of(T1StarforgeBlockEntity::new, CCBlocks.T1_STARFORGE.get()).build(null));
    public static final RegistryObject<BlockEntityType<T2StarforgeBlockEntity>> T2_STARFORGE_MBE = MULTIBLOCK_ENTITY_TYPES.register("t2_starforge", () -> BlockEntityType.Builder.of(T2StarforgeBlockEntity::new, CCBlocks.T2_STARFORGE.get()).build(null));
    public static final RegistryObject<BlockEntityType<T3StarforgeBlockEntity>> T3_STARFORGE_MBE = MULTIBLOCK_ENTITY_TYPES.register("t3_starforge", () -> BlockEntityType.Builder.of(T3StarforgeBlockEntity::new, CCBlocks.T3_STARFORGE.get()).build(null));

    public static void register(IEventBus eventBus) {
        MULTIBLOCK_ENTITY_TYPES.register(eventBus);
    }
}
