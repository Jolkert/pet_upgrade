package dev.jolkert.petupgrade.mixin;

import dev.jolkert.petupgrade.mixinimpl.PettingInteractionKt;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AnimalEntity.class)
public class AnimalInteractionHookMixin
{
	@Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
	void interactHook(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir)
	{
		PettingInteractionKt.petAnimal((AnimalEntity)(Object) this, player, hand, cir);
	}
}
