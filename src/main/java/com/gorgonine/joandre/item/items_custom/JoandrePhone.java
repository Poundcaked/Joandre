package com.gorgonine.joandre.item.items_custom;

import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public class JoandrePhone extends Item {
    public JoandrePhone(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(clickedBlock instanceof LeveledCauldronBlock){
            BlockState state = world.getBlockState(context.getBlockPos());
            if(((LeveledCauldronBlock) clickedBlock).isFull(state)){
                if(!world.isClient && player != null){
                    ItemStack disgustingPhone = new ItemStack(ModItems.DISGUSTING_JOANDRE_PHONE);
                    player.setStackInHand(context.getHand(), disgustingPhone);

                    world.playSound(null,context.getBlockPos(), ModSounds.EWWW, SoundCategory.PLAYERS);
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}
