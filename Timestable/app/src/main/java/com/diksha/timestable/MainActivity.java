package com.diksha.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    public void generatetable(int tn )
{

    ArrayList<String> timetablecontent=new ArrayList<>();
    for(int i=1;i<=10;i++){
        timetablecontent.add(Integer.toString(i*tn));
    }
    ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timetablecontent);
    listview.setAdapter(arrayAdapter);
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekbar=(SeekBar) findViewById(R.id.seekBar);
       listview=(ListView)findViewById(R.id.mylistview);
        seekbar.setMax(20);
        seekbar.setProgress(10);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


                    int min=1;
                    int tt;
                    if(progress<min)
                    {
                        tt=min;
                    }
                    else {
                        tt=progress;
                    }
                    Log.i("change",Integer.toString(progress));
                    //progress start from 0
                    Log.i("change1",Integer.toString(tt));
                generatetable(tt);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //generatetable(10);
    }
}
