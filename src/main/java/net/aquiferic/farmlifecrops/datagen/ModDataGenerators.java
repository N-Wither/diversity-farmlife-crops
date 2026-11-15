package net.aquiferic.farmlifecrops.datagen;

import net.aquiferic.farmlifecrops.FarmLifeCrops;

import java.nio.file.Path;
import java.util.Map;
import java.util.TreeSet;
import net.aquiferic.diversitycore.datagen.ModBlockTagsProvider;
import net.aquiferic.diversitycore.datagen.ModItemTagsProvider;
import net.aquiferic.diversitycore.datagen.ModLanguageProvider;
import net.aquiferic.diversitycore.datagen.ModLootProvider;
import net.aquiferic.diversitycore.datagen.ModModelProvider;
import net.aquiferic.diversitycore.datagen.ModRecipeProvider;
import net.aquiferic.diversitycore.datagen.TranslationSources;
import net.aquiferic.farmlifecrops.registry.ModRegistries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = FarmLifeCrops.MODID, value = Dist.CLIENT)
public final class ModDataGenerators {
    private ModDataGenerators() {
    }

    @SubscribeEvent
    public static void gather(GatherDataEvent.Client event) {
        var content = ModRegistries.CONTENT;
        var output = event.getGenerator().getPackOutput();
        event.addProvider(new ModModelProvider(output, content));
        event.addProvider(new ModLootProvider(output, content, event.getReloadableLookupProvider()));
        event.addProvider(new ModBlockTagsProvider(output, content, event.getWorldLookupProvider()));
        event.addProvider(new ModItemTagsProvider(output, content, event.getWorldLookupProvider()));
        event.addProvider(new ModRecipeProvider(output, ModRegistries.RECIPES, event.getWorldLookupProvider(), event.getReloadableLookupProvider()));

        var translations = TranslationSources.read(Path.of(System.getProperty(
                "farmlifecrops.translationSources", "src/main/translations")));
        var locales = new TreeSet<String>(translations.keySet());
        content.itemDefinitions().forEach(definition -> locales.addAll(definition.names().keySet()));
        content.blockDefinitions().forEach(definition -> locales.addAll(definition.names().keySet()));
        content.cropDefinitions().forEach(definition -> locales.addAll(definition.names().keySet()));
        content.simpleCropDefinitions().forEach(definition -> locales.addAll(definition.names().keySet()));
        content.validateCropSeeds();
        locales.forEach(locale -> event.addProvider(new ModLanguageProvider(
                output, content, locale, translations.getOrDefault(locale, Map.of()))));
    }
}

