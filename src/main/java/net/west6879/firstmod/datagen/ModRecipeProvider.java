package net.west6879.firstmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.west6879.firstmod.FirstMod;
import net.west6879.firstmod.block.ModBlocks;
import net.west6879.firstmod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
            ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
            ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModBlocks.END_STONE_SAPPHIRE_ORE.get());
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY.get(),
            ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");

        blockBuilder(ModBlocks.SAPPHIRE_BLOCK.get(), ModItems.SAPPHIRE.get(), 3, true, pWriter);
        blockBuilder(ModBlocks.RAW_SAPPHIRE_BLOCK.get(), ModItems.RAW_SAPPHIRE.get(), 3, true, pWriter);
        blockBuilder(ModBlocks.RUBY_BLOCK.get(), ModItems.RUBY.get(), 3, true, pWriter);

        swordBuilder(ModItems.SAPPHIRE_SWORD.get(), ModItems.SAPPHIRE.get(), pWriter);
        pickaxeBuilder(ModItems.SAPPHIRE_PICKAXE.get(), ModItems.SAPPHIRE.get(), pWriter);
        axeBuilder(ModItems.SAPPHIRE_AXE.get(), ModItems.SAPPHIRE.get(), pWriter);
        shovelBuilder(ModItems.SAPPHIRE_SHOVEL.get(), ModItems.SAPPHIRE.get(), pWriter);
        hoeBuilder(ModItems.SAPPHIRE_HOE.get(), ModItems.SAPPHIRE.get(), pWriter);
        swordBuilder(ModItems.RUBY_SWORD.get(), ModItems.RUBY.get(), pWriter);


        armorSetBuilder(ModItems.SAPPHIRE_HELMET.get(), ModItems.SAPPHIRE_CHESTPLATE.get(), ModItems.SAPPHIRE_LEGGINGS.get(),
                ModItems.SAPPHIRE_BOOTS.get(), ModItems.SAPPHIRE.get(), pWriter);
    }

    protected static void swordBuilder(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("S")
                .pattern("S")
                .pattern("I")
                .define('S', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    protected static void pickaxeBuilder(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("SSS")
                .pattern(" I ")
                .pattern(" I ")
                .define('S', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    protected static void axeBuilder(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(result.asItem());
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("SS")
                .pattern("SI")
                .pattern(" I")
                .define('S', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    protected static void shovelBuilder(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("S")
                .pattern("I")
                .pattern("I")
                .define('S', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    protected static void hoeBuilder(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result)
                .pattern("SS")
                .pattern(" I")
                .pattern(" I")
                .define('S', ingredient)
                .define('I', Items.STICK)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    protected static void blockBuilder(ItemLike result, ItemLike ingredient, int size, boolean reverse, Consumer<FinishedRecipe> pWriter) {
        if(size == 3) {
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                    .pattern("SSS")
                    .pattern("SSS")
                    .pattern("SSS")
                    .define('S', ingredient)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pWriter);
        }
        else if(size == 2) {
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, result)
                    .pattern("SS")
                    .pattern("SS")
                    .define('S', ingredient)
                    .unlockedBy(getHasName(ingredient), has(ingredient))
                    .save(pWriter);
        }

        if(reverse == true) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingredient, (size == 3) ? 9 : 4)
                    .requires(result)
                    .unlockedBy(getHasName(result), has(result))
                    .save(pWriter);
        }
    }

    protected static void helmetBuilder(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S S")
                .define('S', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    protected static void chestplateBuilder(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    protected static void leggingsBuilder(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    protected static void bootsBuilder(ItemLike result, ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result)
                .pattern("S S")
                .pattern("S S")
                .define('S', ingredient)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pWriter);
    }

    protected static void armorSetBuilder(ItemLike helmet, ItemLike chestplate, ItemLike leggings, ItemLike boots,
                                          ItemLike ingredient, Consumer<FinishedRecipe> pWriter) {
        helmetBuilder(helmet, ingredient, pWriter);
        chestplateBuilder(chestplate, ingredient, pWriter);
        leggingsBuilder(leggings, ingredient, pWriter);
        bootsBuilder(boots, ingredient, pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer,
                            FirstMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
