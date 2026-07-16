package com.sprintxxl.ascenthub;

import com.sprintxxl.ascenthub.mods.Mod;
import com.sprintxxl.ascenthub.build.ProjectBuilder;

import java.nio.file.Path;

import static com.sprintxxl.ascenthub.Paths.*;
import static com.sprintxxl.ascenthub.build.JarCollector.*;
import static com.sprintxxl.ascenthub.build.JarDistributor.distributeJar;
import static com.sprintxxl.ascenthub.mods.registry.AscentModRegistry.getAllMods;
import static com.sprintxxl.ascenthub.mods.registry.AscentModRegistry.initAscentModRegistry;
import static com.sprintxxl.ascenthub.util.FolderCleaner.clean;
import static com.sprintxxl.ascenthub.util.Logging.printInfo;
import static com.sprintxxl.ascenthub.util.Logging.printWarn;

public class Main {

    void main() {

        printInfo("Initializing Ascent Mod Registry...");

        initAscentModRegistry();

        printInfo("Registered " + getAllMods().size() + " mods");

        clean(HUB_MODS_DIRECTORY);
        clean(BUILT_JARS_DIRECTORY);

        for (Mod mod : getAllMods()) {
            clean(mod.getLibsDirectory());
            clean(mod.getRunModsDirectory());
        }

        Path ascentApiJar = findJar(ASCENT_API_JARS, "Ascent HUB Api");

        for (Mod mod : getAllMods()) {
            copyJar(ascentApiJar, mod.getLibsDirectory());
        }

        for (Mod mod : getAllMods()) {

            printInfo("Building " + mod.getDisplayName() + "...");

            if (!ProjectBuilder.build(mod)) {
                printWarn("Build failed for " + mod.getDisplayName());
                return;
            }

            Path builtJar = findBuiltJar(mod);

            copyJar(builtJar, HUB_MODS_DIRECTORY);
            copyJar(builtJar, BUILT_JARS_DIRECTORY);

            distributeJar(mod, builtJar, getAllMods());

            printInfo("Copied " + builtJar.getFileName());
        }

        printInfo("All projects built and collected successfully");
    }
}