package com.nl.nukemod.init;

import com.nl.nukemod.BetterNuke;
import com.nl.nukemod.effect.RadiationEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BetterNuke.MOD_ID);

    public static final RegistryObject<MobEffect> RADIATION = EFFECTS.register("radiation", RadiationEffect::new);
}