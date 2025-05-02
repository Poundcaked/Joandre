package com.gorgonine.joandre.client;

import com.gorgonine.joandre.datagen.*;
import com.gorgonine.joandre.world.ModConfiguredFeatures;
import com.gorgonine.joandre.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class JoandreDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(JoandreEnglishLangProvider::new);
        pack.addProvider(JoandreRecipeProvider::new);

        pack.addProvider(JoandreItemTagProvider::new);
        pack.addProvider(JoandreBlockTagProvider::new);

        pack.addProvider(JoandreBlockLootTableProvider::new);

        pack.addProvider(JoandreRegistryDataGenerator::new);

        pack.addProvider(JoandreModelProvider::new);

    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
