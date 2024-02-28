package ls.miche.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Wand extends Item {
    private static CircleBlockPosGenerator circleBlockPosGenerator = new CircleBlockPosGenerator();

    public Wand(Settings settings)
    {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand)
    {
        if(world.isClient()) {
            playerEntity.sendMessage(Text.literal("Magic wand used!"));
        }

        BlockPos playerPosition =  playerEntity.getBlockPos();

        Direction direction = playerEntity.getHorizontalFacing();

        int radius = 16;

        //for (int i = 0; i < 25; i++) {
            List<BlockPos> positions = circleBlockPosGenerator.generateBlockPositions(playerPosition.getX(), playerPosition.getY(), playerPosition.getZ(), radius);
            for(BlockPos pos : positions) {
                world.setBlockState(pos, MagicWandMod.MARKER_BLOCK.getDefaultState());
            }
        //}

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}