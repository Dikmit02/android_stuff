package com.example.diksh.makeup1;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<pojo> productList;
    GradientDrawable gradientDrawable;
    RecyclerView recyclerView;
    TextView textView5;


    Button grennbtn,bluebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grennbtn=(Button)findViewById(R.id.button2);
        grennbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gradientDrawable=(GradientDrawable) textView5.getBackground().mutate();
                gradientDrawable.setColor(Color.GREEN);

            }
        });


        getImages();



        }

    private void getImages() {

        productList=new ArrayList<>();






        productList.add(
                new pojo(
                        R.drawable.circle));
        productList.add(
                new pojo(
                        R.drawable.circle));

       // gradientDrawable.setColor(Integer.parseInt("#FFF"));
        productList.add(
                new pojo(
                        R.drawable.circle));
        productList.add(
                new pojo(
                        R.drawable.circle));

        getrecyclerview();

    }

    private void getrecyclerview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        circleRecyclerView adapter = new circleRecyclerView(getBaseContext(),productList);
        recyclerView.setAdapter(adapter);
    }
}
