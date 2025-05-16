package com.gorgonine.joandre.world;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.item.ModBlocks;
import com.gorgonine.joandre.item.blocks.BlueberryBushBlock;
import com.gorgonine.joandre.item.blocks.StrawberryBushBlock;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> JOANDREITE_ORE_KEY = registerKey("joandreite_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> DEEPSLATE_JOANDREITE_ORE_KEY = registerKey("deepslate_joandreite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH_KEY = registerKey("blueberry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH_KEY = registerKey("strawberry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VANILLA_FLOWER_KEY = registerKey("vanilla_flower");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context){
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldJoandreiteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.JOANDREITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_JOANDREITE_ORE.getDefaultState()));

        register(context, JOANDREITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldJoandreiteOres,3)); //ore vein size

        register(context, BLUEBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(BlueberryBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );

        register(context, STRAWBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
            ConfiguredFeatures.createRandomPatchFeatureConfig(
                Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.STRAWBERRY_BUSH.getDefaultState().with(StrawberryBushBlock.AGE, 3))),
                List.of(Blocks.GRASS_BLOCK)
            )
        );

        register(context, VANILLA_FLOWER_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.VANILLA_FLOWER.getDefaultState())),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Joandre.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
