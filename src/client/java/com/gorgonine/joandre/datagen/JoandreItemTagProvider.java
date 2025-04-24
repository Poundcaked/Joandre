package com.gorgonine.joandre.datagen;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class JoandreItemTagProvider extends FabricTagProvider<Item> {
    public JoandreItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    public static final TagKey<Item> SMELLY_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Joandre.MOD_ID, "smelly_items"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(SMELLY_ITEMS)
                .add(Items.SLIME_BALL)
                .add(Items.ROTTEN_FLESH)
                .add(ModItems.DISGUSTING_JOANDRE_PHONE)
                .addOptionalTag(ItemTags.DIRT)
                .setReplace(true);
    }
}
