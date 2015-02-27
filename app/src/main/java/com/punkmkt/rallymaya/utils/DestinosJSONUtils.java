package com.punkmkt.rallymaya.utils;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import android.util.Log;


public class DestinosJSONUtils {
	
	public static final String TAG = "DestinosUtils";

	
	public static String getDestinos(){
		
		HttpURLConnection httpConnection = null;
		BufferedReader bufferedReader = null;
		StringBuilder response = new StringBuilder();

		try {
			URL url = new URL(ConstantsUtils.URL_SEARCH);
			httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setRequestMethod("GET");

			httpConnection.setRequestProperty("Content-Type", "application/json");
			httpConnection.connect();

			bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));

			String line;
			while ((line = bufferedReader.readLine()) != null){            
				response.append(line);	
			}
			
			Log.d(TAG, "GET response code: " + String.valueOf(httpConnection.getResponseCode()));
			Log.d(TAG, "JSON response: " + response.toString());
			
			return response.toString();

		} catch (Exception e) {
			Log.e(TAG, "GET error: " + Log.getStackTraceString(e));      
			return null;

		}finally {
			if(httpConnection != null){
				httpConnection.disconnect();
			}
		}
	}
	
	
	public static String getEscapadas(){
		
		HttpURLConnection httpConnection = null;
		BufferedReader bufferedReader = null;
		StringBuilder response = new StringBuilder();

		try {
			URL url = new URL(ConstantsUtils.URL_SEARCH_ESCAPADAS);
			httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setRequestMethod("GET");

			httpConnection.setRequestProperty("Content-Type", "application/json");
			httpConnection.connect();

			bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));

			String line;
			while ((line = bufferedReader.readLine()) != null){            
				response.append(line);	
			}
			
			Log.d(TAG, "GET response code: " + String.valueOf(httpConnection.getResponseCode()));
			Log.d(TAG, "JSON response: " + response.toString());
			
			return response.toString();

		} catch (Exception e) {
			Log.e(TAG, "GET error: " + Log.getStackTraceString(e));      
			return null;

		}finally {
			if(httpConnection != null){
				httpConnection.disconnect();
			}
		}
	}
	
public static String getGaleria(){
		
		HttpURLConnection httpConnection = null;
		BufferedReader bufferedReader = null;
		StringBuilder response = new StringBuilder();

		try {
			URL url = new URL(ConstantsUtils.URL_SEARCH_GALERIA);
			httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setRequestMethod("GET");
		
			httpConnection.setRequestProperty("Content-Type", "application/json");
			httpConnection.connect();

			bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));

			String line;
			while ((line = bufferedReader.readLine()) != null){            
				response.append(line);	
			}
			
			Log.d(TAG, "GET response code: " + String.valueOf(httpConnection.getResponseCode()));
			Log.d(TAG, "JSON response: " + response.toString());
			
			return response.toString();

		} catch (Exception e) {
			Log.e(TAG, "GET error: " + Log.getStackTraceString(e));      
			return null;

		}finally {
			if(httpConnection != null){
				httpConnection.disconnect();
			}
		}
	}
}
