package sheridan.gcaa.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import sheridan.gcaa.GCAA;
import sheridan.gcaa.network.PacketHandler;
import sheridan.gcaa.network.packets.s2c.ClientSoundPacket;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> MOD_SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GCAA.MODID);
    public static RegistryObject<SoundEvent> AK_MAG_OFF = registerSound("ak_mag_off", "item.generic.ak_mag_off");
    public static RegistryObject<SoundEvent> AK_MAG_ATTACH = registerSound("ak_mag_attach", "item.generic.ak_mag_attach");
    public static RegistryObject<SoundEvent> AK_CHARGE = registerSound("ak_charge", "item.generic.ak_charge");
    public static RegistryObject<SoundEvent> PISTOL_SLIDE_BACK = registerSound("pistol_slide_back", "item.generic.pistol_slide_back");
    public static RegistryObject<SoundEvent> PISTOL_SLIDE_FORWARD = registerSound("pistol_slide_forward", "item.generic.pistol_slide_forward");
    public static RegistryObject<SoundEvent> SMG_MAG_ATTACH = registerSound("smg_mag_attach", "item.generic.smg_mag_attach");
    public static RegistryObject<SoundEvent> SMG_MAG_OFF = registerSound("smg_mag_off", "item.generic.smg_mag_off");
    public static RegistryObject<SoundEvent> AWP_MAG_OFF = registerSound("awp_mag_off", "item.generic.awp_mag_off");
    public static RegistryObject<SoundEvent> AWP_MAG_ATTACH = registerSound("awp_mag_attach", "item.generic.awp_mag_attach");
    public static RegistryObject<SoundEvent> AWP_BOLT_BACK = registerSound("awp_bolt_back", "item.generic.awp_bolt_back");
    public static RegistryObject<SoundEvent> AWP_BOLT_FORWARD = registerSound("awp_bolt_forward", "item.generic.awp_bolt_forward");
    public static RegistryObject<SoundEvent> M870_INSERT_SHELL = registerSound("m870_insert_shell", "item.generic.m870_insert_shell");
    public static RegistryObject<SoundEvent> M870_PUMP_ACTION = registerSound("m870_pump_action", "item.generic.m870_pump_action");
    public static RegistryObject<SoundEvent> MG_BOX_ATTACH = registerSound("mg_box_attach", "item.generic.mg_box_attach");
    public static RegistryObject<SoundEvent> MG_BOX_OFF = registerSound("mg_box_off", "item.generic.mg_box_off");
    public static RegistryObject<SoundEvent> MG_CHAIN = registerSound("mg_chain", "item.generic.mg_chain");
    public static RegistryObject<SoundEvent> MG_CHARGE_BACK = registerSound("mg_charge_back", "item.generic.mg_charge_back");
    public static RegistryObject<SoundEvent> MG_CHARGE_FROWARD = registerSound("mg_charge_forward", "item.generic.mg_charge_forward");
    public static RegistryObject<SoundEvent> MG_COVER_OFF = registerSound("mg_cover_off", "item.generic.mg_cover_off");
    public static RegistryObject<SoundEvent> MG_COVER_OPEN = registerSound("mg_cover_open", "item.generic.mg_cover_open");
    public static RegistryObject<SoundEvent> GP_25_FIRE = registerSound("gp_25_fire", "item.generic.gp_25_fire");
    public static RegistryObject<SoundEvent> GP_25_INSERT_GRENADE = registerSound("gp_25_insert_grenade", "item.generic.gp_25_insert_grenade");
    public static RegistryObject<SoundEvent> AR_BOLT_RELEASE = registerSound("ar_bolt_release", "item.generic.ar_bolt_release");
    public static RegistryObject<SoundEvent> AR_MAG_OFF = registerSound("ar_mag_off", "item.generic.ar_mag_off");
    public static RegistryObject<SoundEvent> AR_MAG_ATTACH = registerSound("ar_mag_attach", "item.generic.ar_mag_attach");
    public static RegistryObject<SoundEvent> PISTOL_MAG_OFF = registerSound("pistol_mag_off", "item.generic.pistol_mag_off");
    public static RegistryObject<SoundEvent> PISTOL_MAG_ATTACH = registerSound("pistol_mag_attach", "item.generic.pistol_mag_attach");
    public static RegistryObject<SoundEvent> AR_CHARGE_BACK = registerSound("ar_charge_back", "item.generic.ar_charge_back");
    public static RegistryObject<SoundEvent> AR_CHARGE_FROWARD = registerSound("ar_charge_forward", "item.generic.ar_charge_forward");
    public static RegistryObject<SoundEvent> NI_GAN_MA = registerSound("ni_gan_ma", "item.generic.ni_gan_ma");
    public static RegistryObject<SoundEvent> DEAL = registerSound("deal", "item.generic.deal");
    public static RegistryObject<SoundEvent> AK12_MAG_OFF = registerSound("ak12_mag_off", "item.generic.ak12_mag_off");
    public static RegistryObject<SoundEvent> AK12_MAG_ATTACH = registerSound("ak12_mag_attach", "item.generic.ak12_mag_attach");


    public static RegistryObject<SoundEvent> MG_UNLOAD = registerSound("mg_unload", "item.generic.mg_unload");
    public static RegistryObject<SoundEvent> PISTOL_UNLOAD = registerSound("pistol_unload", "item.generic.pistol_unload");
    public static RegistryObject<SoundEvent> SHOTGUN_UNLOAD = registerSound("shotgun_unload", "item.generic.shotgun_unload");
    public static RegistryObject<SoundEvent> SMG_UNLOAD = registerSound("smg_unload", "item.generic.smg_unload");
    public static RegistryObject<SoundEvent> SNIPER_UNLOAD = registerSound("sniper_unload", "item.generic.sniper_unload");
    public static RegistryObject<SoundEvent> CAL_50_UNLOAD = registerSound("cal_50_unload", "item.generic.cal_50_unload");
    public static RegistryObject<SoundEvent> RIFLE_UNLOAD = registerSound("rifle_unload", "item.generic.rifle_unload");
    public static RegistryObject<SoundEvent> REVOLVER_UNLOAD = registerSound("revolver_unload", "item.generic.revolver_unload");


    public static RegistryObject<SoundEvent> AKM_FIRE = registerSound("akm_fire", "item.akm.fire");
    public static RegistryObject<SoundEvent> M4A1_FIRE = registerSound("m4a1_fire", "item.m4a1.fire");
    public static RegistryObject<SoundEvent> G19_FIRE = registerSound("g19_fire", "item.g19.fire");
    public static RegistryObject<SoundEvent> AWP_FIRE = registerSound("awp_fire", "item.awp.fire");
    public static RegistryObject<SoundEvent> AWP_FIRE_SUPPRESSED = registerSound("awp_fire_suppressed", "item.awp.fire_suppressed");
    public static RegistryObject<SoundEvent> M870_FIRE = registerSound("m870_fire", "item.m870.fire");
    public static RegistryObject<SoundEvent> M870_FIRE_SUPPRESSED = registerSound("m870_fire_suppressed", "item.m870.fire_suppressed");
    public static RegistryObject<SoundEvent> PYTHON_357_FIRE = registerSound("python_357_fire", "item.python_357.fire");
    public static RegistryObject<SoundEvent> M249_FIRE = registerSound("m249_fire", "item.m249.fire");
    public static RegistryObject<SoundEvent> PYTHON_357_BULLETS_IN = registerSound("bullets_in", "item.python_357.bullets_in");
    public static RegistryObject<SoundEvent> PYTHON_357_BULLETS_OUT = registerSound("bullets_out", "item.python_357.bullets_out");
    public static RegistryObject<SoundEvent> PYTHON_357_MAG_OPEN = registerSound("mag_open", "item.python_357.mag_open");
    public static RegistryObject<SoundEvent> PYTHON_357_MAG_CLOSE = registerSound("mag_close", "item.python_357.mag_close");
    public static RegistryObject<SoundEvent> VECTOR_45_FIRE = registerSound("vector_45_fire", "item.vector_45.fire");
    public static RegistryObject<SoundEvent> XM1014_FIRE = registerSound("xm1014_fire", "item.xm1014.fire");
    public static RegistryObject<SoundEvent> XM1014_FIRE_SUPPRESSED = registerSound("xm1014_fire_suppressed", "item.xm1014.fire_suppressed");
    public static RegistryObject<SoundEvent> XM1014_INSERT_SHELL = registerSound("xm1014_insert_shell", "item.xm1014.insert_shell");
    public static RegistryObject<SoundEvent> MK47_FIRE = registerSound("mk47_fire", "item.mk47.fire");
    public static RegistryObject<SoundEvent> HK_G28_FIRE = registerSound("hk_g28", "item.hk_g28.fire");
    public static RegistryObject<SoundEvent> AK12_FIRE = registerSound("ak12_fire", "item.ak12.fire");
    public static RegistryObject<SoundEvent> BERETTA_686_OPEN = registerSound("open", "item.beretta_686.open");
    public static RegistryObject<SoundEvent> BERETTA_686_CLOSE = registerSound("close", "item.beretta_686.close");
    public static RegistryObject<SoundEvent> BERETTA_686_FIRE = registerSound("beretta_fire", "item.beretta_686.fire");
    public static RegistryObject<SoundEvent> BERETTA_686_FIRE_VOLLEY = registerSound("beretta_fire_volley", "item.beretta_686.fire_volley");
    public static RegistryObject<SoundEvent> ANNIHILATOR_FIRE = registerSound("annihilator_fire", "item.annihilator.fire");
    public static RegistryObject<SoundEvent> ANNIHILATOR_CHARGE = registerSound("annihilator_charge", "item.annihilator.annihilator_charge");
    public static RegistryObject<SoundEvent> ANNIHILATOR_MAG_OFF = registerSound("annihilator_mag_off", "item.annihilator.annihilator_mag_off");
    public static RegistryObject<SoundEvent> ANNIHILATOR_MAG_ATTACH = registerSound("annihilator_mag_attach", "item.annihilator.annihilator_mag_attach");


    public static RegistryObject<SoundEvent> HEADSHOT_1 = registerSound("headshot_1", "effect.headshot.1");
    public static RegistryObject<SoundEvent> HEADSHOT_2 = registerSound("headshot_2", "effect.headshot.2");
    public static RegistryObject<SoundEvent> HEADSHOT_3 = registerSound("headshot_3", "effect.headshot.3");
    public static RegistryObject<SoundEvent>[] HEADSHOT_SOUNDS = new RegistryObject[] {
            HEADSHOT_1, HEADSHOT_2, HEADSHOT_3
    };
    private static RegistryObject<SoundEvent> registerSound(String name, String path) {
        return MOD_SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GCAA.MODID, path)));
    }

    public static void register(IEventBus bus) {
        MOD_SOUNDS.register(bus);
    }

    /**
     * play a sound immediately.
     * */
    public static void sound(float vol, float pit, Player player, SoundEvent soundEvent) {
        player.playSound(soundEvent, vol, pit);
    }

    /**
     * play a sound immediately.
     * @param name the registry path of the sound event. such as: new ResourceLocation(your_mod.MODID, name).
     *             the "name" is the name when a sound event registered, not the key of this sound event in sounds.json.
     *             like: ForgeRegistries.SOUND_EVENTS.getKey(soundEvent)
     * */
    public static void sound(float vol, float pit, Player player, ResourceLocation name) {
        SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(name);
        if (soundEvent != null) {
            sound(vol, pit, player, soundEvent);
        }
    }

    public static void boardCastSound(SoundEvent soundEvent, float vol, float volModify, float pitch, ServerPlayer player) {
        if (soundEvent == null) {
            return;
        }
        ResourceLocation key = ForgeRegistries.SOUND_EVENTS.getKey(soundEvent);
        if (key != null) {
            boardCastSound(key.toString(), soundEvent.getRange(vol), vol, volModify, pitch, player);
        }
    }

    public static void boardCastSound(String name, float range, float vol, float volModify, float pitch, ServerPlayer player) {
        PacketHandler.simpleChannel.send(PacketDistributor.NEAR.with(() -> new PacketDistributor.TargetPoint(
                player, player.position().x, player.position().y, player.position().z, range, player.level().dimension()
        )), new ClientSoundPacket(vol, volModify, pitch, player.position(), name));
    }

    public static void soundAtPoint(float vol, float pit, float x, float y, float z, Player player, ResourceLocation name) {
        SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(name);
        if (soundEvent != null) {
            player.level().playSound(player, x, y, z, soundEvent, player.getSoundSource(), vol, pit);
        }
    }
}
