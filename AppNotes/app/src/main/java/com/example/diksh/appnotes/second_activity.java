package com.example.diksh.appnotes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import static com.example.diksh.appnotes.MainActivity.a;

public class second_activity extends AppCompatActivity {
    int noteid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        EditText editText=(EditText)findViewById(R.id.editText);

                Intent intent=getIntent();
                noteid=intent.getIntExtra("noteId",-1);


                if(noteid!=-1){
                    editText.setText(MainActivity.notes.get(noteid));
                }
                //else if new note is added using: three dot options
                //                               .
                else{
                    MainActivity.notes.add("");
                    noteid=MainActivity.notes.size()-1;
                    MainActivity.arrayAdapter.notifyDataSetChanged();
                }

                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                           MainActivity.notes.set(noteid,String.valueOf(s));
                           //s is content of the edit text and any changed to text is stored in thr charsequence that is s
                           MainActivity.arrayAdapter.notifyDataSetChanged();
                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.diksh.appnotes", Context.MODE_PRIVATE);
                        try {
                            sharedPreferences.edit().putString("getnotess",ObjectSerializer.serialize(MainActivity.notes)).apply();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });









    }



}
