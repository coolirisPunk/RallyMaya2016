package com.punkmkt.rallymaya.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.punkmkt.rallymaya.MyVolleySingleton;
import com.punkmkt.rallymaya.R;
import com.punkmkt.rallymaya.models.Participante;


import java.util.List;
import android.app.Activity;
import android.widget.BaseAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class ParticipanteAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Participante> participantes;
    ImageLoader imageLoader = MyVolleySingleton.getInstance().getImageLoader();

        public ParticipanteAdapter(Activity activity, List<Participante> participantes) {
         this.activity = activity;
         this.participantes = participantes;
        }

            @Override
   public int getCount() {
        return participantes.size();
       }

            @Override
    public Object getItem(int location) {
        return participantes.get(location);
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
        //TextView title = (TextView) convertView.findViewById(R.id.textView);
        //TextView rating = (TextView) convertView.findViewById(R.id.rating);
        //TextView genre = (TextView) convertView.findViewById(R.id.genre);
        //TextView year = (TextView) convertView.findViewById(R.id.releaseYear);

        // getting movie data for the row
        Participante p = participantes.get(position);
        // thumbnail image
        thumbNail.setImageUrl(p.getThumbnail(), imageLoader);

        // title
       /// title.setText(p.getName());

//                // rating
//                rating.setText("Rating: " + String.valueOf(m.getRating()));
//                 
//                // genre
//                String genreStr = "";
//                for (String str : m.getGenre()) {
//                        genreStr += str + ", ";
//                    }
//                genreStr = genreStr.length() > 0 ? genreStr.substring(0,
//                                genreStr.length() - 2) : genreStr;
//                genre.setText(genreStr);
//                 
//                // release year
//                year.setText(String.valueOf(m.getYear()));
//         
        return convertView;
        }

}