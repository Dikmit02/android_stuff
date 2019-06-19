package com.diksha.numberapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void clickbutton(View view){

        EditText text =(EditText) findViewById(R.id.text);
        int n =Integer.parseInt(text.getText().toString()); 


        if(n==traiangularnumber(n)&&n==squarenumber(n))
        {

            Toast.makeText(MainActivity.this, "It is both trianguar and square number", Toast.LENGTH_SHORT).show();

        }
        else if(n==traiangularnumber(n))
        {

            Toast.makeText(MainActivity.this, "It is a triangular number", Toast.LENGTH_SHORT).show();
        }
        else if(n==squarenumber(n))
        {
            Toast.makeText(MainActivity.this, "It is a square number", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "It is not trianguar neither square number", Toast.LENGTH_SHORT).show();
        }
    }
    public static int traiangularnumber(int n ) {
        int s=0,a=0;
        while(s<=n)
        {
            s+=a;
            if(s==n)
            {
                break;
            }
            a++;
        }
        return s;
    }
    public static int  squarenumber(int n ) {
        int a=0;
        int sq=0;
        while(sq<=n)
        {
            sq=a*a;
            if(sq==n)
            {
                break;
            }
            a++;
        }
        return sq;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
