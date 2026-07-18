package com.sprintxxl.ascenthub.global;

public final class Logging {

    private Logging() {}

    public static void printInfo(String modid, String text) {
        System.out.println("[" + modid.toUpperCase() + "] INFO: " + text);
    }

    public static void printWarn(String modid, String text) {
        System.out.println("[" + modid.toUpperCase() + "] WARN: " + text);
    }
}
