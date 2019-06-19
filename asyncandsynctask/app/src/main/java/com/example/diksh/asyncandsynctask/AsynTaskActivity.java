package com.example.diksh.asyncandsynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class AsynTaskActivity extends AppCompatActivity {

    TextView tvCounter;
    Button btnstart,btnrandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyn_task);

        tvCounter=(TextView)findViewById(R.id.tvCounter);
        btnstart=(Button)findViewById(R.id.btnStart);
        btnrandom=(Button)findViewById(R.id.btnRandom);

        btnrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                tvCounter.setText(String.valueOf(r.nextInt(100)));

            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Countclass cls=new Countclass();
                cls.execute(5);
               // cls.doInBackground(5);(Skipped 299 frames!  The application may be doing too much work on its main thread.
                // will be printed therefore always use .execute function)
                        // whatever first generic type execute and doinbackground both will take same
                //here Integer is that generic type

            }
        });





    }

    class Countclass extends AsyncTask<Integer,Integer,Void>{
        @Override
        protected Void doInBackground(Integer... integers) {
            // background thread
            // can send n number of integer argument in this funvtion

           Log.i("doInBackground","started");
            int n=integers[0];
            //n=5;
            /*waitNsec(n);*/
            //for(int i=n;i>=0;i--)
             for(int i=0;i<=n;i++){
                wait1sec();
                publishProgress(i);
            }

            Log.i("doInBackground","ended");
            return null;
        }

        //how much to count
        //how much it has counted
        // final rresult is taking as void


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvCounter.setText(String.valueOf(values[0]));

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tvCounter.setText("Countdown Finished!!!");
        }
    }
    void wait1sec(){
        long startTime=System.currentTimeMillis();
        while(System.currentTimeMillis()<startTime+1000);
    }

    void waitNsec(int n ){
        for(int i=0;i<n;i++){
            wait1sec();

        }
    }

}
