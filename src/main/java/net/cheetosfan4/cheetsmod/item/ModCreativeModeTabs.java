package net.cheetosfan4.cheetsmod.item;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CheetsMod.MOD_ID);

    public static final Supplier<CreativeModeTab> CHEETS_MOD_TAB = CREATIVE_MODE_TAB.register("cheets_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.cheese.get()))
                    //.withTabsBefore(ResourceLocation.fromNamespaceAndPath(CheetsMod.MOD_ID, "other_tab"))
                    //other tab would come before this one
                    .title(Component.translatable("creativetab.cf4mod.cheets_mod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.cheese);
                        output.accept(ModBlocks.GRITTLE);
                        output.accept(ModBlocks.YANDESITE);
                        output.accept(ModBlocks.POLISHED_YANDESITE);
                        output.accept(ModItems.CHISEL);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModItems.eggy);
                        output.accept(ModItems.geggy);
                        output.accept(ModBlocks.POOP_ORE);
                        output.accept(ModItems.poop);
                        output.accept(ModBlocks.POOP_BLOCK);
                        output.accept(ModBlocks.MANGO_LOG);
                        output.accept(ModBlocks.PINK_SANDSTONE);
                        output.accept(ModBlocks.MANGO_PLANKS);
                        output.accept(ModBlocks.STRIPPED_MANGO_LOG);

                        output.accept(ModBlocks.POOP_STAIRS);
                        output.accept(ModBlocks.POOP_SLAB);
                        output.accept(ModBlocks.POOP_PRESSURE_PLATE);
                        output.accept(ModBlocks.POOP_BUTTON);
                        output.accept(ModBlocks.POOP_FENCE);
                        output.accept(ModBlocks.POOP_FENCE_GATE);
                        output.accept(ModBlocks.POOP_WALL);
                        output.accept(ModBlocks.POOP_DOOR);
                        output.accept(ModBlocks.POOP_TRAPDOOR);
                        output.accept(ModBlocks.PINK_SAND);
                        output.accept(ModBlocks.PINK_SANDSTONE);

                    })
                    .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TAB.register(eventbus);
    }

}
