package com.punkmkt.rallymaya;

import android.os.Bundle;

public class DiabetesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_diabetes, frameLayout);
        String title;
        title = getResources().getString(R.string.diabetes_seccion);
        setTitle(title);
    }



}
