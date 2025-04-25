package com.gorgonine.joandre.datagen;

import java.util.concurrent.CompletableFuture;

import com.gorgonine.joandre.block.ModBlocks;
import com.gorgonine.joandre.item.ModItems;
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

                createShaped(RecipeCategory.MISC, ModItems.YOGURT_BAG, 1)
                        .pattern("i i")
                        .pattern("i i")
                        .pattern(" I ")
                        .input('i', Items.PAPER)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.PAPER),conditionsFromItem(Items.PAPER))
                        .criterion(hasItem(Items.IRON_INGOT),conditionsFromItem(Items.IRON_INGOT))
                        .group("multi_bench")
                        .offerTo(exporter);

//                createShaped(RecipeCategory.FOOD, ModItems.YOGURT_BAG ,1)
//                        .pattern("i i")
//                        .pattern("ibi")
//                        .pattern(" I ")
//                        .input('i', Items.PAPER)
//                        .input('I', Items.IRON_INGOT)
//                        .input('b', ModItems.BLUEBERRIES)
//                        .criterion(hasItem(ModItems.BLUEBERRIES), conditionsFromItem(ModItems.BLUEBERRIES))
//                        .offerTo(exporter);

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
            }
        };
    }

    @Override
    public String getName() {
        return "Joandre Recipe Provider";
    }
}