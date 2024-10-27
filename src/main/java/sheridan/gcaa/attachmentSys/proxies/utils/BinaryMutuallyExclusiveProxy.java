package sheridan.gcaa.attachmentSys.proxies.utils;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import sheridan.gcaa.attachmentSys.AttachmentSlot;
import sheridan.gcaa.attachmentSys.AttachmentSlotProxy;
import sheridan.gcaa.attachmentSys.common.AttachmentsRegister;
import sheridan.gcaa.items.attachments.IAttachment;
import sheridan.gcaa.items.gun.IGun;

public class BinaryMutuallyExclusiveProxy extends AttachmentSlotProxy {
    private static final Exclusive DEFAULT_EXCLUSIVE = (prevSlot, other, prevAttachment, otherAttachment) -> true;
    private final AttachmentSlot A;
    private final AttachmentSlot B;
    private Exclusive exclusive = DEFAULT_EXCLUSIVE;

    public BinaryMutuallyExclusiveProxy(AttachmentSlot root, String AName, String BName) {
        super(root);
        A = root.searchChild(AName);
        B = root.searchChild(BName);
    }

    public BinaryMutuallyExclusiveProxy setExclusive(Exclusive exclusive) {
        this.exclusive = exclusive;
        return this;
    }

    @Override
    public IAttachment.AttachResult onCanAttach(IAttachment attachment, ItemStack stack, IGun gun, AttachmentSlot root, AttachmentSlot prevSlot) {
        if (prevSlot == A) {
            return B.isEmpty() ? attachment.canAttach(stack, gun, root, prevSlot) :
                    (exclusive.isExclusive(prevSlot, B, attachment, AttachmentsRegister.get(B.getAttachmentId())) ?
                            new IAttachment.AttachResult(false, getMessage(B.getAttachmentId())) :
                            attachment.canAttach(stack, gun, root, prevSlot));
        }
        if (prevSlot == B) {
            return A.isEmpty() ? attachment.canAttach(stack, gun, root, prevSlot) :
                    (exclusive.isExclusive(prevSlot, A, attachment, AttachmentsRegister.get(A.getAttachmentId())) ?
                            new IAttachment.AttachResult(false, getMessage(A.getAttachmentId())):
                            attachment.canAttach(stack, gun, root, prevSlot));
        }
        return attachment.canAttach(stack, gun, root, prevSlot);
    }

    public interface Exclusive {
        boolean isExclusive(AttachmentSlot prevSlot, AttachmentSlot other, IAttachment prevAttachment, IAttachment otherAttachment);
    }

    @Override
    public IAttachment.AttachResult onCanDetach(IAttachment attachment, ItemStack stack, IGun gun, AttachmentSlot root, AttachmentSlot prevSlot) {
        return attachment.canDetach(stack, gun, root, prevSlot);
    }

    private IAttachment.MessageGetter getMessage(String id) {
        return () -> {
            String message = Component.translatable("tooltip.action_res.conflict").getString();
            IAttachment attachment = AttachmentsRegister.get(id);
            if (attachment != null) {
                message = message.replace("$id", Component.translatable(attachment.get().getDescriptionId()).getString());
            } else {
                message = message.replace("$id", "-UNKNOWN-");
            }
            return message;
        };
    }
}
