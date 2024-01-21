package net.ramgames.btp;

import net.fabricmc.api.ModInitializer;
import net.ramgames.btp.blocks.ModBlocks;
import net.ramgames.btp.items.ModItemGroups;
import net.ramgames.btp.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeyondThePast implements ModInitializer {

    public static final String MOD_ID = "btp";
    public static final Logger LOGGER = LoggerFactory.getLogger("Beyond The Past");

    @Override
    public void onInitialize() {
        LOGGER.info("Beyond the Past has begun loading...");
        ModBlocks.registerBlocks();
        ModItems.registerModItems();
        ModItemGroups.onInitialize();
        LOGGER.info("Beyond the Past has finished loading!");
    }
}
