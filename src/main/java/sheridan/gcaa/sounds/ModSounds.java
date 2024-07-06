package sheridan.gcaa.sounds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import sheridan.gcaa.GCAA;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> MOD_SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GCAA.MODID);
    public static RegistryObject<SoundEvent> AKM_FIRE = registerSound("akm_fire", "item.akm.fire");
    public static RegistryObject<SoundEvent> G19_FIRE = registerSound("g19_fire", "item.g19.fire");

    private static RegistryObject<SoundEvent> registerSound(String name, String path) {
        return MOD_SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GCAA.MODID, path)));
    }

    public static void register(IEventBus bus) {
        MOD_SOUNDS.register(bus);
    }

    /**
     * play a sound immediately in client side.
     * */
    @OnlyIn(Dist.CLIENT)
    public static void clientSound(float vol, float pit, Player player, SoundEvent soundEvent) {
        player.playSound(soundEvent, vol, pit);
    }

    /**
     * play a sound immediately in client side by given path.
     * @param name the registry path of the sound event. such as: new ResourceLocation(your_mod.MODID, name).
     *             the "name" is the name then a sound event registered, not the key of this sound event in sounds.json.
     * */
    @OnlyIn(Dist.CLIENT)
    public static void clientSound(float vol, float pit, Player player, ResourceLocation name) {
        SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(name);
        if (soundEvent != null) {
            clientSound(vol, pit, player, soundEvent);
        }
    }
}
