package com.gorgonine.joandre.item.blocks.entity;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.blocks.entity.custom.YogurtMachineBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<YogurtMachineBlockEntity> YOGURT_MACHINE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Joandre.MOD_ID,"yogurt_machine_be"),
                    FabricBlockEntityTypeBuilder.create(YogurtMachineBlockEntity::new, ModBlocks.YOGURT_MACHINE).build());

    public static void registerBlockEntities(){

    }

}
