package coffee.ktty.sedimentary.registry;

import coffee.ktty.sedimentary.blocks.GrinderBlock;
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
 * Blocks can be accessed again from this class if needed
 */
public class LocalBlocks {

    // Special blocks
    public static final Block GRINDER;

    static {
        GRINDER = register(new GrinderBlock(create().strength(4.0f).requiresTool().luminance(inLitState(13))), "grinder");
    }

    /**
     * Registers a new block
     *
     * @param block the block to register
     * @param path the block's name
     * @return the original {@link Block} object
     */
    private static @NotNull Block register(Block block, String path) {
        BlockItem blockItem = new BlockItem(block, new FabricItemSettings());
        return register(block, path, blockItem);
    }

    /**
     * Registers a fireproof block (the block's dropped BlockItem will not be affected by lava or fire)
     *
     * @param block the block to register
     * @param path the block's name
     * @return the original {@link Block} object
     */
    private static @NotNull Block registerFireproof(Block block, String path) {
        BlockItem blockItem = new BlockItem(block, new FabricItemSettings().fireproof());
        return register(block, path, blockItem);
    }
    /**
     * Registers a block with custom BlockItem settings
     *
     * @param block the block to register
     * @param path the block's name
     * @param blockItem the block's associated block item
     * @return the original {@link Block} object
     */
    @Contract("_, _, _ -> param1")
    private static @NotNull Block register(Block block, String path, BlockItem blockItem) {
        Registry.register(Registries.BLOCK, id(path), block);
        Registry.register(Registries.ITEM, id(path), blockItem);

        return block;
    }

    /**
     * Initializes the block registry
     */
    public static void initialize() {
        LOGGER.info("[BlockRegistry] Registering blocks...");
    }
}
