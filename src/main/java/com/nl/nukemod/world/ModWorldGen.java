package com.nl.nukemod.world;

import java.util.List;

import com.nl.nukemod.BetterNuke;
import com.nl.nukemod.init.ModBlocks;

import net.minecraft.core.HolderSet;

import net.minecraft.core.registries.Registries;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.tags.BlockTags;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModWorldGen {
    // DeferredRegister для регистрации ConfiguredFeature и PlacedFeature
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, BetterNuke.MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, BetterNuke.MOD_ID);

    // DeferredRegister для регистрации BiomeModifiers
    public static final DeferredRegister<BiomeModifier> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIERS, BetterNuke.MOD_ID);

 // настройка для генерации руды 
    private static final List<OreConfiguration.TargetBlockState> URANIUM_ORE_TARGET_LIST = List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.URANIUM_ORE.get().defaultBlockState())
    );		
    
    // регистрация ConfiguredFeature для URANIUM_ORE
    public static final RegistryObject<ConfiguredFeature<?, ?>> URANIUM_ORE = CONFIGURED_FEATURES.register("uranium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(URANIUM_ORE_TARGET_LIST, 9)));

    // регистрация PlacedFeature
    public static final RegistryObject<PlacedFeature> URANIUM_ORE_PLACED = PLACED_FEATURES.register("uranium_ore_placed",
            () -> new PlacedFeature(URANIUM_ORE.getHolder().get(), List.of(
                CountPlacement.of(20),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64)),
                BiomeFilter.biome()
            )));

    // регистрация BiomeModifier
    public static final RegistryObject<BiomeModifier> URANIUM_ORE_BIOME_MODIFIER = BIOME_MODIFIERS.register("uranium_ore_biome_modifier",
            () -> new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                    HolderSet.direct(ForgeRegistries.BIOMES.getHolder(ResourceKey.create(Registries.BIOME, new ResourceLocation("minecraft:windswept_gravelly_hills"))).get()),
                    HolderSet.direct(URANIUM_ORE_PLACED.getHolder().get()),
                    GenerationStep.Decoration.UNDERGROUND_ORES
            ));
    

  
    
    public static void register(IEventBus eventBus) {
    	CONFIGURED_FEATURES.register(eventBus);
        System.out.println("Registered configured features for nukemod");
        PLACED_FEATURES.register(eventBus);
        System.out.println("Registered placed features for nukemod");
        BIOME_MODIFIERS.register(eventBus);
        System.out.println("Registered biome modifiers for nukemod");
    }
}