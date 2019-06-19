package com.example.diksh.cbsharedprefrences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button r,b,g;
    LinearLayout li;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li=findViewById(R.id.llbackround);
        r=findViewById(R.id.redbutton);
        b=findViewById(R.id.bluebutton4);
        g=findViewById(R.id.greenbutton5);
        sharedPreferences=getSharedPreferences("SP_NAME",MODE_PRIVATE);
        int a=sharedPreferences.getInt("colour",Color.WHITE);

        li.setBackgroundColor(a);

        r.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                li.setBackgroundColor(Color.RED);
                savecolour(Color.RED);

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                li.setBackgroundColor(Color.BLUE);
                savecolour(Color.BLUE);
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                li.setBackgroundColor(Color.GREEN);
                savecolour(Color.GREEN);
            }
        });

    }
    public void savecolour(Integer c){
        SharedPreferences.Editor editor= sharedPreferences.edit();


        editor.putInt("colour",c);
        editor.apply();

    }
}
