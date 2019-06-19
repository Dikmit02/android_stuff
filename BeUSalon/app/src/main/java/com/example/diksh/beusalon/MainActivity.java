package com.example.diksh.beusalon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);


        toolbar.setLogo(R.drawable.weightlifting);

        toolbar.setTitle("Okhla Industrial Area");

        toolbar.setSubtitle("New Delhi");

        toolbar.setLogo(R.drawable.man_icon);


    }


}
