package com.example.realnextbots.event;

import com.example.realnextbots.RealNextbots;
import com.example.realnextbots.nextbot.ModEntities;
import com.example.realnextbots.nextbot.NextbotEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = RealNextbots.MODID)
public class CommomModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SANYA.get(), NextbotEntity.createAttributes().build());
    }
}
