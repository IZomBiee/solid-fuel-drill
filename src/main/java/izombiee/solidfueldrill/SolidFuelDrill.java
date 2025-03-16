package izombiee.solidfueldrill;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolidFuelDrill implements ModInitializer {
	public static final String MOD_ID = "solid-fuel-drill";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Item SUSPICIOUS_SUBSTANCE = ModItems.register("suspicious_substance", Item::new, new Item.Settings());

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		// Get the event for modifying entries in the ingredients group.
		// And register an event handler that adds our suspicious item to the ingredients group.
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
				.register((itemGroup) -> itemGroup.add(SUSPICIOUS_SUBSTANCE));

		CompostingChanceRegistry.INSTANCE.add(SUSPICIOUS_SUBSTANCE, 0.3f);

		LOGGER.info("Hello Fabric world!");
	}
}