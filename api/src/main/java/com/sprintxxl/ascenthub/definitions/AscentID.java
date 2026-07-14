package com.sprintxxl.ascenthub.definitions;

import java.util.Objects;

public final class AscentID {

    private final String namespace;
    private final String path;

    public AscentID(
            String namespace,
            String path
    ) {
        this.namespace = requireValidPart(namespace, "namespace");
        this.path = requireValidPart(path, "path");
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
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
        return namespace + ":" + path;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof AscentID other)) {
            return false;
        }

        return namespace.equals(other.namespace)
                && path.equals(other.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace, path);
    }

    public static AscentID id(String namespace, String path) {
        return new AscentID(namespace, path);
    }
}
