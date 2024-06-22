package sheridan.gcaa;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import sheridan.gcaa.capability.PlayerStatusProvider;
import sheridan.gcaa.client.ClientWeaponLooper;
import sheridan.gcaa.client.ClientWeaponStatus;
import sheridan.gcaa.client.model.guns.AkmModel;
import sheridan.gcaa.client.model.guns.G19Model;
import sheridan.gcaa.client.model.registry.GunModelRegistry;
import sheridan.gcaa.client.render.DisplayData;
import sheridan.gcaa.items.ModItems;
import sheridan.gcaa.items.guns.IGun;
import sheridan.gcaa.items.guns.IGunFireMode;

import java.util.Timer;
import java.util.concurrent.locks.ReentrantLock;

import static sheridan.gcaa.client.render.DisplayData.DataType.POS;
import static sheridan.gcaa.client.render.DisplayData.DataType.ROT;
import static sheridan.gcaa.client.render.DisplayData.DataType.SCALE;

public class Clients {
    @OnlyIn(Dist.CLIENT)
    public static ClientWeaponStatus mainHandStatus = new ClientWeaponStatus(true);
    @Deprecated
    @OnlyIn(Dist.CLIENT)
    public static ClientWeaponStatus offHandStatus = new ClientWeaponStatus(false);
    @OnlyIn(Dist.CLIENT)
    public static boolean mainButtonDown() {
        return mainHandStatus.buttonDown.get();
    }
    @Deprecated
    @OnlyIn(Dist.CLIENT)
    public static boolean holdingGun() {
        return mainHandStatus.holdingGun.get() || offHandStatus.holdingGun.get();
    }
    @OnlyIn(Dist.CLIENT)
    public static ReentrantLock lock = new ReentrantLock();

    @OnlyIn(Dist.CLIENT)
    public static void onSetUp(final FMLClientSetupEvent event) {
        Timer timer = new Timer();
        timer.schedule(new ClientWeaponLooper(), 0, 5);

        GunModelRegistry.registerModel(ModItems.G19.get(), new G19Model());
        GunModelRegistry.registerTransform(ModItems.G19.get(), new DisplayData()
                .setFirstPersonMain(-0.46f,1.31f,-3.1f, POS).set(DisplayData.FIRST_PERSON_MAIN, 0.1f, SCALE)
                .setThirdPersonRight(0f, 0f, 0, POS).set(DisplayData.THIRD_PERSON_RIGHT, 0.15f, SCALE)
                .setGround(0f, 0f, 0, POS).set(DisplayData.GROUND, 0.15f, SCALE)
                .setFrame(0f, 0f, 0, POS).setFrame(0f, 0f, 0, ROT).set(DisplayData.FIXED, 0.3f, SCALE)
        );

        GunModelRegistry.registerModel(ModItems.AKM.get(), new AkmModel());
        GunModelRegistry.registerTransform(ModItems.AKM.get(), new DisplayData()
                .setFirstPersonMain(-0.85f,2.4f,-2.35f, POS).set(DisplayData.FIRST_PERSON_MAIN, 0.12f, SCALE)
                .setThirdPersonRight(0.0f,-0.2f,1.3f, POS).set(DisplayData.THIRD_PERSON_RIGHT, 0.15f, SCALE)
                .setGround(0f, 0f, 0, POS).set(DisplayData.GROUND, 0.15f, SCALE)
                .setFrame(0f, 0f, 0, POS).setFrame(0f, 0f, 0, ROT).set(DisplayData.FIXED, 0.3f, SCALE)
        );

    }

    public static void updateClientPlayerStatus(int id, long lastShootLeft, long lastChamber, boolean reloading) {
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel != null) {
            Entity entity = clientLevel.getEntity(id);
            if (entity instanceof Player player) {
                player.getCapability(PlayerStatusProvider.CAPABILITY).ifPresent((cap) -> {
                    cap.setLastShoot(lastShootLeft);
                    cap.setReloading(reloading);
                    cap.setLastChamberAction(lastChamber);
                    cap.dataChanged = false;
                });
            }
        }
    }

    @Deprecated
    public static IGun[] getGuns(Player player) {
        ItemStack stackMain = player.getMainHandItem();
        ItemStack stackOff = player.getOffhandItem();
        IGun gunMain = stackMain.getItem() instanceof IGun ? (IGun) stackMain.getItem() : null;
        IGun gunOff = stackOff.getItem() instanceof IGun ? (IGun) stackOff.getItem() : null;
        return new IGun[]{gunMain, gunOff};
    }

    @OnlyIn(Dist.CLIENT)
    public static void handleClientShoot(ItemStack stack, IGun gun, Player player) {
        try {
            lock.lock();
            IGunFireMode fireMode = gun.getFireMode(stack);
            if (fireMode != null && fireMode.canFire(player, stack, gun)) {
                fireMode.clientShoot(player, stack, gun);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
