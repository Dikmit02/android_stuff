package com.diksha.gameconnect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    // 0 yellow 1 rdd

    int activeplayer=0;
    boolean gameISActive =true;
    //2 means unplayed
    int []gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winningpositions ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view ){
        ImageView counter =(ImageView) view;
        System.out.println(counter.getTag().toString());
        int tappedcounter=Integer.parseInt(counter.getTag().toString());
        if (gamestate[tappedcounter]==2&&gameISActive){
            gamestate[tappedcounter]=activeplayer;
        }
        counter.setTranslationY(-1000f);
        if(activeplayer==0)
        {
            counter.setImageResource(R.drawable.yellow);
            activeplayer=1;}
        else{
            counter.setImageResource(R.drawable.red);
            activeplayer=0;
        }
        counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

        for(int [] winningposition: winningpositions){
            if(gamestate[winningposition[0]]==gamestate[winningposition[1]]&&
                    gamestate[winningposition[1]]==gamestate[winningposition[2]]&&
                    gamestate[winningposition[0]]!=2)
            {   String winner ="RED";
                if (gamestate[winningposition[0]]==0){
                    winner ="YELLOW";

                }
                //someone has won
                gameISActive=false;
                TextView winnermessage=(TextView) findViewById(R.id.winnermessage);
                winnermessage.setText(winner+" has won!");
                LinearLayout layout=(LinearLayout)findViewById(R.id.playagainLayout);
                layout.setVisibility(View.VISIBLE);

            }
            //draw
            else
            {    boolean gameisover=true;
                for(int counterstate:gamestate){
                    if(counterstate==2)gameisover=false;

                }
                if(gameisover){
                    TextView winnermessage=(TextView) findViewById(R.id.winnermessage);
                    winnermessage.setText("it is a draw!!");
                    LinearLayout layout=(LinearLayout)findViewById(R.id.playagainLayout);
                    layout.setVisibility(View.VISIBLE);
                }
            }


        }


    }
    public void playagain(View view)
    {   gameISActive=true;
        LinearLayout layout=(LinearLayout)findViewById(R.id.playagainLayout);
        layout.setVisibility(View.INVISIBLE);
        activeplayer=0;
        //2 means unplayed
        int []gamestate={2,2,2,2,2,2,2,2,2};
        for(int i =0;i<gamestate.length;i++)
        {
            gamestate[i]=2;

        }
        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
