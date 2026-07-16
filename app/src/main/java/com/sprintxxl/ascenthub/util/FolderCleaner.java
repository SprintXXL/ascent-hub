package com.sprintxxl.ascenthub.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

public final class FolderCleaner {

    private FolderCleaner() {}

    public static void clean(Path directory) {

        if (!Files.exists(directory)) {
            return;
        }

        try (Stream<Path> paths = Files.walk(directory)) {
            paths
                    .filter(path -> !path.equals(directory))
                    .sorted(Comparator.reverseOrder())
                    .forEach(FolderCleaner::delete);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete directory: " + directory, e);
        }
    }

    private static void delete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete path: " + path, e);
        }
    }
}
