package com.punkmkt.rallymaya;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.text.format.Time;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import org.w3c.dom.Text;

public class HomeActivity extends Activity {
    protected TextView TextCounter;
    protected TextView TextLine;
    protected TextView TextDescription;
    CountDownTimer c;

    Time fechaEvento = new Time(Time.getCurrentTimezone());
    int hora = 00;
    int minuto = 01;
    int segundo = 00;
    int dia = 13;
    // month is zero based...7 == August
    int mes = 4;
    int ano;
    private int diasfaltantes;
    private int horasFaltantes;
    private int minutosFaltantes;
    private int segundosFaltantes;
    public String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        configuracionEvento();
    }


    private void configuracionEvento(){

        this.fechaEvento.setToNow();
        this.ano = fechaEvento.year;

        fechaEvento.set(segundo, minuto, hora, dia, mes, ano);
        fechaEvento.normalize(true);
        long confMillis = fechaEvento.toMillis(true);

        Time nowTime = new Time(Time.getCurrentTimezone());
        nowTime.setToNow();
        nowTime.normalize(true);
        long nowMillis = nowTime.toMillis(true);

        long milliDiff = confMillis - nowMillis;

        c = new CountDownTimer(milliDiff, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                try{
                    segundosFaltantes = (int) (millisUntilFinished / 1000) % 60 ;
                    minutosFaltantes = (int) ((millisUntilFinished / (1000*60)) % 60);
                    horasFaltantes   = (int) ((millisUntilFinished / (1000*60*60)) % 24);
                    diasfaltantes = (int) (millisUntilFinished/(1000*60*60*24));

                    String dias = ""+diasfaltantes;
                    if (diasfaltantes < 10){
                        dias = "0"+diasfaltantes;
                    }
                    String hrs = ""+horasFaltantes;
                    if (horasFaltantes < 10){
                        hrs = "0"+horasFaltantes;
                    }
                    String min = ""+minutosFaltantes;
                    if (minutosFaltantes < 10){
                        min = "0"+minutosFaltantes;
                    }
                    String seg = ""+segundosFaltantes;
                    if (segundosFaltantes < 10){
                        seg = "0"+segundosFaltantes;
                    }
                    TextCounter = (TextView) findViewById(R.id.counter);
                    TextCounter.setText(dias + "  " + hrs + "  " + min + "  " +seg);
                    TextDescription = (TextView) findViewById(R.id.definicion);
                    //TextLine = (TextView) findViewById(R.id.lines);
                    //TextLine.setText("___  ___  ___  ___");
                    String fDias = getResources().getString(R.string.dias);
                    String fHoras = getResources().getString(R.string.horas);
                    String fMinutos = getResources().getString(R.string.minutos);
                    String fSegundos = getResources().getString(R.string.segundos);
                    TextDescription.setText(fDias+"\u00A0"+"\u00A0 \u00A0 \u00A0"+fHoras+"\u00A0"+"\u00A0 \u00A0"+fMinutos+"\u00A0"+"\u00A0 \u00A0"+fSegundos);

                } catch (Exception e) {
                }
            }
            @Override
            public void onFinish() {
                TextCounter = (TextView) findViewById(R.id.counter);
                TextCounter.setText("00:00 - 00:00 - 00:00 - 00:00");
                TextDescription = (TextView) findViewById(R.id.definicion);
                TextDescription.setText("Sigan disfrutando del evento");
            }
        }.start();
    }
}
