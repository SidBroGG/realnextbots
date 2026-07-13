package com.example.realnextbots.nextbot;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

public class NextbotRenderer extends EntityRenderer<NextbotEntity> {
    private static final float SIZE = 4F;

    public NextbotRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    private static void vertex(VertexConsumer consumer, Matrix4f poseMatrix, int packedLight, float x, float y, float u, float v) {
        consumer.addVertex(poseMatrix, x, y, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(packedLight)
                .setNormal(0.0F, 1.0F, 0.0F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull NextbotEntity entity) {
        return entity.getTextureLocation();
    }

    @Override
    public void render(@NotNull NextbotEntity entity, float entityYaw, float partialTick, PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        // poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));

        poseStack.translate(0.0F, SIZE / 2, 0.0F);
        poseStack.scale(SIZE, SIZE, SIZE);

        Matrix4f poseMatrix = poseStack.last().pose();
        VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(getTextureLocation(entity)));

        vertex(consumer, poseMatrix, packedLight, -0.5F, -0.5F, 0.0F, 1.0F);
        vertex(consumer, poseMatrix, packedLight, 0.5F, -0.5F, 1.0F, 1.0F);
        vertex(consumer, poseMatrix, packedLight, 0.5F, 0.5F, 1.0F, 0.0F);
        vertex(consumer, poseMatrix, packedLight, -0.5F, 0.5F, 0.0F, 0.0F);

        poseStack.popPose();
        super.render(entity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }
}
