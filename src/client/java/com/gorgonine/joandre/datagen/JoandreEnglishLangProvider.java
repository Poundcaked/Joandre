package com.gorgonine.joandre.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class JoandreEnglishLangProvider extends FabricLanguageProvider {
    public JoandreEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // Specifying en_us is optional, as it's the default language code
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.joandre.joandre_phone", "Joandre's Phone");
        translationBuilder.add("item.joandre.disgusting_joandre_phone", "Joandre's Disgusting Phone");

        translationBuilder.add("item.joandre.empty_cup_of_yogurt", "Empty Cup of Yogurt");
        translationBuilder.add("item.joandre.strawberry_yogurt", "Strawberry Yogurt");
        translationBuilder.add("item.joandre.vanilla_yogurt", "Vanilla Yogurt");
        translationBuilder.add("item.joandre.blueberries", "Blueberries");

        translationBuilder.add("item.joandre.joandreite_ingot", "Joandreite Ingot");
        translationBuilder.add("item.joandre.joandreite_block", "Joandreite Block");

        translationBuilder.add("itemGroup.joandre_armory", "Joandre's Armory");
        translationBuilder.add("itemGroup.joandre_kitchen", "Joandre's Kitchen");


    }
}