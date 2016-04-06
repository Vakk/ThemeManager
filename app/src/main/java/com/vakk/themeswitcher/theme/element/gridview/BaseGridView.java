package com.vakk.themeswitcher.theme.element.gridview;

import com.vakk.themeswitcher.theme.element.textview.BaseTextView;

/**
 * Created by vakk on 4/6/16.
 */
public interface BaseGridView {

    void setBackgroundColor(int color);
    int getBackgroundColor();

    void setItemBackgroundColor(int color);
    int getItemBackgroundColor();

    void setTextViewStyle(BaseTextView style);
    BaseTextView getTextViewStyle();

    void setVerticalPadding(int padding);
    int getVerticalPadding();

    void setHorizontalPadding(int padding);
    int getHorizontalPadding();
}
