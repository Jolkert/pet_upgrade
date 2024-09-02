package dev.jolkert.petupgrade.mixin;

import dev.jolkert.petupgrade.mixinimpl.PettingInteractionKt;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TameableEntity.class)
public class TameableInteractionMixin extends AnimalInteractMixin
{
	@Override
	void interactHook(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir)
	{
		ActionResult result = PettingInteractionKt.petAnimal((TameableEntity) (Object) this, player, hand);
		if (result != null)
			cir.setReturnValue(result);
	}
}
