package com.gorgonine.joandre.item;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.item.blocks.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.spongepowered.include.com.google.common.base.Function;

public class ModBlocks {
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Joandre.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Joandre.MOD_ID, name));
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(ModBlocks.JOANDREITE_BLOCK.asItem());
        });
    }

    public static final Block JOANDREITE_BLOCK = register(
            "joandreite_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.METAL)
                    .strength(1f)
                    .requiresTool()
                    .mapColor(MapColor.CYAN)
                    .hardness(1f),
            true

    );
    public static final Block JOANDREITE_ORE = register(
            "joandreite_ore",
            Block::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
                    .strength(3f),
            true
    );

    public static final Block DEEPSLATE_JOANDREITE_ORE = register(
            "deepslate_joandreite_ore",
            Block::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)
                    .strength(4f),
            true
    );

    public static final Block VANILLA_YOGURT_STAIN = register(
            "vanilla_yogurt_stain",
            MultifaceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE_GRAY)
                    .sounds(BlockSoundGroup.SLIME)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .replaceable()
                    .noCollision()
                    .slipperiness(1f),
            false
    );

    public static final Block STRAWBERRY_YOGURT_STAIN = register(
            "strawberry_yogurt_stain",
            MultifaceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PINK)
                    .sounds(BlockSoundGroup.SLIME)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .replaceable()
                    .noCollision()
                    .slipperiness(1f),
            false
    );

    public static final Block BLUEBERRY_YOGURT_STAIN = register(
            "blueberry_yogurt_stain",
            MultifaceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLUE)
                    .sounds(BlockSoundGroup.SLIME)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .replaceable()
                    .noCollision()
                    .slipperiness(1f),
            false
    );

    public static final Block BLUEBERRIES_CROP = register(
            "blueberry_plant",
            BlueberryCropBlock::new,
            AbstractBlock.Settings.create()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .burnable()
                    .noCollision()
                    .mapColor(MapColor.DARK_AQUA),
            false
    );

    public static final Block STRAWBERRIES_CROP = register(
            "strawberry_plant",
            StrawberryCropBlock::new,
            AbstractBlock.Settings.create()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .burnable()
                    .noCollision()
                    .mapColor(MapColor.DARK_CRIMSON),
            false
    );

    public static final Block VANILLA_PLANT = register(
            "vanilla_plant",
            VanillaBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.GREEN)
                    .ticksRandomly()
                    .strength(0.2F, 3.0F)
                    .sounds(BlockSoundGroup.SMALL_DRIPLEAF)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY),
            false
    );

    public static final Block YOGURT_MACHINE = register(
            "yogurt_machine",
            YogurtMachineBlock::new,
            AbstractBlock.Settings.create()
                    .registryKey(keyOfBlock("yogurt_machine"))
                    .strength(2f,2f)
                    .requiresTool()
                    .nonOpaque(),

            true
    );


}
