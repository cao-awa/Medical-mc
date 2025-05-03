package com.github.cao.awa.medical.disease.immunity

import com.github.cao.awa.medical.disease.immunity.wbc.WhiteBloodCount
import com.github.cao.awa.medical.nbt.NbtObject
import net.minecraft.nbt.NbtCompound
import com.github.cao.awa.medical.mixin.player.PlayerEntityMixin

/**
 * @see [PlayerEntityMixin]
 */
class ImmunitySystem: NbtObject() {
    val whiteBloodCellCount: WhiteBloodCount = WhiteBloodCount()
    val immuneResponse: UInt = 0u
    override fun readNbt(compound: NbtCompound) {
        compound.getCompound("WBC").ifPresentOrElse(
            // Read present cells data.
            this.whiteBloodCellCount::readNbt
        ) {
            // Generate cells if no data present.
            this.whiteBloodCellCount.healthCells()
        }
    }

    override fun writeNbt(key: String, compound: NbtCompound) {
        val immunitySystem: NbtCompound = NbtCompound()

        this.whiteBloodCellCount.writeNbt("WBC", immunitySystem)

        compound.put(key, immunitySystem)
    }
}
