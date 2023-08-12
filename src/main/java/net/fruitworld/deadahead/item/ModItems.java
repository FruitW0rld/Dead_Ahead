package net.fruitworld.deadahead.item;

import net.fruitworld.deadahead.DeadAhead;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeadAhead.MOD_ID);

    public static final RegistryObject<Item> SCRAP_METAL = ITEMS.register("scrap_metal",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DEAD_TAB)));
    public static final RegistryObject<Item> METAL_PLATE = ITEMS.register("metal_plate",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DEAD_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
