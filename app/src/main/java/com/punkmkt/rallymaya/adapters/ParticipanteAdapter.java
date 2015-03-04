package com.punkmkt.rallymaya.adapters;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.punkmkt.rallymaya.ParticipantesActivityDetail;
import com.punkmkt.rallymaya.R;
import com.punkmkt.rallymaya.models.Participante;
import com.punkmkt.rallymaya.utils.BitmapManager;

public class ParticipanteAdapter extends ArrayAdapter<Participante>{

    private Context context;
    private ArrayList<Participante> participantes;
    private int itemLayout;
    public ParticipanteAdapter(Context context, int viewResourceId, ArrayList<Participante> participantes) {
        super(context, viewResourceId, participantes);
        this.context = context;
        this.participantes = participantes;
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
            viewHolder.imagen = (ImageView) convertView.findViewById(R.id.image_participante);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Participante participante = participantes.get(position);
        //viewHolder.name.setText(actionbar.getName());
        switch (participante.getId()){
            case 1:
                viewHolder.imagen.setImageResource(R.drawable.participante_1_list);
                break;
            case 2:
                viewHolder.imagen.setImageResource(R.drawable.participante_2_list);
                break;
            case 3:
                viewHolder.imagen.setImageResource(R.drawable.participante_3_list);
                break;
            case 4:
                viewHolder.imagen.setImageResource(R.drawable.participante_4_list);
                break;
            case 5:
                viewHolder.imagen.setImageResource(R.drawable.participante_5_list);
                break;
            case 6:
                viewHolder.imagen.setImageResource(R.drawable.participante_6_list);
                break;
            case 7:
                viewHolder.imagen.setImageResource(R.drawable.participante_7_list);
                break;
            case 8:
                viewHolder.imagen.setImageResource(R.drawable.participante_8_list);
                break;
            case 9:
                viewHolder.imagen.setImageResource(R.drawable.participante_9_list);
                break;
            case 10:
                viewHolder.imagen.setImageResource(R.drawable.participante_10_list);
                break;
            case 11:
                viewHolder.imagen.setImageResource(R.drawable.participante_11_list);
                break;
            case 12:
                viewHolder.imagen.setImageResource(R.drawable.participante_12_list);
                break;
            case 13:
                viewHolder.imagen.setImageResource(R.drawable.participante_13_list);
                break;
            case 14:
                viewHolder.imagen.setImageResource(R.drawable.participante_14_list);
                break;
            case 15:
                viewHolder.imagen.setImageResource(R.drawable.participante_15_list);
                break;
            case 16:
                viewHolder.imagen.setImageResource(R.drawable.participante_16_list);
                break;
            case 17:
                viewHolder.imagen.setImageResource(R.drawable.participante_17_list);
                break;
            case 18:
                viewHolder.imagen.setImageResource(R.drawable.participante_18_list);
                break;
            case 19:
                viewHolder.imagen.setImageResource(R.drawable.participante_19_list);
                break;
            case 20:
                viewHolder.imagen.setImageResource(R.drawable.participante_20_list);
                break;
            case 21:
                viewHolder.imagen.setImageResource(R.drawable.participante_21_list);
                break;
            case 22:
                viewHolder.imagen.setImageResource(R.drawable.participante_22_list);
                break;
            case 23:
                viewHolder.imagen.setImageResource(R.drawable.participante_23_list);
                break;
            case 24:
                viewHolder.imagen.setImageResource(R.drawable.participante_24_list);
                break;
            case 25:
                viewHolder.imagen.setImageResource(R.drawable.participante_25_list);
                break;
            case 26:
                viewHolder.imagen.setImageResource(R.drawable.participante_26_list);
                break;
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(context, ParticipantesActivityDetail.class);
                Participante participante = participantes.get(position);
                intent.putExtra("PARTICIPANTE_ID", participante.getId());
                context.startActivity(intent);
            }
        });
        return convertView;
    }

}
