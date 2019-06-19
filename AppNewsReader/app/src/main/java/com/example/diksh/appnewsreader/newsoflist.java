package com.example.diksh.appnewsreader;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
import java.util.concurrent.ExecutionException;

import static com.example.diksh.appnewsreader.MainActivity.selectedFromList;

public class newsoflist extends AppCompatActivity {
    ListView listVieww;
    ArrayList<String> titlelist;
    static int pos;

    static ArrayList<String> listofurls;

    public void function(){
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter <String>(this,android.R.layout.simple_list_item_1,titlelist);
        listVieww.setAdapter(arrayAdapter);
        listVieww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos=position;
                Intent intent=new Intent(getApplicationContext(),contentofnews.class);
                startActivity(intent);




            }
        });

 }

    public void functiondownloadtask(String str){


        DownloadTask downloadTask=new DownloadTask();
        try {
            downloadTask.execute(str).get();

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsoflist);


        Intent intent=getIntent();

        Toast.makeText(this, selectedFromList.toString(), Toast.LENGTH_SHORT).show();
        functiondownloadtask("https://newsapi.org/v2/top-headlines?country=in&category="+MainActivity.selectedFromList.toString()+"&apiKey=ebc60ba7721d4be2a0b1b1dd7fdb37e4");


         listVieww=(ListView)findViewById(R.id.listvieww);
         titlelist=new ArrayList<>();
         listofurls=new ArrayList<>();

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
                InputStreamReader reader=new InputStreamReader(inputStream);

                int data=reader.read();
                while(data!=-1){
                    char cc=(char)data;
                    result+=cc;
                    data=reader.read();
                }
                 Log.i("resultttt",result);
                 return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return "No String";
        }

        @Override
         protected void onPostExecute(String result) {
            super.onPostExecute(result);
               try {

                   JSONObject jsonnew;

                   JSONObject jsonObject=new JSONObject(result);
                   JSONArray jsonArray=jsonObject.getJSONArray("articles");

                for(int i=0;i<jsonArray.length();i++){
                    jsonnew=jsonArray.getJSONObject(i);
                    String title=jsonnew.getString("title");
                    String urll=jsonnew.getString("url");
                    Log.i("url",urll);
                    titlelist.add(title);
                    listofurls.add(urll);
        }
                function();


//                   JSONObject jsonnn=jsonArray.getJSONObject(pos);
//                   urll=jsonnn.getString("url");
//                   Intent intent=new Intent(getApplicationContext(),contentofnews.class);
//                   startActivity(intent);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    }

