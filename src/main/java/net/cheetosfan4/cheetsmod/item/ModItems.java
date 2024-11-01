package net.cheetosfan4.cheetsmod.item;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.item.custom.ChiselItem;
import net.cheetosfan4.cheetsmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CheetsMod.MOD_ID);

    public static final DeferredItem<Item> cheese = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(ModFoodProperties.cheese)));

    public static final DeferredItem<Item> poop = ITEMS.register("poop",
            () -> new Item(new Item.Properties().food(ModFoodProperties.poop)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.cf4mod.poop.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> eggy = ITEMS.register("eggy",
            () -> new FuelItem(new Item.Properties(), 800));

    public static final DeferredItem<Item> geggy = ITEMS.register("geggy",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
