package com.example.diksh.jinglejasnparsing;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class MainActivity extends AppCompatActivity {

    Button btn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        DownloadTask task = new DownloadTask();
        task.execute("http://serv.kesbokar.com.au/jil.0.1/v2/yellowpage-categories?tlevel=0&api_token=FSMNrrMCrXp2zbym9cun7phBi3n2gs924aYCMDEkFoz17XovFHhIcZZfCCdK");

    }
      public class DownloadTask extends AsyncTask<String,Void,String>{

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
                    result+=cc;
                    data=inputStreamReader.read();
                }


                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "NO STRING";
            } catch (IOException e) {
                e.printStackTrace();
                return "NO STRING";
            }

        }


        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            try {

                JSONObject jsonObject=new JSONObject(result);

                JSONArray jsonArray=jsonObject.getJSONArray("data");
                for(int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonnew = jsonArray.getJSONObject(i);
                    final Integer id = jsonnew.getInt("id");
                    final String url_name = jsonnew.getString("url_name");
                    final Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            intent.putExtra("getid",id);
                            intent.putExtra("geturl_name",url_name);

                            startActivity(intent);



                        }
                    });



                }





            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }
}




