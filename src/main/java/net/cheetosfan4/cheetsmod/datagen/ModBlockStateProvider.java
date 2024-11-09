package net.cheetosfan4.cheetsmod.datagen;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CheetsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.GRITTLE);
        blockWithItem(ModBlocks.POLISHED_YANDESITE);
        blockWithItem(ModBlocks.POOP_ORE);
        blockWithItem(ModBlocks.YANDESITE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

}