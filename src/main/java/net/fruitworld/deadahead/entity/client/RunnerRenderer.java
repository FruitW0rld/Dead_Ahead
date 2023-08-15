package net.fruitworld.deadahead.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fruitworld.deadahead.DeadAhead;
import net.fruitworld.deadahead.entity.custom.RunnerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class RunnerRenderer extends GeoEntityRenderer<RunnerEntity> {
    public RunnerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RunnerModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull RunnerEntity instance) {
        return new ResourceLocation(DeadAhead.MOD_ID, "textures/entity/runner.png");
    }

    @Override
    public RenderType getRenderType(RunnerEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}


