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
    ArrayList<LatLng> markerPoints_3;
    ArrayList<LatLng> markerPoints_4;
    ArrayList<LatLng> markerPoints_1;
    ArrayList<LatLng> markerPoints_2;
    ArrayList<LatLng> markerPoints_extras;
    ArrayList<Coordenada> coordenadas_1;
    ArrayList<Coordenada> coordenadas_2;
    ArrayList<Coordenada> coordenadas_3;
    ArrayList<Coordenada> coordenadas_4;
    ArrayList<Coordenada> marcadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_ruta, frameLayout);
        String[] item_menus_sec = getResources().getStringArray(R.array.ItemMenusSec);
        setTitle(item_menus_sec[4]);
        if(NetworkUtils.haveNetworkConnection(this)) {
            markerPoints_1 = new ArrayList<LatLng>();
            markerPoints_2= new ArrayList<LatLng>();
            markerPoints_3 = new ArrayList<LatLng>();
            markerPoints_4 = new ArrayList<LatLng>();
            markerPoints_extras = new ArrayList<LatLng>();
            coordenadas_1 = new ArrayList<Coordenada>();
            coordenadas_2 = new ArrayList<Coordenada>();
            coordenadas_3 = new ArrayList<Coordenada>();
            coordenadas_4 = new ArrayList<Coordenada>();
            marcadores = new ArrayList<Coordenada>();
            SupportMapFragment fragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
            map = fragment.getMap();
            map.setMyLocationEnabled(true);
            // A-B
            coordenadas_1.add(new Coordenada(21.034063, -89.629751, "Mérida"));
            coordenadas_1.add(new Coordenada(19.854094, -90.523104, "Campeche2"));  //2 B

            coordenadas_1.add(new Coordenada(20.997342, -89.623576, ""));
            coordenadas_1.add(new Coordenada(20.822885, -89.742599, ""));
            coordenadas_1.add(new Coordenada(20.745267, -89.721391, ""));

            coordenadas_1.add(new Coordenada(20.489867, -89.732904, "A"));
            coordenadas_1.add(new Coordenada(20.211763, -90.104163, ""));
            coordenadas_1.add(new Coordenada(20.129829, -90.1695713, ""));
            coordenadas_1.add(new Coordenada(19.846212, -90.540779, "Campeche"));
            coordenadas_1.add(new Coordenada(19.848929, -90.531689, ""));

            coordenadas_2.add(new Coordenada(19.848929, -90.531689, ""));
            coordenadas_2.add(new Coordenada(20.397248, -89.535449, "Ticul"));
            coordenadas_2.add(new Coordenada(19.748210, -89.851839, ""));
            coordenadas_2.add(new Coordenada(19.753445, -89.841121, ""));
            coordenadas_2.add(new Coordenada(19.775156, -89.596288, ""));
            coordenadas_2.add(new Coordenada(20.006424, -89.842898, ""));
            coordenadas_2.add(new Coordenada(20.360130, -89.769430, ""));
            coordenadas_2.add(new Coordenada(20.325754, -89.641965, "Santa Elena"));
            coordenadas_2.add(new Coordenada(20.395289, -89.540020, ""));
            coordenadas_2.add(new Coordenada(20.397859, -89.535846, ""));

            coordenadas_3.add(new Coordenada(20.397859, -89.535846, "Ticul"));
            coordenadas_3.add(new Coordenada(21.241901, -89.046411, ""));
            coordenadas_3.add(new Coordenada(20.397248, -89.535449, ""));
            coordenadas_3.add(new Coordenada(20.386730, -89.392054, ""));
            coordenadas_3.add(new Coordenada(20.813236, -89.453061, ""));
            coordenadas_3.add(new Coordenada(21.285345, -89.661917, ""));
            coordenadas_3.add(new Coordenada(21.393030, -88.891646, ""));
            coordenadas_3.add(new Coordenada(21.280416, -88.931591, ""));
            coordenadas_3.add(new Coordenada(21.241901, -89.046411, "Dzidzantun"));
            coordenadas_3.add(new Coordenada(21.280416, -88.931591, ""));

            coordenadas_4.add(new Coordenada(21.280416, -88.931591, ""));
            coordenadas_4.add(new Coordenada(21.086005, -86.773757, "Grans Oasis Cancun"));
            coordenadas_4.add(new Coordenada(21.141256, -89.111939, ""));
            coordenadas_4.add(new Coordenada(21.198097, -88.810170, ""));
            coordenadas_4.add(new Coordenada(21.152583, -88.171573, ""));
            coordenadas_4.add(new Coordenada(21.140176, -88.163162, ""));
            coordenadas_4.add(new Coordenada(20.742540, -88.21284, ""));
            coordenadas_4.add(new Coordenada(20.677660,-88.568201, ""));
            coordenadas_4.add(new Coordenada(20.690885, -88.219442, ""));
            coordenadas_4.add(new Coordenada(20.214318, -87.453574, ""));

            //MARCADORES.
            marcadores.add(new Coordenada(21.034063, -89.629751, "Mérida"));
            marcadores.add(new Coordenada(21.086005, -86.773757, "Grans Oasis Cancun"));

            marcadores.add(new Coordenada(20.745267, -89.721391, "Hacienda Yaxcopoil"));
            marcadores.add(new Coordenada(19.846212, -90.540779, "Campeche"));
            marcadores.add(new Coordenada(19.748210, -89.851839, "Holpechen"));
            marcadores.add(new Coordenada(19.775156, -89.596288, "Santa Rosa Xtampak"));
            marcadores.add(new Coordenada(20.006424, -89.842898, "Grutas de Xtacumbilxunaan"));
            marcadores.add(new Coordenada(20.360130, -89.769430, "Uxmal"));
            marcadores.add(new Coordenada(20.395289, -89.540020, "Ticul"));
            marcadores.add(new Coordenada(20.386730, -89.392054, "Maní"));
            marcadores.add(new Coordenada(20.632594, -89.458469, "Mayapan"));
            marcadores.add(new Coordenada(20.813236, -89.453061, "Acanceh"));
            marcadores.add(new Coordenada(21.337578, -89.315342, "Telchac Puerto"));
            marcadores.add(new Coordenada(21.280416, -88.931591, "Dzilam Gonzalez"));
            marcadores.add(new Coordenada(21.241901, -89.046411, "Dzidzantun"));
            marcadores.add(new Coordenada(21.140176, -88.163162, "Tizimin"));
            marcadores.add(new Coordenada(20.677660,-88.568201, "Chichen Itzá"));



            LatLng location = new LatLng(20.2107651,-89.004814);
            CameraUpdate center=CameraUpdateFactory.newLatLng(location);
            CameraUpdate zoom=CameraUpdateFactory.zoomTo(6);
            map.moveCamera(center);
            map.animateCamera(zoom);

            for (Coordenada coordenada : coordenadas_1) {
                if (markerPoints_1.size() > 10) {
                    Log.e("wtf",coordenada.toString());
                   Log.e("Rebasado el numero de puntos 3","Coordenadas");
                } else {
                    Double Lat = coordenada.getLatitud();
                    Double Lng = coordenada.getLongitud();
                    LatLng point = new LatLng(Lat, Lng);
                    markerPoints_1.add(point);
                   // MarkerOptions options = new MarkerOptions();
                   // options.position(point);
                   // options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                   // map.addMarker(options);
                }
            }

            // Checks, whether start and end locations are captured
            if (markerPoints_1.size() >= 2) {
                LatLng origin = markerPoints_1.get(0);
                LatLng dest = markerPoints_1.get(1);
                // Getting URL to the Google Directions API
                String url = getDirectionsUrl(origin, dest,markerPoints_1);
                DownloadTask downloadTask = new DownloadTask();
                // Start downloading json data from Google Directions API
                downloadTask.execute(url);
            }

            for (Coordenada coordenada : coordenadas_2) {
                if (markerPoints_2.size() > 10) {
                    Log.e("wtf",coordenada.toString());
                    Log.e("Rebasado el numero de puntos 3","Coordenadas");
                } else {
                    Double Lat = coordenada.getLatitud();
                    Double Lng = coordenada.getLongitud();
                    LatLng point = new LatLng(Lat, Lng);
                    markerPoints_2.add(point);
                    //      MarkerOptions options = new MarkerOptions();
                    //     options.position(point);
                    //    options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                    //    map.addMarker(options);
                }
            }
            if (markerPoints_2.size() >= 2) {
                LatLng origin = markerPoints_2.get(0);
                LatLng dest = markerPoints_2.get(1);
                // Getting URL to the Google Directions API
                String url = getDirectionsUrl(origin, dest,markerPoints_2);
                DownloadTask downloadTask = new DownloadTask();
                // Start downloading json data from Google Directions API
                downloadTask.execute(url);
            }
            for (Coordenada coordenada : coordenadas_3) {
                if (markerPoints_3.size() > 10) {
                    Log.e("wtf",coordenada.toString());
                    Log.e("Rebasado el numero de puntos 3","Coordenadas");
                } else {
                    Double Lat = coordenada.getLatitud();
                    Double Lng = coordenada.getLongitud();
                    LatLng point = new LatLng(Lat, Lng);
                    markerPoints_3.add(point);
                    //  MarkerOptions options = new MarkerOptions();
                    //  options.position(point);
                    //    options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                    //     map.addMarker(options);
                }
            }
            if (markerPoints_3.size() >= 2) {
                LatLng origin = markerPoints_3.get(0);
                LatLng dest = markerPoints_3.get(1);
                // Getting URL to the Google Directions API
                String url = getDirectionsUrl(origin, dest,markerPoints_3);
                DownloadTask downloadTask = new DownloadTask();
                // Start downloading json data from Google Directions API
                downloadTask.execute(url);
            }
            for (Coordenada coordenada : coordenadas_4) {
                if (markerPoints_4.size() > 10) {
                    Log.e("wtf",coordenada.toString());
                    Log.e("Rebasado el numero de puntos 3","Coordenadas");
                } else {
                    Double Lat = coordenada.getLatitud();
                    Double Lng = coordenada.getLongitud();
                    LatLng point = new LatLng(Lat, Lng);
                    markerPoints_4.add(point);
                   // MarkerOptions options = new MarkerOptions();
                    //  options.position(point);
                    // options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                    // map.addMarker(options);
                }
            }
            if (markerPoints_4.size() >= 2) {
                LatLng origin = markerPoints_4.get(0);
                LatLng dest = markerPoints_4.get(1);
                // Getting URL to the Google Directions API
                String url = getDirectionsUrl(origin, dest,markerPoints_4);
                DownloadTask downloadTask = new DownloadTask();
                // Start downloading json data from Google Directions API
                downloadTask.execute(url);
            }

            for (Coordenada coordenada : marcadores) {
                    Double Lat = coordenada.getLatitud();
                    Double Lng = coordenada.getLongitud();
                    LatLng point = new LatLng(Lat, Lng);
                    markerPoints_extras.add(point);
                    MarkerOptions options = new MarkerOptions();
                options.title(coordenada.getCiudad());
                    options.position(point);
                    if (markerPoints_extras.size() == 1) {
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                    } else if (markerPoints_extras.size() == 2) {
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                    } else {
                        options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                    }
                    // Add new marker to the Google Map Android API V2
                    map.addMarker(options);

            }

        }
        else{
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.revise_conexion),Toast.LENGTH_SHORT).show();
        }
    }
    private String getDirectionsUrl(LatLng origin,LatLng dest,ArrayList<LatLng> markerPoints){
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
