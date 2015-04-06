package com.punkmkt.rallymaya;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class IntroActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();
        //getActionBar().hide();
        new loading().execute();
    }





    private class loading extends AsyncTask<Void, Void, Void> {

        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(Void result){
            super.onPostExecute(result);
            //progressDialog.dismiss();
            try {
                Thread.sleep(1000);
                Intent goHome = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(goHome);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void goOn(View view){
        Intent goHome = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(goHome);
    }
}
