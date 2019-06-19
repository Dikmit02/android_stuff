package com.example.diksh.appnewsreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.example.diksh.appnewsreader.newsoflist.listofurls;
import static com.example.diksh.appnewsreader.newsoflist.pos;


public class contentofnews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentofnews);
       Intent intent=getIntent();

        String urll=listofurls.get(pos);
        Log.i("popopopopopo",urll);

        WebView webView=(WebView)findViewById(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(urll);

    }
}
