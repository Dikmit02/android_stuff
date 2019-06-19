package com.diksha.hehehehehehe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        int k=0;
        public void fade (View view) {
                if(k==0) {

                    ImageView img = (ImageView) findViewById(R.id.welcome);
                    img.animate().alpha(0f).setDuration(1000);
                    ImageView img1 = (ImageView) findViewById(R.id.one);
                    img1.animate().alpha(1f).setDuration(1000);
                }
                else if (k==1)
                {
                    ImageView img = (ImageView) findViewById(R.id.one);
                    img.animate().alpha(0f).setDuration(1000);
                    ImageView img1 = (ImageView) findViewById(R.id.two);
                    img1.animate().alpha(1f).setDuration(1000);

                }
                else if (k==2)
                {
                    ImageView img = (ImageView) findViewById(R.id.two);
                    img.animate().alpha(0f).setDuration(1000);
                    ImageView img1 = (ImageView) findViewById(R.id.three);
                    img1.animate().alpha(1f).setDuration(1000);

                }
                else if (k==3)
                {
                    ImageView img = (ImageView) findViewById(R.id.three);
                    img.animate().alpha(0f).setDuration(1000);
                    ImageView img1 = (ImageView) findViewById(R.id.four);
                    img1.animate().alpha(1f).setDuration(1000);

                }
                else if (k==4)
                {
                    ImageView img = (ImageView) findViewById(R.id.four);
                    img.animate().alpha(0f).setDuration(1000);
                    ImageView img1 = (ImageView) findViewById(R.id.five);
                    img1.animate().alpha(1f).setDuration(1000);

                }
                else
                {
                    ImageView img = (ImageView) findViewById(R.id.five);
                    img.animate().alpha(0f).setDuration(1000);
                    ImageView img1 = (ImageView) findViewById(R.id.sorry);
                    img1.animate().alpha(1f).setDuration(1000);
                }

                k++;


        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
