package coffee.ktty.sedimentary.screen;

import coffee.ktty.sedimentary.registry.LocalRecipeType;
import coffee.ktty.sedimentary.registry.LocalScreenHandlers;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class GrinderScreenHandler extends AbstractFurnaceScreenHandler {
    public GrinderScreenHandler (int syncId, PlayerInventory playerInventory) {
        super(LocalScreenHandlers.GRINDER, LocalRecipeType.GRINDING, RecipeBookCategory.SMOKER, syncId, playerInventory);
    }

    public GrinderScreenHandler (int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(LocalScreenHandlers.GRINDER, LocalRecipeType.GRINDING, RecipeBookCategory.SMOKER, syncId, playerInventory, inventory, propertyDelegate);
    }
}