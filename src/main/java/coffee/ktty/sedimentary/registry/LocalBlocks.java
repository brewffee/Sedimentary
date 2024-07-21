package coffee.ktty.sedimentary.registry;

import coffee.ktty.sedimentary.blocks.GrinderBlock;
import coffee.ktty.sedimentary.util.SedimentaryBlock;
import net.minecraft.block.*;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;

import java.util.ArrayList;
import java.util.List;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;
import static coffee.ktty.sedimentary.util.SedimentaryBlock.SedimentaryAttribute.FIREPROOF;
import static coffee.ktty.sedimentary.util.SedimentaryBlock.SedimentaryDropType.NOTHING;
import static coffee.ktty.sedimentary.util.SedimentaryBlock.SedimentaryDropType.SELF;
import static coffee.ktty.sedimentary.util.SedimentaryBlock.SedimentaryModelType.*;
import static net.minecraft.registry.tag.BlockTags.NEEDS_DIAMOND_TOOL;
import static net.minecraft.registry.tag.BlockTags.PICKAXE_MINEABLE;

/**
 * A class responsible for registering blocks and their settings.
 * Blocks can be accessed again from this class if needed
 */
public class LocalBlocks {
    public static final List<SedimentaryBlock> blocks = new ArrayList<>();

    // Special blocks (Workstations and others)
    public static final Block GRINDER;

    static {
        GRINDER = new SedimentaryBlock("grinder", GrinderBlock.class, Blocks.FURNACE).model(COOKER)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

    }

    // Level 4 blocks (Bricks)
    public static final Block GILDED_POLISHED_BLACKSTONE_BRICKS;

    static {
        GILDED_POLISHED_BLACKSTONE_BRICKS = new SedimentaryBlock("gilded_polished_blackstone_bricks", Block.class, Blocks.POLISHED_BLACKSTONE_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();
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
        ANCIENT_BRICKS = new SedimentaryBlock("ancient_bricks", Block.class, Blocks.ANCIENT_DEBRIS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, NEEDS_DIAMOND_TOOL).attributes(FIREPROOF).finish();

        CALCITE_BRICKS = new SedimentaryBlock("calcite_bricks", Block.class, Blocks.CALCITE).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, BlockTags.SCULK_REPLACEABLE).finish();

        CRACKED_GILDED_POLISHED_BLACKSTONE_BRICKS = new SedimentaryBlock("cracked_gilded_polished_blackstone_bricks", Block.class, Blocks.POLISHED_BLACKSTONE_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        CRACKED_MOSSY_STONE_BRICKS = new SedimentaryBlock("cracked_mossy_stone_bricks", Block.class, Blocks.MOSSY_STONE_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        DARK_PRISMARINE_BRICKS = new SedimentaryBlock("dark_prismarine_bricks", Block.class, Blocks.PRISMARINE_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        DRIPSTONE_BRICKS = new SedimentaryBlock("dripstone_bricks", Block.class, Blocks.DRIPSTONE_BLOCK).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, BlockTags.SCULK_REPLACEABLE).finish();

        MAGMA_BRICKS = new SedimentaryBlock("magma_bricks", MagmaBlock.class, Blocks.MAGMA_BLOCK).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, BlockTags.INFINIBURN_OVERWORLD).finish();

        NETHER_LANTERN = new SedimentaryBlock("nether_lantern", Block.class, Blocks.SEA_LANTERN).model(CUBE_ALL)
            .customDrop(Items.GLOWSTONE_DUST, 4).tags(PICKAXE_MINEABLE).finish();

        WARPED_NETHER_BRICKS = new SedimentaryBlock("warped_nether_bricks", Block.class, Blocks.RED_NETHER_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();
    }

    // Level 2 blocks (Weak/cobbled stones and glasses)
    public static final Block COBBLED_ANDESITE;
    public static final Block COBBLED_DIORITE;
    public static final Block COBBLED_GRANITE;
    public static final Block GLAZED_TERRACOTTA;
    public static final Block SOUL_STONE;
    public static final Block SOUL_GLASS;

    static {
        COBBLED_ANDESITE = new SedimentaryBlock("cobbled_andesite", Block.class, Blocks.COBBLESTONE).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        COBBLED_DIORITE = new SedimentaryBlock("cobbled_diorite", Block.class, Blocks.COBBLESTONE).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        COBBLED_GRANITE = new SedimentaryBlock("cobbled_granite", Block.class, Blocks.COBBLESTONE).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        GLAZED_TERRACOTTA = new SedimentaryBlock("glazed_terracotta", GlazedTerracottaBlock.class, Blocks.RED_GLAZED_TERRACOTTA).model(TERRACOTTA)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        SOUL_STONE = new SedimentaryBlock("soul_stone", Block.class, Blocks.NETHER_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, BlockTags.SOUL_SPEED_BLOCKS, BlockTags.SOUL_FIRE_BASE_BLOCKS, BlockTags.WITHER_SUMMON_BASE_BLOCKS).finish();

        SOUL_GLASS = new SedimentaryBlock("soul_glass", TintedGlassBlock.class, Blocks.TINTED_GLASS).model(CUBE_ALL)
            .drops(NOTHING).tags(PICKAXE_MINEABLE, BlockTags.SOUL_SPEED_BLOCKS, BlockTags.SOUL_FIRE_BASE_BLOCKS, BlockTags.WITHER_SUMMON_BASE_BLOCKS).finish();
    }

    /**
     * Initializes the block registry
     */
    public static void initialize() {
        LOGGER.info("[BlockRegistry] Registering blocks...");
    }
}
