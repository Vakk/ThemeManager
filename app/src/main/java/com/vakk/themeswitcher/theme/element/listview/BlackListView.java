package com.vakk.themeswitcher.theme.element.listview;

import android.graphics.Color;

import com.vakk.themeswitcher.theme.element.textview.BaseTextView;
import com.vakk.themeswitcher.theme.element.textview.WhiteTextView;

/**
 * Created by vakk on 4/6/16.
 */
public class BlackListView implements BaseListView {

    private int backgroundColor = Color.BLACK;
    private BaseTextView mTextView = new WhiteTextView();
    private int mDividerHeight = 10;
    private int mDividerColor = Color.WHITE;

    @Deprecated
    @Override
    public void setBackgroundColor(int textColor) {
        backgroundColor = textColor;
    }

    @Override
    public int getBackgroundColor() {
        return backgroundColor;
    }

    @Deprecated
    @Override
    public void setTextViewStyle(BaseTextView style) {
        mTextView = style;
    }

    @Override
    public BaseTextView getTextViewStyle() {
        mTextView.setFontSize(20);
        return mTextView;
    }

    @Override
    public void setDividerHeight(int height) {
        mDividerHeight = height;
    }

    @Override
    public int getDividerHeight() {
        return mDividerHeight;
    }

    @Override
    public void setDividerColor(int color) {
        mDividerColor = color;
    }

    @Override
    public int getDividerColor() {
        return mDividerColor;
    }
}
