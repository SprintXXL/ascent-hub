package com.sprintxxl.ascenthub.framework.gui.slots.slotsettings.settings;

import com.sprintxxl.ascenthub.framework.gui.slots.slotsettings.SlotSetting;

public final class PlayerSlotsSetting implements SlotSetting {

    private final boolean value;

    public PlayerSlotsSetting(
            boolean value
    ) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
