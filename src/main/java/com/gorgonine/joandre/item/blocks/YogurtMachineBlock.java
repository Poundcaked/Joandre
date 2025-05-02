package com.gorgonine.joandre.item.blocks;

import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.item.blocks.entity.custom.YogurtMachineBlockEntity;
import com.gorgonine.joandre.util.ModComponents;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.Component;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class YogurtMachineBlock extends BlockWithEntity implements BlockEntityProvider {
//    public static final VoxelShape SHAPE = makeShape();
    private static final VoxelShape SHAPE =
        Block.createCuboidShape(0, 0, 0, 16, 16, 16);
    public static final MapCodec<YogurtMachineBlock> CODEC = YogurtMachineBlock.createCodec(YogurtMachineBlock::new);


    public YogurtMachineBlock(Settings settings) {
        super(settings);
    }

//    public static VoxelShape makeShape(){
//        VoxelShape shape = VoxelShapes.empty();
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0.375, 1, 1, 1), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0, 1, 0.1875, 0.375), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.1875, 0.6875, 0.0625, 0.3125, 0.8125, 0.375), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.1875, 0.5625, 0.0625, 0.3125, 0.6875, 0.1875), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.1875, 0.3125, 0.25, 0.3125, 0.4375, 0.375), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.4375, 0.3125, 0.25, 0.5625, 0.4375, 0.375), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.6875, 0.3125, 0.25, 0.8125, 0.4375, 0.375), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.4375, 0.6875, 0.0625, 0.5625, 0.8125, 0.375), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.4375, 0.5625, 0.0625, 0.5625, 0.6875, 0.1875), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.6875, 0.6875, 0.0625, 0.8125, 0.8125, 0.375), BooleanBiFunction.OR);
//        shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.6875, 0.5625, 0.0625, 0.8125, 0.6875, 0.1875), BooleanBiFunction.OR);
//
//        return shape;
//    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new YogurtMachineBlockEntity(pos,state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        BlockState newState = world.getBlockState(pos);
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof YogurtMachineBlockEntity) {
                ItemScatterer.spawn(world, pos, (YogurtMachineBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, moved);
        }
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(world.getBlockEntity(pos) instanceof YogurtMachineBlockEntity yogurtMachineBlockEntity) {
            if(!world.isClient && !player.getStackInHand(player.getActiveHand()).isOf(ModItems.EMPTY_YOGURT)){
                player.openHandledScreen(yogurtMachineBlockEntity);
            }else if(!world.isClient && player.getStackInHand(player.getActiveHand()).isOf(ModItems.EMPTY_YOGURT)){
                if(yogurtMachineBlockEntity.getItems().getFirst() != null){
                    ItemStack yogurtBagStack = yogurtMachineBlockEntity.getStack(0);
                    int yogurtLevel = yogurtMachineBlockEntity.getStack(0).getComponents().get(ModComponents.YOGURT_LEVEL_COMPONENT);
                    if(yogurtLevel>0){
                        yogurtBagStack.set(ModComponents.YOGURT_LEVEL_COMPONENT, yogurtLevel - 5);
                        stack.decrement(1);

                        if(yogurtMachineBlockEntity.getStack(0).isOf(ModItems.VANILLA_YOGURT_BAG)){
                            player.getInventory().insertStack(new ItemStack(ModItems.VANILLA_YOGURT));
                        }else if(yogurtMachineBlockEntity.getStack(0).isOf(ModItems.STRAWBERRY_YOGURT_BAG)){
                            player.getInventory().insertStack(new ItemStack(ModItems.STRAWBERRY_YOGURT));
                        }else if(yogurtMachineBlockEntity.getStack(0).isOf(ModItems.BLUEBERRY_YOGURT_BAG)){
                            player.getInventory().insertStack(new ItemStack(ModItems.BLUEBERRY_YOGURT));
                        }
                    }else{
                        yogurtMachineBlockEntity.setStack(0,new ItemStack(ModItems.EMPTY_YOGURT_BAG));
                    }


                }

            }

        }

        return ActionResult.SUCCESS;
    }

}
