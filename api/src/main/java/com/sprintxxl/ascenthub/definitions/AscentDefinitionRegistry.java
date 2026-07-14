package com.sprintxxl.ascenthub.definitions;

import com.sprintxxl.ascenthub.definitions.registries.AscentGuiRegistry;

public final class AscentDefinitionRegistry {

    private final AscentGuiRegistry guiRegistry = new AscentGuiRegistry();

    public AscentGuiRegistry getGuiRegistry() {
        return guiRegistry;
    }
}
