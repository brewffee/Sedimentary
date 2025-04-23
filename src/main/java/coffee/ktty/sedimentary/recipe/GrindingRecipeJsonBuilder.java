package coffee.ktty.sedimentary.recipe;

import coffee.ktty.sedimentary.registry.LocalRecipeSerializer;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;

public class GrindingRecipeJsonBuilder extends CookingRecipeJsonBuilder {
    public GrindingRecipeJsonBuilder(RecipeCategory category, CookingRecipeCategory cookingCategory, ItemConvertible output, Ingredient input, float experience, int cookingTime, RecipeSerializer<? extends AbstractCookingRecipe> serializer) {
        super(category, cookingCategory, output, input, experience, cookingTime, serializer);
    }

    public static CookingRecipeCategory getCategory(RecipeSerializer<? extends AbstractCookingRecipe> serializer, ItemConvertible output) {
        if (serializer == LocalRecipeSerializer.GRINDING) {
            return output.asItem() instanceof BlockItem ? CookingRecipeCategory.BLOCKS : CookingRecipeCategory.MISC;
        }
        throw new IllegalStateException("Unknown recipe serializer");
    }
}
