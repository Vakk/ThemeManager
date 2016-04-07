package com.vakk.themeswitcher.theme.element.listview;

import android.graphics.Color;

import com.vakk.themeswitcher.theme.element.textview.BaseTextView;
import com.vakk.themeswitcher.theme.element.textview.WhiteTextView;
import com.vakk.themeswitcher.theme.element.textview.YellowTextView;

/**
 * Created by vakk on 4/6/16.
 */
public class WhiteListView implements BaseListView {

    private int mBackgroundColor = Color.WHITE;
    private  BaseTextView mTextViewStyle;
    private int mDividerHeight = 5;
    private int mDividerColor = Color.BLACK;

    public WhiteListView(){mTextViewStyle = new YellowTextView();}

    @Deprecated
    @Override
    public void setBackgroundColor(int textColor) {
        mBackgroundColor = textColor;
    }
    @Override
    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    @Deprecated
    @Override
    public void setTextViewStyle(BaseTextView style) {
        mTextViewStyle = style;
    }
    @Override
    public BaseTextView getTextViewStyle() {
        return mTextViewStyle;
    }

    @Deprecated
    @Override
    public void setDividerHeight(int height) {
        mDividerHeight = height;
    }
    @Override
    public int getDividerHeight() {
        return mDividerHeight;
    }

    @Deprecated
    @Override
    public void setDividerColor(int color) {
        mDividerColor = color;
    }
    @Override
    public int getDividerColor() {
        return mDividerColor;
    }
}
