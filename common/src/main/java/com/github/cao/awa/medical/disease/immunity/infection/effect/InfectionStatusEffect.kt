package com.github.cao.awa.medical.disease.immunity.infection.effect

import com.github.cao.awa.medical.disease.DiseaseStatusEffect
import com.github.cao.awa.medical.disease.immunity.infection.type.InfectionType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.server.world.ServerWorld

class InfectionStatusEffect(statusEffectCategory: StatusEffectCategory, color: Int, infectionType: InfectionType): DiseaseStatusEffect(statusEffectCategory, color) {

}
