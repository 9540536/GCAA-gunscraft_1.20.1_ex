package sheridan.gcaa.client.model.gun;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.resources.ResourceLocation;
import sheridan.gcaa.client.model.modelPart.ModelPart;

public abstract class AutoMagPositionModel extends GunModel{
    public AutoMagPositionModel(ResourceLocation modelPath, ResourceLocation animationPath) {
        super(modelPath, animationPath);
    }

    @Override
    public boolean hasSlot(String modelSlotName) {
        return "s_mag".equals(modelSlotName) || super.hasSlot(modelSlotName);
    }

    @Override
    public void handleSlotTranslate(PoseStack poseStack, String name) {
        if (name.equals("s_mag")) {
            handleGunTranslate(poseStack);
            getMag().translateAndRotate(poseStack);
            return;
        }
        super.handleSlotTranslate(poseStack, name);
    }

    protected abstract ModelPart getMag();
}
