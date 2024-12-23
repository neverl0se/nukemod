package com.nl.nukemod.radiation;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class RadiationContamination {
    public static void contaminateArea(Level level, BlockPos pos) {
        int radius = 32;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                for (int y = -radius; y <= radius; y++) {
                    BlockPos currentPos = pos.offset(x, y, z);
                    BlockState state = level.getBlockState(currentPos);

                    if (state.getMaterial() == Material.PLANT || state.getMaterial() == Material.LEAVES) {
                        level.setBlock(currentPos, Blocks.DIRT.defaultBlockState(), 3);
                    }
                }
            }
        }
    }
}