package coffee.ktty.sedimentary.registry;

import coffee.ktty.sedimentary.entity.GrinderBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;
import static coffee.ktty.sedimentary.util.Shorthand.createEntity;
import static coffee.ktty.sedimentary.util.Shorthand.id;

/**
 * A class responsible for registering block entities
 */
public class LocalBlockEntities {

    public static final BlockEntityType<GrinderBlockEntity> GRINDER;

    static {
        GRINDER = register(createEntity(GrinderBlockEntity::new, LocalBlocks.GRINDER), "grinder");
    }

    /**
     * Registers a block entity with the given path.
     *
     * @param entity the block entity to register
     * @param path the block entity's name
     * @return the original {@link BlockEntityType} object
     */
    @Contract("_, _ -> param1")
    public static <T extends BlockEntity> BlockEntityType<T> register(BlockEntityType<T> entity, @NotNull String path) {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, id(path), entity);

        return entity;
    }

    /**
     * Initializes the block entity registry
     */
    public static void initialize() {
        LOGGER.info("[BlockEntityRegistry] Registering block entities...");
    }
}
