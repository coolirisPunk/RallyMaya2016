package com.punkmkt.rallymaya.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.punkmkt.rallymaya.ParticipantesActivityDetail;
import com.punkmkt.rallymaya.ParticipantesActivityList;
import com.punkmkt.rallymaya.R;
import com.punkmkt.rallymaya.RallyMayaActivity;
import com.punkmkt.rallymaya.RutaActivity;
import com.punkmkt.rallymaya.TipActivity;
import com.punkmkt.rallymaya.models.ItemMenu;

import java.util.ArrayList;

public class MenuAdapter  extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private ArrayList<ItemMenu> menus;
    private int itemLayout;


    public  MenuAdapter(ArrayList<ItemMenu> data,  int itemLayout){
        menus = data;
        this.itemLayout = itemLayout;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnClickListener {

        public ImageView image;
        public TextView name;
        public TextView description;

        public ViewHolder(View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.image);
            //name = (TextView) itemView.findViewById(R.id.name);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent;
            switch(getPosition()){
                case 0:
                    intent = new Intent(context, RallyMayaActivity.class);
                    context.startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(context, ParticipantesActivityList.class);
                    context.startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(context, RutaActivity.class);
                    context.startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(context, TipActivity.class);
                    context.startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup  parent, int i) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        ItemMenu menu = menus.get(position);
        //viewHolder.name.setText(actionbar.getName());
        switch (menu.getId()){
            case 1:
                viewHolder.image.setImageResource(R.drawable.rally_maya);
                break;
            case 2:
                viewHolder.image.setImageResource(R.drawable.participantes);
                break;
            case 3:
                viewHolder.image.setImageResource(R.drawable.ruta);
                break;
            case 4:
                viewHolder.image.setImageResource(R.drawable.tips);
                break;
            case 5:
                viewHolder.image.setImageResource(R.drawable.patrocinadores);
                break;
            case 6:
                viewHolder.image.setImageResource(R.drawable.directorio);
                break;
            case 7:
                viewHolder.image.setImageResource(R.drawable.diabetes);
                break;
            case 8:
                viewHolder.image.setImageResource(R.drawable.cronometro);
                break;
        }
        viewHolder.itemView.setTag(menu);
    }


    @Override
    public int getItemCount() {
        return menus.size();
    }

}