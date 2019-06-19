package com.example.diksh.activitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class secondactivity extends AppCompatActivity {
    public void firstactivity(View view){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        
        
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        
        Intent intent=getIntent();
        Toast.makeText(this, intent.getStringExtra("username"), Toast.LENGTH_SHORT).show();
    }
}
