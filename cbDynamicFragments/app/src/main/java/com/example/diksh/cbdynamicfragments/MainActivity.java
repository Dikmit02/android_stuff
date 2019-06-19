package com.example.diksh.cbdynamicfragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button fruitbtn=findViewById(R.id.fruitbtn);
        Button vegbtn=findViewById(R.id.vegbtn);



        fruitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragContainer, new FruitFragment())
                        .commit();



            }
        });
        vegbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragContainer, new VegetableFragment())
                        .commit();



            }
        });
    }
}
