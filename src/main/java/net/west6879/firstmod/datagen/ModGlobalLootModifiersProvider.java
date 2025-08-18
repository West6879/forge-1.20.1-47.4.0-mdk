package net.west6879.firstmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.west6879.firstmod.FirstMod;
import net.west6879.firstmod.item.ModItems;
import net.west6879.firstmod.loot.AddItemModifier;
import net.west6879.firstmod.loot.AddSusSandItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, FirstMod.MODID);
    }

    @Override
    protected void start() {
        add("pine_cone_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.PINE_CONE.get()));

        add("pine_cone_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.tryParse("entities/creeper")).build()},
                ModItems.PINE_CONE.get()));

        add("metal_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.tryParse("chests/jungle_temple")).build()},
                ModItems.METAL_DETECTOR.get()));

        add("metal_detector_from_suspicious_sand", new AddSusSandItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.tryParse("archaeology/desert_pyramid")).build()},
                ModItems.METAL_DETECTOR.get()));
    }
}
