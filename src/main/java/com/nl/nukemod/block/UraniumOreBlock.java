package com.nl.nukemod.block;

import com.nl.nukemod.BetterNuke;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UraniumOreBlock extends Block {
    public UraniumOreBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 3.0F));
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterNuke.MOD_ID);

    public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", UraniumOreBlock::new);
}