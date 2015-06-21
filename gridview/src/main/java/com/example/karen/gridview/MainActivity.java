package com.example.karen.gridview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;


public class MainActivity extends ActionBarActivity {

    String data[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

    GridView gvMain;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, data);
        gvMain = (GridView)findViewById(R.id.gvMain);
        gvMain.setAdapter(adapter);
        adjustGridView();
    }

    void adjustGridView() {
        gvMain.setNumColumns(3);
        gvMain.setColumnWidth(50);
        gvMain.setHorizontalSpacing(5);
        gvMain.setVerticalSpacing(5);
        gvMain.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
    }
}
