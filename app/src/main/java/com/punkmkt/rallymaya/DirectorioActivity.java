package com.punkmkt.rallymaya;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.punkmkt.rallymaya.fragments.DirectorioCampeche;
import com.punkmkt.rallymaya.fragments.DirectorioQuintanaRoo;
import com.punkmkt.rallymaya.fragments.DirectorioYucatan;

public class DirectorioActivity extends BaseActivity {
    PagerSlidingTabStrip tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_directorio, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[7]);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
        tabs.setTextColor(Color.WHITE);

    }



    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            String title ="";
            switch (position){
                case 0:
                    title= "CAMPECHE";
                    break;
                case 1:
                    title= "YUCATÁN";
                    break;
                case 2:
                    title= "QUINTANA ROO";
                    break;
            }
            return title;
        }
        @Override
        public int getCount() {
            return 3;
        }
        @Override
        public Fragment getItem(int position) {
            Fragment fm = new Fragment();
            switch (position){
                case 0:
                    fm= new DirectorioCampeche();
                    break;
                case 1:
                    fm= new DirectorioYucatan();
                    break;
                case 2:
                    fm= new DirectorioQuintanaRoo();
                    break;
            }
            return fm;
        }

    }


}
