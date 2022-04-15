package me.declipsonator.noautojump;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class NoAutojump implements ModInitializer {
    public static Logger LOG = LogManager.getLogger("NoAutojump");

    @Override
    public void onInitialize() {
        LOG.info("NoAutojump has been initialized!");
    }

}
