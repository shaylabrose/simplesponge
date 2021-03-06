package jackyy.simplesponge.item;

import jackyy.simplesponge.SimpleSponge;
import jackyy.simplesponge.registry.ModConfig;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemSpongeOnAStick extends ItemSpongeOnAStickBase {

    public ItemSpongeOnAStick() {
        setRegistryName(SimpleSponge.MODID + ":sponge_on_a_stick");
        setUnlocalizedName(SimpleSponge.MODID + ".sponge_on_a_stick");
        setMaxDamage(ModConfig.sponge.spongeOnAStickMaxDamage);
        setCreativeTab(SimpleSponge.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public int getDmg() {
        return ModConfig.sponge.spongeOnAStickMaxDamage;
    }

    @Override
    public int getRange() {
        return ModConfig.sponge.spongeOnAStickRange;
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (Loader.isModLoaded("openblocks")) {
            if (ModConfig.misc.openBlocksIntegration) {
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge_on_a_stick")) == null) {
                    list.add(new ItemStack(item));
                }
            } else {
                list.add(new ItemStack(item));
            }
        } else {
            list.add(new ItemStack(item));
        }
    }

}
