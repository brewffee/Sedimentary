package coffee.ktty.sedimentary.util;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static coffee.ktty.sedimentary.Sedimentary.ID;

/**
 * A utility class providing methods for shortening otherwise ridiculously long lines of code
 */
public final class Shorthand {
    /**
     * Creates an {@link Identifier} (like "namespace:item")
     *
     * @param path the item's path
     * @return a new {@link Identifier}
     */
    @Contract("_ -> new")
    public static @NotNull Identifier id(String path) {
        return new Identifier(ID, path);
    }
}
