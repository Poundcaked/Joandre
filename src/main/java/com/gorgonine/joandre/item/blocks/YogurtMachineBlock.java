package com.gorgonine.joandre.item.blocks;

import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.item.blocks.entity.custom.YogurtMachineBlockEntity;
import com.gorgonine.joandre.util.ModComponents;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class YogurtMachineBlock extends BlockWithEntity implements BlockEntityProvider {

    private static final VoxelShape SHAPE =
        Block.createCuboidShape(0, 0, 0, 16, 16, 16);
    public static final MapCodec<YogurtMachineBlock> CODEC = YogurtMachineBlock.createCodec(YogurtMachineBlock::new);
    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;


    public YogurtMachineBlock(Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<YogurtMachineBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new YogurtMachineBlockEntity(pos,state);
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
            if(!world.isClient){
                if(!player.getStackInHand(player.getActiveHand()).isOf(ModItems.EMPTY_YOGURT)){ //if player is not holding empty yogurt cup
                    player.openHandledScreen(yogurtMachineBlockEntity);
                    world.playSound(null,pos, SoundEvents.BLOCK_ENDER_CHEST_OPEN, SoundCategory.BLOCKS, 0.2f, 1f);
                }else if(player.getStackInHand(player.getActiveHand()).isOf(ModItems.EMPTY_YOGURT)){ //If they are
                    if(yogurtMachineBlockEntity.getItems().getFirst() != null){
                        ItemStack yogurtBagStack = yogurtMachineBlockEntity.getStack(0);
                        int yogurtLevel = yogurtMachineBlockEntity.getStack(0).getComponents().get(ModComponents.YOGURT_LEVEL_COMPONENT);
                        if(yogurtLevel>0){
                            yogurtBagStack.set(ModComponents.YOGURT_LEVEL_COMPONENT, yogurtLevel - 5);
                            yogurtMachineBlockEntity.setStack(0, yogurtBagStack);
                            yogurtMachineBlockEntity.markDirty();
                            world.updateListeners(pos, state, yogurtMachineBlockEntity.getCachedState(), 0);
                            stack.decrement(1);
                            world.playSound(null,pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.35f, 1f);
                            if(yogurtMachineBlockEntity.getStack(0).isOf(ModItems.VANILLA_YOGURT_BAG)){
                                player.getInventory().insertStack(new ItemStack(ModItems.VANILLA_YOGURT));
                            }else if(yogurtMachineBlockEntity.getStack(0).isOf(ModItems.STRAWBERRY_YOGURT_BAG)){
                                player.getInventory().insertStack(new ItemStack(ModItems.STRAWBERRY_YOGURT));
                            }else if(yogurtMachineBlockEntity.getStack(0).isOf(ModItems.BLUEBERRY_YOGURT_BAG)){
                                player.getInventory().insertStack(new ItemStack(ModItems.BLUEBERRY_YOGURT));
                            }
                            world.updateListeners(pos, state, yogurtMachineBlockEntity.getCachedState(), 0);
                        }else{
                            yogurtMachineBlockEntity.setStack(0,new ItemStack(ModItems.EMPTY_YOGURT_BAG));
                            world.updateListeners(pos, state, yogurtMachineBlockEntity.getCachedState(), 0);
                        }

                    }

                }
            }


        }

        return ActionResult.SUCCESS;
    }

}
