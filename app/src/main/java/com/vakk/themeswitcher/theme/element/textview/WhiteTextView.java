package com.vakk.themeswitcher.theme.element.textview;

import android.graphics.Color;
import android.graphics.Typeface;

/**
 * Created by vakk on 4/6/16.
 */
public class WhiteTextView implements BaseTextView {

    private static final int BACKGROUND_COLOR = Color.GRAY;
    private static final int FOREGROUND_COLOR = Color.WHITE;

    private static int mFontSize = 10;
    private static int mTextStyle = Typeface.BOLD_ITALIC;

    @Deprecated
    @Override
    public void setBackgroundColor(int color) {

    }
    @Override
    public int getBackGroundColor() {
        return BACKGROUND_COLOR;
    }

    @Deprecated
    @Override
    public void setForeground(int color) {

    }
    @Override
    public int getForeground() {
        return FOREGROUND_COLOR;
    }

    @Deprecated
    @Override
    public void setTextStyle(int style) {
        mTextStyle = style;
    }
    @Override
    public int getTextStyle() {
        return mTextStyle;
    }

    @Deprecated
    @Override
    public void setFontSize(int fontSize) {
        mFontSize = fontSize;
    }
    @Override
    public int getFontSize() {
        return mFontSize;
    }
}
