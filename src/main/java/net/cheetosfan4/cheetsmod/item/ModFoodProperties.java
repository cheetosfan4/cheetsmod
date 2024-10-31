package net.cheetosfan4.cheetsmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties cheese = new FoodProperties.Builder().nutrition(8).saturationModifier(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 400), 0.35f).build();

    public static final FoodProperties poop = new FoodProperties.Builder()
            .nutrition(0)
            .saturationModifier(0f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 6000, 3), 1.0F)
            .effect(new MobEffectInstance(MobEffects.POISON, 2400, 0), 1.0F)
            .alwaysEdible()
            .build();
}
