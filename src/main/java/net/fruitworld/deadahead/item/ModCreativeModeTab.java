package net.fruitworld.deadahead.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab DEAD_TAB = new CreativeModeTab("deadtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SCRAP_METAL.get());
        }
    };
}
