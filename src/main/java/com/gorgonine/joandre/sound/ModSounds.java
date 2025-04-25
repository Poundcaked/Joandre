package com.gorgonine.joandre.sound;

import com.gorgonine.joandre.Joandre;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent EWWW = registerSoundEvent("ewww");

    public static final SoundEvent GULCH_YOU_AGAIN = registerSoundEvent("gulch_you_again");
    public static final RegistryKey<JukeboxSong> GULCH_YOU_AGAIN_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Joandre.MOD_ID,"gulch_you_again"));

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(Joandre.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){

    }
}
