package net.cheetosfan4.cheetsmod.datagen;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CheetsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.cheese.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.eggy.get());
        basicItem(ModItems.geggy.get());
        basicItem(ModItems.poop.get());

    }
}
