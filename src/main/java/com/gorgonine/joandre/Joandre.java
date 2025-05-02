package com.gorgonine.joandre;

import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.ModItemGroups;
import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.item.blocks.entity.ModBlockEntities;
import com.gorgonine.joandre.sound.ModSounds;
import com.gorgonine.joandre.util.ModComponents;
import com.gorgonine.joandre.util.ModServerEvents;
import com.gorgonine.joandre.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Joandre implements ModInitializer {
    public static final String MOD_ID = "joandre";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();

        ModSounds.registerSounds();
        ModComponents.initialize();

        ModItemGroups.registerItemGroups();

        ModBlockEntities.registerBlockEntities();

        ModServerEvents.initialize();

        ModWorldGeneration.generateModWorldGen();
        LOGGER.info("Joandre Initialized");
    }
}
