package jackyy.simplesponge.registry.crafting;

import net.minecraftforge.common.crafting.CraftingHelper;

public class ModCrafting {

    public static void registerConditions() {
        CraftingHelper.register(ConditionEnergizedSpongeStick.SERIALIZER);
        CraftingHelper.register(ConditionOpenBlocksIntegration.SERIALIZER);
    }

}
