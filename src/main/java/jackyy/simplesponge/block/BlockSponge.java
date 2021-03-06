package jackyy.simplesponge.block;

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

public class BlockSponge extends BlockSpongeBase {

    public BlockSponge() {
        setRegistryName(SimpleSponge.MODID + ":sponge");
        setUnlocalizedName(SimpleSponge.MODID + ".sponge");
        setCreativeTab(SimpleSponge.TAB);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(@Nonnull Item item, CreativeTabs tab, List<ItemStack> list) {
        if (Loader.isModLoaded("openblocks")) {
            if (ModConfig.misc.openBlocksIntegration) {
                if (Item.REGISTRY.getObject(new ResourceLocation("openblocks", "sponge")) == null) {
                    list.add(new ItemStack(item));
                }
            } else {
                list.add(new ItemStack(item));
            }
        } else {
            list.add(new ItemStack(item));
        }
    }

    @Override
    public boolean isMagmatic() {
        return false;
    }

    @Override
    public int getRange() {
        return ModConfig.sponge.spongeRange;
    }

}
