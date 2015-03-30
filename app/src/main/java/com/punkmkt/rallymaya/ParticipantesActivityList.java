package com.punkmkt.rallymaya;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import com.punkmkt.rallymaya.adapters.ParticipanteAdapter;
import com.punkmkt.rallymaya.adapters.PatrocinadorAdapter;
import com.punkmkt.rallymaya.models.Participante;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import android.app.ProgressDialog;
import android.widget.ImageView;


public class ParticipantesActivityList extends BaseActivity {


    private GridView grid;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();
    private final String RALLY_MAYA_JSON_API_URL = "http://punklabs.ninja/rallymaya/api/v1/cars/?format=json";
    private ProgressDialog progress;
    String url = null;
    ImageLoader mImageLoader;
    NetworkImageView mNetworkImageView;
    private ParticipanteAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_participantes_activity_list, frameLayout);

        grid = (GridView)findViewById(R.id.grid_participantes);
        adapter = new ParticipanteAdapter(this,participantes);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Destino clicked_destino = (Destino) grid.getItemAtPosition(position);
                //Toast.makeText(MayaKaanEscapadas.this, "You Clicked at " + clicked_destino.getNombre(), Toast.LENGTH_SHORT).show();
                Participante participante = (Participante) grid.getItemAtPosition(position);
                Intent Idetail = new Intent (getApplicationContext(), ParticipantesActivityDetail.class);
                Idetail.putExtra("id", participante.getId());
                Idetail.putExtra("nombre", participante.getName());
                Idetail.putExtra("image", participante.getImage());
                Idetail.putExtra("year", participante.getYear());
                startActivity(Idetail);
            }

        });


        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[2]);

        JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, RALLY_MAYA_JSON_API_URL,
                null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                parseJSONRespone(response);
                progress.dismiss();
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("VOLLEY", error.getMessage());
            }
        });
        progress = ProgressDialog.show(this, "","Cargando participantes.");


        MyVolleySingleton.getInstance().addToRequestQueue(jr);


    }

    private void parseJSONRespone(JSONObject response) {
        try {
            JSONArray entries = response.getJSONArray("objects");
            for (int count = 0; count < entries.length(); count++) {
                JSONObject anEntry = entries.getJSONObject(count);
                Participante participante = new Participante();
                participante.setId(Integer.parseInt(anEntry.optString("id")));
                participante.setName(anEntry.optString("name"));
                participante.setImage(anEntry.optString("picture"));
                participante.setYear(anEntry.optString("year"));
                participantes.add(participante);
            }
            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    static class ViewHolder {
        ImageView imageView;
    }

    class MyImageAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return participantes.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            final ViewHolder gridViewImageHolder;
//            check to see if we have a view
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.grid_image_item, parent, false);
                gridViewImageHolder = new ViewHolder();
                gridViewImageHolder.imageView = (ImageView) view.findViewById(R.id.netork_imageView);
                view.setTag(gridViewImageHolder);
            } else {
                gridViewImageHolder = (ViewHolder) view.getTag();
            }

            mNetworkImageView = (NetworkImageView) gridViewImageHolder.imageView;
            mNetworkImageView.setDefaultImageResId(R.drawable.article);
            mNetworkImageView.setErrorImageResId(R.drawable.article);
            mNetworkImageView.setAdjustViewBounds(true);
            mNetworkImageView.setImageUrl(ImageUrlArray.IMAGES[position], mImageLoader);

            return view;
        }
    }


}
