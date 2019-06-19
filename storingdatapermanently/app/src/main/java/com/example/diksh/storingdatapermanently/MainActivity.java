package com.example.diksh.storingdatapermanently;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.diksh.storingdatapermanently", Context.MODE_PRIVATE);
        ArrayList<String> friends=new ArrayList<>();
        friends.add("diksha");
        friends.add("kanika");
        try{
            sharedPreferences.edit().putString("friends",ObjectSerializer.serialize(friends)).apply();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> newfriends=new ArrayList<>();
        try {
            newfriends=(ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>() )));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("newfriends",newfriends.toString());



        /* sharedPreferences.edit().putString("dikshaaaa","rob");
        String dikshaaaa=sharedPreferences.getString("dikshaaaa","ftftftftf");
        Log.i("username",dikshaaaa);*/
    }
}
