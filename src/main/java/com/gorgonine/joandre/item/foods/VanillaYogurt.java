package com.gorgonine.joandre.item.foods;

import com.gorgonine.joandre.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class VanillaYogurt extends Item{
    public VanillaYogurt(Settings settings){
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack,world,user);

        if(user instanceof PlayerEntity player && !player.getAbilities().creativeMode){
            ItemStack emptyYogurt = new ItemStack(ModItems.EMPTY_YOGURT);
            player.getInventory().insertStack(emptyYogurt);
        }
        return stack;
    }


}
