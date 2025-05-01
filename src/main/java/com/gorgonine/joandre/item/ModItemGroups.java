package com.gorgonine.joandre.item;

import com.gorgonine.joandre.Joandre;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup JOANDRE_ARMORY = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joandre.MOD_ID ,"joandre_armory"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.JOANDRE_PHONE))
                    .displayName(Text.translatable("itemGroup.joandre_armory"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.JOANDRE_PHONE);
                        entries.add(ModItems.DISGUSTING_JOANDRE_PHONE);
                        entries.add(ModItems.GULCH_YOU_AGAIN_MUSIC_DISC);
                        entries.add(ModItems.JOANDREITE_INGOT);
                        entries.add(ModItems.PISRAT_HAMMER);
                        entries.add(ModBlocks.YOGURT_MACHINE);
                    }).build());
    public static final ItemGroup JOANDRE_KITCHEN = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Joandre.MOD_ID ,"joandre_kitchen"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.STRAWBERRY_YOGURT))
                    .displayName(Text.translatable("itemGroup.joandre_kitchen"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.EMPTY_YOGURT);
                        entries.add(ModItems.STRAWBERRY_YOGURT);
                        entries.add(ModItems.VANILLA_YOGURT);;
                        entries.add(ModItems.BLUEBERRY_YOGURT);

                        entries.add(ModItems.BLUEBERRIES);
                        entries.add(ModItems.STRAWBERRIES);
                        entries.add(ModItems.VANILLA_BEANS);

                        entries.add(ModItems.BLUEBERRY_SEEDS);
                        entries.add(ModItems.STRAWBERRY_SEEDS);

                        entries.add(ModItems.EMPTY_YOGURT_BAG);
                        entries.add(ModItems.VANILLA_YOGURT_BAG);
                        entries.add(ModItems.STRAWBERRY_YOGURT_BAG);
                        entries.add(ModItems.BLUEBERRY_YOGURT_BAG);
                    }).build());

    public static void registerItemGroups(){

    }
}
