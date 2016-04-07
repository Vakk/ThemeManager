package com.vakk.themeswitcher.theme.element.listview;

import com.vakk.themeswitcher.theme.element.textview.BaseTextView;

/**
 * Created by vakk on 4/6/16.
 */
public interface BaseListView {

    @Deprecated
    void setBackgroundColor(int textColor);
    int getBackgroundColor();

    @Deprecated
    void setTextViewStyle(BaseTextView style);
    BaseTextView getTextViewStyle();

    @Deprecated
    void setDividerHeight(int height);
    int getDividerHeight();

    @Deprecated
    void setDividerColor(int color);
    int getDividerColor();
}
