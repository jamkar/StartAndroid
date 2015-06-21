package com.example.karen.animation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANS_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.add(0,MENU_ALPHA_ID,0,"Alpha");
        menu.add(0,MENU_SCALE_ID,0,"Scale");
        menu.add(0,MENU_TRANS_ID,0,"Trans");
        menu.add(0,MENU_ROTATE_ID,0,"Rotate");
        menu.add(0,MENU_COMBO_ID,0,"Combo");

        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Animation anim = null;

        switch (item.getItemId())
        {
            case MENU_ALPHA_ID:
                anim = AnimationUtils.loadAnimation(this,R.anim.myalpha);
                break;
            case MENU_SCALE_ID:
                anim = AnimationUtils.loadAnimation(this,R.anim.myscale);
                break;
            case MENU_TRANS_ID:
                anim = AnimationUtils.loadAnimation(this,R.anim.mytrans);
                break;
            case MENU_ROTATE_ID:
                anim = AnimationUtils.loadAnimation(this,R.anim.myrotate);
                break;
            case MENU_COMBO_ID:
                anim = AnimationUtils.loadAnimation(this,R.anim.mycombo);
                break;
        }

        tv.startAnimation(anim);

        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
