package dev.jolkert.petupgrade.mixin;

import dev.jolkert.petupgrade.mechanics.BehaviorState;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TameableEntity.class)
public class SittingStateUpdateMixin
{
	@Unique
	BehaviorState behaviorState;

	@Inject(method = "writeCustomDataToNbt", at = @At("TAIL"))
	void writeBehaviorState(NbtCompound nbt, CallbackInfo ci)
	{
		nbt.putByte("BehaviorState", BehaviorState.SITTING.byteOrdinal());
	}
	@Inject(method = "readCustomDataFromNbt", at = @At("TAIL"))
	void readBehaviorState(NbtCompound nbt, CallbackInfo ci)
	{
		if (nbt.contains("BehaviorState"))
		{

		}
		else
		{

		}
	}
}
