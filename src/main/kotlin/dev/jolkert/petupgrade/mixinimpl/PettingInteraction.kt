package dev.jolkert.petupgrade.mixinimpl

import net.minecraft.entity.passive.TameableEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand

fun petAnimal(animal: TameableEntity, player: PlayerEntity, hand: Hand): ActionResult?
{
	if (!(animal.isTamed && player.getStackInHand(hand).isEmpty && player.isSneaking))
		return null

	animal.playAmbientSound()
	animal.world.let { world ->
		if (!world.isClient && world is ServerWorld)
		{
			world.spawnParticles(
				ParticleTypes.HEART,
				animal.x,
				animal.y + 1,
				animal.z,
				1,
				0.0,
				0.0,
				0.0,
				0.0
			)
		}
	}

	return ActionResult.SUCCESS
}