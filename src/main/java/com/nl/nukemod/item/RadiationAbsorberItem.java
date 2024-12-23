package com.nl.nukemod.item;

import com.nl.nukemod.BetterNuke;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RadiationAbsorberItem extends Item {
	public RadiationAbsorberItem() {
		super(new Item.Properties());
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BetterNuke.MOD_ID);

    public static final RegistryObject<Item> RADIATION_ABSORBER = ITEMS.register("radiation_absorber", RadiationAbsorberItem::new);
}