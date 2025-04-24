package com.gorgonine.joandre.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent STRAWBERRY_YOGURT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.67f).build();
    public static final FoodComponent VANILLA_YOGURT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.67f).build();

    public static final FoodComponent BLUEBERRIES = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1f).build();
}
