package com.nl.nukemod.init;

import com.nl.nukemod.BetterNuke;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab NUKEMOD_TAB = CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(net.minecraft.network.chat.Component.translatable("itemGroup." + BetterNuke.MOD_ID + "_tab"))
            .icon(() -> new ItemStack(ModItems.URANIUM_ORE.get()))
            
            .build(); // создаем вкладку
}