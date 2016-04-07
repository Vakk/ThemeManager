package com.vakk.themeswitcher.theme.element.gridview;

import com.vakk.themeswitcher.theme.element.textview.BaseTextView;

/**
 * Created by vakk on 4/6/16.
 */
public interface BaseGridView {

    @Deprecated
    void setBackgroundColor(int color);
    int getBackgroundColor();

    @Deprecated
    void setItemBackgroundColor(int color);
    int getItemBackgroundColor();

    @Deprecated
    void setTextViewStyle(BaseTextView style);
    BaseTextView getTextViewStyle();

    @Deprecated
    void setVerticalPadding(int padding);
    int getVerticalPadding();

    @Deprecated
    void setHorizontalPadding(int padding);
    int getHorizontalPadding();
}
