package com.punkmkt.rallymaya;

import android.content.res.Configuration;
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
import android.widget.GridView;
import android.widget.ListView;

import com.punkmkt.rallymaya.adapters.ParticipanteAdapter;
import com.punkmkt.rallymaya.adapters.ParticipanteAdapterRecylcer;
import com.punkmkt.rallymaya.models.Participante;

import java.util.ArrayList;


public class ParticipantesActivityList extends ActionBarActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence activityTitle;
    private CharSequence itemTitle;
    private String[] tagTitles;

    private RecyclerView mRecyclerView;
    private GridView grid;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();

    //private PintaImages tarea1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantes_activity_list);

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
       // tarea1 = new PintaImages();
       // tarea1.execute();
        for (int index = 0; index <26; index++) {
            Participante participante = new Participante();
            participante.setId(index + 1);
            participantes.add(participante);
            //Log.e("participantes",participante.toString());
        }
            grid = (GridView)findViewById(R.id.grid_participantes);
            grid.setAdapter(new ParticipanteAdapter(this, R.layout.row_participante, participantes));
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

    /*private class PintaImages extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int index = 0; index <26; index++) {
                Participante participante = new Participante();
                participante.setId(index + 1);
                participantes.add(participante);
            }
            //Log.e("Participantes", participantes.toString());
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_participantes);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setAdapter(new ParticipanteAdapterRecylcer(participantes, R.layout.row_participante_cardview));
            mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            return true;
        }

    }*/
}
