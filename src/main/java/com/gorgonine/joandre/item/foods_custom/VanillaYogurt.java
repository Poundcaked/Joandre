package com.gorgonine.joandre.item.foods_custom;

import com.gorgonine.joandre.item.ModItems;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class VanillaYogurt extends Item{
    public VanillaYogurt(Settings settings){
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack,world,user);

        if(user instanceof PlayerEntity player && !player.getAbilities().creativeMode){
            stack.decrement(1);

            ItemStack emptyYogurt = new ItemStack(ModItems.EMPTY_YOGURT);

            if(!player.getInventory().insertStack(emptyYogurt)){
                player.dropItem(emptyYogurt, false);
            }
        }
        return stack.isEmpty() ? new ItemStack(ModItems.EMPTY_YOGURT) : stack;
    }


}
