package com.sprintxxl.ascenthub.gui.slots;

public class SlotDefinition {

    private final int x;
    private final int y;
    private final int containerOffsetX;
    private final int containerOffsetY;

    public SlotDefinition(
            int x,
            int y,
            int containerOffsetX,
            int containerOffsetY
    ) {
        this.x = x;
        this.y = y;
        this.containerOffsetX = containerOffsetX;
        this.containerOffsetY = containerOffsetY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getContainerOffsetX() {
        return containerOffsetX;
    }

    public int getContainerOffsetY() {
        return containerOffsetY;
    }

    public int getContainerX() {
        return x + containerOffsetX;
    }

    public int getContainerY() {
        return y + containerOffsetY;
    }

    public static SlotDefinition slot(int x, int y) {
        return new SlotDefinition(x, y, 1, 1);
    }

    public static SlotDefinition largeSlot(int x, int y) {
        return new SlotDefinition(x, y, 5, 5);
    }
}
