package dev.jolkert.petupgrade.mixin;

import dev.jolkert.petupgrade.mixinimpl.DisableFriendlyFireKt;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityDamageHandlerMixin
{
	// this doesn't work right with the "inject a hook & override" method. it's probably because there's overrides later
	// down the line? im not 100% sure how this works?
	// -morgan 2024-09-05
	@Inject(method = "isInvulnerableTo", at = @At("TAIL"), cancellable = true)
	void disableFriendlyFire(DamageSource source, CallbackInfoReturnable<Boolean> cir)
	{
		if (DisableFriendlyFireKt.playerOwns(source.getAttacker(), (Entity)(Object)this))
			cir.setReturnValue(true);
	}
}
