package com.example.diksh.cbalaram;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button btnadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd=findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),Main2Activity.class);

                //Schedule a task that will run 5 minutes from now and start by app
                PendingIntent pi=PendingIntent.getActivity(getBaseContext(),12345,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                 // only one alaram
                //alarmManager.set(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime()+6000,pi);




                //for multiple alarams
                //setRepeating for exact time
                //alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime()+6000,6000,pi);

                //for non strict time
                alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,SystemClock.elapsedRealtime()+600000,10000,pi);








                // x, x+5mins.  (x+5)5
                //current tme+the time delay for scheduling the alaram
                //system.currentTimeMillis();
                //Intent i2=new Intent(getBaseContext)(,MainAcitivity.class);

                //PendingIntent pi2=PendingIntent.getActivity(getBaseContext(),12345,i2);

            }
        });
    }
}
