package coffee.ktty.sedimentary.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ClientModInitializer;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;

@Environment(EnvType.CLIENT)
public class SedimentaryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("Hello, client!");
    }
}