package ls.miche.minecraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicWandMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("magicwand-mod");

    public static final Block MARKER_BLOCK  = new MarkerBlock();

    @Override
    public void onInitialize() {
        LOGGER.info("onInitialize()");

        registerBlocks();
    }

    private void registerBlocks() {
        Registry.register(Registries.BLOCK, new Identifier("magicwand-mod", "marker_block"), MARKER_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("magicwand-mod", "marker_block"), new BlockItem(MARKER_BLOCK, new FabricItemSettings()));
    }
}
