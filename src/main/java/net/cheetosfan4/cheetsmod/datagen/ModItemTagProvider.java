package net.cheetosfan4.cheetsmod.datagen;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.block.ModBlocks;
import net.cheetosfan4.cheetsmod.item.ModItems;
import net.cheetosfan4.cheetsmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, CheetsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.EMERALD);

        //tag(ItemTags.LOGS_THAT_BURN).add(Item.byBlock(ModBlocks.MANGO_LOG.get()));
        //mango log
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.LOGS, ItemTags.LOGS);
        copy(BlockTags.COMPLETES_FIND_TREE_TUTORIAL, ItemTags.COMPLETES_FIND_TREE_TUTORIAL);
        copy(Tags.Blocks.STRIPPED_LOGS, Tags.Items.STRIPPED_LOGS);

        //mango planks
        copy(BlockTags.PLANKS, ItemTags.PLANKS);

        //pink sand
        copy(Tags.Blocks.SANDS, Tags.Items.SANDS);
        copy(BlockTags.SAND, ItemTags.SAND);
        copy(BlockTags.SMELTS_TO_GLASS, ItemTags.SMELTS_TO_GLASS);

        //pink sandstone
        copy(Tags.Blocks.SANDSTONE_BLOCKS, Tags.Items.SANDSTONE_BLOCKS);

    }
}
