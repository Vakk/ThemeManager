package com.vakk.themeswitcher.theme.element.gridview;

import android.graphics.Color;

import com.vakk.themeswitcher.theme.element.textview.BaseTextView;
import com.vakk.themeswitcher.theme.element.textview.YellowTextView;

/**
 * Created by vakk on 4/6/16.
 */
public class RedGridView implements BaseGridView {
    private int mBackgroundColor = Color.RED;
    private BaseTextView mTextStyle;
    private int mVerticalPadding = 5;
    private int mItemBackground = Color.CYAN;
    private int mHorizontalPadding = 5;

    public RedGridView(){
        mTextStyle = new YellowTextView();
    }
    @Deprecated
    @Override
    public void setBackgroundColor(int backgroundColor) {
        mBackgroundColor = backgroundColor;
    }

    @Override
    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    @Deprecated
    @Override
    public void setItemBackgroundColor(int color) {
        mItemBackground = color;
    }

    @Override
    public int getItemBackgroundColor() {
        return mItemBackground;
    }

    @Deprecated
    @Override
    public void setTextViewStyle(BaseTextView style) {
        mTextStyle = style;
    }

    @Override
    public BaseTextView getTextViewStyle() {
        return mTextStyle;
    }

    @Deprecated
    @Override
    public void setVerticalPadding(int padding) {
        mVerticalPadding = padding;
    }

    @Override
    public int getVerticalPadding() {
        return mVerticalPadding;
    }

    @Override
    public void setHorizontalPadding(int padding) {
        mHorizontalPadding = padding;
    }

    @Override
    public int getHorizontalPadding() {
        return mHorizontalPadding;
    }
}
