package com.gorgonine.joandre.item.items;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.item.ModBlocks;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.network.packet.s2c.play.CooldownUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class PisratHammer extends Item {

    public PisratHammer(Settings settings) {
        super(settings);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerWorld serverWorld = (ServerWorld)attacker.getWorld();

        if (attacker instanceof ServerPlayerEntity serverPlayerEntity) {
            serverPlayerEntity.currentExplosionImpactPos = this.getCurrentExplosionImpactPos(serverPlayerEntity);
            serverPlayerEntity.setIgnoreFallDamageFromCurrentExplosion(true);
            serverPlayerEntity.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayerEntity));
        }

        if (attacker instanceof ServerPlayerEntity serverPlayerEntity) {
            serverWorld.spawnParticles(new BlockStateParticleEffect(ParticleTypes.BLOCK, ModBlocks.JOANDREITE_BLOCK.getDefaultState()), target.getX(), target.getY(), target.getZ(), 60, 0.3F, 0.3F, 0.3F, 0.15F);
        }

        serverWorld.playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.ITEM_MACE_SMASH_GROUND, attacker.getSoundCategory(), 1.0F, 1.0F);
    }

    private Vec3d getCurrentExplosionImpactPos(ServerPlayerEntity player) {
        return player.shouldIgnoreFallDamageFromCurrentExplosion()
                && player.currentExplosionImpactPos != null
                && player.currentExplosionImpactPos.y <= player.getPos().y
                ? player.currentExplosionImpactPos
                : player.getPos();
    }

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.ATTACK_DAMAGE,
                        new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 135.0, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, -3.5F, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }

    public static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(), 5.0F, 2, false);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        if(!world.isClient){
            ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) context.getPlayer();
            ItemCooldownManager itemCooldownManager = serverPlayerEntity.getItemCooldownManager();

            serverPlayerEntity.addVelocity(new Vec3d(
                    0.0,

                    Math.abs(1/(serverPlayerEntity.getVelocity().y)+0.1),

                    0.0
            ));

            ServerWorld serverWorld = (ServerWorld) world;

            serverWorld.spawnParticles(ParticleTypes.EXPLOSION,serverPlayerEntity.getX(),serverPlayerEntity.getY(),serverPlayerEntity.getZ(), 100, 0.3F, 0.3F, 0.3F, 0.15F);
            itemCooldownManager.set(context.getStack(),200);

            serverPlayerEntity.currentExplosionImpactPos = this.getCurrentExplosionImpactPos(serverPlayerEntity);
            serverPlayerEntity.setIgnoreFallDamageFromCurrentExplosion(true);
            serverPlayerEntity.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayerEntity));

            world.playSound(null, serverPlayerEntity.getX(), serverPlayerEntity.getY(), serverPlayerEntity.getZ(), SoundEvents.BLOCK_BEACON_DEACTIVATE, serverPlayerEntity.getSoundCategory(), 1.0F, 1.0F);

            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
