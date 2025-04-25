package com.gorgonine.joandre.item.items;

import com.gorgonine.joandre.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class YogurtBag extends Item {
    public YogurtBag(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockPos abovePos = blockPos.up();

        Block aboveBlock = world.getBlockState(abovePos).getBlock();

        if (aboveBlock.equals(Blocks.AIR) || aboveBlock.equals(Blocks.CAVE_AIR) || aboveBlock.equals(Blocks.VOID_AIR) ) {
            world.setBlockState(abovePos, ModBlocks.JOANDREITE_BLOCK.getDefaultState());
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }


}

