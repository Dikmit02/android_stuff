package com.example.diksh.jinglejasnparsing;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    RecyclerView recyclerView;
    ProductAdapter adapter;

    List<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        String name=intent.getStringExtra("geturl_name");
        int id = getIntent().getExtras().getInt("getid");

        DownloadTask task = new DownloadTask();
        task.execute("http://serv.kesbokar.com.au/jil.0.1/v2/yellowpages?page=1&per_page=15&caturl="+name+"&catid="+String.valueOf(id)+"&api_token=FSMNrrMCrXp2zbym9cun7phBi3n2gs924aYCMDEkFoz17XovFHhIcZZfCCdK");



        //adding some items to our list







        //creating recyclerview adapter






    }
    public class DownloadTask extends AsyncTask<String,Void,String> {

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
                for(int i=jsonArray.length()-1;i<jsonArray.length();i++) {
                    JSONObject jsonnew = jsonArray.getJSONObject(i);
                    String  nameee=jsonnew.getString("name");

                          //setting adapter to recyclerview

                    productList=new ArrayList<>();


                    productList.add(
                            new Product(
                                    nameee,"hjhjfh","dhghjcd",R.drawable.headphines));

                    recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));




                    ProductAdapter adapter = new ProductAdapter(getBaseContext(), productList,nameee);



                    recyclerView.setAdapter(adapter);










                }











                } catch (JSONException e1) {
                e1.printStackTrace();
            }


        }

        }

    }


