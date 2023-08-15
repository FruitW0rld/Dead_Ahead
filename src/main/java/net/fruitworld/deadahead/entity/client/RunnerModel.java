package net.fruitworld.deadahead.entity.client;

import net.fruitworld.deadahead.DeadAhead;
import net.fruitworld.deadahead.entity.custom.RunnerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RunnerModel extends AnimatedGeoModel<RunnerEntity> {
    @Override
    public ResourceLocation getModelResource(RunnerEntity object) {
        return new ResourceLocation(DeadAhead.MOD_ID, "geo/runner.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RunnerEntity object) {
        return new ResourceLocation(DeadAhead.MOD_ID, "textures/entity/runner.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RunnerEntity animatable) {
        return new ResourceLocation(DeadAhead.MOD_ID, "animations/runner.animation.json");
    }
}
