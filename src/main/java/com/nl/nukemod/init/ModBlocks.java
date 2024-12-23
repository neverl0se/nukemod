package com.nl.nukemod.init;

import com.nl.nukemod.BetterNuke;
import com.nl.nukemod.block.NuclearChargeBlock;
import com.nl.nukemod.block.NuclearDetonatorBlock;
import com.nl.nukemod.block.UraniumOreBlock;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterNuke.MOD_ID);

	public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", UraniumOreBlock::new); 
	public static final RegistryObject<Block> NUCLEAR_CHARGE = BLOCKS.register("nuclear_charge", NuclearChargeBlock::new); 
	public static final RegistryObject<Block> NUCLEAR_DETONATOR = BLOCKS.register("nuclear_detonator", NuclearDetonatorBlock::new);
	
}

