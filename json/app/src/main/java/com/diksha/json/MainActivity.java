package com.diksha.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    public class Downloadtask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String result ="";
            URL url;
            HttpsURLConnection httpsURLConnection=null;

            try {
                url=new URL(strings[0]);
                httpsURLConnection =(HttpsURLConnection) url.openConnection();
                InputStream inputStream= httpsURLConnection.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                int data =inputStreamReader.read();
                while(data!=-1){
                    char cc=(char)data;
                    result+=data;
                    data=inputStreamReader.read();

                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "NO RESULT";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String m=null;
        Downloadtask dn=new Downloadtask();
        try {
            m=dn.execute("http://www.ipu.ac.in/").get();
            Log.i("RESULTTT",m);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
