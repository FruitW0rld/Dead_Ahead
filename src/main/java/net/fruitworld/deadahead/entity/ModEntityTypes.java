package net.fruitworld.deadahead.entity;

import net.fruitworld.deadahead.DeadAhead;
import net.fruitworld.deadahead.entity.custom.RunnerEntity;
import net.fruitworld.deadahead.entity.custom.WitchEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeadAhead.MOD_ID);

    public static final RegistryObject<EntityType<RunnerEntity>> RUNNER =
            ENTITY_TYPES.register("runner",
                    () -> EntityType.Builder.of(RunnerEntity::new, MobCategory.MONSTER)
                            //.sized is the hit box
                            .sized(0.5f, 1.7f)
                            .build(new ResourceLocation(DeadAhead.MOD_ID, "runner").toString()));
    public static final RegistryObject<EntityType<WitchEntity>> WITCH =
            ENTITY_TYPES.register("witch",
                    () -> EntityType.Builder.of(WitchEntity::new, MobCategory.MONSTER)
                            //.sized is the hit box
                            .sized(0.5f, 1.7f)
                            .build(new ResourceLocation(DeadAhead.MOD_ID, "witch").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
