package com.example.diksh.cbviewnlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG="button clicked";

    Button button2=(Button)findViewById(R.id.button2);
    Button button3=(Button)findViewById(R.id.button3);
    public void buttonclick(View v){

        Log.d(TAG,"BItton clicked");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"second button clicked");
            }
        });
        
        button3.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,"third button clciked");
        
    }
}
