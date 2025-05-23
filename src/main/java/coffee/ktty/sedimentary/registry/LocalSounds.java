package coffee.ktty.sedimentary.registry;


import coffee.ktty.sedimentary.util.Translation;
import coffee.ktty.sedimentary.util.generators.SedimentaryLanguageProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import org.jetbrains.annotations.NotNull;

import static coffee.ktty.sedimentary.Sedimentary.LOGGER;
import static coffee.ktty.sedimentary.util.Shorthand.id;

/**
 * A class responsible for registering sounds
 */
public class LocalSounds {

    public static final SoundEvent GRIND;

    static {
        GRIND = register("grinder_run", "Grinder runs");
    }

    /**
     * Registers a new sound.
     *
     * @param name the name of the sound as defined in sounds.json
     */
    public static SoundEvent register(@NotNull String name, String subtitle) {
        SedimentaryLanguageProvider.translations.add(new Translation("subtitles.sedimentary." + name, subtitle));


        return Registry.register(Registries.SOUND_EVENT, id(name), SoundEvent.of(id(name)));
    }

    /**
     * Initializes the sound registry
     */
    public static void initialize() {
        LOGGER.info("[SoundRegistry] Registering sounds...");
    }
}
