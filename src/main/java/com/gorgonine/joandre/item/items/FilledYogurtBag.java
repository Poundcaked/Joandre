package com.gorgonine.joandre.item.items;

import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.util.ModComponents;
import com.gorgonine.joandre.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MultifaceBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class FilledYogurtBag extends Item {
    Block blockToPlace;

    public FilledYogurtBag(Settings settings, Block blockToPlace) {
        super(settings);
        this.blockToPlace = blockToPlace;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();

        ItemStack stack = context.getStack();

        if (world.isClient) {
            return ActionResult.FAIL;
        }

        int level = stack.getOrDefault(ModComponents.YOGURT_LEVEL_COMPONENT,100);

        if(level > 0){
            BlockPos clickedPos = context.getBlockPos();
            Direction side = context.getSide();
            BlockPos placePos = clickedPos.offset(side);

            PlayerEntity player = context.getPlayer();

            Block clickedBlock = world.getBlockState(clickedPos).getBlock();

            if(!isValidBlock(clickedBlock)){
                BlockState yogurtState = blockToPlace.getDefaultState()
                        .with(MultifaceBlock.getProperty(side.getOpposite()), true);

                world.setBlockState(placePos, yogurtState);
                world.playSound(null,context.getBlockPos(), SoundEvents.BLOCK_SLIME_BLOCK_BREAK, SoundCategory.BLOCKS);

                assert player != null;
                if(!player.getAbilities().creativeMode){
                    stack.set(ModComponents.YOGURT_LEVEL_COMPONENT, --level);
                }


                if(level == 0){
                    ItemStack empty = new ItemStack(ModItems.EMPTY_YOGURT_BAG);

                    if(!player.getInventory().insertStack(empty)){
                        player.dropItem(empty, false);
                    }else{
                        player.getInventory().insertStack(empty);
                    }
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    private boolean isValidBlock(Block block) {
        return block.getDefaultState().isIn(ModTags.Blocks.YOGURT_STAINS);
    }

}

