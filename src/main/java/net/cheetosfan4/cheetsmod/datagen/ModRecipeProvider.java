package net.cheetosfan4.cheetsmod.datagen;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.block.ModBlocks;
import net.cheetosfan4.cheetsmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> CHEESE_GET = List.of(Items.MILK_BUCKET);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GRITTLE.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.cheese.get())
                .unlockedBy("has_cheese", has(ModItems.cheese)).save((recipeOutput));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SANDSTONE.get())
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.PINK_SAND.get())
                .unlockedBy("has_pink_sand", has(ModBlocks.PINK_SAND)).save((recipeOutput));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POOP_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.poop.get())
                .unlockedBy("has_poop", has(ModItems.poop)).save((recipeOutput));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.eggy.get(), 1)
                .requires(ModItems.cheese.get())
                .requires(Items.EGG)
                .unlockedBy("has_cheese", has(ModItems.cheese)).save(recipeOutput);
        //.save(recipeOutput, "cf4mod:eggy_from_crafting_table");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.poop.get(), 9)
                        .requires(ModBlocks.POOP_BLOCK.get())
                        .unlockedBy("has_poop", has(ModItems.poop)).save((recipeOutput));

        oreSmelting(recipeOutput, CHEESE_GET, RecipeCategory.MISC, ModItems.cheese.get(), 0.25f, 200, "cheese");

        stairBuilder(ModBlocks.POOP_STAIRS.get(), Ingredient.of(ModItems.poop)).group("poop")
                .unlockedBy("has_poop", has(ModItems.poop)).save(recipeOutput);
        buttonBuilder(ModBlocks.POOP_BUTTON.get(), Ingredient.of(ModItems.poop)).group("poop")
                .unlockedBy("has_poop", has(ModItems.poop)).save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.POOP_PRESSURE_PLATE.get(), ModItems.poop.get());

        fenceBuilder(ModBlocks.POOP_FENCE.get(), Ingredient.of(ModItems.poop)).group("poop")
                .unlockedBy("has_poop", has(ModItems.poop)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.POOP_FENCE_GATE.get(), Ingredient.of(ModItems.poop)).group("poop")
                .unlockedBy("has_poop", has(ModItems.poop)).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_WALL.get(), ModItems.poop.get());

        doorBuilder(ModBlocks.POOP_DOOR.get(), Ingredient.of(ModItems.poop)).group("poop")
                .unlockedBy("has_poop", has(ModItems.poop)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.POOP_TRAPDOOR.get(), Ingredient.of(ModItems.poop)).group("poop")
                .unlockedBy("has_poop", has(ModItems.poop)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POOP_SLAB.get(), ModItems.poop.get());



    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, CheetsMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

}
