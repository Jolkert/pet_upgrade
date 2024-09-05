package dev.jolkert.petupgrade.mixinimpl

import net.minecraft.entity.Entity
import net.minecraft.entity.passive.TameableEntity
import net.minecraft.entity.player.PlayerEntity

fun playerOwns(player: Entity?, entity: Entity): Boolean
{
	return entity is TameableEntity && player is PlayerEntity && entity.isTamed && entity.ownerUuid == player.uuid
}