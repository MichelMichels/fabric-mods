package com.example;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("first-mod");

	public static final Block MARKER_BLOCK  = new Block(FabricBlockSettings.create().nonOpaque().strength(0f));

	public static final Item CROSS =
			Registry.register(Registries.ITEM, new Identifier("first-mod", "cross"),
					new Cross(new FabricItemSettings()));

	public static final Item CHECKMARK =
			Registry.register(Registries.ITEM, new Identifier("first-mod", "checkmark"),
					new Checkmark(new FabricItemSettings()));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("This is the first mod by Michel Michels");

		Registry.register(Registries.BLOCK, new Identifier("first-mod", "marker_block"), MARKER_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("first-mod", "marker_block"), new BlockItem(MARKER_BLOCK, new FabricItemSettings()));
	}
}