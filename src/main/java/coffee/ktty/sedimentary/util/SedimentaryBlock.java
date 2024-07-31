package coffee.ktty.sedimentary.util;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static coffee.ktty.sedimentary.util.Shorthand.*;

/**
 * A builder for quickly registering blocks
 */
public class SedimentaryBlock {
    private final Class<? extends Block> blockClass;
    private final AbstractBlock.Settings settings;
    private final String path;
    private final String translatedName;

    private @NotNull SedimentaryDropType lootType = SedimentaryDropType.NOTHING;
    private Block block;
    private Item loot;
    private int lootAmount = 1;
    private boolean silkTouchOnly = false;
    private MapColor mapColor;
    private float strength = 0;

    private SedimentaryModelType modelType = SedimentaryModelType.CUBE_ALL;
    private List<TagKey<Block>> tags = List.of();
    private List<SedimentaryAttribute> attrs = List.of();

    /**
     * Creates a new instance of the builder
     *
     * @param path the block's id
     * @param parent the block to copy settings from
     */
    public SedimentaryBlock(@NotNull String path, Block parent) {
        this.blockClass = Block.class;
        this.settings = copyFrom(parent);
        this.path = path;
        this.translatedName = makeTranslation(path);
    }

    /**
     * Creates a new instance of the builder using a custom block class
     *
     * @param path the block's id
     * @param blockClass the class of the block, must extend {@link Block}
     * @param parent the block to copy settings from
     */
    public <T extends Block> SedimentaryBlock(@NotNull String path, @NotNull Class<T>  blockClass, Block parent) {
        this.blockClass = blockClass;
        this.settings = copyFrom(parent);
        this.path = path;
        this.translatedName = makeTranslation(path);
    }

    /**
     * Creates a new instance of the builder with custom settings
     *
     * @param path the block's id
     * @param blockClass the class of the block, must extend {@link Block}
     * @param settings the settings object
     */
    public <T extends Block> SedimentaryBlock(@NotNull String path, @NotNull Class<T> blockClass, AbstractBlock.Settings settings) {
        this.blockClass = blockClass;
        this.settings = settings;
        this.path = path;
        this.translatedName = makeTranslation(path);
    }

    /**
     * Creates a new instance of the builder with custom settings
     *
     * @param path the block's id
     * @param blockClass the class of the block, must extend {@link Block}
     * @param settings the settings object
     */
    public <T extends Block> SedimentaryBlock(String translatedName, @NotNull String path, @NotNull Class<T> blockClass, AbstractBlock.Settings settings) {
        this.blockClass = blockClass;
        this.settings = settings;
        this.path = path;
        this.translatedName = translatedName;
    }

    private static @NotNull <T extends Block> Constructor<T> getBlockConstructor(@NotNull Class<T> blockClass) {
        Constructor<T> constructor;
        try {
            constructor = blockClass.getConstructor(AbstractBlock.Settings.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return constructor;
    }

    private static <T extends Block> T newBlock(@NotNull Class<T> blockClass, AbstractBlock.Settings settings) {
        Constructor<T> constructor = getBlockConstructor(blockClass);

        T newBlock;
        try {
            newBlock = constructor.newInstance(settings);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return newBlock;
    }

    @Contract(pure = true)
    public Block getBlock() { return block; }

    @Contract(pure = true)
    public String getPath() { return path; }

    @Contract(pure = true)
    public Item getLoot() { return loot; }

    @Contract(pure = true)
    public int getLootAmount() { return lootAmount; }

    @Contract(pure = true)
    public boolean isSilkTouchOnly() { return silkTouchOnly; }

    @Contract(pure = true)
    public SedimentaryModelType getModelType() { return modelType; }

    @Contract(pure = true)
    public List<TagKey<Block>> getTags() { return tags; }

    @Contract(pure = true)
    public String getTranslated() { return translatedName; }

    /**
     * Sets a custom loot drop for this block
     *
     * @param item the item to drop
     * @param amount the amount to drop
     */
    @Contract(mutates = "this")
    public SedimentaryBlock customDrop(Item item, int amount) {
        this.loot = item;
        this.lootAmount = amount;

        this.lootType = SedimentaryDropType.DEFINED;

        return this;
    }

    /**
     * Sets the drop type for this block
     *
     * @param dropType  The type of drop to set. Can be NOTHING, SELF, or SILK_TOUCH_ONLY.
     *                  Do not set this as DEFINED !!!!!
     */
    @Contract("_ -> this")
    public SedimentaryBlock drops(@NotNull SedimentaryDropType dropType) {
        if (dropType == SedimentaryDropType.SILK_TOUCH_ONLY) this.silkTouchOnly = true;

        this.lootType = dropType;
        return this;
    }

    /**
     * Sets the model type for this block
     *
     * @param modelType The type of drop to set. Currently, accepts CUBE_ALL, COOKER, and TERRACOTTA
     *
     */
    @Contract(value = "_ -> this", mutates = "this")
    public SedimentaryBlock model(@NotNull SedimentaryModelType modelType) {
        this.modelType = modelType;

        return this;
    }

    /**
     * Sets block tags
     *
     * @param blockTags the tags to use
     */
    @SafeVarargs
    @Contract(value = "_ -> this", mutates = "this")
    public final SedimentaryBlock tags(@NotNull TagKey<Block>... blockTags) {
        this.tags = Arrays.stream(blockTags).toList();

        return this;
    }

    /**
     * Sets custom attributes for the block
     *
     * @param attrs The desired block attributes. Currently only accepts FIREPROOF
     */
    @Contract(value = "_ -> this", mutates = "this")
    public SedimentaryBlock attributes(@NotNull SedimentaryAttribute... attrs) {
        this.attrs = Arrays.stream(attrs).toList();

        return this;
    }

    /**
     * Sets the map color for this block
     *
     * @param color The color to appear on the map
     *
     */
    @Contract(value = "_ -> this", mutates = "this")
    public SedimentaryBlock mapColor(@NotNull MapColor color) {
        this.mapColor = color;
        return this;
    }

    /**
     * Sets the map color for this block using a dye color
     *
     * @param color The color to appear on the map
     *
     */
    @Contract(value = "_ -> this", mutates = "this")
    public SedimentaryBlock mapColor(@NotNull DyeColor color) {
        this.mapColor = color.getMapColor();
        return this;
    }

    /**
     * Sets the strength of this block
     *
     * @param value the strength of the block
     *
     */
    @Contract(value = "_ -> this", mutates = "this")
    public SedimentaryBlock strength(float value) {
        this.strength = 0;
        return this;
    }

    /**
     * Finishes the build process and registers the block in Minecraft to be used by SedimentaryDataGenerator
     *
     */
    @Contract(pure = true)
    public Block finish() {
        // Add default Minecraft block settings
        if (this.mapColor != null) this.settings.mapColor(this.mapColor);
        if (this.strength != 0) this.settings.strength(this.strength);

        // Create the block
        this.block = newBlock(this.blockClass, this.settings);

        LocalBlocks.blocks.add(this); // This new object will be accessed later by another function

        // Register the block with Minecraft
        Registry.register(Registries.BLOCK, id(path), block);

        // Register the block item
        FabricItemSettings itemSettings;
        if (this.attrs.contains(SedimentaryAttribute.FIREPROOF)) {
            itemSettings =  new FabricItemSettings().fireproof();
        } else {
            itemSettings =  new FabricItemSettings();
        }

        Registry.register(Registries.ITEM, id(path), new BlockItem(this.block, itemSettings));

        // Set the loot drop
        this.loot = switch (this.lootType) {
            case SELF, SILK_TOUCH_ONLY -> this.block.asItem();
            case DEFINED -> this.loot;
            case NOTHING -> null;
        };

        return this.block; // :)
    }

    public enum SedimentaryDropType {
        NOTHING,
        SELF,
        SILK_TOUCH_ONLY,
        DEFINED
    }

    public enum SedimentaryModelType {
        CUBE_ALL,
        COOKER,
        TERRACOTTA // probably too specific, but that's our current use case
    }

    public enum SedimentaryAttribute {
        FIREPROOF
    }
}
