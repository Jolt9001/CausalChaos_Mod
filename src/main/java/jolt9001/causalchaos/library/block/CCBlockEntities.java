package jolt9001.causalchaos.library.block;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.block.entity.T0StarforgeBlockEntity;
import jolt9001.causalchaos.library.definitions.CCBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CCBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CausalChaos.MODID);

    public static final RegistryObject<BlockEntityType<T0StarforgeBlockEntity>> T0_STARFORGE_BE = BLOCK_ENTITY_TYPES.register("t0_starforge", () -> BlockEntityType.Builder.of(T0StarforgeBlockEntity::new, CCBlocks.T0_STARFORGE.get()).build(null));
}
