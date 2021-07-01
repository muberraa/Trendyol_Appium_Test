package com.trendyol.selector;

public class SelectorFactory {
    private SelectorFactory() {

    }

    public static Selector createElementHelper(SelectorType selectorType) {
        Selector elementHelper = null;
        if (selectorType == SelectorType.ANDROID) {
            elementHelper = new AndroidSelector();
        }
        return elementHelper;
    }
}
