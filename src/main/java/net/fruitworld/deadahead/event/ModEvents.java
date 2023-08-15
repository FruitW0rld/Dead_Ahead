package net.fruitworld.deadahead.event;

import net.fruitworld.deadahead.DeadAhead;
import net.fruitworld.deadahead.entity.ModEntityTypes;
import net.fruitworld.deadahead.entity.custom.RunnerEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = DeadAhead.MOD_ID)
    public static class ForgeEvents {

    }
    @Mod.EventBusSubscriber(modid = DeadAhead.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void  entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.RUNNER.get(), RunnerEntity.setAttributes());
        }
    }
}
