package com.punkmkt.rallymaya;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.punkmkt.rallymaya.adapters.MenuAdapter;
import com.punkmkt.rallymaya.adapters.ParticipanteAdapter;
import com.punkmkt.rallymaya.models.Participante;

import java.util.ArrayList;


public class ParticipantesActivityDetail extends ActionBarActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence activityTitle;
    private CharSequence itemTitle;
    private String[] tagTitles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantes_activity_detail);

        itemTitle = activityTitle = getTitle();
        tagTitles = getResources().getStringArray(R.array.ItemMenusSec);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        // Setear una sombra sobre el contenido principal cuando el drawer se despliegue
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        //Crear elementos de la lista
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


        // Relacionar el adaptador y la escucha de la lista del drawer
        drawerList.setAdapter(new DrawerListAdapter(this, items));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        // Habilitar el icono de la app por si hay algún estilo que lo deshabilitó
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Crear ActionBarDrawerToggle para la apertura y cierre
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.drawable.ic_drawer,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(itemTitle);

                /*Usa este método si vas a modificar la action bar
                con cada fragmento
                 */
                //invalidateOptionsMenu();
            }
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(activityTitle);

                /*Usa este método si vas a modificar la action bar
                con cada fragmento
                 */
                //invalidateOptionsMenu();
            }
        };
        //Seteamos la escucha
        drawerLayout.setDrawerListener(drawerToggle);
        if (savedInstanceState == null) {
            //    selectItem(0);
        }
        ImageView image = (ImageView) findViewById(R.id.image_participante);
        Intent intent = getIntent();
        Integer participante_id = intent.getIntExtra("PARTICIPANTE_ID", 0);
        switch (participante_id){
            case 1:
                image.setImageResource(R.drawable.participante_1_detail);
                break;
            case 2:
                image.setImageResource(R.drawable.participante_2_detail);
                break;
            case 3:
                image.setImageResource(R.drawable.participante_3_detail);
                break;
            case 4:
                image.setImageResource(R.drawable.participante_4_detail);
                break;
            case 5:
                image.setImageResource(R.drawable.participante_5_detail);
                break;
            case 6:
                image.setImageResource(R.drawable.participante_6_detail);
                break;
            case 7:
                image.setImageResource(R.drawable.participante_7_detail);
                break;
            case 8:
                image.setImageResource(R.drawable.participante_8_detail);
                break;
            case 9:
                image.setImageResource(R.drawable.participante_9_detail);
                break;
            case 10:
                image.setImageResource(R.drawable.participante_10_detail);
                break;
            case 11:
                image.setImageResource(R.drawable.participante_11_detail);
                break;
            case 12:
                image.setImageResource(R.drawable.participante_12_detail);
                break;
            case 13:
                image.setImageResource(R.drawable.participante_13_detail);
                break;
            case 14:
                image.setImageResource(R.drawable.participante_14_detail);
                break;
            case 15:
                image.setImageResource(R.drawable.participante_15_detail);
                break;
            case 16:
                image.setImageResource(R.drawable.participante_16_detail);
                break;
            case 17:
                image.setImageResource(R.drawable.participante_17_detail);
                break;
            case 18:
                image.setImageResource(R.drawable.participante_18_detail);
                break;
            case 19:
                image.setImageResource(R.drawable.participante_19_detail);
                break;
            case 20:
                image.setImageResource(R.drawable.participante_20_detail);
                break;
            case 21:
                image.setImageResource(R.drawable.participante_21_detail);
                break;
            case 22:
                image.setImageResource(R.drawable.participante_22_detail);
                break;
            case 23:
                image.setImageResource(R.drawable.participante_23_detail);
                break;
            case 24:
                image.setImageResource(R.drawable.participante_24_detail);
                break;
            case 25:
                image.setImageResource(R.drawable.participante_25_detail);
                break;
            case 26:
                image.setImageResource(R.drawable.participante_26_detail);
                break;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rally_maya, menu);
        return true;
    }
    /* La escucha del ListView en el Drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        drawerList.setItemChecked(position, true);
        setTitle(tagTitles[position]);
        drawerLayout.closeDrawer(drawerList);
    }

    /* Método auxiliar para setear el titulo de la action bar */
    @Override
    public void setTitle(CharSequence title) {
        itemTitle = title;
        getSupportActionBar().setTitle(itemTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sincronizar el estado del drawer
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Cambiar las configuraciones del drawer si hubo modificaciones
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (drawerToggle.onOptionsItemSelected(item)) {
            // Toma los eventos de selección del toggle aquí
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
