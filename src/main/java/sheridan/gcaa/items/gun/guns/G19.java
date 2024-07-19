package sheridan.gcaa.items.gun.guns;

import sheridan.gcaa.items.gun.Gun;
import sheridan.gcaa.items.gun.GunProperties;
import sheridan.gcaa.items.gun.calibers.Caliber9x19mm;
import sheridan.gcaa.items.gun.fireModes.Semi;
import sheridan.gcaa.sounds.ModSounds;
import sheridan.gcaa.utils.RenderAndMathUtils;

import java.util.List;

public class G19 extends Gun {
    public G19() {
        super(new GunProperties(4.2f, 0.5f, 1f, 0.5f, 0.2f, GunProperties.getRPM(500),
                RenderAndMathUtils.secondsToTicks(2.1f), RenderAndMathUtils.secondsToTicks(2.9f), 15,
                1f, 1f, 0.1f, 0.1f, 5, List.of(Semi.SEMI),
                ModSounds.G19_FIRE, null, Caliber9x19mm.INSTANCE));
    }

    @Override
    public boolean isPistol() {
        return true;
    }
}
