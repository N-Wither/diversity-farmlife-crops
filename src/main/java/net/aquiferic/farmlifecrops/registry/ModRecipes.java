package net.aquiferic.farmlifecrops.registry;

public class ModRecipes {
    private ModRecipes() {}
    static void init() {
        ModRegistries.RECIPES.shapeless("corn_kernel", "farmlifecrops:corn_seeds")
            .requires("#c:crops/corn")
            .count(4)
            .register();
    }
}
