package com.example.diksh.countdowntimer;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    countDowntimer cdt;
    EditText minutetext;
    EditText secondtext;
    TextView counttext;
    Button strtbutton,pausebtn;
    boolean ppbuttonpressed=false;
    int minutes,seconds,t=0;

    int minsec=1;


    void classfunction(){

        cdt=new countDowntimer();
        minutes=Integer.parseInt(String.valueOf(minutetext.getText()));
        seconds=Integer.parseInt(String.valueOf(secondtext.getText()));

        minsec=(minutes*60)+seconds;
        cdt.execute(minsec);

    }

    private void playpausefunction() {

        if (t % 2 == 0) {
            // paused and not waiting for play
            pausebtn.setText("PLAY");

            cdt.cancel(true);
            t++;
        } else {
            // play and waiting for pause
            t++;
            pausebtn.setText("PAUSE");
            classfunction();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minutetext=(EditText)findViewById(R.id.minutetext);
        secondtext=(EditText)findViewById(R.id.secondtext);
        counttext=(TextView)findViewById(R.id.countdoentext);
        strtbutton=(Button)findViewById(R.id.strartbtn);
        pausebtn=(Button)findViewById(R.id.pausebtn);


        strtbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               InputMethodManager mgr=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
               mgr.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);



               if (ppbuttonpressed){
                   playpausefunction();
               }
               else {
                   classfunction();
               }
               counttext.setText(minutetext.getText().toString()+":"+secondtext.getText().toString());
               }
       });
       pausebtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               ppbuttonpressed =true;
               if(ppbuttonpressed) {
                   playpausefunction();

               }

           }
       });

    }



    class countDowntimer extends AsyncTask<Integer,Integer,Void>{


        @Override
        protected Void doInBackground(Integer... integers) {


                int n = integers[0];

                for (int i = n; i >= 0; i--) {

                    wait1sec();
                    publishProgress(i);
                    if(isCancelled())
                        break;
                }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            int m=values[0]/60;
            int s=values[0]%60;
            if(m<10&&s<10){
                counttext.setText("0" +m + ":" + "0" + s);
            }
            else if (m < 10) {

                    counttext.setText("0" + m + ":" + s);
            }

            else if (s < 10){
                    counttext.setText(m + ":" + "0" + s);
            }


            else {
                counttext.setText(m + ":" + s);
            }

            secondtext.setText(String.valueOf(s));
            minutetext.setText(String.valueOf(m));

        }



        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            counttext.setText("Countdown Finished!!!");
        }


    }
    void wait1sec(){
        long startTime=System.currentTimeMillis();
        while(System.currentTimeMillis()<startTime+1000);
    }



}
