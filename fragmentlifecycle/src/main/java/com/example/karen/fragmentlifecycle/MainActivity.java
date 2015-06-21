package com.example.karen.fragmentlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity {

    final String LOG = "activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG, "onDestroy");
    }
}
