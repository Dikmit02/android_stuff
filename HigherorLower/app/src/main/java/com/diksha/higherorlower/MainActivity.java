package com.diksha.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int ans;
    public void guessfunction(View view) {
        EditText et = (EditText) findViewById(R.id.editText);
        int a = Integer.parseInt(et.getText().toString());
        if(ans<a){
            Toast.makeText(MainActivity.this, "Lower!!", Toast.LENGTH_SHORT).show();
        }
        else if (ans>a){
            Toast.makeText(MainActivity.this, "Greater!!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Thats's right.Try again!!!", Toast.LENGTH_SHORT).show();
            Random rn= new Random();
            ans=rn.nextInt(20)+1;

        }

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rn= new Random();
        //int ans=rn.nextInt(max - min + 1) + ans=rn.nextInt(20)+1;
        ans=rn.nextInt(20)+1;
    }
}
