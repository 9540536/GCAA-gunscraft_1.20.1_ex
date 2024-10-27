package sheridan.gcaa.client.model.attachments.grip;

import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import sheridan.gcaa.client.model.attachments.IAttachmentModel;
import sheridan.gcaa.client.model.attachments.IDirectionalModel;
import sheridan.gcaa.client.model.attachments.LaserRayRenderer;
import sheridan.gcaa.client.model.attachments.StatisticModel;
import sheridan.gcaa.client.model.modelPart.ModelPart;
import sheridan.gcaa.client.render.AttachmentRenderEntry;
import sheridan.gcaa.client.render.GunRenderContext;

@OnlyIn(Dist.CLIENT)
public class LaserSightModel implements IAttachmentModel, IDirectionalModel {
    private final ModelPart sight;
    private final ModelPart laser;

    public LaserSightModel() {
        this.sight = StatisticModel.LASER_SIGHTS.get("normal");
        this.laser = sight.getChild("laser");
    }

    @Override
    public void render(GunRenderContext context, AttachmentRenderEntry attachmentRenderEntry, ModelPart pose) {
        context.pushPose();
        initTranslation(attachmentRenderEntry, context, pose);
        context.render(sight, context.getBuffer(RenderType.entityCutout(StatisticModel.LASER_SIGHTS.texture)));
        context.pushPose().translateTo(sight);
        LaserRayRenderer.render(context, laser, LaserRayRenderer.RED, true);
        context.popPose();
        context.popPose();
    }

    @Override
    public ModelPart getRoot() {
        return sight;
    }

    @Override
    public byte getDirection() {
        return LOWER;
    }
}
