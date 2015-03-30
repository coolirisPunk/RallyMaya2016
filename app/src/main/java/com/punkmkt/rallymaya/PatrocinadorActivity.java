package com.punkmkt.rallymaya;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.punkmkt.rallymaya.adapters.PatrocinadorAdapter;
import com.punkmkt.rallymaya.models.Patrocinador;

import java.util.ArrayList;


public class PatrocinadorActivity extends BaseActivity {

    private ArrayList<Patrocinador> patrocinadores = new ArrayList<Patrocinador>();
    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_patrocinador, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[5]);
        for (int index = 0; index <14; index++) {
            Patrocinador patrocinador = new Patrocinador();
            patrocinador.setId(index + 1);
            patrocinadores.add(patrocinador);
        }
        grid = (GridView)findViewById(R.id.grid_patrocinadores);
        grid.setAdapter(new PatrocinadorAdapter(this, R.layout.row_patrocinador, patrocinadores));
    }


}
