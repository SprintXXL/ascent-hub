package com.sprintxxl.ascenthub.build;

import com.sprintxxl.ascenthub.mods.Mod;

import java.nio.file.Path;
import java.util.List;

import static com.sprintxxl.ascenthub.build.JarCollector.copyJar;

public class JarDistributor {

    public static void distributeJar(Mod builtMod, Path builtJar, List<Mod> allMods) {

        for (Mod targetMod : allMods) {

            if (targetMod == builtMod) {
                continue;
            }

            Path destination;

            if (targetMod.dependsOn(builtMod.getID())) {
                destination = targetMod.getLibsDirectory();
            } else {
                destination = targetMod.getRunModsDirectory();
            }

            copyJar(builtJar, destination);
        }
    }
}
