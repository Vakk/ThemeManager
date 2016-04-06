package com.vakk.themeswitcher.theme;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.vakk.themeswitcher.theme.element.actionbar.BaseActionBar;
import com.vakk.themeswitcher.theme.element.gridview.BaseGridView;
import com.vakk.themeswitcher.theme.element.layout.relative.BaseRelativeLayout;
import com.vakk.themeswitcher.theme.element.listview.BaseListView;
import com.vakk.themeswitcher.theme.element.menu.BaseMenuItem;
import com.vakk.themeswitcher.theme.element.textview.BaseTextView;

/**
 * Created by vakk on 4/5/16.
 */
public abstract class Theme {

    private static final String LOG_TAG = Theme.class.getSimpleName();

    protected int mBackground;

    protected BaseActionBar mActionBarTheme;
    protected BaseTextView mTextViewTheme;
    protected BaseRelativeLayout mRelativeLayoutTheme;
    protected BaseListView mListViewTheme;
    protected BaseGridView mGridViewTheme;
    protected BaseMenuItem mMenuItemTheme;
    private Menu mMenu;


    protected void invalidate(final Activity activity) {
        ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (mActionBarTheme != null) {

            Spannable newTitle = new SpannableString(actionBar.getTitle());
            newTitle.setSpan(new ForegroundColorSpan(mActionBarTheme.getFontColor()), 0, newTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            actionBar.setTitle(newTitle);
            actionBar.setBackgroundDrawable(new ColorDrawable(mActionBarTheme.getBackgroundColor()));

            final ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
            viewGroup.getChildAt(0).setBackgroundColor(mBackground);
            recursiveLoopChildren(viewGroup);
        }
    }

    /**
     * @param parent elements group
     */
    private void recursiveLoopChildren(ViewGroup parent) {
        Log.d(LOG_TAG, " recursive loop method start");
        for (int i = parent.getChildCount() - 1; i >= 0; i--) {
            Log.d(LOG_TAG, " recursive loop start");
            final View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                Log.d(LOG_TAG, child.getClass().getCanonicalName() + " instance of ViewGroup");

                //If you want set background color
                if (child instanceof ListView) {

                    if (mListViewTheme != null) {
                        child.setBackgroundColor(mListViewTheme.getBackgroundColor());
                        ((ListView) child).setDividerHeight(mListViewTheme.getDividerHeight());
                        ((ListView) child).setDivider(new ColorDrawable(mListViewTheme.getDividerColor()));
                    }

                } else if (child instanceof GridView) {
                    if (mGridViewTheme != null) {
                        child.setBackgroundColor(mGridViewTheme.getBackgroundColor());
                        ((GridView) child).setVerticalSpacing(mGridViewTheme.getVerticalPadding());
                        ((GridView) child).setHorizontalSpacing(mGridViewTheme.getHorizontalPadding());
                    }

                }
                recursiveLoopChildren((ViewGroup) child);
                // DO SOMETHING WITH VIEWGROUP,
                // AFTER CHILDREN HAS BEEN LOOPED
            } else {
                Log.d(LOG_TAG, child.getClass().getCanonicalName());
                if (child instanceof AppCompatTextView) { // if we have text view
                    Log.d(LOG_TAG, child.getClass().getCanonicalName() + child.getClass().getSimpleName() + " instance of AppCompactTextView");
                    if (parent instanceof ListView) { // and parent is list view

                        if (mListViewTheme != null) {
                            // set params for child
                            ((TextView) child).setTextSize(mListViewTheme.getTextViewStyle().getFontSize());
                            ((TextView) child).setTextColor(mListViewTheme.getTextViewStyle().getForeground());
                            ((TextView) child).setTypeface(null, mListViewTheme.getTextViewStyle().getTextStyle());
                        }

                    } else if (parent instanceof AbsListView) { // if parent is grid view

                        Log.d(LOG_TAG, parent.getClass().getCanonicalName() + " instance of GridView");
                        if (mGridViewTheme != null) {
                            ((TextView) child).setTextSize(mGridViewTheme.getTextViewStyle().getFontSize());
                            ((TextView) child).setTextColor(mGridViewTheme.getTextViewStyle().getForeground());
                            ((TextView) child).setTypeface(null, mGridViewTheme.getTextViewStyle().getTextStyle());
                        }

                    } else if (mTextViewTheme != null) {

                        ((TextView) child).setTypeface(null, mTextViewTheme.getTextStyle());
                        ((TextView) child).setTextSize(mTextViewTheme.getFontSize());
                        ((TextView) child).setBackgroundColor(mTextViewTheme.getBackGroundColor());
                        ((TextView) child).setTextColor(mTextViewTheme.getForeground());

                    }
                } else if (child instanceof TextView) {

                    if (mGridViewTheme != null) {

                        ((TextView) child).setTextSize(mGridViewTheme.getTextViewStyle().getFontSize());
                        ((TextView) child).setTextColor(mGridViewTheme.getTextViewStyle().getForeground());
                        ((TextView) child).setTypeface(null, mGridViewTheme.getTextViewStyle().getTextStyle());
                        child.setBackgroundColor(mGridViewTheme.getItemBackgroundColor());
                    }

                }
                // ... check other views
            }
        }
    }

    public void invalidateMenu() {

        if (mMenuItemTheme != null&& mMenu != null) {
            for (int i = 0; i < mMenu.size(); i++) {
                MenuItem item = mMenu.getItem(i);
                String title = item.getTitle().toString();
                Spannable newTitle = new SpannableString(title);
                newTitle.setSpan(new ForegroundColorSpan(mMenuItemTheme.getFontColor()), 0, newTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                item.setTitle(newTitle);
            }
        }
    }

    public void setMenu(Menu menu){
        mMenu = menu;
    }
}
