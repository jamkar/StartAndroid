package com.example.karen.touch;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnTouchListener{

    TextView tv;
    float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        tv.setOnTouchListener(this);
        setContentView(tv);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        String action = "";

        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                    action = "Down";
                break;
            case MotionEvent.ACTION_MOVE:
                    action = "Move";
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                    action = "up";
                break;
        }
        tv.setText("x = " + x + "; y = " + y + "\n" + action);
        return true;
    }
}
