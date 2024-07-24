package coffee.ktty.sedimentary.registry;

import coffee.ktty.sedimentary.blocks.GrinderBlock;
import coffee.ktty.sedimentary.util.SedimentaryBlock;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;
import static coffee.ktty.sedimentary.util.SedimentaryBlock.SedimentaryAttribute.FIREPROOF;
import static coffee.ktty.sedimentary.util.SedimentaryBlock.SedimentaryDropType.NOTHING;
import static coffee.ktty.sedimentary.util.SedimentaryBlock.SedimentaryDropType.SELF;
import static coffee.ktty.sedimentary.util.SedimentaryBlock.SedimentaryModelType.TERRACOTTA;
import static coffee.ktty.sedimentary.util.SedimentaryBlock.SedimentaryModelType.*;
import static net.minecraft.registry.tag.BlockTags.*;

/**
 * A class responsible for registering blocks and their settings.
 * Blocks can be accessed again from this class if needed
 */
public class LocalBlocks {
    public static final List<SedimentaryBlock> blocks = new ArrayList<>();

    // Special blocks (Workstations and others)
    public static final Block GRINDER;
    public static final Block POWDER_SNOW; // We have to duplicate powder snow to allow stacking

    // Short class for powder snow to override the placing functionality
    public static class CustomPowderSnowBlock extends PowderSnowBlock {
        public CustomPowderSnowBlock(Settings settings) { super(settings); }
        public void onPlaced(@NotNull World w, BlockPos p, BlockState s, LivingEntity e, ItemStack i) {
            w.setBlockState(p, Blocks.POWDER_SNOW.getDefaultState()); // Place minecraft:powder_snow
        }
    }

    static {
        GRINDER = new SedimentaryBlock("grinder", GrinderBlock.class, Blocks.FURNACE).model(COOKER)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        POWDER_SNOW = new SedimentaryBlock("powder_snow", CustomPowderSnowBlock.class, Blocks.POWDER_SNOW).model(CUBE_ALL)
                .drops(NOTHING).tags(INSIDE_STEP_SOUND_BLOCKS, AZALEA_GROWS_ON, AZALEA_ROOT_REPLACEABLE, SNOW).finish();
    }

    // Level 4 blocks (Bricks)
    public static final Block GILDED_POLISHED_BLACKSTONE_BRICKS;

    static {
        GILDED_POLISHED_BLACKSTONE_BRICKS = new SedimentaryBlock("gilded_polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS).model(CUBE_ALL)
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
        ANCIENT_BRICKS = new SedimentaryBlock("ancient_bricks", Blocks.ANCIENT_DEBRIS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, NEEDS_DIAMOND_TOOL).attributes(FIREPROOF).finish();

        CALCITE_BRICKS = new SedimentaryBlock("calcite_bricks", Blocks.CALCITE).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, SCULK_REPLACEABLE).finish();

        CRACKED_GILDED_POLISHED_BLACKSTONE_BRICKS = new SedimentaryBlock("cracked_gilded_polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, GUARDED_BY_PIGLINS).finish();

        CRACKED_MOSSY_STONE_BRICKS = new SedimentaryBlock("cracked_mossy_stone_bricks", Blocks.MOSSY_STONE_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, STONE_BRICKS).finish();

        DARK_PRISMARINE_BRICKS = new SedimentaryBlock("dark_prismarine_bricks", Blocks.PRISMARINE_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        DRIPSTONE_BRICKS = new SedimentaryBlock("dripstone_bricks", Blocks.DRIPSTONE_BLOCK).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, SCULK_REPLACEABLE).finish();

        MAGMA_BRICKS = new SedimentaryBlock("magma_bricks", MagmaBlock.class, Blocks.MAGMA_BLOCK).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, INFINIBURN_OVERWORLD).finish();

        NETHER_LANTERN = new SedimentaryBlock("nether_lantern", Blocks.SEA_LANTERN).model(CUBE_ALL)
            .customDrop(Items.GLOWSTONE_DUST, 4).finish();

        WARPED_NETHER_BRICKS = new SedimentaryBlock("warped_nether_bricks", Blocks.RED_NETHER_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();
    }

    // Level 2 blocks (Weak/cobbled stones and glasses)
    public static final Block COBBLED_ANDESITE;
    public static final Block COBBLED_DIORITE;
    public static final Block COBBLED_GRANITE;
    public static final Block COBBLED_PURPUR;
    public static final Block CRACKED_BRICKS;
    public static final Block GLAZED_TERRACOTTA;
    public static final Block QUARTZ_ROCK;
    public static final Block SOUL_STONE;
    public static final Block SOUL_GLASS;

    static {
        COBBLED_ANDESITE = new SedimentaryBlock("cobbled_andesite", Blocks.COBBLESTONE).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        COBBLED_DIORITE = new SedimentaryBlock("cobbled_diorite", Blocks.COBBLESTONE).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        COBBLED_GRANITE = new SedimentaryBlock("cobbled_granite", Blocks.COBBLESTONE).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        COBBLED_PURPUR = new SedimentaryBlock("cobbled_purpur", Blocks.COBBLESTONE).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        CRACKED_BRICKS = new SedimentaryBlock("cracked_bricks", Blocks.BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        GLAZED_TERRACOTTA = new SedimentaryBlock("glazed_terracotta", GlazedTerracottaBlock.class, Blocks.RED_GLAZED_TERRACOTTA)
                .model(TERRACOTTA).drops(SELF).tags(PICKAXE_MINEABLE).finish();

        QUARTZ_ROCK = new SedimentaryBlock("quartz_rock", Blocks.QUARTZ_BLOCK).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE).finish();

        SOUL_STONE = new SedimentaryBlock("soul_stone", Blocks.NETHER_BRICKS).model(CUBE_ALL)
            .drops(SELF).tags(PICKAXE_MINEABLE, SOUL_SPEED_BLOCKS, SOUL_FIRE_BASE_BLOCKS, WITHER_SUMMON_BASE_BLOCKS).finish();

        SOUL_GLASS = new SedimentaryBlock("soul_glass", TintedGlassBlock.class, Blocks.TINTED_GLASS).model(CUBE_ALL)
            .drops(NOTHING).tags(IMPERMEABLE, SOUL_SPEED_BLOCKS, SOUL_FIRE_BASE_BLOCKS, WITHER_SUMMON_BASE_BLOCKS).finish();
    }

    // Level 1 blocks (Sediments)
    public static final Block CRUSHED_DIORITE;
    public static final Block CRUSHED_GRANITE;

    static {
        CRUSHED_DIORITE = new SedimentaryBlock("crushed_diorite", GravelBlock.class, Blocks.GRAVEL).model(CUBE_ALL)
                .drops(SELF).tags(SHOVEL_MINEABLE).finish();

        CRUSHED_GRANITE = new SedimentaryBlock("crushed_granite", GravelBlock.class, Blocks.GRAVEL).model(CUBE_ALL)
                .drops(SELF).tags(SHOVEL_MINEABLE).finish();
    }

        /**
         * Initializes the block registry
         */
    public static void initialize() {
        LOGGER.info("[BlockRegistry] Registering blocks...");
    }
}
