package net.aquiferic.farmlifecrops;

import net.aquiferic.farmlifecrops.registry.ModRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(FarmLifeCrops.MODID)
public final class FarmLifeCrops {
    public static final String MODID = "farmlifecrops";

    public FarmLifeCrops(IEventBus modEventBus) {
        ModRegistries.register(modEventBus);
    }
}
