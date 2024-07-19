package coffee.ktty.sedimentary;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Sedimentary implements ModInitializer {
    public static final String NAME = "Sedimentary";
    public static final String ID = NAME.toLowerCase();

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello!");
    }
}
