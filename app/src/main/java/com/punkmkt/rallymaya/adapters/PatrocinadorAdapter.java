package com.punkmkt.rallymaya.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.punkmkt.rallymaya.MyVolleySingleton;
import com.punkmkt.rallymaya.ParticipantesActivityDetail;
import com.punkmkt.rallymaya.R;
import com.punkmkt.rallymaya.models.Participante;
import com.punkmkt.rallymaya.models.Patrocinador;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by germanpunk on 05/03/15.
 */
public class PatrocinadorAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Patrocinador> patrocinadores;
    ImageLoader imageLoader = MyVolleySingleton.getInstance().getImageLoader();

    public PatrocinadorAdapter(Activity activity, List<Patrocinador> patrocinadores) {
        this.activity = activity;
        this.patrocinadores = patrocinadores;
    }

    @Override
    public int getCount() {
        return patrocinadores.size();
    }

    @Override
    public Object getItem(int location) {
        return patrocinadores.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.grid_image_item, null);

        if (imageLoader == null)
            imageLoader = MyVolleySingleton.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.netork_imageView);

        // getting movie data for the row
        Patrocinador p = patrocinadores.get(position);
        // thumbnail image
        thumbNail.setImageUrl(p.getImage(), imageLoader);

        return convertView;
    }

}