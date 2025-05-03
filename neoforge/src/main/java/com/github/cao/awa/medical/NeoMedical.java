package com.github.cao.awa.medical;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("medical")
public final class NeoMedical {
    private Logger LOGGER = LogManager.getLogger("MedicalNeoForge");

    public NeoMedical(IEventBus modEventBus) {
        Medical.init();

        LOGGER.info("Loading medical on NeoForge");

        NeoForge.EVENT_BUS.register(this);
    }
}
