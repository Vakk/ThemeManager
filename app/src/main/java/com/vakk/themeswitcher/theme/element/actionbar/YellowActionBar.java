package com.vakk.themeswitcher.theme.element.actionbar;

import android.graphics.Color;

/**
 * Created by vakk on 4/6/16.
 */
public class YellowActionBar implements BaseActionBar {
    private static int mBackgroundColor = Color.YELLOW;
    private static int mFontColor = Color.CYAN;
    @Override
    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    @Deprecated
    @Override
    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
    }

    @Override
    public int getFontColor() {
        return mFontColor;
    }

    @Deprecated
    @Override
    public void setFontColor(int color) {
        mFontColor = color;
    }
}
