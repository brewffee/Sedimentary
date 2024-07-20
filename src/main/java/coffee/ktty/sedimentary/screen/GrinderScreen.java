package coffee.ktty.sedimentary.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class GrinderScreen extends AbstractFurnaceScreen<GrinderScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("textures/gui/container/smoker.png");

    public GrinderScreen(GrinderScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, new GrinderRecipeBookScreen(), inventory, title, TEXTURE);
    }
}
