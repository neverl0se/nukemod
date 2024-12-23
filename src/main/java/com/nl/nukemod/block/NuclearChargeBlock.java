package com.nl.nukemod.block;

import com.nl.nukemod.BetterNuke;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NuclearChargeBlock extends Block {
    public NuclearChargeBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(5.0F, 6.0F));
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterNuke.MOD_ID);

    public static final RegistryObject<Block> NUCLEAR_CHARGE = BLOCKS.register("nuclear_charge", NuclearChargeBlock::new);
}

