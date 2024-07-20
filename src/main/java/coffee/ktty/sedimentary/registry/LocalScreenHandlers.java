package coffee.ktty.sedimentary.registry;


import coffee.ktty.sedimentary.screen.GrinderScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.NotNull;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;
import static coffee.ktty.sedimentary.util.Shorthand.id;

/**
 * A class responsible for registering custom screen handlers
 */
public class LocalScreenHandlers {
    public static final ScreenHandlerType<GrinderScreenHandler> GRINDER;

    static {
        GRINDER = register(GrinderScreenHandler::new, "grinder");
    }

    /**
     * Registers a new screen.
     *
     * @param factory the handler to register
     * @param name the name of the screen handler
     */
    public static <T extends ScreenHandler> ScreenHandlerType<T> register(ScreenHandlerRegistry.SimpleClientHandlerFactory<T> factory, @NotNull String name) {
        return ScreenHandlerRegistry.registerSimple(id(name), factory);
    }

    /**
     * Initializes the screen handler registry
     */
    public static void initialize() {
        LOGGER.info("[ScreenHandlerRegistry] Registering screen handlers...");
    }
}
