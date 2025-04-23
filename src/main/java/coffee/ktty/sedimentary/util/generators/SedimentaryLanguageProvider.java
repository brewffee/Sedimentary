package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import coffee.ktty.sedimentary.util.SedimentaryBlock;
import coffee.ktty.sedimentary.util.Translation;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.ArrayList;
import java.util.List;

public class SedimentaryLanguageProvider extends FabricLanguageProvider {
    public static List<Translation> translations = new ArrayList<>();

    protected SedimentaryLanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translation) {
        for (SedimentaryBlock builder: LocalBlocks.blocks) {
            translation.add(builder.getBlock(), builder.getTranslated());
        }

        for (Translation set: translations) {
            translation.add(set.key, set.name);
        }
    }
}