package com.example.realnextbots.nextbot;

import com.example.realnextbots.RealNextbots;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, RealNextbots.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> NEXTBOT_SANYA = SOUNDS.register(
            "nextbot_sanya",
            () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(RealNextbots.MODID, "nextbot_sanya"))
    );
}
