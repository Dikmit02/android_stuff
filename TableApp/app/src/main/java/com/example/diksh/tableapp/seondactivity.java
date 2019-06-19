package com.example.diksh.tableapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class seondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seondactivity);

        Intent intent=getIntent();
        Toast.makeText(this, intent.getStringExtra("getname"), Toast.LENGTH_SHORT).show();

    }
}
