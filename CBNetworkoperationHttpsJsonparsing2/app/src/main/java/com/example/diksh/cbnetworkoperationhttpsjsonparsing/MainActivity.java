package com.example.diksh.cbnetworkoperationhttpsjsonparsing;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    String ee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.btn);
        Button getname=(Button)findViewById(R.id.getname);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    updatetextview();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        });

        getname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editname=(EditText)findViewById(R.id.editname);

                ee=editname.getText().toString();

            }
        });


    }
    private void updatetextview() throws IOException {
        // TextView textView=(TextView)findViewById(R.id.textview);
        //make network call here ans update the text view that we get from internet

        /*Networktask networktask=new Networktask();
        networktask.execute("https://api.github.com/search/users?q="+ee);*/
        makeaNetworkcall("https://api.github.com/search/users?q="+ee);
    }

    //using OKHttp
    void makeaNetworkcall(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

       // Response response = client.newCall(request).execute(); and its a synchronous call
        // synchronous call means as soon as the code will stop at ths line and will only resume when we get the response back from this

        //here .execute will run on the main thread and thos is the main disadvantage
        //therefore we will us ethe .enqueue and it will queuethe requests

        client.newCall(request).enqueue(new Callback() {
            // here the call ade is asynchronous
            @Override
            public void onFailure( Call call, IOException e) {
             // show a toast
            }

            @Override
            public void onResponse( Call call,  Response response) throws IOException {
                //COde
                // this method runs on the main thread
                String result=response.body().string();

                Log.i("ONRESPONSE",result);
                // use when we are using asynctask
               // ArrayList<GithubUser> users=parseJson(result);
                //final GithubUseradapter githubUseradapter=new GithubUseradapter(users);


                // using GSON
                Gson gson=new Gson();
                ApiResult apiResult=gson.fromJson(result,ApiResult.class);
                final GithubUseradapter githubUseradapter=new GithubUseradapter(apiResult.getItems());



                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //code here runs on main thread
                        RecyclerView recyclerView= findViewById(R.id.rvUser);

                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                        recyclerView.setAdapter(githubUseradapter);
                    }
                });






            }
        });




    }























    /*class Networktask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            String stringurl=strings[0];
            try {
                URL url=new URL(stringurl);
                //make coonection with url by openConnection ans store instance f this connection in httpsURLConnection we did this becuz we wnt to get the data


                HttpsURLConnection httpsURLConnection=(HttpsURLConnection) url.openConnection();
                //gives an inputstream
                InputStream inputStream=httpsURLConnection.getInputStream();
                //Scanner helps to readdata one by one
                Scanner scanner=new Scanner(inputStream);
                //next by oneby one and looping
                //delimiter allows to read entier inputstream in one go and save it as a string
                scanner.useDelimiter("\\A");
                if(scanner.hasNext()){
                    String s=scanner.next();
                    return s;


                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return "Failed to load";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ArrayList<GithubUser> users=parseJson(s);

           Log.i("userdlist", String.valueOf(users.size()));
            Log.i("userdlist", String.valueOf(users.get(7).getHtml_url()));

            GithubUseradapter githubUseradapter=new GithubUseradapter(users);
            RecyclerView recyclerView= findViewById(R.id.rvUser);

            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            recyclerView.setAdapter(githubUseradapter);





//            TextView textView=(TextView)findViewById(R.id.textview);
//            textView.setText(s);

        }



       }*/



    // we have use GSON and therefore no need to use it


    /*ArrayList<GithubUser> parseJson(String s ) {
        ArrayList<GithubUser>githubusers=new ArrayList<>();
        try {
            JSONObject root = new JSONObject(s);
            JSONArray item=root.getJSONArray("items");
            for (int i=0;i<item.length();i++){
                JSONObject object=item.getJSONObject(i);
                String login=object.getString("login");
                int id=object.getInt("id");
                String html_url=object.getString("html_url");
                Double score=object.getDouble("score");
                String avatar_val=object.getString("avatar_url");

                GithubUser gitUser=new GithubUser(login,id,html_url,score,avatar_val);
                githubusers.add(gitUser);

            }


        }
        catch(JSONException e){
            e.printStackTrace();
        }

        return githubusers;

    }*/
}
