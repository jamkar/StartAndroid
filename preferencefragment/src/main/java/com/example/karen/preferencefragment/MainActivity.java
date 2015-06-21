package com.example.karen.preferencefragment;

import java.util.List;

import android.preference.PreferenceActivity;

public class MainActivity extends PreferenceActivity {

    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.pref_head, target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return Fragment1.class.getName().equals(fragmentName) || Fragment2.class.getName().equals(fragmentName);
    }
}