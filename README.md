# Diversity FarmLife Crops

A mod that adds new crops to Minecraft.

I want to collect a full set of different crops in my modpack but ended with tomatoes from 8 different mods, this is why I decided to make this mod.

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

## 作物阶段贴图

作物可在声明时使用 `.textureRatio(1, 2)` 配合 16×32 阶段贴图；需要包含此 API 的新版 Diversity Core。
修改声明后运行 `runData` 重新生成模型。

`splitCropTextures` 默认将每张 atlas 等分为 8 个阶段，根据整张图片的长边识别方向：
高度更大时从上到下，宽度更大时从左到右，输出仍为 `<名称>_stage0.png` 至 `_stage7.png`。
例如 16×256 或 128×32 都输出 8 张 16×32；原有 16×128 仍输出 8 张 16×16。
阶段尺寸直接由条带尺寸和阶段数推导，无需在 Gradle 中重复配置比例，但应与 Java 声明一致。
正方形 atlas 无法确定方向，会报错；长边必须能被阶段数整除。
此任务的 `stageCount` 可统一设置，默认 8，与当前 `createSimple()` 作物一致。
