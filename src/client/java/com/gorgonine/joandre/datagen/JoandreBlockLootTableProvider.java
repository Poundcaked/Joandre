package com.gorgonine.joandre.datagen;

import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.item.blocks.BlueberryCropBlock;
import com.gorgonine.joandre.item.blocks.StrawberryCropBlock;
import com.gorgonine.joandre.item.blocks.VanillaBlock;
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

        addDrop(ModBlocks.JOANDREITE_ORE, oreDrops(ModBlocks.JOANDREITE_ORE,ModItems.JOANDREITE_SHARD));
        addDrop(ModBlocks.DEEPSLATE_JOANDREITE_ORE, oreDrops(ModBlocks.JOANDREITE_ORE,ModItems.JOANDREITE_SHARD));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRIES_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(BlueberryCropBlock.AGE,6));
        this.addDrop(ModBlocks.BLUEBERRIES_CROP, this.cropDrops(ModBlocks.BLUEBERRIES_CROP, ModItems.BLUEBERRIES, ModItems.BLUEBERRY_SEEDS, builder2));


        BlockStatePropertyLootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRIES_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(StrawberryCropBlock.AGE,6));
        this.addDrop(ModBlocks.STRAWBERRIES_CROP, this.cropDrops(ModBlocks.STRAWBERRIES_CROP, ModItems.STRAWBERRIES, ModItems.STRAWBERRY_SEEDS, builder3));

        BlockStatePropertyLootCondition.Builder builder4 = BlockStatePropertyLootCondition.builder(ModBlocks.VANILLA_PLANT)
                .properties(StatePredicate.Builder.create().exactMatch(VanillaBlock.AGE,2));
        this.addDrop(ModBlocks.VANILLA_PLANT, this.cropDrops(ModBlocks.VANILLA_PLANT, ModItems.VANILLA_BEANS,ModItems.VANILLA_BEANS, builder4));
        
    }
}
