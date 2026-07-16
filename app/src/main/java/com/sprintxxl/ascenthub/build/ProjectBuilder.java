package com.sprintxxl.ascenthub.build;

import com.sprintxxl.ascenthub.mods.Mod;

import java.io.IOException;
import java.nio.file.Path;

public class ProjectBuilder {

    public static boolean build(Mod mod) {

        Path wrapperJar = mod.getProjectRoot()
                .resolve("gradle")
                .resolve("wrapper")
                .resolve("gradle-wrapper.jar");

        String javaExecutable = Path.of(
                System.getProperty("java.home"), "bin", "java.exe").toString();

        ProcessBuilder builder = new ProcessBuilder(
                javaExecutable,
                "-classpath",
                wrapperJar.toString(),
                "org.gradle.wrapper.GradleWrapperMain",
                "clean",
                "build"
        );

        builder.directory(mod.getProjectRoot().toFile());
        builder.inheritIO();

        try {

            Process process = builder.start();

            int exitCode = process.waitFor();

            return exitCode == 0;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
