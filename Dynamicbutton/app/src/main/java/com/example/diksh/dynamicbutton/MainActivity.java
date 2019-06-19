package com.example.diksh.dynamicbutton;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btn1;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)findViewById(R.id.bnt1);



        btn1.setOnClickListener(new View.OnClickListener() {
            int i=0;


            @Override
            public void onClick(View v) {

               Log.e("vhbhj","vhgvhbj");

                Button secbtn=new Button(MainActivity.this);
              // Changing only to button 1
              /*  secbtn.setLayoutParams(new ConstraintLayout.LayoutParams(

                        ConstraintLayout.LayoutParams.WRAP_CONTENT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                ));*/



              //Defining the LAyout parameters
                layout=(LinearLayout)findViewById(R.id.lyutid);
                LinearLayout.LayoutParams myparametres=new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT


                        );
                secbtn.setText("I'm a "+(++i)+"Button");
                secbtn.setId(i);
                layout.addView(secbtn,myparametres);


            }
        });

    }
}
