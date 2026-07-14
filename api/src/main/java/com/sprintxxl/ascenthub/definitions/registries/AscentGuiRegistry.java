package com.sprintxxl.ascenthub.definitions.registries;

import com.sprintxxl.ascenthub.definitions.AscentID;
import com.sprintxxl.ascenthub.gui.AscentGUI;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class AscentGuiRegistry {

    private final Map<AscentID, AscentGUI> guis = new LinkedHashMap<>();

    public void register(AscentID id, AscentGUI gui) {
        Objects.requireNonNull(id, "id cannot be null");
        Objects.requireNonNull(gui, "gui cannot be null");

        if (guis.containsKey(id)) {
            throw new IllegalArgumentException("GUI already registered: " + id);
        }

        guis.put(id, gui);
    }

    public AscentGUI get(AscentID id) {
        return guis.get(id);
    }

    public boolean contains(AscentID id) {
        return guis.containsKey(id);
    }

    public int size() {
        return guis.size();
    }

    public boolean isEmpty() {
        return guis.isEmpty();
    }

    public Map<AscentID, AscentGUI> getAll() {
        return Collections.unmodifiableMap(guis);
    }
}
