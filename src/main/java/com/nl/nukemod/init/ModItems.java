package com.nl.nukemod.init;

import com.nl.nukemod.BetterNuke;
import com.nl.nukemod.block.UraniumOreBlock;
import com.nl.nukemod.item.RadiationAbsorberItem;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterNuke.MOD_ID);
	
	// поглотитель радиации
	public static final RegistryObject<Item> RADIATION_ABSORBER = ITEMS.register("radiation_absorber", RadiationAbsorberItem::new);
	
	// урановая руда
	public static final RegistryObject<Item> URANIUM_ORE = ITEMS.register("uranium_ore", () ->
	        new BlockItem(UraniumOreBlock.URANIUM_ORE.get(), new Item.Properties()));
	
	// детонатор
    public static final RegistryObject<Item> NUCLEAR_DETONATOR = ITEMS.register("nuclear_detonator", () ->
            new BlockItem(ModBlocks.NUCLEAR_DETONATOR.get(), new Item.Properties()));

    // ядерный заряд
    public static final RegistryObject<Item> NUCLEAR_CHARGE = ITEMS.register("nuclear_charge", () ->
            new BlockItem(ModBlocks.NUCLEAR_CHARGE.get(), new Item.Properties()));
	
}