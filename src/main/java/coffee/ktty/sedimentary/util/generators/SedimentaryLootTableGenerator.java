package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;

/**
 * Quickly generates loot tables for blocks
 */
public class SedimentaryLootTableGenerator extends FabricBlockLootTableProvider {
    public SedimentaryLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    /**
     * Drops the block itself
     *
     * @param block self-explanatory
     */
    public void dropsSelf(Block block) {
        addDrop(block);
    }

    /**
     * Drops an item instead of the block itself
     *
     * @param block the block to drop from
     * @param drop the item to drop
     * @param quantity how much of the item
     */
    public void dropsMany(Block block, Item drop, float quantity) {
        addDrop(block, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(drop)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(quantity))))));
    }

    /**
     * Generates the loot table.
     */
    @Override
    public void generate() {
        dropsSelf(LocalBlocks.GRINDER);
    }
}