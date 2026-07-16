package com.sprintxxl.ascenthub.mods.registry;

import com.sprintxxl.ascenthub.mods.Mod;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.sprintxxl.ascenthub.mods.definitions.AscentMods.initAscentModDefinitions;

public final class AscentModRegistry {

    private AscentModRegistry() {}

    private static boolean initialized = false;

    private static final List<Mod> ALL_MODS = new ArrayList<>();

    private static final Map<String, Mod> MODS = new LinkedHashMap<>();

    public static List<Mod> getAllMods() {
        return List.copyOf(ALL_MODS);
    }

    public static Mod getMod(String id) {
        return MODS.get(id);
    }

    public static void register(Mod mod) {

        if (MODS.containsKey(mod.getID())) {
            throw new IllegalArgumentException("Mod is already registered: " + mod.getID());
        }

        ALL_MODS.add(mod);
        MODS.put(mod.getID(), mod);
    }

    public static void initAscentModRegistry() {

        if (initialized) {
            return;
        }

        initialized = true;

        initAscentModDefinitions();
    }
}
