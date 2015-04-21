package com.punkmkt.rallymaya;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.punkmkt.rallymaya.models.ItemMenu;

import java.util.ArrayList;


public class RallyMayaActivity extends BaseActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence activityTitle;
    private CharSequence itemTitle;
    private String[] tagTitles;
    public static Activity fa;
    private ArrayList<ItemMenu> itemMenus = new ArrayList<ItemMenu>();

    Intent intent;
    Intent intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MainActivity.fa.finish();
        //fa = this;
        getLayoutInflater().inflate(R.layout.activity_rally_maya, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[1]);

        ImageView img_causa = (ImageView) findViewById(R.id.img_causa);
        ImageView img_reglamento = (ImageView) findViewById(R.id.img_reglamento);
        img_causa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), DiabetesActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //finish();
                getApplicationContext().startActivity(intent);

            }
        });
        img_reglamento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent2 = new Intent(getApplicationContext(), MyPdfViewActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //finish();
                getApplicationContext().startActivity(intent2);

            }
        });

    }
}
