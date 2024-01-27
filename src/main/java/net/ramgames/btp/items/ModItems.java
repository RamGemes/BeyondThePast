package net.ramgames.btp.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.ramgames.btp.BeyondThePast;
import org.jetbrains.annotations.Nullable;

public class ModItems {

    public static final Item CITRINE_SHARD = registerItem("citrine_shard", new Item(new FabricItemSettings()), ModItemGroups.BTP_GROUP);
    public static final Item TOPAZ_SHARD = registerItem("topaz_shard", new Item(new FabricItemSettings()), ModItemGroups.BTP_GROUP);

    private static Item registerItem(String name, Item item, @Nullable ItemGroup tab) {
        Registry.register(Registries.ITEM, new Identifier(BeyondThePast.MOD_ID,name),item);
        if(tab != null) ModItemGroups.appendToTab(item,tab);
        return item;
    }

    public static void registerModItems() {
        BeyondThePast.LOGGER.debug("Registering items for mod: "+BeyondThePast.MOD_ID);
    }
}
