package com.github.cao.awa.medical.disease.immunity.updater.bacterial

import com.github.cao.awa.medical.api.MedicalDelegate
import com.github.cao.awa.medical.disease.immunity.ImmunitySystem

// TODO
object BacterialInfectionUpdater {
    fun updateInfection(delegate: MedicalDelegate) {
        val immunitySystem: ImmunitySystem = delegate.getImmunitySystem()
    }
}