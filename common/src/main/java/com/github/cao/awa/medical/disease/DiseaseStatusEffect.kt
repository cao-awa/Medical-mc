package com.github.cao.awa.medical.disease

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.server.world.ServerWorld

abstract class DiseaseStatusEffect(statusEffectCategory: StatusEffectCategory?, i: Int): StatusEffect(statusEffectCategory, i) {
    override fun applyUpdateEffect(world: ServerWorld, entity: LivingEntity, amplifier: Int): Boolean {
        if (entity.health > 1.0f) {
            entity.damage(world, entity.damageSources.magic(), 1.0f)
        }

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