package com.punkmkt.rallymaya.adapters;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.punkmkt.rallymaya.R;

public class ExpandableListDirectorioAdapter extends BaseExpandableListAdapter{

    private Context context;
    private Activity activity;
    // child data in format of header title, child title
    private List<String> listDataHeader; // header titles
    private HashMap<String, List<String>> listDataChild;

    public ExpandableListDirectorioAdapter(Activity activity, List<String> listDataHeader,
                                            HashMap<String, List<String>> listChildData) {
        this.activity = activity;
        this.context = activity.getApplicationContext();
        this.listDataHeader = listDataHeader;
        this.listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            //LayoutInflater infalInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = this.activity.getLayoutInflater().inflate(R.layout.listrow_directorio_details, null);
        }
        TextView txtListChild = (TextView) convertView.findViewById(R.id.ListItemDirectorio);
        txtListChild.setText(childText);
          Linkify.addLinks(txtListChild, Linkify.ALL);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.listrow_lugarvisita_group, null);
        }
        TextView lblListHeader = (TextView) convertView.findViewById(R.id.ListHeader);
        //lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return convertView;

    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void StartCallEmail(View v){
        TextView textoTitulo = (TextView) v.findViewById(R.id.ListItem);
        String texto = textoTitulo.getText().toString();
        Log.e("Texto",texto);
    }

    }
