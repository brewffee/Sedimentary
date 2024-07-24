package coffee.ktty.sedimentary.util;

import org.jetbrains.annotations.Contract;

public class Translation {
    public final String key;
    public final String name;

    @Contract(pure = true)
    public Translation(String key, String name) {
        this.key = key;
        this.name = name;
    }
}
