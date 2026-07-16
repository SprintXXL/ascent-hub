package com.sprintxxl.ascenthub.framework.gui.icons;

public enum Icons {

    ARROW(27, 27),
    FLAME(14, 14);

    private final int width;
    private final int height;

    Icons(
            int width,
            int height
    ) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
