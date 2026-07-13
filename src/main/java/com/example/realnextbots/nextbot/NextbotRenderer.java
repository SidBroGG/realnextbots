package com.example.realnextbots.nextbot;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class NextbotRenderer extends EntityRenderer<NextbotEntity> {
    private static final float SIZE = 2.5F;

    public NextbotRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull NextbotEntity entity) {
        return entity.getTextureLocation();
    }

    @Override
    public void render(@NotNull NextbotEntity entity, float entityYaw, float partialTick, PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.scale(SIZE, SIZE, SIZE);

        VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
    }
}
