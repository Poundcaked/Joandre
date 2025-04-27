package com.gorgonine.joandre.util;

import com.gorgonine.joandre.Joandre;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModComponents {
    public static void initialize() {

    }

    public static final ComponentType<Integer> YOGURT_LEVEL_COMPONENT = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Joandre.MOD_ID, "yogurt_level"),
            ComponentType.<Integer>builder().codec(Codec.INT).build()
    );
}