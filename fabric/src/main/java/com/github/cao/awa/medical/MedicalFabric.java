package com.github.cao.awa.medical;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.Set;

public class MedicalFabric implements ModInitializer {
    private Logger LOGGER = LogManager.getLogger("MedicalFabric");

    @Override
    public void onInitialize() {
        Medical.init();

        LOGGER.info("Loading medical on Fabric");
    }
}