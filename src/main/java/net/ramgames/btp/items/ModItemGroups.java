package net.ramgames.btp.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.ramgames.btp.BeyondThePast;
import net.ramgames.btp.blocks.ModBlocks;

import java.util.LinkedHashMap;
import java.util.function.Supplier;

public interface ModItemGroups {
    LinkedHashMap<Item,ItemGroup> ItemsToGroup = new LinkedHashMap<>();
    ItemGroup BTP_GROUP = registerItemGroup("leaper_group","Beyond The Past", () -> new ItemStack(ModBlocks.GRIMSTONE.asItem()));
    static void onInitialize() {
        ItemsToGroup.forEach((item, group) -> {
            ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(group).get()).register(entries -> entries.add(item));
        });
    }
    private static ItemGroup registerItemGroup(String path,String name, Supplier<ItemStack> icon) {
        ItemGroup group = FabricItemGroup.builder().icon(icon).displayName(Text.translatable(name)).build();
        Registry.register(Registries.ITEM_GROUP, new Identifier(BeyondThePast.MOD_ID,path), group);
        return group;
    }
    static void appendToTab(Item item, ItemGroup group) {
        ItemsToGroup.put(item,group);
    }
}
