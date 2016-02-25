package com.punkmkt.rallymaya.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.text.format.Time;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.punkmkt.rallymaya.MyVolleySingleton;
import com.punkmkt.rallymaya.R;

/**
 * Created by germanpunk on 24/02/16.
 */
public class HomeFragment extends Fragment {
    protected TextView mTextView;
    protected TextView mCurrWeather;
    protected TextView mStatus;
    protected TextView mLabels;
    CountDownTimer c;

    protected final String CURRENT_WEAHTER_STATUS = "http://api.openweathermap.org/data/2.5/weather?id=3530597&units=metric&lang=es&APPID=0b6b95e193ac67ee6045b6f766bc6cdb";

    Time fechaEvento = new Time(Time.getCurrentTimezone());
    int hora = 13;
    int minuto = 00;
    int segundo = 00;
    int dia = 01;
    // month is zero based...7 == August
    int mes = 10;
    int ano;

    private int diasfaltantes;
    private int horasFaltantes;
    private int minutosFaltantes;
    private int segundosFaltantes;
    ImageView mImageView;
    private String AHZ_LATEST_THREE_NEWS_ENTRIES = "http://104.236.3.158/api/noticias/ultimas_noticias/3/";
    public TextView tituloNoticia1, tituloNoticia2, tituloNoticia3;
    private ImageLoader imageLoader = MyVolleySingleton.getInstance().getImageLoader();

    NetworkImageView last,last2,last3;
    public String img1, img2, img3, id, id2, id3, nom1, nom2, nom3, subtitulo1, subtitulo2, subtitulo3, desc1, desc2, desc3;
    private Button button;

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
                    mTextView = (TextView) getActivity().findViewById(R.id.counter);
                    mTextView.setText(dias + " : " + hrs + " : " + min + " : " +seg);
                    mLabels = (TextView) getActivity().findViewById(R.id.definicion);
                    String fDias = getResources().getString(R.string.dias);
                    String fHoras = getResources().getString(R.string.horas);
                    String fMinutos = getResources().getString(R.string.minutos);
                    String fSegundos = getResources().getString(R.string.segundos);
                    mLabels.setText(fDias+"\u00A0"+"\u00A0 \u00A0 \u00A0"+fHoras+"\u00A0"+"\u00A0 \u00A0"+fMinutos+"\u00A0"+"\u00A0 \u00A0"+fSegundos);
                } catch (Exception e) {
                }
            }
            @Override
            public void onFinish() {
                Context context = getActivity();
                mTextView = (TextView) getActivity().findViewById(R.id.counter);
                mTextView.setText("00:00 - 00:00 - 00:00 - 00:00");
                mLabels = (TextView) getActivity().findViewById(R.id.definicion);
                mLabels.setText("Sigan disfrutando del evento");
            }
        }.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        c.cancel();

    }
    public void onResume(){
        super.onResume();
        configuracionEvento();
    }
}
