package coffee.ktty.sedimentary.blocks;

import coffee.ktty.sedimentary.entity.GrinderBlockEntity;
import coffee.ktty.sedimentary.registry.LocalBlockEntities;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GrinderBlock extends AbstractFurnaceBlock {
    public GrinderBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GrinderBlockEntity(pos, state);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, @NotNull BlockState state, @NotNull Entity entity) {
        if (state.get(LIT).equals(true)) {
            entity.damage(world.getDamageSources().generic(), 2.0f);
        }
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, LocalBlockEntities.GRINDER, world.isClient ? GrinderBlockEntity::clientTick : AbstractFurnaceBlockEntity::tick);
    }

    @Override
    protected void openScreen(@NotNull World world, BlockPos pos, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof GrinderBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);

            // Maybe add a custom stat as well?
            // player.incrementStat(Stats.INTERACT_WITH_SMOKER);
        }
    }

    @Override
    public void randomDisplayTick(@NotNull BlockState state, World world, BlockPos pos, Random random) {
        if (!state.get(LIT)) return;

        double x = pos.getX() + 0.5;
        double y = pos.getY();
        double z = pos.getZ() + 0.5;

        int dir = random.nextFloat() < 0.5 ? -1 : 1;

        world.addParticle(ParticleTypes.CRIT, x, y + 1.0, z, dir * random.nextFloat() / 2.0f, 2.0f, dir * random.nextFloat() / 2.0f);

        if (random.nextDouble() < 0.8) {
            world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y + 1.0, z, 0.0, 0.025f, 0.0);
        }

        if (random.nextDouble() < 0.5) {
            world.addParticle(ParticleTypes.LAVA, x, y + 0.5, z, random.nextFloat() / 2.0f, 5.0E-5, random.nextFloat() / 2.0f);
        }
    }

    @Override
    public void onStateReplaced(@NotNull BlockState state, World world, BlockPos pos, @NotNull BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GrinderBlockEntity) {
                ItemScatterer.spawn(world, pos, ((GrinderBlockEntity) blockEntity));
                world.updateNeighbors(pos, this);
            }
        }
        super.onStateReplaced(state, world, pos, newState, moved);
    }
}
