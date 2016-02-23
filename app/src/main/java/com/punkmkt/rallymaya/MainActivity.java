package com.punkmkt.rallymaya;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.punkmkt.rallymaya.adapters.MenuAdapter;

import com.punkmkt.rallymaya.models.ItemMenu;


public class MainActivity extends BaseActivity {


    private GridView grid;

    private ArrayList<ItemMenu> itemMenus = new ArrayList<ItemMenu>();
    public static Activity fa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fa = this;
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