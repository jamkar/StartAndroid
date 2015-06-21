package com.example.karen.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;




public class MainActivity extends ActionBarActivity implements OnClickListener{

    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String oper = "";

    final int MENU_RESET_ID = 1;
    final int MENU_QUIT_ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText)findViewById(R.id.etNum1);
        etNum2 = (EditText)findViewById(R.id.etNum2);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnMult = (Button)findViewById(R.id.btnMult);
        btnSub = (Button)findViewById(R.id.btnSub);
        tvResult = (TextView)findViewById(R.id.tvResult);

        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if (TextUtils.isEmpty(etNum1.getText()) || TextUtils.isEmpty(etNum2.getText()))
            return;

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        switch (v.getId())
        {
            case R.id.btnAdd:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                break;
            case R.id.btnMult:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                break;
            default:
                break;
        }

        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(0,MENU_RESET_ID,0,"Reset");
        menu.add(0,MENU_QUIT_ID,0,"Quit");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id)
        {
            case MENU_RESET_ID:
                tvResult.setText("");
                etNum1.setText("");
                etNum2.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;

        }
        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


}
