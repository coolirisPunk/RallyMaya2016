package com.punkmkt.rallymaya.fragments;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.punkmkt.rallymaya.R;
import com.punkmkt.rallymaya.adapters.ExpandableListLugarVisitaAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by germanpunk on 02/03/15.
 */
public class Lugar_visita extends Fragment{
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    View header;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.lugar_visita_fragment,container,false);
        expListView = (ExpandableListView) v.findViewById(R.id.listViewLugarVisita);
        prepareListData();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.lugarvisita_header, expListView, false);
        expListView.addHeaderView(header, null, false);
        listAdapter = new ExpandableListLugarVisitaAdapter(getActivity().getApplicationContext(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        return v;
    }
    private void prepareListData() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        for (String headers : Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisitaHeader))){
           listDataHeader.add(headers);
        }

        // Adding child data
        List<String> tips_LugaresVisita_merida = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_merida))){
            tips_LugaresVisita_merida.add(row);
        }

        //String[] chunhuhub  = getResources().getStringArray(R.array.tips_ListHeader);
        List<String> tips_LugaresVisita_uman = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_uman))){
            tips_LugaresVisita_uman.add(row);
        }

        List<String> tips_LugaresVisita_hacienda_yaxcopoil = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_hacienda_yaxcopoil))){
            tips_LugaresVisita_hacienda_yaxcopoil.add(row);
        }

        List<String> tips_LugaresVisita_calkini = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_calkini))){
            tips_LugaresVisita_calkini.add(row);
        }

        List<String> tips_LugaresVisita_hecelchakan = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_hecelchakan))){
            tips_LugaresVisita_hecelchakan.add(row);
        }

        List<String> tips_LugaresVisita_pomuch = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_pomuch))){
            tips_LugaresVisita_pomuch.add(row);
        }

        List<String> tips_LugaresVisita_campeche = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_campeche))){
            tips_LugaresVisita_campeche.add(row);
        }
        List<String> tips_LugaresVisita_hopelchen = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_hopelchen))){
            tips_LugaresVisita_hopelchen.add(row);
        }
        List<String> tips_LugaresVisita_santa_rosa_xtampak = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_santa_rosa_xtampak))){
            tips_LugaresVisita_santa_rosa_xtampak.add(row);
        }
        List<String> tips_LugaresVisita_uxmal = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_uxmal))){
            tips_LugaresVisita_uxmal.add(row);
        }
        List<String> tips_LugaresVisita_muna = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_muna))){
            tips_LugaresVisita_muna.add(row);
        }
        List<String> tips_LugaresVisita_ticul = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_ticul))){
            tips_LugaresVisita_ticul.add(row);
        }
        List<String> tips_LugaresVisita_mani = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_mani))){
            tips_LugaresVisita_mani.add(row);
        }
        List<String> tips_LugaresVisita_mayapan = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_mayapan))){
            tips_LugaresVisita_mayapan.add(row);
        }
        List<String> tips_LugaresVisita_dzilchaltun = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_dzilchaltun))){
            tips_LugaresVisita_dzilchaltun.add(row);
        }
        List<String> tips_LugaresVisita_puerto_progreso = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_puerto_progreso))){
            tips_LugaresVisita_puerto_progreso.add(row);
        }
        List<String> tips_LugaresVisita_xcambo = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_xcambo))){
            tips_LugaresVisita_xcambo.add(row);
        }
        List<String> tips_LugaresVisita_dzilam_gonzalez = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_dzilam_gonzalez))){
            tips_LugaresVisita_dzilam_gonzalez.add(row);
        }
        List<String> tips_LugaresVisita_tizimin = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_tizimin))){
            tips_LugaresVisita_tizimin.add(row);
        }
        List<String> tips_LugaresVisita_valladolid = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_valladolid))){
            tips_LugaresVisita_valladolid.add(row);
        }
        List<String> tips_LugaresVisita_chichenitza = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_chichenitza))){
            tips_LugaresVisita_chichenitza.add(row);
        }
        List<String> tips_LugaresVisita_xcaret = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_xcaret))){
            tips_LugaresVisita_xcaret.add(row);
        }
        List<String> tips_LugaresVisita_playa_carmen = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_playa_carmen))){
            tips_LugaresVisita_playa_carmen.add(row);
        }
        List<String> tips_LugaresVisita_cancun = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_cancun))){
            tips_LugaresVisita_cancun.add(row);
        }
        List<String> tips_LugaresVisita_isla_mujeres = new ArrayList<String>();
        for (String row: Arrays.asList(getResources().getStringArray(R.array.tips_LugaresVisita_isla_mujeres))){
            tips_LugaresVisita_isla_mujeres.add(row);
        }
        listDataChild.put(listDataHeader.get(0), tips_LugaresVisita_merida);
        listDataChild.put(listDataHeader.get(1), tips_LugaresVisita_uman);
        listDataChild.put(listDataHeader.get(2), tips_LugaresVisita_hacienda_yaxcopoil);
        listDataChild.put(listDataHeader.get(3), tips_LugaresVisita_calkini);
        listDataChild.put(listDataHeader.get(4), tips_LugaresVisita_hecelchakan);
        listDataChild.put(listDataHeader.get(5), tips_LugaresVisita_pomuch);
        listDataChild.put(listDataHeader.get(6), tips_LugaresVisita_campeche);
        listDataChild.put(listDataHeader.get(7), tips_LugaresVisita_hopelchen);
        listDataChild.put(listDataHeader.get(8), tips_LugaresVisita_santa_rosa_xtampak);
        listDataChild.put(listDataHeader.get(9), tips_LugaresVisita_uxmal);
        listDataChild.put(listDataHeader.get(10), tips_LugaresVisita_muna);
        listDataChild.put(listDataHeader.get(11), tips_LugaresVisita_ticul);
        listDataChild.put(listDataHeader.get(12), tips_LugaresVisita_mani);
        listDataChild.put(listDataHeader.get(13), tips_LugaresVisita_mayapan);
        listDataChild.put(listDataHeader.get(14), tips_LugaresVisita_dzilchaltun);
        listDataChild.put(listDataHeader.get(15), tips_LugaresVisita_puerto_progreso);
        listDataChild.put(listDataHeader.get(16), tips_LugaresVisita_xcambo);
        listDataChild.put(listDataHeader.get(17), tips_LugaresVisita_dzilam_gonzalez);
        listDataChild.put(listDataHeader.get(18), tips_LugaresVisita_tizimin);
        listDataChild.put(listDataHeader.get(19), tips_LugaresVisita_valladolid);
        listDataChild.put(listDataHeader.get(20), tips_LugaresVisita_chichenitza);
        listDataChild.put(listDataHeader.get(21), tips_LugaresVisita_xcaret);
        listDataChild.put(listDataHeader.get(22), tips_LugaresVisita_playa_carmen);
        listDataChild.put(listDataHeader.get(23), tips_LugaresVisita_cancun);
        listDataChild.put(listDataHeader.get(24), tips_LugaresVisita_isla_mujeres);

    }
}
