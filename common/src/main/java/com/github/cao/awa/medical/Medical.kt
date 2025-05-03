package com.github.cao.awa.medical

import com.github.cao.awa.medical.effect.MedicalEffects
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Medical {
    private val LOGGER: Logger = LogManager.getLogger("Medical")

    @JvmStatic
    fun init() {
        LOGGER.info("Loading medical core")

        LOGGER.info("Registering medical effects")
        MedicalEffects.init()
    }
}