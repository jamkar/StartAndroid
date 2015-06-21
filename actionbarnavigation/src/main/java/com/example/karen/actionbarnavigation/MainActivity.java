package com.example.karen.actionbarnavigation;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity implements ActionBar.TabListener, ActionBar.OnNavigationListener {

    final String LOG_TAG = "myLogs";
    String[] data = new String[] { "one", "two", "three" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getActionBar();

        //bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Tab tab = bar.newTab();
        tab.setText("tab1");
        tab.setTabListener(this);
        bar.addTab(tab);

        tab = bar.newTab();
        tab.setText("tab2");
        tab.setTabListener(this);
        bar.addTab(tab);


        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bar.setListNavigationCallbacks(adapter, this);
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
        Log.d(LOG_TAG, "reselected tab: " + tab.getText());
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        Log.d(LOG_TAG, "selected tab: " + tab.getText());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        Log.d(LOG_TAG, "unselected tab: " + tab.getText());
    }



    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Log.d(LOG_TAG, "selected: position = " + itemPosition + ", id = "
                + itemId + ", " + data[itemPosition]);
        return false;
    }
}