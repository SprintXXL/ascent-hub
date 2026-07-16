package com.sprintxxl.ascenthub.definitions;

@FunctionalInterface
public interface DefinitionRegistrar<T> {

    void register(T definition);
}
