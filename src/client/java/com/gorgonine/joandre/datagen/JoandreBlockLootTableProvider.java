package com.gorgonine.joandre.datagen;

import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.item.blocks.BlueberryCropBlock;
import com.gorgonine.joandre.item.blocks.StrawberryCropBlock;
import com.gorgonine.joandre.item.blocks.VanillaBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JoandreBlockLootTableProvider extends FabricBlockLootTableProvider {
    public JoandreBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);

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

        addDrop(ModBlocks.VANILLA_FLOWER);

        addDrop(ModBlocks.PISRAT_CORE);
        addDrop(ModBlocks.YOGURT_MACHINE);


        this.addDrop(
            ModBlocks.BLUEBERRY_BUSH,
            block -> this.applyExplosionDecay(
                block,
                LootTable.builder()
                    .pool(LootPool.builder()
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueberryCropBlock.AGE, 3))).with(ItemEntry.builder(ModItems.BLUEBERRIES)))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                    )
                    .pool(LootPool.builder()
                        .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.BLUEBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BlueberryCropBlock.AGE, 2)))
                        .with(ItemEntry.builder(ModItems.BLUEBERRIES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                    )
        );
        this.addDrop(
                ModBlocks.STRAWBERRY_BUSH,
                block -> this.applyExplosionDecay(
                                block,
                                LootTable.builder()
                                        .pool(LootPool.builder()
                                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(StrawberryCropBlock.AGE, 3))).with(ItemEntry.builder(ModItems.STRAWBERRIES)))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        )
                        .pool(LootPool.builder()
                                .conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(StrawberryCropBlock.AGE, 2)))
                                .with(ItemEntry.builder(ModItems.STRAWBERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        )
        );



    }

}

