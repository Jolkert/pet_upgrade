package dev.jolkert.petupgrade.mixin;

import dev.jolkert.petupgrade.mixinimpl.PettingInteractionKt;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.jetbrains.annotations.ApiStatus;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ParrotEntity.class)
public class ParrotPettingFixMixin
{
	@Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
	void interactHook(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir)
	{
		// this is required because, unlike cats & wolves, parrots are written to attempt to stand *before* the call to
		// super. this shit is stupid
		// -morgan 2024-09-05
		PettingInteractionKt.petAnimal((AnimalEntity) (Object) this, player, hand, cir);
	}
}
