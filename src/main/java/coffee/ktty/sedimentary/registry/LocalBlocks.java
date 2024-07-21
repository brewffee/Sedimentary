package coffee.ktty.sedimentary.registry;

import coffee.ktty.sedimentary.blocks.GrinderBlock;
import coffee.ktty.sedimentary.util.SedimentaryBlockBuilder;
import net.minecraft.block.*;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;

import java.util.ArrayList;
import java.util.List;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;
import static coffee.ktty.sedimentary.util.SedimentaryBlockBuilder.SedimentaryAttribute.*;
import static coffee.ktty.sedimentary.util.SedimentaryBlockBuilder.SedimentaryDropType.*;
import static coffee.ktty.sedimentary.util.SedimentaryBlockBuilder.SedimentaryModelType.*;
import static coffee.ktty.sedimentary.util.Shorthand.*;

/**
 * A class responsible for registering blocks and their settings.
 * Blocks can be accessed again from this class if needed
 */
public class LocalBlocks {
    public static final List<SedimentaryBlockBuilder> blocks = new ArrayList<>();

    // Special blocks (Workstations and others)
    public static final Block GRINDER;

    static {
        GRINDER = new SedimentaryBlockBuilder(new GrinderBlock(create().strength(4.0f).requiresTool().luminance(inLitState(13)))).path("grinder")
                .drops(SELF).model(COOKER).tags(BlockTags.PICKAXE_MINEABLE).finish();
    }

    // Level 4 blocks (Bricks)
    public static final Block GILDED_POLISHED_BLACKSTONE_BRICKS;

    static {
        GILDED_POLISHED_BLACKSTONE_BRICKS = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.POLISHED_BLACKSTONE_BRICKS))).path("gilded_polished_blackstone_bricks")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).finish();
    }

    // Level 3 blocks (Bricks and stones)
    public static final Block ANCIENT_BRICKS;
    public static final Block CALCITE_BRICKS;
    public static final Block CRACKED_GILDED_POLISHED_BLACKSTONE_BRICKS;
    public static final Block CRACKED_MOSSY_STONE_BRICKS;
    public static final Block DARK_PRISMARINE_BRICKS;
    public static final Block DRIPSTONE_BRICKS;
    public static final Block MAGMA_BRICKS;
    public static final Block NETHER_LANTERN;
    public static final Block WARPED_NETHER_BRICKS;

    static {

        ANCIENT_BRICKS = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.ANCIENT_DEBRIS))).path("ancient_bricks")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).attributes(FIREPROOF).finish();

        CALCITE_BRICKS = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.CALCITE))).path("calcite_bricks")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).finish();

        CRACKED_GILDED_POLISHED_BLACKSTONE_BRICKS = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.POLISHED_BLACKSTONE_BRICKS))).path("cracked_gilded_polished_blackstone_bricks")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).finish();

        CRACKED_MOSSY_STONE_BRICKS = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.MOSSY_STONE_BRICKS))).path("cracked_mossy_stone_bricks")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).finish();

        DARK_PRISMARINE_BRICKS = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.PRISMARINE_BRICKS))).path("dark_prismarine_bricks")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).finish();

        DRIPSTONE_BRICKS = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.DRIPSTONE_BLOCK))).path("dripstone_bricks")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).finish();

        MAGMA_BRICKS = new SedimentaryBlockBuilder(new MagmaBlock(copyFrom(Blocks.MAGMA_BLOCK))).path("magma_bricks")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).finish();

        NETHER_LANTERN = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.SEA_LANTERN))).path("nether_lantern")
                .customDrop(Items.GLOWSTONE_DUST, 4).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).finish();

        WARPED_NETHER_BRICKS = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.RED_NETHER_BRICKS))).path("warped_nether_bricks")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE).finish();
    }

    // Level 2 blocks (Weak/cobbled stones and glasses)
    public static final Block GLAZED_TERRACOTTA;
    public static final Block SOUL_STONE;
    public static final Block SOUL_GLASS;

    static {
        GLAZED_TERRACOTTA = new SedimentaryBlockBuilder(new GlazedTerracottaBlock(copyFrom(Blocks.RED_GLAZED_TERRACOTTA))).path("glazed_terracotta")
                .drops(SELF).model(TERRACOTTA).tags(BlockTags.PICKAXE_MINEABLE).finish();

        SOUL_STONE = new SedimentaryBlockBuilder(new Block(copyFrom(Blocks.NETHER_BRICKS))).path("soul_stone")
                .drops(SELF).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE, BlockTags.SOUL_SPEED_BLOCKS, BlockTags.WITHER_SUMMON_BASE_BLOCKS).finish();

        SOUL_GLASS = new SedimentaryBlockBuilder(new TintedGlassBlock(copyFrom(Blocks.TINTED_GLASS))).path("soul_glass")
                .drops(NOTHING).model(CUBE_ALL).tags(BlockTags.PICKAXE_MINEABLE, BlockTags.SOUL_SPEED_BLOCKS, BlockTags.WITHER_SUMMON_BASE_BLOCKS).finish();
    }

    /**
     * Initializes the block registry
     */
    public static void initialize() {
        LOGGER.info("[BlockRegistry] Registering blocks...");
    }
}
