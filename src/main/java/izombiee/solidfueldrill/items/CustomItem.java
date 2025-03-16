package izombiee.solidfueldrill.items;

import izombiee.solidfueldrill.SolidFuelDrill;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class CustomItem {
    Item.Settings settings;
    Item item;

    public CustomItem(String name, RegistryKey<ItemGroup> group) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SolidFuelDrill.MOD_ID, name));

        initSettings();
        item = new Item(settings.registryKey(itemKey));
        initItem(group);

        Registry.register(Registries.ITEM, itemKey, item);
    }

    public void initSettings() {
        this.settings = new Item.Settings();
    }

    public void initItem(RegistryKey<ItemGroup> group) {
        ItemGroupEvents.modifyEntriesEvent(group)
                .register((itemGroup) -> itemGroup.add(item));
    }
}
