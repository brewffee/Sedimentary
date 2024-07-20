package coffee.ktty.sedimentary.client;

import coffee.ktty.sedimentary.screen.GrinderScreen;
import coffee.ktty.sedimentary.registry.LocalScreenHandlers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;

@Environment(EnvType.CLIENT)
public class SedimentaryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("Hello, client!");
        HandledScreens.register(LocalScreenHandlers.GRINDER, GrinderScreen::new);
    }
}