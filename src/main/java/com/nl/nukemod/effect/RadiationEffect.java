package com.nl.nukemod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;

public class RadiationEffect extends MobEffect {
	
    public RadiationEffect() {
        super(MobEffectCategory.HARMFUL, 0x00FF00); // зеленый цвет сердечек
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.hurt(DamageSource.MAGIC, 1.0F);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}