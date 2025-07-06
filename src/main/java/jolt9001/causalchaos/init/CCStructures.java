package jolt9001.causalchaos.init;

import jolt9001.causalchaos.CausalChaos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class CCStructures {
    // Transcendent's Plain
    public static final ResourceKey<Structure> TRANSCENDENT_MANSION = registerKey("transcendent_mansion"); // Structure: Jolt
    public static final ResourceKey<Structure> PERPETUAL_REACTOR = registerKey("perpetual_reactor"); // Structure: Rex
    public static final ResourceKey<Structure> DOOMSDAY_CLOCK = registerKey("doomsday_clock"); // Structure: Andrea
    public static final ResourceKey<Structure> INFERNAL_MAW = registerKey("infernal_maw"); // Structure: Adrian
    public static final ResourceKey<Structure> PROVIDENCE_TOWER = registerKey("providence_tower"); // Structure: Emily
    public static final ResourceKey<Structure> PERFECT_SANCTUARY = registerKey("perfect_sanctuary"); // Structure: Madeline
    public static final ResourceKey<Structure> HOSPITAL = registerKey("hospital"); // Structure: Alline
    public static final ResourceKey<Structure> ASYLUM = registerKey("asylum"); // Structure: Matthue
    public static final ResourceKey<Structure> BLACK_HOLE_ARENA = registerKey("black_hole_arena"); // Structure: Will
    public static final ResourceKey<Structure> SHADOW_CASTLE = registerKey("shadow_castle"); // Structure: Xanthea
    public static final ResourceKey<Structure> FROZEN_MOUNTAIN = registerKey("frozen_mountain"); // Structure: Jack
    public static final ResourceKey<Structure> DRAGON_CAVE = registerKey("dragon_cave"); // Structure: Aella
    public static final ResourceKey<Structure> GIANT_MONSTER = registerKey("giant_monster"); // Structure: Lyadova
    public static final ResourceKey<Structure> OLD_WEST_TAVERN = registerKey("old_west_tavern"); // Structure: Terry
    public static final ResourceKey<Structure> BIG_BROTHER_SERVER = registerKey("big_brother_server"); // Structure: Kai
    public static final ResourceKey<Structure> PORTAL_CAGE = registerKey("portal_cage"); // Structure: Tsuna

    // Limbo

    // Sky


    public static ResourceKey<Structure> registerKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, CausalChaos.prefix(name));
    }
    public static void bootstrap(BootstapContext<Structure> context) {

    }
}
