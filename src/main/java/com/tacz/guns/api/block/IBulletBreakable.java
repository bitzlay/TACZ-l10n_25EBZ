package com.tacz.guns.api.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface IBulletBreakable {

    default int onDamaged(Level level, BlockPos pos, int damage){
        return damage;
    }
    default int getDefaultHP(BlockState state){
        return (int) (state.getBlock().getExplosionResistance()*100);
    }
}
