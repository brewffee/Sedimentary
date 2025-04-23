package coffee.ktty.sedimentary.util.generators;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.jetbrains.annotations.NotNull;

/**
 * A generator for block data
 */
public class SedimentaryDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(@NotNull FabricDataGenerator generator) {
        FabricDataGenerator.Pack datapack = generator.createPack();

        datapack.addProvider(SedimentaryLootTableGenerator::new);
        datapack.addProvider(SedimentaryModelGenerator::new);
        datapack.addProvider(SedimentaryRecipeGenerator::new);
        datapack.addProvider(SedimentaryTagGenerator::new);
        datapack.addProvider(SedimentaryLanguageProvider::new);
    }
}