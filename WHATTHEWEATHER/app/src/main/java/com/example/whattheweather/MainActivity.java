package com.example.whattheweather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

//    public class DownloadTask extends AsyncTask<String ,Void,String> {
//
//        @Override
//        protected String doInBackground(String... strings) {
//            String result="";
//            URL url;
//            HttpURLConnection httpURLConnection=null;
//            try {
//                url=new URL(strings[0]);
//                httpURLConnection=(HttpURLConnection)url.openConnection();
//                InputStream inputStream=httpURLConnection.getInputStream();
//                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
//
//                int data=inputStream.read();
//                while(data!=-1)
//                {
//                    char cc=(char)data;
//                    result+=cc;
//                    data=inputStreamReader.read();
//                }
//                return result;
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//                return "NO STRING";
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "NO STRING";
//            }
//
//
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            Log.i("WEATHERCONTENT",result);
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DownloadTask task=new DownloadTask();
        imageView=(ImageView)findViewById(R.id.imageView2);
        Button btn=(Button)findViewById(R.id.button);
        textView=findViewById(R.id.editText);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               imageView.setVisibility(View.INVISIBLE);
           }
       });
//        String m="delhi";
 //       task.execute("https://api.openweathermap.org/data/2.5/weather?q="+m+"&units=metric&appid=92b6eee1b96fa751857c27add2f82bd7");




    }
}
