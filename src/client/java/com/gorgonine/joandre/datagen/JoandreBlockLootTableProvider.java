package com.gorgonine.joandre.datagen;

import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.item.blocks.BlueberryCropBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JoandreBlockLootTableProvider extends FabricBlockLootTableProvider {
    public JoandreBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.JOANDREITE_BLOCK);

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRIES_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BlueberryCropBlock.AGE,6));
        this.addDrop(ModBlocks.BLUEBERRIES_CROP, this.cropDrops(ModBlocks.BLUEBERRIES_CROP, ModItems.BLUEBERRIES, ModItems.BLUEBERRY_SEEDS, builder2));
        
    }
}
