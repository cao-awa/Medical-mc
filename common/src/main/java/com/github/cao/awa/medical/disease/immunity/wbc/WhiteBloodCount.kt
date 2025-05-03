package com.github.cao.awa.medical.disease.immunity.wbc

import com.github.cao.awa.medical.count.SICount
import kotlin.random.Random
import kotlin.random.nextUInt

class WhiteBloodCount {
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
    var neutrocyte: UInt = 0U
    var eosinophil: UInt = 0u

    fun generateRandomly() {
        // Generate the Neutrocyte using general range (2.5~7.5 times 10^9).
        //
        // For details, see:
        // + https://pmc.ncbi.nlm.nih.gov/articles/PMC7895691
        this.neutrocyte = Random.nextDouble(2.5, 7.5).times(SICount.GIGA).toUInt()

        // Generate the Neutrocyte using general range (0.4~0.45 times 10^9).
        //
        // For details, see:
        // + https://pmc.ncbi.nlm.nih.gov/articles/PMC5994197/
        this.eosinophil = Random.nextDouble(0.4, 0.45).times(SICount.GIGA).toUInt()
    }
}
