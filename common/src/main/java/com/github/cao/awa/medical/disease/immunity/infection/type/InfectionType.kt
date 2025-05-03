package com.github.cao.awa.medical.disease.immunity.infection.type

import com.github.cao.awa.medical.disease.immunity.infection.effect.InfectionStatusEffect
import com.github.cao.awa.medical.effect.MedicalEffects
import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.entry.RegistryEntry
import net.minecraft.util.Util
import net.minecraft.util.math.random.Random
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.util.function.Function
import java.util.function.Supplier

enum class InfectionType(
    val effectType: () -> RegistryEntry<StatusEffect>,
    private val instanceSupplier: (Int) -> StatusEffectInstance,
    private val limitAmplifier: Int
) {
    BACTERIAL_INFECTION(
        { MedicalEffects.BACTERIAL_INFECTION },
        {
            StatusEffectInstance(MedicalEffects.BACTERIAL_INFECTION, -1, it)
        },
        5
    ),
    VIRAL_INFECTION(
        { MedicalEffects.VIRAL_INFECTION },
        {
            StatusEffectInstance(MedicalEffects.VIRAL_INFECTION, -1, it)
        },
        5
    );

    companion object {
        private val LOGGER: Logger = LogManager.getLogger("InfectionType")

        @JvmStatic
        fun get(random: Random): InfectionType = Util.getRandom(InfectionType.entries.toTypedArray(), random)
    }

    fun getInfectionInstance(amplifier: Int): StatusEffectInstance {
        var applyAmplifier = amplifier

        // Check the limits.
        if (amplifier > this.limitAmplifier) {
            LOGGER.info("Cannot give the infection amplifier more than {}, using limit value", this.limitAmplifier)
            applyAmplifier = this.limitAmplifier
        }

        // Apply the amplifier.
        return this.instanceSupplier(applyAmplifier)
    }
}