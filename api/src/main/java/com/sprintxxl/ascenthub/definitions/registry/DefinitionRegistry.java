package com.sprintxxl.ascenthub.definitions.registry;

import com.sprintxxl.ascenthub.definitions.AscentDefinition;
import com.sprintxxl.ascenthub.definitions.DefinitionID;

import java.util.*;

public final class DefinitionRegistry {

    private DefinitionRegistry() {}

    private static final Map<DefinitionID, AscentDefinition> DEFINITIONS = new LinkedHashMap<>();

    public static void registerDefinition(String modid, AscentDefinition definition) {

        Objects.requireNonNull(modid, "modid cannot be null");
        Objects.requireNonNull(definition, "definition cannot be null");

        DefinitionID id = definition.createDefinitionID(modid);

        if (DEFINITIONS.containsKey(id)) {
            throw new IllegalArgumentException("Definition is already registered: " + id);
        }

        DEFINITIONS.put(id, definition);
    }

    public static Map<DefinitionID, AscentDefinition> getAllDefinitions() {
        return new LinkedHashMap<>(DEFINITIONS);
    }

    public static AscentDefinition getDefinition(DefinitionID id) {
        return DEFINITIONS.get(id);
    }
}
