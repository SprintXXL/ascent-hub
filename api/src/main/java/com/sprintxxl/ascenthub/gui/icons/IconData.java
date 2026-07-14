package com.sprintxxl.ascenthub.gui.icons;

import java.util.List;

public class IconData {

    private final List<IconDefinition> icons;

    public IconData(
            IconDefinition... icons
    ) {
        this.icons = List.of(icons);
    }

    public List<IconDefinition> getAllIcons() {
        return icons;
    }

    public int getIconCount() {
        return icons.size();
    }

    public boolean isEmpty() {
        return icons.isEmpty();
    }
}
