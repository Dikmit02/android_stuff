package com.example.diksh.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
     private EditText resultEditText;
     private Button launchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
        resultEditText=(EditText)findViewById(R.id.resulteditText2);
        launchButton=(Button)findViewById(R.id.button2);

        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,content_child.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe
    public void onEvent(CustomMessageEvent event){
        Log.d("ElectronicArmory","Eventfired");
        resultEditText.setText(event.getCustomMessage());
    }
}
