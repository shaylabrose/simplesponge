package jackyy.simplesponge.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.text.NumberFormat;

public class ModUtils {

    public static int receive(ItemStack container, int energy, int maxEnergy, boolean simulate) {
        int stored = getEnergyStored(container);
        int accepted = Math.min(energy, maxEnergy-stored);
        if (!simulate) {
            stored += accepted;
            setInt(container, "Energy", stored);
        }
        return accepted;
    }

    public static int extract(ItemStack container, int energy, boolean simulate) {
        int stored = getEnergyStored(container);
        int extracted = Math.min(energy, stored);
        if (!simulate) {
            stored -= extracted;
            setInt(container, "Energy", stored);
        }
        return extracted;
    }

    public static int getEnergyStored(ItemStack container) {
        return getInt(container, "Energy");
    }

    public static void setInt(ItemStack stack, String key, int val) {
        getTag(stack).setInteger(key, val);
    }

    public static int getInt(ItemStack stack, String key) {
        return hasTag(stack) ? getTag(stack).getInteger(key) : 0;
    }

    public static NBTTagCompound getTag(ItemStack stack) {
        if(!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());
        return stack.getTagCompound();
    }

    public static boolean hasTag(ItemStack stack) {
        return stack.hasTagCompound();
    }

    public static String formatNumber(long number) {
        return NumberFormat.getInstance().format(number);
    }

    public static ItemStack setDefaultEnergyTag(ItemStack container, int energy) {
        if (!container.hasTagCompound()) {
            container.setTagCompound(new NBTTagCompound());
        }
        container.getTagCompound().setInteger("Energy", energy);
        return container;
    }

}
