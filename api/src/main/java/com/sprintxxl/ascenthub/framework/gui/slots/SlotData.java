package com.sprintxxl.ascenthub.framework.gui.slots;

import com.sprintxxl.ascenthub.framework.gui.slots.slotsettings.SlotSettings;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public final class SlotData {

    private final SlotSettings slotSettings;
    private final List<SlotGroup> slotGroups;

    private final List<SlotDefinition> allSlots;
    private final EnumMap<SlotType, List<SlotGroup>> groupsByType;
    private final EnumMap<SlotType, List<SlotDefinition>> slotsByType;
    private final EnumMap<SlotType, List<Integer>> indicesByType;

    public SlotData(
            SlotSettings slotSettings,
            SlotGroup... slotGroups
    ) {
        this.slotSettings = Objects.requireNonNull(slotSettings, "slotSettings cannot be null");
        this.slotGroups = List.of(slotGroups);

        List<SlotDefinition> temporaryAllSlots = new ArrayList<>();
        EnumMap<SlotType, List<SlotGroup>> temporaryGroupsByType = new EnumMap<>(SlotType.class);
        EnumMap<SlotType, List<SlotDefinition>> temporarySlotsByType = new EnumMap<>(SlotType.class);
        EnumMap<SlotType, List<Integer>> temporaryIndicesByType = new EnumMap<>(SlotType.class);

        int slotIndex = 0;

        for (SlotGroup group : this.slotGroups) {

            temporaryAllSlots.addAll(group.getSlots());

            temporaryGroupsByType.computeIfAbsent(
                    group.getType(),
                    type -> new ArrayList<>()).add(group);

            for (SlotDefinition slot : group.getSlots()) {

                temporarySlotsByType.computeIfAbsent(
                        group.getType(),
                        type -> new ArrayList<>()).add(slot);

                temporaryIndicesByType.computeIfAbsent(
                        group.getType(),
                        type -> new ArrayList<>()).add(slotIndex);

                slotIndex++;
            }
        }

        this.allSlots = List.copyOf(temporaryAllSlots);

        temporaryGroupsByType.replaceAll((type, groups) -> List.copyOf(groups));
        this.groupsByType = new EnumMap<>(temporaryGroupsByType);

        temporarySlotsByType.replaceAll((type, slots) -> List.copyOf(slots));
        this.slotsByType = new EnumMap<>(temporarySlotsByType);

        temporaryIndicesByType.replaceAll((type, indices) -> List.copyOf(indices));
        this.indicesByType = new EnumMap<>(temporaryIndicesByType);
    }

    public SlotSettings getSlotSettings() {
        return slotSettings;
    }

    public List<SlotGroup> getSlotGroups() {
        return slotGroups;
    }

    public List<SlotDefinition> getAllSlots() {
        return allSlots;
    }

    public int getSlotCount() {
        return allSlots.size();
    }

    public List<SlotGroup> getGroupsOfType(SlotType type) {
        return groupsByType.getOrDefault(type, List.of());
    }

    public List<SlotDefinition> getSlotsOfType(SlotType type) {
        return slotsByType.getOrDefault(type, List.of());
    }

    public List<Integer> getSlotIndices(SlotType type) {
        return indicesByType.getOrDefault(type, List.of());
    }

    public boolean hasSlotsOfType(SlotType type) {
        return !getSlotsOfType(type).isEmpty();
    }
}
