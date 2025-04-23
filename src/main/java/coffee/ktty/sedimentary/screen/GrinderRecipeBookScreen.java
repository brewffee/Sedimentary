package coffee.ktty.sedimentary.screen;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.client.gui.screen.recipebook.AbstractFurnaceRecipeBookScreen;
import net.minecraft.item.Item;
import net.minecraft.text.Text;

import java.util.Set;

public class GrinderRecipeBookScreen extends AbstractFurnaceRecipeBookScreen {
    private static final Text TOGGLE_GRINDABLE_RECIPES_TEXT = Text.of("Showing Grindable");

    @Override
    protected Text getToggleCraftableButtonText() {
        return TOGGLE_GRINDABLE_RECIPES_TEXT;
    }

    @Override
    protected Set<Item> getAllowedFuels() {
        return AbstractFurnaceBlockEntity.createFuelTimeMap().keySet();
    }
}