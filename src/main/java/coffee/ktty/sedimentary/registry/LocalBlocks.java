package coffee.ktty.sedimentary.registry;

import coffee.ktty.sedimentary.blocks.GrinderBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
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

    // Special blocks (Workstations and others)
    public static final Block GRINDER;

    static {
        GRINDER = register(new GrinderBlock(create().strength(4.0f).requiresTool().luminance(inLitState(13))), "grinder");
    }

    // Level 4 blocks (Bricks)
    public static final Block GILDED_POLISHED_BLACKSTONE_BRICKS;

    static {
        GILDED_POLISHED_BLACKSTONE_BRICKS = register(new Block(copyFrom(Blocks.POLISHED_BLACKSTONE_BRICKS)), "gilded_polished_blackstone_bricks");
    }

    // Level 3 blocks (Bricks and stones)
    public static final Block ANCIENT_BRICKS;
    public static final Block CALCITE_BRICKS;
    public static final Block CRACKED_GILDED_POLISHED_BLACKSTONE_BRICKS;
    public static final Block CRACKED_MOSSY_STONE_BRICKS;
    public static final Block DARK_PRISMARINE_BRICKS;
    public static final Block DRIPSTONE_BRICKS;
    public static final Block GLAZED_TERRACOTTA;
    public static final Block MAGMA_BRICKS;
    public static final Block NETHER_LANTERN;
    public static final Block WARPED_NETHER_BRICKS;

    static {
        ANCIENT_BRICKS = registerFireproof(new Block(copyFrom(Blocks.ANCIENT_DEBRIS)), "ancient_bricks");
        CALCITE_BRICKS = register(new Block(copyFrom(Blocks.CALCITE)), "calcite_bricks");
        CRACKED_GILDED_POLISHED_BLACKSTONE_BRICKS = register(new Block(copyFrom(Blocks.POLISHED_BLACKSTONE_BRICKS)), "cracked_gilded_polished_blackstone_bricks");
        CRACKED_MOSSY_STONE_BRICKS = register(new Block(copyFrom(Blocks.MOSSY_STONE_BRICKS)), "cracked_mossy_stone_bricks");
        DARK_PRISMARINE_BRICKS = register(new Block(copyFrom(Blocks.PRISMARINE_BRICKS)), "dark_prismarine_bricks");
        DRIPSTONE_BRICKS = register(new Block(copyFrom(Blocks.DRIPSTONE_BLOCK)), "dripstone_bricks");
        GLAZED_TERRACOTTA = register(new GlazedTerracottaBlock(copyFrom(Blocks.BLACK_GLAZED_TERRACOTTA)), "glazed_terracotta");
        MAGMA_BRICKS = register(new MagmaBlock(copyFrom(Blocks.MAGMA_BLOCK)), "magma_bricks");
        NETHER_LANTERN = register(new Block(copyFrom(Blocks.SEA_LANTERN)), "nether_lantern");
        WARPED_NETHER_BRICKS = register(new Block(copyFrom(Blocks.RED_NETHER_BRICKS)), "warped_nether_bricks");
    }

    // Level 2 blocks (Weak/cobbled stones and glasses)
    public static final Block SOUL_STONE;
    public static final Block SOUL_GLASS;

    static {
        SOUL_STONE = register(new Block(copyFrom(Blocks.NETHER_BRICKS)), "soul_stone");
        SOUL_GLASS = register(new TintedGlassBlock(copyFrom(Blocks.TINTED_GLASS)), "soul_glass");
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
    @SuppressWarnings("SameParameterValue") // Until another fireproof block is registered :P
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
