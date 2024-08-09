package sheridan.gcaa.items.attachments;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import sheridan.gcaa.items.gun.IGun;

public class Scope extends Attachment{
    protected int order;

    public Scope(int order) {
        this.order = order;
    }
    
    @Override
    public void onAttach(ItemStack stack, IGun gun, CompoundTag data) {

    }

    @Override
    public void onDetach(ItemStack stack, IGun gun, CompoundTag data) {

    }

    public int getOrder() {
        return order;
    }
}
