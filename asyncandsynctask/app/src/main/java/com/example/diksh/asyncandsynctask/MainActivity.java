package com.example.diksh.asyncandsynctask;

import android.graphics.Color;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button chngcolour;
    ConstraintLayout clBackground;
    ListView lvitems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chngcolour=(Button)findViewById(R.id.buttonChaneColour);
        clBackground=(ConstraintLayout)findViewById(R.id.clBackground);
        lvitems=(ListView)findViewById(R.id.itemlist);
         String[] item=new String[]{
                 "Alpha",
                 "Beta",
                 "Gamma",
                 "Delta",
                 "Phi",
                 "CURO",
                 "STRATRA",
                 "DIKSHA",
                 "MANIKYA",
                 "KANIKA"
         };

        ArrayAdapter<String> itemadapter=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                item
        );
        lvitems.setAdapter(itemadapter);
        chngcolour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clBackground.setBackgroundColor(Color.RED);
                //Log.i("TAG", String.valueOf(System.currentTimeMillis()));
                ///waitNsec(10);

                Handler h=new Handler();
                Runnable r=new Runnable() {
                    @Override
                    public void run() {
                        Log.i("hiiiiii","we have delayed for 5 sec");
                        clBackground.setBackgroundColor(Color.RED);

                    }
                };
                h.postDelayed(r,10000);
                // due to postDelayed it will calculate on seperate thread
                
            }
        });

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
