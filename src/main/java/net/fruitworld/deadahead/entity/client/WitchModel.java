package net.fruitworld.deadahead.entity.client;

import net.fruitworld.deadahead.DeadAhead;
import net.fruitworld.deadahead.entity.custom.WitchEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WitchModel extends AnimatedGeoModel<WitchEntity> {
    @Override
    public ResourceLocation getModelResource(WitchEntity object) {
        return new ResourceLocation(DeadAhead.MOD_ID, "geo/witch.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WitchEntity object) {
        return new ResourceLocation(DeadAhead.MOD_ID, "textures/entity/witch.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WitchEntity animatable) {
        return new ResourceLocation(DeadAhead.MOD_ID, "animations/witch.animation.json");
    }
}
