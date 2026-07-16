package com.sprintxxl.ascenthub.framework.gui.slots.slotsettings;

import com.sprintxxl.ascenthub.framework.gui.slots.slotsettings.settings.PlayerSlotsSetting;

public final class SlotSettings {

    private final boolean addPlayerSlots;

    public SlotSettings(
            SlotSetting... settings
    ) {

        boolean addPlayerSlots = true;
        boolean playerSlotsSettingFound = false;

        for (SlotSetting setting : settings) {
            if (setting instanceof PlayerSlotsSetting playerSlots) {

                if (playerSlotsSettingFound) {
                    throw new IllegalArgumentException(
                            "Player slots setting was defined more than once"
                    );
                }

                playerSlotsSettingFound = true;
                addPlayerSlots = playerSlots.getValue();
            }
        }

        this.addPlayerSlots = addPlayerSlots;
    }

    public boolean shouldAddPlayerSlots() {
        return addPlayerSlots;
    }

    public static SlotSettings slotSettings(SlotSetting... settings) {
        return new SlotSettings(settings);
    }

    public static SlotSetting addPlayerSlots(boolean value) {
        return new PlayerSlotsSetting(value);
    }
}
