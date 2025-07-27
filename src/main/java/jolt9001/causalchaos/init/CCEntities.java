package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.entities.CCEntityNames;
import jolt9001.causalchaos.library.entities.boss.DemonLord;
import jolt9001.causalchaos.library.entities.boss.LeviathanSkywyrm;
import jolt9001.causalchaos.library.entities.monsters.*;
import jolt9001.causalchaos.library.entities.superboss.npc.TsunaNpc;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CCEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CausalChaos.MODID);
    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, CausalChaos.MODID);

    // NPCs
    // Monsters
    public static final RegistryObject<EntityType<RiftwalkerScout>> RIFTWALKER_SCOUT = make(CCEntityNames.RIFTWALKER_SCOUT, RiftwalkerScout::new, MobCategory.MONSTER, 0F, 0F, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<RiftwalkerSoldier>> RIFTWALKER_SOLDIER = make(CCEntityNames.RIFTWALKER_SOLDIER, RiftwalkerSoldier::new, MobCategory.MONSTER, 0F, 0F, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<RiftwalkerElite>> RIFTWALKER_ELITE = make(CCEntityNames.RIFTWALKER_ELITE, RiftwalkerElite::new, MobCategory.MONSTER, 0F, 0F, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<RiftwalkerCorruptor>> RIFTWALKER_CORRUPTOR = make(CCEntityNames.RIFTWALKER_CORRUPTOR, RiftwalkerCorruptor::new, MobCategory.MONSTER, 0F, 0F, 0x0a0000, 0x00008b);

    // Bosses
    public static final RegistryObject<EntityType<DemonLord>> DEMON_LORD = make(CCEntityNames.DEMON_LORD, DemonLord::new, MobCategory.MONSTER, 0f, 0f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<LeviathanSkywyrm>> LEVIATHAN_SKYWYRM = make(CCEntityNames.LEVIATHAN_SKYWYRM, LeviathanSkywyrm::new, MobCategory.MONSTER, 0f, 0f, 0x0a0000, 0x00008b);
    // Superbosses
        // Battle
    public static final RegistryObject<EntityType<TsunaNpc>> TSUNA_BOSS = make(CCEntityNames.TSUNA_BOSS, TsunaNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);

        // NPC
    public static final RegistryObject<EntityType<TsunaNpc>> TSUNA_NPC = make(CCEntityNames.TSUNA_NPC, TsunaNpc::new, MobCategory.MISC, 0.5f, 1.75f, 0x0a0000, 0x00008b);

    private static <E extends Entity> RegistryObject<EntityType<E>> make(ResourceLocation id, EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, int primary, int secondary) {
        return make(id, factory, classification, width, height, false, primary, secondary);
    }
    private static <E extends Entity> RegistryObject<EntityType<E>> make(ResourceLocation id, EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, boolean fireproof, int primary, int secondary) {
        return build(id, makeBuilder(factory, classification, width, height, 80, 3), fireproof, primary, secondary);
    }

    private static <E extends Entity> RegistryObject<EntityType<E>> buildNoEgg(ResourceLocation id, EntityType.Builder<E> builder, boolean fireproof) {
        if (fireproof) builder.fireImmune();
        return ENTITIES.register(id.getPath(), () -> builder.build(id.toString()));
    }
    @SuppressWarnings("unchecked")
    private static <E extends Entity> RegistryObject<EntityType<E>> build(ResourceLocation id, EntityType.Builder<E> builder, boolean fireproof, int primary, int secondary) {
        if (fireproof) builder.fireImmune();
        RegistryObject<EntityType<E>> ret = ENTITIES.register(id.getPath(), () -> builder.build(id.toString()));
        if (primary != 0 && secondary != 0) {
            SPAWN_EGGS.register(id.getPath() + "_spawn_egg", () -> new ForgeSpawnEggItem(() -> (EntityType<? extends Mob>) ret.get(), primary, secondary, new Item.Properties()));
        }
        return ret;
    }

    private static <E extends Entity> EntityType.Builder<E> makeCastedBuilder(@SuppressWarnings("unused") Class<E> cast, EntityType.EntityFactory<E> factory, float width, float height, int range, int interval) {
        return makeBuilder(factory, MobCategory.MISC, width, height, range, interval);
    }
    private static <E extends Entity> EntityType.Builder<E> makeBuilder(EntityType.EntityFactory<E> factory, MobCategory classification, float width, float height, int range, int interval) {
        return EntityType.Builder.of(factory, classification).
                sized(width, height).
                setTrackingRange(range).
                setUpdateInterval(interval).
                setShouldReceiveVelocityUpdates(true);
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {

    }
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {

    }
}
