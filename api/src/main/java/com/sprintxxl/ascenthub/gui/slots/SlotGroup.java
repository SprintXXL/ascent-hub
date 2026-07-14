package com.sprintxxl.ascenthub.gui.slots;

import java.util.List;

public class SlotGroup {

    private final SlotType type;
    private final List<SlotDefinition> slots;

    public SlotGroup(
            SlotType type,
            List<SlotDefinition> slots
    ) {
        this.type = type;
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

    public static SlotGroup inputSlots(SlotDefinition... slots) {
        return new SlotGroup(SlotType.INPUT, List.of(slots));
    }

    public static SlotGroup outputSlots(SlotDefinition... slots) {
        return new SlotGroup(SlotType.OUTPUT, List.of(slots));
    }
}
