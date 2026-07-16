package com.sprintxxl.ascenthub.definitions;

import java.util.Objects;

public final class DefinitionID {

    private final String modid;
    private final String category;
    private final String id;

    public DefinitionID(
            String modid,
            String category,
            String id
    ) {
        this.modid = requireValidPart(modid, "modid");
        this.category = requireValidPart(category, "category");
        this.id = requireValidPart(id, "id");
    }

    public String getModID() {
        return modid;
    }

    public String getCategory() {
        return category;
    }

    public String getID() {
        return id;
    }

    private static String requireValidPart(String value, String name) {

        Objects.requireNonNull(value, name + " cannot be null");

        if (value.isBlank()) {
            throw new IllegalArgumentException(name + " cannot be blank");
        }

        return value;
    }

    @Override
    public String toString() {
        return modid + ":" + category + ":" + id;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof DefinitionID other)) {
            return false;
        }

        return modid.equals(other.modid)
                && category.equals(other.category)
                && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modid, category, id);
    }
}
