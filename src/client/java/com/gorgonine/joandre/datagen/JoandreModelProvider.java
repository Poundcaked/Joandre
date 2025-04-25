package com.gorgonine.joandre.datagen;

import com.gorgonine.joandre.block.ModBlocks;
import com.gorgonine.joandre.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class JoandreModelProvider  extends FabricModelProvider {
    public JoandreModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.JOANDREITE_BLOCK);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.JOANDREITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.JOANDRE_PHONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DISGUSTING_JOANDRE_PHONE, Models.GENERATED);

        itemModelGenerator.register(ModItems.EMPTY_YOGURT, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY_YOGURT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANILLA_YOGURT, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLUEBERRIES, Models.GENERATED);

        itemModelGenerator.register(ModItems.YOGURT_BAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.GULCH_YOU_AGAIN_MUSIC_DISC, Models.GENERATED);
    }

    @Override
    public String getName() {
        return "Joandre Model Provider";
    }
}
