package net.ramgames.btp.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ramgames.btp.BeyondThePast;
import net.ramgames.btp.items.ModItemGroups;

public class ModBlocks {


    public static final Block GRIMSTONE = registerBlock("grimstone", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).resistance(3600000f)), ModItemGroups.BTP_GROUP);
    public static final Block POLISHED_GRIMSTONE = registerBlock("polished_grimstone", new Block(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE).resistance(3600000f)), ModItemGroups.BTP_GROUP);
    public static final Block POLISHED_GRIMSTONE_SLAB = registerBlock("polished_grimstone_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_DEEPSLATE_SLAB).resistance(3600000f)), ModItemGroups.BTP_GROUP);
    public static final Block CITRINE_BLOCK = registerBlock("citrine_block", new AmethystBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK)), ModItemGroups.BTP_GROUP);


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
