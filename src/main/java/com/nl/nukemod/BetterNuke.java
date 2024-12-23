package com.nl.nukemod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import com.nl.nukemod.init.ModEffects;
import com.nl.nukemod.init.ModItems;
import com.nl.nukemod.radiation.RadiationContamination;
import com.nl.nukemod.world.ModWorldGen;
import com.nl.nukemod.block.NuclearDetonatorBlock;
import com.nl.nukemod.explosion.NuclearExplosion;
import com.nl.nukemod.init.ModBlocks;
import com.nl.nukemod.init.ModCreativeModeTab;


import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BetterNuke.MOD_ID)
public class BetterNuke {
    public static final String MOD_ID = "nukemod";

    public BetterNuke() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // регистрация блоков, предметов и эффектов
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModEffects.EFFECTS.register(modEventBus);

        // регистрация событий
        MinecraftForge.EVENT_BUS.register(this);

        // регистрация событий мода
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        // регистрация вкладки креативного режима
        modEventBus.addListener(this::registerCreativeTabs);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        
        event.enqueueWork(() -> {
            ModWorldGen.register(FMLJavaModLoadingContext.get().getModEventBus());
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        
    }

    private void registerCreativeTabs(final CreativeModeTabEvent.Register event) {
        
        event.registerCreativeModeTab(new ResourceLocation(BetterNuke.MOD_ID, "nukemod_tab"), builder -> builder
                .title(net.minecraft.network.chat.Component.translatable("itemGroup." + BetterNuke.MOD_ID + "_tab"))
                .icon(() -> new ItemStack(ModItems.URANIUM_ORE.get()))
                .displayItems((flags, output, hasPermissions) -> {
                	output.accept(ModItems.URANIUM_ORE.get()); // урановая руда
                    output.accept(ModItems.RADIATION_ABSORBER.get()); // поглотитель радиации
                    output.accept(ModItems.NUCLEAR_DETONATOR.get()); // детонатор
                    output.accept(ModItems.NUCLEAR_CHARGE.get()); // ядерный заряд
                })
        );
    }

    @SubscribeEvent
    public void onCreativeTabBuildContents(CreativeModeTabEvent.BuildContents event) {
        
        if (event.getTab() == ModCreativeModeTab.NUKEMOD_TAB) {
            event.accept(ModItems.URANIUM_ORE.get());
        }
    }
    
    @SubscribeEvent
    public void onExplosion(ExplosionEvent.Detonate event) {
        Level level = event.getLevel();
        Vec3 explosionVec = event.getExplosion().getPosition();
        BlockPos explosionPos = new BlockPos(explosionVec.x, explosionVec.y, explosionVec.z);

        // проверяем что взрыв произошел рядом с нашим детонатором
        BlockState blockState = level.getBlockState(explosionPos);
        if (blockState.getBlock() instanceof NuclearDetonatorBlock) {
            // создаем ядерный взрыв
            NuclearExplosion.createExplosion(level, explosionPos);
            // заражаем область радиацией
            RadiationContamination.contaminateArea(level, explosionPos);
        }
    }
    
    
    
}