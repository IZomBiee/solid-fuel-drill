package izombiee.solidfueldrill.items;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;

public class SuspiciousSubstance extends CustomItem {
    public SuspiciousSubstance() {
        super("suspicious_substance", ItemGroups.INGREDIENTS);
    }

    @Override
    public void initItem(RegistryKey<ItemGroup> group) {
        super.initItem(group);
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(this.item, 30 * 20);
        });
    }

    @Override
    public void initSettings() {
        super.initSettings();
        this.settings.maxCount(16);
    }
}
