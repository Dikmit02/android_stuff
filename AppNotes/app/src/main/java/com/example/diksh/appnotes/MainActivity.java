package com.example.diksh.appnotes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    static int a=0;
    static ArrayList<String> notes=new ArrayList<>();;
    static ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listvieww);

        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.diksh.appnotes",Context.MODE_PRIVATE);
        try {
            notes=(ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("getnotess",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(notes.size()==0){
            notes.add("Example note");
        }



        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,notes);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),second_activity.class);
                intent.putExtra("noteId",position);

                startActivity(intent);





            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Are you Sure??")
                        .setMessage("Do you want to delete this note??")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                notes.remove(position);
                                arrayAdapter.notifyDataSetChanged();
                                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.diksh.appnotes", Context.MODE_PRIVATE);
                                try {
                                    sharedPreferences.edit().putString("getnotess",ObjectSerializer.serialize(MainActivity.notes)).apply();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                        })
                        .setNegativeButton("NO",null)
                        .show();




                return true;
            }
        });







    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);









    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);


         Intent intent=new Intent(getApplicationContext(),second_activity.class);
         startActivity(intent);



        return true;
    }



}