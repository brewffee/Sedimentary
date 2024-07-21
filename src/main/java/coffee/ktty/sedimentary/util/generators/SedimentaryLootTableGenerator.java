package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import coffee.ktty.sedimentary.util.SedimentaryBlock;
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

    public void createDrop(Block block, Item drop, float quantity, boolean silkTouchOnly) {
        if (silkTouchOnly) {
            addDrop(block, LootTable.builder()
                    .pool(LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1.0F)).conditionally(WITH_SILK_TOUCH)
                            .with(ItemEntry.builder(drop)
                                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(quantity))))));
        } else {
            addDrop(block, LootTable.builder()
                    .pool(LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1.0F))
                            .with(ItemEntry.builder(drop)
                                    .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(quantity))))));
        }
    }

    /**
     * Generates the loot table.
     */
    @Override
    public void generate() {
        for (SedimentaryBlock builder: LocalBlocks.blocks) {
            if (builder.getLoot() != null) createDrop(builder.getBlock(), builder.getLoot(), builder.getLootAmount(), builder.isSilkTouchOnly());
        }
    }
}