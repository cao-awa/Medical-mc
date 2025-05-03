package com.github.cao.awa.medical.disease.immunity.wbc

import com.github.cao.awa.medical.count.SICount
import com.github.cao.awa.medical.nbt.NbtObject
import net.minecraft.nbt.NbtCompound
import kotlin.random.Random.Default.nextDouble

class WhiteBloodCount : NbtObject() {
    /**
     * Neutrocyte count.
     *
     * For details, see:
     * + [Neutrophil-to-lymphocyte ratio as a predictor of complicated acute diverticulitis: A retrospective cohort study - PMC](https://pmc.ncbi.nlm.nih.gov/articles/PMC7895691)
     * + [Neutrophil Diversity in Health and Disease - PMC](https://pmc.ncbi.nlm.nih.gov/articles/PMC7185435)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    var neutrophil: ULong = 0U

    /**
     * Eosinophil count.
     *
     * For details, see:
     * + [Blood eosinophil thresholds and exacerbations in chronic obstructive pulmonary disease - PMC](https://pmc.ncbi.nlm.nih.gov/articles/PMC5994197)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    var eosinophil: ULong = 0u

    /**
     * Basophil count.
     *
     * For details, see:
     * + [The Absolute Basophil Count - PubMed](https://pubmed.ncbi.nlm.nih.gov/32766970)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    var basophil: ULong = 0u

    /**
     * Lymphocyte count.
     *
     * For details, see:
     * + [Preoperative lymphocyte count, neutrophil to lymphocyte and platelet to lymphocyte ratio predict the recurrence with progression and cancerization in vocal fold lesions-retrospective study - PubMed](https://pubmed.ncbi.nlm.nih.gov/37744219)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    var lymphocyte: ULong = 0u

    /**
     * Monocyte count.
     *
     * For details, see:
     * + [Peripheral blood monocyte count and outcomes in patients with interstitial lung disease: a systematic review and meta-analysis - PMC](https://pmc.ncbi.nlm.nih.gov/articles/PMC10481330)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    var monocyte: ULong = 0u

    override fun readNbt(compound: NbtCompound) {
        // Read neutrocyte data.
        compound.getInt("N").ifPresentOrElse({ neutrophilCount: Int ->
            // If present when set present value.
            this.neutrophil = neutrophilCount.toULong()
        }) {
            // If not data present, generate a new one.
            healthNeutrophil()
        }

        // Read neutrocyte data.
        compound.getInt("E").ifPresentOrElse({ eosinophilCount: Int ->
            // If present when set present value.
            this.eosinophil = eosinophilCount.toULong()
        }) {
            // If not data present, generate a new one.
            healthEosinophil()
        }

        // Read basophil data.
        compound.getInt("B").ifPresentOrElse({ basophilCount: Int ->
            // If present when set present value.
            this.basophil = basophilCount.toULong()
        }) {
            // If not data present, generate a new one.
            healthBasophil()
        }

        // Read lymphocyte data.
        compound.getInt("L").ifPresentOrElse({ lymphocyteCount: Int ->
            // If present when set present value.
            this.lymphocyte = lymphocyteCount.toULong()
        }) {
            // If not data present, generate a new one.
            healthLymphocyte()
        }

        // Read monocyte data.
        compound.getInt("M").ifPresentOrElse({ monocyte: Int ->
            // If present when set present value.
            this.monocyte = monocyte.toULong()
        }) {
            // If not data present, generate a new one.
            healthMonocyte()
        }
    }

    override fun writeNbt(key: String, compound: NbtCompound) {
        val whiteBloodCount: NbtCompound = NbtCompound()

        whiteBloodCount.putLong("N", this.neutrophil.toLong())
        whiteBloodCount.putLong("E", this.eosinophil.toLong())
        whiteBloodCount.putLong("B", this.basophil.toLong())
        whiteBloodCount.putLong("L", this.lymphocyte.toLong())
        whiteBloodCount.putLong("M", this.monocyte.toLong())

        compound.put(key, whiteBloodCount)
    }

    fun healthCells() {
        // Generate the cell data in healthy human.
        healthNeutrophil()
        healthEosinophil()
        healthBasophil()
        healthLymphocyte()
        healthMonocyte()
    }

    /**
     * Generate the Neutrophil using general range (2.5~7.5 times 10^9).
     *
     * For details, see:
     * + [Neutrophil-to-lymphocyte ratio as a predictor of complicated acute diverticulitis: A retrospective cohort study - PMC](https://pmc.ncbi.nlm.nih.gov/articles/PMC7895691)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    fun healthNeutrophil(): ULong {
        // Generate the Neutrocyte using general range (2.5~7.5 times 10^9).
        this.neutrophil = SICount.GIGA.times(nextDouble(2.5, 7.5)).toULong()

        return this.neutrophil
    }

    /**
     * Generate the Eosinophil using general range (0.4~0.45 times 10^9).
     *
     * For details, see:
     * + [Blood eosinophil thresholds and exacerbations in chronic obstructive pulmonary disease - PMC](https://pmc.ncbi.nlm.nih.gov/articles/PMC5994197)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    fun healthEosinophil(): ULong {
        // Generate the Neutrocyte using general range (0.4~0.45 times 10^9).
        this.eosinophil = SICount.GIGA.times(nextDouble(0.4, 0.45)).toULong()

        return this.eosinophil
    }

    /**
     * Generate the Basophil using general range (0~0.1 times 10^9).
     *
     * For details, see:
     * + [The Absolute Basophil Count - PubMed](https://pubmed.ncbi.nlm.nih.gov/32766970)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    fun healthBasophil(): ULong {
        // Generate the Neutrocyte using general range (0~0.1 times 10^9).
        this.basophil = SICount.GIGA.times(nextDouble(0.0, 0.1)).toULong()

        return this.basophil
    }


    /**
     * Generate the Lymphocyte using general range (1.0~4.0 times 10^9).
     *
     * For details, see:
     * + [Preoperative lymphocyte count, neutrophil to lymphocyte and platelet to lymphocyte ratio predict the recurrence with progression and cancerization in vocal fold lesions-retrospective study - PubMed](https://pubmed.ncbi.nlm.nih.gov/37744219)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    fun healthLymphocyte(): ULong {
        // Generate the Neutrocyte using general range (1.0~4.0 times 10^9).
        this.lymphocyte = SICount.GIGA.times(nextDouble(1.0, 4.0)).toULong()

        return this.lymphocyte
    }

    /**
     * Generate the Monocyte using general range (0.2~1.0 times 10^9).
     *
     * For details, see:
     * + [Peripheral blood monocyte count and outcomes in patients with interstitial lung disease: a systematic review and meta-analysis - PMC](https://pmc.ncbi.nlm.nih.gov/articles/PMC10481330)
     *
     * @author cao_awa
     *
     * @since 1.0.0
     */
    fun healthMonocyte(): ULong {
        // Generate the Neutrocyte using general range (0.4~0.45 times 10^9).
        this.monocyte = SICount.GIGA.times(nextDouble(0.2, 1.0)).toULong()

        return this.monocyte
    }
}
