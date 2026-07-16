package com.sprintxxl.ascenthub.definitions;

import java.util.Locale;

public interface AscentDefinition {

    String getID();

    default String getCategory() {
        return getClass().getSimpleName().toLowerCase(Locale.ROOT);
    }

    default DefinitionID createDefinitionID(String modid) {
        return new DefinitionID(modid, getCategory(), getID());
    }
}
