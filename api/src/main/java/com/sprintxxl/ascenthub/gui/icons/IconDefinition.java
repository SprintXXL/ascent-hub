package com.sprintxxl.ascenthub.gui.icons;

public class IconDefinition {

    private final IconType type;
    private final Icons icon;
    private final int visibleX;
    private final int visibleY;
    private final int hiddenX;
    private final int hiddenY;

    public IconDefinition(
            IconType type,
            Icons icon,
            int visibleX,
            int visibleY,
            int hiddenX,
            int hiddenY
    ) {
        this.type = type;
        this.icon = icon;
        this.visibleX = visibleX;
        this.visibleY = visibleY;
        this.hiddenX = hiddenX;
        this.hiddenY = hiddenY;
    }

    public IconType getType() {
        return type;
    }

    public Icons getIcon() {
        return icon;
    }

    public int getVisibleX() {
        return visibleX;
    }

    public int getVisibleY() {
        return visibleY;
    }

    public int getHiddenX() {
        return hiddenX;
    }

    public int getHiddenY() {
        return hiddenY;
    }

    public int getWidth() {
        return icon.getWidth();
    }

    public int getHeight() {
        return icon.getHeight();
    }

    public static IconDefinition staticIcon(Icons icon, int x, int y) {
        return new IconDefinition(IconType.STATIC, icon, x, y, 0, 0);
    }

    public static IconDefinition progressIcon(Icons icon, int visibleX, int visibleY, int hiddenX, int hiddenY) {
        return new IconDefinition(IconType.PROGRESS, icon, visibleX, visibleY, hiddenX, hiddenY);
    }
}
