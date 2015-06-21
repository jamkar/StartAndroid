package com.example.karen.customadapter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ArrayList<Product> products = new ArrayList<Product>();
    BoxAdapter boxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создаем адаптер
        fillData();
        boxAdapter = new BoxAdapter(this, products);

        // настраиваем список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
    }

    // генерируем данные для адаптера
    void fillData() {
        for (int i=1; i<=20; i++) {
            products.add(new Product("Product" + i, i*1000, R.mipmap.ic_launcher, false));
        }
    }

    // выводим информацию о корзине
    public void showResult(View v) {
        String prod = "Buy";
        /*for (int i=0; i<(boxAdapter.getBox().size()); i++) {
            prod += "\n" + boxAdapter.getBox().get(i).name;
        }*/

        for(Product p : boxAdapter.getBox()) {
            prod += "\n" + p.name;
        }

        Toast.makeText(this,prod,Toast.LENGTH_LONG).show();
    }
}
