package com.example.diksh.languageprefences;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView languagebar;
    SharedPreferences sharedPreferences;
    public void setlanguage(String languagestring){

          sharedPreferences.edit().putString("language",languagestring).apply();
        //String getlanguage=sharedPreferences.getString(languagestring,"noooo");
        languagebar.setText(languagestring);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);
         switch(item.getItemId()){
             case R.id.english:
                 setlanguage("English");
                 return true;
             case R.id.spanish:
                setlanguage("Spanish");
                 return true;
             default:
                 return false;


         }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languagebar=(TextView)findViewById(R.id.languagebar) ;
        sharedPreferences=this.getSharedPreferences("com.example.diksh.languageprefences", Context.MODE_PRIVATE);

        String getlanguage=sharedPreferences.getString("language","");
        if(getlanguage=="") {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Choose a language")
                    .setMessage("Which Language Would You Like???")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setlanguage("English");
                        }

                    })
                    .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            setlanguage("Spanish");
                        }
                    })
                    .show();

        }
        else{
            languagebar.setText(getlanguage);
        }




    }
}
