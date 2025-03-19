package izombiee.solidfueldrill;

import izombiee.solidfueldrill.items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolidFuelDrill implements ModInitializer {
	public static final String MOD_ID = "solid-fuel-drill";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		LOGGER.info("Hello Fabric world!");
	}
}