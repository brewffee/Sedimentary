package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;
import org.jetbrains.annotations.NotNull;

public class SedimentaryModelGenerator extends FabricModelProvider {
    public SedimentaryModelGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateBlockStateModels(@NotNull BlockStateModelGenerator gen) {
        gen.registerCooker(LocalBlocks.GRINDER, TexturedModel.ORIENTABLE);

        gen.registerSimpleCubeAll(LocalBlocks.GILDED_POLISHED_BLACKSTONE_BRICKS);

        gen.registerSimpleCubeAll(LocalBlocks.ANCIENT_BRICKS);
        gen.registerSimpleCubeAll(LocalBlocks.CALCITE_BRICKS);
        gen.registerSimpleCubeAll(LocalBlocks.CRACKED_GILDED_POLISHED_BLACKSTONE_BRICKS);
        gen.registerSimpleCubeAll(LocalBlocks.CRACKED_MOSSY_STONE_BRICKS);
        gen.registerSimpleCubeAll(LocalBlocks.DARK_PRISMARINE_BRICKS);
        gen.registerSimpleCubeAll(LocalBlocks.DRIPSTONE_BRICKS);
        gen.registerNorthDefaultHorizontalRotated(LocalBlocks.GLAZED_TERRACOTTA, TexturedModel.TEMPLATE_GLAZED_TERRACOTTA);
        gen.registerSimpleCubeAll(LocalBlocks.MAGMA_BRICKS);
        gen.registerSimpleCubeAll(LocalBlocks.NETHER_LANTERN);
        gen.registerSimpleCubeAll(LocalBlocks.WARPED_NETHER_BRICKS);

        gen.registerSimpleCubeAll(LocalBlocks.SOUL_GLASS);

        gen.registerSimpleCubeAll(LocalBlocks.SOUL_STONE);
    }

    @Override
    public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) { }
}