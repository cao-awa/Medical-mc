package com.github.cao.awa.medical.disease.immunity

import com.github.cao.awa.medical.api.MedicalDelegate
import com.github.cao.awa.medical.disease.immunity.infection.type.InfectionType
import com.github.cao.awa.medical.disease.immunity.updater.bacterial.BacterialInfectionUpdater
import com.github.cao.awa.medical.disease.immunity.updater.viral.ViralInfectionUpdater
import com.github.cao.awa.medical.disease.immunity.wbc.WhiteBloodCount
import com.github.cao.awa.medical.effect.MedicalEffects
import com.github.cao.awa.medical.nbt.NbtObject
import net.minecraft.nbt.NbtCompound
import com.github.cao.awa.medical.mixin.player.PlayerEntityMixin
import net.minecraft.entity.player.PlayerEntity

/**
 * @see [PlayerEntityMixin]
 */
class ImmunitySystem(val delegate: MedicalDelegate) : NbtObject() {
    private var isInViralInfection: Boolean = false
    private var isInBacterialInfection: Boolean = false
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

    fun isInViralInfection(): Boolean = this.isInViralInfection

    fun isInBacterialInfection(): Boolean = this.isInBacterialInfection

    fun infection(infectionType: InfectionType, player: PlayerEntity) {
        when (infectionType.effectType) {
            MedicalEffects.VIRAL_INFECTION -> {
                this.isInViralInfection = true
            }

            MedicalEffects.BACTERIAL_INFECTION -> {
                this.isInBacterialInfection = true
            }
        }

        player.addStatusEffect(
            infectionType.getInfectionInstance(1),
            player
        )
    }

    fun updateInfection() {
        if (this.isInBacterialInfection) {
            BacterialInfectionUpdater.updateInfection(this.delegate)
        }

        if (this.isInViralInfection) {
            ViralInfectionUpdater.updateInfection(this.delegate)
        }
    }
}
