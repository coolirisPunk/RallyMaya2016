package com.punkmkt.rallymaya;

import android.os.Bundle;


public class ProgramaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.fa.finish();
        getLayoutInflater().inflate(R.layout.activity_programa, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[2]);
    }


}
