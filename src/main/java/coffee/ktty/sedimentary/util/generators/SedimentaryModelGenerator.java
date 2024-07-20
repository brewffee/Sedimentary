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
    public void generateBlockStateModels(@NotNull BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCooker(LocalBlocks.GRINDER, TexturedModel.ORIENTABLE);
    }

    @Override
    public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) { }
}