package com.gorgonine.joandre.world.gen;

import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.blocks.VanillaBlock;
import com.mojang.serialization.Codec;
import net.minecraft.block.CocoaBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;


public class VanillaTreeDecorator extends TreeDecorator {
    public static final VanillaTreeDecorator INSTANCE = new VanillaTreeDecorator();
    // Our constructor doesn't have any arguments, so we create a unit codec that returns the singleton instance
    public static final Codec<VanillaTreeDecorator> CODEC = Codec.unit(() -> INSTANCE);

    public VanillaTreeDecorator() {}

    @Override
    protected TreeDecoratorType<?> getType() {
        return TreeDecoratorType.COCOA;
    }

    @Override
    public void generate(TreeDecorator.Generator generator) {
        Random random = generator.getRandom();
        if (!(random.nextFloat() >= 0.25f)) {
            List<BlockPos> list = generator.getLogPositions();
            if (!list.isEmpty()) {
                int i = ((BlockPos)list.getFirst()).getY();
                list.stream().filter(pos -> pos.getY() - i <= 2).forEach(pos -> {
                    for (Direction direction : Direction.Type.HORIZONTAL) {
                        if (random.nextFloat() <= 0.25F) {
                            Direction direction2 = direction.getOpposite();
                            BlockPos blockPos = pos.add(direction2.getOffsetX(), 0, direction2.getOffsetZ());
                            if (generator.isAir(blockPos)) {
                                generator.replace(blockPos, ModBlocks.VANILLA_PLANT.getDefaultState().with(CocoaBlock.AGE, random.nextInt(3)).with(VanillaBlock.FACING, direction));
                            }
                        }
                    }
                });
            }
        }
    }
}
