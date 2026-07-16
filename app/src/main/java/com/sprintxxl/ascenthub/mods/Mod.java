package com.sprintxxl.ascenthub.mods;

import java.nio.file.Path;
import java.util.List;

public final class Mod {

    private final String id;
    private final String displayName;
    private final List<String> dependencies;

    private final Path projectRoot;

    public Mod(
            String id,
            String displayName,
            List<String> dependencies
    ) {
        this.id = id;
        this.displayName = displayName;
        this.dependencies = List.copyOf(dependencies);

        this.projectRoot = Path.of("D:\\Work\\My Modpack\\Mods\\" + displayName);
    }

    public String getID() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    public Path getProjectRoot() {
        return projectRoot;
    }

    public Path getBuildLibsDirectory() {
        return projectRoot.resolve("build").resolve("libs");
    }

    public Path getLibsDirectory() {
        return projectRoot.resolve("libs");
    }

    public Path getRunModsDirectory() {
        return projectRoot.resolve("run").resolve("client").resolve("mods");
    }

    public boolean dependsOn(String id) {
        return dependencies.contains(id);
    }

    public static List<String> dependencies(String... dependencies) {
        return List.of(dependencies);
    }
}
