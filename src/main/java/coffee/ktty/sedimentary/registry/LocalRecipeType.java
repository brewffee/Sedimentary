package coffee.ktty.sedimentary.registry;


import coffee.ktty.sedimentary.recipe.GrinderRecipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.jetbrains.annotations.Contract;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;
import static coffee.ktty.sedimentary.util.Shorthand.id;

/**
 * A class responsible for registering recipe types
 */
public class LocalRecipeType {

    public static final RecipeType<GrinderRecipe> GRINDING;

    static {
        GRINDING = registerGrindingType(); // It's a little more complicated to register this
    }

    /**
     * Registers the grinder recipe type
     *
     * @return The recipe type
     */
    @Contract(" -> !null")
    public static RecipeType<GrinderRecipe> registerGrindingType() {
        return Registry.register(Registries.RECIPE_TYPE, id("grinder"), new RecipeType<GrinderRecipe>() {
            @Override public String toString() { return "grinder";
            }
        });
    }

    /**
     * Initializes the recipe registry
     */
    public static void initialize() {
        LOGGER.info("[RecipeTypeRegistry] Registering recipe types...");
    }
}
