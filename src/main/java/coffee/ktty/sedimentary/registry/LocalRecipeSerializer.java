package coffee.ktty.sedimentary.registry;


import coffee.ktty.sedimentary.recipe.GrinderRecipe;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;
import static coffee.ktty.sedimentary.util.Shorthand.id;

/**
 * A class responsible for registering recipe serializers
 */
public class LocalRecipeSerializer {

    public static final RecipeSerializer<GrinderRecipe> GRINDING;

    static {
        GRINDING = registerCookingSerializer(GrinderRecipe::new, "grinder");
    }

    /**
     * Registers a new cooking recipe serializer
     *
     * @param factory the new serializer
     * @param name its name
     */
    @Contract("_, _ -> !null")
    public static <T extends AbstractCookingRecipe> CookingRecipeSerializer<T> registerCookingSerializer(CookingRecipeSerializer.RecipeFactory<T> factory, @NotNull String name) {
        return Registry.register(Registries.RECIPE_SERIALIZER, id(name), new CookingRecipeSerializer<>(factory, 200));
    }

    /**
     * Initializes the recipe serializer registry
     */
    public static void initialize() {
        LOGGER.info("[RecipeSerializerRegistry] Registering recipe serializer...");
    }
}
