package com.gorgonine.joandre.client;

import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.blocks.entity.ModBlockEntities;
import com.gorgonine.joandre.blockentityrenderer.YogurtMachineBlockEntityRenderer;
import com.gorgonine.joandre.screen.ModScreenHandlers;
import com.gorgonine.joandre.screen.YogurtMachineScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class JoandreClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRIES_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRIES_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VANILLA_YOGURT_STAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_YOGURT_STAIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUEBERRY_YOGURT_STAIN, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YOGURT_MACHINE, RenderLayer.getCutout());

        ModClientEvents.initialize();

        BlockEntityRendererFactories.register(ModBlockEntities.YOGURT_MACHINE_BE, YogurtMachineBlockEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.YOGURT_MACHINE_SCREEN_HANDLER, YogurtMachineScreen::new);
    }
}
