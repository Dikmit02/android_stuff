package com.diksha.imagetranslation;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int k=0;
    public void clickme(View view)
    {
        ImageView triangle=(ImageView) findViewById(R.id.triangle);

        triangle.animate().rotation(180).scaleX(1f).scaleY(1f).translationY(2000).setDuration(2000);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initial on screen
       // ImageView triangle = (ImageView) findViewById(R.id.triangle);
        //square.animate().translationXBy(-2000).setDuration(2000);
        //triangle.setTranslationX(-2000f);



    }
}
