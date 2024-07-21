package coffee.ktty.sedimentary.util;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.ToIntFunction;

import static coffee.ktty.sedimentary.Sedimentary.ID;

/**
 * A utility class providing methods for shortening otherwise ridiculously long lines of code
 */
public final class Shorthand {
    /**
     * Creates an {@link Identifier} (like "namespace:item")
     *
     * @param path the item's path
     * @return a new {@link Identifier}
     */
    @Contract("_ -> new")
    public static @NotNull Identifier id(String path) {
        return new Identifier(ID, path);
    }

    /**
     * Creates a new {@link Block} by copying an existing Block's settings
     *
     * @param block the {@link Block} to copy from
     * @return the block settings object
     */
    @Contract(value = "_ -> new", pure = true)
    public static AbstractBlock.@NotNull Settings copyFrom(Block block) {
        return FabricBlockSettings.copy(block);
    }

    /**
     * Creates a new {@link Block} from scratch
     *
     * @return the block settings object
     */
    @Contract(value = " -> new", pure = true)
    public static @NotNull FabricBlockSettings create() {
        return FabricBlockSettings.create();
    }

    /**
     * Creates a new {@link BlockEntity} from scratch
     *
     * @return the block entity type
     */
    @Contract("_, _ -> new")
    public static <T extends BlockEntity> BlockEntityType<? extends T> createEntity(FabricBlockEntityTypeBuilder.Factory<? extends T> factory, Block... blocks) {
        return FabricBlockEntityTypeBuilder.create(factory, blocks).build(null);
    }

    /**
     * Quick function to define a block's light level in its LIT state.
     *
     * @param level int
     * @return the light level
     */
    @Contract(pure = true)
    public static @NotNull ToIntFunction<BlockState> inLitState(int level) {
        return Blocks.createLightLevelFromLitBlockState(level);
    }
}
