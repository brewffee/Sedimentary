package coffee.ktty.sedimentary.recipe;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import coffee.ktty.sedimentary.registry.LocalRecipeSerializer;
import coffee.ktty.sedimentary.registry.LocalRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.util.Identifier;

public class GrinderRecipe extends AbstractCookingRecipe {
    public GrinderRecipe(Identifier id, String group, CookingRecipeCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(LocalRecipeType.GRINDING, id, group, category, input, output, experience, cookTime);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(LocalBlocks.GRINDER);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return LocalRecipeSerializer.GRINDING;
    }
}
