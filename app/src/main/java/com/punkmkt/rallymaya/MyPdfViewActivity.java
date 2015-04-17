package com.punkmkt.rallymaya;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.punkmkt.rallymaya.utils.NetworkUtils;


public class MyPdfViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_my_pdf_view, frameLayout);
        String title;
        title = getResources().getString(R.string.pdf_seccion);
        setTitle(title);
        String LinkToPDF ="http://punklabs.ninja/rallymaya/static/REGLAMENTO-OFICIAL-DEFINITIVO-RALLY-MAYA-2015.pdf";
        WebView mWebView= (WebView) this.findViewById(R.id.webView);
        if(NetworkUtils.haveNetworkConnection(this)) {
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
            mWebView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + LinkToPDF);
        }
        else{
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.revise_conexion), Toast.LENGTH_SHORT).show();
        }
    }




}
