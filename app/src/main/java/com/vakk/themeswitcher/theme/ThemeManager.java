package com.vakk.themeswitcher.theme;

import android.app.Activity;
import android.view.Menu;

/**
 * Created by vakk on 4/5/16.
 */
public class ThemeManager {

    protected static Theme mCurrentTheme;

    private static ThemeManager instance;

    private ThemeManager(Activity activity) {
        getTheme(activity);
    }


    public Theme setTheme(Activity activity, Theme theme) {
        mCurrentTheme = theme;
        invalidate(activity);
        return mCurrentTheme;
    }

    public Theme getTheme(Activity activity) {
        if (mCurrentTheme != null) {
            invalidate(activity);
            return mCurrentTheme;
        }
        mCurrentTheme = new BlueTheme();
        invalidate(activity);
        return mCurrentTheme;
    }

    public void invalidate(Activity activity){
        mCurrentTheme.invalidate(activity);
    }

    public void invalidate(Menu menu){
        mCurrentTheme.setMenu(menu);
        mCurrentTheme.invalidateMenu();
    }

    public static ThemeManager getInstance(Activity activity) {
        if (instance != null) {
            return instance;
        }
        instance = new ThemeManager(activity);
        return instance;
    }

}
