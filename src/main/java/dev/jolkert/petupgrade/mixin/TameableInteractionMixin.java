package dev.jolkert.petupgrade.mixin;

import dev.jolkert.petupgrade.mixinimpl.PettingInteractionKt;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TameableEntity.class)
public class TameableInteractionMixin extends AnimalInteractionHookMixin
{
	@Override
	void interactHook(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir)
	{
		// TODO: for some reason this doesnt work right with parrots? we gotta fix that -morgan 2024-09-05

		ActionResult result = PettingInteractionKt.petAnimal((TameableEntity) (Object) this, player, hand);
		if (result != null)
			cir.setReturnValue(result);
	}
}
