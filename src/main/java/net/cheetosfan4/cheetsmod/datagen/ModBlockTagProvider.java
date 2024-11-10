package net.cheetosfan4.cheetsmod.datagen;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.Tags;
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
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.MANGO_LOG.get())
                .add(ModBlocks.MANGO_PLANKS.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.POOP_ORE.get())
                .add(ModBlocks.POOP_BLOCK.get());

        tag(BlockTags.FENCES).add(ModBlocks.POOP_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.POOP_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(ModBlocks.POOP_WALL.get());

        tag(BlockTags.LOGS).add(ModBlocks.MANGO_LOG.get()).add(ModBlocks.STRIPPED_MANGO_LOG.get());
        tag(BlockTags.SNAPS_GOAT_HORN).add(ModBlocks.MANGO_LOG.get()).add(ModBlocks.STRIPPED_MANGO_LOG.get());
        tag(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE).add(ModBlocks.MANGO_LOG.get()).add(ModBlocks.STRIPPED_MANGO_LOG.get());
        tag(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).add(ModBlocks.MANGO_LOG.get()).add(ModBlocks.STRIPPED_MANGO_LOG.get());
        tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(ModBlocks.MANGO_LOG.get());
        tag(BlockTags.LOGS_THAT_BURN).add(ModBlocks.MANGO_LOG.get()).add(ModBlocks.STRIPPED_MANGO_LOG.get());
        tag(Tags.Blocks.STRIPPED_LOGS).add(ModBlocks.STRIPPED_MANGO_LOG.get());

        tag(BlockTags.PLANKS).add(ModBlocks.MANGO_PLANKS.get());

        tag(BlockTags.ENDERMAN_HOLDABLE).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.SAND).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.BAMBOO_PLANTABLE_ON).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.AZALEA_GROWS_ON).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.SCULK_REPLACEABLE_WORLD_GEN).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.CAMEL_SAND_STEP_SOUND_BLOCKS).add(ModBlocks.PINK_SAND.get());
        tag(Tags.Blocks.SANDS).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.LUSH_GROUND_REPLACEABLE).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.SMELTS_TO_GLASS).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.SCULK_REPLACEABLE).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.AZALEA_ROOT_REPLACEABLE).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.RABBITS_SPAWNABLE_ON).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.DEAD_BUSH_MAY_PLACE_ON).add(ModBlocks.PINK_SAND.get());
        tag(BlockTags.PARROTS_SPAWNABLE_ON).add(ModBlocks.MANGO_LOG.get()).add(ModBlocks.STRIPPED_MANGO_LOG.get());

        tag(BlockTags.OVERWORLD_CARVER_REPLACEABLES).add(ModBlocks.PINK_SANDSTONE.get());
        tag(BlockTags.SCULK_REPLACEABLE).add(ModBlocks.PINK_SANDSTONE.get());
        tag(BlockTags.SCULK_REPLACEABLE_WORLD_GEN).add(ModBlocks.PINK_SANDSTONE.get());
        tag(Tags.Blocks.SANDSTONE_BLOCKS).add(ModBlocks.PINK_SANDSTONE.get());


    }
}
