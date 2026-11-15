# Diversity FarmLife Crops

> [!IMPORTANT]
> Requires [Diversity Core](https://github.com/n-wither/diversitycore).

A mod that adds new crops to Minecraft.

I want to collect a full set of different crops in my modpack but ended with tomatoes from 8 different mods, this is why I decided to make this mod.

Part of Diversity Mods & FarmLife Series.

## Development

Run `.\gradlew.bat runData` after changing content declarations or translations,
then `.\gradlew.bat build` to package the generated resources.
Translations live in `src/main/translations/<locale>.json`; English crop and
item names are declared in Java and merged during data generation.

Place crop strips in `src/main/resources/assets/farmlifecrops/textures/block/atlas`.
Every PNG must have dimensions n x 8n (for example, 16x128 or 32x256), with
eight square growth stages arranged top to bottom. `processResources`
automatically runs `splitCropTextures`, producing `<name>_stage0.png` through
`<name>_stage7.png` under `build/generated/resources/crops/assets/farmlifecrops/textures/block`.
Subdirectories are preserved. Transparency and original resolution are retained.
Adding a PNG requires no Gradle changes; deleting or renaming it removes its
obsolete generated slices on the next run. Invalid dimensions fail the build.
Replace the source strips to update textures; do not edit generated slices.
New crop declarations still require `runData` to generate models and translations.

## Credits

Item textures by [Glionox](https://glionox.itch.io/items16).

Crop block textures by me, inspired by Glionox's work.
