package jolt9001.causalchaos.library.block.entity;

import jolt9001.causalchaos.init.CCBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class SFMultiblock {
    static boolean check(Level level, BlockPos forgePos, StarforgeTier tier, Direction facing){
        // find a Fusion Core 1 block away in any horizontal dir
        for(Direction d : Direction.Plane.HORIZONTAL){
            BlockPos center = forgePos.relative(d);
            if(level.getBlockState(center).is(CCBlocks.FUSION_CORE.get())){
                if(isValidCube(level, center, tier)) return true;
            }
        }
        return false;
    }
    private static boolean isValidCube(Level level, BlockPos c, StarforgeTier tier){
        // layers y = -1..+1, x/z = -1..+1 around center
        for(int y=-1;y<=1;y++){
            for(int x=-1;x<=1;x++){
                for(int z=-1;z<=1;z++){
                    BlockPos p = c.offset(x,y,z);
                    Block b = level.getBlockState(p).getBlock();

                    int i = y+1, j = x+1, k = z+1; // your old indices if you want to mirror comments

                    if(i==0){ // middle layer
                        if((j==1 && k==1)){
                            // center is Fusion Core already checked
                            continue;
                        }
                        // positions marked EM or SF are valid if EITHER matches:
                        if(!(emagnet(b, tier) || findSF(b, tier))) return false;
                    } else { // top/bottom layers
                        boolean corner = (j!=1 && k!=1);
                        if(corner){
                            if(!coreShield(b, tier)) return false;
                        } else { // edges and cross
                            if(!heatSink(b, tier)) return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean coreShield(Block block, StarforgeTier tier) {
        switch (tier) {
            case T1 -> {
                return block == CCBlocks.T1_CORE_SHIELDING.get();
            } case T2 -> {
                return block == CCBlocks.T2_CORE_SHIELDING.get();
            } case T3 -> {
                return block == CCBlocks.T3_CORE_SHIELDING.get();
            } default -> {
                return true;
            }
        }
    }
    public static boolean emagnet(Block block, StarforgeTier tier) {
        switch (tier) {
            case T1 -> {
                return block == CCBlocks.T1_ELECTROMAGNET.get()
                        || block == CCBlocks.T1_HOPPER.get()
                        || block == CCBlocks.T1_S_HOPPER.get();
            } case T2 -> {
                return block == CCBlocks.T2_ELECTROMAGNET.get()
                        || block == CCBlocks.T2_HOPPER.get()
                        || block == CCBlocks.T2_S_HOPPER.get();
            } case T3 -> {
                return block == CCBlocks.T3_ELECTROMAGNET.get()
                        || block == CCBlocks.T3_HOPPER.get()
                        || block == CCBlocks.T3_S_HOPPER.get();
            } default -> {
                return true;
            }
        }
    }
    public static boolean findSF(Block block, StarforgeTier tier) {
        switch (tier) {
            case T1 -> {
                return block == CCBlocks.T1_STARFORGE.get();
            } case T2 -> {
                return block == CCBlocks.T2_STARFORGE.get();
            } case T3 -> {
                return block == CCBlocks.T3_STARFORGE.get();
            } default -> {
                return true;
            }
        }
    }
    public static boolean heatSink(Block block, StarforgeTier tier) {
        switch (tier) {
            case T1 -> {
                return block == CCBlocks.T1_HEAT_SINK.get();
            } case T2 -> {
                return block == CCBlocks.T2_HEAT_SINK.get();
            } case T3 -> {
                return block == CCBlocks.T3_HEAT_SINK.get();
            } default -> {
                return true;
            }
        }
    }
}
