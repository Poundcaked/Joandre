package com.gorgonine.joandre.item;


import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;

import java.util.List;

public class ModConsumableComponents  {
    public static final ConsumableComponent BLUEBERRY = food().consumeSeconds(0.45F).build();
    public static final ConsumableComponent STRAWBERRY = food().consumeSeconds(0.75F).build();

    public static final ConsumableComponent STRAWBERRY_YOGURT = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(
                                    new StatusEffectInstance(StatusEffects.REGENERATION, 300, 0)
                            )
                    )
            )
            .build();

    public static final ConsumableComponent VANILLA_YOGURT = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(
                                    new StatusEffectInstance(StatusEffects.SPEED, 200, 1)
                            )
                    )
            )
            .build();

    public static final ConsumableComponent BLUEBERRY_YOGURT = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 250, 0)
                            )
                    )
            )
            .build();

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }
}
