package com.gorgonine.joandre.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JoandreEnglishLangProvider extends FabricLanguageProvider {
    public JoandreEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.joandre.joandre_phone", "Joandre's Phone");
        translationBuilder.add("item.joandre.disgusting_joandre_phone", "Joandre's Disgusting Phone");

        translationBuilder.add("item.joandre.pisrat_hammer","Pisrat Hammer");

        translationBuilder.add("item.joandre.gulch_you_again_music_disc", "Gulch You Again Music Disc");
        translationBuilder.add("item.joandre.gulch_you_again_music_disc.desc", "Gulch You Again - Pisrat, the Belcher");

        translationBuilder.add("item.joandre.empty_yogurt", "Empty Cup of Yogurt");
        translationBuilder.add("item.joandre.strawberry_yogurt", "Strawberry Yogurt");
        translationBuilder.add("item.joandre.vanilla_yogurt", "Vanilla Yogurt");

        translationBuilder.add("item.joandre.yogurt_stain", "Yogurt Stain");

        translationBuilder.add("item.joandre.blueberries", "Blueberries");
        translationBuilder.add("item.joandre.strawberries", "Strawberries");
        translationBuilder.add("item.joandre.blueberry_seeds","Blueberry Seeds");
        translationBuilder.add("item.joandre.blueberry_crop","Blueberry Plant");

        translationBuilder.add("item.joandre.empty_yogurt_bag", "Empty Yogurt Bag");
        translationBuilder.add("item.joandre.strawberry_yogurt_bag", "Strawberry Yogurt Bag");
        translationBuilder.add("item.joandre.vanilla_yogurt_bag", "Vanilla Yogurt Bag");
        translationBuilder.add("item.joandre.blueberry_yogurt_bag", "Blueberry Yogurt Bag");


        translationBuilder.add("item.joandre.joandreite_ingot", "Joandreite Ingot");
        translationBuilder.add("item.joandre.joandreite_block", "Joandreite Block");

        translationBuilder.add("itemGroup.joandre_armory", "Joandre's Armory");
        translationBuilder.add("itemGroup.joandre_kitchen", "Joandre's Kitchen");

        translationBuilder.add("tooltip.yogurt_bag.level", "Yogurt Level: %s%%");

        translationBuilder.add("sounds.joandre.ewww","Ewww!");
        translationBuilder.add("sounds.joandre.gulch_you_again","Gulch You Again - Pisrat, The Belcher");
    }
}