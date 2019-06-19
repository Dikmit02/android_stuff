package com.diksha.appbraintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

//import java.util.ArrayList;
//import java.util.Random;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    TextView second;
    TextView score;

    ArrayList<Integer> arraylist=new ArrayList<Integer>();
    TextView correctwrong;
    TextView goTextView;
    CountDownTimer countDownTimer;
    TextView ansview;
    int time,randomnumone,randomnumtwo,ans,locationofcorrectans;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playagin;
    int totalcorrectans=0;
    int totalquesasked=0;
    int incorrectans;
    int k;
    int flag=0;


    public void Clck(View view){
       while(k==0) {
           if (view.getTag().toString().equals(Integer.toString(locationofcorrectans))) {
               correctwrong.setText("CORRECT!!!");
               totalcorrectans++;
               k=1;

           } else {
               correctwrong.setText("WRONG!!!");
               k=1;
           }
           totalquesasked++;
           score.setText(totalcorrectans + "/" + totalquesasked);
           flag = 0;
           arraylist.clear();

       }
       }
    public void playaginmethod (View view){

       // countDownTimer.cancel();
        correctwrong.setText("");
        score.setText("0/0");
        generateques();

    }
    public void random()
    {   flag=1;
        k=0;
        Random rand= new Random();

        randomnumone=rand.nextInt(21);
        randomnumtwo=rand.nextInt(21);
        ans=randomnumone+randomnumtwo;
        ansview.setText(Integer.toString(randomnumone)+" + "+Integer.toString(randomnumtwo));
        locationofcorrectans=rand.nextInt(4);
        button0.setVisibility(View.VISIBLE);

        button1.setVisibility(View.VISIBLE);

        button2.setVisibility(View.VISIBLE);

        button3.setVisibility(View.VISIBLE);



        for(int i=0;i<4;i++){
            if(i==locationofcorrectans){
                arraylist.add(randomnumone+randomnumtwo);


            }
            else{
                incorrectans=rand.nextInt(30);
                while(incorrectans==randomnumone+randomnumtwo)
                {
                    incorrectans=rand.nextInt(30);

                }
                arraylist.add(incorrectans);

            }

        }
        button0.setText(Integer.toString(arraylist.get(0)));
        button1.setText(Integer.toString(arraylist.get(1)));
        button2.setText(Integer.toString(arraylist.get(2)));
        button3.setText(Integer.toString(arraylist.get(3)));


    }
    public void generateques(){
        score.setVisibility(View.VISIBLE);
        second.setVisibility(View.VISIBLE);
        goTextView.setVisibility(View.INVISIBLE);

        ansview.setVisibility(View.VISIBLE);

        button0.setVisibility(View.VISIBLE);

        button1.setVisibility(View.VISIBLE);

        button2.setVisibility(View.VISIBLE);

        button3.setVisibility(View.VISIBLE);
        //gridlayout.setVisibility(View.VISIBLE);

        countDownTimer = new CountDownTimer(30000 + 300, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int tt = (int) millisUntilFinished / 1000;

                second.setText(Integer.toString(tt) + "s");
                if (flag == 0) {

                    random();
                }


            }

            @Override
            public void onFinish() {
                second.setText("0s");
                // k = 1;
                correctwrong.setText("YOUR SCORE:" + totalcorrectans + "/" + totalquesasked);
                playagin.setVisibility(View.VISIBLE);
                //again start
            }
        }.start();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            second = (TextView) findViewById(R.id.second);
            second.setVisibility(View.INVISIBLE);
            score = (TextView) findViewById(R.id.score);
            score.setVisibility(View.INVISIBLE);
            ansview = (TextView) findViewById(R.id.generateansview);
            ansview.setVisibility(View.INVISIBLE);
            button0 = (Button) findViewById(R.id.button0);
            button0.setVisibility(View.INVISIBLE);
            button1 = (Button) findViewById(R.id.button1);
            button1.setVisibility(View.INVISIBLE);
            button2 = (Button) findViewById(R.id.button2);
            button2.setVisibility(View.INVISIBLE);
            button3 = (Button) findViewById(R.id.button3);
            button3.setVisibility(View.INVISIBLE);
            playagin = (Button) findViewById(R.id.playagin);
            playagin.setVisibility(View.INVISIBLE);
            correctwrong = (TextView) findViewById(R.id.tteexxtt);


            goTextView = (TextView) findViewById(R.id.goTextView);

            goTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    correctwrong.setText("");
                   generateques();

                }
            });

        }


}
