package com.punkmkt.rallymaya;

import android.os.AsyncTask;

import android.os.Bundle;
import android.util.Log;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import android.graphics.Color;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.punkmkt.rallymaya.models.Coordenada;
import com.punkmkt.rallymaya.utils.NetworkUtils;

import android.widget.Toast;

import org.json.JSONObject;

public class RutaActivity extends BaseActivity {

    GoogleMap map;
    ArrayList<LatLng> markerPoints;
    ArrayList<Coordenada> coordenadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_ruta, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[3]);
        if(NetworkUtils.haveNetworkConnection(this)) {
            markerPoints = new ArrayList<LatLng>();
            coordenadas = new ArrayList<Coordenada>();
            SupportMapFragment fragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
            map = fragment.getMap();
            map.setMyLocationEnabled(true);
            coordenadas.add(new Coordenada(20.9627063, -89.6282379, "Merida"));
            coordenadas.add(new Coordenada(20.9578743, -86.9253269, "Cancun"));
            coordenadas.add(new Coordenada(20.9013842, -89.725542, "Uman"));
            coordenadas.add(new Coordenada(20.74578, -89.7222305, "HACIENDA YAXCOPOIL"));
            coordenadas.add(new Coordenada(20.3666355, -90.0485722, "CALKINÍ"));
            coordenadas.add(new Coordenada(20.4593239, -89.7592358, "HECELCHAKAN"));
            coordenadas.add(new Coordenada(20.1361321, -90.174441, "POMUCH"));
            coordenadas.add(new Coordenada(19.8254249, -90.5548053, "CAMPECHE"));
            coordenadas.add(new Coordenada(19.7475659, -89.8427386, "HOPELCHEN"));
            coordenadas.add(new Coordenada(20.3888822, -89.6859027, "UXMAL"));
            coordenadas.add(new Coordenada(20.4886998,-89.7090447, "MUNA"));
            coordenadas.add(new Coordenada(20.4098456,-89.5443497, "TICUL"));
            coordenadas.add(new Coordenada(21.2386449,-89.2108244, "MANI"));
            coordenadas.add(new Coordenada(20.9790703,-89.5922433, "MAYAPAN"));
            coordenadas.add(new Coordenada(21.0982572,-89.7417512, "DZIBILCHALTUN"));
            coordenadas.add(new Coordenada(21.2500219,-89.649646, "PROGRESO"));
            coordenadas.add(new Coordenada(21.3274647,-89.2987983, "Telchac Puerto"));
            coordenadas.add(new Coordenada(21.313508,-89.3541, "xcambo"));
            coordenadas.add(new Coordenada(21.3294724,-89.0277729, "Dzilam González"));
            coordenadas.add(new Coordenada(21.0050939,-88.0464464, "Tizimín"));
            coordenadas.add(new Coordenada(20.6875138,-88.5659138, "Chichén Itzá, Tinum, Yuc."));
            coordenadas.add(new Coordenada(20.6335355,-87.0796316, "Playa del Carmen"));
            for (Coordenada coordenada : coordenadas) {
                if (markerPoints.size() >= 10) {
                   Log.e("Rebasado el numero de puntos","Coordenadas");
                    //Toast.makeText(this, "Rebasado el numero de puntos.", Toast.LENGTH_SHORT).show();
                } else {
                    Double Lat = coordenada.getLatitud();
                    Double Lng = coordenada.getLongitud();
                    LatLng point = new LatLng(Lat, Lng);
                    markerPoints.add(point);
                    MarkerOptions options = new MarkerOptions();
                    options.position(point);
                    if (markerPoints.size() == 1) {
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                    } else if (markerPoints.size() == 2) {
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                    } else {
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                    }
                    // Add new marker to the Google Map Android API V2
                    map.addMarker(options);
                }
            }


            //Log.e("points", markerPoints.toString());

            // Checks, whether start and end locations are captured
            if (markerPoints.size() >= 2) {
                LatLng origin = markerPoints.get(0);
                LatLng dest = markerPoints.get(1);
                // Getting URL to the Google Directions API
                String url = getDirectionsUrl(origin, dest);
                DownloadTask downloadTask = new DownloadTask();
                // Start downloading json data from Google Directions API
                downloadTask.execute(url);

                LatLng location = new LatLng(20.2107651,-89.004814);
                CameraUpdate center=CameraUpdateFactory.newLatLng(location);
                CameraUpdate zoom=CameraUpdateFactory.zoomTo(6);
                map.moveCamera(center);
                map.animateCamera(zoom);
            }
        }
        else{
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.revise_conexion),Toast.LENGTH_SHORT).show();
        }
    }
    private String getDirectionsUrl(LatLng origin,LatLng dest){

        // Origin of route
        String str_origin = "origin="+origin.latitude+","+origin.longitude;

        // Destination of route
        String str_dest = "destination="+dest.latitude+","+dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Waypoints
        String waypoints = "";
        for(int i=2;i<markerPoints.size();i++){
            LatLng point  = (LatLng) markerPoints.get(i);
            if(i==2)
                waypoints = "waypoints=";
            waypoints += point.latitude + "," + point.longitude + "|";
        }

        // Building the parameters to the web service
        String parameters = str_origin+"&"+str_dest+"&"+sensor+"&"+waypoints;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"+output+"?"+parameters;

        return url;
    }

    /** A method to download json data from url */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try{
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb  = new StringBuffer();

            String line = "";
            while( ( line = br.readLine())  != null){
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){
            Log.d("Exception while downloading url", e.toString());
        }finally{
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service

            String data = "";

            try{
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            }catch(Exception e){
                Log.d("Background Task",e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }

    /** A class to parse the Google Places in JSON format */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String,String>>> >{

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try{
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            }catch(Exception e){
                e.printStackTrace();
            }

            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {

            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for(int i=0;i<result.size();i++){
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for(int j=0;j<path.size();j++){
                    HashMap<String,String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.BLUE);
            }

            // Drawing polyline in the Google Map for the i-th route
            map.addPolyline(lineOptions);
        }
    }


}
