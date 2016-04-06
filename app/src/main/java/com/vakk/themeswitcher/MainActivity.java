package com.vakk.themeswitcher;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.vakk.themeswitcher.theme.BlueTheme;
import com.vakk.themeswitcher.theme.GrayTheme;
import com.vakk.themeswitcher.theme.ThemeManager;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.security.auth.callback.Callback;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private ThemeManager mThemeManager;
    private GridView mGridView;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=this;
        setContentView(R.layout.activity_main);
        mGridView = (GridView)findViewById(R.id.gridView);
        mGridView.setAdapter( new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.list_view_items)));
    }

     Handler handler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
                if (mGridView.getChildCount() != 0) { // need check size one of list or grid view
                    Log.d(LOG_TAG, " handle message");
                    thread.interrupt();
                    mThemeManager.invalidate(activity);
            }
            return false;
        }
    });

    final Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            boolean stop = false;
            while(!stop){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    stop = true;
                }
                    handler.obtainMessage().sendToTarget();
            }
        }
    });

    @Override
    protected void onResume() {
        super.onResume();
        mThemeManager = ThemeManager.getInstance(this);
        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.preferences, menu);
        mThemeManager.invalidate(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.blue_theme: {
                mThemeManager.setTheme(this, new BlueTheme());
                break;
            }

            case R.id.gray_theme: {
                mThemeManager.setTheme(this, new GrayTheme());
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
