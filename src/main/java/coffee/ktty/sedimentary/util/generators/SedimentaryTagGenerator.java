package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.registry.tag.BlockTags.SOUL_SPEED_BLOCKS;

public class SedimentaryTagGenerator extends FabricTagProvider.BlockTagProvider {
    public SedimentaryTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(SOUL_SPEED_BLOCKS).add(LocalBlocks.SOUL_GLASS);
        getOrCreateTagBuilder(SOUL_SPEED_BLOCKS).add(LocalBlocks.SOUL_STONE);
    }
}