package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import coffee.ktty.sedimentary.util.SedimentaryBlock;
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
        for (SedimentaryBlock builder: LocalBlocks.blocks) {
            switch (builder.getModelType()) {
                case COOKER -> gen.registerCooker(builder.getBlock(), TexturedModel.ORIENTABLE);
                case TERRACOTTA -> gen.registerNorthDefaultHorizontalRotated(builder.getBlock(), TexturedModel.TEMPLATE_GLAZED_TERRACOTTA);
                case CUBE_ALL -> gen.registerSimpleCubeAll(builder.getBlock());
            }
        }
    }

    @Override
    public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) { }
}