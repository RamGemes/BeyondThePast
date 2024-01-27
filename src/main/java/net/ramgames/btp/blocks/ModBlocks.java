package net.ramgames.btp.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ramgames.btp.BeyondThePast;
import net.ramgames.btp.blocks.custom.BuddingBlock;
import net.ramgames.btp.items.ModItemGroups;

public class ModBlocks {


    public static final Block GRIMSTONE = registerBlock("grimstone", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).resistance(3600000f)), ModItemGroups.BTP_GROUP);
    public static final Block POLISHED_GRIMSTONE = registerBlock("polished_grimstone", new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE).resistance(3600000f)), ModItemGroups.BTP_GROUP);
    public static final Block POLISHED_GRIMSTONE_SLAB = registerBlock("polished_grimstone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE_SLAB).resistance(3600000f)), ModItemGroups.BTP_GROUP);
    public static final Block CITRINE_BLOCK = registerBlock("citrine_block", new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)), ModItemGroups.BTP_GROUP);
    public static final Block TOPAZ_BLOCK = registerBlock("topaz_block", new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)), ModItemGroups.BTP_GROUP);

    public static final Block CITRINE_CLUSTER = registerBlock("citrine_cluster", new AmethystClusterBlock(7, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)), ModItemGroups.BTP_GROUP);
    public static final Block LARGE_CITRINE_BUD = registerBlock("large_citrine_bud", new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)), ModItemGroups.BTP_GROUP);
    public static final Block MEDIUM_CITRINE_BUD = registerBlock("medium_citrine_bud", new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)), ModItemGroups.BTP_GROUP);
    public static final Block SMALL_CITRINE_BUD = registerBlock("small_citrine_bud", new AmethystClusterBlock(3, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)), ModItemGroups.BTP_GROUP);

    public static final Block BUDDING_CITRINE_BLOCK = registerBlock("budding_citrine_block", new BuddingBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK), SMALL_CITRINE_BUD, MEDIUM_CITRINE_BUD, LARGE_CITRINE_BUD, CITRINE_CLUSTER), ModItemGroups.BTP_GROUP);

    public static final Block TOPAZ_CLUSTER = registerBlock("topaz_cluster", new AmethystClusterBlock(7, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)), ModItemGroups.BTP_GROUP);
    public static final Block LARGE_TOPAZ_BUD = registerBlock("large_topaz_bud", new AmethystClusterBlock(5, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)), ModItemGroups.BTP_GROUP);
    public static final Block MEDIUM_TOPAZ_BUD = registerBlock("medium_topaz_bud", new AmethystClusterBlock(4, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)), ModItemGroups.BTP_GROUP);
    public static final Block SMALL_TOPAZ_BUD = registerBlock("small_topaz_bud", new AmethystClusterBlock(3, 3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER)), ModItemGroups.BTP_GROUP);

    public static final Block BUDDING_TOPAZ_BLOCK = registerBlock("budding_topaz_block", new BuddingBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK), SMALL_TOPAZ_BUD, MEDIUM_TOPAZ_BUD, LARGE_TOPAZ_BUD, TOPAZ_CLUSTER), ModItemGroups.BTP_GROUP);

    private static void registerBlockItem(String name, Block block, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(BeyondThePast.MOD_ID,name), new BlockItem(block, new FabricItemSettings()));
        if(tab != null) ModItemGroups.appendToTab(item,tab);
    }

    private static Block registerBlock(String name,Block block, ItemGroup tab) {
        registerBlockItem(name,block,tab);
        return Registry.register(Registries.BLOCK, new Identifier(BeyondThePast.MOD_ID,name), block);

    }


    public static void registerBlocks(){
        BeyondThePast.LOGGER.debug("Registering Mod Blocks for "+ BeyondThePast.MOD_ID);
    }
}
