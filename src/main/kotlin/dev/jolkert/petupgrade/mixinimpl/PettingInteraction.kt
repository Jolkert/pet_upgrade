package dev.jolkert.petupgrade.mixinimpl

import   net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.TameableEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.particle.ParticleTypes
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable

fun petAnimal(animal: AnimalEntity, player: PlayerEntity, hand: Hand, cir: CallbackInfoReturnable<ActionResult>)
{
	if (!(animal is TameableEntity && animal.isTamed && player.getStackInHand(hand).isEmpty && player.isSneaking))
		return

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

	cir.returnValue = ActionResult.SUCCESS
}