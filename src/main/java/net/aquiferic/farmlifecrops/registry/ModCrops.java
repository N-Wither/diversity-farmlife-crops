package net.aquiferic.farmlifecrops.registry;

import static net.aquiferic.farmlifecrops.registry.ModRegistries.CONTENT;

import net.aquiferic.diversitycore.api.registry.SimpleCropEntry;
import net.minecraft.world.food.FoodProperties;
import net.aquiferic.diversitycore.api.registry.CropModelType;
import net.aquiferic.diversitycore.api.loot.CropLootTables;

public final class ModCrops {
    public static final SimpleCropEntry CABBAGE = CONTENT.crops().createSimple("cabbage")
        .model(CropModelType.CROSS)
        .displayName("en_us", "Cabbage")
        .seed(seed -> seed.displayName("en_us", "Cabbage Seeds"))
        .produce(ModItems.CABBAGE)
        .register();

    public static final SimpleCropEntry RED_CABBAGE = CONTENT.crops().createSimple("red_cabbage")
        .model(CropModelType.CROSS)
        .displayName("en_us", "Red Cabbage")
        .seed(seed -> seed.displayName("en_us", "Red Cabbage Seeds"))
        .produce(ModItems.RED_CABBAGE)
        .register();

    public static final SimpleCropEntry CAULIFLOWER = CONTENT.crops().createSimple("cauliflower")
        .model(CropModelType.CROSS)
        .displayName("en_us", "Cauliflower")
        .seed(seed -> seed.displayName("en_us", "Cauliflower Seeds"))
        .produce(ModItems.CAULIFLOWER)
        .register();

    public static final SimpleCropEntry BROCCOLI = CONTENT.crops().createSimple("broccoli")
        .model(CropModelType.CROSS)
        .displayName("en_us", "Broccoli")
        .seed(seed -> seed.displayName("en_us", "Broccoli Seeds"))
        .produce(ModItems.BROCCOLI)
        .register();

    public static final SimpleCropEntry TOMATO = CONTENT.crops().createSimple("tomato")
        .model(CropModelType.CROP)
        .displayName("en_us", "Tomato")
        .seed(seed -> seed.displayName("en_us", "Tomato Seeds"))
        .produce(ModItems.TOMATO)
        .loot(CropLootTables.crop().produce(1, 3, true).seeds(1).bonusSeeds(2).build())
        .register();

    public static final SimpleCropEntry GARLIC = CONTENT.crops().createSimple("garlic")
        .model(CropModelType.CROP)
        .displayName("en_us", "Garlic")
        .selfSeeded()
        .produce(item -> 
            item.displayName("en_us", "Garlic")
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.5f).build()))
            .tag("c:crops/garlic")
        )
        .loot(CropLootTables.crop().produce(1, 2, true).seeds(1).bonusSeeds(0).build())
        .register();

    public static final SimpleCropEntry CORN = CONTENT.crops().createSimple("corn")
        .model(CropModelType.CROSS)
        .textureRatio(1, 2)
        .displayName("en_us", "Corn")
        .seed(seed -> 
            seed.displayName("en_us", "Corn Kernel")
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.5f).build()))
        )
        .produce(ModItems.CORN)
        .loot(CropLootTables.crop().produce(1, 3, true).seeds(1).bonusSeeds(0).build())
        .register();

    private ModCrops() {
    }

    static void init() {
    }
}
