package com.punkmkt.rallymaya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class DiabetesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_diabetes, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[7]);
    }



}
