package jolt9001.causalchaos.library.entities.boss;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class DemonLord extends Monster {
    public DemonLord(EntityType<? extends DemonLord> type, Level world) {
        super(type, world);
    }
}
