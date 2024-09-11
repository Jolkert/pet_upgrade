package dev.jolkert.petupgrade.mechanics

enum class BehaviorState
{
	SITTING,
	WANDERING,
	FOLLOWING;

	fun byteOrdinal(): Byte
	{
		return this.ordinal.toByte()
	}
}