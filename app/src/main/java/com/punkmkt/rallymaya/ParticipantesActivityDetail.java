package com.punkmkt.rallymaya;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class ParticipantesActivityDetail extends BaseActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence activityTitle;
    private CharSequence itemTitle;
    private String[] tagTitles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_participantes_activity_detail, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[2]);
        ImageView image = (ImageView) findViewById(R.id.image_participante);
        TextView title = (TextView) findViewById(R.id.title);
        Intent intent = getIntent();
        Integer p_id = intent.getIntExtra("id", 0);
        String p_nombre = intent.getStringExtra("nombre");
        String p_image = intent.getStringExtra("image");
        String p_year = intent.getStringExtra("year");

        title.setText(p_nombre + p_year);


    }


}
