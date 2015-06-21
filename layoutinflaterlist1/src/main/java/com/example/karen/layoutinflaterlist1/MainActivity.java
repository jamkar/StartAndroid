package com.example.karen.layoutinflaterlist1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    String[] name = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь" };
    String[] position = { "Программер", "Бухгалтер", "Программер",
            "Программер", "Бухгалтер", "Директор", "Программер", "Охранник" };
    int salary[] = { 13000, 10000, 13000, 13000, 10000, 15000, 13000, 8000 };

    int[] colors = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors[0] = Color.parseColor("#559966CC");
        colors[1] = Color.parseColor("#55336699");

        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
        LayoutInflater ltInflater = getLayoutInflater();

        for (int i=0; i < name.length; i++){
            View item = ltInflater.inflate(R.layout.item,linLayout,false);
            TextView tvName = (TextView) item.findViewById(R.id.tvName);
            tvName.setText(name[i]);
            TextView tvPosition = (TextView) item.findViewById(R.id.tvPosition);
            tvPosition.setText("Position: " + position[i]);
            TextView tvSalary = (TextView) item.findViewById(R.id.tvSalary);
            tvSalary.setText("Salary: " + String.valueOf(salary[i]));
            item.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
            item.setBackgroundColor(colors[i%2]);
            linLayout.addView(item);
        }

    }

}
