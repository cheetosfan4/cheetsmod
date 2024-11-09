package net.cheetosfan4.cheetsmod.block;

import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.block.custom.MagicBlock;
import net.cheetosfan4.cheetsmod.item.ModItems;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CheetsMod.MOD_ID);

    public static final DeferredBlock<Block> YANDESITE = registerBlock("yandesite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> POLISHED_YANDESITE = registerBlock("polished_yandesite",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> GRITTLE = registerBlock("grittle",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));

    public static final DeferredBlock<Block> POOP_ORE = registerBlock("poop_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<Block> POOP_BLOCK = registerBlock("poop_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<Block> PINK_SAND = registerBlock("pink_sand",
            () -> new ColoredFallingBlock(new ColorRGBA(16748767), BlockBehaviour.Properties.of()
                    .mapColor((MapColor.COLOR_PINK))
                    .instrument(NoteBlockInstrument.SNARE)
                    .strength(0.5F)
                    .sound(SoundType.SAND)));

    public static final DeferredBlock<Block> PINK_SANDSTONE = registerBlock("pink_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(0.8F)));


    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));


    public static final DeferredBlock<StairBlock> POOP_STAIRS = registerBlock("poop_stairs",
            () -> new StairBlock(ModBlocks.POOP_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<SlabBlock> POOP_SLAB = registerBlock("poop_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<PressurePlateBlock> POOP_PRESSURE_PLATE = registerBlock("poop_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<ButtonBlock> POOP_BUTTON = registerBlock("poop_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission().sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<FenceBlock> POOP_FENCE = registerBlock("poop_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<FenceGateBlock> POOP_FENCE_GATE = registerBlock("poop_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<WallBlock> POOP_WALL = registerBlock("poop_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<DoorBlock> POOP_DOOR = registerBlock("poop_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<TrapDoorBlock> POOP_TRAPDOOR = registerBlock("poop_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.SLIME_BLOCK)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventbus) {
        BLOCKS.register(eventbus);
    }
}
