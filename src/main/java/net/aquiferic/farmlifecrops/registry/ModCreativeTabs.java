package net.aquiferic.farmlifecrops.registry;

import net.aquiferic.farmlifecrops.FarmLifeCrops;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {
    static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FarmLifeCrops.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register("main", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.farmlifecrops"))
                    .icon(() -> ModItems.CABBAGE.get().getDefaultInstance())
                    .displayItems((parameters, output) -> ModRegistries.CONTENT.creativeItems().forEach(item -> output.accept(item.get())))
                    .build());

    private ModCreativeTabs() {
    }

    static void init() {
    }
}
