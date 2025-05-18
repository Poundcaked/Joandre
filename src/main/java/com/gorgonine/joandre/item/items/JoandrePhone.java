package com.gorgonine.joandre.item.items;

import com.gorgonine.joandre.item.ModItems;
import com.gorgonine.joandre.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class JoandrePhone extends Item {
    public JoandrePhone(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(clickedBlock instanceof LeveledCauldronBlock){
            BlockState state = world.getBlockState(context.getBlockPos());
            if(((LeveledCauldronBlock) clickedBlock).isFull(state)){
                if(!world.isClient && player != null){
                    ItemStack disgustingPhone = new ItemStack(ModItems.DISGUSTING_JOANDRE_PHONE);
                    player.setStackInHand(context.getHand(), disgustingPhone);

                    world.playSound(null,context.getBlockPos(), SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS);
                    world.playSound(null,context.getBlockPos(), ModSounds.EWWW, SoundCategory.PLAYERS);

                    return ActionResult.SUCCESS;
                }
            }
        }

        return ActionResult.FAIL;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();

        if (entity instanceof PigEntity){
            LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT,world);
            lightningBolt.setPos(entity.getX(),entity.getY(),entity.getZ());
            world.spawnEntity(lightningBolt);
            return ActionResult.SUCCESS;
        }
        if(entity instanceof ZoglinEntity){
            HoglinEntity hog = new HoglinEntity(EntityType.HOGLIN,world);
            hog.setPos(entity.getX(),entity.getY(),entity.getZ());
            hog.age = entity.age;
            hog.bodyYaw = entity.bodyYaw;
            hog.headYaw = entity.headYaw;
            hog.fallDistance = entity.fallDistance;
            hog.hurtTime = entity.hurtTime;
            entity.remove(Entity.RemovalReason.DISCARDED);
            world.spawnEntity(hog);
            world.playSound(null,hog.getX(),hog.getY(),hog.getZ(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.PLAYERS);
            world.addParticleClient(ParticleTypes.ANGRY_VILLAGER,hog.getX(),hog.getY(),hog.getZ(),0,0,0);
            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    }
}
