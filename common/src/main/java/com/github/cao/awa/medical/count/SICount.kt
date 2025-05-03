package com.github.cao.awa.medical.count

/**
 * A benefit of the SI (International System of Units) is that written technical information is effectively communicated,
 * transcending the variations of language – including spelling and pronunciation.
 *
 * Values of quantities are expressed using Arabic symbols for numbers paired with a unit symbol, often with a prefix symbol that modifies unit magnitude.
 *
 * For details, see: <br></br>
 * + [Metric (SI) Prefixes | NIST](https://www.nist.gov/pml/owm/metric-si-prefixes)
 *
 * @author cao_awa
 *
 * @since 1.0.0
 */
object SICount {
    /**
     * SI: ``billion``.
     *
     * @since 1.0.0
     */
    @JvmField
    val GIGA: Int = 1000000000

    /**
     * SI: ``million``.
     *
     * @since 1.0.0
     */
    @JvmField
    val MEGA: Int = 1000000

    /**
     * SI: ``thousand``.
     *
     * @since 1.0.0
     */
    @JvmField
    val KILO: Int = 1000
}
