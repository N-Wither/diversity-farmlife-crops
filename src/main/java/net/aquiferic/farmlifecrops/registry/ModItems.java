package net.aquiferic.farmlifecrops.registry;

import static net.aquiferic.farmlifecrops.registry.ModRegistries.CONTENT;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public final class ModItems {
    public static final DeferredItem<Item> CABBAGE = CONTENT.items().create("cabbage")
        .displayName("en_us", "Cabbage")
        .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.75F).build()))
        .tag("c:crops/cabbage")
        .register();

    public static final DeferredItem<Item> RED_CABBAGE = CONTENT.items().create("red_cabbage")
        .displayName("en_us", "Red Cabbage")
        .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.75F).build()))
        .tag("c:crops/red_cabbage")
        .register();
        
    public static final DeferredItem<Item> CAULIFLOWER = CONTENT.items().create("cauliflower")
        .displayName("en_us", "Cauliflower")
        .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationModifier(1F).build()))
        .tag("c:crops/cauliflower")
        .register();

    public static final DeferredItem<Item> BROCCOLI = CONTENT.items().create("broccoli")
        .displayName("en_us", "Broccoli")
        .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationModifier(1F).build()))
        .tag("c:crops/broccoli")
        .register();
    
    public static final DeferredItem<Item> TOMATO = CONTENT.items().create("tomato")
        .displayName("en_us", "Tomato")
        .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build()))
        .tag("c:crops/tomato")
        .register();

    public static final DeferredItem<Item> CORN = CONTENT.items().create("corn")
        .displayName("en_us", "Corn")
        .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.75F).build()))
        .tag("c:crops/corn")
        .register();

    private ModItems() {
    }

    static void init() {
    }
}
