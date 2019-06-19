package com.diksha.webcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    // runnung a background task using AsyncTask
    public class DownloadTask extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... urls){
            ///protected here so can be used within the package itself
            ////strings... called varargas as a aray and contain bunch of strings that is send to downloadtask
            //Log.i("URL",params[0]);
            // Log.i("URLSSSSSS",params[1]);
            String result="";
            //html code stores in result
            URL url;//empty
            HttpURLConnection urlconnection =null;
            //HttpURLConnection a bit of browser oening up of browser and fetching the code;

            try{
                url=new URL(urls[0]);//www.ecohost//gives error if malfomed
                //opening up  browser window
                urlconnection=(HttpURLConnection)url.openConnection();
                //doing  load to browser
                InputStream in =urlconnection.getInputStream();
                // reading the uploaded data
                InputStreamReader reader= new InputStreamReader(in) ;
                // one character at a tym and keep the track og the location of the html code

                int data=reader.read();
                while(data!=-1){
                    char current =(char) data;
                    result+=current;

                    data=reader.read();

                }
                //result give the whole html code of the site
                return result;
                //result is returned to orgiall task

            }
            catch(Exception e){
                e.printStackTrace();//gives the details of the exception

                return "failed";

            }


            // return "DONE!!!!";
            /// download code from net

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////calling downloaadtask
        DownloadTask task=new DownloadTask();
        // task.execute("https://www.ecowebhosting.co.uk/","http://www.stackoverflow.com");
        // sending https://www.ecowebhosting.co.uk/ as a string to DownloadTask extends AsyncTask<String
        //https://www.ecowebhosting.co.uk/" as a array called params or a varagas
        //get the value return downhere
        ///String result=task.execute("https://www.ecowebhosting.co.uk/","http://www.stackoverflow.com").get();
        String result= null;
        try {
            result = task.execute("http://www.ipu.ac.in/").get();
            Log.i("resulttttttt",result);
        } catch (ExecutionException e) {
            e.printStackTrace();


        } catch (InterruptedException e) {
            e.printStackTrace();



        }

        //alaways use try and catch while asynctask
        ///interruted and execution exception
        ///they are working on diiffernt threads and their is a possibilty that there might be an error
        ///printStackTrace() it is a java method that only prints all the information about the exception that we wants to print




    }
}


