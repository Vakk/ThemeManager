package com.vakk.themeswitcher.theme.element.textview;

import android.graphics.Color;
import android.graphics.Typeface;

/**
 * Created by vakk on 4/6/16.
 */
public class YellowTextView implements BaseTextView {

    private static int fontSize = 40;
    private static int textStyle = Typeface.ITALIC;

    @Deprecated
    @Override
    public void setBackgroundColor(int color) {

    }

    @Override
    public int getBackGroundColor() {
        return 0;
    }

    @Deprecated
    @Override
    public void setForeground(int color) {

    }
    @Override
    public int getForeground() {
        return Color.YELLOW;
    }

    @Deprecated
    @Override
    public void setTextStyle(int style) {
    }
    @Override
    public int getTextStyle() {
        return textStyle;
    }

    @Deprecated
    @Override
    public void setFontSize(int fontSize) {

    }

    @Override
    public int getFontSize() {
        return fontSize;
    }
}
