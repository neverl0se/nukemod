package com.nl.nukemod.explosion;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class NuclearExplosion {
    public static void createExplosion(Level level, BlockPos pos) {
        int radius = 32;
        int depth = 10;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                for (int y = -depth; y <= 0; y++) {
                    BlockPos currentPos = pos.offset(x, y, z);
                    BlockState state = level.getBlockState(currentPos);

                    if (state.getMaterial() != Material.AIR && state.getDestroySpeed(level, currentPos) >= 0) {
                        level.setBlock(currentPos, Blocks.AIR.defaultBlockState(), 3);
                    }
                }
            }
        }
    }
}