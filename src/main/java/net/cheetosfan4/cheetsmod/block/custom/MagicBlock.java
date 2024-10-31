package net.cheetosfan4.cheetsmod.block.custom;

import net.cheetosfan4.cheetsmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Interaction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        level.playSound(player, pos, SoundEvents.GHAST_SCREAM, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        if(entity instanceof ItemEntity itemEntity) {
            if(itemEntity.getItem().getItem() == Items.DIAMOND) {
                itemEntity.setItem((new ItemStack(ModItems.cheese.get(), itemEntity.getItem().getCount())));
            }
            if(itemEntity.getItem().getItem() == Items.DANDELION) {
                itemEntity.setItem((new ItemStack(Items.WITHER_ROSE, itemEntity.getItem().getCount())));
            }
            if(itemEntity.getItem().getItem() == ModItems.eggy.get()) {
                itemEntity.setItem((new ItemStack(ModItems.geggy.get(), itemEntity.getItem().getCount())));
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}
