package com.punkmkt.rallymaya.fragments;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.punkmkt.rallymaya.R;
import com.punkmkt.rallymaya.adapters.ExpandableListDirectorioAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by germanpunk on 05/03/15.
 */
public class DirectorioCampeche extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    View header;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.directorio_fragment,container,false);
        expListView = (ExpandableListView) v.findViewById(R.id.listViewDirectorio);
        prepareListData();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.lugarvisita_header, expListView, false);
        expListView.addHeaderView(header, null, false);
        listAdapter = new ExpandableListDirectorioAdapter(getActivity(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);


        return v;
    }

    private void prepareListData() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        Resources res = getResources();
        TypedArray ta = res.obtainTypedArray(R.array.directorio_campeche_header);
        int n = ta.length();
        for (int i = 0; i < n; ++i) {
            int id_r = ta.getResourceId(i, 0);
            if (id_r > 0) {
                String strings[] = res.getStringArray(id_r);
                String id = strings[0];
                String title = strings[1];
                String tag = strings[2];
                listDataHeader.add(title);
                int getRes2 = getResources().getIdentifier(tag,"array",getActivity().getApplicationContext().getPackageName());
                String strings_content[] = res.getStringArray(getRes2);
                List<String> ListString = new ArrayList<String>();
                for (String row: Arrays.asList(getResources().getStringArray(getRes2))){
                    ListString.add(row);
                }
                listDataChild.put(listDataHeader.get(i), ListString);
            } else {

            }

        }
        ta.recycle();
    }


}
