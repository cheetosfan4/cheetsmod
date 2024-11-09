package net.cheetosfan4.cheetsmod.datagen;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CheetsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.GRITTLE.get())
                .add(ModBlocks.YANDESITE.get())
                .add(ModBlocks.POLISHED_YANDESITE.get())
                .add(ModBlocks.POOP_ORE.get())
                .add(ModBlocks.POOP_BLOCK.get())
                .add(ModBlocks.PINK_SANDSTONE.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.PINK_SAND.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.POOP_ORE.get())
                .add(ModBlocks.POOP_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.POOP_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.POOP_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.POOP_WALL.get());


    }
}
