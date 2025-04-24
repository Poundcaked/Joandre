package com.gorgonine.joandre.item;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.item.foods_custom.StrawberryYogurt;
import com.gorgonine.joandre.item.foods_custom.VanillaYogurt;
import com.gorgonine.joandre.item.items_custom.JoandrePhone;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ModItems.BLUEBERRIES));


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ModItems.DISGUSTING_JOANDRE_PHONE));
    }


    public static final Item DISGUSTING_JOANDRE_PHONE = registerItem("disgusting_joandre_phone", Item::new, new Item.Settings());

    public static final Item JOANDRE_PHONE = registerItem("joandre_phone", JoandrePhone::new, new Item.Settings()
            .maxCount(1)
    );
    public static final Item JOANDREITE_INGOT = registerItem("joandreite_ingot", Item::new, new Item.Settings());

    public static final Item EMPTY_YOGURT = registerItem("empty_cup_of_yogurt", Item::new, new Item.Settings());
    public static final Item STRAWBERRY_YOGURT = registerItem("strawberry_yogurt", StrawberryYogurt::new, new Item.Settings().food(ModFoodComponents.STRAWBERRY_YOGURT));
    public static final Item VANILLA_YOGURT = registerItem("vanilla_yogurt", VanillaYogurt::new, new Item.Settings().food(ModFoodComponents.VANILLA_YOGURT));

    public static final Item BLUEBERRIES = registerItem("blueberries", VanillaYogurt::new, new Item.Settings().food(ModFoodComponents.BLUEBERRIES));



}
