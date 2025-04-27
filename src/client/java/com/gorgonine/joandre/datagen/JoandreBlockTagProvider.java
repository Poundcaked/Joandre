package com.gorgonine.joandre.datagen;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.item.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class JoandreBlockTagProvider extends FabricTagProvider<Block> {
    public JoandreBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    public static final TagKey<Block> YOGURT_STAINS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Joandre.MOD_ID, "yogurt_stains"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(YOGURT_STAINS)
                .add(ModBlocks.VANILLA_YOGURT_STAIN)
                .add(ModBlocks.STRAWBERRY_YOGURT_STAIN)
                .add(ModBlocks.BLUEBERRY_YOGURT_STAIN)
                .setReplace(true);
    }
}
