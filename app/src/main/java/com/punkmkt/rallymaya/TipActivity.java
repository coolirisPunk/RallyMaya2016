package com.punkmkt.rallymaya;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.punkmkt.rallymaya.fragments.Diccionario_maya;
import com.punkmkt.rallymaya.fragments.Lugar_visita;
import com.punkmkt.rallymaya.fragments.Tip_viaje;


public class TipActivity extends ActionBarActivity {
    PagerSlidingTabStrip tabs;
    private Drawable oldBackground = null;
    private int currentColor = 0xFF666666;
    private final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
       // tabs.setDividerColorResource(Color.WHITE);
        tabs.setTextColor(Color.WHITE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tips, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
