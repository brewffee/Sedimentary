package coffee.ktty.sedimentary.client;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import coffee.ktty.sedimentary.registry.LocalScreenHandlers;
import coffee.ktty.sedimentary.screen.GrinderScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;

@Environment(EnvType.CLIENT)
public class SedimentaryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        LOGGER.info("Hello, client!");
        HandledScreens.register(LocalScreenHandlers.GRINDER, GrinderScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(LocalBlocks.SOUL_GLASS, RenderLayer.getTranslucent());
    }
}