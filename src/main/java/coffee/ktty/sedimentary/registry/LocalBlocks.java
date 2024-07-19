package coffee.ktty.sedimentary.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;
import static coffee.ktty.sedimentary.util.Shorthand.*;

/**
 * A class responsible for registering blocks and their settings.
 * Blocks can be accessed again from this class if needed.
 */
public final class LocalBlocks {
    /**
     * Registers a new block.
     *
     * @param block the block to register
     * @param path the block's name
     * @return the original {@link Block} object
     */
    private static @NotNull Block register(Block block, String path) {
        FabricItemSettings itemSettings = new FabricItemSettings();
        return register(block, path, itemSettings);
    }

    /**
     * Registers a fireproof block (the block's dropped BlockItem will not be affected by lava or fire)
     *
     * @param block the block to register
     * @param path the block's name
     * @return the original {@link Block} object
     */
    private static @NotNull Block registerFireproof(Block block, String path) {
        FabricItemSettings itemSettings = new FabricItemSettings().fireproof();
        return register(block, path, itemSettings);
    }

    /**
     * Registers a block with custom BlockItem settings.
     *
     * @param block the block to register
     * @param path the block's name
     * @param itemSettings the settings for the item associated with the block
     * @return the original {@link Block} object
     */
    @Contract("_, _, _ -> param1")
    private static @NotNull Block register(@NotNull Block block, String path, FabricItemSettings itemSettings) {
        LOGGER.info("[BlockRegistry] Registering {}", block.getName().getString());
        Registry.register(Registries.BLOCK, id(path), block);
        Registry.register(Registries.ITEM, id(path), new BlockItem(block, itemSettings));

        return block;
    }

    /**
     * Initializes the new registry.
     */
    public static void initialize() {
        LOGGER.info("[BlockRegistry] Registering blocks...");
    }
}
