package coffee.ktty.sedimentary.entity;

import coffee.ktty.sedimentary.registry.LocalBlockEntities;
import coffee.ktty.sedimentary.registry.LocalRecipeType;
import coffee.ktty.sedimentary.registry.LocalSounds;
import coffee.ktty.sedimentary.screen.GrinderScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import static coffee.ktty.sedimentary.blocks.GrinderBlock.LIT;

public class GrinderBlockEntity extends AbstractFurnaceBlockEntity {
    public GrinderBlockEntity(BlockPos pos, BlockState state) {
        super(LocalBlockEntities.GRINDER, pos, state, LocalRecipeType.GRINDING);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.sedimentary.grinder");
    }

    @Override
    public int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel) / 4;
    }

    public static void clientTick(@NotNull World world, @NotNull BlockPos pos, @NotNull BlockState state, GrinderBlockEntity blockEntity) {
        if (state.get(LIT)) world.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, LocalSounds.GRIND, SoundCategory.BLOCKS, 0.125f, 0.75f, false);
        AbstractFurnaceBlockEntity.tick(world, pos, state, blockEntity);
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new GrinderScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
