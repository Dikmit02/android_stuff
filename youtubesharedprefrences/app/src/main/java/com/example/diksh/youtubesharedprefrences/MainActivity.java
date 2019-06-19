package com.example.diksh.youtubesharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     EditText mNameEt,mAgeEt;
     Button mSaveBtn,mInfobtn;
     Switch mSwitch;
     TextView mINfoTv;

     //instance of sharedprefences
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEt=findViewById(R.id.nameET);
        mAgeEt=findViewById(R.id.ageET);
        mSaveBtn=findViewById(R.id.savebtn);
        mInfobtn=findViewById(R.id.showbtn);
        mSwitch =findViewById(R.id.switchh);
        mINfoTv=findViewById(R.id.infoTV);

        //sharedprefrences (nmae,Mode)
        sharedPreferences=getSharedPreferences("SP_NAME",MODE_PRIVATE);


        //handle save button click:input data and save in shared prefrenecs
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=mNameEt.getText().toString();
                int age=Integer.parseInt(mAgeEt.getText().toString().trim());
                boolean experience=mSwitch.isChecked();
                //if switch is check then true else false


                //edit shredprefrences (to put data)
                SharedPreferences.Editor editor= sharedPreferences.edit();

                //putdata in sharedprefrences
                editor.putString("NAME",name);
                editor.putInt("AGE",age);
                editor.putBoolean("EXPERIENCD",experience);

                //apply changes to shared prefrences
                editor.apply();


            }
        });
        // handel show info button click:get info from shared prefrences and show in textview

        mInfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=sharedPreferences.getString("NAME","");
                int age=sharedPreferences.getInt("AGE",0);
                boolean experience=sharedPreferences.getBoolean("EXPERIENCD",false);
                mINfoTv.setText("NAME"+name
                        +"\nAGE"+age
                +"\nEXPERIENCED"+experience);

            }
        });





    }
}
