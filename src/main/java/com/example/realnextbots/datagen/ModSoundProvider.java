package com.example.realnextbots.datagen;

import com.example.realnextbots.RealNextbots;
import com.example.realnextbots.nextbot.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundProvider extends SoundDefinitionsProvider {
    public ModSoundProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RealNextbots.MODID, existingFileHelper);
    }

    @Override
    public void registerSounds() {
        this.add(ModSounds.NEXTBOT_SANYA, definition()
                .with(sound(ResourceLocation.fromNamespaceAndPath(RealNextbots.MODID, "nextbot_sanya")))
                .subtitle("sound.realnextbots.nextbot_sanya"));
    }
}
