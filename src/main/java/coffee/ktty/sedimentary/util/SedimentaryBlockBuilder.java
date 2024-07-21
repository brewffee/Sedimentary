package coffee.ktty.sedimentary.util;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static coffee.ktty.sedimentary.util.Shorthand.id;

public final class SedimentaryBlockBuilder {
    private final Block block;
    private String path = "";

    private @NotNull SedimentaryDropType lootType = SedimentaryDropType.NOTHING;
    private Item loot;
    private int lootAmount = 1;
    private boolean silkTouchOnly = false;

    private SedimentaryBlockBuilder.SedimentaryModelType modelType = SedimentaryModelType.CUBE_ALL;
    private List<TagKey<Block>> tags = List.of();
    private List<SedimentaryAttribute> attrs = List.of();

    public SedimentaryBlockBuilder(@NotNull Block block) {
        this.block = block;
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


    @Contract(value = "_ -> this", mutates = "this")
    public SedimentaryBlockBuilder path(@NotNull String path) {
        this.path = path;

        return this;
    }

    @Contract(mutates = "this")
    public SedimentaryBlockBuilder customDrop(Item item, int amount) {
        this.loot = item;
        this.lootAmount = amount;

        this.lootType = SedimentaryDropType.DEFINED;

        return this;
    }

    @Contract("_ -> this")
    public SedimentaryBlockBuilder drops(@NotNull SedimentaryDropType dropType) {
        if (dropType == SedimentaryDropType.SILK_TOUCH_ONLY) this.silkTouchOnly = true;

        this.lootType = dropType;
        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public SedimentaryBlockBuilder model(@NotNull SedimentaryModelType modelType) {
        this.modelType = modelType;

        return this;
    }

    @SafeVarargs
    @Contract(value = "_ -> this", mutates = "this")
    public final SedimentaryBlockBuilder tags(@NotNull TagKey<Block>... blockTags) {
        this.tags = Arrays.stream(blockTags).toList();

        return this;
    }

    @Contract(value = "_ -> this", mutates = "this")
    public SedimentaryBlockBuilder attributes(@NotNull SedimentaryAttribute... attrs) {
        this.attrs = Arrays.stream(attrs).toList();

        return this;
    }

    @Contract(pure = true)
    public Block finish() {
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
