package com.vakk.themeswitcher.theme;

import android.app.Activity;
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
        if (mActionBarTheme != null && actionBar != null) {

            // draw text on action bar with needed color

            Spannable newTitle = new SpannableString(actionBar.getTitle());
            newTitle.setSpan(new ForegroundColorSpan(mActionBarTheme.getFontColor()), 0, newTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            actionBar.setTitle(newTitle);
            actionBar.setBackgroundDrawable(new ColorDrawable(mActionBarTheme.getBackgroundColor()));
        }

        final ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content); // root view
        viewGroup.getChildAt(0).setBackgroundColor(mBackground); // main background
            recursiveLoopChildren(viewGroup);
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

                foundViewGroup(child, parent);

            } else {

                if (child instanceof AppCompatTextView) { // if we have text view

                    foundAppCompactTextView(child, parent);

                } else if (child instanceof TextView) { //

                    foundTextView(child, parent);

                }
                // ... check other views
            }
        }
    }

    private void foundAppCompactTextView(View child, ViewGroup parent) {

        Log.d(LOG_TAG, child.getClass().getCanonicalName() + child.getClass().getSimpleName() + " instance of AppCompactTextView");
        if (parent instanceof ListView) { //  if parent is list view - we on grid view item

            if (mListViewTheme != null) {

                // set params for items
                ((TextView) child).setTextSize(mListViewTheme.getTextViewStyle().getFontSize());
                ((TextView) child).setTextColor(mListViewTheme.getTextViewStyle().getForeground());
                ((TextView) child).setTypeface(null, mListViewTheme.getTextViewStyle().getTextStyle());
            }

        } else if (parent instanceof GridView) { // if parent is grid view - we on grid view item

            Log.d(LOG_TAG, parent.getClass().getCanonicalName() + " instance of GridView");
            if (mGridViewTheme != null) {

                // set params for items
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

    }

    private void foundTextView(View child, ViewGroup parent) {
        if (parent instanceof GridView) {

            ((TextView) child).setTextSize(mGridViewTheme.getTextViewStyle().getFontSize());
            ((TextView) child).setTextColor(mGridViewTheme.getTextViewStyle().getForeground());
            ((TextView) child).setTypeface(null, mGridViewTheme.getTextViewStyle().getTextStyle());
            child.setBackgroundColor(mGridViewTheme.getItemBackgroundColor());

        } else {

            ((TextView) child).setTextSize(mTextViewTheme.getFontSize());
            ((TextView) child).setTextColor(mTextViewTheme.getForeground());
            ((TextView) child).setTypeface(null, mTextViewTheme.getTextStyle());

        }
    }

    private void foundViewGroup(View child, ViewGroup parent) {
        Log.d(LOG_TAG, child.getClass().getCanonicalName() + " instance of ViewGroup");

        if (child instanceof ListView) {

            if (mListViewTheme != null) {
                child.setBackgroundColor(mListViewTheme.getBackgroundColor());
                ((ListView) child).setDividerHeight(mListViewTheme.getDividerHeight());
                ((ListView) child).setDivider(new ColorDrawable(mListViewTheme.getDividerColor()));
            }

        } else if (child instanceof GridView) {
            if (mGridViewTheme != null) {
                child.setBackgroundColor(mGridViewTheme.getBackgroundColor()); // set main background (divider)
                ((GridView) child).setVerticalSpacing(mGridViewTheme.getVerticalPadding()); // divider
                ((GridView) child).setHorizontalSpacing(mGridViewTheme.getHorizontalPadding()); // divider
            }

        }
        recursiveLoopChildren((ViewGroup) child);
        // DO SOMETHING WITH VIEWGROUP,
        // AFTER CHILDREN HAS BEEN LOOPED
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
