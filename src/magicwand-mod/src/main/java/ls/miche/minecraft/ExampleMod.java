package ls.miche.minecraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {

	// Fields, variables
	public static final Logger LOGGER = LoggerFactory.getLogger("example-mod");

	// Items
	public static final Item CROSS = new Cross(new FabricItemSettings());
	public static final Item CHECKMARK = new Checkmark(new FabricItemSettings());
	public static final Item WAND = new Wand(new FabricItemSettings());

	// Blocks

	// Methods
	@Override
	public void onInitialize() {
		logStartupMessage();
		registerItems();
	}

	private void logStartupMessage() {
		LOGGER.info("This is the first mod by Michel Michels");
	}

	private void registerItems() {
		Registry.register(Registries.ITEM, new Identifier("magicwand-mod", "cross"), CROSS);
		Registry.register(Registries.ITEM, new Identifier("magicwand-mod", "checkmark"), CHECKMARK);
		Registry.register(Registries.ITEM, new Identifier("magicwand-mod", "wand"), WAND);
	}
}