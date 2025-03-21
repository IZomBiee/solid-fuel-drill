package izombiee.solidfueldrill.items;

import izombiee.solidfueldrill.SolidFuelDrill;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.*;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IronDrill extends PickaxeItem {
    public static final RegistryKey<Item> itemKey = RegistryKey.of(
            RegistryKeys.ITEM, Identifier.of(SolidFuelDrill.MOD_ID, "iron_drill"));
    public static final Settings settings = new Settings().registryKey(itemKey).maxCount(1);

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {

        int xF = miner.getFacing().getOffsetX();
        int yF = miner.getFacing().getOffsetY();
        int zF = miner.getFacing().getOffsetZ();
        // y - z = z
        // x - y = x
        // x - z = y

        SolidFuelDrill.LOGGER.info(String.valueOf(miner.getFacing().getOffsetX()) + " " +
                String.valueOf(miner.getFacing().getOffsetY()) + " " +
                String.valueOf(miner.getFacing().getOffsetZ()));

        for (int x = -1; x<2; x++) {
            for (int y = -1; y<2; y++) {
                if (yF != 0) {
                    world.breakBlock(new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + y), true);
                }
                else if (xF != 0) {
                        world.breakBlock(new BlockPos(pos.getX(), pos.getY()+y, pos.getZ()+x), true);
                    }
                else {
                    world.breakBlock(new BlockPos(pos.getX()+x, pos.getY()+y, pos.getZ()), true);
                }
            }
        }

        return super.postMine(stack, world, state, pos, miner);
    }

    public IronDrill() {
        super(ToolMaterial.IRON, 5f, 5f, settings);
        Registry.register(Registries.ITEM, itemKey, this.asItem());

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (player.getMainHandStack().getItem().equals(this.asItem())) {
                if (player.getMainHandStack().getDamage() >= player.getMainHandStack().getMaxDamage()-1) {
                    player.sendMessage(Text.of("Run out of fuel!"), true);
                    return ActionResult.FAIL;
                }
            }
            return ActionResult.PASS;
        });


    }
}
