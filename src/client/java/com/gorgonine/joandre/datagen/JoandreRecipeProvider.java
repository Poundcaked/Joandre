package com.gorgonine.joandre.datagen;

import java.util.concurrent.CompletableFuture;

import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class JoandreRecipeProvider extends FabricRecipeProvider {
    public JoandreRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() { //add stuff here
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.JOANDREITE_INGOT, 9) // You can also specify an int to produce more than one
                        .input(ModBlocks.JOANDREITE_BLOCK) // You can also specify an int to require more than one, or a tag to accept multiple things
                        .criterion(hasItem(ModBlocks.JOANDREITE_BLOCK), conditionsFromItem(ModBlocks.JOANDREITE_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.JOANDREITE_BLOCK, 1)
                        .pattern("iii")
                        .pattern("iii")
                        .pattern("iii")
                        .input('i', ModItems.JOANDREITE_INGOT)
                        .criterion(hasItem(ModItems.JOANDREITE_INGOT), conditionsFromItem(ModItems.JOANDREITE_INGOT))
                        .group("multi_bench")
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.JOANDREITE_INGOT,2)
                        .pattern("i i")
                        .pattern(" i ")
                        .pattern("i i")
                        .input('i',ModItems.JOANDREITE_SHARD)
                        .criterion(hasItem(ModItems.JOANDREITE_SHARD), conditionsFromItem(ModItems.JOANDREITE_SHARD))
                        .group("multi_bench")
                        .offerTo(exporter,"shard_joandreite_ingot");

                createShaped(RecipeCategory.MISC, ModItems.JOANDRE_PHONE, 1)
                        .pattern("iii")
                        .pattern("ici")
                        .pattern("iRi")
                        .input('i', ModItems.JOANDREITE_INGOT)
                        .input('c', Items.COPPER_INGOT)
                        .input('R', Items.REDSTONE)
                        .criterion(hasItem(ModItems.JOANDREITE_INGOT),conditionsFromItem(ModItems.JOANDREITE_INGOT))
                        .criterion(hasItem(Items.REDSTONE),conditionsFromItem(Items.REDSTONE))
                        .criterion(hasItem(Items.COPPER_INGOT),conditionsFromItem(Items.COPPER_INGOT))
                        .group("multi_bench")
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ModItems.EMPTY_YOGURT, 4)
                        .pattern("i i")
                        .pattern("i i")
                        .pattern("iii")
                        .input('i', Items.PAPER)
                        .criterion(hasItem(Items.PAPER),conditionsFromItem(Items.PAPER))
                        .group("multi_bench")
                        .offerTo(exporter);
//YOGURT BAGS
                createShaped(RecipeCategory.MISC, ModItems.EMPTY_YOGURT_BAG, 1)
                        .pattern("i i")
                        .pattern("i i")
                        .pattern(" I ")
                        .input('i', Items.PAPER)
                        .input('I', Items.IRON_NUGGET)
                        .criterion(hasItem(Items.PAPER),conditionsFromItem(Items.PAPER))
                        .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                        .group("multi_bench")
                        .offerTo(exporter);

                createShaped(RecipeCategory.FOOD, ModItems.BLUEBERRY_YOGURT_BAG ,1)
                        .pattern("ibi")
                        .pattern("ibi")
                        .pattern(" I ")
                        .input('i', Items.PAPER)
                        .input('I', Items.IRON_NUGGET)
                        .input('b', ModItems.BLUEBERRIES)
                        .criterion(hasItem(ModItems.BLUEBERRIES), conditionsFromItem(ModItems.BLUEBERRIES))
                        .offerTo(exporter);

                createShaped(RecipeCategory.FOOD, ModItems.STRAWBERRY_YOGURT_BAG ,1)
                        .pattern("isi")
                        .pattern("isi")
                        .pattern(" I ")
                        .input('i', Items.PAPER)
                        .input('I', Items.IRON_NUGGET)
                        .input('s', ModItems.STRAWBERRIES)
                        .criterion(hasItem(ModItems.STRAWBERRIES), conditionsFromItem(ModItems.STRAWBERRIES))
                        .offerTo(exporter);

                createShaped(RecipeCategory.FOOD, ModItems.VANILLA_YOGURT_BAG ,1)
                        .pattern("ivi")
                        .pattern("ivi")
                        .pattern(" I ")
                        .input('i', Items.PAPER)
                        .input('I', Items.IRON_NUGGET)
                        .input('v', ModItems.VANILLA_BEANS)
                        .criterion(hasItem(ModItems.VANILLA_BEANS), conditionsFromItem(ModItems.VANILLA_BEANS))
                        .offerTo(exporter);
//SHAPELESS BAGS
                createShapeless(RecipeCategory.MISC, ModItems.STRAWBERRY_YOGURT_BAG, 1)
                        .input(ModItems.EMPTY_YOGURT_BAG)
                        .input(ModItems.STRAWBERRIES,2)
                        .criterion(hasItem(ModItems.EMPTY_YOGURT_BAG), conditionsFromItem(ModItems.EMPTY_YOGURT_BAG))
                        .criterion(hasItem(ModItems.STRAWBERRIES), conditionsFromItem(ModItems.STRAWBERRIES))
                        .offerTo(exporter,"shapeless_strawberry_bag");
                createShapeless(RecipeCategory.MISC, ModItems.BLUEBERRY_YOGURT_BAG, 1)
                        .input(ModItems.EMPTY_YOGURT_BAG)
                        .input(ModItems.BLUEBERRIES,2)
                        .criterion(hasItem(ModItems.EMPTY_YOGURT_BAG), conditionsFromItem(ModItems.EMPTY_YOGURT_BAG))
                        .criterion(hasItem(ModItems.BLUEBERRIES), conditionsFromItem(ModItems.BLUEBERRIES))
                        .offerTo(exporter,"shapeless_blueberry_bag");
                createShapeless(RecipeCategory.MISC, ModItems.VANILLA_YOGURT_BAG, 1)
                        .input(ModItems.EMPTY_YOGURT_BAG)
                        .input(ModItems.VANILLA_BEANS,2)
                        .criterion(hasItem(ModItems.EMPTY_YOGURT_BAG), conditionsFromItem(ModItems.EMPTY_YOGURT_BAG))
                        .criterion(hasItem(ModItems.VANILLA_BEANS), conditionsFromItem(ModItems.VANILLA_BEANS))
                        .offerTo(exporter,"shapeless_vanilla_bag");

                createShapeless(RecipeCategory.FOOD, ModItems.BLUEBERRY_SEEDS,4)
                        .input(ModItems.BLUEBERRIES)
                        .criterion(hasItem(ModItems.BLUEBERRIES), conditionsFromItem(ModItems.BLUEBERRIES))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.FOOD, ModItems.STRAWBERRY_SEEDS,12)
                        .input(ModItems.STRAWBERRIES)
                        .criterion(hasItem(ModItems.STRAWBERRIES), conditionsFromItem(ModItems.STRAWBERRIES))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.VANILLA_BEANS,4)
                        .input(ModBlocks.VANILLA_FLOWER.asItem())
                        .criterion(hasItem(ModBlocks.VANILLA_FLOWER.asItem()), conditionsFromItem(ModBlocks.VANILLA_FLOWER.asItem()))
                        .offerTo(exporter);


                createShaped(RecipeCategory.MISC, ModItems.GULCH_YOU_AGAIN_MUSIC_DISC, 1)
                        .pattern("iii")
                        .pattern("ioi")
                        .pattern("iii")
                        .input('i', Items.FLINT)
                        .input('o', ModItems.JOANDREITE_INGOT)
                        .criterion(hasItem(Items.FLINT),conditionsFromItem(Items.FLINT))
                        .criterion(hasItem(ModItems.JOANDREITE_INGOT),conditionsFromItem(ModItems.JOANDREITE_INGOT))
                        .group("multi_bench")
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.PISRAT_HAMMER, 1)
                        .pattern("ioi")
                        .pattern(" i ")
                        .pattern(" i ")
                        .input('i', ModBlocks.JOANDREITE_BLOCK)
                        .input('o', ModBlocks.PISRAT_CORE)
                        .criterion(hasItem(ModBlocks.PISRAT_CORE),conditionsFromItem(ModBlocks.PISRAT_CORE))
                        .criterion(hasItem(ModBlocks.JOANDREITE_BLOCK),conditionsFromItem(ModBlocks.JOANDREITE_BLOCK))
                        .group("multi_bench")
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, ModBlocks.YOGURT_MACHINE, 1)
                        .pattern(" Ii")
                        .pattern("  i")
                        .pattern("sss")
                        .input('i', ModBlocks.JOANDREITE_BLOCK)
                        .input('I', Items.IRON_INGOT)
                        .input('s', Blocks.SMOOTH_STONE)
                        .criterion(hasItem(ModBlocks.JOANDREITE_BLOCK),conditionsFromItem(ModBlocks.JOANDREITE_BLOCK))
                        .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                        .criterion(hasItem(Blocks.SMOOTH_STONE),conditionsFromItem(Blocks.SMOOTH_STONE))
                        .group("multi_bench")
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.PISRAT_CORE, 1)
                        .pattern("wNw")
                        .pattern("ini")
                        .pattern("wNw")
                        .input('n', Items.NETHER_STAR)
                        .input('N', Items.NETHERITE_INGOT)
                        .input('w', Blocks.WHITE_CONCRETE)
                        .input('i', ModItems.JOANDREITE_INGOT)
                        .criterion(hasItem(ModItems.JOANDREITE_INGOT),conditionsFromItem(ModItems.JOANDREITE_INGOT))
                        .criterion(hasItem(Items.NETHER_STAR),conditionsFromItem(Items.NETHER_STAR))
                        .criterion(hasItem(Items.NETHERITE_INGOT),conditionsFromItem(Items.NETHERITE_INGOT))
                        .criterion(hasItem(Blocks.WHITE_BANNER),conditionsFromItem(Blocks.WHITE_BANNER))
                        .group("multi_bench")
                        .offerTo(exporter);


            }
        };
    }

    @Override
    public String getName() {
        return "Joandre Recipe Provider";
    }
}