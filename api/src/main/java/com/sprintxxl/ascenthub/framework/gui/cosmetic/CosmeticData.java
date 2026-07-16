package com.sprintxxl.ascenthub.framework.gui.cosmetic;

public final class CosmeticData {

    private final String themeColor;
    private final String headerText;

    public CosmeticData(
            String themeColor,
            String headerText
    ) {
        this.themeColor = themeColor;
        this.headerText = headerText;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public String getHeaderText() {
        return headerText;
    }
}
