package com.gorgonine.joandre.item;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.item.foods.BlueberryYogurt;
import com.gorgonine.joandre.item.foods.StrawberryYogurt;
import com.gorgonine.joandre.item.foods.VanillaYogurt;
import com.gorgonine.joandre.item.items.*;
import com.gorgonine.joandre.sound.ModSounds;
import com.gorgonine.joandre.util.ModComponents;
import com.gorgonine.joandre.util.ModTags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.WeaponComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import org.spongepowered.include.com.google.common.base.Function;


public class ModItems {
    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Joandre.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.JOANDRE_PHONE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(ModItems.JOANDREITE_INGOT));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.EMPTY_YOGURT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.STRAWBERRY_YOGURT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.VANILLA_YOGURT));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.EMPTY_YOGURT_BAG));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.BLUEBERRIES));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.VANILLA_BEANS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.STRAWBERRIES));


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ModItems.DISGUSTING_JOANDRE_PHONE));
    }

    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }

    public static final Item GULCH_YOU_AGAIN_MUSIC_DISC = registerItem("gulch_you_again_music_disc", Item::new, new Item.Settings()
            .jukeboxPlayable(ModSounds.GULCH_YOU_AGAIN_KEY).maxCount(1)
    );

    public static final Item DISGUSTING_JOANDRE_PHONE = registerItem("disgusting_joandre_phone", Item::new, new Item.Settings()
            .maxCount(1)
    );

    public static final Item JOANDRE_PHONE = registerItem("joandre_phone", JoandrePhone::new, new Item.Settings()
            .maxCount(1)
    );
    public static final Item JOANDREITE_INGOT = registerItem("joandreite_ingot", Item::new, new Item.Settings());

    public static final Item JOANDREITE_SHARD = registerItem("joandreite_shard", Item::new, new Item.Settings());

    public static final Item PISRAT_HAMMER = registerItem("pisrat_hammer", PisratHammer::new,new Item.Settings()
            .maxCount(1)
            .maxDamage(3300)
            .attributeModifiers(PisratHammer.createAttributeModifiers())
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.TOOL, PisratHammer.createToolComponent())
            .component(DataComponentTypes.WEAPON, new WeaponComponent(1))

    );

    //YOGURT **CUPS**
    public static final Item EMPTY_YOGURT = registerItem("empty_yogurt", Item::new, new Item.Settings());
    public static final Item STRAWBERRY_YOGURT = registerItem("strawberry_yogurt", StrawberryYogurt::new, new Item.Settings().food(ModFoodComponents.STRAWBERRY_YOGURT));
    public static final Item VANILLA_YOGURT = registerItem("vanilla_yogurt", VanillaYogurt::new, new Item.Settings().food(ModFoodComponents.VANILLA_YOGURT));
    public static final Item BLUEBERRY_YOGURT = registerItem("blueberry_yogurt", BlueberryYogurt::new, new Item.Settings().food(ModFoodComponents.BLUEBERRY_YOGURT));

    //CROPS

    public static final Item BLUEBERRIES = registerItem("blueberries", Item::new, new Item.Settings()
            .food(ModFoodComponents.BLUEBERRIES)
            .maxCount(16)

    );

    public static final Item STRAWBERRIES = registerItem("strawberries", Item::new, new Item.Settings()
            .food(ModFoodComponents.STRAWBERRIES)
            .maxCount(16)

    );

    public static final Item VANILLA_BEANS = registerItem("vanilla_beans",createBlockItemWithUniqueName(ModBlocks.VANILLA_PLANT), new Item.Settings()
            .maxCount(16)
    );

    public static final Item BLUEBERRY_SEEDS = registerItem(
            "blueberry_seeds",
            settings -> new BlockItem(ModBlocks.BLUEBERRIES_CROP, settings),
            new Item.Settings()
    );

    public static final Item STRAWBERRY_SEEDS = registerItem(
            "strawberry_seeds",
            settings -> new BlockItem(ModBlocks.STRAWBERRIES_CROP, settings),
            new Item.Settings()
    );


    //BAGS

    public static final Item EMPTY_YOGURT_BAG = registerItem("empty_yogurt_bag", Item::new, new Item.Settings()
            .maxCount(3)
            .component(ModComponents.YOGURT_LEVEL_COMPONENT,0)
    );
    public static final Item VANILLA_YOGURT_BAG = registerItem("vanilla_yogurt_bag", VanillaYogurtBag::new, new Item.Settings()
            .maxCount(3)
            .component(ModComponents.YOGURT_LEVEL_COMPONENT,100)
    );
    public static final Item STRAWBERRY_YOGURT_BAG = registerItem("strawberry_yogurt_bag", StrawberryYogurtBag::new, new Item.Settings()
            .maxCount(3)
            .component(ModComponents.YOGURT_LEVEL_COMPONENT,100)
    );
    public static final Item BLUEBERRY_YOGURT_BAG = registerItem("blueberry_yogurt_bag", BlueberryYogurtBag::new, new Item.Settings()
            .maxCount(3)
            .component(ModComponents.YOGURT_LEVEL_COMPONENT,100)
    );


}
