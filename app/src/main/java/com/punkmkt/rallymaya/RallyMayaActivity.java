package com.punkmkt.rallymaya;

import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.punkmkt.rallymaya.adapters.DrawerListAdapter;
import com.punkmkt.rallymaya.models.DrawerItem;
import com.punkmkt.rallymaya.models.ItemMenu;

import java.util.ArrayList;


public class RallyMayaActivity extends BaseActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence activityTitle;
    private CharSequence itemTitle;
    private String[] tagTitles;

    private ArrayList<ItemMenu> itemMenus = new ArrayList<ItemMenu>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_rally_maya, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[1]);

    }
}
