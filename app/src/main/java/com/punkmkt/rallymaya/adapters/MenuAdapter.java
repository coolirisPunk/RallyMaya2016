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
import com.punkmkt.rallymaya.ParticipantesActivityList;
import com.punkmkt.rallymaya.R;
import com.punkmkt.rallymaya.RallyMayaActivity;
import com.punkmkt.rallymaya.RutaActivity;
import com.punkmkt.rallymaya.TipActivity;
import com.punkmkt.rallymaya.models.ItemMenu;
import com.punkmkt.rallymaya.models.Participante;
import com.punkmkt.rallymaya.utils.BitmapManager;

public class MenuAdapter extends ArrayAdapter<ItemMenu>{
    private Context context;
    private ArrayList<ItemMenu> menus;
    private int itemLayout;
    public MenuAdapter(Context context, int viewResourceId, ArrayList<ItemMenu> menus) {
        super(context, viewResourceId, menus);
        this.context = context;
        this.menus = menus;
        this.itemLayout = viewResourceId;
    }
    static class ViewHolder{
        public ImageView image;
        public TextView name;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder = new ViewHolder();
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(itemLayout, parent, false);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image_menu);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ItemMenu menu = menus.get(position);
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
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch(position){
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
        });
        return convertView;
    }

}
