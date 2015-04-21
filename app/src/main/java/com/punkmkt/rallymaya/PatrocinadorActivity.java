package com.punkmkt.rallymaya;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.punkmkt.rallymaya.adapters.PatrocinadorAdapter;
import com.punkmkt.rallymaya.models.Patrocinador;
import com.punkmkt.rallymaya.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class PatrocinadorActivity extends BaseActivity {

    private GridView grid;
    private ArrayList<Patrocinador> patrocinadores = new ArrayList<Patrocinador>();
    private final String RALLY_MAYA_JSON_API_URL = "http://punklabs.ninja/rallymaya/api/v1/sponsors/?format=json";
    private ProgressDialog progress;
    String url = null;
    ImageLoader mImageLoader;
    NetworkImageView mNetworkImageView;
    private PatrocinadorAdapter adapter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MainActivity.fa.finish();
        getLayoutInflater().inflate(R.layout.activity_patrocinador, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[6]);
//        for (int index = 0; index <14; index++) {
//            Patrocinador patrocinador = new Patrocinador();
//            patrocinador.setId(index + 1);
//            patrocinadores.add(patrocinador);
//        }
//        grid = (GridView)findViewById(R.id.grid_patrocinadores);
//        grid.setAdapter(new PatrocinadorAdapter(this, R.layout.row_patrocinador, patrocinadores));
        grid = (GridView)findViewById(R.id.grid_patrocinadores);
        adapter = new PatrocinadorAdapter(this,patrocinadores);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Patrocinador patrocinador = (Patrocinador) grid.getItemAtPosition(position);
                String url = patrocinador.getLink();
                if(url != null && !url.isEmpty()) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            }

        });

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
            //progress = ProgressDialog.show(this, "", getResources().getString(R.string.cargando_patrocinadores));
            progress = new ProgressDialog(PatrocinadorActivity.this);
            progress.setMessage(getResources().getString(R.string.cargando_patrocinadores));
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
                Patrocinador patrocinador = new Patrocinador();
                patrocinador.setId(Integer.parseInt(anEntry.optString("id")));
                patrocinador.setName(anEntry.optString("name"));
                patrocinador.setImage(anEntry.optString("picture"));
                patrocinador.setLink(anEntry.optString("link"));
                patrocinadores.add(patrocinador);
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
            return patrocinadores.size();
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
