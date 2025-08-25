package net.west6879.firstmod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.west6879.firstmod.FirstMod;
import net.west6879.firstmod.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 12f, 4f, 25,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            ResourceLocation.tryBuild(FirstMod.MODID, "sapphire"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier RUBY = TierSortingRegistry.registerTier(
            new ForgeTier(6, 2500, 15f, 10f, 40,
                    ModTags.Blocks.NEEDS_RUBY_TOOL, () -> Ingredient.of(ModItems.RUBY.get())),
            ResourceLocation.tryBuild(FirstMod.MODID, "ruby"), List.of(ModToolTiers.SAPPHIRE), List.of());

}
