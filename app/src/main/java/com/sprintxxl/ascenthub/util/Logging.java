package com.sprintxxl.ascenthub.util;

public final class Logging {

    private Logging() {}

    public static void printInfo(String text) {
        System.out.println("[ASCENT HUB] INFO: " + text);
    }

    public static void printWarn(String text) {
        System.out.println("[ASCENT HUB] WARN: " + text);
    }
}
