package com.example.realnextbots.event;

import com.example.realnextbots.RealNextbots;
import com.example.realnextbots.nextbot.ModEntities;
import com.example.realnextbots.nextbot.NextbotRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = RealNextbots.MODID, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SANYA.get(), NextbotRenderer::new);
    }
}
