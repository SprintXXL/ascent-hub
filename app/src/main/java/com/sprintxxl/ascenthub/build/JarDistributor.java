package com.sprintxxl.ascenthub.build;

import com.sprintxxl.ascenthub.mods.Mod;
import com.sprintxxl.ascenthub.mods.definitions.AscentMods;

import java.nio.file.Path;
import java.util.List;

import static com.sprintxxl.ascenthub.build.JarCollector.copyJar;

public class JarDistributor {

    public static void distributeJar(Mod builtMod, Path builtJar, List<Mod> allMods) {

        for (Mod targetMod : allMods) {

            if (targetMod == builtMod) {
                continue;
            }

            if (targetMod.dependsOn(builtMod.getID())) {
                copyJar(builtJar, targetMod.getLibsDirectory());
            }

            if (targetMod == AscentMods.ARRI) {
                copyJar(builtJar, targetMod.getRunModsDirectory());
            }
        }
    }
}