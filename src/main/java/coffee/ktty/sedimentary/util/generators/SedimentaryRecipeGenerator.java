package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.recipe.GrindingRecipeJsonBuilder;
import coffee.ktty.sedimentary.registry.LocalRecipeSerializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class SedimentaryRecipeGenerator extends FabricRecipeProvider {
    public SedimentaryRecipeGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public static void offerGrinding(Consumer<RecipeJsonProvider> exporter, @NotNull List<ItemConvertible> inputs, ItemConvertible output, float experience, int cookingTime, String group) {
        for (ItemConvertible item: inputs) {
            // This is clean enough for now
            CookingRecipeCategory category = GrindingRecipeJsonBuilder.getCategory(LocalRecipeSerializer.GRINDING, output);

            GrindingRecipeJsonBuilder builder = (GrindingRecipeJsonBuilder) new GrindingRecipeJsonBuilder(
                    RecipeCategory.MISC, category, output, Ingredient.ofItems(item), experience, cookingTime, LocalRecipeSerializer.GRINDING
            ).group(group).criterion(RecipeProvider.hasItem(item), RecipeProvider.conditionsFromItem(item));

            builder.offerTo(exporter, RecipeProvider.getItemPath(output) + "_from_grinding_" + RecipeProvider.getItemPath(item));
        }
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerGrinding(exporter, List.of(Blocks.STONE, Blocks.CRACKED_STONE_BRICKS), Blocks.COBBLESTONE, 0.1F, 100, "cobblestone");
    }
}