package com.github.cao.awa.medical.api.immunity

import com.github.cao.awa.medical.disease.immunity.ImmunitySystem

interface ImmunityDelegate {
    fun getImmunitySystem(): ImmunitySystem
}