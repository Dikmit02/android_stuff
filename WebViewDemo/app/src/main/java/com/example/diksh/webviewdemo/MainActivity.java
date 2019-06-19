package com.example.diksh.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView webView=(WebView)findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.google.com");

        //webView.loadData("<html><body><h1> hi here!</h1><p> this is a paragraph</p></body></html>","text/html","UTF-8");
        // "text/html type of data that we Rae loading here and here in thsi case we are using html data
        //UTF-8 is a type of charcter encoding na dUTF-8 is a default character decoding




    }
}
