package com.plush.summonersversus.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class ShopBlock extends Block {

    public ShopBlock(Properties properties) {
        super(properties);
    }



    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {

            pLevel.playSound(pPlayer, pPos, SoundEvents.AMETHYST_CLUSTER_PLACE, SoundSource.BLOCKS, 1f, 1f);

            EntityType<Zombie> monsterType = EntityType.ZOMBIE;
            Monster monster = monsterType.spawn((ServerLevel) pLevel, pPos, MobSpawnType.NATURAL);
            if (monster == null) {
                return InteractionResult.PASS;
            } else {
                pLevel.gameEvent(pPlayer, GameEvent.ENTITY_PLACE, monster.position());
            }
            return InteractionResult.SUCCESS;
        }
    }
}
