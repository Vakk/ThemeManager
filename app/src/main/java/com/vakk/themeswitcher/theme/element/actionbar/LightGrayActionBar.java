package com.vakk.themeswitcher.theme.element.actionbar;

import android.graphics.Color;

/**
 * Created by vakk on 4/6/16.
 */
public class LightGrayActionBar implements BaseActionBar {
    private int mBackgroundColor = Color.LTGRAY;
    private int mFontColor = Color.DKGRAY;
    
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
