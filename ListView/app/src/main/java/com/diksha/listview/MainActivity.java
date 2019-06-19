package com.diksha.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mylistview=(ListView) findViewById(R.id.myListview);
        final ArrayList<String> myfamily= new ArrayList<>();
        myfamily.add("Ajay");
        myfamily.add("Seema");
        myfamily.add("Kanika");
        myfamily.add("Diksha");
        myfamily.add("Manikya");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myfamily);
        mylistview.setAdapter(arrayAdapter);
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //AdapterView<?>???? type of view
                // if want to disapper;
                //paent.setVisibility(View.GONE);
                //View that is actually tapped
                //position name of item is tapped ie row number
                Toast.makeText(MainActivity.this, "HII"+myfamily.get(position), Toast.LENGTH_SHORT).show();

            }
        });



    }
}
