package com.gorgonine.joandre.util;

import com.gorgonine.joandre.item.ModItems;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class ModServerEvents {
    public static void initialize(){
        CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRIES, 0.5f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRY_SEEDS, 0.25f);

        CompostingChanceRegistry.INSTANCE.add(ModItems.STRAWBERRIES, 0.5f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.STRAWBERRY_SEEDS, 0.55f);


        CompostingChanceRegistry.INSTANCE.add(ModItems.VANILLA_BEANS, 0.55f);


    }
}
