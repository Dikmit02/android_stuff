package com.diksha.demoasyn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String,Void,String>
    {
        @Override
        protected String doInBackground(String... strings) {

            String result="";
            URL url;
            HttpURLConnection httpURLConnection=null;
            try {
                url=new URL(strings[0]);

                    httpURLConnection=(HttpURLConnection)url.openConnection();
                    InputStream inputStream=httpURLConnection.getInputStream();

                    InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                    int data=inputStreamReader.read();
                    while(data!=-1)
                    {
                        char cc=(char)data;
                        result=result+cc;
                        data=inputStreamReader.read();
                    }
                    return result;

                }
            catch (Exception e) {
                e.printStackTrace();
                return "no result";
            }


        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadTask downloadTask=new DownloadTask();
        String m=null;
        try {
            m = downloadTask.execute("http://www.ipu.ac.in/").get();
            Log.i("INFORMATION",m);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }
}
