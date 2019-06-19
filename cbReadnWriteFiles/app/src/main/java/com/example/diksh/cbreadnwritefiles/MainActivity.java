package com.example.diksh.cbreadnwritefiles;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnwrite,btnread;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        btnread=findViewById(R.id.btnread);
        btnwrite=findViewById(R.id.btnwrite);
        textview=findViewById(R.id.textView);





        btnwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=editText.getText().toString();

                File dataDir=ContextCompat.getDataDir(MainActivity.this);
                File myfile=new File(dataDir,"file.txt");

                try {
                    FileOutputStream fos=new FileOutputStream(myfile,true);
                    fos.write(text.getBytes());
                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this, "File not Found", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error while writing a file", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dataDir=ContextCompat.getDataDir(MainActivity.this);
                File myfile=new File(dataDir,"file.txt");

                try {
                    FileInputStream fis=new FileInputStream(myfile);
                    InputStreamReader isr=new InputStreamReader(fis);
                    BufferedReader br=new BufferedReader(isr);

                    StringBuilder sb =new StringBuilder();
                    String buffer=br.readLine();

                    while(buffer!=null){
                        sb.append(buffer);
                        buffer=br.readLine();
                    }
                    String text=sb.toString();
                    textview.setText(text);

                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this, "File not Found", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "Error while writing a file", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
