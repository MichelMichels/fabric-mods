package ls.miche.minecraft;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.swing.*;

public class MarkerBlock extends Block {

    public MarkerBlock() {
        super(FabricBlockSettings.create().noCollision().nonOpaque().strength(0f));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        // Get index of selected hotbar item
        int selectedSlotIndex = player.getInventory().selectedSlot;

        // ItemStack van geselecteerde item
        ItemStack selectedItemStack = player.getInventory().getStack(selectedSlotIndex);

        // Get Item
        Item selectedItem = selectedItemStack.getItem();

        // Logging
        player.sendMessage(Text.literal("Selected hotbar index: " + selectedSlotIndex), false);
        player.sendMessage(Text.literal("Selected ItemStack: " + selectedItem.getName()), false);

        // Controle als selectedItem een blok is
        if(selectedItem instanceof BlockItem) {

            //
            world.setBlockState(pos, ((BlockItem) selectedItem).getBlock().getDefaultState());
            selectedItemStack.decrement(1);
        }

        return ActionResult.SUCCESS;
    }
}
