package com.gorgonine.joandre.client;

import com.gorgonine.joandre.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class JoandreDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(JoandreEnglishLangProvider::new);
        pack.addProvider(JoandreRecipeProvider::new);
        pack.addProvider(JoandreItemTagProvider::new);
        pack.addProvider(JoandreBlockLootTableProvider::new);
        pack.addProvider(JoandreModelProvider::new);

    }
}
