package com.example.karen.fragmentdynamic;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;


public class MainActivity extends Activity {

    Fragment frag1;
    Fragment frag2;
    FragmentTransaction fTrans;
    CheckBox chBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new Fragment1();
        frag2 = new Fragment2();
        chBox = (CheckBox)findViewById(R.id.chkboxBackstack);
    }

    public void onClick(View v) {
        fTrans = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btnAdd:
                fTrans.add(R.id.frgmtCont, frag1);
                break;
            case R.id.btnRemove:
                fTrans.remove(frag1);
                break;
            case R.id.btnReplace:
                fTrans.add(R.id.frgmtCont, frag2);
                break;

        }
        if(chBox.isChecked())
            fTrans.addToBackStack(null);
        fTrans.commit();
    }
}
