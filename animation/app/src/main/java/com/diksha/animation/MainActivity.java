package com.diksha.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int k=0;
    public void fade (View view) {

         if(k==0) {
             ImageView img = (ImageView) findViewById(R.id.imageView);
             img.animate().alpha(0f).setDuration(1000);
             ImageView img1 = (ImageView) findViewById(R.id.cat);
             img1.animate().alpha(1f).setDuration(1000);
         }
         else if(k==1)
         {    ImageView img1 = (ImageView) findViewById(R.id.cat);
             img1.animate().alpha(0f).setDuration(1000);
             ImageView img = (ImageView) findViewById(R.id.welcome);
             img.animate().alpha(1f).setDuration(1000);

         }
         else
         {
             ImageView img1 = (ImageView) findViewById(R.id.welcome);
             img1.animate().alpha(0f).setDuration(1000);
             ImageView img = (ImageView) findViewById(R.id.imageView);
             img.animate().alpha(1f).setDuration(1000);
         }
        k++;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
