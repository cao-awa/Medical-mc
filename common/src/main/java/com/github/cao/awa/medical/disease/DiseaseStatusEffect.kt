package com.github.cao.awa.medical.disease

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.server.world.ServerWorld

abstract class DiseaseStatusEffect(statusEffectCategory: StatusEffectCategory, color: Int): StatusEffect(statusEffectCategory, color) {
    override fun applyUpdateEffect(world: ServerWorld, entity: LivingEntity, amplifier: Int): Boolean {
        return true
    }

    override fun canApplyUpdateEffect(duration: Int, amplifier: Int): Boolean {
        val i = 25 shr amplifier
        return if (i > 0) {
            duration % i == 0
        } else {
            true
        }
    }
}