package com.example.webviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private WebView alcidaeWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alcidaeWeb = (WebView)findViewById(R.id.help);
        alcidaeWeb.setWebViewClient(new WebViewClient());
        alcidaeWeb.setWebChromeClient(new WebChromeClient());

        WebSettings webSettings = alcidaeWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setDomStorageEnabled(true);

        Random rand = new Random();
        String helpURL = "https://www.alcidae.com/pages/shop-cart" + "?r=" + rand.nextInt(10000);

        alcidaeWeb.loadUrl(helpURL);
    }

    @Override
    public void onBackPressed() {
        alcidaeWeb.goBack();
    }
}
