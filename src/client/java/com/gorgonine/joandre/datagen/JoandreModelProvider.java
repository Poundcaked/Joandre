package com.gorgonine.joandre.datagen;

import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.item.blocks.BlueberryCropBlock;
import com.gorgonine.joandre.item.blocks.StrawberryCropBlock;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class JoandreModelProvider extends FabricModelProvider {

    public JoandreModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JOANDREITE_BLOCK);
        blockStateModelGenerator.registerCrop(ModBlocks.BLUEBERRIES_CROP, BlueberryCropBlock.AGE, 0,1,2,3,4,5,6);
        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRIES_CROP, StrawberryCropBlock.AGE, 0,1,2,3,4,5,6);

        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.VANILLA_YOGURT_STAIN);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.BLUEBERRY_YOGURT_STAIN);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.STRAWBERRY_YOGURT_STAIN);

    }



    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.JOANDREITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.JOANDRE_PHONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DISGUSTING_JOANDRE_PHONE, Models.GENERATED);

        itemModelGenerator.register(ModItems.EMPTY_YOGURT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY_YOGURT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANILLA_YOGURT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRY_YOGURT, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLUEBERRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANILLA_BEANS, Models.GENERATED);

        itemModelGenerator.register(ModItems.EMPTY_YOGURT_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY_YOGURT_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANILLA_YOGURT_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUEBERRY_YOGURT_BAG, Models.GENERATED);

        itemModelGenerator.register(ModItems.GULCH_YOU_AGAIN_MUSIC_DISC, Models.GENERATED);



    }

    @Override
    public String getName() {
        return "Joandre Model Provider";
    }
}
