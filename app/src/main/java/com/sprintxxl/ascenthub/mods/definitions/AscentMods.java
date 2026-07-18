package com.sprintxxl.ascenthub.mods.definitions;

import com.sprintxxl.ascenthub.mods.Mod;

import static com.sprintxxl.ascenthub.mods.Mod.dependencies;
import static com.sprintxxl.ascenthub.mods.registry.AscentModRegistry.register;

public final class AscentMods {

    private AscentMods() {}

    public static void initAscentModDefinitions() {

        register(ARRI);
        register(MATTER);
        register(WORLDGEN);
        register(TWEAKS);
        register(TOOLS);
        register(OREGEN);
        register(UTILITYTOOLS);
        register(MULTIBLOCKS);
        register(HUD);
        register(TOOLWORKS);
        register(INDUSTRY);
    }

    public static final Mod ARRI =
            new Mod(
                    ModIDs.ARRI,
                    "Ascent Resource & Recipe Index",
                    dependencies()
            );

    public static final Mod MATTER =
            new Mod(
                    ModIDs.MATTER,
                    "Primitive Matter",
                    dependencies(
                            ModIDs.ARRI
                    )
            );

    public static final Mod WORLDGEN =
            new Mod(
                    ModIDs.WORLDGEN,
                    "Primitive WorldGen",
                    dependencies(
                            ModIDs.ARRI
                    )
            );

    public static final Mod TWEAKS =
            new Mod(
                    ModIDs.TWEAKS,
                    "Primitive Tweaks",
                    dependencies(
                            ModIDs.ARRI
                    )
            );

    public static final Mod TOOLS =
            new Mod(
                    ModIDs.TOOLS,
                    "Primitive Tools",
                    dependencies(
                            ModIDs.ARRI
                    )
            );

    public static final Mod OREGEN =
            new Mod(
                    ModIDs.OREGEN,
                    "Primitive OreGen",
                    dependencies(
                            ModIDs.ARRI,
                            ModIDs.MATTER
                    )
            );

    public static final Mod UTILITYTOOLS =
            new Mod(
                    ModIDs.UTILITYTOOLS,
                    "Primitive UtilityTools",
                    dependencies(
                            ModIDs.ARRI,
                            ModIDs.MATTER
                    )
            );

    public static final Mod MULTIBLOCKS =
            new Mod(
                    ModIDs.MULTIBLOCKS,
                    "Primitive Multiblocks",
                    dependencies(
                            ModIDs.ARRI,
                            ModIDs.UTILITYTOOLS
                    )
            );

    public static final Mod HUD =
            new Mod(
                    ModIDs.HUD,
                    "Primitive HUD",
                    dependencies(
                            ModIDs.ARRI,
                            ModIDs.MATTER,
                            ModIDs.OREGEN
                    )
            );

    public static final Mod TOOLWORKS =
            new Mod(
                    ModIDs.TOOLWORKS,
                    "Primitive Toolworks",
                    dependencies(
                            ModIDs.ARRI,
                            ModIDs.MATTER,
                            ModIDs.UTILITYTOOLS
                    )
            );

    public static final Mod INDUSTRY =
            new Mod(
                    ModIDs.INDUSTRY,
                    "Primitive Industry",
                    dependencies(
                            ModIDs.ARRI,
                            ModIDs.MULTIBLOCKS
                    )
            );
}
