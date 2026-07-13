package com.example.realnextbots.nextbot;

import com.example.realnextbots.RealNextbots;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, RealNextbots.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<NextbotEntity>> SANYA = ENTITIES.register(
            "nextbot_sanya",
            () -> EntityType.Builder
                    .of((EntityType<NextbotEntity> entityType, Level level) -> new NextbotEntity(entityType, level, "nextbot_sanya"), MobCategory.MONSTER)
                    .sized(1.0F, 2.5F)
                    .build("nextbot_sanya")
    );


    private ModEntities() {
    }
}
