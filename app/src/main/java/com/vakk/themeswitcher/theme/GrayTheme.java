package com.vakk.themeswitcher.theme;

import android.app.Activity;
import android.graphics.Color;

import com.vakk.themeswitcher.theme.element.actionbar.YellowActionBar;
import com.vakk.themeswitcher.theme.element.listview.BlackListView;
import com.vakk.themeswitcher.theme.element.textview.WhiteTextView;

/**
 * Created by vakk on 4/5/16.
 */
public class GrayTheme extends Theme {

    /**
     * int constructor you can use written templates
     */
    public GrayTheme(){
        mActionBarTheme = new YellowActionBar();
        mTextViewTheme = new WhiteTextView();
        mBackground = Color.GRAY;
        mListViewTheme = new BlackListView();
    }

    public void invalidate(Activity activity){
        super.invalidate(activity);
    }
}
