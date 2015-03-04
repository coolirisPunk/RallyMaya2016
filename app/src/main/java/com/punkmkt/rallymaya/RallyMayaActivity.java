package com.punkmkt.rallymaya;

import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.punkmkt.rallymaya.models.ItemMenu;

import java.util.ArrayList;


public class RallyMayaActivity extends ActionBarActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence activityTitle;
    private CharSequence itemTitle;
    private String[] tagTitles;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemMenu> itemMenus = new ArrayList<ItemMenu>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rally_maya);

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
        String[] item_menus = getResources().getStringArray(R.array.ItemMenus);

        for (int index = 0; index < item_menus.length; index++) {
            ItemMenu menu = new ItemMenu();
            menu.setId(index+1);
            //actionbar.setName(item_menus[index]);
            itemMenus.add(menu);
        }
        TextView title_section=(TextView)findViewById(R.id.title_section);
        TextView description_section=(TextView)findViewById(R.id.description_section);
        MyApplication application = (MyApplication) getApplication();
        application.setTypeface(title_section);
        application.setTypeface(description_section);
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
        // Reemplazar el contenido del layout principal por un fragmento
        //Fragment fragment = new ArticleFragment();
        //Bundle args = new Bundle();
        //args.putInt(ArticleFragment.ARG_ARTICLES_NUMBER, position);
        //fragment.setArguments(args);

        //FragmentManager fragmentManager = getFragmentManager();
        // fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // Se actualiza el item seleccionado y el título, después de cerrar el drawer
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
