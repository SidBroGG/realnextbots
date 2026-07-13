package com.example.realnextbots;

import com.example.realnextbots.datagen.DataGenerators;
import com.example.realnextbots.nextbot.ModEntities;
import com.example.realnextbots.nextbot.ModSounds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(RealNextbots.MODID)
public class RealNextbots {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "realnextbots";

    public RealNextbots(IEventBus modEventBus) {
        ModEntities.ENTITIES.register(modEventBus);
        ModSounds.SOUNDS.register(modEventBus);

        modEventBus.addListener(DataGenerators::gatherData);
    }
}
