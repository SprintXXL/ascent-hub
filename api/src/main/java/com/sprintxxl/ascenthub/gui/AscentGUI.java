package com.sprintxxl.ascenthub.gui;

import com.sprintxxl.ascenthub.gui.cosmetic.CosmeticData;
import com.sprintxxl.ascenthub.gui.icons.IconData;
import com.sprintxxl.ascenthub.gui.slots.SlotData;

public class AscentGUI {

    private final CosmeticData cosmeticData;
    private final IconData iconData;
    private final SlotData slotData;

    public AscentGUI(
            CosmeticData cosmeticData,
            IconData iconData,
            SlotData slotData
    ) {
        this.cosmeticData = cosmeticData;
        this.iconData = iconData;
        this.slotData = slotData;
    }

    public CosmeticData getCosmeticData() {
        return cosmeticData;
    }

    public IconData getIconData() {
        return iconData;
    }

    public SlotData getSlotData() {
        return slotData;
    }
}
