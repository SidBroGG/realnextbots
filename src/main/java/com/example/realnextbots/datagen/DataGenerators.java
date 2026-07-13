package com.example.realnextbots.datagen;

import net.minecraft.data.DataGenerator;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        var packOutput = generator.getPackOutput();

        generator.addProvider(event.includeClient(), new ModSoundProvider(packOutput, event.getExistingFileHelper()));
    }
}
