package coffee.ktty.sedimentary.util;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static coffee.ktty.sedimentary.Sedimentary.ID;

public final class Shorthand {
    @Contract("_ -> new")
    public static @NotNull Identifier id(String path) {
        return new Identifier(ID, path);
    }
}
