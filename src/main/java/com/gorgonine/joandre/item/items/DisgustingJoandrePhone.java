package com.gorgonine.joandre.item.items;

import com.gorgonine.joandre.item.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class DisgustingJoandrePhone extends JoandrePhone {
    public DisgustingJoandrePhone(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();

        world.setBlockState(entity.getBlockPos(),ModBlocks.JOANDRE_SLIME.getDefaultState());
        world.playSound(null,entity.getBlockPos(), SoundEvents.BLOCK_SLIME_BLOCK_PLACE, SoundCategory.BLOCKS);
        world.addParticleClient(ParticleTypes.ITEM_SLIME, entity.getX(),entity.getY(),entity.getZ(), 0,0,0);

        super.useOnEntity(stack,user,entity,hand);

        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        super.useOnBlock(context);

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(clickedBlock instanceof LeveledCauldronBlock){
            return ActionResult.FAIL;
        }else{
            world.setBlockState(context.getBlockPos(), ModBlocks.JOANDRE_SLIME.getDefaultState());
            world.playSound(null,context.getBlockPos(), SoundEvents.BLOCK_SLIME_BLOCK_PLACE, SoundCategory.BLOCKS);
            world.addParticleClient(ParticleTypes.ITEM_SLIME, context.getBlockPos().getX(), context.getBlockPos().getY(),context.getBlockPos().getZ(), 0,0,0);
        }

        return ActionResult.SUCCESS;
    }
}
