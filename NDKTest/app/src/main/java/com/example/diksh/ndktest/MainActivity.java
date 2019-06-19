package com.example.diksh.ndktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {
 public static final String TAG="maincativity";

 static {
     if(!OpenCVLoader.initDebug()){
         Log.d(TAG,"OPEN CV NOT LOADED");
     }
     else{
         Log.d(TAG,"OPEN CV LOADED");
     }
 }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
