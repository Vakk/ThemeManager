package com.vakk.themeswitcher.theme.element.layout.relative;

import android.graphics.Color;

/**
 * Created by vakk on 4/6/16.
 */
public class GrayRelativeLayout implements BaseRelativeLayout {

    private static final int BACKGROUND_COLOR = Color.GRAY;

    @Deprecated
    @Override
    public void setBackgroundColor(int color) {

    }

    @Override
    public int getBackgroundColor() {
        return BACKGROUND_COLOR;
    }
}
