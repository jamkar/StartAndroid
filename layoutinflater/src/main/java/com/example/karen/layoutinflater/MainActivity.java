package com.example.karen.layoutinflater;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linLayout = (LinearLayout)findViewById(R.id.linLayout);
        RelativeLayout relLayout = (RelativeLayout)findViewById(R.id.relLayout);

        LayoutInflater ltInflater = getLayoutInflater();
        View view = ltInflater.inflate(R.layout.text,linLayout,true);
        View view1 = ltInflater.inflate(R.layout.text,relLayout,true);
        //ViewGroup.LayoutParams lp = view.getLayoutParams();



        //linLayout.addView(view);
        //relLayout.addView(view1);

    }

}
