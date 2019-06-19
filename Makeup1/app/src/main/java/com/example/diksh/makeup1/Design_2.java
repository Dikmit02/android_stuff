package com.example.diksh.makeup1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Design_2 extends AppCompatActivity {

    Button btn,Cambtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_2);



       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn=(Button)findViewById(R.id.button);
                Cambtn=(Button)findViewById(R.id.cambtn);   Toast.makeText(Design_2.this, "Hii i am image btn", Toast.LENGTH_SHORT).show();
            }
        });
        Cambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Design_2.this, "Add image", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
