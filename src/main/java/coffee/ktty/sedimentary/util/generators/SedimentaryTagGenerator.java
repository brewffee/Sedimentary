package coffee.ktty.sedimentary.util.generators;

import coffee.ktty.sedimentary.registry.LocalBlocks;
import coffee.ktty.sedimentary.util.SedimentaryBlockBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class SedimentaryTagGenerator extends FabricTagProvider.BlockTagProvider {
    public SedimentaryTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        for (SedimentaryBlockBuilder builder: LocalBlocks.blocks) {
            for (TagKey<Block> tag: builder.getTags()) {
                getOrCreateTagBuilder(tag).add(builder.getBlock());
            }
        }
    }
}