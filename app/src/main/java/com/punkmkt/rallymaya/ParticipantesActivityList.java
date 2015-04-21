package com.punkmkt.rallymaya;

import android.app.Activity;
import android.content.DialogInterface;
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
import com.punkmkt.rallymaya.models.Participante;
import com.punkmkt.rallymaya.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import android.app.ProgressDialog;
import android.widget.ImageView;
import android.widget.Toast;


public class ParticipantesActivityList extends BaseActivity {


    private GridView grid;
    private ArrayList<Participante> participantes = new ArrayList<Participante>();
    private final String RALLY_MAYA_JSON_API_URL = "http://punklabs.ninja/rallymaya/api/v1/cars/?format=json";
    private ProgressDialog progress;
    private ProgressDialog myDialog;
    String url = null;
    ImageLoader mImageLoader;
    NetworkImageView mNetworkImageView;
    private ParticipanteAdapter adapter;
    Intent intent;
    public static Activity fa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MainActivity.fa.finish();
        fa=this;
        getLayoutInflater().inflate(R.layout.activity_participantes_activity_list, frameLayout);

        grid = (GridView)findViewById(R.id.grid_participantes);
        adapter = new ParticipanteAdapter(this,participantes);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Participante participante = (Participante) grid.getItemAtPosition(position);
                Intent Idetail = new Intent (getApplicationContext(), ParticipantesActivityDetail.class);
                Idetail.putExtra("id", participante.getId());
                Idetail.putExtra("nombre", participante.getName());
                Idetail.putExtra("image", participante.getImage());
                Idetail.putExtra("year", participante.getYear());
                Idetail.putExtra("thumbnail", participante.getThumbnail());
                startActivity(Idetail);
            }

        });
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[3]);
        if(NetworkUtils.haveNetworkConnection(this)) {
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

            progress = new ProgressDialog(ParticipantesActivityList.this);
            progress.setMessage(getResources().getString(R.string.cargando_participantes));
            progress.setCancelable(false);
            progress.setButton(DialogInterface.BUTTON_NEGATIVE, getResources().getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent);
                }
            });
            progress.show();
            //progress = ProgressDialog.show(this, "", getResources().getString(R.string.cargando_participantes));
            MyVolleySingleton.getInstance().addToRequestQueue(jr);
        }
        else{
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.revise_conexion), Toast.LENGTH_SHORT).show();
        }
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
                participante.setThumbnail(anEntry.optString("thumbnail"));
                if(anEntry.has("year") && !anEntry.optString("year").equals("null")){
                   // Log.e("Lista",anEntry.optString("year"));
                    participante.setYear(anEntry.optString("year"));
                }
                else{
                    //participante.setYear(" ");
                }
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
