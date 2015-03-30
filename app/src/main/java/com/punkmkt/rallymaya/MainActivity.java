package com.punkmkt.rallymaya;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.punkmkt.rallymaya.adapters.DrawerListAdapter;
import com.punkmkt.rallymaya.adapters.MenuAdapter;

import com.punkmkt.rallymaya.models.DrawerItem;
import com.punkmkt.rallymaya.models.ItemMenu;


public class MainActivity extends BaseActivity {


    private GridView grid;

    private ArrayList<ItemMenu> itemMenus = new ArrayList<ItemMenu>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        /**
         *  We will not use setContentView in this activty
         *  Rather than we will use layout inflater to add view in FrameLayout of our base activity layout*/

        /**
         * Adding our layout to parent class frame layout.
         */
        getLayoutInflater().inflate(R.layout.activity_main, frameLayout);

        /**
         * Setting title and itemChecked
         */
        mDrawerList.setItemChecked(position, true);

        String[] item_menus = getResources().getStringArray(R.array.ItemMenus);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[1]);
        for (int index = 0; index < item_menus.length; index++) {
            ItemMenu menu = new ItemMenu();
            menu.setId(index+1);
            //actionbar.setName(item_menus[index]);
            itemMenus.add(menu);
        }
        grid = (GridView)findViewById(R.id.grid_menu);
        grid.setAdapter(new MenuAdapter(this,R.layout.row_menu, itemMenus));
    }


}