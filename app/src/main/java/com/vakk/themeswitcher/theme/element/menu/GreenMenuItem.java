package com.vakk.themeswitcher.theme.element.menu;

import android.graphics.Color;

/**
 * Created by vakk on 4/6/16.
 */
public class GreenMenuItem implements BaseMenuItem {
    private int mFontColor = Color.GREEN;
    private int mBackgroundColor = Color.BLUE;

    @Deprecated
    @Override
    public void setFontColor(int color) {
        mFontColor = color;
    }

    @Override
    public int getFontColor() {
        return mFontColor;
    }

    @Deprecated
    @Override
    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
    }

    @Override
    public int getBackgroundColor() {
        return mBackgroundColor;
    }
}
