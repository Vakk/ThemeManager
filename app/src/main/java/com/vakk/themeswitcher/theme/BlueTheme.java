package com.vakk.themeswitcher.theme;

import android.app.Activity;
import android.graphics.Color;

import com.vakk.themeswitcher.theme.element.actionbar.BlueActionBar;
import com.vakk.themeswitcher.theme.element.gridview.RedGridView;
import com.vakk.themeswitcher.theme.element.listview.WhiteListView;
import com.vakk.themeswitcher.theme.element.menu.GreenMenuItem;
import com.vakk.themeswitcher.theme.element.textview.YellowTextView;

/**
 * Created by vakk on 4/6/16.
 */
public class BlueTheme extends Theme {
    /**
     * @see GrayTheme
     */
    public BlueTheme() {
        mActionBarTheme = new BlueActionBar();
        mTextViewTheme = new YellowTextView();
        mBackground = Color.BLUE;
        mListViewTheme = new WhiteListView();
        mGridViewTheme = new RedGridView();
        mMenuItemTheme = new GreenMenuItem();
    }

    public void invalidate(Activity activity) {
        super.invalidate(activity);
    }
}
