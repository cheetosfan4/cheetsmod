package net.cheetosfan4.cheetsmod.datagen;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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
        blockWithItem(ModBlocks.POOP_BLOCK);
        blockWithItem(ModBlocks.YANDESITE);
        blockWithItem(ModBlocks.PINK_SAND);
        blockWithItem(ModBlocks.MANGO_PLANKS);
        //blockWithItem(ModBlocks.PINK_SANDSTONE);

        stairsBlock(ModBlocks.POOP_STAIRS.get(), blockTexture(ModBlocks.POOP_BLOCK.get()));
        slabBlock(ModBlocks.POOP_SLAB.get(), blockTexture(ModBlocks.POOP_BLOCK.get()), blockTexture(ModBlocks.POOP_BLOCK.get()));
        buttonBlock(ModBlocks.POOP_BUTTON.get(), blockTexture(ModBlocks.POOP_BLOCK.get()));
        pressurePlateBlock(ModBlocks.POOP_PRESSURE_PLATE.get(), blockTexture(ModBlocks.POOP_BLOCK.get()));
        fenceBlock(ModBlocks.POOP_FENCE.get(), blockTexture(ModBlocks.POOP_BLOCK.get()));
        fenceGateBlock(ModBlocks.POOP_FENCE_GATE.get(), blockTexture(ModBlocks.POOP_BLOCK.get()));
        wallBlock(ModBlocks.POOP_WALL.get(), blockTexture(ModBlocks.POOP_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.POOP_DOOR.get(), modLoc("block/poop_door_bottom"), modLoc("block/poop_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.POOP_TRAPDOOR.get(), modLoc("block/poop_trapdoor"), true, "cutout");

        blockItem(ModBlocks.POOP_STAIRS);
        blockItem(ModBlocks.POOP_SLAB);
        blockItem(ModBlocks.POOP_PRESSURE_PLATE);
        blockItem(ModBlocks.POOP_FENCE_GATE);
        blockItem(ModBlocks.POOP_TRAPDOOR, "_bottom");

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cf4mod:block/" + deferredBlock.getId().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("cf4mod:block/" + deferredBlock.getId().getPath() + appendix));
    }

}