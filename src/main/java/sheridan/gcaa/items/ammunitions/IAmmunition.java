package sheridan.gcaa.items.ammunitions;

import net.minecraft.world.item.ItemStack;
import sheridan.gcaa.entities.projectiles.effects.IBulletEffectProcessor;
import sheridan.gcaa.items.guns.ICaliber;

import java.util.List;

public interface IAmmunition {
    List<ICaliber> getCalibersProvided();
    int getBulletLeft(ICaliber caliber);
    int getMaxPoints();
    int getPointsLeft();
    List<IBulletEffectProcessor> getBulletEffectProcessors(ItemStack stack);
    int getEffectCapacity();
}
