package com.punkmkt.rallymaya;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.punkmkt.rallymaya.utils.BitmapManager;
import com.punkmkt.rallymaya.utils.NetworkUtils;


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
        //setTitle(item_menus_sec[2]);
        ImageView image = (ImageView) findViewById(R.id.image_participante);
        Intent intent = getIntent();
        Integer p_id = intent.getIntExtra("id", 0);
        String p_nombre = intent.getStringExtra("nombre");
        String p_image = intent.getStringExtra("image");
        String p_year = intent.getStringExtra("year");
        Log.e("Intent",p_nombre + p_year + p_image);
        if(NetworkUtils.haveNetworkConnection(this)) {
            setTitle(p_nombre + " " + p_year);
            BitmapManager.getInstance().loadBitmap(p_image, image);
        }

    else{
        Toast.makeText(getApplicationContext(), getResources().getString(R.string.revise_conexion), Toast.LENGTH_SHORT).show();
    }

    }


}
