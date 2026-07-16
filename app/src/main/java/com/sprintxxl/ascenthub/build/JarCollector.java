package com.sprintxxl.ascenthub.build;

import com.sprintxxl.ascenthub.mods.Mod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public final class JarCollector {

    private JarCollector() {}

    public static Path findBuiltJar(Mod mod) {
        return findJar(
                mod.getBuildLibsDirectory(),
                mod.getDisplayName()
        );
    }

    public static void copyJar(Path jar, Path destinationDirectory) {

        try {
            Files.createDirectories(destinationDirectory);

            Path destination = destinationDirectory.resolve(jar.getFileName());

            Files.copy(jar, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to copy JAR: " + jar, e);
        }
    }

    public static Path findJar(Path directory, String name) {

        try (Stream<Path> paths = Files.list(directory)) {
            return paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".jar"))
                    .filter(path -> !path.getFileName().toString().contains("-dev"))
                    .filter(path -> !path.getFileName().toString().contains("-sources"))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException(
                            "No distributable JAR found for " + name
                    ));
        } catch (IOException e) {
            throw new RuntimeException("Failed to inspect built JARs for "
                    + name, e);
        }
    }
}
