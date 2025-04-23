package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.recipe.GrindingRecipeJsonBuilder;
import coffee.ktty.sedimentary.registry.LocalBlocks;
import coffee.ktty.sedimentary.registry.LocalRecipeSerializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public static void offerShapedCrafting(Consumer<RecipeJsonProvider> exporter, List<String> shape, @NotNull List<ItemConvertible> ingredients, RecipeCategory category, ItemConvertible output) {
        ShapedRecipeJsonBuilder builder = ShapedRecipeJsonBuilder.create(category, output);

        Set<Character> chars = new HashSet<>();
        for (char c: String.join("", shape).toCharArray()) {
            if (!chars.contains(c)) {
                int i = chars.size();

                ItemConvertible ingredient;
                try {
                    ingredient = ingredients.get(i);
                } catch (IndexOutOfBoundsException err) {
                    throw new IllegalArgumentException("Recipe shape does not match the ingredients provided!");
                }

                builder.input(c, ingredient);
                builder.criterion(FabricRecipeProvider.hasItem(ingredient),FabricRecipeProvider.conditionsFromItem(ingredient));
            }
            chars.add(c);
        }

        // :steamhappy:
        for (String line: shape) builder.pattern(line);
        builder.offerTo(exporter);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerGrinding(exporter, List.of(Blocks.STONE, Blocks.CRACKED_STONE_BRICKS), Blocks.COBBLESTONE, 0.1F, 100, "cobblestone");

        offerShapedCrafting(exporter,
          List.of("bbb","bgb","sfs"),
          List.of(Items.IRON_INGOT, Items.GRINDSTONE, Items.SMOOTH_STONE, Items.BLAST_FURNACE),
          RecipeCategory.MISC, LocalBlocks.GRINDER
        );
    }
}