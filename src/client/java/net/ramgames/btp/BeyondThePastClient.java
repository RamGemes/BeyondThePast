package net.ramgames.btp;

import net.fabricmc.api.ClientModInitializer;
import net.ramgames.btp.blocks.ModBlockRenderLayers;
import net.ramgames.btp.blocks.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeyondThePastClient implements ClientModInitializer {

    public static final String MOD_ID = "btp";
    public static final Logger LOGGER = LoggerFactory.getLogger("Beyond The Past) (Client");
    @Override
    public void onInitializeClient() {
        LOGGER.info("BTP Client has begun loading...");
        ModBlockRenderLayers.registerNonFull(
                ModBlocks.POLISHED_GRIMSTONE_SLAB
        );
        LOGGER.info("BTP Client has finished loading!");
    }
}
