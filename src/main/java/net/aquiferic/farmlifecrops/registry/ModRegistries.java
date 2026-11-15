package net.aquiferic.farmlifecrops.registry;

import net.aquiferic.diversitycore.api.recipe.RecipeRegistry;
import net.aquiferic.diversitycore.api.registry.ContentRegistry;
import net.aquiferic.farmlifecrops.FarmLifeCrops;
import net.neoforged.bus.api.IEventBus;

public final class ModRegistries {
    public static final ContentRegistry CONTENT = new ContentRegistry(FarmLifeCrops.MODID);
    public static final RecipeRegistry RECIPES = new RecipeRegistry(FarmLifeCrops.MODID);

    private ModRegistries() {
    }

    public static void register(IEventBus bus) {
        // Load all declarations before binding the content registry.
        ModItems.init();
        ModCrops.init();
        ModCreativeTabs.init();
        ModRecipes.init();
        RECIPES.freeze();
        CONTENT.register(bus);
        ModCreativeTabs.TABS.register(bus);
    }
}
