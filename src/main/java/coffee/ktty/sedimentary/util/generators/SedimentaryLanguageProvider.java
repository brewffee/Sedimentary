package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import coffee.ktty.sedimentary.util.SedimentaryBlock;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class SedimentaryLanguageProvider extends FabricLanguageProvider {
    protected SedimentaryLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translation) {
        for (SedimentaryBlock builder: LocalBlocks.blocks) {
            translation.add(builder.getBlock(), builder.getTranslated());
        }
    }
}