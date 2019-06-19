package com.example.diksh.appnewsreader;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    static String selectedFromList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview=(ListView)findViewById(R.id.list);

        ArrayList<String> newslist=new ArrayList<>();

        newslist.add("general");
        newslist.add("business");
        newslist.add("entertainment");
        newslist.add("sports");
        newslist.add("science");
        newslist.add("health");
        newslist.add("technology");



        ArrayAdapter<String>arrayAdapter=new ArrayAdapter <String>(this,android.R.layout.simple_list_item_1,newslist);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedFromList = (String) listview.getItemAtPosition(position);

                Intent intent=new Intent(getApplicationContext(),newsoflist.class);
                startActivity(intent);


            }
        });



    }

}
