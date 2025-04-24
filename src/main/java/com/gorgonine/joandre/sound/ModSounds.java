package com.gorgonine.joandre.sound;

import com.gorgonine.joandre.Joandre;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent EWWW = registerSoundEvent("ewww");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(Joandre.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){

    }
}
