package izombiee.solidfueldrill;

import izombiee.solidfueldrill.items.CustomItem;
import izombiee.solidfueldrill.items.SuspiciousSubstance;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolidFuelDrill implements ModInitializer {
	public static final String MOD_ID = "solid-fuel-drill";

	public static final SuspiciousSubstance suspiciousSubstance = new SuspiciousSubstance();

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	}
}