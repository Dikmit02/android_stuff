package com.diksha.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000,1000){

                public void onTick(long millisecondUntilDone){
                  //for 1 sec here
                    //countdown is counting down ie every sec
                    Log.i("Seconds left",String.valueOf(millisecondUntilDone/1000));
                }


                public void onFinish(){
                    //every 10 sec
                    Log.i("Done","Countdown tier finished");
                }

        }.start();






        final Handler handler=new Handler();
        Runnable run =new Runnable() {
            @Override
            public void run() {
                //Inset code to be run every second

                handler.postDelayed(this,1000);
                Log.i("Runnable has run ","a second must have passed...");
            }
        };
        //initialise runnable in first place
        //execute runnable righgt from start as soon as runfrist tym caal fro second and keep goind
        handler.post(run);

    }
}
