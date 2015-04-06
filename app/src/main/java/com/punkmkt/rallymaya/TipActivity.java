package com.punkmkt.rallymaya;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;
import com.punkmkt.rallymaya.fragments.Diccionario_maya;
import com.punkmkt.rallymaya.fragments.Lugar_visita;
import com.punkmkt.rallymaya.fragments.Tip_viaje;


public class TipActivity extends BaseActivity {
    PagerSlidingTabStrip tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_tips, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[5]);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setTabBackgroundColorTab(R.drawable.background_tab);
        tabs.setTabBackgroundColorCurrentTab(R.drawable.background_current_tab);
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
                    title= "TIPS DE VIAJE";
                    break;
                case 1:
                    title= "LUGARES DE VISITA";
                    break;
                case 2:
                    title= "DICCIONARIO MAYA";
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
                     fm= new Tip_viaje();
                break;
                case 1:
                    fm= new Lugar_visita();
                break;
                case 2:
                    fm= new Diccionario_maya();
                break;
            }
            return fm;
        }
    }







}
