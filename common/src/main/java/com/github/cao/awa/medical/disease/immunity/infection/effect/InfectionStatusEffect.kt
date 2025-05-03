package com.github.cao.awa.medical.disease.immunity.infection.effect

import com.github.cao.awa.medical.api.immunity.ImmunityDelegate
import com.github.cao.awa.medical.disease.DiseaseStatusEffect
import com.github.cao.awa.medical.disease.immunity.ImmunitySystem
import com.github.cao.awa.medical.disease.immunity.infection.type.InfectionType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.server.world.ServerWorld

class InfectionStatusEffect(statusEffectCategory: StatusEffectCategory, color: Int, infectionType: InfectionType): DiseaseStatusEffect(statusEffectCategory, color) {
    override fun applyUpdateEffect(world: ServerWorld, entity: LivingEntity, amplifier: Int): Boolean {
        return if (entity is ImmunityDelegate) {
            val immunitySystem: ImmunitySystem = entity.getImmunitySystem()

            immunitySystem.updateInfection()

            true
        } else {
            false
        }
    }
}
