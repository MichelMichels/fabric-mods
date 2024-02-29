package ls.miche.minecraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
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
    private static StructureManager structureManager = new StructureManager();

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

        int radius = 16;

        List<BlockPos> positions = circleBlockPosGenerator.generateBlockPositions(playerPosition.getX(), playerPosition.getY(), playerPosition.getZ(), radius);
        structureManager.addStructure(positions);

        for(BlockPos pos : positions) {
            world.setBlockState(pos, MagicWandMod.MARKER_BLOCK.getDefaultState());
        }

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block minedBlock = state.getBlock();
        if(minedBlock instanceof MarkerBlock) {
            miner.sendMessage(Text.literal("MarkerBlock mined"));

            List<BlockPos> structure = structureManager.getStructure(pos);
            if(!structure.isEmpty()) {
                miner.sendMessage(Text.literal("Structure found!"));

                for(BlockPos structureBlockPos : structure) {
                    world.setBlockState(structureBlockPos, Blocks.AIR.getDefaultState());
                }
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }
}