package com.example.diksh.cbweb;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tx=(TextView)findViewById(R.id.tvans);



        Intent i=getIntent();
        int ans =i.getIntExtra("result",0);
        tx.setText(String.valueOf(ans));



    }
}
