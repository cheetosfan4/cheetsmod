package net.cheetosfan4.cheetsmod.block;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import net.cheetosfan4.cheetsmod.CheetsMod;
import net.cheetosfan4.cheetsmod.block.custom.MagicBlock;
import net.cheetosfan4.cheetsmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

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

    public static final DeferredBlock<Block> MANGO_LOG = registerBlock("mango_log",
            () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_YELLOW : MapColor.COLOR_BROWN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F)
                            .sound(SoundType.CHERRY_WOOD)
                            .ignitedByLava())
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> STRIPPED_MANGO_LOG = registerBlock("stripped_mango_log",
            () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MapColor.COLOR_YELLOW : MapColor.COLOR_BROWN)
                            .instrument(NoteBlockInstrument.BASS)
                            .strength(2.0F)
                            .sound(SoundType.CHERRY_WOOD)
                            .ignitedByLava())
            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<Block> MANGO_PLANKS = registerBlock("mango_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.CHERRY_WOOD)
                    .ignitedByLava())            {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });


    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));


/*    public static final BlockSetType STONE = register(
            new BlockSetType(
                    "stone",
                    true,
                    true,
                    false,
                    BlockSetType.PressurePlateSensitivity.MOBS,
                    SoundType.STONE,
                    SoundEvents.IRON_DOOR_CLOSE,
                    SoundEvents.IRON_DOOR_OPEN,
                    SoundEvents.IRON_TRAPDOOR_CLOSE,
                    SoundEvents.IRON_TRAPDOOR_OPEN,
                    SoundEvents.STONE_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.STONE_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
            )
    );
 */

public record BlockSetType (String name, boolean canOpenByHand, boolean canOpenByWindCharge, boolean canButtonBeActivatedByArrows, BlockSetType.PressurePlateSensitivity pressurePlateSensitivity, SoundType soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn)
{
    private static final Map<String, net.minecraft.world.level.block.state.properties.BlockSetType> TYPES = new Object2ObjectArrayMap<>();
    public static final Codec<net.minecraft.world.level.block.state.properties.BlockSetType> CODEC = Codec.stringResolver(net.minecraft.world.level.block.state.properties.BlockSetType::name, TYPES::get);

    public static final net.minecraft.world.level.block.state.properties.BlockSetType POOP = register(
            new net.minecraft.world.level.block.state.properties.BlockSetType(
                    "poop",
                    true,
                    true,
                    false,
                    net.minecraft.world.level.block.state.properties.BlockSetType.PressurePlateSensitivity.MOBS,
                    SoundType.SLIME_BLOCK,
                    SoundEvents.SLIME_BLOCK_BREAK,
                    SoundEvents.SLIME_BLOCK_PLACE,
                    SoundEvents.SLIME_BLOCK_BREAK,
                    SoundEvents.SLIME_BLOCK_PLACE,
                    SoundEvents.SLIME_BLOCK_BREAK,
                    SoundEvents.SLIME_BLOCK_PLACE,
                    SoundEvents.SLIME_BLOCK_BREAK,
                    SoundEvents.SLIME_BLOCK_PLACE));
    
    public static net.minecraft.world.level.block.state.properties.BlockSetType register(net.minecraft.world.level.block.state.properties.BlockSetType value) {
    TYPES.put(value.name(), value);
    return value;
}

    public static Stream<net.minecraft.world.level.block.state.properties.BlockSetType> values() {
        return TYPES.values().stream();
    }

    public static enum PressurePlateSensitivity {
        EVERYTHING,
        MOBS;
    }};
public record WoodType(String name, net.minecraft.world.level.block.state.properties.BlockSetType setType, SoundType soundType, SoundType hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen)
{
    private static final Map<String, net.minecraft.world.level.block.state.properties.WoodType> TYPES = new Object2ObjectArrayMap<>();
    public static final Codec<net.minecraft.world.level.block.state.properties.WoodType> CODEC = Codec.stringResolver(net.minecraft.world.level.block.state.properties.WoodType::name, TYPES::get);

    public static final net.minecraft.world.level.block.state.properties.WoodType POOP = register(
            new net.minecraft.world.level.block.state.properties.WoodType(
                    "poop",
                    BlockSetType.POOP,
                    SoundType.SLIME_BLOCK,
                    SoundType.SLIME_BLOCK,
                    SoundEvents.SLIME_BLOCK_BREAK,
                    SoundEvents.SLIME_BLOCK_PLACE
            )
    );

    public static net.minecraft.world.level.block.state.properties.WoodType register(net.minecraft.world.level.block.state.properties.WoodType woodType) {
        TYPES.put(woodType.name(), woodType);
        return woodType;
    }

    public static Stream<net.minecraft.world.level.block.state.properties.WoodType> values() {
        return TYPES.values().stream();
    }
}



    public static final DeferredBlock<StairBlock> POOP_STAIRS = registerBlock("poop_stairs",
            () -> new StairBlock(ModBlocks.POOP_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(2f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<SlabBlock> POOP_SLAB = registerBlock("poop_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<PressurePlateBlock> POOP_PRESSURE_PLATE = registerBlock("poop_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.POOP, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<ButtonBlock> POOP_BUTTON = registerBlock("poop_button",
            () -> new ButtonBlock(BlockSetType.POOP, 20, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission().sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<FenceBlock> POOP_FENCE = registerBlock("poop_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<FenceGateBlock> POOP_FENCE_GATE = registerBlock("poop_fence_gate",
            () -> new FenceGateBlock(WoodType.POOP, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<WallBlock> POOP_WALL = registerBlock("poop_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().sound(SoundType.SLIME_BLOCK)));

    public static final DeferredBlock<DoorBlock> POOP_DOOR = registerBlock("poop_door",
            () -> new DoorBlock(BlockSetType.POOP, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.SLIME_BLOCK)));
    public static final DeferredBlock<TrapDoorBlock> POOP_TRAPDOOR = registerBlock("poop_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.POOP, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion().sound(SoundType.SLIME_BLOCK)));



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
