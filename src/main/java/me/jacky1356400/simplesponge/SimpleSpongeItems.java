package me.jacky1356400.simplesponge;

import me.jacky1356400.simplesponge.item.ItemSpongeOnAStick;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Admin on 04/06/2017.
 */
public class SimpleSpongeItems {

    public static ItemSpongeOnAStick spongeOnAStick;

    public static void init(){
        spongeOnAStick = GameRegistry.register(new ItemSpongeOnAStick());
    }

    public static void initModels(){
        spongeOnAStick.initModel();
    }

}
