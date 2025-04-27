package com.gorgonine.joandre.client;

import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.util.ModComponents;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ModClientEvents{
    public static void initialize(){
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if(itemStack.contains(ModComponents.YOGURT_LEVEL_COMPONENT)){
                if (!(itemStack.isOf(ModItems.VANILLA_YOGURT_BAG) || itemStack.isOf(ModItems.STRAWBERRY_YOGURT_BAG) || itemStack.isOf(ModItems.BLUEBERRY_YOGURT_BAG))) {
                    return;
                }

                int yogurtLevel = itemStack.getOrDefault(ModComponents.YOGURT_LEVEL_COMPONENT, 100);

                list.add(Text.translatable("tooltip.yogurt_bag.level", yogurtLevel).formatted(Formatting.GOLD));
            }
        });
    }
}


