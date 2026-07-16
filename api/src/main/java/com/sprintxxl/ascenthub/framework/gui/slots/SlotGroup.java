package com.sprintxxl.ascenthub.framework.gui.slots;

import java.util.List;
import java.util.Objects;

public final class SlotGroup {

    private final SlotType type;
    private final List<SlotDefinition> slots;

    public SlotGroup(
            SlotType type,
            List<SlotDefinition> slots
    ) {
        this.type = Objects.requireNonNull(type, "type cannot be null");
        this.slots = List.copyOf(slots);
    }

    public SlotType getType() {
        return type;
    }

    public List<SlotDefinition> getSlots() {
        return slots;
    }

    public int getSlotCount() {
        return slots.size();
    }

    public boolean isEmpty() {
        return slots.isEmpty();
    }

    public static SlotGroup storageSlots(SlotDefinition... slots) {
        return new SlotGroup(SlotType.STORAGE, List.of(slots));
    }

    public static SlotGroup inputSlots(SlotDefinition... slots) {
        return new SlotGroup(SlotType.INPUT, List.of(slots));
    }

    public static SlotGroup outputSlots(SlotDefinition... slots) {
        return new SlotGroup(SlotType.OUTPUT, List.of(slots));
    }

    public static SlotGroup fuelSlots(SlotDefinition... slots) {
        return new SlotGroup(SlotType.FUEL, List.of(slots));
    }

    public static SlotGroup catalystSlots(SlotDefinition... slots) {
        return new SlotGroup(SlotType.CATALYST, List.of(slots));
    }
}
