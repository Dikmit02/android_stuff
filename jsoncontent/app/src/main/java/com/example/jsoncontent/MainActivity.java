package com.example.jsoncontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    public class DownlaadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String result="";
            URL url;
            HttpURLConnection httpURLConnection;
            try {

                url=new URL(strings[0]);

                httpURLConnection=(HttpURLConnection)url.openConnection();

                InputStream inputStream=httpURLConnection.getInputStream();

                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);

                int data= inputStream.read();

                while(data!=-1){
                    char cc= (char) data;
                    result+=cc;
                    data=inputStreamReader.read();

                }


                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            }

            return "NO RETURN";

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {
                JSONObject jsonObject = new JSONObject(result);
                /*
                String weatherinfo=jsonObject.getString("list");
                Log.i("WEATHER CONTENT",weatherinfo);
                JSONArray array=new JSONArray(weatherinfo);
                */
                JSONArray array=jsonObject.getJSONArray("list");
                for(int i=0;i< array.length();i++){
                    JSONObject jsonpart= array.getJSONObject(i);
                    /*JSONObject obj=jsonpart.getJSONObject("main");
                    String temp=obj.getString("temp");
                    Log.i("tempooooo",temp);*/
                    JSONArray jsonarr= jsonpart.getJSONArray("weather");
                    for(int k=0;k<jsonarr.length();k++){
                        JSONObject jso=jsonarr.getJSONObject(k);
                        String mainn=jso.getString("main");
                        Log.i("mainnnn",mainn);



                    }




//                    Log.i("dt",jsonpart.getString("dt"));
//                    Log.i("main",jsonpart.getString("main"));
//


                        /*array=jsonObject.getJSONArray("main");
                        for(int k=0;k<array.length();k++)

                        {   jsonpart= array.getJSONObject(k);
                            Log.i("temp",jsonpart.getString("temp"));
                            Log.i("temp_min",jsonpart.getString("temp_min"));
                            Log.i("temp_max",jsonpart.getString("temp_max"));
                            Log.i("pressure",jsonpart.getString("pressure"));
                            Log.i("sea_level",jsonpart.getString("sea_level"));

                        }*/



                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownlaadTask task=new DownlaadTask();
        task.execute("https://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1");

       /* String m=null;
        try {

            m=task.execute("http://ipu.ac.in/").get();

            Log.i("INFORMATION",m);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


    }


}