package jolt9001.causalchaos.common.init;

import jolt9001.causalchaos.common.triggers.AdvancementTriggers;
import net.minecraft.advancements.CriteriaTriggers;

public class InitAdvancementTriggers {
    public static void init() {
        CriteriaTriggers.register("causalchaos:hardcore_death", AdvancementTriggers.HARDCORE_DEATH);
    }
}
