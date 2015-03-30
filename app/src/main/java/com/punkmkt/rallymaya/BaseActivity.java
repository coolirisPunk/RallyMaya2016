package com.punkmkt.rallymaya;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.punkmkt.rallymaya.adapters.DrawerListAdapter;
import com.punkmkt.rallymaya.models.DrawerItem;

import java.util.ArrayList;


public class BaseActivity extends ActionBarActivity {
    /**
     *  Frame layout: Which is going to be used as parent layout for child activity layout.
     *  This layout is protected so that child activity can access this
     *  */
    protected FrameLayout frameLayout;

    /**
     * ListView to add navigation drawer item in it.
     * We have made it protected to access it in child class. We will just use it in child class to make item selected according to activity opened.
     */

    protected ListView mDrawerList;


    /**
     * Static variable for selected item position. Which can be used in child activity to know which item is selected from the list.
     * */
    protected static int position;

    /**
     *  This flag is used just to check that launcher activity is called first time
     *  so that we can open appropriate Activity on launch and make list item position selected accordingly.
     * */
    private static boolean isLaunch = true;

    /**
     *  Base layout node of this Activity.
     * */
    private DrawerLayout mDrawerLayout;

    /**
     * Drawer listner class for drawer open, close etc.
     */

    private String[] tagTitles;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        frameLayout = (FrameLayout)findViewById(R.id.content_frame);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        tagTitles = getResources().getStringArray(R.array.ItemMenusSec);
        // set a custom shadow that overlays the main content when the drawer opens
        //mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        ArrayList<DrawerItem> items = new ArrayList<DrawerItem>();

        items.add(new DrawerItem(tagTitles[0],R.drawable.home_sec));
        items.add(new DrawerItem(tagTitles[1],R.drawable.rally_maya_sec));
        items.add(new DrawerItem(tagTitles[2],R.drawable.participantes_sec));
        items.add(new DrawerItem(tagTitles[3],R.drawable.ruta_sec));
        items.add(new DrawerItem(tagTitles[4],R.drawable.tips_sec));
        items.add(new DrawerItem(tagTitles[5],R.drawable.patrocinadores_sec));
        items.add(new DrawerItem(tagTitles[6],R.drawable.directorio_sec));
        items.add(new DrawerItem(tagTitles[7],R.drawable.diabetes_sec));
        items.add(new DrawerItem(tagTitles[8],R.drawable.cronometro_sec));
        items.add(new DrawerItem(tagTitles[9],R.drawable.facebook_sec));
        items.add(new DrawerItem(tagTitles[10],R.drawable.twitter_sec));


        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new DrawerListAdapter(this, items));
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                openActivity(position);
            }
        });
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // ActionBarDrawerToggle ties together the the proper interactions between the sliding drawer and the action bar app icon
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,						/* host Activity */
                mDrawerLayout, 				/* DrawerLayout object */
                R.drawable.menu,     /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,       /* "open drawer" description for accessibility */
                R.string.drawer_close)      /* "close drawer" description for accessibility */
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                //getActionBar().setTitle(listArray[position]);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
               // getActionBar().setTitle(getString(R.string.app_name));
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        };
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

/**
 * As we are calling BaseActivity from manifest file and this base activity is intended just to add navigation drawer in our app.
 * We have to open some activity with layout on launch. So we are checking if this BaseActivity is called first time then we are opening our first activity.
 * */
        if(isLaunch){
            /**
             *Setting this flag false so that next time it will not open our first activity.
             *We have to use this flag because we are using this BaseActivity as parent activity to our other activity.
             *In this case this base activity will always be call when any child activity will launch.
             */
            isLaunch = false;
            openActivity(0);
        }

    }
    /**
     * @param position
     *
     * Launching activity when any list item is clicked.
     */
    protected void openActivity(int position) {
        /**
         * We can set title & itemChecked here but as this BaseActivity is parent for other activity,
         * So whenever any activity is going to launch this BaseActivity is also going to be called and
         * it will reset this value because of initialization in onCreate method.
         * So that we are setting this in child activity.
         */
//		mDrawerList.setItemChecked(position, true);
//		setTitle(listArray[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
        BaseActivity.position = position; //Setting currently selected position in this field so that it will be available in our child activities.
        Intent intent;
        switch(position){
            case 0:
                intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, RallyMayaActivity.class);
                this.startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, ParticipantesActivityList.class);
                this.startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, RutaActivity.class);
                this.startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, TipActivity.class);
                this.startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, PatrocinadorActivity.class);
                this.startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, DirectorioActivity.class);
                this.startActivity(intent);
                break;
            case 7:
                intent = new Intent(this, DiabetesActivity.class);
                this.startActivity(intent);
                break;
            case 8:
                intent = new Intent(this, CronometroActivity.class);
                this.startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sincronizar el estado del drawer
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Cambiar las configuraciones del drawer si hubo modificaciones
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }


}
