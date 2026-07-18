package com.sprintxxl.ascenthub.definitions.registry;

import com.sprintxxl.ascenthub.definitions.AscentDefinitionProvider;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public final class DefinitionProviderRegistry {

    private DefinitionProviderRegistry() {}

    private static final Map<String, AscentDefinitionProvider> PROVIDERS = new LinkedHashMap<>();

    public static void registerProvider(String modid, AscentDefinitionProvider provider) {

        Objects.requireNonNull(modid, "modid cannot be null");
        Objects.requireNonNull(provider, "provider cannot be null");

        if (modid.isBlank()) {
            throw new IllegalArgumentException("ModID cannot be empty");
        }

        if (PROVIDERS.containsKey(modid)) {
            throw new IllegalArgumentException(
                    "Definition provider is already registered for: " + modid
            );
        }

        PROVIDERS.put(modid, provider);
    }

    public static Map<String, AscentDefinitionProvider> getAllProviders() {
        return new LinkedHashMap<>(PROVIDERS);
    }
}
