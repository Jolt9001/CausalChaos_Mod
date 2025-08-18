package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import jolt9001.causalchaos.library.entities.CCEntityNames;
import jolt9001.causalchaos.library.entities.custom.boss.*;
import jolt9001.causalchaos.library.entities.custom.superboss.hostile.chaos.*;
import jolt9001.causalchaos.library.entities.custom.superboss.hostile.normal.*;
import jolt9001.causalchaos.library.entities.custom.superboss.npc.*;
import jolt9001.causalchaos.library.entities.custom.monsters.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
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
    public static final RegistryObject<EntityType<Worldeater>> WORLDEATER = make(CCEntityNames.WORLDEATER, Worldeater::new, MobCategory.MONSTER, 0f, 0f, 0x0a0000, 0x00008b);

    // Superbosses
        // Battle
    public static final RegistryObject<EntityType<TsunaBoss>> TSUNA_BOSS = make(CCEntityNames.TSUNA_BOSS, TsunaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<KaiBoss>> KAI_BOSS = make(CCEntityNames.KAI_BOSS, KaiBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<TerryBoss>> TERRY_BOSS = make(CCEntityNames.TERRY_BOSS, TerryBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<LyadovaBoss>> LYADOVA_BOSS = make(CCEntityNames.LYADOVA_BOSS, LyadovaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<AellaBoss>> AELLA_BOSS = make(CCEntityNames.AELLA_BOSS, AellaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<JackBoss>> JACK_BOSS = make(CCEntityNames.JACK_BOSS, JackBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<XantheaBoss>> XANTHEA_BOSS = make(CCEntityNames.XANTHEA_BOSS, XantheaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<WillBoss>> WILL_BOSS = make(CCEntityNames.WILL_BOSS, WillBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<MatthueBoss>> MATTHUE_BOSS = make(CCEntityNames.MATTHUE_BOSS, MatthueBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<AllineBoss>> ALLINE_BOSS = make(CCEntityNames.ALLINE_BOSS, AllineBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<MadelineBoss>> MADELINE_BOSS = make(CCEntityNames.MADELINE_BOSS, MadelineBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<EmilyBoss>> EMILY_BOSS = make(CCEntityNames.EMILY_BOSS, EmilyBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<AdrianBoss>> ADRIAN_BOSS = make(CCEntityNames.ADRIAN_BOSS, AdrianBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<AndreaBoss>> ANDREA_BOSS = make(CCEntityNames.ANDREA_BOSS, AndreaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<RexBoss>> REX_BOSS = make(CCEntityNames.REX_BOSS, RexBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<JoltBoss>> JOLT_BOSS = make(CCEntityNames.JOLT_BOSS, JoltBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<FPJoltBoss>> FPJOLT_BOSS = make(CCEntityNames.FPJOLT_BOSS, FPJoltBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
        // Chaos Mode
    public static final RegistryObject<EntityType<ChaosTsunaBoss>> C_TSUNA_BOSS = make(CCEntityNames.C_TSUNA_BOSS, ChaosTsunaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosKaiBoss>> C_KAI_BOSS = make(CCEntityNames.C_KAI_BOSS, ChaosKaiBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosTerryBoss>> C_TERRY_BOSS = make(CCEntityNames.C_TERRY_BOSS, ChaosTerryBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosLyadovaBoss>> C_LYADOVA_BOSS = make(CCEntityNames.C_LYADOVA_BOSS, ChaosLyadovaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosAellaBoss>> C_AELLA_BOSS = make(CCEntityNames.C_AELLA_BOSS, ChaosAellaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosJackBoss>> C_JACK_BOSS = make(CCEntityNames.C_JACK_BOSS, ChaosJackBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosXantheaBoss>> C_XANTHEA_BOSS = make(CCEntityNames.C_XANTHEA_BOSS, ChaosXantheaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosWillBoss>> C_WILL_BOSS = make(CCEntityNames.C_WILL_BOSS, ChaosWillBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosMatthueBoss>> C_MATTHUE_BOSS = make(CCEntityNames.C_MATTHUE_BOSS, ChaosMatthueBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosAllineBoss>> C_ALLINE_BOSS = make(CCEntityNames.C_ALLINE_BOSS, ChaosAllineBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosMadelineBoss>> C_MADELINE_BOSS = make(CCEntityNames.C_MADELINE_BOSS, ChaosMadelineBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosEmilyBoss>> C_EMILY_BOSS = make(CCEntityNames.C_EMILY_BOSS, ChaosEmilyBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosAdrianBoss>> C_ADRIAN_BOSS = make(CCEntityNames.C_ADRIAN_BOSS, ChaosAdrianBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosAndreaBoss>> C_ANDREA_BOSS = make(CCEntityNames.C_ANDREA_BOSS, ChaosAndreaBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosRexBoss>> C_REX_BOSS = make(CCEntityNames.C_REX_BOSS, ChaosRexBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosJoltBoss>> C_JOLT_BOSS = make(CCEntityNames.C_JOLT_BOSS, ChaosJoltBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<ChaosFPJoltBoss>> C_FPJOLT_BOSS = make(CCEntityNames.C_FPJOLT_BOSS, ChaosFPJoltBoss::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    // NPC
    public static final RegistryObject<EntityType<TsunaNpc>> TSUNA_NPC = make(CCEntityNames.TSUNA_NPC, TsunaNpc::new, MobCategory.MISC, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<KaiNpc>> KAI_NPC = make(CCEntityNames.KAI_NPC, KaiNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<TerryNpc>> TERRY_NPC = make(CCEntityNames.TERRY_NPC, TerryNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<LyadovaNpc>> LYADOVA_NPC = make(CCEntityNames.LYADOVA_NPC, LyadovaNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<AellaNpc>> AELLA_NPC = make(CCEntityNames.AELLA_NPC, AellaNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<JackNpc>> JACK_NPC = make(CCEntityNames.JACK_NPC, JackNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<XantheaNpc>> XANTHEA_NPC = make(CCEntityNames.XANTHEA_NPC, XantheaNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<WillNpc>> WILL_NPC = make(CCEntityNames.WILL_NPC, WillNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<MatthueNpc>> MATTHUE_NPC = make(CCEntityNames.MATTHUE_NPC, MatthueNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<AllineNpc>> ALLINE_NPC = make(CCEntityNames.ALLINE_NPC, AllineNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<MadelineNpc>> MADELINE_NPC = make(CCEntityNames.MADELINE_NPC, MadelineNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<EmilyNpc>> EMILY_NPC = make(CCEntityNames.EMILY_NPC, EmilyNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<AdrianNpc>> ADRIAN_NPC = make(CCEntityNames.ADRIAN_NPC, AdrianNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<AndreaNpc>> ANDREA_NPC = make(CCEntityNames.ANDREA_NPC, AndreaNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<RexNpc>> REX_NPC = make(CCEntityNames.REX_NPC, RexNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);
    public static final RegistryObject<EntityType<JoltNpc>> JOLT_NPC = make(CCEntityNames.JOLT_NPC, JoltNpc::new, MobCategory.MONSTER, 0.5f, 1.75f, 0x0a0000, 0x00008b);

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
