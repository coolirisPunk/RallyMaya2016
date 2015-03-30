package com.punkmkt.rallymaya.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.punkmkt.rallymaya.ParticipantesActivityDetail;
import com.punkmkt.rallymaya.R;
import com.punkmkt.rallymaya.models.Patrocinador;

import java.util.ArrayList;

/**
 * Created by germanpunk on 05/03/15.
 */
public class PatrocinadorAdapter extends ArrayAdapter<Patrocinador> {
    private Context context;
    private ArrayList<Patrocinador> patrocinadores;
    private int itemLayout;
    public PatrocinadorAdapter(Context context, int viewResourceId, ArrayList<Patrocinador> patrocinadores) {
        super(context, viewResourceId, patrocinadores);
        this.context = context;
        this.patrocinadores = patrocinadores;
        this.itemLayout = viewResourceId;
    }

    static class ViewHolder{
        public ImageView imagen;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder = new ViewHolder();
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(itemLayout, parent, false);
            viewHolder.imagen = (ImageView) convertView.findViewById(R.id.image_patrocinador);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Patrocinador patrocinador = patrocinadores.get(position);
        //viewHolder.name.setText(actionbar.getName());
        switch (patrocinador.getId()){
            case 1:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_aicm);
                break;
            case 2:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_asur);
                break;
            case 3:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_campeche);
                break;
            case 4:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_cancun);
                break;
            case 5:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_deiman);
                break;
            case 6:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_donm);
                break;
            case 7:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_fullgas);
                break;
            case 8:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_interjet);
                break;
            case 9:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_mayaland);
                break;
            case 10:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_oasis);
                break;
            case 11:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_scappino);
                break;
            case 12:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_sct);
                break;
            case 13:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_ultramar);
                break;
            case 14:
                viewHolder.imagen.setImageResource(R.drawable.patrocinador_yucatan);
                break;
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return convertView;
    }
}
