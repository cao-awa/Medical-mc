package com.github.cao.awa.medical.effect

import com.github.cao.awa.medical.disease.immunity.infection.effect.InfectionStatusEffect
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectCategory
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.util.Identifier

object MedicalEffects {
    fun init() {
        // Nothing here.
    }

    private fun register(id: String, statusEffect: StatusEffect): RegistryEntry<StatusEffect> {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of("medical", id), statusEffect)
    }

    val BACTERIAL_INFECTION: RegistryEntry<StatusEffect> =
        register("bacterial_infection", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
    val VIRAL_INFECTION: RegistryEntry<StatusEffect> =
        register("viral_infection", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
    val CYTOKINE_STORM: RegistryEntry<StatusEffect> =
        register("cytokine_storm", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
    val RHABDMYOLYSIS: RegistryEntry<StatusEffect> =
        register("rhabdomyolysis", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
    val DIARRHEA: RegistryEntry<StatusEffect> =
        register("diarrhea", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
    val VOMITING: RegistryEntry<StatusEffect> =
        register("vomiting", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
    val BLEEDING: RegistryEntry<StatusEffect> =
        register("bleeding", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
    val RESPIRATORY_FAILURE: RegistryEntry<StatusEffect> =
        register("respiratory_failure", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
    val HYPOVOLEMIC_SHOCK: RegistryEntry<StatusEffect> =
        register("hypovolemia", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
    val SHOCK: RegistryEntry<StatusEffect> =
        register("shock", InfectionStatusEffect(StatusEffectCategory.HARMFUL, 8889187))
}