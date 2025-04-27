package com.gorgonine.joandre.util;

import com.gorgonine.joandre.Joandre;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> YOGURT_STAINS = createTag("yogurt_stains");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Joandre.MOD_ID,name));
        }
    }

    public static class Items{
        public static final TagKey<Item> PISRATIUM_REPAIRABLE = createTag("pisratium_repairable");
        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Joandre.MOD_ID,name));
        }
    }
}
