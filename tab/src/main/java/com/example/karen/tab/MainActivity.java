package com.example.karen.tab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        // �������������
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        // ������� ������� � ��������� ���
        tabSpec = tabHost.newTabSpec("tag1");
        // �������� �������
        tabSpec.setIndicator("Tab 1");
        // ��������� id ���������� �� FrameLayout, �� � ������ ����������
        tabSpec.setContent(R.id.tvTab1);
        // ��������� � �������� �������
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        // ��������� �������� � ��������
        // � ����� ������ ������ �������� ���� xml-����,
        // ������� ���������� �������� �� ��������� �������
        tabSpec.setIndicator("Tab 2", getResources().getDrawable(R.drawable.tab_icon_selector));
        tabSpec.setContent(R.id.tvTab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        // ������� View �� layout-�����
        View v = getLayoutInflater().inflate(R.layout.tab_header, null);
        // � ������������� ���, ��� ���������
        tabSpec.setIndicator(v);
        tabSpec.setContent(R.id.tvTab3);
        tabHost.addTab(tabSpec);

        // ������ ������� ����� ������� �� ���������
        tabHost.setCurrentTabByTag("tag2");

        // ���������� ������������ �������
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            public void onTabChanged(String tabId) {
                Toast.makeText(getBaseContext(), "tabId = " + tabId, Toast.LENGTH_SHORT).show();
            }
        });
    }
}