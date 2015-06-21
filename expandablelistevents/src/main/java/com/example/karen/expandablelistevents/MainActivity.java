package com.example.karen.expandablelistevents;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    ExpandableListView elvMain;
    AdapterHelper ah;
    SimpleExpandableListAdapter adapter;
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.tvInfo);

        // создаем адаптер
        ah = new AdapterHelper(this);
        adapter = ah.getAdapter();

        elvMain = (ExpandableListView) findViewById(R.id.elvMain);
        elvMain.setAdapter(adapter);

        elvMain.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                tvInfo.setText(ah.getGroupText(groupPosition));
                return false;
            }
        });

        elvMain.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                tvInfo.setText(ah.getGroupChildText(groupPosition, childPosition));
                return false;
            }
        });

    }
}
