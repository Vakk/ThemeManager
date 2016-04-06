package com.vakk.themeswitcher.theme.element.listview;

import com.vakk.themeswitcher.theme.element.textview.BaseTextView;

/**
 * Created by vakk on 4/6/16.
 */
public interface BaseListView {

    void setBackgroundColor(int textColor);
    int getBackgroundColor();

    void setTextViewStyle(BaseTextView style);
    BaseTextView getTextViewStyle();

    void setDividerHeight(int height);
    int getDividerHeight();

    void setDividerColor(int color);
    int getDividerColor();
}
