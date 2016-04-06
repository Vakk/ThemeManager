package com.vakk.themeswitcher.theme;

import android.app.Activity;
import android.view.Menu;

/**
 * Created by vakk on 4/5/16.
 */
public class ThemeManager {


    protected static Theme mCurrentTheme;       // current set up theme

    private static ThemeManager instance;       // theme manager instance (single tone)

    private ThemeManager(Activity activity) {
        getTheme(activity); // init theme manager
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
        mCurrentTheme = new BlueTheme(); // default theme, because can be null pointer ex
        invalidate(activity);
        return mCurrentTheme;
    }

    /**
     * invalidate activity
     * @param activity current activity
     */
    public void invalidate(Activity activity){
        mCurrentTheme.invalidate(activity);
    }

    /**
     * invalidate menu
     * @param menu current menu
     */
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
